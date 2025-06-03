public class test {

    // Starting point
    public static void subSets(String str) {
        helper(str, 0, 0);
    }

    // This replaces the 1st and 2nd loop (i and j)
    public static void helper(String str, int start, int end) {
        if (start == str.length())
            return; // base case

        if (end == str.length()) {
            // when end reaches string length, move start to next index
            helper(str, start + 1, start + 1);
        } else {
            // print characters from start to end (like your 3rd loop)
            printChars(str, start, end);
            System.out.println();
            helper(str, start, end + 1); // move end ahead
        }
    }

    // This replaces the innermost loop
    public static void printChars(String str, int si, int ei) {
        if (si > ei)
            return;
        System.out.print(str.charAt(si) + " ");
        printChars(str, si + 1, ei);
    }

    public static void main(String[] args) {
        subSets("abcd");
    }
}
