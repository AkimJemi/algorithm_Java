import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _34_Find_First_and_Last_Position_of_Element_in_Sorted_Array {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution34().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }
}

class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        return new int[]{list.indexOf(target), list.lastIndexOf(target)};
    }
}