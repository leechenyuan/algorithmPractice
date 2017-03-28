package me.leechenyuan.practice.algorithms.leetcode.q92;

import me.leechenyuan.practice.algorithms.leetcode.L148.ListNode;
import me.leechenyuan.practice.algorithms.leetcode.Printor;
import org.junit.Test;

/**
 * Created by L on 17/3/28.
 */
public class Q92 {
    /**
     * 这道题的理解错了，不过这个程序用于一个目的的话还是正常的，那就是:调换指定节点的位置
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if( ( m == n) || (head == null)){
            return head;
        }

        int diff = n - m;
        if(diff < 0 ){
            int tmp = n;
            n  = m;
            m = tmp;
            diff = - diff;
        }
        int i = 1;
        ListNode firstPre = null;
        ListNode firstExchange = null;
        ListNode secondPre = null;
        ListNode secondExchange = null;
        ListNode cur = head;
        while( i <= n){
            if(i == (m-1)){
                firstPre = cur;
            }else if(i == m){
                firstExchange = cur;
            }else  if(i == (n-1)){
                secondPre = cur;
            }else if( i == n){
                secondExchange = cur;
            }
            cur = cur.next;

            i++;
        }
        if(diff == 1) {
            if(firstPre == null) {
                head = secondExchange;
                ListNode secondNext = secondExchange.next;
                secondExchange.next = firstExchange;
                firstExchange.next = secondNext;
            }else{
                firstPre.next = secondExchange;
                ListNode secondNext = secondExchange.next;
                secondExchange.next = firstExchange;
                firstExchange.next = secondNext;
            }
        }else{
            if(firstPre == null){
                head = secondExchange;
                ListNode secondNext = secondExchange.next;
                secondExchange.next = firstExchange.next;
                secondPre.next = firstExchange;
                firstExchange.next = secondNext;
            }else{
                firstPre.next = secondExchange;
                ListNode secondNext = secondExchange.next;
                secondExchange.next = firstExchange.next;
                secondPre.next = firstExchange;
                firstExchange.next = secondNext;
            }
        }
        return head;
    }


    @Test
    public void q92(){
        ListNode node =
//                ListNode.buildListNode(1,2,3,4,5)
        ListNode.buildListNode(1,2,3,4)
                ;
        int m = 3;
        int n = 1;
        node = reverseBetween(node,m,n);
        Printor.print(node);
    }
}
