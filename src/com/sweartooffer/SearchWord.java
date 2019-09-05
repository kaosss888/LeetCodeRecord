package com.sweartooffer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <h1>单词搜索2</h1>
 */
public class SearchWord {

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String s : words) {
            trie.insert(s);
        }

        int row = board.length;
        int column = board[0].length;
        Set<String> res = new HashSet<>();
        boolean[][] visited = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                search(board, i, j, row, column, trie.root, res, visited);
            }
        }

        return new ArrayList<>(res);
    }

    public void search(char[][] board, int i, int j, int row, int column, TreeNode node, Set<String> res, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= row || j >= column || visited[i][j]) {
            return;
        }

        node = node.links[board[i][j] - 'a'];
        if (node == null) {
            return;
        }

        if (node.word != null) {
            res.add(node.word);
        }

        visited[i][j] = true;
        search(board, i - 1, j, row, column, node, res, visited);
        search(board, i, j + 1, row, column, node, res, visited);
        search(board, i + 1, j, row, column, node, res, visited);
        search(board, i, j - 1, row, column, node, res, visited);
        visited[i][j] = false;
    }

    class Trie {

        TreeNode root;

        public Trie() {
            root = new TreeNode();
        }

        public void insert(String word) {
            TreeNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char curChar = word.charAt(i);
                if (!node.containsKey(curChar)) {
                    node.put(curChar, new TreeNode());
                }
                node = node.get(curChar);
            }
            node.setWord(word);
        }
    }

    class TreeNode {

        TreeNode[] links;

        String word;

        private final int R = 26;

        public TreeNode() {
            this.links = new TreeNode[this.R];
        }

        public boolean containsKey(char c) {
            return this.links[c - 'a'] != null;
        }

        public void put(char c, TreeNode node) {
            this.links[c - 'a'] = node;
        }

        public TreeNode get(char c) {
            return this.links[c - 'a'];
        }

        public void setWord(String word) {
            this.word = word;
        }
    }
}
