package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        List<String> test1 = new ArrayList<>();
        test1.add("a");
        test1.add("a");
        test1.add("b");
        test1.add("a");
        test1.add("c");
        test1.add("c");
        List<String> test2 = new ArrayList<>();
        test2.add("a");
        test2.add("a");
        test2.add("b");
        System.out.println(test1);
        System.out.println(test1.retainAll(test2));
        System.out.println(test1);

    }
}
