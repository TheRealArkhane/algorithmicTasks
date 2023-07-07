package algorithmicTasks;

//You are given an m x n integer matrix matrix with the following two properties:
//
//        Each row is sorted in non-decreasing order.
//        The first integer of each row is greater than the last integer of the previous row.
//        Given an integer target, return true if target is in matrix or false otherwise.
//
//        You must write a solution in O(log(m * n)) time complexity.

//Example 1:
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//        Output: true

//Example 2:
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//        Output: false

public class SearchA2DMatrix {
    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{1}, {3}}, 0));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int indexOfArray = (matrix.length - 1) / 2;
        if (matrix.length == 1) {
            int searchIndex = search(matrix[0], target);
            if (searchIndex == -1){
                return false;
            }
            return target == matrix[0][searchIndex];
        }
        while (target > matrix[indexOfArray][matrix[indexOfArray].length - 1]
                && indexOfArray < matrix.length - 1) {
            indexOfArray++;
        }
        while (target < matrix[indexOfArray][0]
                && indexOfArray > 0) {
            indexOfArray--;
        }
        int searchIndex = search(matrix[indexOfArray], target);
        if (searchIndex == -1){
            return false;
        }
            return target == matrix[indexOfArray][searchIndex];
    }

    public static int search(int[] nums, int target) {
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
