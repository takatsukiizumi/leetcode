package takatsukiizumi.leetcode.hot100;

import takatsukiizumi.leetcode.hot100.entity.ListNode;

/**
 * @Description:
 * @author: takatsukiizumi
 * @date: 2023/5/19
 */
public class removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0); // 创建一个虚拟头结点
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // fast指针先向前移动n+1步
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // fast和slow指针同时向前移动，直到fast指针到达链表末尾
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 删除倒数第n个节点
        slow.next = slow.next.next;

        return dummy.next; // 返回新的头结点
    }
}
