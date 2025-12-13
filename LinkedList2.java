public class LinkedList2 {

    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {

        Node newNode = new Node(data);
        size++;
        // if Head is null
        if (head == null) {
            head = tail = newNode;
            tail.next = head;
            return;
        }
        newNode.next = head;
        head = newNode;
        tail.next = head;
    }

    public void add(int index, int data) {

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        // if index is zero we simply perform addfirst
        if (index == 0) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;
        int i = 0;
        while (i < index - 1) {
            temp = temp.next;
            i++;
        }
        // we are adding at the last index so we need to update tail
        if (temp == tail) {
            tail = newNode;
        }
        Node tempNext = temp.next;
        temp.next = newNode;
        newNode.next = tempNext;
        size++;

    }

    public void display(Node head) {

        if (size == 0) {
            System.out.println("Circular ll is empty");
            return;
        }
        Node temp = head;

        do {
            System.out.println(temp.data);
            temp = temp.next;
        } while (temp != head);

        System.out.println("Reached at head again");
    }

    public static void main(String args[]) {

    }
}
