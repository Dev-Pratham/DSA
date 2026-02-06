import java.sql.Array;
import java.util.Scanner;
import java.util.Stack;

public class StackBasics3 {

    public static void addBottom(int data, Stack<Integer> passed) {

        // Stack<Integer> temp = passed;
        Stack<Integer> temp2 = new Stack<>();

        while (!passed.isEmpty()) {
            temp2.push(passed.pop());
        }

        passed.push(data);
        while (!temp2.isEmpty()) {
            passed.push(temp2.pop());
        }

    }

    // This approach uses recursion
    // and without creating extra stack
    public static void addBottom2(int data, Stack<Integer> s) {

        if (s.isEmpty()) {
            s.push(data);
            return;
        }

        s.pop();
        addBottom(data, s);
        int top = s.peek();
        s.push(top);

    }

    // reverse a string from using stack
    public static void reverseString(StringBuilder sb) {

        Stack<Character> s = new Stack<>();

        // push elements into stack does the reversing thing
        for (int i = 0; i < sb.length(); i++) {
            s.push(sb.charAt(i));
        }

        // remove all from sb
        sb.setLength(0);

        // save from stack to stringbuilder
        while (!s.isEmpty()) {
            sb.append(s.pop());
        }
    }

    // reverse a stack
    public static void reverseStack(Stack<Integer> s) {
        // base case is reached when stack becomes empty
        if (s.isEmpty()) {
            return;
        }

        int top = s.pop();
        reverseStack(s);
        // simply add bottom will do the job
        addBottom(top, s);
    }

    // stock span function returning array of span
    public static int[] stockSpan(int stock[]) {

        int span[] = new int[stock.length];
        Stack<Integer> s = new Stack<>();

        s.push(0);
        span[0] = 1;
        for (int i = 1; i < stock.length; i++) {

            // pop while the current price is higher than in stack
            while (!s.isEmpty() && stock[s.peek()] <= stock[i]) {
                s.pop();
            }

            // pop kerte kerte agar empty hogya this means all the elemnts
            // are smaller than the current price so in that case index+1
            if (s.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - s.peek();
            }
            s.push(i);

        }

        return span;

    }

    // complex problem watch vid if req
    public static int[] nxtGreaterElement(int arr[]) {

        int n = arr.length;
        int out[] = new int[arr.length];
        Stack<Integer> s = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!s.isEmpty() && arr[s.peek()] < arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                out[i] = -1;
            } else {
                out[i] = arr[s.peek()];
            }

            s.push(i);
        }

        return out;

    }

    public static int[] test2(int arr[]) {
        int n = arr.length;
        int out[] = new int[arr.length];
        Stack<Integer> s = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            if (s.isEmpty()) {
                out[i] = -1;
                s.push(arr[i]);
                continue;
            }

            if (arr[i] < s.peek()) {
                out[i] = s.peek();
                s.push(arr[i]);
            } else {
                while (!s.isEmpty() && s.peek() < arr[i]) {
                    s.pop();
                }
                if (s.isEmpty()) {
                    out[i] = -1;
                } else {

                    out[i] = s.peek();
                }
                s.push(arr[i]);
            }

        }

        return out;
    }

    public static boolean isOpen(char c) {

        if (c == '(' || c == '{' || c == '[') {
            return true;
        }

        return false;
    }

    public static boolean isPair(char c1, char c2) {

        if (c1 == '{' && c2 == '}') {
            return true;
        }
        if (c1 == '(' && c2 == ')') {
            return true;
        }
        if (c1 == '[' && c2 == ']') {
            return true;
        }

        return false;
    }

    public static boolean isValidParenthesis(String s) {

        Stack<Character> cstack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (isOpen(s.charAt(i))) {
                cstack.push(s.charAt(i));
            } else {
                if (isPair(cstack.peek(), s.charAt(i))) {
                    cstack.pop();
                } else {
                    return false;
                }
            }
        }

        if (!cstack.isEmpty()) {
            return false;
        }
        return true;
    }

    public static void prinArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static boolean isClosing(char ch) {

        if (ch == ')' || ch == '}' || ch == ']') {
            return true;
        }

        return false;
    }

    // duplicate parenthesis
    public static boolean isDuplicate(String w) {

        Stack<Character> s = new Stack<>();
        for (int i = 0; i < w.length(); i++) {

            if (!isClosing(w.charAt(i))) {
                s.push(w.charAt(i));
            } else {
                int count = 0;
                while (!s.isEmpty() && s.peek() != w.charAt(i)) {
                    count++;
                    s.pop();
                }
                if (count < 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String args[]) {

        // Stack<Integer> s = new Stack<>();
        // s.push(10);
        // s.push(20);
        // s.push(30);
        // s.push(50);
        // addBottom2(40, s);
        // System.out.println(s);

        // reverse string using stringbuilder
        // Scanner sc = new Scanner(System.in);
        // System.out.print("Enter your string to be reversed : ");
        // StringBuilder sb = new StringBuilder(sc.nextLine());
        // sc.close();

        // reverseString(sb);
        // System.out.println(sb);

        // revese a stack using no extra memory
        // Stack<Integer> s = new Stack<>();
        // s.push(30);
        // s.push(20);
        // s.push(10);
        // reverseStack(s);
        // System.out.println(s);

        // stock span problem
        // int stocks[] = { 100, 80, 60, 70, 60, 85, 100 };
        // int res[] = stockSpan(stocks);
        // for (int i = 0; i < res.length; i++) {
        // System.out.print(res[i] + " ");
        // }

        // next greater element problem
        // int arr[] = { 6, 8, 0, 1, 3 };
        // int arr[] = { 4, 5, 2, 25 };
        // int res[] = test2(arr);
        // prinArr(res);

        // isvalid parentehsis
        // String w = "(({[]}()))";
        // System.out.println(isValidParenthesis(w));

        // isDuplicate
        String w = "(((a+b))+c)";
        String w2 = "(a+b)";
        System.out.println(isDuplicate(w));

    }
}
