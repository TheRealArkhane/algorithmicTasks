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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    //TODO: Work In Progress, this is not a solution, this is part of it
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int i;
        int j;
        int k;
        for (int o = 0; o < nums.length - 2; o++) {
            i = nums[o];
            j = nums[o + 1];
            k = nums[o + 2];
            if (i == j && i != 0) {
                continue;
            }
            if (i + j > 0) {
                for (int p = o + 1; p < nums.length; p++) {
                    k = nums[p];
                    if (k > 0) {
                        continue;
                    }
                    addListOfSumToResult(result, i, j, k);
                }
            }
            if (i + j < 0) {
                for (int q = o + 1; q < nums.length; q++) {
                    k = nums[q];
                    if (k < 0) {
                        continue;
                    }
                    addListOfSumToResult(result, i, j, k);
                }
            }
            if (i + j == 0) {
                for (int l = o + 1; l < nums.length; l++) {
                    k = nums[l];
                    if (k != 0) {
                        continue;
                    }
                    List<Integer> sumList = new ArrayList<>();
                    sumList.add(i);
                    sumList.add(j);
                    sumList.add(k);
                    result.add(sumList);
                }
            }
        }
        return result;
    }

    public void addListOfSumToResult(List<List<Integer>> result, int i, int j, int k) {
        if (i + j + k == 0) {
            List<Integer> sumList = new ArrayList<>();
            sumList.add(i);
            sumList.add(j);
            sumList.add(k);
            result.add(sumList);
        }
    }
}
