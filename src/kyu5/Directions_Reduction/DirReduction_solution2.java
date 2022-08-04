package kyu5.Directions_Reduction;

import java.util.Arrays;

public class DirReduction_solution2 {
    static class Direction {
        Direction previous;
        int arrayIndex;
        Direction(Direction previous, int arrayIndex) {
            this.previous = previous;
            this.arrayIndex = arrayIndex;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dirReduc(new String[]{"EAST", "EAST", "WEST", "NORTH", "WEST", "EAST", "EAST", "SOUTH", "NORTH", "WEST"})));
    }

//    public static String[] dirReduc(String[] arr) {
//        int[] shortedDirections = new int[arr.length];
//        for (int i = 0; i < shortedDirections.length; i++) { shortedDirections[i] = i; }
//        for (int i = 0; i < arr.length - 1; i++) {
//
//            switch (arr[i]) {
//                case "NORTH" -> {
//                    if (arr[i + 1].equals("SOUTH")) {shortedDirections[i] = -1; shortedDirections[i + 1] = -1; i = 0; }
//                }
//                case "SOUTH" -> {
//                    if (arr[i + 1].equals("NORTH")) {shortedDirections[i] = -1; shortedDirections[i + 1] = -1; i = 0; }
//                }
//                case "EAST" -> {
//                    if (arr[i + 1].equals("WEST")) {shortedDirections[i] = -1; shortedDirections[i + 1] = -1; i = 0; }
//                }
//                case "WEST" -> {
//                    if (arr[i + 1].equals("EAST")) {shortedDirections[i] = -1; shortedDirections[i + 1] = -1; i = 0; }
//                }
//            }
//        }
//        int outArrLength = 0;
//        for (int item:
//             shortedDirections) {
//            if (item != -1) outArrLength++;
//        }
//        System.out.println(outArrLength);
//        return new String[] {};
//    }
    public static int newArrayLength;
    public static String[] dirReduc(String[] arr) {
        newArrayLength = arr.length;
        for (int i = 0; i < newArrayLength - 1; i++) {
            if (arr[i].equals("NORTH") & arr[i + 1].equals("SOUTH") | arr[i].equals("SOUTH") & arr[i + 1].equals("NORTH")
                | arr[i].equals("WEST") & arr[i + 1].equals("EAST") | arr[i].equals("EAST") & arr[i + 1].equals("WEST")) {
                if (newArrayLength - 2 - i >= 0) System.arraycopy(arr, i + 2, arr, i, newArrayLength - 2 - i);
                newArrayLength -= 2;
            }
        }
        if (newArrayLength != arr.length) {
            String[] tempArr = new String[newArrayLength];
            System.arraycopy(arr, 0, tempArr, 0, newArrayLength);
            arr = dirReduc(tempArr);
        }
        return arr;
    }
}
