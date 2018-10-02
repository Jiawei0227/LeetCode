package com.top100Liked;

/**
 * Created by Jerry Wang on 11/07/2018.
 */
public class RegularExpression {

    public static boolean isMatch(String s, String p) {
        if( s==null || p == null)
            return false;
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        // if s contains '*', then dp table [][i-2] should be the same value to dp table [0][i]
        for(int i = 0 ; i<p.length();i++){
            if(p.charAt(i) == '*' && dp[0][i-1])
                dp[0][i+1] = true;
        }
        for ( int i = 0;i< s.length() ;i++){
            for(int j = 0;j<p.length(); j++){
                if(s.charAt(i) == p.charAt(j)){
                    dp[i+1][j+1] = dp[i][j];
                }
                if(p.charAt(j) == '.'){
                    dp[i+1][j+1] = dp[i][j];
                }
                if(p.charAt(j) == '*'){
                    if(p.charAt(j-1) == '.' || p.charAt(j-1) == s.charAt(i))
                        dp[i+1][j+1] = (dp[i][j+1] || dp[i+1][j-1]);
                    else if(p.charAt(j-1) != s.charAt(i))
                        dp[i+1][j+1] = dp[i+1][j-1];
                }
            }
        }
        for(int i =0;i<s.length()+1;i++){
            for(int j = 0;j<p.length()+1;j++){
                System.out.print(dp[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println(dp[0][2]);
        return dp[s.length()][p.length()];
    }

    public static void main(String args[]){
        String s = "ab";
        String p = ".*";
        System.out.println(RegularExpression.isMatch(s,p));
    }

}
