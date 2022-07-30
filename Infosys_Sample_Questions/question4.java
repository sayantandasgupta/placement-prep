package Infosys_Sample_Questions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class question4 {

    /*
     * While playing an RPG game, you were assigned to complete one of the hardest quests in this game. There are n monsters you’ll need to defeat in this quest. Each monster i is described with two integer numbers – poweri and bonusi. To defeat this monster, you’ll need at least poweri experience points. If you try fighting this monster without having enough experience points, you lose immediately. You will also gain bonusi experience points if you defeat this monster. You can defeat monsters in any order.

        The quest turned out to be very hard – you try to defeat the monsters but keep losing repeatedly. Your friend told you that this quest is impossible to complete. Knowing that, you’re interested, what is the maximum possible number of monsters you can defeat?

        (Question difficulty level: Hardest)

        Input:

        The first line contains an integer, n, denoting the number of monsters. The next line contains an integer, e, denoting your initial experience.
        Each line i of the n subsequent lines (where 0 ≤ i < n) contains an integer, poweri, which represents power of the corresponding monster.
        Each line i of the n subsequent lines (where 0 ≤ i < n) contains an integer, bonusi, which represents bonus for defeating the corresponding monster.

        INPUT:
            2
            123
            78
            130
            10
            0
        OUTPUT:
            2
        EXPLANATION:
            Initial Experience = 123 -> defeat first monster, gain 10 points -> Experience = 133 -> Defeat second monster
     */

    static class Monster {
        int power, bonus;
        public Monster(int power, int bonus) {
            this.power = power;
            this.bonus = bonus;
        }
    }

    static class MonsterComparator implements Comparator<Monster> {
        @Override
        public int compare(Monster m1, Monster m2) {
            if(m1.power < m2.power) return -1;
            else if(m1.power > m2.power) return 1;
            return 0;
        }
    }

    static int solution(int experience, int[] power, int[] bonus) {
        int numMonsters = power.length;
        Monster[] monsters = new Monster[numMonsters];

        for(int i=0;i<numMonsters;i++) {
            monsters[i] = new Monster(power[i], bonus[i]);
        }

        Arrays.sort(monsters, new MonsterComparator());

        int count = 0, i = 0;
        while(i < numMonsters && experience >= monsters[i].power) {
            experience += monsters[i].bonus;
            count++;
            i++;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int e = sc.nextInt();
        int[] power = new int[n], bonus = new int[n];

        for(int i=0;i<n;i++) power[i] = sc.nextInt();
        for(int i=0;i<n;i++) bonus[i] = sc.nextInt();

        int ans = solution(e, power, bonus);

        System.out.println(ans);

        sc.close();
    }
}
