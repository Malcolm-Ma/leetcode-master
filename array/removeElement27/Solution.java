package array.removeElement27;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int slowFlag = 0;
        for (int fastFlag = 0; fastFlag < nums.length; fastFlag++) {
            if (nums[fastFlag] != val) {
                nums[slowFlag++] = nums[fastFlag];
            }
        }
        return slowFlag;
    }
    
    public int removeElementOptimization(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }
}
