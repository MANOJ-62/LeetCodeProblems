package medium;

/**
 * Leetcode 152
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums){
        int currentProd = nums[0];
        int maxProd = nums[0];

        for(int i=1; i<nums.length; i++){
            if(currentProd < 0){
                currentProd = nums[i];
            } else {
                currentProd *= nums[i];
            }
            if(currentProd>maxProd){
                maxProd = currentProd;
            }
        }
        return maxProd;
    }

    public static void main(String[] args) {
        MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
        System.out.println(maximumProductSubarray.maxProduct(new int[]{2,3,-2,4}));
    }
}
