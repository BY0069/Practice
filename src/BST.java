public class BST {
    private TreeNode root;

    public BST() {
        this.root = null;
    }

    public void InOrder(TreeNode root) {
        if (root == null) return;
        InOrder(root.left);
        System.out.print(root.data + "\t");
        InOrder(root.right);
    }

    public void InsertNode(int elem) {
        TreeNode node = new TreeNode(elem);
        TreeNode cur = root, parent = null;
        while (cur != null) {
            parent = cur;
            if (elem > cur.data) cur = cur.right;
            else {
                if (elem < cur.data) cur = cur.left;
                else {
                    cur.data = elem;
                    return;
                }
            }
        }

        if (root != null) {
            if (elem < parent.data) parent.left = node;
            else parent.right = node;
        } else {
            root = node;
        }
    }

    public void DeleteNode(int elem) {
        TreeNode target = root;
        TreeNode parent = null;

        //Find the element
        while (elem != target.data) {
            parent = target;
            if (elem < target.data) {
                target = target.left;
            } else {
                target = target.right;
            }
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
            target.data = maxOfLeft.data;

            //Delete max node
            if (maxOfLeft == parentOfMax.right) parentOfMax.right = maxOfLeft.left;
            else parentOfMax.left = maxOfLeft.left;


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

    public void InOrder() {
        InOrder(this.root);
    }

}
