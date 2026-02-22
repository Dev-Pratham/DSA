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

            if (node[index] == -1) {
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

        // This is like bfs
        public static void levelOrder(Node root) {

            Queue<Node> q = new LinkedList<Node>();
            q.add(root);

            while (!q.isEmpty()) {
                Node rem = q.remove();
                System.out.println(rem.data);
                if (rem.left != null) {
                    q.add(rem.left);
                }
                if (rem.right != null) {
                    q.add(rem.right);
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

    public static void main(String args[]) {

        int node[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Node root = BinaryTree.buildTree(node);
        // System.out.println(root.data);
        // System.out.println(root.left.data);
        // System.out.println(root.right.data);

        // levelorder
        // BinaryTree.levelOrder(root);

    }
}
