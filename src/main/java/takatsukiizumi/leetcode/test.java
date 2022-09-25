package takatsukiizumi.leetcode;

import takatsukiizumi.leetcode.hot100.generateParenthesis;

import java.util.List;

public class test {
    public static void main(String[] args) {
        generateParenthesis gen = new generateParenthesis();
        List<String> ans1 = gen.generateParenthesis(1);
        List<String> ans2 = gen.generateParenthesis(2);
        List<String> ans3 = gen.generateParenthesis(3);
        System.out.println(ans1+"\n"+ans2+"\n"+ans3+"\n");
    }
}
