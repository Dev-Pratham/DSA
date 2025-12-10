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

    public void addFirst(int data) {
        // create a new node
        Node newNode = new Node(data);
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

    public void addLast(int data) {

        Node newNode = new Node(data);
        // This case checks whether the linklist is empty or what
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
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
        L1.addFirst(10);
        L1.addFirst(20);
        L1.addFirst(30);
        L1.addFirst(40);

        // Node temp = head;
        // while (temp != null) {
        // System.out.println(temp.data + "");
        // temp = temp.next;
        // }

        LinkedList.printLinkedList(head);

    }
}
