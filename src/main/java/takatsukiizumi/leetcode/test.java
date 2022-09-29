package takatsukiizumi.leetcode;

import takatsukiizumi.leetcode.hot100.generateParenthesis;
import takatsukiizumi.leetcode.hot100.majorityElement;

import java.util.List;

public class test {
    public static void main(String[] args) {
//        generateParenthesis gen = new generateParenthesis();
//        List<String> ans2 = gen.generateParenthesis(2);
//        List<String> ans3 = gen.generateParenthesis(3);
//        List<String> ans4 = gen.generateParenthesis(4);
//        System.out.println(ans2+"\n"+ans3+"\n"+ans4+"\n");

          majorityElement maj = new majorityElement();
          int []nums = new int[]{3,2,3};
          int i = maj.majorityElement1(nums);
          System.out.println(i);

    }
}
