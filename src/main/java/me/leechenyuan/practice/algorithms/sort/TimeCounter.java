package me.leechenyuan.practice.algorithms.sort;

/**
 * * Created by lee chenyuan on 2015/9/30.
 */
public class TimeCounter {
    private long begin ;
    private TimeCounter(){
        begin = System.currentTimeMillis();
    };
    public static TimeCounter startCounting(){
        TimeCounter timeCounter = new TimeCounter();
        return timeCounter ;
    }

    public long usingSeconds(){
        return (System.currentTimeMillis()-begin)/1000;
    }
}
