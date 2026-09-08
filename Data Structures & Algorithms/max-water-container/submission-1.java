class Solution {
    public int maxArea(int[] heights) {
        int maxWater = 0, currentWater = 0;
        int leftIndex = 0, rightIndex = heights.length-1;
        while (leftIndex < rightIndex) {
            int minHeight = Math.min(heights[leftIndex], heights[rightIndex]);
            currentWater = (rightIndex - leftIndex) * minHeight;
            maxWater = Math.max(maxWater, currentWater);
            if (heights[leftIndex] < heights[rightIndex]) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }
        return maxWater;
    }
}
