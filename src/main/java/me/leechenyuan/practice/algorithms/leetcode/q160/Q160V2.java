package me.leechenyuan.practice.algorithms.leetcode.q160;

import me.leechenyuan.practice.algorithms.leetcode.L148.ListNode;
import me.leechenyuan.practice.algorithms.leetcode.Printor;
import org.junit.Test;

/**
 * Created by L on 17/3/25.
 */
public class Q160V2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || (headB == null)){
            return  null;
        }
        int aPlusX = countLength(headA);
        int bPlusX = countLength(headB);

        ListNode tail = joinAEnd2BHead(headA,headB);
        boolean hasLoop = hasLoop(headA,aPlusX+bPlusX);
        tail.next = null;//还原A的尾巴
        if(!hasLoop ) {
            return null;
        }
        int xLength = Math.abs((aPlusX+bPlusX)/2);
        int diff = aPlusX - bPlusX;
        if(diff > 0){
            while(diff != 0){
                headA = headA.next;
                diff--;
            }
        }
        if(diff <0 ){
            while(diff!=0 ){
                headB = headB.next;
                diff++;
            }
        }
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return  headA;
//        int count = 0;
//        while(headA != null) {
//            ++count;
//            if(count == xLength){
//                return headA.next;
//            }
//            headA = headA.next;
//        }
//        return null;//impossible
    }

    //连接a的尾巴到b的头，返回a的尾巴
    private static ListNode joinAEnd2BHead(ListNode nodeA,ListNode nodeB){
        while(nodeA.next != null) {
            nodeA = nodeA.next;
        }
        nodeA.next = nodeB;
        return nodeA;
    }
    private static int countLength(ListNode node){
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

    //判断一个链表是否有环
    private boolean hasLoop(ListNode node,int length){
        int count = 0;
        while(node != null){
            ++count;
            if(count > length){
                return true;
            }
        }
        return false;
    }


    @Test
    public void q1602(){
//        ListNode headA = ListNode.buildListNode(4,3,2,1,0);
//        ListNode headB = ListNode.buildListNode(15,16,27,18,19,20);
        ListNode headA = ListNode.buildListNode(1);
        ListNode headB = headA;
//        headB.next.next.next = headA.next.next;
        ListNode joinNode = getIntersectionNode(headA,headB);
        Printor.print(joinNode);
    }
}
