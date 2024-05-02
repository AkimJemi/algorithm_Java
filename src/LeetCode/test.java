package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
//        void001();
//        void002();
        int x = 10;
        int y = 15;
        void003(x, y);
        System.out.println(x);
        System.out.println(y);
    }

    private static void void003(int x, int y) {
        x += 5;
        y += 10;
        System.out.println(x);
        System.out.println(y);
    }

    private static void void002() {
        String test1 = "test1";
        String test2 = test1 = "test2";
        System.out.println(test1);
        System.out.println(test2);
    }


    private static void void001() {
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
