import java.util.Queue;
import java.util.Stack;
import java.util.HashMap;
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

    public static int sumNodes(Node root) {
        if (root == null) {
            return 0;
        }

        int leftSum = sumNodes(root.left);
        int rightSum = sumNodes(root.right);

        return leftSum + rightSum + root.data;
    }

    // this is the top view of binary tree this is wrong
    public static void topViewHelper(Node root, Node root2) {

        Stack<Node> s = new Stack<>();

        while (root2 != null) {
            if (root2.left != null) {
                s.push(root2.left);
            }
            root2 = root2.left;
        }

        while (!s.isEmpty()) {
            System.out.print(s.pop().data);
        }

        while (root != null) {
            System.out.print(root.data);
            root = root.right;
        }

    }

    // this is wrong
    public static void topView(Node root) {
        topViewHelper(root, root);
    }

    // Since node will also contain their horizontal distance
    public static class Info {
        Node node;
        int hd;

        Info(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }

    }

    // here we are using level order traversal and horizontal distance concept to
    // get the top view of binary tree
    public static void topView2(Node root) {

        // level order traversal because
        // we are using horizontal distance concept
        Queue<Info> q = new LinkedList<>();
        // as per level order traversal
        // we need to add root and null
        q.add(new Info(root, 0));
        q.add(null);
        // for adding nodes with unique distance we need hashmap ds
        HashMap<Integer, Node> map = new HashMap<>();

        // min and max for iternating the hashmap
        // initialized with zero because we are starting with root node
        // and root node has horizontal distance of zero
        int min = 0;
        int max = 0;

        while (!q.isEmpty()) {
            Info curr = q.remove();

            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                }
            } else {
                // we simply check the hashmap whether the distance exists in hashmap or not if
                // not we add simply
                if (!map.containsKey(curr.hd)) {
                    map.put(curr.hd, curr.node);
                }

                // inserting left children and right children if its not null
                if (curr.node.left != null) {
                    q.add(new Info(curr.node.left, curr.hd - 1));

                    if (min > curr.hd - 1) {
                        min = curr.hd - 1;
                    }
                }
                if (curr.node.right != null) {
                    q.add(new Info(curr.node.right, curr.hd + 1));

                    if (max < curr.hd + 1) {
                        max = curr.hd + 1;
                    }
                }

            }
        }
        // printing top view
        for (int i = min; i <= max; i++) {
            // get(i) will return the node and we need data so
            System.out.print(map.get(i).data + " ");
        }

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
        // int res2 = countNodes(root);
        // System.out.println(res2);

        // topView2(root);
    }
}
