public class test {

    public static void printmaze(int[][] sol) {
        for (int i = 0; i < sol.length; i++) {
            for (int j = 0; j < sol.length; j++) {
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void solveMazeUntil(int maze[][], int x, int y, int sol[][]) {
        // base case
        // we reached at the end of the maze

        int n = maze.length;
        if (x == n - 1 && y == n - 1 && maze[x][y] == 1) {
            sol[x][y] = 1;
            printmaze(sol);
            sol[x][y] = 0;
            return;
        }

        // Check if current cell is invalid
        if (x < 0 || x >= n || y < 0 || y >= n || maze[x][y] == 0 || sol[x][y] == 1) {
            return;
        }

        // Mark current cell in solution
        sol[x][y] = 1;

        // Explore all 4 directions: Down, Left, Right, Up
        solveMazeUntil(maze, x + 1, y, sol); // Down
        solveMazeUntil(maze, x, y - 1, sol); // Left
        solveMazeUntil(maze, x, y + 1, sol); // Right
        solveMazeUntil(maze, x - 1, y, sol); // Up

        // Backtrack
        sol[x][y] = 0;

    }

    public static void solveMaze(int maze[][]) {
        int n = maze.length;
        int sol[][] = new int[n][n];

        if (maze[0][0] == 0) {
            System.out.println("No path possible from start.");
            return;
        }
        solveMazeUntil(maze, 0, 0, sol);

    }

    public static void main(String args[]) {

        // int sudoku2[][] = { { 0, 0, 8, 0, 0, 0, 0, 0, 0 },
        // { 4, 9, 0, 1, 5, 7, 0, 0, 2 },
        // { 0, 0, 3, 0, 0, 4, 1, 9, 0 },
        // { 1, 8, 5, 0, 6, 0, 0, 2, 0 },
        // { 0, 0, 0, 0, 2, 0, 0, 6, 0 },
        // { 9, 6, 0, 4, 0, 5, 3, 0, 0 },
        // { 0, 3, 0, 0, 7, 2, 0, 0, 4 },
        // { 0, 4, 9, 0, 3, 0, 0, 5, 7 },
        // { 8, 2, 7, 0, 0, 9, 0, 1, 3 } };

        // if (sudoku(sudoku2, 0, 0)) {
        // System.out.println("solution exists");
        // printSudoku(sudoku2);
        // } else {
        // System.out.println("Solution does not exists");
        // }

        int[][] maze = {
                { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 }
        };

        solveMaze(maze);

    }
}