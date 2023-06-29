package algorithmicTasks;

//Given an integer array nums and an integer k, return the k most frequent elements.
// You may return the answer in any order.
//
//        Example 1:
//
//        Input: nums = [1,1,1,2,2,3], k = 2
//        Output: [1,2]
//        Example 2:
//
//        Input: nums = [1], k = 1
//        Output: [1]

import java.util.*;

// my solution.
public class TopKFrequentElements {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 4, 1, 2, 2, 4, 2, 3, 3, 1, 4, 2}, 3)));
    }
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        int[] result = new int[k];
        Integer quantity = nums.length;
        for (int i = 0; i < k; i++) {
            while (!map.containsValue(quantity)) {
                quantity--;
            }
            Integer finalQuantity = quantity;
            result[i] = map
                    .entrySet()
                    .stream()
                    .filter(e -> Objects.equals(e.getValue(), finalQuantity))
                    .map(Map.Entry::getKey)
                    .findAny().get();
            map.remove(result[i]);
        }
        return result;
    }

    //new solution using PriorityQueue
    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int num : nums)
        {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue =
                new PriorityQueue<>((o1, o2) -> o2.getValue()- o1.getValue());

        priorityQueue.addAll(map.entrySet());
        int[] result = new int[k];

        for(int i = 0; i < k; i++)
        {
            result[i] = Objects.requireNonNull(priorityQueue.poll()).getKey();
        }
        return result;
    }
}
