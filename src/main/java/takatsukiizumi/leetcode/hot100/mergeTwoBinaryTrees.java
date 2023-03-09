package takatsukiizumi.leetcode.hot100;

import takatsukiizumi.leetcode.hot100.entity.TreeNode;

/**
 * @Description:合并二叉树
 * @author: takatsukiizumi
 * @date: 2023/2/28
 */

//想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
//
//返回合并后的二叉树。
//
//注意: 合并过程必须从两个树的根节点开始。

public class mergeTwoBinaryTrees {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        return merge(root1,root2);

    }
        public TreeNode merge(TreeNode node1,TreeNode node2){
        if(node1 == null) return node2;
        if(node2 == null) return node1;

        node1.left = merge(node1.left,node2.left);
        node1.right = merge(node1.right,node2.right);

        node1.val = node1.val+node2.val;

        return node1;
        }




    }



