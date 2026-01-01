public class StackBasics2 {

    // Simple thing to remember top of stack is head of
    // linked list
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class Stack {

        Node head = null;

        // isEmpty
        public boolean isEmpty() {
            return head == null;
        }

        // push
        public void push(int data) {

            Node newNode = new Node(data);

            if (head == null) {
                head = newNode;
                return;
            }

            // head is the top of stack in linklist stack implementation
            newNode.next = head;
            head = newNode;
            return;

        }

        // pop
        public int pop() {

            if (head == null) {
                return -1;
            }

            Node temp = head;
            head = head.next;
            return temp.data;

        }

        // peek
        public int peek() {

            if (head == null) {
                return -1;
            }

            return head.data;
        }

    }

    public static void main(String args[]) {

        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }

    }
}
