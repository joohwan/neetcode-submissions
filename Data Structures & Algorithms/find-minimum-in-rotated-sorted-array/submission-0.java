class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1, mid = 0;
        if (nums[left] <= nums[right]) {
            return nums[left];
        }

        while (left <= right) {
            if (left + 1 == right) {
                break;
            }

            mid = left + (right - left) / 2;
            if (nums[left] <= nums[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return Math.min(nums[left], nums[right]);
    }
}
