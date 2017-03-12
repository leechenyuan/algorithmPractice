package me.leechenyuan.practice.algorithms.leetcode.L88;

import java.util.Arrays;

/**
 * Created by L on 2017/3/7.
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1 == null ){
            return;
        }
        if(nums2 != null){
            for(int i = 0;i<n;i++)    {
                nums1[m+i] = nums2[i];
            }
        }
        /**
         * 什么时候自己写一个排序，用自己的排序方法才屌
         */
        Arrays.sort(nums1);
    }
}
