package algorithm.tree;

public class Test {
    public static void main(String[] args) {
        int[] arrays = {2, 3, 1, 4, 5};

        TreeRoot root = new TreeRoot();
        for (int i : arrays) {
            TreeUtils.createTree(root, i);
        }

        TreeNode treeRoot = root.getTreeRoot();
        TreeUtils.preTraverseBtree(treeRoot);
    }
}
