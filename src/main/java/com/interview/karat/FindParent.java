package com.interview.karat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jerry Wang on 20/10/2018.
 */
public class FindParent {

    // find 1 parent or 0 parent node
    public List<Integer> findparent(int[][] edges){
        ArrayList<Integer> re = new ArrayList<>();

        Map<Integer,List<Integer>> map = new HashMap<>();

        for(int[] edge:edges){
            if(!map.containsKey(edge[1])){
                map.put(edge[1],new ArrayList<>());
            }

            if(!map.containsKey(edge[0])){
                map.put(edge[0],new ArrayList<>());
            }

            List<Integer> edgeMap = map.get(edge[1]);
            edgeMap.add(edge[0]);
        }

        for(int node: map.keySet()){
            if(map.get(node).size() == 0 || map.get(node).size() == 1)
                re.add(node);
        }

        return re;
    }


    boolean hasCommonAncestor(int[][] edges, int a, int b){
        return false;
    }

}