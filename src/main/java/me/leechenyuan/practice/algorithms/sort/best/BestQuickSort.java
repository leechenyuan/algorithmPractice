package me.leechenyuan.practice.algorithms.sort.best;

/**
 * * Created by lee chenyuan on 2015/10/11.
 */

import me.leechenyuan.practice.algorithms.sort.ISorter;
import me.leechenyuan.practice.algorithms.sort.SortTester;
import org.junit.Test;
/**
 *  这是我见过的最简洁的快排算法
 */
public class BestQuickSort implements ISorter{
    @Override
    public void sort(int[] arr, int left, int right) {
        quickSort(arr,left,right);
    }

    public static void quickSort(int[] arr, int left, int right){
        if(arr == null || left>=right){return ;}

        int pivotIndex = partritionn(arr,left,right);
        quickSort(arr, left, pivotIndex - 1);
        quickSort(arr, pivotIndex, right); //不是 index + 1,因为index实际上并不是最初我们选择的pivot的坐标
    }

    public static int partritionn(int [] arr,int left,int right){
        int i = left;
        int j = right ;
        int pivot = arr[(left+right)/2];
        int tmp = 0;
        while(i<=j){
            while(arr[i] < pivot) i++;
            while(arr[j] > pivot) j--;
            if(i<=j){
                if(i < j){
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp ;
                }
                i++ ;
                j-- ;
            }
        }
        return i ;
    }

    @Test
    public void test(){
        int dataMaxSize = 100 * 10000 ;
        int testTimes = 50 ;
        ISorter iSorter = new BestQuickSort();
        SortTester.sortIt(iSorter, testTimes,dataMaxSize);
   }
}
