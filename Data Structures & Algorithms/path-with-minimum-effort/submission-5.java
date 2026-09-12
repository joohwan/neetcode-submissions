class Solution {
    public int minimumEffortPath(int[][] height) {
        final int rowSize = height.length, colSize = height[0].length;
        int[][] minEfforts = new int[rowSize][colSize];
        for (int[] row : minEfforts) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        minEfforts[0][0] = 0;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparing((int[] rowColEffort) -> rowColEffort[2]));
        minHeap.offer(new int[] {0, 0, minEfforts[0][0]});
        boolean[][] checkedNeighbors = new boolean[rowSize][colSize];
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!minHeap.isEmpty()) {
            int[] rowColEffort = minHeap.poll();
            int ri = rowColEffort[0], ci = rowColEffort[1], effort = rowColEffort[2];
            if (ri == rowSize-1 && ci == colSize-1) {
                return effort;
            }

            // if (checkedNeighbors[ri][ci]) {
            //     continue;
            // }
            checkedNeighbors[ri][ci] = true;

            for (int[] rowCol : dirs) {
                int nextRow = ri + rowCol[0];
                int nextCol = ci + rowCol[1];
                if (nextRow < 0 || nextRow >= rowSize || nextCol < 0 || nextCol >= colSize
                                || checkedNeighbors[nextRow][nextCol]) {
                    continue;
                }
                int diff = Math.abs(height[ri][ci] - height[nextRow][nextCol]);
                int newEffort = Math.max(effort, diff);
                if (newEffort < minEfforts[nextRow][nextCol]) {
                    minEfforts[nextRow][nextCol] = newEffort;
                    minHeap.offer(new int[] {nextRow, nextCol, minEfforts[nextRow][nextCol]});
                }
            }
        }

        return 0;
    }
}