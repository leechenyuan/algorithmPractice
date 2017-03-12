package me.leechenyuan.practice.algorithms.leetcode;

/**
 * Created by L on 2017/3/7.
 */
public class Printor {
    public static void println(Object ob){
        System.out.println(ob);
    }
    public static void println(int [] nums){
        for(int i:nums){
            System.out.print(i + ",");
        }
        System.out.println();
    }
}
