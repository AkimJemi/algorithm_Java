import java.util.*;

public class _20_Valid_Parentheses {
    public static void main(String[] args) {
        System.out.println(new Solution20().isValid("(])"));
    }
}

class Solution20 {

    public boolean isValid(String s) {
        String[] strArray = s.split("");
        Map<String, String> mapOpen = new HashMap<>();
        mapOpen.put("(", ")");
        mapOpen.put("{", "}");
        mapOpen.put("[", "]");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            String str = strArray[i];
            if (mapOpen.containsKey(str)) {
                list.add(str);
                continue;
            } else if (mapOpen.containsValue(str)) {
                if (list.size() > 0) {
                    Optional<String> getValue = mapOpen.keySet().stream().filter(a -> str.equals(mapOpen.get(a))).findFirst();
                    if (getValue.isPresent() && list.get(list.size() - 1).equals(getValue.get())) {
                        list.remove(list.size() - 1);
                        continue;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return list.size() == 0 ? true : false;
    }
}