package com.brettdoes;

public class PrintGrid {
    public static void display (int[][] grid) {
        final int DIM = 9;
        final int BLANK = 0;
        final char LINE = '|';
        final char SPACE = ' ';
        final String NEW_ROW = "-------------------------------------";
        for (int i = 0; i < DIM; i++) {
            System.out.println("\n" + NEW_ROW);
            System.out.print(LINE);
            for (int j =0; j < DIM; j++) {
                System.out.print(SPACE);
                if (BLANK == grid[i][j]) {
                    System.out.print(SPACE);
                } else {
                    System.out.print(grid[i][j]);
                }
                System.out.print(SPACE);
                System.out.print(LINE);
            }
        }
        System.out.println("\n" + NEW_ROW +"\n\n");
    }
}
