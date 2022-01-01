package com.me.link;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 不允许修改 链表。
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LinkedListCycle2 {

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();

        while (head != null){
            if(set.contains(head)){
                return head;
            }
            set.add(head);
            head = head.next;

        }
        return null;
    }

    /**
     * 诀窍是证明过程。快指针走的路程是慢指针的两倍。慢指针入环后，在一圈内就会跟快指针相遇。
     */
    public ListNode detectCycleV2(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        //注意初始值
        ListNode slow = head.next, temp = head, fast = head.next.next;

        while (fast != null && fast.next != null) {
            if (fast == slow) {
                while (true) {
                    if (slow == temp) {
                        return temp;
                    }
                    temp = temp.next;
                    slow = slow.next;
                }
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return null;
    }
}