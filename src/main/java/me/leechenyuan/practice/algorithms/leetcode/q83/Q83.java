package me.leechenyuan.practice.algorithms.leetcode.q83;

import me.leechenyuan.practice.algorithms.leetcode.L148.ListNode;
import me.leechenyuan.practice.algorithms.leetcode.Printor;
import org.junit.Test;

/**
 * Created by L on 17/3/27.
 */
public class Q83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode pre = head;
        for(ListNode cur = head.next;cur != null; cur = cur.next){
            if(cur.val == pre.val){
                pre.next = cur.next;
            }else{
                pre = cur;
            }
        }
        return head;
    }

    @Test
    public void q83(){
        ListNode node =
//                ListNode.buildListNode(1)
//                ListNode.buildListNode(1,1)
//                ListNode.buildListNode(1,1,2)
//        ListNode.buildListNode(1,2,2,3)
        ListNode.buildListNode(1,2,3,3)
//        ListNode.buildListNode(1,2,2,3)
//        ListNode.buildListNode(1,2,2,3)
                ;
        node = deleteDuplicates(node);
        Printor.println(node);
    }
}
