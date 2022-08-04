package kyu5.Valid_Parentheses;

import java.nio.charset.StandardCharsets;

public class Solution {
    public static void main(String[] args) {
        System.out.println(validParentheses("adasdasfa"));
    }

    public static boolean validParentheses(String parens) {
        StringBuilder outStr = new StringBuilder(parens.replaceAll("[^()]", ""));
        for (int i = 0, j = 1; j < outStr.length();) {

            if (outStr.length() % 2 == 1) return false;
            System.out.println(outStr + ". " + i + ":" + j);
            if (outStr.charAt(i) == '(' & outStr.charAt(j) == ')') {
                outStr.delete(i, j + 1);
                i = 0;
                j = 1;
            } else {
                i++;
                j++;
            }
            System.out.println(outStr);
        }
        return outStr.isEmpty();
    }
}
