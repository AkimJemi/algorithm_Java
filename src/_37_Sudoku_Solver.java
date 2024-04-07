import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _37_Sudoku_Solver {
    public static void main(String[] args) {
        String[][] strArray = new String[][]{{".", ".", "9", "7", "4", "8", ".", ".", "."}, {"7", ".", ".", ".", ".", ".", ".", ".", "."}, {".", "2", ".", "1", ".", "9", ".", ".", "."}, {".", ".", "7", ".", ".", ".", "2", "4", "."}, {".", "6", "4", ".", "1", ".", "5", "9", "."}, {".", "9", "8", ".", ".", ".", "3", ".", "."}, {".", ".", ".", "8", ".", "3", ".", "2", "."}, {".", ".", ".", ".", ".", ".", ".", ".", "6"}, {".", ".", ".", "2", "7", "5", "9", ".", "."}};
        char[][] twoDimensionalArray = Arrays.stream(strArray).map(a -> {
                    char[] chaArray = new char[9];
                    for (int i = 0; i < a.length; i++) {
                        chaArray[i] = a[i].charAt(0);
                    }
                    return chaArray;
                })
                .toArray(char[][]::new);
        new Solution37().solveSudoku(twoDimensionalArray);
    }
}

class Solution37 {
    public void solveSudoku(char[][] board) {
        List<Character> charNumList = new ArrayList<>(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9', '.'));
        List<List<Character>> charList = IntStream.range(0, board.length).mapToObj(row -> IntStream.range(0, board.length).mapToObj(colum -> board[row][colum]).collect(Collectors.toList())).collect(Collectors.toList());
        while (true) {
            List<List<Character>> columnList = new ArrayList<>();
            List<List<Character>> rowList = new ArrayList<>();
            List<List<Character>> subBoxList = new ArrayList<>();
            List<Integer> matchSizeList = new ArrayList<>();
            for (int i = 0; i < 9; i++) {
                List<Character> charSubBoxList = new ArrayList<>();
                int columIndex = i;
                columnList.add(charList.stream().map(a -> a.get(columIndex)).collect(Collectors.toList()));
                int rowBox = (i / 3) * 3;
                int columnBox = (i % 3) * 3;
                for (int sub = 1; sub <= 9; sub++) {
                    Character character = charList.get(rowBox).get((columnBox + ((sub - 1) % 3)));
                    charSubBoxList.add(character);
                    if (sub % 3 == 0) {
                        rowBox++;
                    }
                }
                rowList.add(charList.get(i).stream().collect(Collectors.toList()));
                subBoxList.add(charSubBoxList);
            }
            for (int row = 0; row < 9; row++) {
                List<Character> rowCulList = rowList.get(row);
                for (int column = 0; column < 9; column++) {
                    Character target = charList.get(row).get(column);
                    if (Character.isDigit(target)) {
                        continue;
                    }
                    List<Character> columnCulList = columnList.get(column);
                    List<Character> subCulList = subBoxList.get((column / 3) + ((row / 3) * 3));
                    List<Character> collectList = new ArrayList<>();
                    collectList.addAll(rowCulList);
                    collectList.addAll(columnCulList);
                    collectList.addAll(subCulList);
                    List<Character> notMatchList = charNumList.stream().filter(old -> collectList.stream().noneMatch(Predicate.isEqual(old))).collect(Collectors.toList());
                    if (notMatchList.size() == 1) {
                        charList.get(row).set(column, notMatchList.get(0));
                    }
                    matchSizeList.add(notMatchList.size());
                }
            }
            Optional<Integer> check = matchSizeList.stream().reduce(Integer::max);
            if (!check.isPresent()) {
                break;
            }
            System.out.println("---------------------");
            System.out.println(charList);
        }
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                board[row][column] = charList.get(row).get(column);
            }
        }
    }
}