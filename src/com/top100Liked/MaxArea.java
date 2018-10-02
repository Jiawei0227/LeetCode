package com.top100Liked;

/**
 * Created by Jerry Wang on 11/07/2018.
 */
public class MaxArea {
    public static int maxArea(int[] height) {
        int[] dp = new int[height.length+1];
        dp[0] = 0;

        for(int i = 1; i< height.length ; i++){
            //get first max value from i
            int maxJValue = -1;
            for(int j = 0; j<i ;j++){
                int width = i-j;
                //before find the earliest high y, find the max
                if(height[j]>=height[i]) {
                    maxJValue = Math.max(width * height[i],maxJValue);
                    break;
                }
                maxJValue = Math.max(width * height[j],maxJValue);
            }

            dp[i+1] = Math.max(maxJValue,dp[i]);
        }

        return dp[height.length];
    }

    public static void main(String args[]){
        int[] test1 = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(MaxArea.maxArea(test1));
    }

}
