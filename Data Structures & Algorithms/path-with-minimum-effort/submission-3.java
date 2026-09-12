class Solution {
    public int minimumEffortPath2(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        
        // effort[r][c] = minimum possible max-difference to reach (r, c)
        int[][] effort = new int[rows][cols];
        for (int[] row : effort) Arrays.fill(row, Integer.MAX_VALUE);
        effort[0][0] = 0;
        
        // Min-heap ordered by effort so far: {row, col, effortToReach}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, 0});
        
        boolean[][] visited = new boolean[rows][cols];
        visited[0][0] = true;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // up, down, left, right
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int r = current[0], c = current[1], curEffort = current[2];
            
            // if (visited[r][c]) continue;
            // visited[r][c] = true;
            
            // Reached bottom-right cell — this is guaranteed minimal since it's a min-heap
            if (r == rows - 1 && c == cols - 1) return curEffort;
            
            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols || visited[nr][nc]) continue;
                
                int diff = Math.abs(heights[nr][nc] - heights[r][c]);
                int newEffort = Math.max(curEffort, diff);
                
                if (newEffort < effort[nr][nc]) {
                    effort[nr][nc] = newEffort;
                    pq.offer(new int[]{nr, nc, newEffort});
                    visited[nr][nc] = true;
                }
            }
        }
        
        return 0; // unreachable in practice given constraints
    }

    public int minimumEffortPath(int[][] height) {
        final int rowSize = height.length, colSize = height[0].length;
        int[][] minEfforts = new int[rowSize][colSize];
        for (int[] row : minEfforts) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        minEfforts[0][0] = 0;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparing((int[] rowColEffort) -> rowColEffort[2]));
        minHeap.offer(new int[] {0, 0, minEfforts[0][0]});
        boolean[][] addedToQ = new boolean[rowSize][colSize];
        // addedToQ[0][0] = true;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!minHeap.isEmpty()) {
            int[] rowColEffort = minHeap.poll();
            int ri = rowColEffort[0], ci = rowColEffort[1], effort = rowColEffort[2];
            if (addedToQ[ri][ci]) continue;
            addedToQ[ri][ci] = true;
            if (ri == rowSize-1 && ci == colSize-1) {
                return effort;
            }

            for (int[] rowCol : dirs) {
                int nextRow = ri + rowCol[0];
                int nextCol = ci + rowCol[1];
                if (nextRow < 0 || nextRow >= rowSize || nextCol < 0 || nextCol >= colSize
                                || addedToQ[nextRow][nextCol]) {
                    continue;
                }
                int diff = Math.abs(height[ri][ci] - height[nextRow][nextCol]);
                int newEffort = Math.max(effort, diff);
                if (newEffort < minEfforts[nextRow][nextCol]) {
                    minEfforts[nextRow][nextCol] = newEffort;
                    minHeap.offer(new int[] {nextRow, nextCol, minEfforts[nextRow][nextCol]});
                    // addedToQ[nextRow][nextCol] = true;
                }
            }
        }

        return 0;
    }
}