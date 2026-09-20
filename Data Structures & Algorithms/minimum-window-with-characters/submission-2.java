class Solution {
    public String minWindow(String s, String t) {
        final int sLen = s.length();
        final int tLen = t.length();
        if (tLen > sLen) {
            return "";
        }

        int missingCount = 0;
        int[] toFindCounts = new int[128];
        for (char c : t.toCharArray()) {
            toFindCounts[c]++;
            missingCount++;
        }

        int start = 0, end = 0;
        int minSubStrLen = s.length()+1, minSubStrStart = -1;
        for (; end < sLen; end++) {
            char c = s.charAt(end);
            toFindCounts[c]--;
            if (toFindCounts[c] >= 0) {
                missingCount--;
            }

            while (missingCount == 0) {
                int subStrLen = end - start + 1;
                if (subStrLen < minSubStrLen) {
                    minSubStrLen = subStrLen;
                    minSubStrStart = start;
                }

                // shrink
                char startChar = s.charAt(start++);
                if (++toFindCounts[startChar] > 0) {
                    missingCount++;
                }
            }
        }

        if (minSubStrStart == -1) {
            return "";
        } else {
            return s.substring(minSubStrStart, minSubStrStart+minSubStrLen);
        }
    }
}
