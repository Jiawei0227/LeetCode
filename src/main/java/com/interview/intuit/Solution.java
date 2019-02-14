package com.interview.intuit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Jerry Wang on 2018/10/23.
 */
public class Solution {
    // If you need extra classes, you can define them privately here within class Solution

    static void findFrequentEntries(List<List<String>> input) {

        //transfer input into employee Map for further process
        HashMap<String, List<Integer>> employeeMap = new HashMap<>();
        for(int i = 0 ; i<input.size() ; i++){
            String name = input.get(i).get(0);
            String time = input.get(i).get(1);

            if(!employeeMap.containsKey(name)){
                employeeMap.put(name,new ArrayList<>());
            }

            List<Integer> employeeEnterList = employeeMap.get(name);
            employeeEnterList.add(Integer.valueOf(time));
        }

        List<String> result = new ArrayList<>();

        for(String employeeName : employeeMap.keySet()){

            List<Integer> employeeEnterList = employeeMap.get(employeeName);
            //System.out.println(employeeEnterList.size());
            //Sort the enterlist in asc order
            employeeEnterList.sort((t1,t2)->(t1-t2));
            int startTime = employeeEnterList.get(0);
            for(int i = 1; i<employeeEnterList.size() ; i++) {

                int curTime = employeeEnterList.get(i);
                //System.out.println(curTime);
                if ((curTime - startTime) > 100) {
                    startTime = curTime;
                } else {
                    StringBuilder sb = new StringBuilder();
                    int j = i;
                    sb.append(employeeName).append(": ").append(startTime).append(" ");
                    while (j < employeeEnterList.size() && (employeeEnterList.get(j) - startTime) <= 100) {
                        sb.append(employeeEnterList.get(j)).append(" ");
                        j++;
                    }
                    //System.out.println(j-i+1);
                    //System.out.println(sb.toString());
                    if (j - i >= 2) {
                        result.add(sb.toString().substring(0, sb.length() - 1));
                        break;
                    } else {
                        startTime = curTime;
                    }
                }
            }

        }
    }

    // DO NOT MODIFY MAIN()
    public static void main(String[] args) {
        List<List<String>> input = new ArrayList<List<String>>();

        String line;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while ((line = br.readLine()) != "#") {
                if (line.equals("")) {
                    continue;
                }
                if (line.equals("#"))
                    break;

                List<String> pair = Arrays.asList(line.split(" "));
                input.add(pair);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        findFrequentEntries(input);
    }
}
