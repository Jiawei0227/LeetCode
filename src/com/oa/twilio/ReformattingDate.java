package com.oa.twilio;

import java.util.HashMap;

/**
 * Created by Jerry Wang on 21/09/2018.
 */
public class ReformattingDate {
    static HashMap<String,String> maps = new HashMap<>();
    static{
        maps.put("Jan","01");
        maps.put("Feb","02");
        maps.put("Mar","03");
        maps.put("Apr","04");
        maps.put("May","05");
        maps.put("Jun","06");
        maps.put("Jul","07");
        maps.put("Aug","08");
        maps.put("Sep","09");
        maps.put("Oct","10");
        maps.put("Nov","11");
        maps.put("Dec","12");
    }

    public static String[] reformattingDate(String[] a){
        String[] re = new String[a.length];
        for(int i = 0;i<a.length ; i++){
            String date = a[i];
            String[] dateSplit = date.split(" ");
            StringBuilder val = new StringBuilder();
            val.append(dateSplit[2]).append("-");
            val.append(maps.get(dateSplit[1])).append("-");
            String day = dateSplit[0];
            if(day.length() == 3)
                val.append("0");
            val.append(dateSplit[0].substring(0,dateSplit[0].length()-2));

            re[i] = val.toString();
        }
        return re;
    }

    public static void main(String args[]){
        String[] test = new String[4];
        test[0] = "1st Mar 1984";
        test[1] = "2nd Feb 2013";
        test[2] = "4th Apr 1900";
        test[3] = "20th Dec 2018";
        String[] re = ReformattingDate.reformattingDate(test);
        for(String show : re)
            System.out.println(show);
    }

}
