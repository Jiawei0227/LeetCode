package com.top100Liked;

import java.util.HashMap;

/**
 * Created by Jerry Wang on 11/07/2018.
 */
public class Int2Roman {
    static HashMap<Integer,String> romanMap = new HashMap<Integer, String>();
    static HashMap<Character,Integer> romanMap2 = new HashMap<Character, Integer>();
    static {
        romanMap.put(4,"IV");
        romanMap.put(9,"IX");
        romanMap.put(40,"XL");
        romanMap.put(90,"XC");
        romanMap.put(400,"CD");
        romanMap.put(900,"CM");
        romanMap.put(1,"I");
        romanMap.put(5,"V");
        romanMap.put(10,"X");
        romanMap.put(50,"L");
        romanMap.put(100,"C");
        romanMap.put(500,"D");
        romanMap.put(1000,"M");

        romanMap2.put('I',1);
        romanMap2.put('V',5);
        romanMap2.put('X',10);
        romanMap2.put('L',50);
        romanMap2.put('C',100);
        romanMap2.put('D',500);
        romanMap2.put('M',1000);


    }

    public static String intToRoman(int num) {
        StringBuilder str = new StringBuilder();

        int zeroNum = 1;
        while(num>0){
            int number = (num%10)*zeroNum;
            num = num/10;

            if(romanMap.containsKey(number)){
                str.insert(0,romanMap.get(number));
            }else{
                StringBuilder temp = new StringBuilder();
                if(number > 5*zeroNum){
                    temp.append(romanMap.get(5*zeroNum));
                    number -= 5*zeroNum;
                }
                for(int i = 0; i<number;i+=zeroNum)
                    temp.append(romanMap.get(zeroNum));
                str.insert(0,temp.toString());
            }
            zeroNum = zeroNum*10;
        }
        return str.toString();
    }

    public static int romanToInt(String s) {
        int value = 0;
        int tmpMax = romanMap2.get(s.charAt(s.length()-1));
        System.out.println(tmpMax);
        for(int i = s.length()-1; i>=0;i--){
            int number = romanMap2.get(s.charAt(i));
            if(tmpMax>number)
                value -= number;
            else {
                value += number;
                tmpMax = number;
            }
        }

        return value;

    }

    public static void main(String args[]){
        //System.out.println(Int2Roman.intToRoman(3));
        System.out.println(Int2Roman.romanToInt("MCMXCIV"));
    }
}
