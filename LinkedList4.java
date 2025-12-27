
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
    // bruteforce appraoch
    public static int getLinkNode(LinkedList4 l1, LinkedList4 l2) {

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

    public static Node getLinkNode2(LinkedList4 l1, LinkedList4 l2) {
        // This is 2 pointer approach

        // Idea (simple words)

        // Use two pointers, one for each list
        // When a pointer reaches the end of a list, jump it to the head of the other
        // list
        // If the lists intersect, the pointers will meet at the merge node
        // If not, both will become null at the same tim

        Node p1 = l1.head;
        Node p2 = l2.head;

        while (p1 != p2) {
            p1 = (p1 != null) ? p1.next : l2.head;
            p2 = (p2 != null) ? p2.next : l1.head;
        }

        return p1;

    }

    // delete n nodes after travelling m nodes
    public void delMN(int m, int n, Node tem) {

        if (tem == null || m <= 0 || n <= 0)
            return;

        Node temp = tem;

        // Move to m-th node
        for (int i = 1; i < m && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null)
            return;

        Node temp2 = temp.next;

        // Delete n nodes
        for (int j = 0; j < n && temp2 != null; j++) {
            temp2 = temp2.next;
        }

        temp.next = temp2;

        // Recurse for remaining list
        delMN(m, n, temp);
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
        l1.addLast(8);
        l1.addLast(9);
        l1.addLast(10);

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

        System.out.println("Merging Node:" + getLinkNode(l1, l2));

        l1.delMN(2, 2, l1.head);
        l1.printLinkedList();

    }
}
