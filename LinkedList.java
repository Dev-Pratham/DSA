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

    public static void main(String args[]) {

        // inside the same file these 3 lines are same but outside the file we have to
        // use
        // full path of the class
        LinkedList.Node obj = new LinkedList.Node(10);
        Node obj2 = new LinkedList.Node(10);
        Node obj3 = new Node(10);

    }
}
