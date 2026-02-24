import java.util.Queue;
import java.util.LinkedList;

public class BinaryT {

    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class BinaryTree {
        // this index tracks the index of the given arrat of node
        static int index = -1;

        // this is preorder
        public static Node buildTree(int node[]) {
            index++;

            if (index >= node.length || node[index] == -1) {
                return null;
            }

            Node newNode = new Node(node[index]);
            newNode.left = buildTree(node);
            newNode.right = buildTree(node);

            return newNode;

        }

        public static void printPreOrder(Node root) {

            if (root == null) {
                return;
            }

            System.out.println(root.data);
            printPreOrder(root.left);
            printPreOrder(root.right);
        }

        public static void printInOrder(Node root) {

            if (root == null) {
                return;
            }

            printInOrder(root.left);
            System.out.println(root.data);
            printInOrder(root.right);

        }

        // This is like bfs this was implemented using queue data structure
        public static void levelOrder(Node root) {

            Queue<Node> q = new LinkedList<Node>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node rem = q.remove();
                if (rem != null) {
                    System.out.print(rem.data + " ");
                    if (rem.left != null) {
                        q.add(rem.left);
                    }
                    if (rem.right != null) {
                        q.add(rem.right);
                    }

                } else {
                    // if next node is also null
                    Node next = q.peek();
                    if (next == rem) {
                        break;
                    }
                    System.out.println();
                    q.add(null);
                }

            }

        }

        public static void postOrder(Node root) {
            if (root == null) {
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.data);
        }

    }

    // main objective was to get the height of binary tree to 3 node height re
    public static int heightBinaryTree(Node root) {

        if (root == null) {
            return 0;
        }
        int leftHeight = heightBinaryTree(root.left);
        int rightHeight = heightBinaryTree(root.right);

        if (leftHeight > rightHeight) {
            return leftHeight + 1;
        } else {
            return rightHeight + 1;
        }

    }

    public static int countNodes(Node root) {

        if (root == null) {
            return 0;
        }

        int leftChild = countNodes(root.left);
        int rightChild = countNodes(root.right);

        return leftChild + rightChild + 1;

    }

    public static void main(String args[]) {

        int node[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, 5 };
        Node root = BinaryTree.buildTree(node);
        // System.out.println(root.data);
        // System.out.println(root.left.data);
        // System.out.println(root.right.data);

        // levelorder
        // BinaryTree.levelOrder(root);

        // height of binary tree(node height)
        // int res = heightBinaryTree(root);
        // System.out.println(res);

        // count nodes
        int res2 = countNodes(root);
        System.out.println(res2);
    }
}
