package takatsukiizumi.leetcode;

import takatsukiizumi.leetcode.hot100.entity.ListNode;
import takatsukiizumi.leetcode.hot100.removeNthFromEnd;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:
 * @author: takatsukiizumi
 * @date: 2023/5/17
 */
public class test1 {
    public static void main(String[] args) {

//        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 9);
//        numbers.sort((a, b) -> a.compareTo(b));
//        numbers.forEach(number-> System.out.println(number));
//
//        List<Integer> numberss = Arrays.asList(1, 2, 3, 4, 5, 6);
//        List<Integer> evenNumbers = numberss.stream()
//                .filter(n -> n % 2 == 0)
//                .collect(Collectors.toList());
//        evenNumbers.forEach(evenNumber-> System.out.println(evenNumber));

        removeNthFromEnd removeNthFromEnd = new removeNthFromEnd();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next =node2;
        node2.next =node3;
        node3.next=node4;
        node4.next=node5;
        ListNode resultNode = removeNthFromEnd.removeNthFromEnd(node1, 3);
        System.out.println(resultNode.toString());

    }
}
