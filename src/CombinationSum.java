import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Jerry Wang on 04/09/2018.
 */
//39
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList result = new ArrayList<>();
        Arrays.sort(candidates);

        ArrayList<Integer> numberList = new ArrayList<>();
        combinationSumIteration(numberList,target,candidates,result, 0);
        return result;

    }

    private void combinationSumIteration(List<Integer> numberInList, int target, int[] candidatesList ,List result, int start){
        if(target == 0){
            result.add(numberInList);
            return;
        }
        for(int i = start ;i< candidatesList.length ;i++){
            if((target >= 2*candidatesList[i])||target == candidatesList[i]){
                List number = new ArrayList(numberInList);
                number.add(candidatesList[i]);
                combinationSumIteration(number,target-candidatesList[i],candidatesList,result,i);
            }
        }
    }

    //40
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList result = new ArrayList<>();
        Arrays.sort(candidates);

        ArrayList<Integer> numberList = new ArrayList<>();
        combinationSumIteration2(numberList,target,candidates,result, 0);
        return result;

    }

    private void combinationSumIteration2(List<Integer> numberInList, int target, int[] candidatesList ,List result, int start){
        if(target == 0){
            result.add(numberInList);
            return;
        }
        for(int i = start ;i< candidatesList.length ;i++){
            if((target >= 2*candidatesList[i])||target == candidatesList[i]){
                List number = new ArrayList(numberInList);
                number.add(candidatesList[i]);
                int jumpNumber = 1;
                //while(candidatesList[i+jumpNumber] == candidatesList[i]) jumpNumber++;
                combinationSumIteration(number,target-candidatesList[i],candidatesList,result,i+1);
                while((i+1)<candidatesList.length && candidatesList[i+1] == candidatesList[i]) i++;
            }
        }
    }

    public static void main(String args[]){
        CombinationSum combinationSum = new CombinationSum();
        int[] a = new int[]{2,3,5};
        combinationSum.combinationSum(a,8);
    }
}
