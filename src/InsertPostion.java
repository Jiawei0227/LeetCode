/**
 * Created by Jerry Wang on 04/09/2018.
 */
//35
public class InsertPostion {

    public int searchInsert(int[] nums, int target) {
        int lo = 0, hi = nums.length-1;
        while(lo<=hi){
            int mid = (lo+hi) >> 1;
            if(nums[mid]>target){
                hi = mid-1;
            }else if(nums[mid]<target){
                lo = mid+1;
            }else
                return mid;
        }
        return lo;

    }
}
