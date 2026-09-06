class Solution {
    public int[] productExceptSelf(int[] nums) {
        final int len = nums.length;
        int[] leftProducts = new int[len];
        leftProducts[0] = nums[0];
        for (int i = 1; i < len; i++) {
            leftProducts[i] = leftProducts[i-1] * nums[i];
        }

        int rightProduct = 1;
        int[] productsExceptSelf = new int[len];
        for (int i = len-1; i >= 0; i--) {
            productsExceptSelf[i] = (i == 0 ? 1 : leftProducts[i-1]) * rightProduct;
            rightProduct *= nums[i];
        }
        return productsExceptSelf;
    }
}  
