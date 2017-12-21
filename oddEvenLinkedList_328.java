
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
 * ����һ������Ȼ�󽫻�������ֵ��
 * ��������У���ָ���쳣һֱ�޷����
 * ����ż��������������ָ��
 * ��������������ż����ָ��
 * �������������ѭ������ ��Ϊż�����ż�������һ�������Ƿ�Ϊ��
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
