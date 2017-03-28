package me.leechenyuan.practice.algorithms.leetcode.q133CloneGraph;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by L on 17/3/19.
 */
public class Q133 {
    /**
     * Definition for undirected graph.
     * class UndirectedGraphNode {
     *     int label;
     *     List<UndirectedGraphNode> neighbors;
     *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
     * };
     */
        public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
            return createUndirected(node);
        }

        private Map<Integer,UndirectedGraphNode> mapping = new HashMap<>();
        private UndirectedGraphNode createUndirected(UndirectedGraphNode node ){
            if(node == null){
                return null;
            }
            UndirectedGraphNode toCreate = getNode(node);
            if(toCreate != null){
                return toCreate;
            }
            toCreate = new UndirectedGraphNode(node.label);
            putNode(toCreate);

            if(node.neighbors != null){
                for(UndirectedGraphNode no : node.neighbors){
                    toCreate.neighbors.add(createUndirected(no));
                }
            }
            return toCreate;
        }

        private UndirectedGraphNode getNode(UndirectedGraphNode node ){
            return mapping.get(node.label);
        }

        private UndirectedGraphNode putNode(UndirectedGraphNode node){
            return mapping.put(node.label,node);
        }

}
