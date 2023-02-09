package takatsukiizumi.leetcode;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import takatsukiizumi.leetcode.hot100.bestTimeToSellStock;
import takatsukiizumi.leetcode.hot100.entity.ListNode;
import takatsukiizumi.leetcode.hot100.generateParenthesis;
import takatsukiizumi.leetcode.hot100.majorityElement;
import takatsukiizumi.leetcode.hot100.reverseList;
import takatsukiizumi.leetcode.philosopher_eating_problem.chopsticks;
import takatsukiizumi.leetcode.philosopher_eating_problem.philosopher;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class test {
    public static void main(String[] args)  throws InterruptedException {
        bestTimeToSellStock stock = new bestTimeToSellStock();
        int [] prices = {7,1,5,3,6,4};
        int max = stock.maxProfit(prices);
        System.out.println(max);




//        generateParenthesis gen = new generateParenthesis();
//        List<String> ans2 = gen.generateParenthesis(2);
//        List<String> ans3 = gen.generateParenthesis(3);
//        List<String> ans4 = gen.generateParenthesis(4);
//        System.out.println(ans2+"\n"+ans3+"\n"+ans4+"\n");

//          majorityElement maj = new majorityElement();
//          int []nums = new int[]{3,2,3};
//          int i = maj.majorityElement1(nums);
//          System.out.println(i);

//            reverseList rev = new reverseList();
//            ListNode node1 = new ListNode(1);
//            ListNode node2 = new ListNode(2);
//            ListNode node3 = new ListNode(3);
//            ListNode node4 = new ListNode(4);
//            node1.next=node2;
//            node2.next=node3;
//            node3.next=node4;
//            rev.reverseList1(node1);
//            System.out.println(node3.next.val);
//              String str = "AB";
//              System.out.println(str.hashCode());
//        chopsticks  c1 = new chopsticks(1);
//        chopsticks  c2 = new chopsticks(2);
//        chopsticks  c3 = new chopsticks(3);
//        chopsticks  c4 = new chopsticks(4);
//        chopsticks  c5 = new chopsticks(5);
//
//        philosopher p1 = new philosopher("1号哲学家",1,c1,c2);
//        philosopher p2 = new philosopher("2号哲学家",2,c2,c3);
//        philosopher p3 = new philosopher("3号哲学家",3,c3,c4);
//        philosopher p4 = new philosopher("4号哲学家",4,c4,c5);
//        philosopher p5 = new philosopher("5号哲学家",5,c5,c1);
//
//        p1.start();
//        p2.start();
//        p3.start();
//        p4.start();
//        p5.start();


    }




}
