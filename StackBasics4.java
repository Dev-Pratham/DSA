import java.util.LinkedList;
import java.util.Queue;

public class StackBasics4 {

    // implementation of stack using 2 queus

    public static class Stack {

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        Queue<Integer> temp = new LinkedList<>();

        void push(int data) {
            // move data to queue 2
            q2.add(data);
            // move all elements from queue 1 to queue 2
            while (!q1.isEmpty()) {
                q2.add(q1.remove());
            }
            // swap queue 1 and queue 2
            temp = q2;
            q2 = q1;
            q1 = temp;
            return;

        }

        int pop() {

            if (q1.isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }

            return q1.remove();
        }

        int peek() {

            if (q1.isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }
            return q1.peek();
        }

        void print() {
            if (q1.isEmpty()) {
                System.out.println("Stack is empty");
                return;
            }

            temp = q1;

            while (!temp.isEmpty()) {
                System.out.println(temp.remove());
            }
        }

    }

    public static void main(String args[]) {

        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(30);
        s.print();

    }
}
