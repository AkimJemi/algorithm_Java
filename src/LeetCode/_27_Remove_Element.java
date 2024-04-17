package LeetCode;

public class _27_Remove_Element {
    public static void main(String[] args) {
        System.out.println(new Solutio27().removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }
}

class Solutio27 {
    public int removeElement(int[] nums, int val) {
        int length = 0;
        for (int num : nums) {
            if (num != val) {
                nums[length++] = num;
            }
        }
        return length;
    }
}