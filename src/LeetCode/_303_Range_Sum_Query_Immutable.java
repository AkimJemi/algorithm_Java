package LeetCode;

public class _303_Range_Sum_Query_Immutable {
    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(0, 2));
        ; // return (-2) + 0 + 3 = 1
        System.out.println(numArray.sumRange(2, 5));
        ; // return 3 + (-5) + 2 + (-1) = -1
        System.out.println(numArray.sumRange(0, 5));
        ; // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
    }
}

// mycode
class NumArray {
    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += nums[i];
        }
        return sum;
    }
}

// others code
class NumArray2 {
    int[] pre;

    public NumArray2(int[] nums) {
        pre = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        int sum = pre[right + 1] - pre[left];
        return sum;
    }
}