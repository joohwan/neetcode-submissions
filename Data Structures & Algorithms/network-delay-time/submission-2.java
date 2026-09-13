class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        Map<Integer, Integer> toNodeToTravelTime = new HashMap<>();
        toNodeToTravelTime.put(k, 0);
        for (int[] fromToTime : times) {
            int from = fromToTime[0];
            int to = fromToTime[1];
            int time = fromToTime[2];
            graph.computeIfAbsent(from, key -> new ArrayList<>()).add(new int[] {to, time});
        }

        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparing((int[] nodeAndTime) -> nodeAndTime[1]));
        Set<Integer> visited = new HashSet<>(); // avoid cycle
        q.offer(new int[] {k, 0});

        while (!q.isEmpty()) {
            int[] nodeAndTime = q.poll();
            int fromNode = nodeAndTime[0];
            int timeTillFrom = nodeAndTime[1];
            if (visited.contains(fromNode)) {
                continue;
            }
            visited.add(fromNode);
            List<int[]> connectedEdges = graph.get(fromNode);
            if (connectedEdges != null) {
                for (int[] toNodeAndTime : connectedEdges) {
                    int toNode = toNodeAndTime[0];
                    int time = toNodeAndTime[1];
                    Integer travelTime = toNodeToTravelTime.get(toNode);
                    if (travelTime == null) {
                        if (k == fromNode) {
                            toNodeToTravelTime.put(toNode, time);
                            q.offer(new int[] {toNode, time});
                        } else if (toNodeToTravelTime.containsKey(fromNode)) {
                            int preTime = toNodeToTravelTime.get(fromNode);
                            toNodeToTravelTime.put(toNode, preTime + time);
                            q.offer(new int[] {toNode, preTime + time});
                        }
                    } else {
                        if (k == fromNode) {
                            if (time < travelTime) {
                                toNodeToTravelTime.put(toNode, time);
                                q.offer(new int[] {toNode, time});
                            }
                        } else if (toNodeToTravelTime.containsKey(fromNode)) {
                            int preTime = toNodeToTravelTime.get(fromNode);
                            if (preTime + time < travelTime) {
                                toNodeToTravelTime.put(toNode, preTime + time);
                                q.offer(new int[] {toNode, preTime + time});
                            }
                        }
                    }
                }
            }
        }

        int maxTime = 0;
        for (int node = 1; node <= n; node++) {
            Integer time = toNodeToTravelTime.get(node);
            if (time == null) {
                return -1;
            }
            maxTime = Math.max(maxTime, time);
        }
        return maxTime;
    }

    record FromTo(int from, int to) {}
}
