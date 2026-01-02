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

    public static void main(String args[]) {

        // Stack<Integer> s = new Stack<>();
        // s.push(10);
        // s.push(20);
        // s.push(30);
        // s.push(50);
        // addBottom2(40, s);
        // System.out.println(s);

        // reverse string using stringbuilder
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your string to be reversed : ");
        StringBuilder sb = new StringBuilder(sc.nextLine());
        sc.close();

        reverseString(sb);
        System.out.println(sb);

    }
}
