package Recursion.Easy;

public class reverse_number_using_recursion {
    /*
     * Given a number, reverse the number using recursion
     * 
     * I/P : 1234
     * O/P : 4321
     * 
     */

     static int res = 0;
     static void solution(int n) {
        if(n == 0) return;

        res = res*10 + n%10;

        solution(n/10);        
     }

     public static void main(String[] args) {
        solution(983038);

        System.out.println(res);
     }
}
