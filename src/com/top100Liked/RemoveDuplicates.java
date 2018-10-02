package com.top100Liked;

/**
 * Created by Jerry Wang on 14/07/2018.
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] != nums[i-1]){
                nums[count] = nums[i];
                count ++;
            }
        }
        return count;
    }

    public int removeElement(int[] nums, int val) {
        int count = 0;
        int j = nums.length - 1;
        for(int i = 0 ;i<nums.length-count ;i++){
            if( i > j)
                break;
            if(nums[i] == val){
                count ++;
                while (i<j && nums[j] == val) {
                    j--;
                    count++;
                }
                if(j<0)
                    break;
                nums[i] = nums[j];
                j--;
            }
        }
        return nums.length-count;
    }
}
