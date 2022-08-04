package kyu6.Equal_Sides_Of_An_Array;

public class Kata {
    public static void main(String[] args) {
        System.out.println(findEvenIndex(new int[] {4}));
    }

    public static int findEvenIndex(int[] arr) {
        int sumLeft = 0, sumRight = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) sumLeft += arr[j];
            for (int j = i + 1; j < arr.length; j++) sumRight += arr[j];
            if (sumLeft == sumRight) return i;
            sumLeft = sumRight = 0;
        }
        return -1;
    }
}