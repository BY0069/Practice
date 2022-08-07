import java.util.Scanner;

public class HuffmanTree {
    private final java.util.ArrayList<HFTNode> nodes;
    private HFTNode root;

    public HuffmanTree() {
        this.nodes = new java.util.ArrayList<>();
        String c = new Scanner(System.in).next();
        int n = c.length();
        for (int i = 0; i < n; i++)
            nodes.add(new HFTNode(c.charAt(i), c.charAt(i)));
    }

    public void BuildTree() {
        while (nodes.size() > 1) {
            java.util.Collections.sort(nodes);
            HFTNode node1 = nodes.get(0);
            nodes.remove(0);
            HFTNode node2 = nodes.get(0);
            nodes.remove(0);
            HFTNode node3 = new HFTNode(node1.weight + node2.weight);
            node3.left = node1;
            node3.right = node2;
            nodes.add(node3);
        }
        root = nodes.get(0);
    }

    private void InOrder(HFTNode root) {
        if (root == null) return;
        InOrder(root.left);
        System.out.println(root.weight);
        InOrder(root.right);
    }

    public void PrintTree() {
        InOrder(root);
    }
}


class HFTNode implements Comparable<HFTNode> {

    public char data;
    public int weight;
    public HFTNode left;
    public HFTNode right;
    public String code = "";

    public HFTNode(int weight) {
        this.weight = weight;
        left = null;
        right = null;
    }

    public HFTNode(char data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(HFTNode hftNode) {
        return Integer.compare(this.weight, hftNode.weight);
    }
}