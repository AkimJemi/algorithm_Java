public class _2_String_To_Integer {
    public static void main(String[] args) {
        System.out.println(new Solution2().myAtoi("+-12"));
    }
}

class Solution2 {
    public int myAtoi(String s) {
        String result = "";
        boolean check = true;
        boolean minus = false;
        boolean plus = false;
        int notDouble = 0;
        try {
            for (Character cha : s.toCharArray()) {
                if (Character.isDigit(cha)) {
                    if (notDouble == 2) {
                        return 0;
                    }
                    check = false;
                    result += cha;
                } else {
                    if (notDouble == 2) {
                        return minus ? Integer.valueOf("-" + result) : Integer.valueOf(result);
                    }
                    if (plus || minus) {
                        return result.length() == 0 ? 0 : minus ? Integer.valueOf("-" + result) : Integer.valueOf(result);
                    }
                    if (String.valueOf(cha).equals(" ") && check) {
                        continue;
                    }
                    if (String.valueOf(cha).equals("-") && check) {
                        notDouble++;
                        minus = true;
                        continue;
                    }
                    if (String.valueOf(cha).equals("+") && check) {
                        notDouble++;
                        plus = true;
                        continue;
                    }
                    return result.length() == 0 ? 0 : minus ? Integer.valueOf("-" + result) : Integer.valueOf(result);
                }
            }
            return result.length() == 0 ? 0 : minus ? Integer.valueOf("-" + result) : Integer.valueOf(result);
        } catch (Exception e) {
            return minus ? -Integer.MAX_VALUE - 1 : Integer.MAX_VALUE;
        }
    }
}
