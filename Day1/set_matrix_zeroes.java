package Day1;

public class set_matrix_zeroes {
    /**
     * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

        You must do it in place.

        

        Example 1:

        Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
        Output: [[1,0,1],[0,0,0],[1,0,1]]

        Example 2:

        Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
        Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

        

        Constraints:

            m == matrix.length
            n == matrix[0].length
            1 <= m, n <= 200
            -231 <= matrix[i][j] <= 231 - 1

     */

    /**
     * 
     * Solution
     * One way of approaching this problem is, for every arr[i][j] = 0
     * We mark the beginning of the respective row and column by turning it into 0
     * After getting that array, we check which row and columns have been marked 0, and then replace every element of 
     * that particular row/column to 0
     * 
     * After that particular operation, we check for the first row / column if they have to be turned to 0
     */

    public static void solution(int[][] mat) {
        boolean isCol = false;

        int rows = mat.length, cols = mat[0].length;

        for(int i=0;i<rows;i++) {

            // Flagging if the first column has to be set to 0
            if(mat[i][0] == 0) isCol = true;

            for(int j=0;j<cols;j++) {
                if(mat[i][j] == 0) {
                    mat[i][0] = 0;
                    mat[0][j] = 0;
                }
            }
        }

        // Second iteration to convert the marked columns and rows to zero, this iteration starts from 1

        for(int i =1;i<rows;i++){
            for(int j=1;j<cols;j++){
                if(mat[i][0] == 0 || mat[0][j] == 0) mat[i][j] = 0;
            }
        }


        // Check if the first row needs to be converted to zero

        if(mat[0][0] == 0) {
            for(int j=0;j<cols;j++){
                mat[0][j] = 0;
            }
        }

        if(isCol) {
            for(int i=0;i<rows;i++){
                mat[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] mat = {{0,1,2,0}, {3,4,5,2}, {1,3,1,5}};

        int m = mat.length, n = mat[0].length;

        System.out.println("Initial Matrix");

        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(mat[i][j] + " ");
            }

            System.out.println();
        }

        solution(mat);

        System.out.println("Final Matrix");

        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(mat[i][j] + " ");
            }

            System.out.println();
        }
    }
}
