package takatsukiizumi.leetcode.hot100;

/**
 * @Description: TODO
 * @author: takatsukiizumi
 * @date: 2022年09月20日 10:33
 */
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
