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

        if (row == board.length) {
            printBorard(board);
            return;
        }

        for (int j = 0; j < board.length; j++) {
            board[row][j] = 'Q';
            nQueens(board, row + 1);
            board[row][j] = 'x';
        }

    }

    public static void main(String args[]) {

        // String str = "abc";
        // // findSubset(str, "", 0);
        // permutation(str, "");

        int n = 2;
        char board[][] = new char[n][n];
        nQueens(board, 0);

    }
}