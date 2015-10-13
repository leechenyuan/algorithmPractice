package me.leechenyuan.practice.algorithms.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * * Created by lee chenyuan on 2015/10/11.
 */
public enum  SortTester {
    INSTANCE;
    public static void sortIt(ISorter iSorter,int testTimes,int dataMaxSize){
        Random random = new Random();
        int tryTime = 0;
        int dataSize = Math.abs(random.nextInt()) % dataMaxSize;
        while((tryTime ++) < testTimes) {
            int[] testDataForTest = new int[dataSize];
            int[] testDataForJDK_Sort;
            for (int i = 0; i < dataSize; i++) {
                testDataForTest[i] = random.nextInt();
            }
            testDataForJDK_Sort = Arrays.copyOf(testDataForTest, testDataForTest.length);
            long begin = System.currentTimeMillis();
            Arrays.sort(testDataForJDK_Sort);
            long jdkUsingTime = System.currentTimeMillis() - begin;

            begin = System.currentTimeMillis();
            iSorter.sort(testDataForTest, 0, testDataForTest.length - 1);

            long mySortUsingTime = System.currentTimeMillis() - begin;
            org.junit.Assert.assertArrayEquals(testDataForTest,testDataForJDK_Sort);

            System.out.println("you escape " + tryTime + "times ");
            System.out.println("jdk using time : "+jdkUsingTime);
            System.out.println("you using time : "+mySortUsingTime);
            System.out.println("millis percentage more than jdk quickSort  : " + (((mySortUsingTime - jdkUsingTime)/(double)jdkUsingTime))*100);
        }
        System.out.println("well done....");
    }
}
