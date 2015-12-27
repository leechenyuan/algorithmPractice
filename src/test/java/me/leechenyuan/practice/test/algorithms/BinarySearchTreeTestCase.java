package me.leechenyuan.practice.test.algorithms;

import me.leechenyuan.practice.algorithms.find.v1.BinarySearchTree;
import me.leechenyuan.practice.algorithms.find.v1.SymbolTable;
import org.junit.Test;

/**
 * Created by Administrator on 2015/12/20.
 */
public class BinarySearchTreeTestCase {
    @Test
    public void t(){
        SymbolTable<String,Integer> st = new BinarySearchTree<>();
        st.put("3",4);
        st.put("4",5);
        st.put("5",6);
        st.put("5",7);
        System.out.println(st.get("3"));
        System.out.println(st.get("4"));
        System.out.println(st.get("5"));
        System.out.println(st.get("A"));
        st.put("A",9);
        System.out.println(st.get("A"));
        st.put("A",null);
        System.out.println(st.get("A"));
    }
}
