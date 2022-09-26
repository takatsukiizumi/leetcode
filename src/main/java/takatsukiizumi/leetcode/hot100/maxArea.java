package takatsukiizumi.leetcode.hot100;

/**
 * @Description: 盛水最多的容器
 * @author: takatsukiizumi
 * @date: 2022年09月17日 10:33
 */

//给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。
//
//找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
//
//返回容器可以储存的最大水量。
//
//说明：你不能倾斜容器。

public class maxArea {

    public int maxArea(int[] height) {
        int l =0, r = height.length -1 ;
        int ans = 0;
        while(l<r) {
            int area = Math.min(height[l],height[r]) * (r-l);
            ans = Math.max(ans,area);
            if (height[l] <= height[r])
                l++;
            else
                r--;
        }
        return ans;

    }
}
