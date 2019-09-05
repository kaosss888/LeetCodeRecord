package com.sweartooffer;

public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;
        int n = matrix[0].length;
        int m = matrix.length;

        for(int i = 0, j = n - 1; i < m && j >= 0 ;) {
            if (target == matrix[i][j])
                return true;
            if (target > matrix[i][j]) {
                i++;
            } else if (target < matrix[i][j]) {
                j--;
            }
        }
        return false;
    }
}
