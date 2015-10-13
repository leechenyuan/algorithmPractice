package me.leechenyuan.practice.algorithms.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * * Created by lee chenyuan on 2015/9/30.
 */
public class QuickSort {
    static Sort sort = new RecursiveQuickSort();

    static public void sort(Comparable[] arr, int left, int right) {
        System.out.println("this is a bit slow");
        sort.sort(arr, left, right);
    }

    static public void sort(int[] arr, int left, int right) {
        PrimitiveTypeRecursiveQuickSort.sort(arr, left, right);
    }

    //TODO　这个排序有问题，记得检查！
    static class PrimitiveTypeRecursiveQuickSort {
        static public void sort(int[] arr, int left, int right) {
            if (arr == null) throw new IllegalArgumentException("fuck");
            if (left >= right) return;

            int pivot = partrition(arr, left, right);
            PrimitiveTypeRecursiveQuickSort.sort(arr, left, pivot - 1);
            PrimitiveTypeRecursiveQuickSort.sort(arr, pivot + 1, right);
        }

        static int partrition(int arr[], int left, int right) {
            int pivot = getRandom(left, right);
            swap(arr, left, pivot);
            pivot = left;
            int i = left; // .....这里模糊代表了什么？
            int j = right;
            while (pivot < j) {
//                while (arr[j].compareTo(arr[pivot]) >= 0 && (j > left)) {//TODO ？为什么改成 j> left会出错？
                while (arr[j] >= arr[pivot] && (j > pivot)) {
                    j--;
                }
                if (j > pivot) { // TODO　关键的问题 : 当 j < pivot的时候不能够交换,而不是当 j 小于 left的时候。因为 当 j > left && j <pivot的时候，arr[j]< arr[pivot]，而不是大于arr[pivot]这个时候不符合交换的原则
                    swap(arr, j, pivot);
                    i = pivot + 1;
                    pivot = j;
                } else {
                    break;
                }
                while ((i < pivot) && (arr[i] <= arr[pivot])) {
                    i++;
                }
                if (i < pivot) {
                    swap(arr, i, pivot);
                    j = pivot - 1;
                    pivot = i;
                } else {
                    break;
                }
            }
            return pivot;
        }

        private static void swap(int[] arr, int left, int right) {
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
        }
    }


    /*
         * 递归
         */
    static class RecursiveQuickSort implements Sort {
        Random random = new Random();

        @Override
        public void sort(Comparable[] arr, int left, int right) {
            if (arr == null) throw new IllegalArgumentException();
            if (right <= left) return;
            int pivot = partrition(arr, left, right);
            this.sort(arr, left, pivot - 1);
            this.sort(arr, pivot + 1, right);
        }

        <T extends Comparable> int partrition(T[] arr, int left, int right) {
            int pivot = getRandom(left, right);
            swap(arr, left, pivot);
            pivot = left;
            int i = left; // .....这里模糊代表了什么？
            int j = right;
            while (pivot < j) {
//                while (arr[j].compareTo(arr[pivot]) >= 0 && (j > left)) {//TODO ？为什么改成 j> left会出错？
                while (arr[j].compareTo(arr[pivot]) >= 0 && (j > pivot)) {
                    j--;
                }
                if (j > pivot) { // TODO　关键的问题 : 当 j < pivot的时候不能够交换,而不是当 j 小于 left的时候。因为 当 j > left && j <pivot的时候，arr[j]< arr[pivot]，而不是大于arr[pivot]这个时候不符合交换的原则
                    swap(arr, j, pivot);
                    i = pivot + 1;
                    pivot = j;
                } else {
                    break;
                }
                while ((i < pivot) && (arr[i].compareTo(arr[pivot]) < 0)) {
                    i++;
                }
                if (i < pivot) {
                    swap(arr, i, pivot);
                    j = pivot - 1;
                    pivot = i;
                } else {
                    break;
                }
            }
            return pivot;
        }
    }

    static interface Sort<T extends Comparable> {
        public void sort(T[] arr, int left, int right);
    }

    private static int getRandom(int begin, int end) {
        if (begin > end) throw new IllegalArgumentException("begin > end ");
        int random = (begin + end) / 2;
        return random;
    }

    private static <T> void swap(T[] arr, int left, int right) {
        T tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }


    @Test
    public void t() {
        Integer[] arr = {
//                -1834421472, -1901554022, -308248890, 158456413, 1338032478

//                1446105365,1596401734
                2, 3
        };
        QuickSort.sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test() {
        int tryTime = 100;
//        int maxElementSize = 100000;
        int maxElementSize = 10000000;
        Random random = new Random();
        for (int i = 0; i < tryTime; i++) {
//            System.out.println(" you escaped " + i + " times :) ");
            int arrSize = Math.abs(random.nextInt());
            System.out.println("quickSort size : " + arrSize);
            arrSize = arrSize % maxElementSize;
//            arrSize = 3;
            int[] arr = new int[arrSize];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = random.nextInt();
            }
            int[] jdkSort = Arrays.copyOf(arr, arr.length);

//            TimeCounter timeCounter = TimeCounter.startCounting();
            long starderBegin = System.currentTimeMillis();
            Arrays.sort(jdkSort);
            long useMillis = System.currentTimeMillis() - starderBegin ;
//            System.out.println("standard JDK quickSort using time : " + useMillis + " milliss");

//            Integer[] mySort = new Integer[arrSize];
//            for (int j = 0; j < arr.length; j++) {
//                mySort[j] = new Integer(arr[j]);
//            }
            int [] mySort = new int[arrSize];
            for (int j = 0; j < arr.length; j++) {
                mySort[j] = arr[j];
            }
            long begin = System.currentTimeMillis();
            QuickSort.sort(mySort, 0, arr.length - 1);
            long mySortUsingMillis = System.currentTimeMillis() - begin;
            long difference = mySortUsingMillis - useMillis ;
            System.out.println("use "+difference + " millis ");
            if(difference > 1000){
                System.out.println("-------------ao.................................so bad ");
            }

            boolean success = true;
            for (int j = 0; j < arr.length; j++) {
                if (mySort[j] != jdkSort[j]) {
                    success = false;
                    System.out.println("you are wrong !!!");
                    System.out.println("mysort[" + j + "] : " + mySort[j] + " != jdkSort[" + j + "" +
                            "] : " + jdkSort[j]);
                    System.out.println("origin  array : " + Arrays.toString(arr));
                    System.out.println("my quickSort array : " + Arrays.toString(mySort));
                    System.out.println("stanard array : " + Arrays.toString(jdkSort));
                    break;
                }
            }
            if (!success) {
                break;
            }
        }
    }

}
