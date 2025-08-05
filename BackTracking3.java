//This is for solving knight problem

public class BackTracking3 {

    static int N;
    static int moveX[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
    static int moveY[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

    public static void printSolution(int sol[][]) {

        for (int i = 0; i < sol.length; i++) {
            for (int j = 0; j < sol.length; j++) {
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(int sol[][], int x, int y) {

        return (x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1);
        // The -1 ensures that there to avoid cycles
    }

    public static boolean solveKnightUntil(int sol[][], int moves, int x, int y) {

        if (moves == N * N) {
            return true;
        }

        // check for all knight moves

        for (int k = 0; k < 8; k++) {
            int nextX = x + moveX[k];
            int nextY = y + moveY[k];

            if (isSafe(sol, nextX, nextY)) {

                sol[nextX][nextY] = moves;
                if (solveKnightUntil(sol, moves + 1, nextX, nextY)) {
                    return true;
                }
                // solveKnightUntil(sol, moves + 1, nextX, nextY);

                sol[nextX][nextY] = -1;
            }
        }

        return false;

    }

    public static void solveKnight(int N) {

        // initializing empty array
        // with -1
        int sol[][] = new int[N][N];

        for (int i = 0; i < sol.length; i++) {
            for (int j = 0; j < sol.length; j++) {
                sol[i][j] = -1;
            }
        }

        // The first postion must be zero
        // Starting position

        sol[0][0] = 0;

        // we already placed the knight at 0,0 thats why we used move=1 while passing it
        if (solveKnightUntil(sol, 1, 0, 0)) {

            printSolution(sol);

        } else {
            System.out.println("Solution does not exist");

        }

    }

    public static void main(String args[]) {

        N = 8;

        solveKnight(N);
    }
}
