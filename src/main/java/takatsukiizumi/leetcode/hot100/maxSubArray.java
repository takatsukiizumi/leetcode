package takatsukiizumi.leetcode.hot100;

/**
 * @Description: 最大子数组和
 * @author: takatsukiizumi
 * @date: 2022年09月20日 14:59
 */

//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
//子数组 是数组中的一个连续部分。

public class maxSubArray {

    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

}
