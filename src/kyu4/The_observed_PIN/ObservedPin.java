package kyu4.The_observed_PIN;

import java.util.*;
import java.util.stream.Collectors;

public class ObservedPin {
    public static void main(String[] args) {
        System.out.println(getPINs("11"));
    }
    public static Map<Character, Character[]> adjacent = new HashMap<>() {
        {
            put('0', new Character[] {'8', '0'});
            put('1', new Character[] {'1', '2', '4'});
            put('2', new Character[] {'1', '2', '3', '5'});
            put('3', new Character[] {'2', '3', '6'});
            put('4', new Character[] {'1', '4', '5', '7'});
            put('5', new Character[] {'2', '4', '5', '6', '8'});
            put('6', new Character[] {'3', '5', '6', '9'});
            put('7', new Character[] {'4', '7', '8'});
            put('8', new Character[] {'5', '7', '8', '9', '0'});
            put('9', new Character[] {'6', '8', '9'});
        }
    };
    public static List<String> getPINs(String observed) {
        System.out.println(observed);
        Character[][] inputDigits = new Character[observed.length()][];
        int size = 1;
        for (int i = 0; i < observed.length(); i++) {
            inputDigits[i] = adjacent.get(observed.charAt(i));
            size *= inputDigits[i].length;
        }
        List<StringBuilder> variations = new ArrayList<>();
        while (variations.size() < size) variations.add(new StringBuilder());
        fillVariations(variations, 0, size, inputDigits);
        return variations.stream().map(StringBuilder::toString).collect(Collectors.toList());
    }

    public static void fillVariations(List<StringBuilder> variations, int left, int right, Character[][] inputDigits) {
        if (inputDigits.length == 0) return;
        int gaps = inputDigits[0].length;
        int gapLength = (right - left) / gaps;
        for (int i = 0; i < gaps; i++) {
            for (int j = left + i * gapLength; j < left + (i + 1) * gapLength; j++) {
                variations.get(j).append(inputDigits[0][i]);
            }
            fillVariations(variations, left + i * gapLength, left + (i + 1) * gapLength, Arrays.copyOfRange(inputDigits, 1, inputDigits.length));
        }
    }
}
