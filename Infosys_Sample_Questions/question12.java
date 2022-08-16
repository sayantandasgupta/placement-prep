package Infosys_Sample_Questions;

import java.util.Scanner;

public class question12 {

    /*
     * Problem Statement :

        You need to build a road in a rugged terrain. You know the sea level of each segment of the rugged terrain, i.e., the i-th segment is Li meters from sea level.

        You need to transform the terrain into a strictly downward sloping terrain for the road, i.e., for each i-th segment where 2 <= i <= N, resultant Li-1 > Li. To do so, you employ a powerful digging team to help you dig and reduce the sea level of the segments. On day D, the team can reduce the sea level for each segment that you scheduled that day by 2D-1 meters each.

        You are allowed to assign the team to dig on multiple segments and/or dig on the same segments for multiple days.

        Your task is to find the minimum number of days needed to transform the terrain as per your requirements.

        Input Format

        N :: INTEGER
        The first line contains an integer, N, denoting the number of elements in L. N :: 1 -> 10^5

        L :: INTEGER ARRAY
        Each line i of the N subsequent lines (where 0 < i ≤ N) contains an integer describing Li, the sea level of the i-th segment. L[i] :: -10^9 -> 10^9

        Sample Input 1:
            2
            3
            3

        Sample Output 1 :
            1

        Sample input 2:
            2
            5
            -3

        Sample Output 2:
            0
     */
    static int solution(int[] arr, int n) {
        int count = 0, d = 1;

        for(int i=0;i<n-1;i++) {
            if(arr[i+1] >= arr[i]) {
                for(int j=1;j<=2*i-1;j++) {
                    arr[i+1] -= j;
                    if(arr[i+1] >= arr[i]) continue;
                    else break;
                }
                count++;
            }
        }

        return count;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        int res = solution(arr, n);

        System.out.println(res);

        sc.close();
    }
}
