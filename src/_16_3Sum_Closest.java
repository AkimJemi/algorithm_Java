public class _16_3Sum_Closest {
    public static void main(String[] args) {
        System.out.println(new Solution16().threeSumClosest(new int[]{0, 1, 2}, 0));
    }
}

class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        int distance = Math.abs(nums[0] + nums[1] + nums[2] - target);
        int cloestNum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int n = j + 1; n < nums.length; n++) {
                    int sum3 = nums[i] + nums[j] + nums[n];
                    int cdistance = Math.abs(sum3 - target);
                    if (cdistance < distance) {
                        cloestNum = sum3;
                        distance = cdistance;
                    }
                }
            }
        }
        return cloestNum;
    }
}