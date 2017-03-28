package me.leechenyuan.practice.algorithms.leetcode.q86;

import me.leechenyuan.practice.algorithms.leetcode.L148.ListNode;
import me.leechenyuan.practice.algorithms.leetcode.Printor;
import org.junit.Test;

/**
 * Created by L on 17/3/14.
 */
public class S86 {
    public ListNode partition(ListNode head, int x) {
        if(head == null || (head.next == null)){
            return head;
        }
        ListNode cur = head;
        ListNode pre = null;
        ListNode connect = null;
        boolean hasBigOrEqual = false;
        boolean hasSetConnect = false;
        while(cur != null){
            if(cur.val >= x) {
                hasBigOrEqual = true;
                if(!hasSetConnect){
                    connect = pre;
                    hasSetConnect = true;
                }
            }else{
                if(hasBigOrEqual){
                    if(connect == null){
                        pre.next = cur.next;
                        connect = cur;
                        connect.next = head;
                        head = connect;
                        cur = pre.next;
                        continue;
                    }else{
                        pre.next = cur.next;
                        ListNode preNext = connect.next;
                        connect.next = cur;
                        connect = cur;
                        connect.next = preNext;
                        cur = pre.next;
                        continue;
                    }
                }

            }
            pre = cur;
            cur = cur.next;
        }

        return head;
    }


    @Test
    public void q86(){
        ListNode node =
//                ListNode.buildListNode(1,4,3,2,5,2)
//                ListNode.buildListNode(4,1)
//                ListNode.buildListNode(1)
//                ListNode.buildListNode(4)
                ListNode.buildListNode(2,3,1)
//                ListNode.buildListNode(3,3,3,3,3,3)
                ;
        node = partition(node,2);
        Printor.print(node);
    }
}
