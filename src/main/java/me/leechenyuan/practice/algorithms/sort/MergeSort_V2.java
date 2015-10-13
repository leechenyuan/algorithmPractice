package me.leechenyuan.practice.algorithms.sort;

import org.junit.Test;

/**
 * * Created by lee chenyuan on 2015/10/11.
 *  合并排序第二个版本
 */

/**
 *  疑惑 ：
 *      为什么重复利用临时的交换数组避免多次生成数组了，反而没有不这样做运行速度更快 呢？
 */
public class   MergeSort_V2 implements ISorter{
    private static MergeSort_V2 INSTANCE = new MergeSort_V2();

    @Override
    public void sort(int[] arr, int left, int right) {
        int [] swapArray = new int [right - left + 1];
        mergeSort(arr,left,right,swapArray);
    }

    public static void mergeSort(int [] arr,int left,int right,int [] swapArray){
        if(arr == null || left >= right ){
            return;
        }
        int mid = (left+right)/2;
        mergeSort(arr,left,mid,swapArray);
        mergeSort(arr,mid+1,right,swapArray);

        merge(arr,left,mid,mid+1,right,swapArray);
    }
    public static void merge(int [] arr,int aLeft,int aRight,int bLeft,int bRight,int [] swapArray){
        int i = aLeft ;
        int j = bLeft ;
        int length = bRight - aLeft + 1;
        int k = 0 ;
        while(k<length){
            if( i> aRight){
                while(j <= bRight){
                    swapArray[k++] = arr[j++];
                }
                break ;
            }
            if( j > bRight){
                while(i <= aRight) {
                    swapArray[k++] = arr[i++];
                }
                break ;
            }
            if(arr[i] <= arr[j] ){
                swapArray[k++] = arr[i++];
            }else{
                swapArray[k++] = arr[j++];
            }
        }

        for(int z = 0;z< length;z++){
            arr[aLeft+z] = swapArray[z];
        }
//        while((i<=aRight) && (j <= bRight) ){
//            if( i<= aRight ) {
//                if (arr[i] <= arr[j]) {
//                    tmp[k++] = arr[i++];
//                } else {
//                    tmp[k++] = arr[j++];
//                }
//            }
//        }
    }


    @Test
    public void testMergSort(){
        int dataMaxSize = 100 * 10000 ;
        int testTimes = 50 ;
        ISorter iSorter = MergeSort_V2.INSTANCE;
        SortTester.sortIt(iSorter,testTimes,dataMaxSize);
    }
}
