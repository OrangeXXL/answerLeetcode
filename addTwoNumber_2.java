/**
 * Created by WenXun on 2017/12/21.
 * leetcode problem  add two number in linkedList
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class addTwoNumber_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        int carry = 0;
        ListNode pointer = result;
        while(l1 != null || l2 != null){
            if(l1 != null){
                carry += l1.val;
                l1 = l1.next;
            }

            if(l2 != null){
                carry += l2.val;
                l2 = l2.next;
            }

            pointer.next = new ListNode(carry%10);
            carry /= 10;
            pointer = pointer.next;
        }

        if (carry>0){ //处理最后的进位
            pointer.next = new ListNode(carry);
        }

        return result.next;
    }
}
