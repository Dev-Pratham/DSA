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

    }
}
