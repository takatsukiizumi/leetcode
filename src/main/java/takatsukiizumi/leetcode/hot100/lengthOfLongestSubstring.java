package takatsukiizumi.leetcode.hot100;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 最后一个单词的长度
 * @author: takatsukiizumi
 * @date: 2022年09月17日 17:23
 */

//给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
//
//单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。

public class lengthOfLongestSubstring  {
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
