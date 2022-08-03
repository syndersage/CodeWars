package kyu6.Tribonacci_sequence;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Xbonacci {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(tribonacci(new double[] {1, 1, 1}, 10)));
    }
    public static double[] tribonacci(double[] s, int n) {
        if (n <= 3) return Arrays.copyOf(s, n);
        s = Arrays.copyOf(s, n);
        for (int i = 3; i < s.length ; i++) {
            s[i] = s[i - 1] + s[i - 2] + s[i - 3];
        }
        return s;
    }
}
