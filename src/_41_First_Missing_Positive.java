import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _41_First_Missing_Positive {

    public static void main(String[] args) {
        System.out.println(new Solution41().firstMissingPositive(new int[]{0}));
    }
}

class Solution41 {
    public int firstMissingPositive(int[] nums) {
        List<Integer> list = Arrays.stream(nums).filter(a -> a > 0).sorted().distinct().boxed().collect(Collectors.toList());
        if (list.size() == 0) {
            return 1;
        }
        if (list.get(0) != 1) {
            return 1;
        }
        int preNum = 0;
        for (Integer num : list) {
            if (++preNum != num) {
                return preNum;
            }
        }
        return list.get(list.size() - 1) + 1;
    }
}