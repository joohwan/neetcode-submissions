class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];  // position
            cars[i][1] = speed[i];     // speed
        }

        // Sort by position descending: closest to the target first.
        Arrays.sort(cars, Comparator.comparing((int[] posAndSpeed) -> posAndSpeed[0]).reversed());

        int fleets = 0;
        double slowest = -1;  // arrival time of the fleet directly ahead

        for (int[] car : cars) {
            double arrivalTime = (double) (target - car[0]) / car[1];

            if (arrivalTime > slowest) {
                // Too slow to catch the fleet ahead -> starts a new fleet.
                fleets++;
                slowest = arrivalTime;
            }
            // Otherwise it catches up and merges into the fleet ahead.
        }
        return fleets;
    }
}
