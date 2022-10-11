package takatsukiizumi.leetcode.hot100;

import takatsukiizumi.leetcode.hot100.entity.TreeNode;

/**
 * @Description: 翻转二叉树
 * @author: takatsukiizumi
 * @date: 2022年10月11日 10:16
 */

public class invertTree {
    public TreeNode invertTree(TreeNode root) {
        //递归函数的终止条件，节点为空时返回
        if(root==null) {
            return null;
        }
        //下面三句是将当前节点的左右子树交换
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        //递归交换当前节点的 左子树
        invertTree(root.left);
        //递归交换当前节点的 右子树
        invertTree(root.right);
        //函数返回时就表示当前这个节点，以及它的左右子树
        //都已经交换完了
        return root;
    }
}
