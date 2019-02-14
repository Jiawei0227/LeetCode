package com.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Jerry Wang on 03/10/2018.
 */
public class Student {

    public int id;
    public String name;

    public static void main(String args[]){
        int a = 1;
        boolean b = true;
        String c = "hh";
        long d = 2;
        Byte f = 2;

        System.out.println(Integer.SIZE);
        System.out.println();
        System.out.println(Integer.SIZE);
        System.out.println(Integer.SIZE);
        System.out.println(Integer.SIZE);

        PriorityQueue pq = new PriorityQueue();

        Queue<String> q = new LinkedList<>();
        ArrayList aa = new ArrayList();
        BlockingQueue bl = new ArrayBlockingQueue(10);
        Queue<Integer> qq = new LinkedList<>();
        qq.isEmpty();
    }

}
