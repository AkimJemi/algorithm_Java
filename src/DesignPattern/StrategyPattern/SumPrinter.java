package DesignPattern.StrategyPattern;

public class SumPrinter {
    void print(SumStrategy sumStrategy, int N) {
        System.out.printf("The %s of 1 -  %d : ", sumStrategy.getClass().getName().split("\\.")[2], N);
        System.out.println(sumStrategy.get(N));
    }
}
