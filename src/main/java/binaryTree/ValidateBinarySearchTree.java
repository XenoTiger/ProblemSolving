package binaryTree;

public class ValidateBinarySearchTree {

    private static boolean validateBST(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }

        if (root.data >= max || root.data <= min) {
            return false;
        }

        return validateBST(root.left, min, root.data)
                && validateBST(root.right, root.data, max);
    }

    private static boolean isValidBST(TreeNode root) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        return validateBST(root, min, max);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.add(10);
        tree.add(20);
        tree.add(30);

        System.out.println("In-order traversal of the tree:");
        tree.inorder(tree.root);

        System.out.println();
        System.out.println(isValidBST(tree.root));
    }
}
