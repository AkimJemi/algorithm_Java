package LeetCode;

public class _342_Power_of_Four {
    public static void main(String[] args) {
//        System.out.println(new Solution342().isPowerOfFour(16));
//        System.out.println(new Solution342().isPowerOfFour(5));
//        System.out.println(new Solution342().isPowerOfFour(-2147483648));
        System.out.println(new Solution342().isPowerOfFour(-64));
        System.out.println(new Solution342().isPowerOfFour(-16));
    }
}

class Solution342 {
    public boolean isPowerOfFour(int n) {
        if (n < 0) return false;
        while (n > 1) {
            double floor = Math.floor(n / 4);
            if (floor != (double) n / 4) {
                return false;
            }
            n = (int) floor;
        }
        return n == 1 ? true : false;
    }
}