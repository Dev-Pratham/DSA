public class QueueJ3 {

    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head;
    public Node tail;
    public int size;

    // This performs inserting in queue
    public void addLast(int data) {

        // create a new node
        Node newNode = new Node(data);

        // If it is the first node
        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }

        tail.next = newNode;
        tail = newNode;
        size++;
        return;

    }

    // remove from queue
    public void remove() {
        // if no element exists in queue
        if (head == null) {
            System.out.println("Queue is empty");
            return;
        }

        // if just one element exists
        if (head == tail) {
            head = tail = null;
            size--;
            return;
        }

        head = head.next;
        size--;
        return;
    }

    // peek operation
    public int peek() {
        if (head == null) {
            System.out.println("Queue is empty");
            return -1;
        }

        return head.data;

    }

    public void printQueue() {

        Node temp = head;

        if (temp == null) {
            System.out.println("Queue is empty");
            return;
        }

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String args[]) {

        QueueJ3 q = new QueueJ3();
        q.addLast(10);
        q.addLast(20);
        q.addLast(30);

        q.printQueue();
    }
}
