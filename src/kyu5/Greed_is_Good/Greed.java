package kyu5.Greed_is_Good;

import java.util.Arrays;

public class Greed{
    public static void main(String[] args) {
        System.out.println(greedy(new int[] {5,1,3,4,1}));
    }
    public static int greedy(int[] dice){
        int[] sidesNumber = new int[6];
        for (int roll:
             dice) {
            sidesNumber[roll - 1]++;
        }
        int result = 0;
        result += sidesNumber[0] / 3 * 1000 + sidesNumber[0] % 3 * 100;
        result += sidesNumber[4] / 3 * 500 + sidesNumber[4] % 3 * 50;
        for (int i = 1; i <= 5; i++) {
            if (i != 4) result += sidesNumber[i] / 3 * 100 * (i + 1);
        }
        return result;
    }
}