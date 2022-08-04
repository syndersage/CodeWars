package kyu6.Decode_the_Morse_code;

import java.util.Arrays;

public class MorseCodeDecoder {
    public static void main(String[] args) {
        System.out.println(decode(" . "));
    }
    public static class MorseCode {
        public static char get(String code) {
            return 'A';
        }
    }
    public static String decode(String morseCode) {
        String[] words = morseCode.trim().split(" {3}");
        String[] letters;
        StringBuilder decodedCode = new StringBuilder();
        for (String word:
             words) {
            System.out.println(word);
            letters = word.split(" ");
            System.out.println(letters.length);
            for (String letter:
                 letters) {
                decodedCode.append(MorseCode.get(letter));
            }
            decodedCode.append(' ');
        }
        return decodedCode.toString().trim();
    }
}
