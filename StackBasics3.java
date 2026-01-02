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
    // and has space complexity of 0(1)
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

    public static void main(String args[]) {

        Stack<Integer> s = new Stack<>();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(50);
        addBottom2(40, s);
        System.out.println(s);
    }
}
