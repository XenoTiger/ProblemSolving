package binaryTree;

public class HeightOfBinaryTree {

    private static int maxDepthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepthOfBinaryTree(root.left), maxDepthOfBinaryTree(root.right));
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.add(50);
        tree.add(30);
        tree.add(70);
        tree.add(20);
        tree.add(40);
        tree.add(60);
        tree.add(80);

        System.out.println("In-order traversal of the tree:");
        tree.inorder(tree.root);

        System.out.println();

        System.out.println("Maximum Height : " + maxDepthOfBinaryTree(tree.root));
    }
}
