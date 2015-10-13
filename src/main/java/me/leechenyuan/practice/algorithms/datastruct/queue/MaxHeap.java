package me.leechenyuan.practice.algorithms.datastruct.queue;

import java.util.Arrays;

/**
 * * Created by lee chenyuan on 2015/10/11.
 */
public class MaxHeap<T extends Comparable<T> > implements MaxQueue<T>{
    final static int HEAD_INDEX = 1 ;
    final static int DEFAULT_INTI_SIZE  = 16 ;
    T [] heapArray;
    int currentSize  = 0 ;

//    public MaxHeap(T [] arr,int size){
//        heapArray =(T [])new  Comparable<T> [currentSize]; //TODO 这句话为什么不行？
//        heapArray =(T [])new  Comparable [size];
//    }

    public MaxHeap(){
        heapArray = (T [])new  Comparable [DEFAULT_INTI_SIZE];
    }
    public MaxHeap(int size){
        heapArray =(T [])new  Comparable [size];
    }
    @Override
    public void insert(T t) {
        if(currentSize >= heapArray.length){
            // 数组扩容
            heapArray = Arrays.copyOf(heapArray,heapArray.length * 2);
        }
        heapArray[currentSize] = t ;
        swim(currentSize);
        currentSize ++ ;
    }

    @Override
    public T getMax() {
        return heapArray[HEAD_INDEX];
    }

    @Override
    public T deleteMax() {
        T max = heapArray[HEAD_INDEX];
        /**
         *  TODO 为什么将最后的元素放到堆的顶部，然后再下沉 ？
         */
        swap(currentSize-1,HEAD_INDEX);
        sink(HEAD_INDEX);
        currentSize -- ; // 很容易漏掉这个.....
        return max;
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    @Override
    public int size() {
        return currentSize;
    }

    /**
     * 将元素上浮
     * 它的实现至关重要!!!
      * @param index
     */
    private void swim(int index){
        int parennt = index /2 ;
        while(index > HEAD_INDEX && lessThan(parennt,index)){
            swap(index,parennt);
            index = parennt ;
            parennt = parennt / 2 ;
        }
    }
    /**
     * 将元素下沉
     * 我最容易弄混淆的地方
     *      。 我们怎么知道到底这个元素有几个子元素？
     *      。 如果有两个子元素，我们到底和哪个进行交换 ？ 理由又是什么？
     *
     * @param index
     */
    private void sink(int index){
        int childIndex = index << 1;
        while(hasChild(index) && lessThan(index,childIndex) ){ // 有孩子，并且小于孩子的情况下才下沉
            swap(index,childIndex);

            index = childIndex ;
            childIndex = index << 1; //TODO 为什么每次都只交换 index*2这个child，而不是index*2+1的这个child ?
        }
    }

    private boolean hasChild(int index){
//        return currentSize >= (index << 1); 不是 >= 而是 >
        return currentSize > (index << 1);
    }

    private boolean lessThan(int aIndex,int bIndex){
        return heapArray[aIndex].compareTo(heapArray[bIndex]) < 0;
    }

    private void swap(int aIndex,int bIndex){
        T tmp = heapArray[aIndex];
        heapArray[aIndex] = heapArray[bIndex];
        heapArray[bIndex] = tmp ;
    }



}
