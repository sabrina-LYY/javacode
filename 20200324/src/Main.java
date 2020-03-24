import java.util.*;

public class Main {
    public int getValue(int[] gifts, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < gifts.length; i++) {
            if (map.containsKey(gifts[i])) {
                map.put(gifts[i], map.get(gifts[i]) + 1);
            } else {
                map.put(gifts[i], 1);
            }
        }
        for (int i = 0; i < gifts.length; i++) {
            if (map.get(gifts[i]) >= n / 2) {
                return gifts[i];
            }
        }
        return 0;
    }



    //将链表设置为前面比x小，后面比x大
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public class Partition {
        public ListNode partition(ListNode pHead, int x) {
            if(pHead==null || pHead.next == null){
                return pHead;
            }
            ListNode maxHead = new ListNode(-1);
            ListNode minHead = new ListNode(-1);
            ListNode max = maxHead;
            ListNode min = minHead;
            ListNode cur = pHead;
            while(cur !=null){
                if(cur.val<x){
                   min.next = cur;
                   min = min.next;
                }else{
                    max.next = cur;
                    max = max.next;
                }
                cur = cur.next;
            }
            min.next = maxHead.next;
            max.next = null;
            return minHead.next;

        }
    }

}