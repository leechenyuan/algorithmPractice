package me.leechenyuan.practice.algorithms.leetcode.q24;

import me.leechenyuan.practice.algorithms.leetcode.L148.ListNode;
import me.leechenyuan.practice.algorithms.leetcode.Printor;
import org.junit.Test;

/**
 * Created by L on 17/3/12.
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode newHead = head.next==null?head:head.next;
        ListNode cur = head;
        ListNode pre = head;
        ListNode tmp;
        while( (cur != null) && (cur.next != null) ){
           if(pre != null) {
                pre.next = cur.next;
                pre = cur;
           }
           tmp = cur.next.next;
           cur.next.next = cur;
           cur.next = tmp;
           cur = tmp;
        }
       return newHead;
    }


    @Test
    public void q24(){
        ListNode head = ListNode.buildListNode(1,2,3);
//        ListNode head = ListNode.buildListNode(1);
//        ListNode head = ListNode.buildListNode(1,2,3,4,9,7);
        head = swapPairs(head);
        Printor.println(head);
    }
}
