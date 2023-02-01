package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Temurbek Ismoilov on 24/01/23.
 */

public class TrieNode {
    public Map<Character, TrieNode> children;
    public boolean endOfString;

    public TrieNode() {
        children = new HashMap<>();
        endOfString = false;
    }
}
