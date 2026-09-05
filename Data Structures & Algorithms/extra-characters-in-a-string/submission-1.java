class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Map<Range, Integer> indexToMinCharCount = new HashMap<>();
        return minExtraChar(s, 0, s.length()-1, dictionary, indexToMinCharCount);
    }

    private int minExtraChar(String s, int startIndex, int endIndex, String[] dictionary,
                             Map<Range, Integer> indexToMinCharCount) {
        if (startIndex == s.length()) {
            return 0;
        }
        
        Range range = new Range(startIndex, endIndex);
        Integer minCount = indexToMinCharCount.get(range);
        if (minCount != null) {
            return minCount;
        }
        
        int minExtraCount = Integer.MAX_VALUE;
        boolean found = false;
        for (String word : dictionary) {
            int foundStartIndex = s.indexOf(word, startIndex);
            int foundEndIndex = foundStartIndex + word.length() - 1;
            if (foundStartIndex != -1 && foundEndIndex <= endIndex) {
                found = true;
                int preExtraCharCount = 0, postExtraCharCount = 0;
                if (startIndex < foundStartIndex) {
                    preExtraCharCount = minExtraChar(s, startIndex, foundStartIndex-1, 
                                                     dictionary, indexToMinCharCount);
                }
                if (foundEndIndex < endIndex) {
                    postExtraCharCount = minExtraChar(s, foundEndIndex+1,
                            endIndex, dictionary, indexToMinCharCount);
                }
                minExtraCount = Math.min(minExtraCount, preExtraCharCount + postExtraCharCount);
            }
        }
        
        if (!found) {
            indexToMinCharCount.put(range, endIndex - startIndex + 1);
            return endIndex - startIndex + 1;
        } else {
            indexToMinCharCount.put(range, minExtraCount);
            return minExtraCount;
        }
    }

    record Range(int startIndex, int endIndex) {}
}