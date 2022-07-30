package Infosys_Sample_Questions;

public class question3 {

    /*
     * You need to build a road in a rugged terrain. You know the sea level of each segment of the rugged
        terrain, i.e., the i-th segment is Li meters from sea level.
        You need to transform the terrain into a strictly downward sloping terrain for the road, i.e., for each i-th
        segment where 2 <= i <= N, resultant Li-1 > Li. To do so, you employ a powerful digging team to help you
        dig and reduce the sea level of the segments. On day D, the team can reduce the sea level for each
        segment that you scheduled that day by 2D-1 meters each.
        You are allowed to assign the team to dig on multiple segments and/or dig on the same segments for
        multiple days.
        Your task is to find the minimum number of days needed to transform the terrain as per your
        requirements.

        Parameters:

            N :: INTEGER
            The first line contains an integer, N, denoting the number of elements in L.
            N :: 1 -> 10^5
            L :: INTEGER ARRAY
            Each line i of the N subsequent lines (where 0 < i ≤ N) contains an integer describing Li, the sea level of
            the i-th segment.
            L[i] :: -10^9 -> 10^9

        Test Cases
            Case#: 1
                Input:
                    2
                    3
                    3
                Output:
                    1
                We can dig on the 2nd segment, reducing it from 3-meter sea level to 2. Resulting in {3, 2} which is
                strictly decreasing.
            Case#: 2
                Input:
                    2
                    5
                    -3
                Output:
                    0
                It is already strictly decreasing before start.
     */

     static int solution(int n, int[] L) {
        int count = 0;
        for(int i=0;i<n-1;i++) {
            if(L[i] <= L[i+1]) {
                for(int j=1;j<=(2*i) - 1;j++) {
                    L[i+1] -= j;
                    if(L[i] <= L[i+1]) {
                        continue;
                    } else {
                        break;
                    }
                }
                count++;
            }
        }
        return count;
     } 

    public static void main(String[] args) {
        int n = 4;
        int[] L = {-1,1,1,1};

        System.out.print(solution(n, L));
    }    
}
