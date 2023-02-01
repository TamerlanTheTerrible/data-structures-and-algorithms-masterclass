package exercises.graph.Buildorder;

import exercises.graph.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Temurbek Ismoilov on 31/01/23.
 */

public class CommonAncestor {
    public static TreeNode commonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
        List<TreeNode> parents1 = parents(node1);
        List<TreeNode> parents2 = parents(node2);
        for(TreeNode parent1: parents1) {
            for(TreeNode parent2: parents2) {
                if (parent1 == parent2) {
                    return parent1;
                }
            }
        }

        return root;
    }

    private static List<TreeNode> parents(TreeNode node) {
        List<TreeNode> parents = new ArrayList<>();
        TreeNode currentNode = node;
        while (currentNode.parent != null) {
            parents.add(currentNode.parent);
            currentNode = currentNode.parent;
        }
        return parents;
    }
}
