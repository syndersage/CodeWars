package kyu5.Whats_a_Perfect_Power_anyway;

import java.math.BigInteger;
import java.util.*;

public class PerfectPower {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(isPerfectPower(343)));
    }

    public static int[] isPerfectPower(int n) {
        int maxDegree = (int) (Math.log(n) / Math.log(2));
        List<Integer> degrees = new ArrayList<>();
        for (int i = 2; i <= maxDegree; i++)
            if (isPrimeFermat(i, 5)) degrees.add(i);
        int base, minBase, maxBase;
        for (Integer degree : degrees) {
            minBase = 2;
            maxBase = (int) Math.sqrt(n);
            do {
                base = (maxBase + minBase) / 2;
                //System.out.println(base + " " + degree);
                if (Math.pow(base, degree) == n) return new int[] {base, degree};
                if (Math.pow(base + 1, degree) == n) return new int[] {base + 1, degree};
                else if (Math.pow(base, degree) > n) {
                    if (maxBase == base) break;
                    maxBase = base;
                } else {
                    if (minBase == base) break;
                    minBase = base;
                }
            } while (true);
        }
        return null;
    }

    public static boolean isPrimeFermat(int n, int iterations) {
        if (n == 2 || n == 3) return true;
        if ((n % 2) == 0) return false;
        BigInteger a;
        BigInteger bigN = BigInteger.valueOf(n);
        BigInteger bigNm1 = BigInteger.valueOf(n - 1);
        BigInteger one = BigInteger.ONE;
        for (int i = 0; i < iterations; i++) {
            a = BigInteger.valueOf(3 + (int) (Math.random() * (n - 3)));
            if (!a.modPow(bigNm1, bigN).equals(one)) return false;
        }
        return true;
    }
}