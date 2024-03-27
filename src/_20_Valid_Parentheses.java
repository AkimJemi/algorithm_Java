import java.util.HashMap;
import java.util.Map;

public class _20_Valid_Parentheses {
    public static void main(String[] args) {
        System.out.println(new Solution20().isValid("(([]){})"));
    }
}

class Solution20 {

    public boolean isValid(String s) {
        String[] strArray = s.split("");
        Map<String, String> mapOpen = new HashMap<>();
        mapOpen.put("(", ")");
        mapOpen.put("{", "}");
        mapOpen.put("[", "]");
        Map<String, String> mapClose = new HashMap<>();
        mapClose.put(")", "(");
        mapClose.put("}", "{");
        mapClose.put("]", "[");
        if (s.length() <= 1 || mapClose.containsKey(strArray[0]) || mapOpen.containsKey(strArray[s.length() - 1]) || s.length() % 2 != 0) {
            return false;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (mapOpen.containsKey(strArray[i])) {
                if (!(mapOpen.get(strArray[i]).equals(strArray[i + 1]) || mapOpen.get(strArray[i]).equals(strArray[s.length() - i - 1]))) {
                    return false;
                }
            } else if (mapClose.containsKey(strArray[i])) {
                if (!(mapClose.get(strArray[i]).equals(strArray[i - 1]))) {
                    return false;
                }
            }
        }
        return true;
    }
}