package me.leechenyuan.practice.algorithms.leetcode.q25;

import me.leechenyuan.practice.algorithms.leetcode.L148.ListNode;
import me.leechenyuan.practice.algorithms.leetcode.Printor;
import org.junit.Test;

/**
 * Created by L on 17/3/12.
 */
public class Solution {
    /**
     * 没想到 q24 竟然是这个问题的简化版，看来自己当时做的思路有点问题
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return head;
        }
        if( k == 1){
            return head;
        }

        ListNode prePartPoint = null;
        ListNode newHead = head;
        ListNode pre = head;
        int step = 0;
        while(true){
            pre = head;
            int i = 0 ;
            while ((i++ <k)&& head!=null){
                head = head.next;
            }
            if(i <= k){
                if(prePartPoint != null){
                    prePartPoint.next = pre;
                }
                break;
            }
            ListNode postLast = pre;
            ListNode postFirst = reverse(pre,k);
            if(prePartPoint == null){
                newHead = postFirst;
                prePartPoint = postLast;
            }else{
                prePartPoint.next = postFirst;
                prePartPoint = postLast;
            }
        }
        return newHead;
    }

    //反转，并返回早期最后一个(就是结果最前那一个)
    private static ListNode reverse(ListNode cur , int k) {
        ListNode [] tmp = null;
        for(int i=0;i<k-1;i++){
            if(i == 0) {
                tmp = reverse(cur,cur.next);
            }else{
                tmp = reverse(tmp[0],tmp[1]);
            }
        }
        return tmp[0];
    }

    private static ListNode[] reverse(ListNode cur,ListNode next) {
        ListNode nextNext = next.next;
        next.next = cur;
        return new ListNode[]{next,nextNext};
    }

    @Test
    public void q25(){
        ListNode node =
                ListNode.buildListNode()
//                ListNode.buildListNode(1,2,3,4,5,6,7)
                ;
        int k = 8;
        node = reverseKGroup(node,k);
        while(node != null){
            Printor.print(node.val);
            node = node.next;
            if(node != null){
                Printor.print(",");
            }
        }
        Printor.println();
    }
}
