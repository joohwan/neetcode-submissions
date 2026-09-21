class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        final int len = nums.length;
        Deque<Integer> indexBigValueFirst = new ArrayDeque<>();
        int[] maximums = new int[len - k + 1];
        for (int i = 0; i < len; i++) {
            // remove old index out of window
            if (!indexBigValueFirst.isEmpty() && indexBigValueFirst.getFirst() <= i - k) {
                indexBigValueFirst.removeFirst();
            }

            // remove small or equal values than the value to be added
            while (!indexBigValueFirst.isEmpty() && nums[indexBigValueFirst.getLast()] <= nums[i]) {
                indexBigValueFirst.removeLast();
            }

            indexBigValueFirst.addLast(i);

            if (i >= k - 1) {
                maximums[i-k+1] = nums[indexBigValueFirst.getFirst()];
            }
        }
        return maximums;
    }


}
