import java.util.Arrays;

// time complexity: nlogn, n = max length of (a or b)
public class CheckAnagram {

    public static boolean check(char[] s1, char[] s2) {
        int num1 = s1.length;
        int num2 = s2.length;

        if (num1 != num2) {
            return false;
        }

        Arrays.sort(s1);
        Arrays.sort(s2);

        for (int i = 0; i <= num1 - 1; i++) {
            if (s1[i] != s2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagram(String a, String b, int x) {
        char[] s1 = a.toCharArray();
        char[] s2 = b.toCharArray();

        if (x != 0) {
            for (int i = 0; i < s1.length; i++) {
                s1[i] = (char) (s1[i] + x);
            }
        }

        if (check(s1, s2) == true)
            return true;

        if (x != 0) {
            for (int i = 0; i < s2.length; i++) {
                s2[i] = (char) (s2[i] + x);
            }
        }

        return check(s1, s2) == true;
    }

    public static void main(String[] args) {
        String a = "sdsd";
        String b = "ssdd";
        System.out.println(isAnagram(a, b, 1));
    }
}