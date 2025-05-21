package binaryTree;

public class MirrorBinaryTree {

    private static TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        mirrorTree(root.left);
        mirrorTree(root.right);

        return root;
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

        System.out.println("Level-order traversal of the tree:");
        System.out.println(tree.levelOrder(tree.root));

        System.out.println();

        tree.root = mirrorTree(tree.root);
        System.out.println(tree.levelOrder(tree.root));
    }
}
