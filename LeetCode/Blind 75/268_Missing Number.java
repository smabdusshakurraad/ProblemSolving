/**
 * Finds the missing number in an array containing n distinct numbers in the range [0, n].
 * Uses the Gaussian sum formula to achieve O(n) time complexity and O(1) space complexity.
 */

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int currentSum = 0;

        for( int i : nums){
            currentSum += i;
        }

        return expectedSum - currentSum;
    }
}