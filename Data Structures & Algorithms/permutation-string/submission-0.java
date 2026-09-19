class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] counts = new int[26];
        for (char c : s1.toCharArray()) {
            counts[c - 'a']++;
        }
        
        int start = 0, end = 0;
        for (; end < s2.length(); end++) {
            char c = s2.charAt(end);
            counts[c - 'a']--;
            if (counts[c - 'a'] == 0) {
                boolean allZeros = true;
                for (int n : counts) {
                    if (n != 0) {
                        allZeros = false;
                        break;
                    }
                }

                if (allZeros) {
                    return true;
                }
            } else if (counts[c - 'a'] == -1) {
                while (start <= end && counts[c - 'a'] == -1) {
                    counts[s2.charAt(start) - 'a']++;
                    start++;
                }
            }
        }
        return false;
    }
}
