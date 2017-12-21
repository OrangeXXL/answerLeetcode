/**
 * Created by WenXun on 2017/12/21.
 * leetcode problems 19 remove the Nth node from end of list
 */
public class removeNthNodeFromEndOfList_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ret = head;
        int count = 0;
        while(head.next != null){
            head = head.next;
            count++;
        }
        if (count < 1) return null;
        int index = count - n;
        head = ret;
        if (index < 0) return head.next;
        while(index > 0){
            head = head.next;
            index--;
        }

        head.next = head.next.next;
        return ret;
    }
}
