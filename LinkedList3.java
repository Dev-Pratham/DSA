public class LinkedList3 {
    // This file is for doubly linked list
    public static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }

        head.prev = newNode;
        newNode.next = head;
        head = newNode;
        size++;

    }

    public void remFirst() {

        if (head == null) {
            System.out.println("LL is empty");
            return;
        }

        // This is null pointer exception for below code
        if (size == 1) {
            head = tail = null;
            size--;
        }

        head = head.next;
        head.prev = null;
        size--;
        return;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            addFirst(data);
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;
        return;

    }

    public void remLast() {

        if (head == null) {
            System.out.println("Linked List is empty");
            return;
        }

        if (size == 1) {
            head = tail = null;
            size--;
            return;
        }

        Node prev = tail.prev;
        prev.next = null;
        tail = prev;
        size--;
        return;

    }

    public void reverse() {

        Node prev = null;
        Node curr = tail = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            // This is that extra line
            curr.prev = next;
            prev = curr;
            curr = next;
        }

        head = prev;

    }

    // Helper function for zig-zag using slow pointer approach
    public Node findMid() {

        Node slow = head;
        Node fast = head;

        // This condition is necessary
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // zig zag is operation for modifying the original linked list itself not about
    // just printing it
    public void zigZag() {

        Node mid = findMid();
        Node prev = null;
        Node curr = mid.next;
        mid.next = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node Left = head;
        Node Right = prev;

        while (Left != null && Right != null) {

            Node lnext = Left.next;
            Left.next = Right;
            Node rnext = Right.next;
            Right.next = lnext;
            Left = lnext;
            Right = rnext;
        }

    }

    public void print() {

        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("null");
        }
    }

    public static void main(String args[]) {

        LinkedList3 l = new LinkedList3();
        l.addLast(1);
        l.addLast(2);
        l.addLast(3);
        l.addLast(4);
        l.addLast(5);
        l.addLast(6);
        l.addLast(7);
        // l.print();

        // zig-zag caller
        l.zigZag();
        l.print();
        System.out.println(l.tail);

    }

}
