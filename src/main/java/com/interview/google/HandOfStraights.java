package com.interview.google;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jerry Wang on 20/10/2018.
 */
public class HandOfStraights {
    public boolean isNStraightHand(int[] hand, int W) {
        if(hand.length%W != 0)
            return false;
        if(W == 1)
            return true;

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ; i<hand.length;i ++){
            list.add(hand[i]);
        }
        list.sort((o1,o2)->(o1-o2));
        return helper(list,W);
    }

    public boolean helper(List<Integer> list, int W){
        //System.out.println(list.size());
        if(list.size() == 0)
            return true;
        int count = 1;
        int startNumber = list.get(0);
        List<Integer> removeList = new ArrayList<Integer>();
        removeList.add(0);
        for(int i = 1 ;i<list.size(); i++){
            if(list.get(i) == (startNumber+count-1))
                continue;
            else if(list.get(i) == (startNumber+count)){
                count++;
                removeList.add(i);

                if(count == W){
                    for(int j = removeList.size()-1; j>=0; j--){
                        System.out.println(list.remove((int)removeList.get(j)));
                        System.out.println("removeindex:" + removeList.get(j));
                    }

                    list.forEach(System.out::print);
                    System.out.println();
                    return helper(list,W);
                }
            }else{
                //System.out.println(list.get(i) + "  "+count+ "  "+startNumber);
                return false;
            }
        }

        return false;
    }

    public static void main(String args[]){
        HandOfStraights h = new HandOfStraights();
        int[] test = new int[]{1,2,3,6,2,3,4,7,8};
        h.isNStraightHand(test,3);

    }

}
