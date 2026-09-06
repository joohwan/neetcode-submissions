class Solution {
    public boolean isAnagram(String s, String t) {
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
