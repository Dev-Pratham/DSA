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

    public static int[] nxtGreaterElement(int arr[]) {

        int out[] = new int[arr.length];
        Stack<Integer> s = new Stack<>();
        s.push(0);
        int j = 0;
        int k;

        for (int i = 1; i < arr.length; i++) {
            k = i;
            while (s.peek() != arr.length - 1) {
                s.push(k);
                if (arr[s.peek()] > arr[j]) {
                    out[j] = arr[s.peek()];
                    j++;
                    break;
                } else {
                    k++;
                }
            }
            if (s.peek() == arr.length - 1) {
                out[j] = -1;
                j++;
            }
        }

        return out;
    }

    public static void prinArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
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
        int arr[] = { 6, 8, 0, 1, 3 };
        int res[] = nxtGreaterElement(arr);
        prinArr(res);

    }
}
