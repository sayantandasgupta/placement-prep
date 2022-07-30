package Infosys_Sample_Questions;

public class question1 {
    /*
     * Today you decided to go to the gym. You currently have energy equal to E units. There are N exercises in
        the gym. Each of these exercises drains Ai amount of energy from your body.
        You feel tired if your energy reaches 0 or below. Calculate the minimum number of exercises you have
        to perform such that you become tired. Every unique exercise can only be performed at most 2 times as
        others also have to use the machines.
        If performing all the exercises does not make you feel tired, return -1.

        Parameters:

            E :: INTEGER
            The first line contains an integer, E, denoting the Energy.
            E :: 1 -> 10^5
            N :: INTEGER
            The next line contains an integer, N, denoting the number of exercises.
            N :: 1 -> 10^5
            A :: INTEGER ARRAY
            Each line i of the N subsequent lines (where 0 ≤ i < N) contains an integer describing the amount of
            energy drained by i-th exercise.
            A[i] :: 1 -> 10^5

        Test Cases
        Case#: 1
            Input:
                6
                2
                1
                2
            Output:
                4
                E = 6
                Do 1st exercise 2 times
                Do 2nd exercise 2 times
                Hence, total exercises done 4.
     */

     static int solution(int E, int[] exercises) {
        int count = 0, n = exercises.length;
        int index = 0;

        while(E > 0 && index < n) {
            if(exercises[index] > E) {
                E -= exercises[index++];
                count++;
            }
            else if(E - exercises[index]*2 < E - exercises[index]) {
                E -= 2*exercises[index++];
                count += 2;
            } else {
                E -= exercises[index++];
                count++;
            }
        }

        return E>0 ? -1 : count;
     }

     public static void main(String[] args) {
        int E = 10;
        int[] a = {2,1};

        System.out.println(solution(E, a));
     }
}
