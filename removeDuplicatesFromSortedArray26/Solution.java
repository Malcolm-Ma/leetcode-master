package removeDuplicatesFromSortedArray26;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int slowFlag = 1;
        for (int fastFlag = 1; fastFlag < nums.length; fastFlag++) {
            if (nums[fastFlag] != nums[fastFlag - 1]) {
                nums[slowFlag++] = nums[fastFlag];
            }
        }
        return slowFlag;
    }
}
