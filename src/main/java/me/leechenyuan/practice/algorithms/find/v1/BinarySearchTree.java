package me.leechenyuan.practice.algorithms.find.v1;

/**
 * 二叉查找树树
 */
public class BinarySearchTree<K extends Comparable<K>,V> implements SymbolTable<K,V>{
    private Node<K,V> root = null;

    //递归的本质 : 一颗树由Key,Value 还有两个子节点组成
    private void insert(K key,V value,Node<K,V> curNode){
       if(curNode.getKey().compareTo(key) == 0){
            curNode.setValue(value);
       }else if(key.compareTo(curNode.getKey()) < 0){
            if(curNode.getLeft() == null){
                curNode.setLeft(new Node<K,V>(key,value,null,null));
            }else{
                insert(key,value,curNode.getLeft());
            }
       }else{
            if(curNode.getRight() == null){
                curNode.setRight(new Node<K,V>(key,value,null,null));
            }else{
                insert(key,value,curNode.getRight());
            }
        }
    }
    @Override
    public void put(K key, V value) {
        if(root == null){
            root = new Node<>(key,value,null,null);
            return ;
        }
        insert(key,value,root);
    }

    @Override
    public V get(K key) {
        return get(root,key);
    }

    private V get(Node<K,V> node,K key){
          if(node == null){
             return null;
         }
         if(node.getKey().compareTo(key) == 0){
             return (V)node.getValue();
         }else if(key.compareTo(node.getKey()) < 0){
             return (V)get(node.getLeft(),key);
         }else{
            return (V)get(node.getRight(),key);
         }
    }

    @Override
    public void remove(K key) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

}
