package exercises.graph;

import exercises.graph.Buildorder.CommonAncestor;

/**
 * Created by Temurbek Ismoilov on 30/01/23.
 */

public class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;
    private int size = 0;

    public TreeNode(int d) {
        data = d;
        size = 1;
    }

    public int size() {
        return size;
    }

    public static TreeNode createMinimalBST(int[] array) {
        return create(array, 0, array.length, null);
    }

    private static TreeNode create(int[] arr, int start, int end, TreeNode parent) {
        int mid = (start + end) / 2;
        if (start >= end || mid > arr.length) {
            return  null;
        }

        TreeNode node = new TreeNode(arr[mid]);
        node.parent = parent;

        node.left = create(arr, start, mid, node);
        if (node.left != null)
            node.size = node.size + node.left.size;

        node.right = create(arr, mid+1, end, node);
        if (node.right != null && node.right.size >= node.size)
            node.size = node.size + node.right.size;

        return node;
    }

    public static boolean isBalanced(TreeNode node) {
        if (node == null) {
            return true;
        } else if (node.left == null && node.right == null) {
            return true;
        } else if (node.left == null) {
            return node.right.size() == 1;
        } else if (node.right == null) {
            return node.left.size() == 1;
        } else {
            int diff = node.left.size() - node.right.size();
            if (diff > 1 || diff < -1) {
                return false;
            }
            else {
                return isBalanced(node.left) && isBalanced(node.right);
            }
        }
    }

    public boolean isBST() {
        if (left != null && data < left.data){
            return false;
        } else if (left == null) {
            return true;
        }

        if (right != null && data >= right.data) {
            return false;
        } else if (right == null) {
            return true;
        }

        return left.isBST() && right.isBST();
    }

    public void insertInOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        insertInOrder(node.left);
        System.out.print(node.data + " ");
        insertInOrder(node.right);
    }

    public TreeNode find(int d) {
        if (d == data) {
            return this;
        } else if (d <= data) {
            return left != null ? left.find(d) : null;
        } else if (d > data) {
            return right != null ? right.find(d) : null;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5,6,7,8,9,10};
        final TreeNode node = createMinimalBST(arr);
        final TreeNode ancestor = CommonAncestor.commonAncestor(node, node.find(arr[0]), node.find(arr[9]));
        System.out.println(ancestor.data);
    }
}
