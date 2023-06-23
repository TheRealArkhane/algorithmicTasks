package algorithmicTasks;

//Given an integer array nums, return true if any value appears at least twice in the array,
// and return false if every element is distinct.
//
//        Example 1:
//
//        Input: nums = [1,2,3,1]
//        Output: true
//
//        Example 2:
//
//        Input: nums = [1,2,3,4]
//        Output: false

import java.util.Arrays;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        int[] numsSorted = Arrays.stream(nums).sorted().toArray();
        for (int i = 0; i < numsSorted.length - 1; i++) {
            if (numsSorted[i] == numsSorted[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
