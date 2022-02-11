package com.me.link;

/**
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 *
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * 示例 2：
 *
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode dmp = new ListNode(1000);
        dmp.next = head;

        ListNode smallHead = new ListNode(1000);
        ListNode pre = dmp;
        ListNode cur = head;
        ListNode smallTail = smallHead;

        while(cur != null){
            if(cur.val < x){
                smallTail.next = cur;
                smallTail = cur;

                pre.next = cur.next;
                cur = cur.next;

                smallTail.next = null;
            }else{
                pre = pre.next;
                cur = cur.next;
            }
        }

        smallTail.next = dmp.next;

        return smallHead.next;
    }
}
