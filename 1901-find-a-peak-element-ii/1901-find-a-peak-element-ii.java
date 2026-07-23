class Solution {

    public static int findRow(int[][] arr, int col) {
        int maxVal = -1;
        int maxRow = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i][col] > maxVal) {
                maxVal = arr[i][col];
                maxRow = i;
            }
        }

        return maxRow;
    }

    public int[] findPeakGrid(int[][] mat) {

        int low = 0;
        int high = mat[0].length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int maxRow = findRow(mat, mid);

            int left = (mid > 0)
                    ? mat[maxRow][mid - 1]
                    : -1;

            int right = (mid < mat[0].length - 1)
                    ? mat[maxRow][mid + 1]
                    : -1;

            if (mat[maxRow][mid] > left && mat[maxRow][mid] > right)
                return new int[]{maxRow, mid};

            else if (mat[maxRow][mid] < left)
                high = mid - 1;

            else
                low = mid + 1;
        }

        return new int[]{-1, -1};
    }
}