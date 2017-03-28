package me.leechenyuan.practice.algorithms.leetcode.L148;

import me.leechenyuan.practice.algorithms.leetcode.Printor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by L on 2017/3/7.
 */
  public class ListNode {
      public int val;
      public ListNode next;
      public ListNode(int x) { val = x; }


      public static ListNode buildListNode(int ... nums){
          if((nums == null) || nums.length==0){
              return null;
          }
          ListNode node = new ListNode(nums[0]);
          ListNode head = node ;
          for(int i=1;i<nums.length;i++){
              node.next = new ListNode(nums[i]);
              node = node.next;
          }
          return head ;
      }


    @Override
    public String toString() {
        return String.valueOf(val);
    }

    public String friendlyListString(){
          ListNode cur = this;
          StringBuilder builder = new StringBuilder();
          while(cur != null){
              builder.append(cur.val).append(',');
          }
          builder.setLength(builder.length()-1);
          return builder.toString();
    }
}
