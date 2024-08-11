package DesignPattern.StrategyPattern;

public class GaussSumStrategy implements SumStrategy {
    @Override
    public int get(int N) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += i;
        }
        return sum;
    }
}
