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
        l.addFirst(10);
        l.addFirst(20);
        l.addFirst(30);
        l.print();
    }

}
