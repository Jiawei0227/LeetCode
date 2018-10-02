package com.top100Liked;

/**
 * Created by Jerry Wang on 14/07/2018.
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        if(needle.isEmpty())
            return 0;
        for(int i = 0;i<=haystack.length() - needle.length();i++){
            int j = 0;
            while(haystack.charAt(i+j) == needle.charAt(j)){
                if(j == needle.length()-1)
                    return i;
                j++;
            }
        }
        haystack.indexOf(needle);
        return -1;
    }
}
