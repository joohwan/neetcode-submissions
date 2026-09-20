class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int[] maximums = new int[nums.length - k + 1];
        int maximumIndex = 0, numsIndex = 0;
        for (; numsIndex < k-1; numsIndex++) {
            maxHeap.offer(nums[numsIndex]);
        }

        for (; numsIndex < nums.length; numsIndex++) {
            maxHeap.offer(nums[numsIndex]);
            maximums[maximumIndex] = maxHeap.peek();
            maxHeap.remove(nums[maximumIndex]);
            maximumIndex++;
        }
        return maximums;
    }
}
