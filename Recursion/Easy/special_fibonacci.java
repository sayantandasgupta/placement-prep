package Recursion.Easy;

import java.util.Scanner;

public class special_fibonacci {
    /*
     * Sankalp recently learned Fibonacci numbers and now he is studying different algorithms to find them. After getting bored of reading them, he came with his own new type of numbers. He defined them as follows:

        f(0) = a;
        f(1) = b;
        f(n) = f(n-1) ^ f(n-2);  when n>1, where ^ denotes the bitwise xor operation.
        You are given three integers a,b and n , calculate f(n).

        Input

        The input contains one or more independent test cases.

        The first line of input contains a single integer T (1≤T≤103), the number of test cases.

        Each of the T following lines contains three space-separated integers a, b, and n (0≤a,b,n≤109) respectively.

        Output

        For each test case, output f(n).

        Constraints
        1<=T<=1000
        0<=a,b,n<=109
        Sample Input
        4
        86 77 15
        93 35 86
        92 49 21
        62 27 90
        Sample Input
        86
        126
        92
        62
     */

     static int helper(int a, int b, int n) {
        if(n == 0) return a;
        if(n == 1) return b;

        return helper(a,b,n-1) ^ helper(a,b,n-2);
     }

     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while(T > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int N = sc.nextInt();

            System.out.print(helper(a,b,N) + "\n");
            T--;
        }

        sc.close();
        return;
     }
}
