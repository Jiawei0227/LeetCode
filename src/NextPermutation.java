/**
 * Created by Jerry Wang on 16/07/2018.
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length-1;
        int temp;
        while(i>0 && nums[i]<=nums[i-1]) i--;
        if(i != 0) {
            int xChange = nums[i - 1];
            int cha = Integer.MAX_VALUE;
            int pointer = i;
            for (int j = nums.length-1; j >i; j--) {
                if (nums[j] > xChange && (nums[j] - xChange) < cha) {
                    cha = (nums[j] - xChange);
                    pointer = j;
                }
            }

            temp = nums[i - 1];
            nums[i - 1] = nums[pointer];
            nums[pointer] = temp;
        }

        int j = nums.length - 1;
        while(i<j){
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
