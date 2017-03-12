package me.leechenyuan.practice.algorithms.leetcode.q324;

/**
 *
 * @link : https://leetcode.com/problems/wiggle-sort-ii/?tab=Description
 */

import me.leechenyuan.practice.algorithms.leetcode.Printor;
import org.junit.Test;

/**
 * 这道题可以表示成 : n1 < m1 > n2 < m2 > n3....
 *
 * 因为总是 2个大于一个，很容易让人联想到二叉树，左子节点总是小于父节点和右兄弟节点
 */
public class Solution {
    //TODO not done yet
    public void wiggleSort(int[] nums) {
        if((nums == null) || nums.length < 2){
            return ;
        }
        boolean isBig = false;
        for(int i=0;i<nums.length;i++){
            isBig = (i%2 != 0) ;
            if(isBig ){
                if(nums[i-1] >= nums[i]) {
                    swap(nums,i-1,i);
                }
                if((i<nums.length -1) && (nums[i]<= nums[i+1])){
                    swap(nums,i,i+1);
                }
            }
        }
    }
    private static void swap(int []nums,int l,int r){
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }


    @Test
    public void te(){
        int [] nums =
//                new int []{1, 5, 1, 1, 6, 4}
//                new int []{1, 3, 2, 2, 3, 1}
//                new int []{1,2,3,4,5,6}
//                new int []{6,5,4,3,2,1}
//                new int [] {2,1}
                new int []{1,2,2,1,2,1,1,1,1,2,2,2}
                ;
        wiggleSort(nums);
        Printor.println(nums);
    }
}
