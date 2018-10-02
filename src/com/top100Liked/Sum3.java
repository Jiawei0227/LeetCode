package com.top100Liked;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Jerry Wang on 12/07/2018.
 */
public class Sum3 {

    public static List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i = 0; i+2 < nums.length ; i++){
            if(i>0 && nums[i] == nums[i-1]) //skip duplicate
                continue;

            int need = -nums[i];
            int m = i+1;
            int k = nums.length-1;

            while(m<k){
                if(need == (nums[m]+nums[k])){
                    res.add(Arrays.asList(nums[i],nums[m],nums[k]));

                    while(m+1<nums.length && nums[m+1] == nums[m])
                        m++; //skip same m
                    while(k>0 && nums[k-1] == nums[k])
                        k--;
                    m++;
                    k--;
                }else if((nums[m]+nums[k])>need){ //too much
                    k--;
                }else{
                    m++;
                }
            }
        }
        return res;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i = 0; i+3 < nums.length ; i++){
            if( i>0 && nums[i] == nums[i-1])
                continue;
            if(nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target) // useful to reduce search!!!!
                break;
            for(int j = i+1;j+2<nums.length ; j++){
                if(j>i+1 && nums[j] == nums[j-1])
                    continue;
                int need = target-nums[i]-nums[j];
                int m = j+1;
                int n = nums.length-1;

                while(m<n){
                    if(need == (nums[m]+nums[n])){
                        res.add(Arrays.asList(nums[i],nums[j],nums[m],nums[n]));

                        while(m+1<nums.length && nums[m+1] == nums[m])
                            m++; //skip same m
                        while(n>0 && nums[n-1] == nums[n])
                            n--;
                        m++;
                        n--;
                    }else if((nums[m]+nums[n])>need){ //too much
                        n--;
                    }else{
                        m++;
                    }
                }
            }
        }
        return res;
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        int absRES = Integer.MAX_VALUE;
        for(int i = 0; i+2 < nums.length ;i++){
            if(i>0 && nums[i] == nums[i-1]) //skip duplicate
                continue;

            int m = i+1;
            int n = nums.length-1;
            while(m<n){
                int result = nums[i] + nums[m] + nums[n] - target;
                if(Math.abs(result) < absRES){
                    res = result+target;
                    absRES = Math.abs(result);
                }

                if(result>0)
                    n--;
                else
                    m++;

            }
        }

        return res;
    }

    public static void main(String args[]){
        Sum3.threeSum(new int[]{-1,0,1,2,-1,-4});
    }

}
