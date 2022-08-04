package kyu6.Duplicate_Encoder;

import java.util.Locale;

public class DuplicateEncoder {
    public static void main(String[] args) {
        System.out.println(encode("   ()(   "));
    }

    static String encode(String word){
        StringBuilder outWord = new StringBuilder();
        word = word.toLowerCase();
        for (int i = 0; i < word.length(); i++) {
            char symbol = word.charAt(i);
            int counter = 0;
            for (int j = 0; j < word.length(); j++) {
                if (word.charAt(j) == symbol) counter++;
            }
            outWord.append(counter > 1 ? ')' : '(');
        }
        return outWord.toString();
    }
}
