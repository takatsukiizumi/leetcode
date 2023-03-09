package takatsukiizumi.leetcode.hot100;

import takatsukiizumi.leetcode.hot100.entity.TreeNode;

/**
 * @Description:二叉树的直径
 * @author: takatsukiizumi
 * @date: 2023/2/28
 */

//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。

public class diameterOfBinaryTree {

    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans-1;
    }


    public int depth(TreeNode node){
    if(node == null ){
        ans = 0;
        return ans;
    }
    int left = depth(node.left);
    int right =depth(node.right);
    ans = Math.max(left+right+1,ans);
    return ans;

    }

    }

