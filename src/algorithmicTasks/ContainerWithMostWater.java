package algorithmicTasks;

//You are given an integer array height of length n. There are n vertical
//        lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
//        Find two lines that together with the x-axis form a container,
//        such that the container contains the most water.
//        Return the maximum amount of water a container can store.
//        Notice that you may not slant the container.
//
//        Input: height = [1,8,6,2,5,4,8,3,7]
//        Output: 49
//        Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case,
//        the max area of water (blue section) the container can contain is 49.

public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
//    public static int maxArea(int[] height) {
//        int maxArea = 0;
//        for (int i = 0; i < height.length - 1; i++) {
//            if (height[i] == height[i + 1]) {
//                maxArea = Math.max(maxArea, height[i]);
//                continue;
//            }
//            int right = height.length - 1;
//            while (i < right) {
//                int rightHeight = height[right];
//                if (rightHeight > height[i]) {
//                    rightHeight = height[i];
//                }
//                int area = rightHeight * (right - i);
//                maxArea = Math.max(maxArea, area);
//                right--;
//            }
//        }
//        return maxArea;
//    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int length = right - left;
            int area = length * Math.min(height[right], height[left]);
            maxArea = Math.max(maxArea, area);
            if (height[left] < height[right]) {
                left++;
            }
            else {
                right--;
            }
        }
        return maxArea;
    }
}

