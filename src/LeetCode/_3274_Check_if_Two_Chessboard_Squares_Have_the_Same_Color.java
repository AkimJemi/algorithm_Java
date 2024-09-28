package LeetCode;

public class _3274_Check_if_Two_Chessboard_Squares_Have_the_Same_Color {
    public static void main(String[] args) {
        System.out.println(new Solution_3274_Check_if_Two_Chessboard_Squares_Have_the_Same_Color().checkTwoChessboards("a1", "h3"));

    }
}

class Solution_3274_Check_if_Two_Chessboard_Squares_Have_the_Same_Color {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        int coo1Alp = coordinate1.charAt(0);
        int coo1Num = coordinate1.charAt(1);
        int coo2Alp = coordinate2.charAt(0);
        int coo2Num = coordinate2.charAt(1);
        if ((coo1Alp + coo1Num) % 2 == 0) {
            if ((coo2Alp + coo2Num) % 2 == 0) {
                return true;
            }
            return false;
        } else {
            if ((coo2Alp + coo2Num) % 2 == 0) {
                return false;
            }
            return true;
        }
    }
}