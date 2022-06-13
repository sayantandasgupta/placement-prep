package Day14;

import java.util.HashMap;
import java.util.Map;

public class longest_substring_without_repeating_characters {

    /**
     * Given a string s, find the length of the longest substring without repeating
     * characters.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: s = "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     * Example 2:
     * 
     * Input: s = "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     * Example 3:
     * 
     * Input: s = "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     * Notice that the answer must be a substring, "pwke" is a subsequence and not a
     * substring.
     * 
     * 
     * Constraints:
     * 
     * 0 <= s.length <= 5 * 104
     * s consists of English letters, digits, symbols and spaces.
     */

    /**
     * First we need to understand what type of algorithm we should use for this
     * problem,
     * 1. We have been given a string
     * 2. We need to find the longest substring from the given string
     * Therefore, this is a sliding window problem. Since we do not have the window
     * size, this is a variable size sliding window problem.
     */

    /**
     * Solution - Using a HashMap to store the count of individual elements in the
     * map
     * the condition for checking would be the following
     * 
     * while(j < string size)
     * Store the count of the elements
     * if(map.size() == j - i +1) // Where i is the leftmost element and j is the
     * rightmost element of the sliding window
     * max = Maximum of max and j-i+1
     * j++;
     * else if(map.size() < j-i+1 )
     * remove 1 count of the character at i from the map
     * if the count becomes 0, then remove the key itself from the map
     * i++;
     * 
     * finally return max;
     */

    public static int solution(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int i = 0, j = 0, max = 0;

        while (j < s.length()) {
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);

            if (map.size() == j - i + 1) {
                max = Math.max(max, j - i + 1);
                j++;
            } else if (map.size() < j - i + 1) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                if (map.get(s.charAt(i)) == 0)
                    map.remove(s.charAt(i));
                i++;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";

        System.out.print(solution(s));
    }
}
