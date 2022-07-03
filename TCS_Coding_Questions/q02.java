package TCS_Coding_Questions;

public class q02 {
    /*
     * Problem Statement –

        Joseph is learning digital logic subject which will be for his next semester. He usually tries to solve unit assignment problems before the lecture. Today he got one tricky question. The problem statement is “A positive integer has been given as an input. Convert decimal value to binary representation. Toggle all bits of it after the most significant bit including the most significant bit. Print the positive integer value after toggling all bits”.

        Constrains-

        1<=N<=100

        Example 1:

        Input :

        10  -> Integer

        Output :

        5    -> result- Integer

        Explanation:

        Binary representation of 10 is 1010. After toggling the bits(1010), will get 0101 which represents “5”. Hence output will print “5”.
     */

     static String decToBin(int n) {
        StringBuilder sb = new StringBuilder();
        while(n>0) {
            int rem = n%2;
            sb.insert(0, rem);
            n = n/2;
        }

        return sb.toString();
     }

     static int solution(int n) {
        String bin = decToBin(n);

        char[] binArray = bin.toCharArray();

        for(int i=0;i<binArray.length;i++) {
            if(binArray[i] == '1') binArray[i] = '0';
            else binArray[i] = '1';
        }

        bin = new String(binArray);
        return Integer.parseInt(bin, 2);
     }

     public static void main(String[] args) {
        int n = 100;

        System.out.println(solution(n));
     }
}
