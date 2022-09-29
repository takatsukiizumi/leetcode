package takatsukiizumi.leetcode.hot100;

import takatsukiizumi.leetcode.hot100.entity.ListNode;

/**
 * @Description: 反转链表
 * @author: takatsukiizumi
 * @date: 2022年09月29日 20:20
 */

//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。

public class reverseList {
    public ListNode reverseList1(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode headhead = reverseList1(head.next);
        head.next.next=head;
        head.next = null;
        return headhead;
    }
}





