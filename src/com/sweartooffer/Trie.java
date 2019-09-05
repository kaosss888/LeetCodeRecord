package com.sweartooffer;

public class Trie {

    private TreeNode root;


    public Trie() {
        this.root = new TreeNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TreeNode node = root;
        String lowerCase = word.toLowerCase();
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(lowerCase.charAt(i))) {
                node.put(lowerCase.charAt(i), new TreeNode());
            }
            node.get(lowerCase.charAt(i));
        }
        node.setEnd();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TreeNode node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TreeNode node = searchPrefix(prefix);
        return node != null;
    }

    public TreeNode searchPrefix(String prefix) {
        TreeNode node = root;
        String lowerCase = prefix.toLowerCase();
        for (int i = 0; i < prefix.length(); i++) {
            if (node.containsKey(lowerCase.charAt(i))) {
                node = node.get(lowerCase.charAt(i));
            } else {
                return null;
            }
        }
        return node;
    }

    class TreeNode {
        private TreeNode[] links;
        private final int R = 26;
        private boolean isEnd;
        public TreeNode() {
            this.links = new TreeNode[R];
        }
        public boolean containsKey(char c) {
            return links[c - 'a'] != null;
        }
        public TreeNode get(char c) {
            return links[c - 'a'];
        }
        public void put(char c, TreeNode treeNode) {
            links[c - 'a'] = treeNode;
        }
        public boolean isEnd() {
            return isEnd;
        }
        public void setEnd() {
            isEnd = true;
        }
    }

}
