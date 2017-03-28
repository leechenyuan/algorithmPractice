package me.leechenyuan.practice.algorithms.leetcode.q138;

/**
 * Created by L on 17/3/18.
 */
public class RandomListNode {
     int label;
     RandomListNode next, random;
     RandomListNode(int x) { this.label = x; }



     public static RandomListNode buildListNode(int ... nums){
          if((nums == null) || nums.length==0){
               return null;
          }
          RandomListNode node = new RandomListNode(nums[0]);
          RandomListNode head = node ;
          for(int i=1;i<nums.length;i++){
               node.next = new RandomListNode(nums[i]);
               node = node.next;
          }

          return head ;
     }
}

