package me.leechenyuan.practice.algorithms.leetcode.q147;

import me.leechenyuan.practice.algorithms.leetcode.L148.ListNode;
import me.leechenyuan.practice.algorithms.leetcode.Printor;
import org.junit.Test;

/**
 * Created by L on 17/3/18.
 */
public class Q147 {
    public ListNode insertionSortList(ListNode head) {
        if( (head == null ) || head.next== null){
            return head;
        }
        ListNode cur = head.next;
        ListNode pre = head;
        while(cur != null) {
            ListNode p = head;
            ListNode beforeP = null;
            while( (p != null)
                    && (cur.val >= p.val)
                    && (p != cur)){ //不能超过cur
                beforeP = p;
                p = p.next;
            }
            if( (p != null) && (p != cur)){
                if(beforeP != null){
                    pre.next = cur.next;
                    beforeP.next = cur;
                    cur.next = p;
                }else{
                    pre.next = cur.next;
                    head = cur;
                    beforeP = cur;
                    cur.next = p;
                }
                //下面这2个一漏掉，会导致执行 pre = cur;cur = cur.next;程序就乱掉了
                cur = pre.next;
                continue;
            }
            pre = cur;
            cur = cur.next;
        }
        return head;
    }

    @Test
    public void q147(){
        int [] nums =
//                new int []{3,4,1,2}
//                new int []{1}
//                new int []{2,1}
//                new int []{2,1,3}
                new int []{1,2,3,4}
                ;
        ListNode node = ListNode.buildListNode(nums);
        node = insertionSortList(node);
        Printor.print(node);
    }
}
