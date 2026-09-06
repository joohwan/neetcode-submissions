class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numToCount = new HashMap<>();
        for (int n : nums) {
            numToCount.merge(n, 1, Integer::sum);
        }

        Comparator<Map.Entry<Integer, Integer>> minCountFirst = Comparator.comparing(entry -> entry.getValue());
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(minCountFirst);
        for (Map.Entry<Integer, Integer> entry : numToCount.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        int[] elements = new int[k];
        int i = 0;
        while (!minHeap.isEmpty()) {
            elements[i++] = minHeap.poll().getKey();
        }
        return elements;
    }
}
