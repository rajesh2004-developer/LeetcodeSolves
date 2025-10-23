class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        int[] merged = new int[n];
        int i = 0, j = 0, k = 0;
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] < nums2[j]) {
                merged[k] = nums1[i];
                i++;
            }
            else {
                merged[k] = nums2[j];
                j++;
            }
            k++;
        }
        while(i < nums1.length) {
            merged[k] = nums1[i];
            i++;k++;
        }
        while(j < nums2.length) {
            merged[k] = nums2[j];
            j++;k++;
        }
        if(n % 2 == 0) return (double) (merged[n / 2] + merged[n / 2 - 1]) / 2;
        return merged[n / 2];
    }
}