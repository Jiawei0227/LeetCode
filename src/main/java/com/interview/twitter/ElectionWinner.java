package com.interview.twitter;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jerry Wang on 11/10/2018.
 */
public class ElectionWinner {
    static String electionWinner(String[] votes) {
        //create a HashMap(which can store key in order)
        HashMap<String, Integer> voteMap = new HashMap<String, Integer>();
        for(String vote: votes){
            voteMap.put(vote, voteMap.getOrDefault(vote,0) + 1);
        }

        //sort the hashmap entry in order
        return voteMap.entrySet().stream().max(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String,Integer> e1, Map.Entry<String,Integer> e2){
                if(e1.getValue() != e2.getValue())
                    return e2.getValue() - e1.getValue();
                else{
                    return e1.getKey().compareTo(e2.getKey());
                }
            }
        }).get().getKey();
    }
}
