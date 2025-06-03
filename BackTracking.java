public class BackTracking {

    public static void arrayBacktrack(int arr[], int i) {

        if (i == arr.length) {
            System.out.print("Base case array : ");
            print(arr);
            System.out.println();
            System.out.print("Backtracked : ");
            return;
        }
        arr[i] = i + 1;
        arrayBacktrack(arr, i + 1); // recursive call
        arr[i] = arr[i] - 2; // backtracking step

    }

    public static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    // This is brute force method to build understanding
    public static void subString(String str) {

        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                for (int si = i; si <= j; si++) {
                    System.out.print(str.charAt(si) + " ");
                }
                System.out.println();

            }
        }

    }

    // This is helper for printing substring
    public static void printSubStr(String str, int si, int ei) {
        if (si > ei) {
            return;
        }
        System.out.print(str.charAt(si) + "");
        printSubStr(str, si + 1, ei);

    }

    // This method uses backtracking for printing substring
    public static void subStringBacktrack(String str, int si, int ei) {
        if (si == str.length()) {
            return; // base case
        }
        if (ei == str.length()) {
            subStringBacktrack(str, si + 1, si + 1);
        } else {
            printSubStr(str, si, ei);
            System.out.println();
            subStringBacktrack(str, si, ei + 1);
        }
    }

    // overfitted code for printing subset of size 3
    // highly optimized what the hell is this
    public static void backTracking2(String str, int i) {

        if (i == str.length()) {
            System.out.println(str + "");
            return;
        }

        System.out.println(str.charAt(i));
        backTracking2(str, i + 1);
        for (int j = i - 1; j >= 0; j--) {
            System.out.println(str.charAt(j) + "" + str.charAt(i));
        }
    }

    public static void main(String args[]) {

        // int arr[] = new int[10];
        // backTracking1(arr, 0);
        // print(arr);

        String str = "abc";
        subStringBacktrack(str, 0, 0);
    }
}