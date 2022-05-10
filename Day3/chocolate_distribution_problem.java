package Day3;

import java.util.Arrays;

public class chocolate_distribution_problem {
    /**
     * Given an array of n integers where each value represents the number of chocolates in a packet. Each packet can have a variable number of chocolates. There are m students, the task is to distribute chocolate packets such that: 

        Each student gets one packet.
        The difference between the number of chocolates in the packet with maximum chocolates and packet with minimum chocolates given to the students is minimum.

    Examples:

        Input : arr[] = {7, 3, 2, 4, 9, 12, 56} , m = 3 
        Output: Minimum Difference is 2 
        Explanation:
        We have seven packets of chocolates and 
        we need to pick three packets for 3 students 
        If we pick 2, 3 and 4, we get the minimum 
        difference between maximum and minimum packet 
        sizes.

        Input : arr[] = {3, 4, 1, 9, 56, 7, 9, 12} , m = 5 
        Output: Minimum Difference is 6 
        Explanation:
        The set goes like 3,4,7,9,9 and the output 
        is 9-3 = 6
     */

    /**
     * 
     * A simple solution is to generate all subsets of size m of arr[0..n-1]. For every subset, find the difference between the maximum and minimum elements in it. Finally, return the minimum difference.
        An efficient solution is based on the observation that to minimize the difference, we must choose consecutive elements from a sorted packet. We first sort the array arr[0..n-1], then find the subarray of size m with the minimum difference between the last and first elements.
     * 
     * Here we will carry out the efficient solution
     */

    public static int solution(int[] arr, int m, int n){

        // If either m or n is zero, then none of the child will get a chocolate.
        if(m == 0 || n == 0) return 0;

        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;

        int i=0, j = m-1;

        while(j < arr.length) {
            int diff = arr[j] - arr[i];

            minDiff = Math.min(minDiff, diff);

            i++;j++;
        }

        return minDiff;
    }

    public static void main(String[] args) {
        int[] arr = {7, 3, 2, 4, 9, 12, 56};
        int n = 7, m = 3;

        System.out.print(solution(arr, m, n) + "\n");
    }
}
