package kyu4.Decode_the_Morse_code_advanced;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MorseCodeDecoder {
    public static void main(String[] args) {
        System.out.println(decodeBits("11111100111111"));
    }

    public static String decodeBits(String bits) {
        System.out.println(bits);
        bits = removeZeroes(bits);
        int unitLing = findUnitLong(bits);
        System.out.println(unitLing);
        String wordsPattern = "0".repeat(7 * unitLing);
        String lettersPattern = "0".repeat(3 * unitLing);
        String dashesAndDotsPattern = "0".repeat(unitLing);
        String dashPattern = "1".repeat(3 * unitLing);
        String dotPattern ="1".repeat(unitLing);
        String[] words = bits.trim().split(wordsPattern);
        String[] letters;
        String[] dashesAndDots;
        StringBuilder outStr = new StringBuilder();
        for (String word:
             words) {
            letters = word.split(lettersPattern);
            for (String letter:
                 letters) {
                dashesAndDots = letter.split(dashesAndDotsPattern);
                for (String dashOrDot:
                     dashesAndDots) {
                    if (dashOrDot.equals(dotPattern)) outStr.append(".");
                    else if (dashOrDot.equals(dashPattern)) outStr.append("-");
                }
                outStr.append(" ");
            }
            outStr.deleteCharAt(outStr.length() - 1);
            outStr.append("   ");
        }
        return outStr.toString().trim();
    }

    public static int findUnitLong(String decodeBits) {
        int unitSize = 1, tempSize = 1;
        if (!decodeBits.isEmpty()) {
            char previous = decodeBits.charAt(0);
            int i = 1;
            for (; i < decodeBits.length(); i++) {
                if (decodeBits.charAt(i) == previous) {
                    unitSize++;
                }
                else {
                    previous = decodeBits.charAt(i++);
                    break;
                }
            }
            for (; i < decodeBits.length(); i++) {
                if (decodeBits.charAt(i) == previous) {
                    tempSize++;
                }
                else {
                    if (tempSize == unitSize * 3) return unitSize;
                    if (tempSize * 3 == unitSize) return tempSize;
                    tempSize = 0;
                }
            }
        }
        return unitSize;
    }

    public static String removeZeroes(String bits) {
        StringBuilder str = new StringBuilder(bits);
        while (!str.isEmpty() && str.charAt(0) == '0') str.deleteCharAt(0);
        str.reverse();
        while (!str.isEmpty() && str.charAt(0) == '0') str.deleteCharAt(0);
        return str.reverse().toString();
    }
}