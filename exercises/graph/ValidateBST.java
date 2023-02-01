package exercises.graph;

/**
 * Created by Temurbek Ismoilov on 31/01/23.
 */

public class ValidateBST {

    public static boolean isBST(TreeNode node) {
        if (node.left != null && node.data < node.left.data){
            return false;
        } else if (node.left == null) {
            return true;
        }

        if (node.right != null && node.data >= node.right.data) {
            return false;
        } else if (node.right == null) {
            return true;
        }

        return isBST(node.left) && isBST(node.right);
    }
}
