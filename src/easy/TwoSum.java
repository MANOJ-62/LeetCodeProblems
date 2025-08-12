package easy;

import java.util.HashMap;

/**
 * Leetcode 1
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);

        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store numbers and their corresponding indices
        HashMap<Integer, Integer> map = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {

            // Calculate the complement that would add up to the target
            int complement = target - nums[i];

            // Check if the complement is already in the map
            // If it is, we have found the two numbers that add up to the target
            // If complement exists, it means we have already seen a number that pairs with the current number to form the target sum.
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            // If complement is not found, add the current number and its index to the map
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
