package kyu4.All_Balanced_Parentheses;

import java.util.*;

public class BalancedParens {
    public static void main(String[] args) {
        System.out.println(balancedParens(4));
    }

    public static final List<String> combinations = Collections.synchronizedList(new ArrayList<>());

    public static List<String> balancedParens (int n) {
        System.out.println(n);
        if (n == 0) return new ArrayList<>(List.of(""));
        else if (n == 1) return new ArrayList<>(List.of("()"));
        addParen(n, n, "");
        combinations.removeIf(str -> str.length() != n * 2);
        return combinations;
    }

    public static void addParen(int left, int right, String parens) {
        System.out.println(left + ":" + right);
        if (left + right == 0) synchronized (combinations) {
            combinations.add(parens);
        } else {
            if (left != 0 & right >= left) addParen(left - 1, right, parens + '(');
            if (right != 0) addParen(left, right - 1, parens + ')');
        }
    }
}
