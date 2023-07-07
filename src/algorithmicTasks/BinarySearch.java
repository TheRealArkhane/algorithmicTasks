package algorithmicTasks;

//Given an array of integers nums which is sorted in ascending order,
// and an integer target, write a function to search target in nums.
// If target exists, then return its index. Otherwise, return -1.
//        You must write an algorithm with O(log n) runtime complexity.

import java.util.Arrays;

public class BinarySearch {
    public int search(int[] nums, int target) {
//        return Arrays.binarySearch(nums, target);
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int midVal = nums[mid];
            if (midVal < target) {
                left = mid + 1;
            }
            else if (midVal > target) {
                right = mid - 1;
            }
            else return mid;
        }
        return -1;
    }
}
