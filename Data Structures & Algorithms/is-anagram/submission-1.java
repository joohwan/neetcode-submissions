class Solution {
    public boolean isAnagram(String s, String t) {
        int[] charCounts = new int[26];
        for (char ch : s.toCharArray()) {
            charCounts[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            charCounts[ch - 'a']--;
        }
        for (int count : charCounts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        return toMap(s).equals(toMap(t));
    }

    Map<Character, Integer> toMap(String s) {
        Map<Character, Integer> charToCount = new HashMap<>();
        for (char ch : s.toCharArray()) {
            charToCount.merge(ch, 1, Integer::sum);
        }
        return charToCount;
    }
}
