package Recursion.Easy;

public class check_if_array_is_sorted {
    /**
     * Given an array arr[] of size N, check if it is sorted in non-decreasing order or not. 

        Example 1:

        Input:
        N = 5
        arr[] = {10, 20, 30, 40, 50}
        Output: 1
        Explanation: The given array is sorted.
        Example 2:

        Input:
        N = 6
        arr[] = {90, 80, 100, 70, 40, 30}
        Output: 0
        Explanation: The given array is not sorted.

        Your Task:
        You don't need to read input or print anything. Your task is to complete the function arraySortedOrNot() which takes the arr[] and N as input parameters and returns a boolean value (true if it is sorted otherwise false).


        Expected Time Complexity: O(N)
        Expected Auxiliary Space: O(1)


        Constraints:
        1 ≤ N ≤ 105
        1 ≤ Arr[i] ≤ 106
     */

     static boolean iterative(int[] arr, int n) {
        for(int i=0;i<n-1;i++) {
            if(arr[i] > arr[i+1]) return false;
        }

        return true;
     }

     static boolean recursive(int[] arr, int n) {
        if(n == 0 || n ==1) return true;
        
        boolean x = recursive(arr, n-1);
        
        return x && (arr[n-1] >= arr[n-2]);
    }

     public static void main(String[] args) {
        int[] arr = {90, 80, 100, 70, 40, 30};

        System.out.print(recursive(arr, arr.length));
     }
}
