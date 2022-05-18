package Day9;

public class word_search {

    /**
     * Given an m x n grid of characters board and a string word, return true if word exists in the grid.

        The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

        

        Example 1:

        Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
        Output: true

        Example 2:

        Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
        Output: true

        Example 3:

        Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
        Output: false

        

        Constraints:

            m == board.length
            n = board[i].length
            1 <= m, n <= 6
            1 <= word.length <= 15
            board and word consists of only lowercase and uppercase English letters.

     */

     /**
      * There is a recursive solution to this problem
      * For each element in the matrix, if the element is equal to the word[i] character, then we have to check all adjacent elements if any of them 
      * they are same as word[i+1] and continue the process until we reach the end of word array or any of the ends of the matrix.
      * Another false case is when any element of the matrix is not equal to word[i]
      */

    public static boolean exists(char[][] board, String word) {
        char[] w = word.toCharArray();
        
        for(int x=0;x<board.length;x++) {
            for(int y=0;y<board[x].length;y++) {
                if(helper(board, x, y, w, 0)) return true;
            }
        }
        
        return false;
        
    }

    //Recursive Function
    public static boolean helper(char[][] board, int x, int y, char[] word, int i) {
        if(i == word.length) return true;
        
        if(x<0 || y<0 || x == board.length || y == board[0].length) return false;
        if(board[x][y] != word[i]) return false;
        board[x][y] ^= 256;
        boolean exists = helper(board, x+1, y, word, i+1)
            || helper(board, x, y+1, word, i+1)
            || helper(board, x-1, y, word, i+1)
            || helper(board, x, y-1, word, i+1);
        
        board[x][y] ^= 256;
        return exists;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";

        System.out.print(exists(board, word));
    }
}
