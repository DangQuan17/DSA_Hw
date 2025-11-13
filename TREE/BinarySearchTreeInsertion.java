import java.util.*;

class BSTNode {
    int data;
    BSTNode left;
    BSTNode right;

    BSTNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Solution2 {

    public static BSTNode insertIterative(BSTNode root, int data) {
        if (root == null) {
            return new BSTNode(data);
        }

        BSTNode current = root;
        BSTNode parent = null;

        while (current != null) {
            parent = current;
            if (data < current.data) {
                current = current.left;
            } else if (data > current.data) {
                current = current.right;
            } else {
                return root;
            }
        }

        BSTNode newNode = new BSTNode(data);

        if (data < parent.data) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }

        return root;
    }

    public static void inorder(BSTNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
}

public class BinarySearchTreeInsertion {

    public static void main(String[] args) {
        BSTNode root = new BSTNode(4);
        root.left = new BSTNode(2);
        root.right = new BSTNode(7);
        root.left.left = new BSTNode(1);
        root.left.right = new BSTNode(3);

        root = Solution2.insertIterative(root, 6);
        root = Solution2.insertIterative(root, 9);

        Solution2.inorder(root);
        System.out.println();
    }
}