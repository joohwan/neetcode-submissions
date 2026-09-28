class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1, maxSpeed = 0;
        for (int n : piles) {
            maxSpeed = Math.max(maxSpeed, n);
        }

        int left = minSpeed, right = maxSpeed, mid = 0;
        int minSpeedWithinH = maxSpeed;
        while (left <= right) {
            mid = left + (right - left) / 2;
            int time = 0;
            for (int n : piles) {
                time += n / mid;
                time += n % mid == 0 ? 0 : 1;
            }
            if (time <= h) {
                minSpeedWithinH = Math.min(minSpeedWithinH, mid);
            }

            if (time <= h) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return minSpeedWithinH;
    }

}
