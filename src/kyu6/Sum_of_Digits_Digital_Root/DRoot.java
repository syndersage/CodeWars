package kyu6.Sum_of_Digits_Digital_Root;

import java.util.Arrays;

public class DRoot {
    public static void main(String[] args) {
        System.out.println(digital_root(154));
    }
    public static int digital_root(int n) {
        while (n >= 10) {
            int tempInt = 0;
            for (String digit:
                    String.valueOf(n).split("")) {
                tempInt += Integer.parseInt(digit);
            }
            n = tempInt;
        }
        return n;
    }
}
