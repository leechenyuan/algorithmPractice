package me.leechenyuan.practice.algorithms.leetcode.utils;

import me.leechenyuan.practice.algorithms.leetcode.L148.ListNode;
import me.leechenyuan.practice.algorithms.leetcode.Printor;
import org.junit.Test;

/**
 * Created by L on 17/3/24.
 */
public class LinkedListUtil {
    /**
     * 返回翻转后的头部,比如将A->B->C 转成 C->B->A，并返回C
     * @param node
     * @return
     */
    public static ListNode reverse(ListNode node){
        if( node == null ) {
//            || node.next == null){
            return node;
        }
        ListNode cur = node;
//        cur.next = null; 这样写下面就跑不动了
        ListNode next = node.next;
        while(next != null){
            ListNode realNext = next.next;
            next.next = cur;
            cur = next;
            next = realNext;
        }
        //将node.next = null 将原来的头部next变成null，否则就死循环了
        node.next = null;

        return cur;
    }

    public static int countLength(ListNode node){
        if(node == null){
            return 0;
        }
        int count = 0;
        while(node != null){
            ++count;
            node = node.next;
        }
        return count;
    }


    @Test
    public void testReverse(){
        ListNode node = ListNode.buildListNode(1,2,3);
        node = reverse(node);
        Printor.print(node);
    }
}
