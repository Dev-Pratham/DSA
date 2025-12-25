
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
    // This approach will not simply work incase of intersection
    // case in deepcopy we have to update the tail too
    // This apprach will not work with 2 pointers
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
        // here tail is also updating through addlast
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
        // Not updating tail so that we can use it for matching purpose
        // this.tail = l1.tail;
    }

    // This part is to detect the node where the linkage occours
    public static int getLinkIndex2(LinkedList4 l1, LinkedList4 l2) {

        Node head1 = l1.head;
        Node head2 = l2.head;

        if (l1.tail.next == null && l2.tail.next == null) {
            System.out.println("No link founds between 2 lists");
            return -1;
        }

        if (l1.tail.next != null && l2.tail.next != null) {
            // invalid case according to problem statement
            // both links are connected to one another invalid link
            return -1;
        }

        // if link2 is attached to link1
        while (head1 != null) {
            if (head1 == l2.tail.next) {
                return head1.data;
            }
            head1 = head1.next;
        }

        // if link1 is attached to link2
        while (head2 != null) {
            if (head2 == l1.tail.next) {
                return head2.data;
            }
            head2 = head2.next;
        }

        return -1;

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

        // This link is of deep copy with tail updation
        // l2.link(l1.head, 4);
        // This link is of shallow copy without tail updation
        l2.link2(l1, 4);
        l2.printLinkedList();

        System.out.println("Merging Node:" + getLinkIndex2(l1, l2));

    }
}
