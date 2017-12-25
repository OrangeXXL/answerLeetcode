/**
 * Created by WenXun on 2017/12/25.
 * leetcode problem 24 swap nodes in pairs
 */
public class swapNodesInPairs_24 {
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        printList(head);
        ListNode temp = head.next;
        head.next = swapPairs(temp.next);
        temp.next = head;
        return temp;
    }
    public static void printList(ListNode list){
        while(list != null){
            System.out.print(list.val + "->");
            list = list.next;
        }
        System.out.println("");
    }

    public static void print(Object o){
        System.out.println(o);
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        ListNode retVal = swapPairs(l1);
        printList(retVal);
    }
}
