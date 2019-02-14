package com.interview.stripe;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by Jerry Wang on 13/10/2018.
 */
public class NextServerNumber {

    class ServerRecord{
        PriorityQueue<Integer> p;
        int max;
    }

    HashMap<String, ServerRecord> map = new HashMap<>();

    public NextServerNumber(){

    }

    public static int nextServerNumber(int[] arrays){
        //O(n) time
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0 ;i<arrays.length; i++)
            set.add(arrays[i]);

        for(int i = 0 ;i<arrays.length;i++)
            if(!set.contains(i+1))
                return i+1;

        return arrays.length + 1;
    }

    public String allocate(String serverName){
        if(!map.containsKey(serverName)){
            ServerRecord serverRecord = new ServerRecord();
            serverRecord.p = new PriorityQueue<>();
            serverRecord.max = 2;
            map.put(serverName,serverRecord);
            return serverName+"1";
        }else{
            ServerRecord serverRecord = map.get(serverName);
            if(serverRecord.p.isEmpty()){
                String re = serverName + serverRecord.max;
                serverRecord.max ++;
                return re;
            }else{
                int number = serverRecord.p.poll();
                return serverName + number;
            }

        }
    }

    public void deallocate(String serverName){
        int i = serverName.length();
        while(i>0 && Character.isDigit(serverName.charAt(i-1))){
            i--;
        }
        int version = Integer.parseInt(serverName.substring(i));
        String server = serverName.substring(0,i);
        ServerRecord s = map.get(server);
        s.p.offer(version);
    }

    public static void main(String args[]){
//        System.out.println(nextServerNumber(new int[]{5,3,1}));
//        System.out.println(nextServerNumber(new int[]{5,4,1,2}));
//        System.out.println(nextServerNumber(new int[]{3,2,1}));
//        System.out.println(nextServerNumber(new int[]{2,3}));
//        System.out.println(nextServerNumber(new int[]{}));

        NextServerNumber nextServerNumber = new NextServerNumber();
        System.out.println(nextServerNumber.allocate("apibox"));
        System.out.println(nextServerNumber.allocate("apibox"));
        nextServerNumber.deallocate("apibox3");
        nextServerNumber.deallocate("apibox1");
        System.out.println(nextServerNumber.allocate("apibox"));
        System.out.println(nextServerNumber.allocate("apibox"));
        System.out.println(nextServerNumber.allocate("sitebox"));
    }
}
