class Solution {
    public int search(int[] nums, int target) {
        // Left closed and right closed intervals
        int flagLeft = 0;
        int flagRight = nums.length - 1;
        while(flagLeft <= flagRight) {
            int flagMedium = flagLeft + (flagRight - flagLeft) / 2;
            if (target < nums[flagMedium]) {
                flagRight = flagMedium - 1;
            } else if (target > nums[flagMedium]) {
                flagLeft = flagMedium + 1;
            } else {
                return flagMedium;
            }
        }
        return -1;
    }
}