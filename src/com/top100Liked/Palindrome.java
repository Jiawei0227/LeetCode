package com.top100Liked;

/**
 * Created by Jerry Wang on 11/07/2018.
 */
public class Palindrome {
    public boolean isPalindrome(int x) {
        if (x<0 || (x!=0 && x%10==0))
            return false;
        int rev = 0;
        while(rev < x){
            rev = rev*10 + x%10;
            x = x/10;
        }

        return (rev == x || rev == x/10);

    }
}
