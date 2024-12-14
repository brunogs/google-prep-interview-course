package lesson7;

import precondition.Preconditions;

public class ImplementTrie {

    static class Trie {

        private Trie[] childs;
        private boolean wordEnd;

        public Trie() {
            this.childs = new Trie[26];
        }

        public void insert(String word) {
            Trie current = this;
            for (var c : word.toCharArray()) {
                if (current.childs[c - 'a'] == null) {
                    var node = new Trie();
                    current.childs[c - 'a'] = node;
                }
                current = current.childs[c - 'a'];
            }
            current.wordEnd = true;
        }

        public boolean search(String word) {
            Trie current = this;
            for (var c : word.toCharArray()) {
                if (current.childs[c - 'a'] == null) {
                    return false;
                }
                current = current.childs[c - 'a'];
            }
            return current.wordEnd;
        }

        public boolean startsWith(String prefix) {
            Trie current = this;
            for (var c : prefix.toCharArray()) {
                if (current.childs[c - 'a'] == null) {
                    return false;
                }
                current = current.childs[c - 'a'];
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");

        boolean hasApple = trie.search("apple");
        Preconditions.check(hasApple);

        boolean hasWordApp = trie.search("app");
        Preconditions.check(!hasWordApp);

        boolean hasPrefixApp = trie.startsWith("app");
        Preconditions.check(hasPrefixApp);

        trie.insert("app");
        hasWordApp = trie.search("app");
        Preconditions.check(hasWordApp);
    }
}
