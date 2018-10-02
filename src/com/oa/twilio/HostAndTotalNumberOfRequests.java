package com.oa.twilio;

import java.io.*;
import java.util.HashMap;

/**
 * Created by Jerry Wang on 21/09/2018.
 */
public class HostAndTotalNumberOfRequests {

    public static void countNumber(File f){
        HashMap<String,Integer> map = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] res = line.split(" ");
                map.put(res[0],map.getOrDefault(res[0],0)+1);
                // process the line.
            }

            Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("filename.txt"), "utf-8"));
            for(String key: map.keySet()){
                writer.write(key+" "+map.get(key));
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void main(String args[]){
        String path = HostAndTotalNumberOfRequests.class.getClassLoader().getResource("hosts_access_log_00.txt").getPath();
        File f = new File(path);
        HostAndTotalNumberOfRequests.countNumber(f);
    }
}
