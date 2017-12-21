
/**
 * Created by WenXun on 2017/12/15.
 * leetcode problems odd even linkedlist;
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * 设另一个链表，然后将基数链表赋值。
 * 解题过程中，空指针异常一直无法解决
 * 满足偶数个链表，奇数空指针
 * 满足奇数个链表，偶数空指针
 * 最后解决方法，将循环条件 设为偶链表和偶链表的下一个链表是否为空
 * */
public class oddEvenLinkedList_328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode even = head.next;
        ListNode oddHead = head;
        ListNode evenHead = even;

        while(even != null && even.next != null){
            head.next = even.next;
            even.next = head.next.next;
            head = head.next;
            even = even.next;
        }
        head.next = evenHead;
        return oddHead;
    }
}
