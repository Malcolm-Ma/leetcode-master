package squaresOfSortedArray977;

public class Solution {
    public int[] sortedSquares(int[] nums) {
        int leftFlag = 0;
        int size = nums.length;
        int[] result = new int[size];
        size--;
        int rightFlag = size;
        
        while (size >= 0) {
            // Slowly runtime
            // int squareLeft = (int)Math.pow(nums[leftFlag], 2);
            // int squareRight = (int)Math.pow(nums[rightFlag], 2);
            int squareLeft = nums[leftFlag]*nums[leftFlag];
            int squareRight = nums[rightFlag]*nums[rightFlag];
            if (squareLeft < squareRight) {
                result[size--] = squareRight;
                rightFlag--;
            } else {
                result[size--] = squareLeft;
                leftFlag++;
            }
        }
        return result;
    }
}