package me.leechenyuan.practice.algorithms.leetcode.q160;

import me.leechenyuan.practice.algorithms.leetcode.L148.ListNode;
import me.leechenyuan.practice.algorithms.leetcode.Printor;
import me.leechenyuan.practice.algorithms.leetcode.utils.LinkedListUtil;
import org.junit.Test;

/**
 * Created by L on 17/3/22.
 */
public class Q160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || (headB == null)){
            return null;
        }
        headA = LinkedListUtil.reverse(headA);
        headB = LinkedListUtil.reverse(headB);

        ListNode backHeadA = headA;
        ListNode backHeadB = headB;


        ListNode pre = null;
        while(headA == headB){
            pre = headA;
            headA = headA.next;
            headB = headB.next;
        }

        LinkedListUtil.reverse(backHeadA);
        LinkedListUtil.reverse(backHeadB);

        return pre;
    }


    @Test
    public void q160(){
        ListNode headA = ListNode.buildListNode(4,3,2,1,0);
        ListNode headB = ListNode.buildListNode(15,16,27,18,19,20);
        headB.next.next.next = headA.next.next;
        ListNode joinNode = getIntersectionNode(headA,headB);
        Printor.print(joinNode);
    }
}
