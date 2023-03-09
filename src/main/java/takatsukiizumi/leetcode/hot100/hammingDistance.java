package takatsukiizumi.leetcode.hot100;

/**
 * @Description:汉明距离
 * @author: takatsukiizumi
 * @date: 2023/2/27
 */


public class hammingDistance {

    public int hammingDistance(int x, int y) {
        int count=0;
        if(x==y)
            return 0;
        while(x!=0||y!=0){
            if(x%2!=y%2)
                count++;
            x=x/2;
            y=y/2;
        }
        return count;

    }

}
