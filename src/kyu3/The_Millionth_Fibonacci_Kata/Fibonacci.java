package kyu3.The_Millionth_Fibonacci_Kata;

import java.math.BigInteger;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fib(BigInteger.valueOf(-1000000)));
    }

    public static BigInteger fib(BigInteger n) {
        BigInteger result = fastDoublingFib(n.abs());
        return n.mod(BigInteger.TWO).equals(BigInteger.ZERO) & n.compareTo(BigInteger.ZERO) < 0 ? result.negate() : result;
    }

    public static BigInteger fastDoublingFib(BigInteger n) {
        if (n.equals(BigInteger.ZERO)) return BigInteger.ZERO;
        if (n.equals(BigInteger.ONE) | n.equals(BigInteger.TWO)) return BigInteger.ONE;
        BigInteger a, b;
        if (n.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
            a = fastDoublingFib(n.divide(BigInteger.TWO));
            b = fastDoublingFib(n.divide(BigInteger.TWO).add(BigInteger.ONE));
            return  (a.multiply(b).multiply(BigInteger.TWO)).subtract(a.pow(2));
        } else {
            a = fastDoublingFib(n.subtract(BigInteger.ONE).divide(BigInteger.TWO));
            b = fastDoublingFib(n.subtract(BigInteger.ONE).divide(BigInteger.TWO).add(BigInteger.ONE));
            return  (a.pow(2)).add(b.pow(2));
        }
    }
}
