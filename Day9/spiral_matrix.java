package Day9;

import java.util.ArrayList;
import java.util.List;

public class spiral_matrix {

    /**
     * Given an m x n matrix, return all elements of the matrix in spiral order.

 

        Example 1:

        Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
        Output: [1,2,3,6,9,8,7,4,5]

        Example 2:

        Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
        Output: [1,2,3,4,8,12,11,10,9,5,6,7]

        

        Constraints:

            m == matrix.length
            n == matrix[i].length
            1 <= m, n <= 10
            -100 <= matrix[i][j] <= 100

     */

     /**
      * Simple and most easy solution
      * Consider 4 variables, rowBegin, rowEnd, colBegin, colEnd. These variables will help us specify which column or row we should add next
      */

    public static List<Integer> solution(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        
        int rowBegin = 0, rowEnd = m-1, colBegin = 0, colEnd = n-1;
        
        List<Integer> res = new ArrayList<>();
        
        while(rowBegin <= rowEnd && colBegin <= colEnd) {
            
            //Traverse Right
            
            for(int j=colBegin;j<=colEnd;j++){
                res.add(matrix[rowBegin][j]);
            }
            
            rowBegin++;
            
            //Traverse Down
            for(int i=rowBegin;i<=rowEnd;i++) {
                res.add(matrix[i][colEnd]);
            }
            
            colEnd--;
            
            if(rowBegin <= rowEnd) {
                //Traverse Left
                for(int j = colEnd; j>= colBegin;j--){
                    res.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;
            
            if(colBegin <= colEnd) {
                //Traverse Up
                
                for(int i=rowEnd;i>=rowBegin;i--) {
                    res.add(matrix[i][colBegin]);
                }
            }
            colBegin++;            
        }
        
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};

        List<Integer> res = solution(matrix);

        for(int i : res) {
            System.out.print(i + " ");
        }

        System.out.print("\n");
    }
    
}
