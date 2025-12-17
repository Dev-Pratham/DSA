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
    public Node findMid(Node hea) {

        Node slow = hea;
        // this gives mid of first half last node
        Node fast = hea.next;

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

        Node mid = findMid(head);
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

    public Node merge(Node head1, Node head2) {

        Node temp = new Node(-1);
        Node mergedll = temp;

        while (head1 != null && head2 != null) {

            if (head1.data < head2.data) {
                temp.next = head1;
                head1 = head1.next;

            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;

        }

        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        // returning to remove -1
        return mergedll.next;

    }

    public Node mergeSort(Node head) {
        // base case when head is a single we return it
        if (head == null || head.next == null) {
            return head;
        }

        Node left = head;
        Node mid = findMid(head);
        Node right = mid.next;
        mid.next = null;

        Node newLeft = mergeSort(left);
        Node newRight = mergeSort(right);

        return merge(newLeft, newRight);

    }

    // This approach uses floyeds algo
    // similar to 2 pointer approach
    public static boolean detectCycle(Node head) {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
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

        // // zig-zag caller
        // l.zigZag();
        // l.print();
        // System.out.println(l);

        // This part is for mergesort
        l.head = l.mergeSort(l.head);
        l.print();

        // This part is for detecting cycles
        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = head2;
        System.out.println(detectCycle(head2));

    }

}
