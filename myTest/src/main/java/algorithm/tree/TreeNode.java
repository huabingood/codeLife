package algorithm.tree;

/**
 * 树有节点和数据域组成
 * 而二叉树由左节点和右节点共同组成
 */
public class TreeNode {
    // 数据域
    private int value;

    // 左右节点
    public TreeNode leftNode;
    public TreeNode rightNode;

    public TreeNode() {
    }

    public TreeNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }
}
