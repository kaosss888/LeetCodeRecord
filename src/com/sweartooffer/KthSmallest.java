package com.sweartooffer;

/**
 * 有序矩阵中第K小的元素
 */
public class KthSmallest {

    public int kthSmallest(int[][] matrix, int k) {

        int n = matrix.length;
        int lo = matrix[0][0], hi = matrix[n-1][n-1];
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0,  j = matrix[0].length - 1;
            for(int i = 0; i < matrix.length; i++) {
                while(j >= 0 && matrix[i][j] > mid) j--;
                count += (j + 1);
            }
            if(count < k)
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }
}
