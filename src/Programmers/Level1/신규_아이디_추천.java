package Programmers.Level1;

public class 신규_아이디_추천 {
    public static void main(String[] args) {
        System.out.println(new Solution신규_아이디_추천().solution("...!@BaT#*..y.abcdefghijklm"));
        System.out.println(new Solution신규_아이디_추천().solution("z-+.^."));
        System.out.println(new Solution신규_아이디_추천().solution("=.="));
        System.out.println(new Solution신규_아이디_추천().solution("123_.def"));
        System.out.println(new Solution신규_아이디_추천().solution("abcdefghijklmn.p"));
    }
}

class Solution신규_아이디_추천 {
    public String solution(String new_id) {
        new_id = new_id.
                toLowerCase().
                replaceAll("[^a-z0-9-._]", "").
                replaceAll("\\.+", ".").
                replaceAll("^\\.", "").
                replaceAll("\\.$", "");
        if (new_id.length() == 0) {
            new_id = "a";
        }
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15).replaceAll("\\.$", "");
        }
        if (new_id.length() <= 2) {
            new_id = new_id + new_id.substring(new_id.length() - 1).repeat(3 - new_id.length());
        }
        return new_id;
    }
//    public String solution(String new_id) {
//        new_id = new_id.replaceAll("[0-9]", "");
//        StringBuilder stringBuilder = new StringBuilder();
//        String lastStr = null;
//        for (int i = 0; i < new_id.length(); i++) {
//            char cha = new_id.charAt(i);
//            if (cha != '-' || cha != '_' || cha != '-' || cha != '.') {
//                continue;
//            }
//            if (cha == '.' && lastStr.equals(".")) {
//                continue;
//            }
//            lastStr = String.valueOf(cha);
//            stringBuilder.append(cha);
//        }
//        return stringBuilder.toString();
//    }
}