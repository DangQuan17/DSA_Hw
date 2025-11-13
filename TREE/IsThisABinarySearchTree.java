import java.util.*;

class SolutionBSTCheck {

    private static boolean check(Node node, int min, int max) {
        if (node == null) {
            return true;
        }

        if (node.data <= min || node.data >= max) {
            return false;
        }

        return check(node.left, min, node.data) &&
                check(node.right, node.data, max);
    }

    public static boolean checkBST(Node root) {
        return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}

public class IsThisABinarySearchTree {

    public static void main(String[] args) {
        Node rootValid = new Node(4);
        rootValid.left = new Node(2);
        rootValid.right = new Node(5);

        System.out.println(SolutionBSTCheck.checkBST(rootValid)); // true

        Node rootInvalid = new Node(4);
        rootInvalid.left = new Node(5);
        rootInvalid.right = new Node(2);

        System.out.println(SolutionBSTCheck.checkBST(rootInvalid)); // false
    }
}