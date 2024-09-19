package LeetCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class _179_Largest_Number {
    public static void main(String[] args) {
        String a = "380";
        String b = "39000000";
//        System.out.println(new Solution_179_Largest_Number().largestNumber(new int[]{10, 2, 3, 11, 42}));
        System.out.println(new Solution_179_Largest_Number().largestNumber(new int[]{34, 3, 341, 301, 3014, 5, 9, 3}));
    }
}

class Solution_179_Largest_Number {
    // ChatGPT
    public String largestNumber(int[] nums) {
        String str = Arrays.stream(nums).mapToObj(String::valueOf).sorted((a, b) -> (b + a).compareTo(a + b)).collect(Collectors.joining());
        if (str.charAt(0) == '0') {
            return "0";
        }
        return str;
    }

    // Mycode
//    public String largestNumber1(int[] nums) {
//        return Arrays.stream(nums).mapToObj(String::valueOf).sorted((a, b) -> {
//            if (a.length() == b.length()) {
//                return b.compareTo(a) + b.length();
//            }
//            int aL = a.length();
//            int bL = b.length();
//            String longLength = Math.max(aL, bL) == aL ? a : b;
//            String shortLength = Math.max(aL, bL) == aL ? b : a;
////            if ()
//            return -1;
//        }).collect(Collectors.joining());
//    }


    // others code
    public void merge(int[] arr, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int[] temp = new int[high - low + 1];
        int k = 0;
        while (i <= mid && j <= high) {
            long n = 10, m = 10;
            while (arr[i] >= n) {
                n *= 10;
            }
            while (arr[j] >= m) {
                m *= 10;
            }
            long l = arr[i] * m + arr[j];
            long r = arr[j] * n + arr[i];
            if (l > r) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];

        }
        while (j <= high) {

            temp[k++] = arr[j++];
        }
        k = 0;
        int m = low;
        while (m <= high) {
            arr[m++] = temp[k++];
        }
    }

    public void mergesort(int[] arr, int low, int high) {
        if (low == high) {
            return;
        }
        int mid = low + (high - low) / 2;
        mergesort(arr, low, mid);
        mergesort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    public String largestNumber1(int[] nums) {
        mergesort(nums, 0, nums.length - 1);
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            str.append(String.valueOf(nums[i]));
        }
        return (str.charAt(0) == '0') ? "0" : str.toString();
    }
}