package me.leechenyuan.practice.algorithms.datastruct.queue;

import com.google.common.base.Strings;
import org.junit.Test;

import java.util.Random;

/**
 * * Created by lee chenyuan on 2015/10/12.
 */
public class TestCase {
    @Test
    public void test(){
        MaxQueue<Integer> priorityQueue ;
        Random random = new Random();
        int testTimes = 10 ;
//        int testDataMaxSize = 100 * 10000;
        int testDataMaxSize = 10;
        int count= 0 ;

        while((count++) < testTimes ){
            int randomDataSize = Math.abs(random.nextInt())%testDataMaxSize;
            priorityQueue = new MaxHeap<Integer>(randomDataSize);
//            Integer [] integers = new Integer [randomDataSize] ;
            for(int i = 0;i<randomDataSize;i++){
//                integers[i] = random.nextInt() ;
                priorityQueue.insert(random.nextInt());
            }
            System.out.println(Strings.repeat("-", 10)+"¶ÑµÄÕ¹Ê¾"+Strings.repeat("-",10));
            for(int i = 0;i<randomDataSize;i++){
//                integers[i] = random.nextInt() ;
                System.out.println(priorityQueue.deleteMax() + "\t");
            }
            System.out.println(Strings.repeat("-",10)+"END"+Strings.repeat("-",10));
        }
    }
}
