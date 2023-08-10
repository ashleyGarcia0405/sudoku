import java.io.*;
import java.util.*;

public class Sudoku {
    //defining the Sudoku grid as a 9x9 perfect square
    static int N = 9;

    // generating a Sudoku puzzle --- uhh I will do this later

    // solving a Sudoku puzzle
    static boolean solve(int grid[][], int row, int col) {
        // checking that we haven't
        if(row == N-1 && col == N) {
            return true;
        }
        if(col == N) {
            row++;
            col = 0;
        }
        if(grid[row][col] != 0 ) {
            return solve(grid, row, col + 1);
        }
        for(int num = 1; num < 10; num++) {
            if(isValid(grid, row, col, num)) {
                grid[row][col] = num;
                if(solve(grid, row, col +1)) {
                    return true;
                }
            }
            grid[row][col] = 0;
        }
        return false;
    }

    public static boolean isValid(int[][] grid, int row, int col, int num) {
        for(int i = 0; i <= N-1; i++) {
            if (grid[row][i] == num) {
                return false;
            }
        }
        for(int i = 0; i <= N-1; i++) {
            if (grid[i][col] == num) {
                return false;
            }
        }

        int startRow= row - row % 3;
        int startCol = col - col % 3;

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if (grid[i + startRow][j + startCol] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    // printing the grid
    static void print(int[][] grid) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
