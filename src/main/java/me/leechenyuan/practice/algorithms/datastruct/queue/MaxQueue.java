package me.leechenyuan.practice.algorithms.datastruct.queue;

/**
 * * Created by lee chenyuan on 2015/10/11.
 */
public interface MaxQueue<T extends  Comparable<T>> {
    public void insert(T t); //如果数据结构可以动态扩容，insert返回void比返回boolean好
    public T getMax();
    public T deleteMax();
    public boolean isEmpty();
    public int size();
}
