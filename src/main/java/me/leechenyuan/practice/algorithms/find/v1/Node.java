package me.leechenyuan.practice.algorithms.find.v1;

/**
 * * Created by lee chenyuan on 2015/11/5.
 */
public class Node<K extends Comparable,V> {
    private K key;
    private V value ;
    private Node left;
    private Node right;
    public Node(K key,V value,Node left,Node right) {
        this.key = key ;
        this.value = value ;
        this.left = left ;
        this.right = right ;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
