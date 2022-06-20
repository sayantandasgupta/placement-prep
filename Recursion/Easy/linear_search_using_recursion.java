package Recursion.Easy;

public class linear_search_using_recursion {
    
    static int solution(int[] arr, int target, int idx) {
        if(idx == arr.length) return -1;

        else if(arr[idx] == target) return idx;

        return solution(arr, target, idx+1);
    }

    public static void main(String[] args) {
        int[] arr = {9,8,3,0,4,7,5,6,2,1};
        int target = -5;

        System.out.println(solution(arr, target, 0));
    }
}
