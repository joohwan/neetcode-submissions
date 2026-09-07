class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        for (int n : nums) {
            numbers.add(n);
        }

        int maxLength = 0;
        int currentLength = 0;
        int currentNo = 0;
        for (int n : numbers) {
            if (!numbers.contains(n-1)) {
                currentLength = 0;
                currentNo = n;
                while (numbers.contains(currentNo)) {
                    currentLength++;
                    currentNo += 1;
                }

                maxLength = Math.max(maxLength, currentLength);
            }
        }
        return maxLength;
    }
}
