package binaryTree;

public class DiameterOfBinaryTree {

    static int diameter = 0;

    private static int diameterOfBinaryTree(TreeNode root) {
        calculateHeight(root);
        return diameter;
    }

    public static int calculateHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lh = calculateHeight(root.left);
        int rh = calculateHeight(root.right);

        diameter = Math.max(lh + rh, diameter);
        return 1 + Math.max(lh, rh);
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

        System.out.println("Diameter of tree is: " + diameterOfBinaryTree(tree.root));
    }
}
