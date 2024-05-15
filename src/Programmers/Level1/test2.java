package Programmers.Level1;

import java.util.Arrays;
import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
//        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
//        System.out.println("test");
//        Scanner sc = new Scanner(System.in);
//        String[] strArray = sc.next().split(" ");
//        System.out.println(Integer.valueOf(strArray[0]) + Integer.valueOf(strArray[1]));
//        System.out.println(Arrays.toString(args));
        System.out.println((double) 1 / 8);
        System.out.println((double) 3 / 7);
        System.out.println((double) 1 / 2);
        System.out.println((double) 0 / 1);
    }

    static int lengthOfLastWord(String s) {
        String[] result = s.trim().split(" ");
        return result[result.length - 1].length();
    }
}
