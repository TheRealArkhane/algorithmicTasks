package algorithmicTasks;

//Given an array of strings strs, group the anagrams together. You can return the answer in any order.
//
//        An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
//        typically using all the original letters exactly once.
//
//        Example 1:
//
//        Input: strs = ["eat","tea","tan","ate","nat","bat"]
//        Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
//        Example 2:
//
//        Input: strs = [""]
//        Output: [[""]]
//        Example 3:
//
//        Input: strs = ["a"]
//        Output: [["a"]]

import java.util.*;

class GroupAnagrams {

    public static void main(String[] args) {
        System.out.println(groupAnagrams2(new String[]{"kolya", "lokya", "don", "nod", "aykol", "jan"}));
    }

    // O(n * m);
    // based on a turnkey solution
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        if (strs.length == 0) {
            return result;
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            int[] hash = new int[26]; //for [a - z] letters
            for (char letter : word.toCharArray()) {
                hash[letter - 'a']++; // (- 'a') because of ASCII specifics
            }
            // any word in strs becomes an array of numbers of equal letters of it, then
            // if this array with this hashcode already exists, it adding into existing ArrayList this word
            // else program at first creates it
            String key = Arrays.toString(hash);
            map.computeIfAbsent(key, x -> new ArrayList<>());
            map.get(key).add(word);
        }
        // finally, we get perfectly sorted list of lists of anagrams using HashMap
        result.addAll(map.values());
        return result;
    }

    // after better look to HashMap<K,T> API
    public static List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : strs) {
            char[] wordAsCharArray = word.toLowerCase().toCharArray();
            Arrays.sort(wordAsCharArray);
            if (map.containsKey(String.valueOf(wordAsCharArray))) {
                map.get(String.valueOf(wordAsCharArray)).add(word);
            } else {
                map.put(String.valueOf(wordAsCharArray), new ArrayList<>());
                map.get(String.valueOf(wordAsCharArray)).add(word);
            }
        }
        return new ArrayList<>(map.values());
    }
}