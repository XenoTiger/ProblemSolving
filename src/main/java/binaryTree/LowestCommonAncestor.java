package binaryTree;

public class LowestCommonAncestor {

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }

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

        TreeNode p = tree.search(tree.root, 70);
        TreeNode q = tree.search(tree.root, 80);

        System.out.println(lowestCommonAncestor(tree.root, p, q).data);
    }
}
