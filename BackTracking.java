public class BackTracking {

    public static void printarr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

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

    public static void arrBackTrack(int arr[], int i) {

        if (i == arr.length) {
            return;
        }
        arr[i] = i + 1;
        arrBackTrack(arr, i + 1);
        arr[i] = arr[i] - 2;
    }

    public static void findSubset(String str, String ans, int level) {

        if (level == str.length()) {

            if (ans.length() == 0) {
                System.out.println("Null");
            } else {
                System.out.println(ans);
            }
            return;
        }
        // decision of each character
        // if yes
        findSubset(str, ans + str.charAt(level), level + 1);
        // if no leave it as it is
        findSubset(str, ans, level + 1);

    }

    public static void permutation(String str, String ans) {

        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i + 1);
            permutation(newStr, ans + current);
        }

    }

    public static boolean isSafe(char board[][], int row, int col) {

        // vertical condition
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // left diagonal condition
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void printBorard(char board[][]) {

        System.out.println("-----Chess Board-----");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int count = 0;

    public static void nQueens(char board[][], int row) {

        // approach used plac n queen in n row first
        if (row == board.length) {
            printBorard(board);
            return;
        }

        for (int j = 0; j < board.length; j++) {
            // Checks whether to place queen or not

            if (isSafe(board, row, j)) {

                // This 3 step is for all the permutation of placing queen in row
                board[row][j] = 'Q';
                nQueens(board, row + 1);
                // when we backtrack then first we remove queen then
                // place it to another position
                board[row][j] = 'x';
            }
        }

    }

    // THis variation counts the number of solution
    public static void nQueen2(char board[][], int row) {

        // approach used plac n queen in n row first
        if (row == board.length) {
            count++;
            return;
        }

        for (int j = 0; j < board.length; j++) {
            // Checks whether to place queen or not

            if (isSafe(board, row, j)) {

                // This 3 step is for all the permutation of placing queen in row
                board[row][j] = 'Q';
                nQueens(board, row + 1);
                // when we backtrack then first we remove queen then
                // place it to another position
                board[row][j] = 'x';
            }
        }

    }

    // This variation check whether problem can be solved if yes then
    // print only one solution
    public static boolean nQueen3(char board[][], int row) {

        // approach used plac n queen in n row first
        if (row == board.length) {

            return true;
        }

        for (int j = 0; j < board.length; j++) {
            // Checks whether to place queen or not

            if (isSafe(board, row, j)) {

                board[row][j] = 'Q';
                if (nQueen3(board, row + 1)) {
                    return true;
                }

                board[row][j] = 'x';
            }
        }

        return false;
    }

    public static int gridWays(int i, int j, int n, int m) {
        if (i == n - 1 && j == m - 1) {
            return 1;
        }

        // boundary condition
        // if we increment the i and j we might move to n or beyond
        // however the valid index is from 0 to n-1
        else if (i == n || j == m) {
            return 0;
        }

        int w1 = gridWays(i, j + 1, n, m);
        int w2 = gridWays(i + 1, j, n, m);

        return w1 + w2;
    }

    public static int gridWays2(int i, int j, int n, int m) {
        // default is considered that src is at origin
        // permutation approch used
        int totalCharac = (n - 1 - i) + (m - 1 - j);
        return fact(totalCharac) / (fact(n - 1 - i) * fact(m - 1 - j));
    }

    public static int fact(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        return n * fact(n - 1);
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
        if (row == 9 && col == 0) {
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

        // String str = "abc";
        // // findSubset(str, "", 0);
        // permutation(str, "");

        // initialization
        // int n = 4;
        // char board[][] = new char[n][n];

        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < n; j++) {
        // board[i][j] = '.';
        // }
        // }
        // // Print all possible solutions
        // nQueens(board, 0);

        // // Count all possible solutions
        // nQueen2(board, 0);
        // System.out.println(count);

        // if (nQueen3(board, 0)) {
        // System.out.println("Solution exists");
        // printBorard(board);
        // } else {
        // System.out.println("Solution doesnot exists");
        // }

        // gridways
        // int gridSol = gridWays(1, 1, 5, 3);
        // System.out.println(gridSol);

        // System.out.println("null");
        // // gridways linear time
        // System.out.println(gridWays2(1, 1, 5, 3));

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