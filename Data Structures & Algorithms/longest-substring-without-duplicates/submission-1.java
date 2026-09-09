class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charToCount = new HashMap<>();
        int maxLength = 0;
        int start = 0, end = 0;
        for (; end < s.length(); end++) {
            char ch = s.charAt(end);
            int count = charToCount.merge(ch, 1, Integer::sum);
            if (count == 2) {
                while (charToCount.get(ch) == 2) {
                    char old = s.charAt(start++);
                    charToCount.put(old, charToCount.get(old)-1);
                }
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
