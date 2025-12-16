public class LinkedList2 {
    // This code is for singly circular linked list
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

    public void addLast(int data) {

        Node newNode = new Node(data);
        size++;
        // This case checks whether the linklist is empty or what
        if (head == null) {
            head = tail = newNode;
            tail.next = head;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        tail.next = head;
    }

    public void delFirst() {

        if (size == 0) {
            System.out.println("Circular linked list is empty");
            return;
        }

        if (size == 1) {
            head = tail = null;
            size--;
            return;
        }

        head = head.next;
        tail.next = head;
        size--;
        return;

    }

    public void delLast() {
        if (size == 0) {
            System.out.println("ll is empty");
            return;
        }
        if (size == 1) {
            delFirst();
            return;
        }

        int i = 0;
        Node temp = head;
        while (i < size - 2) {
            temp = temp.next;
            i++;
        }

        temp.next = head;
        tail = temp;
        size--;
        return;
    }

    public void deleteNthNode(int n) {

        // edge cases
        if (size == 0) {
            System.out.println("Link list is empty");
            return;
        }
        if (size == n) {
            delFirst();
            return;
        }
        if (n == 1) {
            delLast();
            return;
        }
        if (size < n) {
            System.out.println("Size out of limit of link list");
            return;
        }

        int i = 0;
        Node temp = head;
        // reach the previous node
        while (i < size - n - 1) {
            temp = temp.next;
            i++;
        }

        Node delNode = temp.next;
        Node next = delNode.next;
        temp.next = next;
        size--;
        return;
    }

    public int Search(int key, Node head) {

        int i = 0;
        Node temp = head;
        // can iterate either using size or null using size for simplicity
        while (i < size) {
            // search for key
            if (temp.data == key) {
                return (i + 1);
            }
            temp = temp.next;
            i++;
        }

        return -1;
    }

    // another version using head pointer for iteration

    public int Search(int key) {
        Node temp = head;
        int i = 1;

        do {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        } while (temp != head);

        return -1;
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

        LinkedList2 l2 = new LinkedList2();
        l2.addFirst(10);
        l2.addFirst(20);
        l2.addFirst(30);
        l2.display(head);
    }
}
