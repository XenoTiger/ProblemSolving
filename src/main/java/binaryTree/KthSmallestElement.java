package binaryTree;

public class KthSmallestElement {

    private static int count = 0;
    private static int result = -1;

    private static int KthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    private static void inorder(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        inorder(root.left, k);

        count++;
        if (count == k) {
            result = root.data;
            return;
        }

        inorder(root.right, k);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.add(50);
        tree.add(30);
        tree.add(70);
        tree.add(10);
        tree.add(20);
        tree.add(40);
        tree.add(60);
        tree.add(80);

        System.out.println("In-order traversal of the tree:");
        tree.inorder(tree.root);
        System.out.println();

        int k = 5;
        System.out.println(k + "th Smallest element is: " + KthSmallest(tree.root, k));
    }
}
