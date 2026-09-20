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

    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int[] result = new int[n - k + 1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            heap.offer(new int[] {nums[i], i});
            if (i >= k - 1) {
                while (heap.peek()[1] <= i - k) {
                    heap.poll();
                }
                result[index++] = heap.peek()[0];
            }
        }
        return result;
    } 
}
