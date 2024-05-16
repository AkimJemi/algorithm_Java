package Programmers.Level1;

import java.util.Arrays;
import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        System.out.println((int) 'Z');
        System.out.println((int) 'a');
        System.out.println((int) 's');
        System.out.println((int) 'S');
    }

    static int lengthOfLastWord(String s) {
        String[] result = s.trim().split(" ");
        return result[result.length - 1].length();
    }
}
