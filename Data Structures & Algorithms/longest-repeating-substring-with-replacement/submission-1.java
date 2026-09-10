class Solution {
    public int characterReplacement(String s, int k) {
        final int len = s.length(); 
        Map<Character, Integer> charToCount = new HashMap<>();
        int start = 0, end = 0, maxFreqCharCount = 0, maxLength = 1;
        char maxCountChar = '\0';
        for (; end < len; end++) {
            char curChar = s.charAt(end);
            int curCharCount = charToCount.merge(curChar, 1, Integer::sum);
            maxFreqCharCount = Math.max(maxFreqCharCount, curCharCount);
            int curSubstringLength = end - start + 1;
            if (curSubstringLength - maxFreqCharCount > k) {
                char charToRemove = s.charAt(start++);
                charToCount.merge(charToRemove, -1, Integer::sum);
                curSubstringLength = end - start + 1;
            }

            maxLength = Math.max(maxLength, curSubstringLength);
        }
        return maxLength;
    }
}
