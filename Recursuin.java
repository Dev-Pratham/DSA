import java.util.Scanner;

public class Recursuin {

    public static void printDec(int n) {

        if (n == 0) {
            System.out.println("Base case reached!");
            return;
        }
        System.out.println(n);
        printDec(n - 1);

    }

    public static void printInc(int n) {

        if (n == 0) {
            return;
        }
        printInc(n - 1);
        System.out.println(n);
    }

    public static int factorial(int n) {

        if (n == 0 || n == 1) {
            return 1;
        }

        int fact = n * factorial(n - 1);
        return fact;
        // System.out.println(fact); unreachable code

    }

    public static int printSum(int n) {
        if (n == 1) {
            return 1;
        }
        int sum = n + printSum(n - 1);
        return sum;
    }

    public static int printNthFinonnaci(int n) {

        if (n == 0 || n == 1) {
            return n;
        }

        int nth = printNthFinonnaci(n - 1) + printNthFinonnaci(n - 2);
        return nth;
    }

    public static boolean isSorted(int arr[], int i) {
        // for ascending order
        if (i == arr.length - 1) {
            return true;
        }

        if (arr[i] > arr[i + 1]) {
            return false;
        }

        boolean result = isSorted(arr, i + 1);
        return result;

    }

    public static int firstOccurrence(int arr[], int key, int i) {

        if (i == arr.length - 1) {
            return -1;
        }

        if (arr[i] == key) {
            return i;
        }

        return firstOccurrence(arr, key, i + 1);

    }

    public static int lastOccurrence(int arr[], int key, int i) {
        // base case
        if (i == arr.length) {
            return -1;
        }

        int index = lastOccurrence(arr, key, i + 1);
        if (index == -1 && arr[i] == key) {
            return i;
        }

        return index;

    }

    public static int calcPower(int x, int n) {

        if (n == 0) {
            return 1;
        }

        int power = x * calcPower(x, n - 1);
        return power;
    }

    public static int optimizedPower(int base, int power) {

        if (power == 0) {
            return 1;
        }

        int halfpow = optimizedPower(base, power / 2) * optimizedPower(base, power / 2);

        if (power % 2 == 0) {

            return halfpow;

        }

        return base * halfpow;

    }

    public static int tilingProblem(int n) {

        if (n == 0 || n == 1) {
            return 1;
        }

        int ways = tilingProblem(n - 1) + tilingProblem(n - 2);
        return ways;
    }

    public static void removeDulplicates(String str, StringBuilder sb, int index, boolean map[]) {

        if (index == str.length()) {
            System.out.print(sb);
            return;
        }

        char currentChar = str.charAt(index);

        if (map[currentChar - 'a']) {
            removeDulplicates(str, sb, index + 1, map);
        } else {
            sb.append(currentChar);
            map[currentChar - 'a'] = true;
            removeDulplicates(str, sb, index + 1, map);
        }
    }

    public static void main(String args[]) {
        // Scanner sc = new Scanner(System.in);
        // System.out.print("Enter number: ");
        // int n = sc.nextInt();
        // sc.close();
        // printDec(n);
        // printInc(n);
        // int fact = factorial(n);
        // System.out.println(fact);
        // int sum = printSum(n);
        // System.out.println(sum);
        // int fib = printNthFinonnaci(n - 1);
        // System.out.println(fib);
        // int arr[] = { 1, 5, 3, 4, 7 };
        // System.out.println(isSorted(arr, 0));
        // int arr[] = { 5, 4, 3, 5, 6, 8, 9, 12, 8, 16, 10 };

        // System.out.println(lastOccurrence(arr, 5, 0));
        // int base = 2;
        // int power = 5;
        // int calcPower = optimizedPower(base, power);
        // System.out.println(calcPower);

        // int floorLength = 6;
        // System.out.println(tilingProblem(floorLength));

        String dulpcation = "pratham";
        boolean map[] = new boolean[26];
        StringBuilder sb = new StringBuilder("");
        removeDulplicates(dulpcation, sb, 0, map);

    }
}