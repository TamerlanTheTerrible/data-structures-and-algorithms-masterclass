package tree;

import java.sql.SQLOutput;

/**
 * Created by Temurbek Ismoilov on 24/01/23.
 */

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            final char c = word.charAt(i);
            TrieNode node = currentNode.children.get(c);
            if (node == null) {
                node = new TrieNode();
                currentNode.children.put(c, node);
            }
            currentNode = node;
        }
        currentNode.endOfString = true;
        System.out.println(word + " inserted");
    }

    public boolean search(String word) {
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            final char c = word.charAt(i);
            TrieNode node = currentNode.children.get(c);
            if (node == null) {
                System.out.println(word + " doesn't exist in trie");
                return false;
            }
            currentNode = node;
        }
        if (currentNode.endOfString) {
            System.out.println(word + " exists in trie");
            return true;
        } else {
            System.out.println(word + " doesn't exist in trie");
            return false;
        }
    }
}
