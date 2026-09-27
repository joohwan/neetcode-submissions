class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLen = matrix.length, colLen = matrix[0].length;
        int left = 0, right = rowLen * colLen - 1;
        int mid = 0;

        while (left <= right) {
            mid = left + (right - left) / 2;
            int row = mid / colLen;
            int col = mid % colLen;
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
