import java.util.Arrays;

public class Two_Sum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution1().twoSum(new int[]{3, 2, 4}, 6)));

    }
}
class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}