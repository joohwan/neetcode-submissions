class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        Deque<Integer> q = new ArrayDeque<>();
        int minHeight = n;
        List<Integer> minHeightRoots = new ArrayList<>();
        Set<Integer> addedToQ = new HashSet<>();

        for (int i = 0; i < n; i++) {
            q.addLast(i);
            addedToQ.clear();
            addedToQ.add(i);
            int height = -1;
            while (!q.isEmpty()) {
                height++;
                int size = q.size();
                for (int j = 0; j < size; j++) {
                    int node = q.removeFirst();
                    for (int next : graph.get(node)) {
                        if (!addedToQ.contains(next)) {
                            q.addLast(next);
                            addedToQ.add(next);
                        }
                    }
                }
            }

            if (height < minHeight) {
                minHeight = height;
                minHeightRoots.clear();
                minHeightRoots.add(i);
            } else if (height == minHeight) {
                minHeightRoots.add(i);
            }
        }

        return minHeightRoots;
    }
}