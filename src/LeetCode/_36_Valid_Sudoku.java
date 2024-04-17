package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _36_Valid_Sudoku {

    public static void main(String[] args) {
        String[][] strArray = new String[][]{{"5", "3", ".", ".", "7", ".", ".", ".", "."}, {"6", ".", ".", "1", "9", "5", ".", ".", "."}, {".", "9", "8", ".", ".", ".", ".", "6", "."}, {"8", ".", ".", ".", "6", ".", ".", ".", "3"}, {"4", ".", ".", "8", ".", "3", ".", ".", "1"}, {"7", ".", ".", ".", "2", ".", ".", ".", "6"}, {".", "6", ".", ".", ".", ".", "2", "8", "."}, {".", ".", ".", "4", "1", "9", ".", ".", "5"}, {".", ".", ".", ".", "8", ".", ".", "7", "9"}};
        char[][] twoDimensionalArray = Arrays.stream(strArray).map(a -> {
                    char[] chaArray = new char[9];
                    for (int i = 0; i < a.length; i++) {
                        chaArray[i] = a[i].charAt(0);
                    }
                    return chaArray;
                })
                .toArray(char[][]::new);
        System.out.println(new Solution36().isValidSudoku(twoDimensionalArray));

    }
}

class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        List<List<Character>> charList = IntStream.range(0, board.length).mapToObj(row -> IntStream.range(0, board.length).mapToObj(colum -> board[row][colum]).collect(Collectors.toList())).collect(Collectors.toList());
        for (int row = 0; row < 9; row++) {
            List<Character> charRowList = new ArrayList<>(charList.get(row).stream().filter(ch -> Character.isDigit(ch)).collect(Collectors.toList()));
            if ((charRowList.stream().distinct().count() != charRowList.size())) {
                return false;
            }
            List<Character> charSubBoxList = new ArrayList<>();
            int rowBox = (row / 3) * 3;
            int columnBox = (row % 3) * 3;
            for (int sub = 1; sub <= 9; sub++) {
                Character character = charList.get(rowBox).get((columnBox + ((sub - 1) % 3)));
                if (charSubBoxList.contains(character)) {
                    return false;
                }
                if (Character.isDigit(character)) {
                    charSubBoxList.add(character);
                }
                if (sub % 3 == 0) {
                    rowBox++;
                }
            }
            int columIndex = row;
            List<Character> charColumList = new ArrayList<>(charList.stream().map(a -> a.get(columIndex)).filter(ch -> Character.isDigit(ch)).collect(Collectors.toList()));
            if (charColumList.stream().distinct().count() != charColumList.size()) {
                return false;
            }
        }
        return true;
    }
}