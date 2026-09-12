class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> addedToQ = new HashSet<>();
        Deque<String> q = new ArrayDeque<>();
        q.addLast(beginWord);
        addedToQ.add(beginWord);
        
        int level = 0;
        boolean found = false;

        test:
        while (!q.isEmpty()) {
            int size = q.size();
            level++;
            for (int i = 0; i < size; i++) {
                String adj = q.removeFirst();
                if (adj.equals(endWord)) {
                    found = true;
                    break test;
                } else {
                    for (String word : wordList) {
                        if (!addedToQ.contains(word) && isOneCharDiff(adj, word)) {
                            q.addLast(word);
                            addedToQ.add(word);
                        }
                    }
                }
            }
        }

        return found ? level : 0;
    }

    boolean isOneCharDiff(String a, String b) {
        int diffCount = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diffCount++;
                if (diffCount > 1) {
                    return false;
                }
            }
        }
        return diffCount == 1;
    }
}
