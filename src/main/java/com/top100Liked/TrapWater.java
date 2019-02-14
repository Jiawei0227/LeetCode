package com.top100Liked;

/**
 * Created by Jerry Wang on 05/09/2018.
 */
//42
public class TrapWater {
    public int trap(int[] height) {
        int sum = 0;
        //get highest location
        int maxLocation = -1;
        int maxValue = -1;
        int[] fullHeight = new int[height.length];
        for(int i = 0; i<height.length;i++){
            fullHeight[i] = height[i];
            if(height[i]>maxValue){
                maxValue = height[i];
                maxLocation = i;
            }
        }

        int left = maxLocation, right = maxLocation;
        while(left>0){
            left = getLeft(fullHeight,left-1);
        }
        while(right<height.length){
            right = getRight(fullHeight,right+1);
        }

        for(int i = 0;i<height.length ;i ++){
            sum += fullHeight[i]-height[i];
        }
        return sum;

    }

    public int trap2(int[] height){
        int sum = 0;
        int left = 0; int right = height.length-1;
        int maxLeft = height[left];
        int maxRight = height[right];
        while(left<=right){
            if(height[left]<=height[right]){
                if(height[left]<maxLeft)
                    sum+=(maxLeft-height[left]);
                else
                    maxLeft = height[left];
                left++;
            }else{
                if(height[right]>maxRight)
                    maxRight = height[right];
                else
                    sum += (maxRight-height[right]);
                right --;
            }
        }
        return sum;
    }

    private int getLeft(int[] fullHeight, int end){
        int maxLocation = -1;
        int maxValue = -1;
        for(int i = 0; i<=end; i++){
            if(fullHeight[i]>maxValue){
                maxValue = fullHeight[i];
                maxLocation = i;
            }
        }
        for(int i = maxLocation; i<=end ;i++){
            fullHeight[i] = maxValue;
        }

        return maxLocation;
    }

    private int getRight(int[] fullHeight, int start){
        int maxLocation = -1;
        int maxValue = -1;
        for(int i = start; i<=fullHeight.length; i++){
            if(fullHeight[i]>maxValue){
                maxValue = fullHeight[i];
                maxLocation = i;
            }
        }
        for(int i = start; i<=maxLocation ;i++){
            fullHeight[i] = maxValue;
        }

        return maxLocation;
    }
}
