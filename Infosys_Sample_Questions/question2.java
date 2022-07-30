package Infosys_Sample_Questions;

import java.util.Arrays;

public class question2 {
    /*
     * There is a battle between heroes and villains going on. You have M heroes, all of them have the same
        health H. There are N villains, health of the i-th villain is Vi.
        When a hero, with health H battles a villain with health Vi, one of the three scenarios can happen:
        if H > Vi: The villain is defeated, and the health of the hero is decreased by Vi
        if H < Vi: The villain wins, his health is not affected, and the hero is no longer able to fight.
        if H = Vi: Both are considered defeated, and neither can fight.
        The heroes start fighting villains one by one in the same order, first villain 1 then villain 2 and so on. It
        might be possible that before defeating all the villains, all the heroes are defeated. Therefore, to ensure
        the victory of the heroes, you want to remove some villains from the front.
        Your task is to find the minimum number of villains you need to remove from the front such that the
        victory of the heroes is guaranteed.

        Note: If in the last battle, both the hero and villain are defeated and no more heroes or villains remain, it
        would still be considered a victory since all the villains are defeated.

        Parameters:
            N :: INTEGER
            The first line contains an integer, N, denoting the number of villains
            N :: 1 -> 2*10^5
            M :: INTEGER
            The next line contains an integer, M, denoting the number of heroes
            M :: 1 -> 2*10^5
            H :: INTEGER
            The next line contains an integer, H, denoting the health of each of the heroes
            H :: 1 -> 10^9
            array :: INTEGER ARRAY
            Each line i of the N subsequent lines (where 0 ≤ i < N) contains an integer describing the health of each
            of the villains.
            array[i] :: 1 -> 10^9

        Test Cases
        Case#: 1
            Input:
                4
                4
                3
                3
                1
                3
                3
            Output:
                0
        [3, 1, 3, 3]. We have 4 heroes will health 3. The heroes 1 will fight villain 1. Both get defeated. The hero 2
        fights villain 2. It wins the battle and now his health is 2. He fights the third villain and loses, the villain
        still has health 3. The hero 3 fights villain 3 and both get defeated. Hero 4 fights villain 4 and both get
        defeated. So, no need to remove any villain.
     */

     static int solution(int N, int M, int H, int[] V) {
        int[] hero = new int[M];
        Arrays.fill(hero, H);

        int i = 0, j = 0;

        while(i<M && j<N) {
            if(hero[i] > V[j]) hero[i] -= V[j++];
            else if(hero[i] < V[j]) i++;
            else {
                i++;
                j++;
            }
        }

        return j != N ? (N-j) : 0;
     } 

     public static void main(String[] args) {
        int N = 5, M = 1, H = 4;
        int[] V = {1,2,3,1,3};

        System.out.print(solution(N, M, H, V));
     }
}
