/**
 * Created by Jerry Wang on 04/09/2018.
 */
public class RotatedSearch {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length-1;
        while(lo<hi) {
            int mid = (lo+hi)/2;
            if(nums[mid]>nums[hi]){
                lo = mid+1;
            }else{
                hi = mid;
            }
        }
        int rot = lo;
        lo = 0; hi = nums.length-1;
        if(nums[0]<target){
            hi = rot;
        }else{
            lo = rot;
        }
        while(lo<hi){
            int mid = (lo+hi)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid]>target){
                hi = mid;
            }else if(nums[mid]<target){
                lo = mid+1;
            }
        }

        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length-1;
        int firstFind = -1;

        if(nums.length == 0)
            return new int[]{-1,-1};

        while(lo<=hi){
            int mid = (lo+hi)/2;
            if(target == nums[mid]){
                firstFind = mid;
                break;
            }else if(target<nums[mid]){
                hi = mid-1;
            }else
                lo = mid+1;
        }
        //System.out.println(firstFind + " " + lo + " " + hi);

        if(firstFind == -1)
            return new int[]{-1,-1};

        int left = lo;
        int right = firstFind;
        while(left<right){
            int mid = (left+right)/2;
            if(target == nums[mid]){
                right = mid;
            }else
                left = mid+1;
        }
        int leftRange = left;

        left = firstFind;
        right = hi;
        while(left<right){
            int mid = (left+right)/2+1;
            if(target == nums[mid]){
                left = mid;
            }else
                right = mid-1;
        }

        int rightRange = right;

        return new int[]{leftRange,rightRange};

    }
}
