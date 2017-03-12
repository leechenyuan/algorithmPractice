package me.leechenyuan.practice.algorithms.leetcode.L148;


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 可以直接参考了L23了，好无聊
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if( (head == null) || (head.next == null)){
            return head;
        }
        Queue<ListNode> heap = new PriorityQueue<ListNode>(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if((!ListNode.class.isInstance(o1)
                || (!ListNode.class.isInstance(o2)))){
                    throw new IllegalArgumentException();
                }
                ListNode a = (ListNode)o1;
                ListNode b = (ListNode)o2;
                if(a == null){
                    return -1;
                }
                if(b == null){
                    return 1;
                }
                return a.val - b.val;
            }
        });
        while(head != null){
            heap.add(head);
            head = head.next;
        }
        ListNode result = new ListNode(0);
        ListNode iHead = result;
        while(heap.peek() != null){
            result.next = heap.poll();
            result = result.next;
        }
        result.next = null;
        return iHead.next;
    }
}
