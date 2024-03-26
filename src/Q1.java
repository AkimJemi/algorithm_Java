import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class Q1 {
    public static void main(String[] args) {
        System.out.println(solutionWithSet());
    }

    // 7037
    public static int solution() {
        return (int) IntStream.rangeClosed(0, 30).boxed().map(a -> {
                    List<Integer> list = new ArrayList<>();
                    for (int i = 0; i <= 40; i++) {
                        for (int j = 0; j <= 30; j++) {
                            list.add(205 * a + 82 * i + 30 * j);
                        }
                    }
                    return list.stream().distinct().flatMapToInt(IntStream::of).toArray();
                }
        ).flatMapToInt(IntStream::of).distinct().count();
    }

    public static int solutionWithSet() {
        Set<Integer> set = new HashSet<>();
        for (int a = 0; a <= 30; a++) {
            for (int i = 0; i <= 40; i++) {
                for (int j = 0; j <= 30; j++) {
                    if (a + i + j != 0) {
                        set.add(205 * a + 82 * i + 30 * j);
                    }
                }
            }
        }
        return set.size();
    }
}
