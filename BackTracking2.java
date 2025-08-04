public class BackTracking2 {

    public static void printAllPaths(int[][] maze, int x, int y, int[][] sol) {
        // Base Case: Reached the destination
        int n = maze.length;
        if (x == n - 1 && y == n - 1 && maze[x][y] == 1) {
            sol[x][y] = 1;
            printMatrix(sol);
            sol[x][y] = 0; // Backtrack
            return;
        }

        // Check if current cell is invalid
        if (x < 0 || x >= n || y < 0 || y >= n || maze[x][y] == 0 || sol[x][y] == 1) {
            return;
        }

        // Mark current cell in solution
        sol[x][y] = 1;

        // Explore all 4 directions: Down, Left, Right, Up
        printAllPaths(maze, x + 1, y, sol); // Down
        printAllPaths(maze, x, y - 1, sol); // Left
        printAllPaths(maze, x, y + 1, sol); // Right
        printAllPaths(maze, x - 1, y, sol); // Up

        // Backtrack
        sol[x][y] = 0;
    }

    public static void printMatrix(int[][] sol) {
        for (int i = 0; i < sol.length; i++) {
            for (int j = 0; j < sol.length; j++) {
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void solveMaze(int[][] maze) {
        int n = maze.length;
        int[][] sol = new int[n][n];

        if (maze[0][0] == 0) {
            System.out.println("No path possible from start.");
            return;
        }

        System.out.println("All possible path matrices:");
        printAllPaths(maze, 0, 0, sol);
    }

    public static String getString(char ch) {

        char c = ch;

        switch (c) {
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
            default:
                return "";
        }
    }

    public static void generateCombinations(String digit, int index, String current) {

        if (index == digit.length()) {
            System.out.println(current);
            return;
        }

        char currentInput = digit.charAt(index);
        String mappedString = getString(currentInput);

        for (int i = 0; i < mappedString.length(); i++) {
            generateCombinations(digit, index + 1, current + mappedString.charAt(i));
        }

    }

    public static void main(String[] args) {
        // int[][] maze = {
        // { 1, 0, 0, 0 },
        // { 1, 1, 0, 1 },
        // { 0, 1, 0, 0 },
        // { 1, 1, 1, 1 }
        // };

        // solveMaze(maze);

        String digit = "2";
        generateCombinations(digit, 0, "");
    }
}
