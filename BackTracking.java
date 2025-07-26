public class BackTracking {

    public static void printarr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
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

    public static void main(String args[]) {

        // String str = "abc";
        // // findSubset(str, "", 0);
        // permutation(str, "");

        // initialization
        int n = 4;
        char board[][] = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        nQueens(board, 0);

    }
}