class Solution {
    public boolean isPalindrome(String s) {
        for (int start = 0, end = s.length()-1; start < end;) {
            while (start < end && !isAlphaNumeric(s.charAt(start))) {
                start++;
            }
            while (start < end && !isAlphaNumeric(s.charAt(end))) {
                end--;
            }

            if (start < end) {
                if (!s.substring(start, start+1).equalsIgnoreCase(s.substring(end, end+1))) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }

    boolean isAlphaNumeric(char ch) {
        return ('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z') || ('0' <= ch && ch <= '9');
    }
        
}
