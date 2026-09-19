class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] count1 = new int[26];
        for (char c : s1.toCharArray()) {
            count1[c - 'a']++;
        }
        
        int[] count2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count2[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(count1, count2)) {
            return true;
        }

        for (int oldStart = 0, newEnd = s1.length(); newEnd < s2.length(); oldStart++, newEnd++) {
            char oldStartChar = s2.charAt(oldStart);
            char newChar = s2.charAt(newEnd);
            count2[newChar - 'a']++;
            count2[oldStartChar - 'a']--;
            if (Arrays.equals(count1, count2)) {
                return true;
            }
        }
        return false;
    }
}
