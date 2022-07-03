package Recursion.Medium;

import java.util.ArrayList;
import java.util.List;

public class different_ways_to_add_parenthesis {

    /*
     * Given a string expression of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. You may return the answer in any order.

        The test cases are generated such that the output values fit in a 32-bit integer and the number of different results does not exceed 104.

        

        Example 1:

        Input: expression = "2-1-1"
        Output: [0,2]
        Explanation:
        ((2-1)-1) = 0 
        (2-(1-1)) = 2
        Example 2:

        Input: expression = "2*3-4*5"
        Output: [-34,-14,-10,-10,10]
        Explanation:
        (2*(3-(4*5))) = -34 
        ((2*3)-(4*5)) = -14 
        ((2*(3-4))*5) = -10 
        (2*((3-4)*5)) = -10 
        (((2*3)-4)*5) = 10
        

        Constraints:

        1 <= expression.length <= 20
        expression consists of digits and the operator '+', '-', and '*'.
        All the integer values in the input expression are in the range [0, 99].
     */

    static List<Integer> solution(String expression) {
        List<Integer> res = new ArrayList<>();
        
        for(int i=0;i<expression.length();i++) {
            if(expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*') {
                String firstPart = expression.substring(0,i);
                String secondPart = expression.substring(i+1);
                
                List<Integer> resFirst = solution(firstPart);
                List<Integer> resSecond = solution(secondPart);
                
                for(int p1 : resFirst) {
                    for(int p2 : resSecond) {
                        int c = 0;
                        
                        switch(expression.charAt(i)) {
                            case '+': c = p1 + p2;
                                      break;
                            case '-': c = p1 - p2;
                                      break;
                            case '*': c = p1 * p2;
                                      break;
                        }
                        
                        res.add(c);
                    }
                }
            }
        }
        
        if(res.size() == 0) {
            res.add(Integer.valueOf(expression));
        }
        
        return res;
    }

    public static void main(String[] args) {
        
    }
}
