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

    /**
     * Easily Readable
     */
     /**
        public int maxProduct(int[] nums) {
            int maxProd = nums[0];
            int minProd = nums[0];
            int result = nums[0];

            for (int i = 1; i < nums.length; i++) {
                int tempMax = maxProd;

                maxProd = Math.max(nums[i], Math.max(maxProd * nums[i], minProd * nums[i]));
                minProd = Math.min(nums[i], Math.min(tempMax * nums[i], minProd * nums[i]));

                result = Math.max(result, maxProd);
            }

            return result;
        }
     */

     /** Optimized
      */
     public int maxProduct(int[] nums) {
         int maxProd = nums[0];
         int minProd = nums[0];
         int result = nums[0];

         for (int i = 1; i < nums.length; i++) {
             int current = nums[i];
             int tempMax = maxProd * current;
             int tempMin = minProd * current;

             int newMax, newMin;

             // compute new max
             if (current >= tempMax && current >= tempMin) newMax = current;
             else if (tempMax >= current && tempMax >= tempMin) newMax = tempMax;
             else newMax = tempMin;

             // compute new min
             if (current <= tempMax && current <= tempMin) newMin = current;
             else if (tempMax <= current && tempMax <= tempMin) newMin = tempMax;
             else newMin = tempMin;

             maxProd = newMax;
             minProd = newMin;

             if (maxProd > result) {
                 result = maxProd;
             }
         }

         return result;
     }


    public static void main(String[] args) {
        MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
        System.out.println(maximumProductSubarray.maxProduct(new int[]{-3,-1,-1}));
    }
}

