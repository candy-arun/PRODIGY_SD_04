class SudokuPuzzle{

    public static void main(String[] args) {
        int[][] question = {
            {0,0,0,6,0,0,0,7,0},
            {0,2,0,0,0,5,0,0,0},
            {8,0,0,0,4,0,0,0,0},
            {0,0,0,0,5,8,0,0,0},
            {7,0,0,0,0,0,0,0,8},
            {0,0,0,0,3,0,0,0,0},
            {0,0,0,0,7,0,0,0,6},
            {0,4,0,0,0,3,0,0,0},
            {0,0,0,4,0,0,0,8,0}
        };

        if (solveSudoku(question)) {
            System.out.println("Solved Sudoku:");
            SudokuGrid(question);
        } else {
            System.out.println("question was incomplete");
        }
    }

     static boolean solveSudoku(int[][] grid) {
        int[] emptycell = findemptycell(grid);

        if (emptycell == null) {
            return true;
        }

        int row = emptycell[0];
        int col = emptycell[1];

        for (int n = 1; n <= 9; n++) {
            if (validmove(grid, row, col, n)) {
                grid[row][col] = n;

                if (solveSudoku(grid)) {
                    return true;
                }
                grid[row][col] = 0;
            }
        }
        return false;
    }

     static int[] findemptycell(int[][] grid) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (grid[row][col] == 0) {
                    return new int[]{row, col};
                }
            }
        }
        return null;
    }

     static boolean validmove(int[][] grid, int row, int col, int num) {
        return !in_row(grid, row, num) && !in_col(grid, col, num) && !box(grid, row - row % 3, col - col % 3, num);
    }

     static boolean in_row(int[][] grid, int row, int num) {
        for (int col = 0; col < 9; col++) {
            if (grid[row][col] == num) {
                return true;
            }
        }
        return false;
    }

     static boolean in_col(int[][] grid, int col, int num) {
        for (int row = 0; row < 9; row++) {
            if (grid[row][col] == num) {
                return true;
            }
        }
        return false;
    }

     static boolean box(int[][] grid, int startRow, int startCol, int num) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (grid[row + startRow][col + startCol] == num) {
                    return true;
                }
            }
        }
        return false;
    }

     static void SudokuGrid(int[][] grid) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                System.out.print(grid[row][col] + " ");
            }
            System.out.println();
        }
    }
}