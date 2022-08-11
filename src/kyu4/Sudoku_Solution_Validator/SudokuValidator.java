package kyu4.Sudoku_Solution_Validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class SudokuValidator {
    public static void main(String[] args) {
        System.out.println(check(new int[][]{
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
                }));
    }

    public static boolean check (int[][] sudoku) {
        Set<Integer> numbersLines = new HashSet<>();
        Set<Integer> numbersRows = new HashSet<>();
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {
                numbersLines.add(sudoku[i][j]);
                numbersRows.add(sudoku[j][i]);
            }
            if (isInvalid(numbersLines) | isInvalid(numbersRows)) return false;
            numbersLines.clear();
            numbersRows.clear();
        }
        for (int i = 0; i <= sudoku.length - 3; i += 3) {
            for (int j = 0; j <= sudoku.length - 3; j += 3) {
                if (isInvalid(Arrays.stream(getSubGrid(sudoku, i, j)).boxed().collect(Collectors.toSet()))) return false;
            }
        }
        return true;
    }

    public static boolean isInvalid(Set<Integer> numbers) {
        return (!(numbers.size() == 9 & !numbers.contains(0)));
    }

    public static int[] getSubGrid(int[][] grid, int leftTop, int rightBottom) {
        int[] subGrid = new int[9];
        for (int i = leftTop; i < leftTop + 3; i++) {
            for (int j = rightBottom; j < rightBottom + 3; j++) {
                subGrid[i * 3 + j - leftTop * 3 - rightBottom] = grid[i][j];
            }
        }
        return subGrid;
    }
}
