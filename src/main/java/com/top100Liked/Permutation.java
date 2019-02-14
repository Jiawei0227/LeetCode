package com.top100Liked;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Jerry Wang on 05/09/2018.
 */
//46
public class Permutation {

    public List<List<Integer>> permute(int[] nums) {
        ArrayList result = new ArrayList();
        ArrayList numsList = new ArrayList<>();
        for(int i = 0;i<nums.length ; i++){
            numsList.add(nums[i]);
        }
        permuteIteration(numsList,new ArrayList<>(),result);
        return result;
    }

    private void permuteIteration(List<Integer> numList, List<Integer> temp, ArrayList result){
        if (numList.size() == 0 && !result.contains(temp)) {
            result.add(temp);
            return;
        }

        for(int i = 0; i<numList.size() ;i ++){
            List<Integer> halfList = new ArrayList<>(temp);
            halfList.add(numList.get(i));
            int number = numList.remove(i);
            permuteIteration(numList,halfList,result);
            numList.add(i,number);
        }

    }


    //47
    public List<List<Integer>> permuteUnique(int[] nums) {
        ArrayList result = new ArrayList();
        ArrayList numsList = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0;i<nums.length ; i++){
            numsList.add(nums[i]);
        }
        permuteIteration2(numsList,new ArrayList<>(),result);
        return result;
    }

    private void permuteIteration2(List<Integer> numList, List<Integer> temp, ArrayList result){
        if (numList.size() == 0) {
            result.add(temp);
            return;
        }

        for(int i = 0; i<numList.size() ;i ++){
            List<Integer> halfList = new ArrayList<>(temp);
            halfList.add(numList.get(i));
            int number = numList.remove(i);
            permuteIteration(numList,halfList,result);
            numList.add(i,number);
            while((i!= numList.size()-1)&&(numList.get(i) == numList.get(i+1))) i++;
        }

    }

}
