/**
 * Created by Jerry Wang on 10/07/2018.
 */
public class MedianTwoSorts {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;
        if( m > n ){
            return findMedianSortedArrays(nums2,nums1);
        }
        int imin = 0;
        int imax = m;

        while(imin <= imax) {
            //System.out.println(imin + "min  " + imax+"max");
            //System.out.println(longer[0] + "longer shorter "+shorter[0]);
            int i = (imin + imax) / 2;
            int j = (m + n + 1) / 2 - i;
            System.out.println(i+"  "+j);
            if( i<m && nums2[j-1] > nums1[i]){
                //System.out.println("imin+1");
                imin = i + 1;
            }else if(i>0 && nums1[i-1] > nums2[j]){
                imax = i - 1;
            }else{
               // System.out.println("perfect");
                //perfect
                int max_left,max_right;
                if(i == 0){
                    max_left = nums2[j-1];
                }else if(j == 0){
                    max_left = nums1[i-1];
                }else{
                    max_left = Math.max(nums2[j-1],nums1[i-1]);
                }

                // odd
                if((m+n)%2 == 1)
                    return max_left;

                if(i == m){
                    max_right = nums2[j];
                }else if(j==n){
                    max_right = nums1[i];
                } else{
                    max_right = Math.min(nums2[j],nums1[i]);
                }

                return ((max_left+max_right)/2.0);
            }

        }
        return -1;

    }

    public static void main(String args[]){
        int[] a = {1,2};
        int[] b = {3,4};
        MedianTwoSorts m = new MedianTwoSorts();
        System.out.println(m.findMedianSortedArrays(a,b));
    }
}
