class Solution {
    public int minExtraChar2(String s, String[] dictionary) {
        final int len = s.length();
        int[] dp = new int[len];
        Set<String> dict = new HashSet<>(Arrays.asList(dictionary));

        for (int i = 0; i < len; i++) {
            dp[i] = i+1;

            for (int j = 0; j <= i; j++) {
                if (dict.contains(s.substring(0, j+1))) {
                    dp[i] = Math.min(dp[i], i-j);
                } 
                if (dict.contains(s.substring(j, i+1))) {
                    dp[i] = Math.min(dp[i], j == 0 ? 0 : dp[j-1]);
                }
            }
        }
        return dp[len-1];
    }
    
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        Set<String> wordSet = new HashSet<>(Arrays.asList(dictionary));
        
        int[] dp = new int[n + 1];
        dp[0] = 0;
        
        for (int i = 1; i <= n; i++) {
            // Option 1: s[i-1] is an extra character
            dp[i] = dp[i - 1] + 1;
            
            // Option 2: check if s[j..i-1] forms a dictionary word
            for (int j = 0; j < i; j++) {
                String sub = s.substring(j, i);
                if (wordSet.contains(sub)) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }
        
        return dp[n];
    }
}