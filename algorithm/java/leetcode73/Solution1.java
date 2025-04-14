package leetcode73;


/**
 * 矩阵置0
 * @author rogan
 * @date 2025/3/6
 */
public class Solution1 {

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] lineWithZero = new int[m];
        int[] columnWithZero = new int[n];

        // 找出有0存在的行
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    lineWithZero[i] = 1;
                    columnWithZero[j] = 1;
                    break;
                }
            }
        }
        // 找出有0存在的列
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                if (matrix[j][i] == 0) {
                    columnWithZero[i] = 1;
                    break;
                }
            }
        }

        // 有0的行赋值为0
        for (int i = 0; i < m; i++) {
            if (lineWithZero[i] == 1) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 有0的列赋值为0
        for (int i = n - 1; i >= 0; i--) {
            if (columnWithZero[i] == 1) {
                for (int j = 0; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }



    public static void main(String[] args) {
        {
            int[][] matrix = {
                    {0, 1, 2, 0},
                    {3, 4, 5, 2},
                    {1, 3, 1, 5}
            };
            setZeroes(matrix);
        }

        {
            int[][] matrix = {
                    {3,5,5,6,9,1,4,5,0,5},
                    {2,7,9,5,9,5,4,9,6,8},
                    {6,0,7,8,1,0,1,6,8,1},
                    {7,2,6,5,8,5,6,5,0,6},
                    {2,3,3,1,0,4,6,5,3,5},
                    {5,9,7,3,8,8,5,1,4,3},
                    {2,4,7,9,9,8,4,7,3,7},
                    {3,5,2,8,8,2,2,4,9,8}
            };
            setZeroes(matrix);
        }
    }
}