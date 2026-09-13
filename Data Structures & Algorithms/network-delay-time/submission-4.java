class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<long[]>[] graph = new ArrayList[n+1];
        long[] travelTimes = new long[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            travelTimes[i] = Long.MAX_VALUE;
        }
        travelTimes[k] = 0;

        for (int[] fromToTime : times) {
            int from = fromToTime[0];
            int to = fromToTime[1];
            int time = fromToTime[2];
            graph[from].add(new long[] {to, time});
        }

        PriorityQueue<long[]> q = new PriorityQueue<>(Comparator.comparing((long[] nodeAndTime) -> nodeAndTime[1]));
        Set<Integer> visited = new HashSet<>(); // avoid cycle
        q.offer(new long[] {k, 0});

        while (!q.isEmpty()) {
            long[] nodeAndTime = q.poll();
            int fromNode = (int) nodeAndTime[0];
            long timeTillFrom = nodeAndTime[1];
            // if (visited.contains(fromNode)) {
            //     continue;
            // }
            visited.add(fromNode);

            List<long[]> connectedEdges = graph[fromNode];
            for (long[] toNodeAndTime : connectedEdges) {
                int toNode = (int) toNodeAndTime[0];
                long time = toNodeAndTime[1];
                if (!visited.contains(toNode) && timeTillFrom + time < travelTimes[toNode]) {
                    travelTimes[toNode] = timeTillFrom + time;
                    q.offer(new long[] {toNode, travelTimes[toNode]});
                }
            }
        }

        long maxTime = 0;
        for (int node = 1; node <= n; node++) {
            long time = travelTimes[node];
            if (time == Long.MAX_VALUE) {
                return -1;
            }
            maxTime = Math.max(maxTime, time);
        }
        return (int) maxTime;
    }
}
