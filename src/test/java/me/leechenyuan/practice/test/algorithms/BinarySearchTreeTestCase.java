package me.leechenyuan.practice.test.algorithms;

import me.leechenyuan.practice.algorithms.find.v1.BinarySearchTree;
import me.leechenyuan.practice.algorithms.find.v1.SymbolTable;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


/**
 * Created by Administrator on 2015/12/20.
 */
public class BinarySearchTreeTestCase {
    private static Logger logger = LoggerFactory.getLogger(BinarySearchTreeTestCase.class);
    @Test
    public void t(){
        BinarySearchTree<String,Integer> st = new BinarySearchTree<>();
        st.put("3",3);
        st.put("4",4);
        st.put("5",5);
        st.put("5",6);
        System.out.println(st.get("3"));
        System.out.println(st.get("4"));
        System.out.println(st.get("5"));
       logger.info("st size : " + st.size());

        logger.info("max " + st.max());
        logger.info("min " + st.min());
        st.deleteMin();
        st.deleteMax();
        System.out.println(st.get("3"));
        logger.info("st size : " + st.size());
        System.out.println(st.get("5"));
        System.out.println(st.get("4"));
            st.remove("4");
        System.out.println(st.get("4"));
        logger.info("st size : " + st.size());
        st.put("3",3);
        st.put("4",4);
        logger.info("st size : " + st.size());
        System.out.println(st.get("3"));
    }
}
