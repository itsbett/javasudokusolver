package com.brettdoes;

public class Main {
    static private final int DIM = 9;
    static private final Position<Integer, Integer> GRID_FULL = new Position<>(9,9);

    public static void main(String[] args) {
        int[][] grid = new int[][] {
                {2, 0, 0, 0, 0, 5, 0, 0, 0},
                {0, 6, 0, 0, 0, 0, 5, 9, 0},
                {5, 9, 4, 3, 0, 0, 0, 7, 0},
                {0, 3, 2, 0, 5, 0, 7, 0, 0},
                {4, 0, 0, 0, 8, 0, 0, 0, 9},
                {0, 0, 7, 0, 3, 0, 6, 5, 0},
                {0, 5, 0, 0, 0, 7, 9, 6, 4},
                {0, 4, 9, 0, 0, 0, 0, 8, 0},
                {0, 0, 0, 9, 0, 0, 0, 0, 5}
        };
        PrintGrid.display(grid);

        if (solveSudoku(grid)) {
            PrintGrid.display(grid);
        } else {
            System.out.println("There is no solution for the given Sudoku.");
        }
    }
    // check rows to see if number already exists
    static private boolean usedInRow (int[][] grid, int row, int num) {
        for (int col = 0; col < DIM; col++) {
            if (grid[row][col] == num) {
                return true;
            }
        }
        return false;
    }
    // check columns to see if number already exists
    static private boolean usedInCol (int[][] grid, int col, int num) {
        for (int row =0; row < DIM; row++) {
            if (grid[row][col] == num) {
                return true;
            }
        }
        return false;
    }

    // check 3 x 3 square to see if number already exists
    static private boolean usedInBox (int[][] grid, int boxStartingRow, int boxStartingCol, int num) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (grid[row + boxStartingRow][row + boxStartingCol] == num) {
                    return true;
                }
            }
        }
        return false;
    }
    static private boolean isValidNumber (int[][] grid, int row, int col, int num) {
        return !usedInRow(grid, row, num) &&
                !usedInCol(grid, col, num) &&
                // row - row % 3 and col - col %3 returns the top left position of the 3 x 3 box the element belongs to
                !usedInBox(grid, row - row % 3, col - col % 3, num);
    }

    static private Position getEmptySpace (int[][] grid) {
        for (int row = 0; row < DIM; row++) {
            for (int col = 0; col < DIM; col++) {
                if(grid[row][col] == 0) {
                    return new Position<>(row, col);
                }
            }
        }
        return GRID_FULL;
    }

    static private boolean solveSudoku (int[][] grid) {
        if (GRID_FULL.equals(getEmptySpace(grid))) {
            return true;
        }

        Position gridPosition = getEmptySpace(grid);

        int row = (int) gridPosition.getX();
        int col = (int) gridPosition.getY();

        for (int num = 1; num <= 9; num++) {
            if(isValidNumber(grid, row, col, num)) {
                grid[row][col] = num;

                if(solveSudoku(grid)) {
                    return true;
                }

                grid[row][col] = 0;
            }
        }
        return false;
    }
}
