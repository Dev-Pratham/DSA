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

    // implemented queue using deque
    public static class Queue {

        Deque<Integer> dq = new LinkedList<>();

        void add(int data) {
            dq.addLast(data);
        }

        int remove() {
            if (dq.isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }

            return dq.removeFirst();
        }

        int peek() {
            if (dq.isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }

            return dq.getFirst();
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

        Queue q = new Queue();
        q.add(10);
        q.add(20);
        q.add(30);

        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }

    }
}
