package me.leechenyuan.practice.algorithms.leetcode.L23;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        /**
         * 合并两个sort list (数量分别为n,m)的时候，每一个比较，都会导致一个数据进入有序的新队列，所以 最多需要 n+m-1次。
         *
         * 对于 K 个 有序数列(假如每个长度为l)来说， 如果重复调用 mergeTwoLists的方法，最差的情况下，是 (2*l-1) + （3*l-1）+ ... + ((k-1)*l-1) 次的比较这是不能够容忍的。
         * 但是，如果我们通过使用优先队列，我们可以避免这样的漫长重复的比较。优先队列好像本质是一个二叉树，忘记了，后面有空复习深入一下。
         * 通过二叉树排序，就会快了很多。
         *
         *
         */
        if((lists == null) || (lists.length == 0)){
            return null;
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
        for(ListNode no : lists){
            while(no != null){
                heap.add(no);
                no = no.next;
            }
        }
        ListNode result = new ListNode(0);
        ListNode head = result;
        while(heap.peek() != null){
            result.next = heap.poll();
            result = result.next;
        }
        result.next = null;
        return head.next;
    }
}
