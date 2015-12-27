package me.leechenyuan.practice.algorithms.find.v1;

/**
 * 符号表
 */
public interface SymbolTable<K extends Comparable,V> {
    public void put(K key,V value);
    public V get(K key);
    public void remove(K key);
    public int size();
    public boolean  isEmpty();
}
