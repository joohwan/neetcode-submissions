class PrefixTree {
    private Node root;

    public PrefixTree() {
        this.root = new Node(null);
    }

    public void insert(String word) {
        Node currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            Node next = currentNode.getNextCharacterNode(ch);
            if (next == null) {
                next = currentNode.addNextCharacterNode(ch);
            }
            currentNode = next;
        }
        currentNode.setWord(true);
    }

    private boolean search(String word, boolean isWord) {
        Node currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            Node next = currentNode.getNextCharacterNode(ch);
            if (next == null) {
                return false;
            }
            currentNode = next;
        }
        return isWord ? currentNode.isWord() : true;
    }

    public boolean search(String word) {
        return search(word, true);
    }

    public boolean startsWith(String prefix) {
        return search(prefix, false);
    }
}

private static class Node {
    Character ch;
    Map<Character, Node> charToNode;
    boolean isWord; 

    public Node(Character ch) {
        this.charToNode = new HashMap<>();
        this.ch = ch;
    }

    Node getNextCharacterNode(char ch) {
        return charToNode.get(ch);
    }

    Node addNextCharacterNode(char ch) {
        Node next = charToNode.get(ch);
        if (next == null) {
            next = new Node(ch);
            charToNode.put(ch, next);
        }
        return next;
    }

    boolean isWord() {
        return this.isWord;
    }

    void setWord(boolean flag) {
        this.isWord = flag;
    }
}
