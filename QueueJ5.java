import java.util.Stack;

//implemented queue using 2 stacks
public class QueueJ5 {

    public static class Queue {

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        void add(int data) {

            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            s1.push(data);

            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        int remove() {

            if (s1.isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            return s1.pop();
        }

        int peek() {
            if (s1.isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            return s1.peek();

        }

        void printQueue() {
            if (s1.isEmpty()) {
                System.out.println("Queue is empty");
                return;
            }

            for (int i = s1.size() - 1; i >= 0; i--) {
                System.out.println(s1.get(i) + " ");
            }

            return;
        }

    }

    public static void main(String args[]) {

        Queue q = new Queue();
        q.add(10);
        q.add(20);
        q.add(30);
        q.printQueue();
    }
}
