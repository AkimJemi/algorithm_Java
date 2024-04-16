public class _38_Count_and_Say {
    public static void main(String[] args) {
        System.out.println(new Solution38().countAndSay(4));

    }
}

class Solution38 {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String nums = "1";
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                continue;
            }
            int count = 0;
            String str = String.valueOf(nums.charAt(0));
            for (String num : nums.split("")) {
                if (num.equals(str)) {
                    count++;
                } else {
                    str = num;
                    nums += count + str;
                }
            }
        }
        return nums;
    }
}

