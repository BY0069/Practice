public class BST {
    private TreeNode root;

    public BST() {
        this.root = null;
    }

    public void InOrder(TreeNode root) {
        if (root == null) return;
        InOrder(root.left);
        System.out.println(root.data);
        InOrder(root.right);
    }

    public void AddNode(TreeNode root, int elem) {
        TreeNode node = new TreeNode(elem);
        if (root == null) {
            root = node;
        } else {
            if (elem < root.data) AddNode(root.left, elem);
            if (elem >= root.data) AddNode(root.right, elem);
        }
    }

    public void DeleteNode(int elem) {
        TreeNode target = root;
        TreeNode parent = null;

        //Find the element
        while (elem != target.data) {
            parent = target;
            if (elem < target.data) target = target.left;
            else target = target.right;
        }

        //Node has both left and right
        if (target.left != null && target.right != null) {
            //Find the max in the left child
            TreeNode maxOfLeft = target.left, parentOfMax = target;
            while (maxOfLeft.right != null) {
                parentOfMax = maxOfLeft;
                maxOfLeft = maxOfLeft.right;
            }

            //Move max node
            TreeNode newNode = new TreeNode(maxOfLeft.data, target.left, target.right);
            if (parent == null) root = maxOfLeft;
            else {
                if (target == parent.left) parent.left = newNode;
                else parent.right = newNode;
            }
            if (parentOfMax == target) parent = maxOfLeft;
            else parent = parentOfMax;
            target = null;
            target = maxOfLeft;
        } else { //Node has less one child
            TreeNode newNode;
            if (target.left != null) newNode = target.left;
            else newNode = target.right;

            if (target == root) root = newNode;
            else {
                if (target == parent.left) parent.left = newNode;
                else parent.right = newNode;
            }
        }
    }

    public void AddNode(int elem) {
        AddNode(this.root, elem);
    }

    public void InOrder() {
        InOrder(this.root);
    }

}
