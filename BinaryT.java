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

    public static boolean checkStructure(Node root, Node sub) {

        // check structure checks for non identical cases
        if (root == null && sub == null) {
            return true;
        }

        if (root == null || sub == null) {
            return false;
        }

        if (root.data != sub.data) {
            return false;
        }

        boolean left = checkStructure(root.left, sub.left);
        boolean right = checkStructure(root.right, sub.right);

        return left && right;

    }

    public static boolean isSubtree(Node root, Node sub) {

        // preorder Traversal
        if (root == null) {
            return false;
        }

        if (root.data == sub.data) {
            if (checkStructure(root, sub)) {
                return true;
            }
        }

        // for iteratively checking left and right child
        boolean left = isSubtree(root.left, sub);
        boolean right = isSubtree(root.right, sub);
        return left || right;

    }

    public static int diameter(Node root) {

        if (root == null) {
            return 0;
        }

        // to solve this problem we need to use height of tree
        int leftheight = heightBinaryTree(root.left);
        int rightHeight = heightBinaryTree(root.right);
        int d = leftheight + rightHeight + 1;

        // left subtree height calculation
        int leftdia = heightBinaryTree(root.left.left) + heightBinaryTree(root.right.right) + 1;
        int rightdia = heightBinaryTree(root.right.left) + heightBinaryTree(root.right.right) + 1;

        if (d > rightdia && d > rightdia) {
            return d;
        } else if (rightdia > d && rightdia > d) {
            return rightdia;
        }

        return leftdia;

    }

    public static int diameter2(Node root) {
        if (root == null) {
            return 0;
        }

        int leftdia = diameter2(root.left);
        int leftheight = heightBinaryTree(root.left);
        int rightdia = diameter2(root.right);
        int rightheight = heightBinaryTree(root.right);

        int self = leftheight + rightheight + 1;

        return Math.max(self, Math.max(rightdia, leftdia));
    }

    static class DiaPair {
        int dia;
        int height;

        DiaPair(int dia, int ht) {
            this.dia = dia;
            this.height = ht;
        }
    }

    // time complexity 0(n) because we are calculating diameter and height in one
    // function so we are not doing repeated work of calculating height again and
    // again for each node
    public static DiaPair diameter3(Node root) {
        if (root == null) {
            return new DiaPair(0, 0);
        }

        DiaPair leftinfo = diameter3(root.left);
        DiaPair rightinfo = diameter3(root.right);

        int dia = Math.max(leftinfo.height + rightinfo.height + 1, Math.max(leftinfo.dia, rightinfo.dia));
        int height = Math.max(leftinfo.height, rightinfo.height) + 1;

        return new DiaPair(dia, height);

    }

    public static void main(String args[]) {

        int node[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        int node2[] = { 2, 4, -1, -1, 5, -1, -1 };
        Node root = BinaryTree.buildTree(node);
        BinaryTree.index = -1;
        Node subRoot = BinaryTree.buildTree(node2);
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

        // isSubtree
        // System.out.println(isSubtree(root, subRoot));

        // diameter 0(n^2) because we are calculating height for each node and height is
        // 0(n) so n*n = n^2
        System.out.println(diameter2(root));
        // 0(N)
        System.out.println(diameter3(root).dia);
    }
}
