package me.leechenyuan.practice.algorithms.sort;

import org.junit.Test;

/**
 * * Created by lee chenyuan on 2015/10/11.
 */
public class MergeSort implements ISorter{
    @Override
    public void sort(int[] arr, int left, int right) {
        mergeSort(arr,left,right);
    }

    public static void mergeSort(int [] arr,int left,int right){
        if(arr == null || left >= right ){
            return;
        }
        int mid = (left+right)/2;
        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);

        merge(arr,left,mid,mid+1,right);
    }
    public static void merge(int [] arr,int aLeft,int aRight,int bLeft,int bRight){
        int i = aLeft ;
        int j = bLeft ;

        int k = 0 ;
        int [] tmp = new int [bRight-aLeft+1];
        while(k<tmp.length){
            if( i> aRight){
                while(j <= bRight){
                    tmp[k++] = arr[j++];
                }
                break ;
            }
            if( j > bRight){
                while(i <= aRight) {
                    tmp[k++] = arr[i++];
                }
                break ;
            }
            if(arr[i] <= arr[j] ){
                tmp[k++] = arr[i++];
            }else{
                tmp[k++] = arr[j++];
            }
        }

        for(int z = 0;z< tmp.length;z++){
            arr[aLeft+z] = tmp[z];
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
        ISorter iSorter = new MergeSort();
        SortTester.sortIt(iSorter,testTimes,dataMaxSize);
    }
}
