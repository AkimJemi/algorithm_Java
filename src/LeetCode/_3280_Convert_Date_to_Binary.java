package LeetCode;

public class _3280_Convert_Date_to_Binary {
    public static void main(String[] args) {
        System.out.println(new Solution_3280_Convert_Date_to_Binary().convertDateToBinary("2080-02-29"));
    }
}

class Solution_3280_Convert_Date_to_Binary {
    public String convertDateToBinary(String date) {
        String[] strArray = date.split("-");
        return Integer.toBinaryString(Integer.valueOf(strArray[0])) + "-" + Integer.toBinaryString(Integer.valueOf(strArray[1])) + "-" +
                Integer.toBinaryString(Integer.valueOf(strArray[2]));
    }

    // others code
    public String convertDateToBinary2(String date) {

        String y = date.substring(0, 4);
        String m = date.substring(5, 7);
        String d = date.substring(8, 10);

        StringBuilder sb = new StringBuilder();

        sb.append(Integer.toBinaryString(Integer.parseInt(y)));
        sb.append("-");
        sb.append(Integer.toBinaryString(Integer.parseInt(m)));
        sb.append("-");
        sb.append(Integer.toBinaryString(Integer.parseInt(d)));

        return sb.toString();

    }
}