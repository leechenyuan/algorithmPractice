package me.leechenyuan.practice.algorithms.leetcode.q92;

import me.leechenyuan.practice.algorithms.leetcode.L148.ListNode;
import me.leechenyuan.practice.algorithms.leetcode.Printor;
import org.junit.Test;

/**
 * Created by L on 17/3/28.
 */
public class Q92V2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || (m == n) || (head.next == null)){
            return head;
        }
        ListNode realNext = head.next;
        ListNode cur = head;
        ListNode prePre = null;
        ListNode postLast = null; // == preFirst
        int step = 1;
        while (step <= n){
            if(step == (m-1)){
                prePre = cur;
            }
            if(step == m){
                postLast = cur;
            }
            if(step == n){
                if(prePre == null){
                    head = cur;
                }else{
                    prePre.next = cur;
                }
                postLast.next = realNext;
            }

            ListNode tmp = realNext == null?null:realNext.next; //又忽略了空指针
//                    realNext.next;
            if((step >= m) &&(step<n)){
                realNext.next = cur;
            }
//            cur = cur.next;这一步很容易写错，cur.next实际上可能指向的已经是前一个了，而不是后一个
            cur = realNext;
            realNext = tmp;
            step++;
        }

        return head;
    }

    @Test
    public void q9202(){
        ListNode node =
//                ListNode.buildListNode(1,2,3,4)
//        ListNode.buildListNode(1,2,3)
                ListNode.buildListNode(1,2)
                ;
        int m = 2;
        int n = 2;
        node = reverseBetween(node,m,n);
        Printor.print(node);
    }
}
