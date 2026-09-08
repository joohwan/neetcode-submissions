class Solution {
public int trap(int[] height) {
    final int len = height.length;
    int leftMax = height[0], rightMax = height[len-1];
    int curLeft = 1, curRight = len-2, water = 0;
    while (curLeft <= curRight) {
        if (leftMax <= rightMax) {
            water += Math.max(0, leftMax - height[curLeft]);
            leftMax = Math.max(leftMax, height[curLeft]);
            curLeft++;
        } else {
            water += Math.max(0, rightMax - height[curRight]);
            rightMax = Math.max(rightMax, height[curRight]);
            curRight--;
        }
   }
    return water;    
}
    
}
