package Infosys_Sample_Questions;

public class question6 {

    /*
     * Problem Statement :

        Khaled has an array A of N elements. It is guaranteed that N is even. He wants to choose at most N/2 elements from array A. It is not necessary to choose consecutive elements.  Khaled is interested in XOR of all the elements he chooses. Here, XOR denotes the bitwise XOR operation. 

        For example:

        If A=[2,4,6,8], then khaled can choose the subset [2,4,8] to achieve XOR=(2 XOR 4 XOR 8)=14.
        Khaled wants to maximize the XOR of all the elements he chooses. Your task is to help khaled to find the max XOR of a subset that he can achieve by choosing at most N/2 elements?

        Input format:

        The first line contains an integer, N, denoting the number of elements in A.
        Each line i of the N subsequent lines(where 0<=i<=N) contains an integer describing Ai.
        Constraints 

        1<=N<=120
        1<=A[i]<=10^6
        Sample Input 1

        2
        1
        2
        Sample Output 1 
        2

        Explanation:

        N=2,  A=[1,2] khaled can choose the subset[2]. The xor of the elements in the subset is 2. And the number of elements in the subset is 1 which is less than N/2.

        Sample Input 2
        4
        1
        2
        4 
        7

        Sample Output 2

        7

        Explanation:

        N=4,  A=[1,2,4,7] Khaled can choose the subset [7]. The xor of the elements in the subset is 7, and the number of elements in the subset is 1 which is less than N/2.
     */
    
    static int result = Integer.MIN_VALUE;

    static void helper(int index, int[] arr, int res) {
        if(index == arr.length / 2) result = Math.max(result, res);
        helper(index+1, arr, res);
        helper(index+1, arr, res^arr[index]);
    }

    static int solution(int[] arr) {
        return 0;
    }

    public static void main(String[] args) {
        
    }
}
