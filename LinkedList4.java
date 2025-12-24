
//This portion of code is for questions mentioned in linked list
public class LinkedList4 {

    public class Node {
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

    public void addFirst(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }

        newNode.next = head;
        head = newNode;
        size++;
        return;

    }

    public void addLast(int data) {

        Node newNode = new Node(data);

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

    // This is my copy apporach used in real world approaches
    public void link(Node l1, int index) {

        int i = 0;
        Node temp = l1;
        Node prev = null;

        // reach to the prev node of l1
        while (i < index - 1 && temp != null) {
            temp = temp.next;
            i++;
        }

        if (temp == null) {
            return;
        }

        prev = temp;
        while (prev != null) {
            addLast(prev.data);
            prev = prev.next;
        }

        return;

    }

    // very good linkage
    public void link2(LinkedList4 l1, int index) {
        int i = 0;
        Node temp = l1.head;

        while (i < index - 1 && temp != null) {
            temp = temp.next;
            i++;
        }

        if (temp == null) {
            return;
        }

        this.tail.next = temp;
        this.tail = l1.tail;
    }

    public void printLinkedList() {

        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String args[]) {

        // Linked List 1
        LinkedList4 l1 = new LinkedList4();
        l1.addLast(1);
        l1.addLast(2);
        l1.addLast(3);
        l1.addLast(6);
        l1.addLast(7);

        // l1.printLinkedList();

        // Linked list 2
        LinkedList4 l2 = new LinkedList4();
        l2.addLast(4);
        l2.addLast(5);

        l2.link(l1.head, 4);

        l2.printLinkedList();

    }
}
