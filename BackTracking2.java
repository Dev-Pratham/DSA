public class BackTracking2 {

    public static void printMaze(int maze[][]) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze.length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void recur(int iniMaze[][], int solMaze[][], int i, int j) {

        int n = iniMaze.length;
        if (i == n || j == n || i == -1 || j == -1) {
            // The position is out of matrix we simply return
            return;
        }

        if (iniMaze[i][j] != 0) {

            solMaze[i][j] = 1;
        }
        if (i == n - 1 && j == n - 1) {
            printMaze(solMaze);
            System.out.println("-------------------");
        }

        recur(iniMaze, solMaze, i + 1, j);
        recur(iniMaze, solMaze, i, j + 1);
        solMaze[i][j] = 0;

    }

    public static void main(String args[]) {

        int maze[][] = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 } };

        int mazeSize = maze.length;

        // creating solution maze
        int solMaze[][] = new int[mazeSize][mazeSize];
        // initializing solution maze
        for (int i = 0; i < solMaze.length; i++) {
            for (int j = 0; j < solMaze.length; j++) {
                solMaze[i][j] = 0;
            }
        }

        recur(maze, solMaze, 0, 0);
    }
}
