package Study;

import java.util.ArrayList;
import java.util.List;

public class Backtracking {
    public static void main(String[] args) {
        new BacktrackingMethod();
    }
}
class BacktrackingMethod {
    BacktrackingMethod() {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        int[] array = {1, 2, 3, 4, 4};
        int start = 0;
        backtrack(list, tmp, array, start);
        List<List<Integer>> copyList = new ArrayList<>();
        copyList = new ArrayList<>(list);
        list = new ArrayList<>();
        tmp = new ArrayList<>();
        backtrack1(list, tmp, array, start);
    }

    private void backtrack(List<List<Integer>> listOfList, List<Integer> tmpList, int[] array, int start) {
        listOfList.add(new ArrayList<>(tmpList));
        for (int i = start; i < array.length; i++) {
            tmpList.add(array[i]);
            backtrack(listOfList, tmpList, array, i + 1);
            tmpList.remove(tmpList.size() - 1);
        }
    }

    private void backtrack1(List<List<Integer>> listOfList, List<Integer> tmpList, int[] array, int start) {
        listOfList.add(new ArrayList<>(tmpList));
        for (int i = start; i < array.length; i++) {
            if (i > start && array[i] == array[i - 1]) continue;
            tmpList.add(array[i]);
            backtrack(listOfList, tmpList, array, i + 1);
            tmpList.remove(tmpList.size() - 1);
        }
    }
}
