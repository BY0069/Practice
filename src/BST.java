public class BST {
    private TreeNode root;

    public void PreOrder(TreeNode root) {
        if (root == null) return;
        System.out.println(root.data);
        PreOrder(root.left);
        PreOrder(root.right);
    }

    public void InOrder(TreeNode root) {
        if (root == null) return;
        InOrder(root.left);
        System.out.println(root.data);
        InOrder(root.right);
    }

    public void PostOrder(TreeNode root) {
        if (root == null) return;
        PostOrder(root.left);
        PostOrder(root.right);
        System.out.println(root.data);
    }

    public void AddNode(TreeNode root, int elem) {
        TreeNode node = new TreeNode(elem);
        if (root == null) root = node;
        else {
            if (elem < root.data) AddNode(root.left, elem);
            if (elem >= root.data) AddNode(root.right, elem);
        }
    }

    public void DeleteNode(int elem) {
        TreeNode target = root;
        TreeNode parent = root;

        //Find the element
        while (elem != target.data) {
            if (elem < target.data) target = target.left;
            else target = target.right;
        }

        //Node is a leaf
        if (target.left == null && target.right == null) {
            target = null;
        }

        //Find the max in the left branch

    }

    public TreeNode getRoot() {
        return root;
    }
}
