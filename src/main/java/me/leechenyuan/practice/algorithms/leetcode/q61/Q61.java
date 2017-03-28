package me.leechenyuan.practice.algorithms.leetcode.q61;

import me.leechenyuan.practice.algorithms.leetcode.L148.ListNode;
import me.leechenyuan.practice.algorithms.leetcode.Printor;
import org.junit.Test;

/**
 * Created by L on 17/3/19.
 */
public class Q61 {
    public ListNode rotateRight(ListNode head, int k) {
        if( (head == null)
                || (k < 1)
                || (head.next == null)){
            return head;
        }
        /**
         * 考虑k>=链表长度的情况
         */
        ListNode preNode = null; // A B C D ,如果k=2，那么preNode == B
        ListNode cutNode = null;
        int i=0;
        ListNode endNode = null;
        for(ListNode cur = head;cur != null ; cur = cur.next){
            if(++i >= k){
                preNode = cutNode;
                if(cutNode == null){
                    cutNode = head;
                }else{
                    cutNode = cutNode.next;
                }
            }
            endNode = cur;
        }

        if(i <= k){
            if(k%i == 0){
                return head;
            }
            return (rotateRight(head,k%i));
        }
        //可以交换节点了
        preNode.next = null;
        endNode.next = head;
        return cutNode;
//        endNode.next = head;

//        return endNode;

    }

    @Test
    public void q61(){
        ListNode node =
//                ListNode.buildListNode(1,2,3,4,5)
            ListNode.buildListNode(1,2)
                ;
        int k = 4;
        ListNode newNode = rotateRight(node,k);
        Printor.print(newNode);
    }
}
