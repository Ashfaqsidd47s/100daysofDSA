import java.util.Arrays;

public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m -1;
        int j = n - 1;

        int l = nums1.length-1;

        while (i >= 0 || j >= 0) {
            if(i < 0){
                nums1[l] = nums2[j];
                l--;
                j--;
            } else if(nums1[i] > nums2[j]) {
                nums1[l] = nums1[i];
                l--;
                i--;
            } else {
                nums1[l] = nums2[j];
                l--;
                j--;
            }
        }

    }

    public static void main(String[] args) {
        int[] nums1 = {0,0,0,0,0};
        int[] nums2 = {1,3,5,6,8};
        int n = nums2.length;
        merge(nums1, 0, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
