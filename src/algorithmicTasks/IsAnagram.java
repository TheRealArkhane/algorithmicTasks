package algorithmicTasks;

//Given two strings s and t, return true if t is an anagram of s, and false otherwise.
//
//        An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
//
//
//
//        Example 1:
//
//        Input: s = "anagram", t = "nagaram"
//        Output: true
//        Example 2:
//
//        Input: s = "rat", t = "car"
//        Output: false

import java.util.Arrays;

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        char[] charsOfS = s.toCharArray();
        char[] charsOfT = t.toCharArray();
        Arrays.sort(charsOfS);
        Arrays.sort(charsOfT);
        return Arrays.equals(charsOfS, charsOfT);
    }
}


