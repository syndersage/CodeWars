package kyu5.Directions_Reduction;

import java.util.Arrays;

public class DirReduction_solution1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dirReduc(new String[]{"EAST", "EAST", "WEST", "NORTH", "WEST", "EAST", "EAST", "SOUTH", "NORTH", "WEST"})));
    }

    public static String[] dirReduc(String[] arr) {
        int x = 0, y = 0;
        for (String direction:
                arr) {
            switch (direction) {
                case "NORTH" -> y++;
                case "SOUTH" -> y--;
                case "WEST" -> x--;
                case "EAST" -> x++;
            }
        }
        String[] outArr = new String[(x < 0 ? -x : x) + (y < 0 ? -y : y)];
        for (int i = 0; i < outArr.length; i++) {
            if (y != 0) {
                if (y > 0) {
                    outArr[i] = "NORTH";
                    y--;
                } else {
                    outArr[i] = "SOUTH";
                    y++;
                }
            } else if (x != 0) {
                if (x > 0) {
                    outArr[i] = "EAST";
                    x--;
                } else {
                    outArr[i] = "WEST";
                    x++;
                }
            } else break;
        }
        return outArr;
    }
}
