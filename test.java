public class test {

    public static int gridWays(int i, int j, int n, int m) {
        if (i == n - 1 && j == m - 1) {
            return 1;
        }

        // boundary condition
        else if (i == n || j == m) {
            return 0;
        }

        int w1 = gridWays(i, j + 1, n, m);
        int w2 = gridWays(i + 1, j, n, m);

        return w1 + w2;
    }

    public static void main(String args[]) {

        int gridSol = gridWays(0, 0, 3, 3);
        System.out.println(gridSol);
    }
}