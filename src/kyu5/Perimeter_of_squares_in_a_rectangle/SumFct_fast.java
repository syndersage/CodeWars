package kyu5.Perimeter_of_squares_in_a_rectangle;

import java.math.BigInteger;

public class SumFct_fast {
    public static void main(String[] args) {
        System.out.println(perimeter(BigInteger.valueOf(4)));
    }
    public static BigInteger perimeter(BigInteger n) {
        if (n.compareTo(BigInteger.ZERO) == 0) return BigInteger.ZERO;
        if (n.compareTo(BigInteger.ONE) == 0) return BigInteger.TWO.add(BigInteger.TWO);
        if (n.compareTo(BigInteger.TWO) == 0) return BigInteger.TWO.add(BigInteger.TWO).multiply(BigInteger.TWO);
        if (n.compareTo(BigInteger.TWO.add(BigInteger.ONE)) == 0) return BigInteger.TWO.add(BigInteger.TWO).multiply(BigInteger.TWO).multiply(BigInteger.TWO);
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.TWO.add(BigInteger.TWO);
        BigInteger temp;
        for (int i = 0; i < n.intValue() + 2; i++) {
            temp = b.add(a);
            a = b;
            b = temp;
            System.out.println(i);
        }
        return b.add(BigInteger.valueOf(-4));
    }
}
