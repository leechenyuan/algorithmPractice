package me.leechenyuan.practice.algorithms.leetcode.q133CloneGraph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by L on 17/3/19.
 */
public class UndirectedGraphNode {
          int label;
          List<UndirectedGraphNode> neighbors;
          UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>();
     }
}
