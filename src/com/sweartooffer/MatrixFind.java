package com.sweartooffer;

public class MatrixFind {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int start = m + n - 1;
        while (m > 0 && n > 0) {
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[start] = nums1[m - 1];
                m--;
            } else {
                nums1[start] = nums2[n - 1];
                n--;
            }
            start--;
        }
        while (m > 0) {
            nums1[start] = nums1[m - 1];
            m--;
            start--;
        }
        while (n > 0) {
            nums1[start] = nums2[n - 1];
            n--;
            start--;
        }

        String str = "[";
        for (int i = 0; i < nums1.length; i++) {
            if (i != nums1.length - 1) {
                str = str + nums1[i] + ",";
            } else {
                str = str + nums1[i];
            }
        }
        System.out.println(str + "]");
    }

//    public static void main(String[] args) {
//        int[] nums1 = {1,2,3,0,0,0};
//        int m = 3;
//        int[] nums2 = {2,5,6};
//        int n = 3;
//        merge(nums1, m, nums2, n);
//    }
}
