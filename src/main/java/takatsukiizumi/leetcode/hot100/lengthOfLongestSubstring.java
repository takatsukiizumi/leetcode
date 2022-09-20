package takatsukiizumi.leetcode.hot100;

import java.util.HashSet;
import java.util.Set;

public class lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> temp = new HashSet<Character>();
        int rk =0,ans=0,n=s.length();
        for (int i =0 ; i<n ;i++){
            if(i != 0){
                temp.remove(s.charAt(i-1));
            }
            while(n>rk && !temp.contains(s.charAt(rk))){
                temp.add(s.charAt(rk));
                rk++;
            }
            ans =Math.max(ans,rk-i);
        }
        return ans;
    }
}
