import java.util.ArrayList;
import java.util.List;

public class _22_Generate_Parentheses {
    public static void main(String[] args) {
        System.out.println(new Solution22().generateParenthesis(3));
    }
}

class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n > 1) {
            list.add("(".repeat(n) + ")".repeat(n));
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < n; i++) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("(".repeat(n - i));
            for (int j = 1; j < n; j++) {
                stringBuilder.append(")".repeat(n - j));
            }
            list.add(stringBuilder.toString());
        }
        list.add("()".repeat(n));
        return list;
    }
}