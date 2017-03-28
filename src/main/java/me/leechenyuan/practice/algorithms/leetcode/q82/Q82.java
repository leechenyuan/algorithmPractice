package me.leechenyuan.practice.algorithms.leetcode.q82;

import me.leechenyuan.practice.algorithms.leetcode.L148.ListNode;
import me.leechenyuan.practice.algorithms.leetcode.Printor;
import org.junit.Test;

import java.util.List;

/**
 * Created by L on 17/3/22.
 */
public class Q82 {
    public ListNode deleteDuplicates(ListNode head) {
        if( (head == null) || (head.next == null)){
            return head;
        }
        ListNode preFirstSame = null; // 在一系列相同元素之前的那一个元素，用于连接后面的元素。比如ABBBC,那么preFirstSame->A ,后面的元素就是C ... A->C
        ListNode prePre = null; //当pre.val == cur.val的时候，我们知道有相同的元素了，但是我们怎么获取相同元素之前的preFirstSame元素，就是要看prePre来达到目的
        ListNode pre = head; //因为排序过了，所以判断重复的标准 : pre.val = cur.val
        ListNode cur = head.next;
        boolean hasSame = false;
        while(cur != null){
            if(cur.val == pre.val){
                if(preFirstSame == null){
                    if((prePre != null ) && (prePre.val != cur.val)){ //尼玛，又忘记这里了,只有prePre.value != cur.val的时候
                        preFirstSame = prePre;
                    }
                }
                hasSame = true;
            }else{
                if(hasSame){
                    if(preFirstSame != null){
                        preFirstSame.next = cur;
                        pre = preFirstSame; //这一句很容易漏掉啊!!!
                        preFirstSame = null;
                    }else{
                        head = cur;
                        pre = null;
//                        prePre = null;
//                        pre = cur;
//                        cur
//                        hasSame = false;
//                        continue;
                    }
                    hasSame = false;
                }
            }
            prePre = pre;
            pre = cur;
            cur = cur.next;
        }
        if(hasSame){
            //ABB
            if(preFirstSame != null){
                preFirstSame.next = null;
            }else{ //AA | AAA
                head = null;
            }
        }
        return head;
    }


    @Test
    public void q82(){
//        ListNode node = ListNode.buildListNode(1,2,2,3,5,5);
        ListNode node =
//                ListNode.buildListNode(1,1)
//                ListNode.buildListNode(1,2)
//                ListNode.buildListNode(1,1,2)
//                ListNode.buildListNode(1,2,2,3)
//                ListNode.buildListNode(1,2,2,3,4,4)
                  ListNode.buildListNode(1,2,2)
                ;
//        ListNode node = ListNode.buildListNode(1,1,2);
        node = deleteDuplicates(node);
        Printor.print(node);
    }
}
