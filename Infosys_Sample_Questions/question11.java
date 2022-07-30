package Infosys_Sample_Questions;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class question11 {
    /*
     * Problem Statement :

    You have an interesting string S of length N. It is interesting because you can rearrange the characters of this string in any order. You want to cut this string into some contiguous pieces such that after cutting, all the pieces are equal to one another.

    You can’t rearrange the characters in the cut pieces or join the pieces together. You want to make the number of pieces as large as possible. What is the maximum number of pieces you can get?

    Note: You can observe that you may not want to cut the string at all, therefore the number of pieces is 1. Hence, the answer always exists.

    Input Format

    S :: STRING
    The first line contains a string, S, denoting the string.
    length(S) :: 1 -> 2 * 10^5

    Sample Input 1:
        zzzzz

    Sample Output 1 :
        5

    Sample input 2:
        ababcc

    Sample Output 2:
        2

    Sample input 2:
        abccdcabacda

    Sample Output 2:
        2
     */

    static int findHCF(int a, int b) {
        int hcf = 0;
        for(int i=1; i<= a || i<= b;i++) {
            if(a%i == 0 && b%i == 0) hcf = i;
        }

        return hcf;
    }

    static int findHCFArray(int[] arr) {
        int n = arr.length;
        int hcf = findHCF(arr[0], arr[1]);

        if(n == 2) return hcf;

        for(int i=2;i<n;i++) {
            hcf = findHCF(hcf, arr[i]);
        }

        return hcf;
    }

    static int solution(String str) {
        Map<Character, Integer> map = new HashMap<>();
        int n = str.length();

        for(int i=0;i<n;i++) map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);

        if(map.size() == 1) return map.get(str.charAt(0));
        
        int[] frequencies = new int[map.size()];
        int i=0;

        for(Map.Entry<Character, Integer> entry : map.entrySet())  frequencies[i++] = entry.getValue();

        return findHCFArray(frequencies);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int res = solution(str);
        System.out.println(res);

        sc.close();
    }
}
