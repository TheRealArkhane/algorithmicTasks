package algorithmicTasks;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
    public static int lengthOfLongestSubstring(String s) {
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
}
