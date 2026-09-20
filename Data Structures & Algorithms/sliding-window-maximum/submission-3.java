class Solution {
    public int[] maxSlidingWindow3(int[] nums, int k) {
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

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>(); // stores indices, values decreasing

        for (int i = 0; i < n; i++) {
            // 1. Drop the front if it has slid out of the window [i-k+1, i]
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // 2. Drop smaller-or-equal values from the back; they can never be a max
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }

            // 3. Add the current index
            dq.offerLast(i);

            // 4. Once the first full window is formed, the front is the max
            if (i >= k - 1) {
                result[i - k + 1] = nums[dq.peekFirst()];
            }
        }
        return result;
    }
}
