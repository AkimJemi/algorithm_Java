package DesignPattern.StrategyPattern;

public class SimpleSumStrategy implements SumStrategy {
    @Override
    public int get(int N) {
        return (N + 1) * N / 2;
    }
}
