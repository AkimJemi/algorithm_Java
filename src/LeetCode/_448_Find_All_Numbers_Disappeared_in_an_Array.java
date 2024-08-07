package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _448_Find_All_Numbers_Disappeared_in_an_Array {
    public static void main(String[] args) {
        System.out.println(new Solution448().findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        System.out.println(new Solution448().findDisappearedNumbers(new int[]{1, 1}));
        System.out.println(new Solution448().findDisappearedNumbers(new int[]{1, 1, 2, 2}));
    }
}


class Solution448 {
    // mycode
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] array = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            array[nums[i]]++;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < array.length; i++) {
            if (array[i] == 0) {
                list.add(i);
            }
        }
        return list;
    }

    // ChatGPT →　「mycode」よりRuntimeは以前よりも遅くなったが、Memoryの使用量は多少改善された。ただし、その差は大きくない
    public List<Integer> findDisappearedNumbers3(int[] nums) {
        // Mark the presence of numbers
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1; // Use the value as index
            if (nums[index] > 0) {
                nums[index] = -nums[index]; // Negate the value at that index
            }
        }

        // Collect the missing numbers
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1); // Index i+1 is missing
            }
        }
        return result;
    }

    // others code
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        return new MyList(nums);
    }

    private static class MyList extends ArrayList<Integer> {
        int[] nums;

        public MyList(int[] nums) {
            this.nums = nums;
        }

        public int size() {
            if (nums != null) {
                method();
            }
            return super.size();
        }

        public void method() {
            int[] nums = this.nums;
            Set<Integer> set = new HashSet<>(nums.length + 3, 3f);

            for (int num : nums) {
                set.add(num);
            }
            for (int i = 1; i <= nums.length; i++) {

                if (!set.contains(i)) {
                    super.add(i);
                }
            }
            this.nums = null;
        }
    }
    // Time Limit Exceeded3
//    public List<Integer> findDisappearedNumbers(int[] nums) {
//        List<Integer> list = IntStream.rangeClosed(1, nums.length).boxed().collect(Collectors.toList());
//        List<Integer> list2 = Arrays.stream(nums).boxed().collect(Collectors.toList());
//        list.removeAll(list2);
//        return list;
//    }
    // Time Limit Exceeded2
//    public List<Integer> findDisappearedNumbers(int[] nums) {
//        List<Integer> list = IntStream.rangeClosed(1, nums.length).boxed().collect(Collectors.toList());
//        for (int i = 0; i < nums.length; i++) {
//            list.remove(Integer.valueOf(nums[i]));
//        }
//        return list;
//    }
    // Time Limit Exceeded
//    public List<Integer> findDisappearedNumbers(int[] nums) {
//        int max = Arrays.stream(nums).max().getAsInt();
//        if (max < 2) return nums[0] == 1 ? Arrays.asList(2) : Arrays.asList(1);
//        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
//        List<Integer> list2 = IntStream.rangeClosed(1, nums.length).boxed().collect(Collectors.toList());
//        List<Integer> onlyInList = list2.stream()
//                .filter(e -> !list.contains(e))
//                .collect(Collectors.toList());
//        return onlyInList;
//    }
}