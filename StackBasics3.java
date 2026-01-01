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

    public static void main(String args[]) {

        Stack<Integer> s = new Stack<>();
        s.push(10);
        s.push(20);
        s.push(30);
        addBottom(40, s);
        System.out.println(s);
    }
}
