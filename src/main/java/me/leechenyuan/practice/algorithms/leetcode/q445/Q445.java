package me.leechenyuan.practice.algorithms.leetcode.q445;

import me.leechenyuan.practice.algorithms.leetcode.L148.ListNode;
import me.leechenyuan.practice.algorithms.leetcode.Printor;
import me.leechenyuan.practice.algorithms.leetcode.utils.LinkedListUtil;
import org.junit.Test;

/**
 * Created by L on 17/3/27.
 */
public class Q445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int aLength = LinkedListUtil.countLength(l1);
        int bLength = LinkedListUtil.countLength(l2);
        int diff = aLength - bLength ;
        ListNode head = new ListNode(0);
        ListNode cur = head;
        if(diff > 0){
            for(int i=0;i<diff;i++){
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
                cur = cur.next;
            }
        }else if(diff < 0){
            for(int i=0;i>diff;i--){
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
                cur = cur.next;
            }
        }

        while(l1 != null) {
            cur.next = new ListNode(l1.val + l2.val);
            cur = cur.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        cur = LinkedListUtil.reverse(head);
        head = cur;
        while(cur.next != null) {
            if(cur.val >= 10) {
                cur.val -= 10;
                cur.next.val += 1;
            }
            cur = cur.next;
        }
        cur = LinkedListUtil.reverse(head);
        if(cur.val == 0){
            cur = cur.next;
        }
        return cur;
    }



    @Test
    public void q445(){
        ListNode a =
                ListNode.buildListNode(1)
//                ListNode.buildListNode(7,2,4,3)
                ;
        ListNode b =
//                ListNode.buildListNode(2)
        ListNode.buildListNode(1,9)
//                ListNode.buildListNode(5,6,4)
                ;

        ListNode result = addTwoNumbers(a,b);
        Printor.print(result);
    }
}
