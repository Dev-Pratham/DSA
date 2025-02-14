import java.util.ArrayList;
import java.util.List;

public class test {
    // Define the dominos as arrays of strings
    static String[] top = { "1", "10" };
    static String[] bottom = { "111", "0" };
    static int maxDepth = 10; // Limit recursion depth to avoid infinite loops
    static int solutionCount = 0; // Track the number of solutions found
    static int requiredSolutions = 3; // Number of solutions to find

    public static void main(String[] args) {
        List<Integer> solution = new ArrayList<>();
        System.out.println("Solving PCP for dominos...");
        solvePCP("", "", solution, 0);
        if (solutionCount < requiredSolutions) {
            System.out.println("Less than 3 solutions were found.");
        }
    }

    // Recursive function to solve PCP
    public static void solvePCP(String topString, String bottomString, List<Integer> solution, int depth) {
        // Stop recursion if depth exceeds maxDepth or if enough solutions are found
        if (depth > maxDepth || solutionCount >= requiredSolutions) {
            return;
        }

        // Check if the top and bottom strings match
        if (!topString.isEmpty() && topString.equals(bottomString)) {
            solutionCount++;
            System.out.println("Solution " + solutionCount + ": " + solution);
            if (solutionCount >= requiredSolutions) {
                return;
            }
        }

        // Try each domino
        for (int i = 0; i < top.length; i++) {
            // Append current domino to the solution
            solution.add(i + 1);

            // Concatenate current domino to top and bottom strings
            String newTopString = topString + top[i];
            String newBottomString = bottomString + bottom[i];

            // Recursive call
            solvePCP(newTopString, newBottomString, solution, depth + 1);

            // Backtrack: remove the last domino from the solution
            solution.remove(solution.size() - 1);
        }
    }
}
