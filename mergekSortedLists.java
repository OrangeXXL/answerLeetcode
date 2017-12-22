import java.util.Arrays;

/**
 * Created by WenXun on 2017/12/22.
 * leetcode problems 23 merge k sorted lists
 */
public class mergekSortedLists {
    public static ListNode mergeKLists(ListNode[] lists) {
        System.out.println("length = "+lists.length);
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        if (lists.length == 2) return mergeTwoLists(lists[0], lists[1]);

        ListNode[] left = Arrays.copyOfRange(lists, 0, lists.length/2);
        ListNode[] right = Arrays.copyOfRange(lists, lists.length / 2 , lists.length);

        return mergeTwoLists(mergeKLists(left), mergeKLists(right));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode p = new ListNode(0);
        ListNode mergeTwoHead = p;

        if (l1 == null && l2 == null) return null;

        while (l1 != null && l2 != null){
            System.out.println("l1.val = "+l1.val+" and l2.val = "+l2.val);
            if (l1.val <= l2.val){
                p.next = l1;
                l1 = l1.next;
            }else{
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if(l1 != null)
            p.next = l1;
        if(l2 != null)
            p.next = l2;
        return mergeTwoHead.next;
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
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode();
        ListNode l3 = new ListNode(-1);
        ListNode[] lists = {l1, l2, l3};
        for (int i = 0; i < lists.length; i++) {
            printList(lists[i]);
        }
        ListNode retVal = mergeKLists(lists);
        printList(retVal);

    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode() { }
    ListNode(int x) { val = x;}
}