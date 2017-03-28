package me.leechenyuan.practice.algorithms.leetcode.q328;

import me.leechenyuan.practice.algorithms.leetcode.L148.ListNode;
import me.leechenyuan.practice.algorithms.leetcode.Printor;
import org.junit.Test;

/**
 * Created by L on 17/3/27.
 */
public class Q328 {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || (head.next == null) ||(head.next.next==null)){
            return head;
        }
//        for(ListNode pre = head,ListNode cur = head.next;cur != null;cur = cu)
        ListNode pre = head;
        ListNode connect = head.next;
        ListNode cur = head.next;
        int step = 0;
        while(cur != null){
            if(cur.next == null){
                if(step%2 != 0){
                    pre.next = cur.next;
                    cur.next = connect;
                    break;
                }else{
                    pre.next = connect;
                    break;
                }
            }
            pre.next = cur.next;
            pre  = cur;
            cur = cur.next;
            ++step;
        }

        return  head;
    }


    @Test
    public void q328(){
        ListNode node =
//                ListNode.buildListNode(1,2,3,4,5)
//        ListNode.buildListNode(1)
        ListNode.buildListNode(1,2)
//        ListNode.buildListNode(1,2,3)
//        ListNode.buildListNode(1,2,3,4)
//        ListNode.buildListNode(1,2,3,4,5,6)
                ;
        node = oddEvenList(node);
        Printor.print(node);
    }
}
