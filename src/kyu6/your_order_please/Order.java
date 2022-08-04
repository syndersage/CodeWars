package kyu6.your_order_please;

import java.util.Arrays;

public class Order {
    public static void main(String[] args) {
        System.out.println(order(""));
    }

    public static String order(String words) {
        if (words.length() == 0) return "";
        String[] splitWords = words.split(" ");
        String tempStr;
        for (int i = splitWords.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (Integer.parseInt(splitWords[j].replaceAll("\\D", "")) > Integer.parseInt(splitWords[j + 1].replaceAll("\\D", ""))) {
                    tempStr = splitWords[j];
                    splitWords[j] = splitWords[j + 1];
                    splitWords[j + 1] = tempStr;
                }
            }
        }
        StringBuilder outStr = new StringBuilder();
        for (String word:
             splitWords) {
            outStr.append(word).append(" ");
        }
        return outStr.deleteCharAt(outStr.length() - 1).toString();
    }
}
