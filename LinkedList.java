public class LinkedList {

    // linked list mein har ek list ek node hota hai jisme data aur next node ka
    // reference hota hai
    // and java mein hum reference variable classes ke through bana sakte hain
    public static class Node {
        // considering data ek integer valuye hai
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            // assuming that there is no next node in the begining
            // this is assumption which is universally true.
            this.next = null;
        }

    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        // create a new node
        Node newNode = new Node(data);
        size++;
        // if linked list is empty
        if (head == null) {
            head = tail = newNode;
            return;
        }
        // assign head to next of newnode
        newNode.next = head;
        // update the head to newnode
        head = newNode;
    }

    public void add(int index, int data) {

        // if index is zero we simply perform addfirst
        size++;

        if (index == 0) {
            addFirst(data);
            return;
        }

        Node temp = head;
        int i = 0;
        while (i < index - 1) {
            temp = temp.next;
            i++;
        }
        Node tempNext = temp.next;
        Node newNode = new Node(data);
        temp.next = newNode;
        newNode.next = tempNext;

    }

    public void addLast(int data) {

        Node newNode = new Node(data);
        size++;
        // This case checks whether the linklist is empty or what
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void delFirst() {

        if (size == 0) {
            System.out.println("Link list is empty");
            return;
        }
        if (size == 1) {
            head = tail = null;
            size--;
            return;
        }

        head = head.next;
        size--;
        return;
    }

    public void delLast() {
        // edge cases
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

        temp.next = null;
        tail = temp;
        return;

    }

    public int Search(int key, Node head) {

        int i = 0;
        Node temp = head;
        // can iterate either using size or null using size for simplicity
        while (i < size - 1) {
            // search for key
            if (temp.data == key) {
                return (i + 1);
            }
            temp = temp.next;
            i++;
        }

        return -1;
    }

    public int RecursiveSearch(int key, Node head, int i) {

        // base case
        if (head == null) {
            System.out.println("No key found");
            return -1;
        }

        if (head.data == key) {
            return (i + 1);
        }

        return RecursiveSearch(key, head.next, i + 1);

    }

    public void reverseList() {

        Node prev = null;
        Node curr = tail = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static void printLinkedList(Node l) {
        // we just need head to iterate through linkedlist and a temporary variable
        if (head == null) {
            System.out.println("LinkList is empty");
        }

        Node temp = l;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }

    }

    public static void main(String args[]) {

        // inside the same file these 3 lines are same but outside the file we have to
        // use
        // full path of the class
        // LinkedList.head = new Node(10);
        // LinkedList.head.next = new Node(20);
        // LinkedList.head.next.next = new Node(30);
        // LinkedList.tail = LinkedList.head.next.next;

        // The Problem with the above apprach was the chain structure formed from using
        // next several time and was
        // confusing so we created seperate add function for that

        LinkedList L1 = new LinkedList();
        L1.addFirst(50);
        L1.addFirst(40);
        L1.addFirst(20);
        L1.addFirst(10);

        // Node temp = head;
        // while (temp != null) {
        // System.out.println(temp.data + "");
        // temp = temp.next;
        // }

        // LinkedList.printLinkedList(head);
        L1.add(2, 30);
        // LinkedList.printLinkedList(head);
        // System.out.println(size);

        // L1.delLast();
        LinkedList.printLinkedList(head);

        System.out.println(L1.Search(30, head));
        System.out.println(L1.RecursiveSearch(30, head, 0));

        L1.reverseList();
        LinkedList.printLinkedList(head);

    }
}
