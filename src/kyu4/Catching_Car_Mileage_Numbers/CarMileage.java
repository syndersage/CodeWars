package kyu4.Catching_Car_Mileage_Numbers;

public class CarMileage {
    public static void main(String[] args) {
        System.out.println(isInteresting(109, new int[]{1337, 256}));
    }

    enum NumberType {
        NO(0), ALMOST(1), YES(2);
        private final int out;
        NumberType(int out) {
            this.out = out;
        }

        public int getOut() {
            return out;
        }
    }

    public static String str;

    public static int isInteresting(int number, int[] awesomePhrases) {
        int[] numbers = new int[] {number, number + 1, number + 2};
        NumberType numberType;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 100) continue;
            numberType = i == 0 ? NumberType.YES : NumberType.ALMOST;
            str = String.valueOf(numbers[i]);
            if (followedByZeros() | sameDigits() | sequentialIncrementing() |
                    sequentialDecrementing() | palindrome()) return numberType.out;
            for (int awesomePhrase : awesomePhrases) {
                if (awesomePhrase == numbers[i]) return numberType.out;
            }
        }
        return 0;
    }

    public static boolean palindrome() {
        String left = str.substring(0, str.length() / 2);
        StringBuilder right = new StringBuilder(str.substring(str.length() / 2));
        if (right.length() > left.length()) right.deleteCharAt(0);
        return left.equals(right.reverse().toString());
    }

    public static boolean sequentialIncrementing() {
        char[] letters = str.toCharArray();
        for (int i = 1; i < letters.length; i++) {
            if (letters[i] == 48) {
                if (letters[i - 1] != 57 & i == letters.length - 1) return false;
            }
            else if (letters[i] != letters[i - 1] + 1) return false;
        }
        return true;
    }

    public static boolean sequentialDecrementing() {
        char[] letters = str.toCharArray();
        for (int i = 1; i < letters.length; i++) {
            if (letters[i] == 57) {
                if (letters[i - 1] != 48 | i == letters.length - 1) return false;
            }
            else if (letters[i] != letters[i - 1] - 1) return false;
        }
        return true;
    }

    public static boolean followedByZeros() {
        return str.charAt(str.length() - 1) == '0' && sameDigits(str.substring(1));
    }

    public static boolean sameDigits() {
        return str.replaceAll(str.substring(0, 1), "").equals("");
    }

    public static boolean sameDigits(String str) {
        return str.replaceAll(str.substring(0, 1), "").equals("");
    }
}
