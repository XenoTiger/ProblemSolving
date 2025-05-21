package binaryTree;


import java.util.*;

class TreeNode {

    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

}

public class BinaryTree {

    TreeNode root;

    public BinaryTree() {
        this.root = null;
    }

    public void add(int value) {
        root = insert(root, value);
    }

    private TreeNode insert(TreeNode root, int data) {
        if (root == null) {
            return new TreeNode(data);
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }

    public TreeNode search(TreeNode root, int value) {
        if (root == null || root.data == value) {
            return root;
        }
        if (value < root.data) {
            return search(root.left, value);
        } else {
            return search(root.right, value);
        }
    }

    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + "\t");
            inorder(root.right);
        }
    }

    public List<Integer> iterativeInorder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()){
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.data);
            curr = curr.right;
        }
        return res;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.data);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            ans.add(level);
        }
        return ans;
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
        System.out.println("Iterative inorder");
        System.out.println(tree.iterativeInorder(tree.root));
    }
}
