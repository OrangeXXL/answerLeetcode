/**
 * Created by WenXun on 2017/12/22.
 * leetcode problem merge two sorted lists
 */
public class mergeTwoSortedLists_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(0);
        ListNode res = ret;
        if (l1 == null && l2 == null) return null;

        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                ret.next = l1;
                l1 = l1.next;
            }else{
                ret.next = l2;
                l2 = l2.next;
            }
            ret = ret.next;
        }
        if(l1 != null)
            ret.next = l1;
        if(l2 != null)
            ret.next = l2;
        return res.next;
    }
}
