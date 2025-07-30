public class test {

    public static void printSudoku(int arr[][]) {
        // This 2d matrix function is custom built to print 9*9 sudoku

        for (int i = 0; i < arr.length; i++) {
            if (i == 3 || i == 6) {
                System.out.print("-----------------------");
                System.out.println();
            }
            for (int j = 0; j < arr.length; j++) {

                if (j == 3 || j == 6) {
                    System.out.print(" | ");
                }

                System.out.print(arr[i][j] + " ");
            }

            System.out.println();
        }
    }

    public static boolean isSafe2(int sud[][], int row, int col, int digit) {

        // column traverse
        for (int i = 0; i < sud.length; i++) {
            if (sud[i][col] == digit) {
                return false;
            }
        }

        // row traverse
        for (int j = 0; j < sud.length; j++) {
            if (sud[row][j] == digit) {
                return false;
            }
        }

        // grid traverse
        // this is a method to find
        // starting row and col
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;

        for (int k = sr; k < sr + 3; k++) {
            for (int l = sc; l < sc + 3; l++) {
                if (sud[k][l] == digit) {
                    return false;
                }
            }
        }

        return true;

    }

    public static boolean sudoku(int sud[][], int row, int col) {

        // base case
        if (row == 9) {
            return true;
        }

        // we only wanted to change the row until one
        // row is completed
        int nextrow = row;
        int nextCol = col + 1;
        if (nextCol == sud.length) {
            nextrow = row + 1;
            nextCol = 0;
        }
        // if there is already an digit int the suodku we move next
        if (sud[row][col] != 0) {
            return sudoku(sud, nextrow, nextCol);
        }
        // placing of digits
        for (int i = 1; i <= 9; i++) {
            if (isSafe2(sud, row, col, i)) {
                sud[row][col] = i;
                // solution exists
                if (sudoku(sud, nextrow, nextCol)) {
                    return true;
                }
                // if the above statement return false we make the digit
                // zer0
                sud[row][col] = 0;
            }

        }

        return false;
    }

    public static void main(String args[]) {

        int sudoku2[][] = { { 0, 0, 8, 0, 0, 0, 0, 0, 0 },
                { 4, 9, 0, 1, 5, 7, 0, 0, 2 },
                { 0, 0, 3, 0, 0, 4, 1, 9, 0 },
                { 1, 8, 5, 0, 6, 0, 0, 2, 0 },
                { 0, 0, 0, 0, 2, 0, 0, 6, 0 },
                { 9, 6, 0, 4, 0, 5, 3, 0, 0 },
                { 0, 3, 0, 0, 7, 2, 0, 0, 4 },
                { 0, 4, 9, 0, 3, 0, 0, 5, 7 },
                { 8, 2, 7, 0, 0, 9, 0, 1, 3 } };

        if (sudoku(sudoku2, 0, 0)) {
            System.out.println("solution exists");
            printSudoku(sudoku2);
        } else {
            System.out.println("Solution does not exists");
        }
    }
}