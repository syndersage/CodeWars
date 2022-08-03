package kyu6.create_Phone_Number;

public class Kata {
    public static void main(String[] args) {
        System.out.println(createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));

    }

    public static String createPhoneNumber(int[] numbers) {
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            switch (i) {
                case 0 -> number.append("(").append(numbers[i]);
                case 2 -> number.append(numbers[i]).append(") ");
                case 5 -> number.append(numbers[i]).append("-");
                default -> number.append(numbers[i]);
            }
        }
        return number.toString();
    }
}
