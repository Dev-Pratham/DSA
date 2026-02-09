import java.util.Deque;
import java.util.LinkedList;

// Basically we are implementing stack using deque
public class QueueJ6 {

    public static class Stack {

        Deque<Integer> dq = new LinkedList<>();

        void push(int data) {

            dq.addLast(data);
            return;
        }

        int pop() {
            if (dq.isEmpty()) {
                System.out.println("Stack is Empty");
                return -1;
            }

            return dq.removeLast();
        }

        int peek() {

            if (dq.isEmpty()) {
                System.out.println("Stack is Empty");
                return -1;
            }

            return dq.getLast();

        }

        boolean isEmpty() {

            return dq.isEmpty();
        }

    }

    public static void main(String args[]) {

        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(30);

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }

    }
}
