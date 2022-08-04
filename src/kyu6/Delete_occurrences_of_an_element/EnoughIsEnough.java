package kyu6.Delete_occurrences_of_an_element;

import java.util.Arrays;

public class EnoughIsEnough {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(deleteNth(new int[] { 1, 1, 3, 3, 7, 2, 2, 2, 2 }, 2)));
    }

    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        for (int i = 0; i < elements.length; i++) {
            int numOfOccurs = 0;
            for (int j = 0; j <= i; j++) {
                if (elements[j] == elements[i]) numOfOccurs++;
            }
            if (numOfOccurs > maxOccurrences) {
                System.arraycopy(elements, i + 1, elements, i, elements.length - i - 1);
                elements = Arrays.copyOf(elements, elements.length - 1);
                i--;
            }
        }
        return elements;
    }
}
