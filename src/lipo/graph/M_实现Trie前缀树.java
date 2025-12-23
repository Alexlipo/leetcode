package lipo.graph;

public class M_实现Trie前缀树 {

    class Trie {
        private Trie[] children;
        private boolean isEnd;

        public Trie() {
            children = new Trie[26];
            isEnd = false;
        }

        public void insert(String word) {
            Trie t = this;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (t.children[index] == null) {
                    t.children[index] = new Trie();
                }
                t = t.children[index];
            }
            t.isEnd = true;
        }

        public boolean search(String word) {
            Trie t = searchPrefix(word);
            return t != null && t.isEnd;
        }

        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }

        private Trie searchPrefix(String prefix) {
            Trie t = this;
            for (char c : prefix.toCharArray()) {
                int index = c - 'a';
                if (t.children[index] == null) {
                    return null;
                }
                t = t.children[index];
            }
            return t;
        }
    }
}
