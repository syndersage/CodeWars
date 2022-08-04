package kyu5.Perimeter_of_squares_in_a_rectangle;

import java.math.BigInteger;

public class SumFct_slow {
    public static void main(String[] args) {
        System.out.println(perimeter(BigInteger.valueOf(10000)));
    }
    public static BigInteger perimeter(BigInteger n) {
        if (n.intValue() == 0) return new BigInteger("0");
        if (n.intValue() == 1) return new BigInteger("4");
        if (n.intValue() == 2) return new BigInteger("8");
        BigInteger s1 = new BigInteger("0");
        BigInteger s2 = new BigInteger("4");
        BigInteger temp;
        for (int i = 0; i < n.intValue() + 2; i++) {
            temp = s2;
            s2 = s2.add(s1);
            s1 = temp;
            System.out.println(i);
        }
        return s2.add(new BigInteger("-4"));
    }
}
