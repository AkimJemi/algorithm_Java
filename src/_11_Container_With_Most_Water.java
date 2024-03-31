import java.util.*;

public class _11_Container_With_Most_Water {
    public static void main(String[] args) {
        System.out.println(new Solution11().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}

class Solution11 {
    public int maxArea(int[] height) {
        int maxValue = 0;
        int beforeIValue = 0;
        for (int i = 0; i < height.length; i++) {
            if (beforeIValue <= height[i]) {
                int beforeJValue = 0;
                for (int j = height.length - 1; j > i; j--) {
                    if (beforeJValue < height[j]) {
                        int width = Math.abs(i - j);
                        int length = height[j] >= height[i] ? height[i] : height[j];
                        int value = width * length;
                        if (maxValue < value) {
                            maxValue = value;
                        }
                    }
                    beforeJValue = height[j];
                }
            }
            beforeIValue = height[i];
        }
        return maxValue;
    }
}