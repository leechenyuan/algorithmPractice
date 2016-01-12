package me.leechenyuan.practice.algorithms.find.v1;

/**
 * 二叉查找树树
 */
public class BinarySearchTree<K extends Comparable<K>, V> implements SymbolTable<K, V> {
    private Node<K, V> root = null;

    //递归的本质 : 一颗树由Key,Value 还有两个子节点组成
    private void put(K key, V value, Node<K, V> curNode) {
        if (curNode.getKey().compareTo(key) == 0) {
            curNode.setValue(value);
            return;
        }

        if (key.compareTo(curNode.getKey()) < 0) {
            if (curNode.getLeft() == null) {
                curNode.setLeft(new Node<K, V>(key, value, null, null));
            } else {
                put(key, value, curNode.getLeft());
            }
        } else {
            if (curNode.getRight() == null) {
                curNode.setRight(new Node<K, V>(key, value, null, null));
            } else {
                put(key, value, curNode.getRight());
            }
        }
        curNode.setSize(size(curNode));
    }

    @Override
    public void put(K key, V value) {
        if (root == null) {
            root = new Node<>(key, value, null, null);
            return;
        }
        put(key, value, root);
    }

    @Override
    public V get(K key) {
        return get(root, key);
    }

    private V get(Node<K, V> node, K key) {
        if (node == null) {
            return null;
        }
        if (node.getKey().compareTo(key) == 0) {
            return (V) node.getValue();
        } else if (key.compareTo(node.getKey()) < 0) {
            return (V) get(node.getLeft(), key);
        } else {
            return (V) get(node.getRight(), key);
        }
    }

    @Override
    public void remove(K key) {
        V value = get(key);
        root = remove(root,key);
    }

    public Node<K,V> remove(Node<K,V> node,K key){
        if(node == null){
            return null;
        }
        if(node.getKey().compareTo(key)==0) {
            if(node.getLeft() == null){
                return node.getRight();
            }
            if(node.getRight() == null){
                return node.getLeft();
            }
            Node minNode = min(node.getRight()); //
            minNode.setLeft(node.getLeft());
            minNode.setRight(deleteMin(node.getRight()));
            return minNode;
       }else if(key.compareTo(node.getKey())<0){
             node.setLeft(remove(node.getLeft(),key));
            return node;
        }else{
            node.setRight(remove(node.getRight(),key));
            return node ;
        }
    }
//    @Override
//    public void remove(Node<K, V> root, K key) {
//        this.root = remove(this.root,key);
//    }

//    public Node<K,V> remove(Node<K,V> node,K k){
//        if(root == null){
//            return null;
//        }else if(node.getLeft() != null && node.getRight() !=null){
//            //deleteMax(node.getRight());
//        }else{
//
//        }
//    }


//    private Node<K,V> deleteMax(Node<K,V> node){
//        if(node == null || node.getRight() == null){
//            return null;
//        }
//        Node<K,V> right = deleteMax(node.getRight());
//        node.setRight(right);
//
//        return right;
//    }
//

    public void deleteMin(){
        root = deleteMin(root);
    }
    private Node<K,V> deleteMin(Node<K,V> node){
        if(node == null ){
            return null;
        }
        if(node.getLeft() == null){
            return node.getRight();
        }else{
            Node<K,V> childNode = deleteMin(node.getLeft());
            node.setLeft(childNode);
            return node;
        }
    }
    public void deleteMax(){
        root = deleteMax(root);
    }
    public Node<K,V> deleteMax(Node<K,V> node){
        if(node == null){
            return null;
        }
        if(node.getRight() == null){
            return node.getLeft();
        }else{
            Node<K,V> rNode = deleteMax(node.getRight());
            node.setRight(rNode);
            return node;
        }
    }

    public K max(){
        Node<K,V> max = max(root);
        if(max != null){
            return max.getKey();
        }
        return null;
    }
    public K min(){
        Node<K,V> min = min(root);
        if(min != null){
            return min.getKey();
        }
        return null;
    }
    public Node<K,V> min(Node<K,V> node){
        if(node == null){
            return null;
        }else if(node.getLeft()!=null){
            return min(node.getLeft());
        }else{
            return node;
        }
    }

    public Node<K,V> max(Node<K,V> node) {
        if(node == null){
            return node;
        }else if(node.getRight() !=null){
            return max(node.getRight());
        }else{
            return node;
        }
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node<K, V> node) {
        if (node == null) {
            return 0;
        }
        return 1 + size(node.getLeft()) + size(node.getRight());
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

}
