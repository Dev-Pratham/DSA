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

    public static int friendsPair(int n) {

        if (n == 1 || n == 2) {
            return n;
        }

        int totalways = friendsPair(n - 1) + (n - 1) * friendsPair(n - 2);
        return totalways;

    }

    public static String binaryString(String str, int index) {

        if (index == str.length()) {
            return str;
        }

        char one = '1';

        if (str.charAt(index) == one && str.charAt(index + 1) == one) {
            return "contains consecutive one";
        }

        return binaryString(str, index + 1);
    }

    public static void printBs(int n, String srt, int lastPlace) {

        if (n == 0) {
            System.out.println(srt);
            return;
        }

        String newStr = srt;
        if (lastPlace == 0) {
            printBs(n - 1, newStr + 0, 0);
            printBs(n - 1, newStr + 1, 1);

        } else {
            printBs(n - 1, newStr + 0, 0);
        }
    }

    public static void q1(int arr[], int key, int index) {

        if (index == arr.length) {
            System.out.print("\n" + "Completed traversing the array");
            return;
        }

        if (arr[index] == key) {
            System.out.print(index + " ");
        }

        q1(arr, key, index + 1);

    }

    public static void q2(int n) {

        if (n == 0) {
            return;
        }
        q2(n / 10);

        String letter = "Invalid argument passed";
        switch (n % 10) {

            case 0:
                letter = "zero";

                break;
            case 1:
                letter = "one";

                break;
            case 2:
                letter = "two";

                break;
            case 3:
                letter = "three";

                break;
            case 4:
                letter = "four";

                break;
            case 5:
                letter = "five";

                break;
            case 6:
                letter = "six";

                break;
            case 7:
                letter = "seven";

                break;
            case 8:
                letter = "eight";

                break;

            case 9:
                letter = "nine";
                break;
        }

        System.out.print(letter + " ");

    }

    public static int stringLength(String str) {

        int length = 0;

        while (true) {

            try {
                char ch = str.charAt(length);
                length++;
            } catch (Exception e) {
                break;
            }
        }
        return length;
    }

    public static int stringLength2(String str, int index) {

        if (index == stringLength(str)) {
            return 0;
        }

        return 1 + stringLength2(str, index + 1);

    }

    public static int q3(String str, int index, int length) {

        if (index == stringLength(str)) {

            return length;

        }

        char ch = str.charAt(index);

        return 0;

    }

    public static int countSubStr(String str, int start, int end) {

        if (start > end) {
            return 0;
        }

        int count = 0;
        for (int i = start; i < end; i++) {

            if (str.charAt(start) == str.charAt(i)) {
                count++;
            }
        }

        int sum = count + countSubStr(str, start + 1, end);
        return sum;

    }

    public static void towerOfHanoi(int n, char src, char des, char helper) {

        if (n == 1) {
            System.out.println("Move" + n + "from " + src + " To " + des);
            return;
        }

        towerOfHanoi(n - 1, src, helper, des);
        System.out.println("Move" + n + "from " + src + " To " + des);
        towerOfHanoi(n - 1, helper, des, src);

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

        // String dulpcation = "pratham";
        // boolean map[] = new boolean[26];
        // StringBuilder sb = new StringBuilder("");
        // removeDulplicates(dulpcation, sb, 0, map);

        // System.out.println(friendsPair(4));

        // printBs(3, "", 0);

        // int arr[] = { 2, 3, 4, 2, 3, 4, 2, 4, 5, 6, 6, 6, 7, 8, 9, 7 };
        // q1(arr, 6, 0);
        // q2(1250);

        // String name = "abcab";
        // System.out.println(countSubStr(name, 0, 5));

        towerOfHanoi(3, 'A', 'B', 'C');

    }
}