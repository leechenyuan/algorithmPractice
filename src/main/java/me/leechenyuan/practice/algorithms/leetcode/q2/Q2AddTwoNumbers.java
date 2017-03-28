package me.leechenyuan.practice.algorithms.leetcode.q2;

import me.leechenyuan.practice.algorithms.leetcode.L148.ListNode;
import me.leechenyuan.practice.algorithms.leetcode.Printor;
import org.junit.Test;

/**
 * Created by L on 17/3/19.
 */
public class Q2AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode head = null;
        ListNode cur = null;
        int access = 0;
        int value = 0;
        while( (l1 != null) && (l2 != null)){
            value = l1.val + l2.val + access;
            if(value >= 10){
                access = 1;
                value -= 10;
            }else{ //这一段太容易漏掉了
                access = 0;
            }
            if(cur == null){
                head = new ListNode(value);
                cur = head;
            }else{
                cur.next = new ListNode(value);
                cur = cur.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null){
            value = access + l1.val;
            if(value >= 10){
                access = 1;
                value -= 10;
            }else{
                access = 0;
            }
            cur.next = new ListNode(value);
            cur = cur.next;
            l1 = l1.next;
        }
        while(l2 != null){
            value = access + l2.val;
            if(value >= 10){
                access = 1;
                value -= 10;
            }else{
                access = 0;
            }
            cur.next = new ListNode(value);
            cur = cur.next;
            l2= l2.next;
        }

        if(access != 0){
            cur.next = new ListNode(access);
        }
        return head;
    }



    @Test
    public void q2(){
        ListNode l1 =
                ListNode.buildListNode(0)
                ;
        ListNode l2 =
//                ListNode.buildListNode(6,7,8)
                ListNode.buildListNode(0)
                ;

        ListNode result = addTwoNumbers(l1,l2);

        Printor.println(result);
    }
}
