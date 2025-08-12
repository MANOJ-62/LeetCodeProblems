package medium;

/**
 * Leetcode 153
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * Find the minimum element.
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class FindMinimuminRotatedSortedArray {

    public int findMin(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;

                // Minimum is in the right half
                if (nums[mid] > nums[right]) {
                    left = mid + 1;
                } else {
                    // Minimum is in the left half (including mid)
                    right = mid;
                }
            }
            // At the end, left == right
            return nums[left];
    }

    public static void main(String[] args) {
        FindMinimuminRotatedSortedArray findMinimuminRotatedSortedArray = new FindMinimuminRotatedSortedArray();
        System.out.println(findMinimuminRotatedSortedArray.findMin(new int[]{3,4,5,1,2}));
    }
}