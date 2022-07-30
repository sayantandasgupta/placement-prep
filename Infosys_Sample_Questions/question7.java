package Infosys_Sample_Questions;

import java.util.Scanner;

public class question7 {
    /*
     * Problem Statement :

        One of the first lessons IT students learn is the representation of natural numbers in the binary number system (base 2) This system uses only two digits, 0 and 1. In everyday life we use for convenience the decimal system (base 10) which uses ten digits, from 0 to 9. In general, we could use any numbering system.

        Computer scientists often use systems based on 8 or 16. The numbering system based on K uses K digits with a value from 0 to K-1. Suppose a natural number M is given, written in the decimal system To convert it to the corresponding writing in the system based on K, we successively divide M by K until we reach a quotient that is less than K

        The representation of M in the system based on K is formed by the final quotient (as first digit) and is followed by the remainder of the previous divisionsFor example :

        If M=122 and K=8, 122 in base 10= 172 in base 8 This means that the number
        In decimal system = 172 in octal system.
        172 in base 8 = 1*8^2 + 7*8 + 2 = 122 
        You made the following observation in applying the above rule of converting natural numbers to another numbering system

        In some cases in the new representation all the digits of the number are the same. For example 63 in base 10= 333 in base 4
        Given a number M in its decimal representation, your task is find the minimum base B such that in the representation of M at base B all digits are the same.

        Input Format

        The first line contains an integer, M, denoting the number given
        Constraints

        1 <= M = 10^12
        Sample Input 1 :

            41

        Sample Output 1 :

            40

        Explanation :

        Here 41 in base 40. will be 11 so it has all digits the same, and there is no smaller base satisfying the requirements 

        Sample Input 2 :

            34430

        Sample Output 2 :

        312

        Explanation :

        Here 34430 in base 312 will have all digits the same and there is no smaller base satisfying the requirements
     */

    private static boolean toAnyBase(int n, int base) {
        int rem = n%base;

        n /= base;

        while(n >= base && (n%base == rem)) n /= base;

        if(n == rem) return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int base = 2;

        while(toAnyBase(m, base) != true) base++;

        System.out.println(base);
        sc.close();
        
    }
}
