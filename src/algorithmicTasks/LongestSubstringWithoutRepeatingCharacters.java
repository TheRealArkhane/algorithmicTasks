package algorithmicTasks;

//Given a string s, find the length of the longest
//        substring
//        without repeating characters.
//
//        Example 1:
//        Input: s = "abcabcbb"
//        Output: 3
//        Explanation: The answer is "abc", with the length of 3.

//        Example 2:
//        Input: s = "bbbbb"
//        Output: 1
//        Explanation: The answer is "b", with the length of 1.

//        Example 3:
//        Input: s = "pwwkew"
//        Output: 3
//        Explanation: The answer is "wke", with the length of 3.
//        Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    //solution for unique characters, not substring(
    public static int lengthOfLongestSubstring2(String s) {
       char[] array = s.toCharArray();
       Arrays.sort(array);
       int left = 0;
       int right = 1;
       int count = 1;
       if (array.length == 0) {
           return 0;
        }
       while (right < array.length) {
           if (array[left] != array[right]) {
               count++;
           }
           left ++;
           right ++;
       }
       return count;
    }

    //substring solution
    public static int lengthOfLongestSubstring(String s) {
        List<Character> substringL = new ArrayList<>();
        int largestlength = 0;
        for(int right = 0; right < s.length(); right++) {
            if(substringL.contains(s.charAt(right))) {
                // get the index of the char
                int index = substringL.indexOf(s.charAt(right));
                substringL.remove(index);
                if(index > 0)
                    substringL.subList(0, index).clear();
            }
            substringL.add(s.charAt(right));
            largestlength = Math.max(largestlength, substringL.size());
        }
        return largestlength;
    }
}
