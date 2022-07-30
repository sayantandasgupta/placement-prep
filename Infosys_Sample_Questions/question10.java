package Infosys_Sample_Questions;

import java.util.Arrays;
import java.util.Scanner;

public class question10 {

    /*
     * Problem Statement :

        Today you decided to go to the gym. You currently have energy equal to E units. There are N exercises in the gym. Each of these exercises drains Ai amount of energy from your body.

        You feel tired if your energy reaches 0 or below. Calculate the minimum number of exercises you have to perform such that you become tired. Every unique exercise can only be performed at most 2 times as others also have to use the machines.

        If performing all the exercises does not make you feel tired, return -1.

        Input Format
        E :: INTEGER
        The first line contains an integer, E, denoting the Energy.
        E :: 1 -> 10^5

        N :: INTEGER
        The next line contains an integer, N, denoting the number of exercises. N :: 1 -> 10^5

        A :: INTEGER ARRAY
        Each line i of the N subsequent lines (where 0 ≤ i < N) contains an integer describing the amount of energy drained by i-th exercise.
        A[i] :: 1 -> 10^5

        Sample Input 1:
            6
            2
            1
            2

        Sample Output 1 :
            4

        Sample input 2:
            10
            2
            1
            2

        Sample Output 2:
            -1

        Sample input 3:
            2
            3
            1
            5
            2

        Sample Output 3:
            1
     */

    static int solution(int E, int N, int[] exercises ) {
        int i=N-1, count = 0;
        Arrays.sort(exercises);
        while(i>=0 && E > 0) {
            if(exercises[i] > E) {
                i--;
            } else {
                if(2*exercises[i] <= E) {
                    E -= 2*exercises[i];
                    count += 2;
                } else {
                    E -= exercises[i];
                    count++;
                }

                i--;
            }
        }

        return E > 0 ? -1 : count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int E = sc.nextInt();
        int N = sc.nextInt();
        int[] exercises = new int[N];
        for(int i=0;i<N;i++) exercises[i] = sc.nextInt();

        int res = solution(E, N, exercises);

        System.out.println(res);

        sc.close();
    }
}
