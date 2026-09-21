class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        final int len = temperatures.length;
        int[] dist = new int[len];
        Deque<Integer> indexBigValueFirst = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            // check if small value exists
            while (!indexBigValueFirst.isEmpty() && temperatures[indexBigValueFirst.getLast()] < temperatures[i]) {
                int prevIndex = indexBigValueFirst.removeLast();
                dist[prevIndex] =  i - prevIndex;
            }

            indexBigValueFirst.addLast(i);
        }
        return dist;
    }
}
