package me.leechenyuan.practice.algorithms.leetcode.q138;

import me.leechenyuan.practice.algorithms.leetcode.L148.ListNode;
import me.leechenyuan.practice.algorithms.leetcode.Printor;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by L on 17/3/18.
 */
public class Q138 {
    Map<Integer,RandomListNode> mapping = new HashMap<>();
    public RandomListNode copyRandomList(RandomListNode head) {
       if(head == null) {
           return head;
       }
       RandomListNode newHead = createRandomeNode(head);
       RandomListNode newCur = newHead;
       while(head != null){
           newCur.next = createRandomeNode(head.next);
           newCur = newCur.next;
           head = head.next;
       }
       return newHead;
    }

    private RandomListNode createRandomeNode(RandomListNode node){
        if(node == null){
            return null;
        }
        RandomListNode toCreate = mapping.get(node.hashCode());
        if(toCreate != null){
            return toCreate;
        }
        toCreate = new RandomListNode(node.label);
        mapping.put(node.hashCode(),toCreate);
        if(node.random != null){
            RandomListNode ran = mapping.get(node.random.hashCode());
            if(ran != null){
                toCreate.random = ran;
            }else{
                toCreate.random = createRandomeNode(node.random);
            }
        }
        return toCreate;
    }

    @Test
    public void q138(){
        RandomListNode node = new RandomListNode(2);
        node.next = RandomListNode.buildListNode(5,1,9);
        node.random = node.next.next;
        node.next.random = node;


        RandomListNode newNode = copyRandomList(node);

        Printor.println(newNode);
    }

}
