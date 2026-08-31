class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<String>> indexToSentences = new HashMap<>();
        Set<String> dict = new HashSet<>(wordDict);
        return wordBreak(s, 0, dict, indexToSentences);
    }

    List<String> wordBreak(String s, int startIndex, Set<String> dict,  Map<Integer, List<String>> indexToSentences) {
        if (indexToSentences.containsKey(startIndex)) {
            return indexToSentences.get(startIndex);
        } else if (startIndex == s.length()) {
            List<String> sentences = new ArrayList<>();
            sentences.add("");
            indexToSentences.put(startIndex, sentences);
            return sentences;
        }

        List<String> sentences = new ArrayList<>();
        for (int endIndex = startIndex; endIndex < s.length(); endIndex++) {
            String prefix = s.substring(startIndex, endIndex+1);
            if (dict.contains(prefix)) {
                List<String> subSentences = wordBreak(s, endIndex+1, dict, indexToSentences);
                if (!subSentences.isEmpty()) {
                    for (String subSentence : subSentences) {
                        if (subSentence.isEmpty()) {
                            sentences.add(prefix);
                        } else {
                            sentences.add(prefix + " " + subSentence);
                        }
                    }
                }
            }
        }
        indexToSentences.put(startIndex, sentences);
        return sentences;
    }
}