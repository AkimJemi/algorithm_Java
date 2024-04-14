import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _26_Remove_Duplicates_from_Sorted_Array {
    public static void main(String[] args) {
        System.out.println(new Solution26().removeDuplicates(new int[]{1, 1, 2}));

    }
}

class Solution26 {
    public int removeDuplicates(int[] nums) {
        int[] expectedNums = Arrays.stream(nums).distinct().toArray();
        for (int i = 0; i < nums.length; i++) {
            if (i >= expectedNums.length)
                break;
            nums[i] = expectedNums[i];
        }
        return expectedNums.length;
    }
}