import java.util.*;
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
//链表分割；分别定义大的一半的头，小的一半的头，进行连接即可
public class TestDemo {
    public ListNode partition(ListNode pHead, int x) {
        ListNode minHead = new ListNode(-1);
        ListNode maxHead = new ListNode(-1);
        ListNode l1 = minHead;
        ListNode l2 = maxHead;
        ListNode cur = pHead;
        ListNode next = null;
        while(cur!=null){
            next = cur.next;//每次循环要将cur的next置空
            if(cur.val<x){
                minHead.next = cur;
                minHead = minHead.next;
                cur.next = null;
            }else{
                maxHead.next = cur;
                maxHead = maxHead.next;
                cur.next = null;
            }
            cur = next;
        }
        minHead.next = l2.next;
        return l1.next;
    }
}