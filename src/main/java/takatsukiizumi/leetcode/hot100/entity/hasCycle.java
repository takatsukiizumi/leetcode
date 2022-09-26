package takatsukiizumi.leetcode.hot100.entity;

import java.util.*;

/**
 * @Description: 环形链表
 * @author: takatsukiizumi
 * @date: 2022年09月26日 21:06
 */

//如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos
//
// 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递。仅仅是为了标识链表的实际情况

public class hasCycle {
    //快慢指针
    public boolean hasCycle1(ListNode head) {
        if (null == head) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow)
                return true;
        }
        return false;
    }

    //hashset遍历
    public boolean hasCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        if (null == head) {
            return false;
        }
        while (null != head) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }
}
