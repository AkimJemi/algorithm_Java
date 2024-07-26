package LeetCode;

public class _278_First_Bad_Version {
    public static void main(String[] args) {
        System.out.println(new Solution278().firstBadVersion(2126753390));

    }
}

class Solution278 extends VersionControl {
    public int firstBadVersion(int n) {
        long i = n;
        long start = 0;
        long end = n;
        while (true) {
            if (isBadVersion((int) i)) {
                end = i;
                i = (i + start) / 2;
            } else {
                if (isBadVersion((int) i + 1)) {
                    return (int) i + 1;
                }
                start = i;
                i = (end + i) / 2;
            }
        }
    }
}

class VersionControl {
    boolean isBadVersion(int version) {
        return version >= 1702766719;
    }
}


