class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();
        int lastIndex = nums.length - 1;

        for (int startIndex = 0; startIndex <= lastIndex-2;) {
            List<List<Integer>> pairs = twoSum(nums, startIndex+1, lastIndex, -nums[startIndex]);
            for (List<Integer> pair : pairs) {
                pair.addFirst(nums[startIndex]);
                triplets.add(pair);
            }
            while (++startIndex <= lastIndex-2 && nums[startIndex-1] == nums[startIndex]) {}
        }
        return triplets;
    }
    
    List<List<Integer>> twoSum(int[] nums, int start, int end, int target) {
        List<List<Integer>> pairs = new ArrayList<>();

        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum == target) {
                List<Integer> pair = new ArrayList<>();
                pair.add(nums[start]);
                pair.add(nums[end]);
                pairs.add(pair);
                while (++start < end && nums[start-1] == nums[start]) {}
                while (--end > start && nums[end] == nums[end+1]) {}
            } else if (sum < target) {
                while (++start < end && nums[start-1] == nums[start]) {}
            } else {
                while (--end > start && nums[end] == nums[end+1]) {}
            }
        }
        return pairs;
    }
}
