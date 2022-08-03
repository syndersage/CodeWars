package kyu6.stop_gninnipS_My_sdroW;

import java.util.Arrays;

public class SpinWords {
    public static void main(String[] args) {
        System.out.println(spinWords("Hello guys hello 12345"));
    }

    public static String spinWords(String sentence) {
        int numOfSpaces = 0;
        for (int i = 0; i < sentence.length(); i++) { if (sentence.charAt(i) == ' ') numOfSpaces++; }
        int[] spaces = new int[numOfSpaces + 2];
        spaces[0] = 0;
        spaces[spaces.length - 1] = sentence.length();
        for (int i = 0, arrayIndex = 1; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' ') spaces[arrayIndex++] = i;
        }
        StringBuilder outStr = new StringBuilder();
        System.out.println(Arrays.toString(spaces));
        for (int i = 0; i < spaces.length - 1; i++) {
            if (spaces[i + 1] - spaces[i] + (i == 0 ? 0 : -1) >= 5) outStr.append(new StringBuilder(sentence.substring(i == 0 ? spaces[i] : spaces[i] + 1, spaces[i + 1]) + (i == 0 ? "" : " ")).reverse());
            else outStr.append(sentence, spaces[i], spaces[i + 1]);
        }
        return outStr.toString();
    }
}