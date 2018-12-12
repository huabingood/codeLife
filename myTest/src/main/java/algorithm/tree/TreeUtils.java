package algorithm.tree;

import scala.xml.Null;

public class TreeUtils {

    /**
     * 动态创建Tree
     *
     * @param treeRoot 根节点
     * @param value    要生成的节点的值
     */
    public static void createTree(TreeRoot treeRoot, int value) {


        // 如果根节点不存在就创建根节点
        if (treeRoot.getTreeRoot() == null) {
            TreeNode treeNode = new TreeNode(value);
            treeRoot.setTreeRoot(treeNode);
            return;
        }

        // 将根节点转换成普通节点
        TreeNode root = treeRoot.getTreeRoot();
        // 获取根节点
        while (treeRoot.getTreeRoot() != null) {
            // 如果当前值大于根节点的值，将数据放到根节点的右边
            if (value > root.getValue()) {
                // 如果根节点右边没有节点就添加
                if (root.getRightNode() == null) {
                    root.setRightNode(new TreeNode(value));
                    return;
                } else {
                    // 如果右边有节点就认为右边的节点是根节点，递归调用本方法，继续创建
                    root = root.getRightNode();
                }
            } else {
                // 就往左节点插入
                if (root.getLeftNode() == null) {
                    root.setLeftNode(new TreeNode(value));
                    return;
                } else {
                    root = root.getLeftNode();
                }
            }
        }
    }

    /**
     * 使用递归法 先序遍历Tree
     *
     * @param rootNode 根节点
     */
    public static void preTraverseBtree(TreeNode rootNode) {
        if (rootNode != null) {

            // 递归遍历左边
            preTraverseBtree(rootNode.getLeftNode());
            // 输出中间
            System.out.println(rootNode.getValue());
            // 递归遍历右边
            preTraverseBtree(rootNode.getRightNode());

        }
    }
}
