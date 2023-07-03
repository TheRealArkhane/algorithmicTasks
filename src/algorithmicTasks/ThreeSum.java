package algorithmicTasks;

//Given an integer array nums, return all the triplets
// [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
//
//        Notice that the solution set must not contain duplicate triplets.
//
//        Example 1:
//
//        Input: nums = [-1,0,1,2,-1,-4]
//        Output: [[-1,-1,2],[-1,0,1]]
//        Explanation:
//        nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
//        nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
//        nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
//        The distinct triplets are [-1,0,1] and [-1,-1,2].
//        Notice that the order of the output and the order of the triplets does not matter.

//        Example 2:
//
//        Input: nums = [0,1,1]
//        Output: []
//        Explanation: The only possible triplet does not sum up to 0.
//        Example 3:
//
//        Input: nums = [0,0,0]
//        Output: [[0,0,0]]
//        Explanation: The only possible triplet sums up to 0.

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4, 3, -2, 5, -3, 6, -3, 10, 4, 6, -7, -11, 8, -12, 11, -14, 14}));
    }
    //i learned the solution
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            if(i == 0 || nums[i] != nums[i - 1]) {
                int left = i + 1;
                int right = nums.length - 1;
                int sum = -nums[i];
                while(left < right) {
                    if(nums[left] + nums[right] == sum) {
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while(left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while(left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    }
                    else if(nums[left] + nums[right] < sum) {
                        left++;
                    }
                    else {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
