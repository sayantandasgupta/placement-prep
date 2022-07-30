package Infosys_Sample_Questions;

import java.util.Arrays;
import java.util.Scanner;

public class question9 {

    /*
     * Problem Statement :

        There is a battle between heroes and villains going on. You have M heroes, all of them have the same health H. There are N villains, health of the i-th villain is Vi.

        When a hero, with health H battles a villain with health Vi, one of the three scenarios can happen:

        if H > Vi: The villain is defeated, and the health of the hero is decreased by Vi if H < Vi: The villain wins, his health is not affected, and the hero is no longer able to fight. if H = Vi: Both are considered defeated, and neither can fight.

        The heroes start fighting villains one by one in the same order, first villain 1 then villain 2 and so on. It might be possible that before defeating all the villains, all the heroes are defeated. Therefore, to ensure the victory of the heroes, you want to remove some villains from the front.

        Your task is to find the minimum number of villains you need to remove from the front such that the victory of the heroes is guaranteed.

        Note: If in the last battle, both the hero and villain are defeated and no more heroes or villains remain, it would still be considered a victory since all the villains are defeated.

        Input Format

        N :: INTEGER
        The first line contains an integer, N, denoting the number of villains N :: 1 -> 2*10^5

        M :: INTEGER
        The next line contains an integer, M, denoting the number of heroes M :: 1 -> 2*10^5

        H :: INTEGER
        The next line contains an integer, H, denoting the health of each of the heroes H :: 1 -> 10^9

        array :: INTEGER ARRAY
        Each line i of the N subsequent lines (where 0 ≤ i < N) contains an integer describing the health of each of the villains.
        array[i] :: 1 -> 10^9

        Sample Input 1:
            4
            4
            3
            3
            1
            3
            3

        Sample Output 1 :
            0

        Sample input 2:
            5
            3
            3
            1
            2
            3
            1
            1

        Sample Output 2:
            0

        Sample input 3:
            5
            1
            4
            1
            2
            3
            1
            3

        Sample Output 3:
            3
     */

    static int solution(int M, int[] H, int[] V, int N) {
        int i=0, j = 0;

        while(i<N && j< M) {
            if(V[i] < H[j]) H[j] -= V[i++];
            else if(V[i] > H[j]) j++;
            else {
                i++;
                j++;
            }
        }

        if(i == N) return 0;

        return N - i;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int H = sc.nextInt();
        int[] heroes = new int[M], V = new int[N];
        for(int i=0;i<N;i++) V[i] = sc.nextInt();

        Arrays.fill(heroes, H);

        int res = solution(M, heroes, V, N);

        System.out.println(res);

        sc.close();
    }
}
