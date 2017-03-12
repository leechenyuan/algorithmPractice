package me.leechenyuan.practice.algorithms.leetcode.L175;

import me.leechenyuan.practice.algorithms.leetcode.Printor;
import org.junit.Test;

import java.security.Principal;

/**
 * Created by L on 2017/3/7.
 */
public class Solution {
    /**
     *  暂时不知道如何去证明，仅仅是感觉这样做，不知道为什么正确。
     *
     *  脑海的想法:
     *  0000 A 111 B 111 C 2222222222
     *
     *  B 一路向北 ，找到0就扔给A，A会向前移动一位来放置0，然后把被挪出来的扔给B。
     *  如果B碰到2就扔给C，C前B的方向挪一位放2，然后将被挪出来的扔给B。
     *  这里需要考虑的是: 如果C扔给B的是0，B不应该忽视掉，而是应该扔给C。
     *  为什么不需要考虑A扔给B的是2 ? 因为B在C之前，如果碰到2会扔给C、所以A-B之间不存在有2的可能
     */
    public void sortColors(int[] nums) {
        if( (nums == null) || nums.length==0){
            return ;
        }
        int tail = -1;
        int end = nums.length;
        int head = 0;
        int tmp;
        for(int i=0;i<end;i++){
            if(nums[i] == 0){
                while( (nums[++tail] < 1) && (tail < i));//继续
                swap(nums,tail,i);
                // 下面这里不需要考虑的原因是:B在A之前，所以B 如果碰到2会扔给C，所以不存在A到B之间的元素存在2的可能
//                if(nums[i] == 2){
//                    swap(nums,i,--end);
//                }
            }
            if(nums[i] == 2){
                while(  ( nums[--end] > 1) && (end>i));
                swap(nums,i,end);
                if(nums[i] == 0){
                    swap(nums,++tail,i);
                }
            }
        }
    }

    private static void swap(int [] nums ,int l ,int r){
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }

    @Test
    public void te(){
        int [] nums =
//                new int []{2,0,1,0}
                new int []{0}
//                new int []{1,2,0}
                ;
        sortColors(nums);
        Printor.println(nums);
    }
}
