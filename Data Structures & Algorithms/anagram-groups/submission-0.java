class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> anagramsByMapKey = new HashMap<>();
        for (String s : strs) {
            anagramsByMapKey.computeIfAbsent(toMap(s), key -> new ArrayList<>()).add(s);
        }
        List<List<String>> groups = new ArrayList<>();
        for (List<String> anagrams : anagramsByMapKey.values()) {
            groups.add(anagrams);
        }
        return groups;
    }

    Map<Character, Integer> toMap(String s) {
        Map<Character, Integer> charToCount = new HashMap<>();
        for (char ch : s.toCharArray()) {
            charToCount.merge(ch, 1, Integer::sum);
        } 
        return charToCount;
    }
}
