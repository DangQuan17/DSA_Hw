import java.util.*;

class AVLNode {
    int data;
    AVLNode left;
    AVLNode right;
    int height; // Chiều cao của nút

    AVLNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.height = 0;
    }
}

class SolutionAVL {

    private static int getHeight(AVLNode node) {
        return (node == null) ? -1 : node.height;
    }

    private static int getBalance(AVLNode node) {
        return (node == null) ? 0 : getHeight(node.left) - getHeight(node.right);
    }

    private static void updateHeight(AVLNode node) {
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    private static AVLNode rotateRight(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        x.right = y;
        y.left = T2;

        updateHeight(y);
        updateHeight(x);

        return x;
    }

    private static AVLNode rotateLeft(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        y.left = x;
        x.right = T2;

        updateHeight(x);
        updateHeight(y);

        return y;
    }

    public static AVLNode insert(AVLNode node, int data) {
        if (node == null) {
            return new AVLNode(data);
        }

        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        } else {
            return node;
        }

        updateHeight(node);
        int balance = getBalance(node);

        // Left Left Case
        if (balance > 1 && data < node.left.data) {
            return rotateRight(node);
        }

        // Right Right Case
        if (balance < -1 && data > node.right.data) {
            return rotateLeft(node);
        }

        // Left Right Case
        if (balance > 1 && data > node.left.data) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // Right Left Case
        if (balance < -1 && data < node.right.data) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }
}

public class SelfBalancingTreeAVL {

    public static void main(String[] args) {
        AVLNode root = null;
        int[] values = {10, 20, 30, 40, 50, 25};

        for (int val : values) {
            root = SolutionAVL.insert(root, val);
        }

        System.out.println(root.data);
        System.out.println(root.height);
    }
}