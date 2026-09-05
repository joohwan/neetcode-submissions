class WordDictionary {
    Node root;

    public WordDictionary() {
        this.root = new Node('\0');
    }

    public void addWord(String word) {
        Node parentNode = root;
        for (char ch : word.toCharArray()) {
            parentNode = parentNode.findOrAddChild(ch);
        }
        parentNode.setWord();
    }

    public boolean search(String word) {
        return search(root, word);
    }
    
    private boolean search(Node parentNode, String word) {
        if (parentNode == null) {
            return false;
        }

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == '.') {
                for (Node child : parentNode.getChildren()) {
                    if (search(child, word.substring(i+1))) {
                        return true;
                    }
                }
                return false;
            } else {
                parentNode = parentNode.findChild(ch);
                if (parentNode == null) {
                    return false;
                }
            }
        }
        return parentNode.isWord();
    }

    private static class Node {
        char ch;
        boolean isWord;
        Map<Character, Node> charToChild;

        Node(char c) {
            this.ch = c;
            charToChild = new HashMap<>();
        }

        Node findOrAddChild(char ch) {
            Node child = charToChild.get(ch);
            if (child == null) {
                child = new Node(ch);
                charToChild.put(ch, child);
            }
            return child;
        }

        Node findChild(char ch) {
            return charToChild.get(ch);
        }

        void setWord() {
            this.isWord = true;
        }

        boolean isWord() {
            return isWord;
        }

        Collection<Node> getChildren() {
            return charToChild.values();
        }
    }
}
