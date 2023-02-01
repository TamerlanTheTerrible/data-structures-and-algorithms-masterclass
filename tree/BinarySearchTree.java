package tree;

import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Temurbek Ismoilov on 22/01/23.
 */

public class BinarySearchTree {
    public BinaryNode<Integer> root;

    public BinarySearchTree() {
        root = null;
    }


    // pre-order traversal
    public void preOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // in-order traversal
    public void inOrder(BinaryNode<Integer> node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    // post-order traversal
    public void postOrder(BinaryNode<Integer> node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

    // lever-order traversal
    public void leverOder() {
        if (root == null) {
            System.out.println("tree is empty");
            return;
        }
        Queue<BinaryNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode<Integer> currentQueue = queue.remove();
            System.out.print(currentQueue.value + " ");
            if (currentQueue.left != null) {
                queue.add(currentQueue.left);
            }
            if (currentQueue.right != null) {
                queue.add(currentQueue.right);
            }
        }
        System.out.println();
    }

    public void insert(Integer value) {
        root = insert(root, value);
    }

    private BinaryNode<Integer> insert(BinaryNode<Integer> node, Integer value) {
        if (node == null) {
            BinaryNode<Integer> newNode = new BinaryNode<>(value);
//            System.out.println(value + " inserted");
            return newNode;
        } else if (node.value >= value) {
            node.left = insert(node.left, value);
            return node;
        } else {
            node.right = insert(node.right, value);
            return node;
        }
    }

    public BinaryNode<Integer> search(BinaryNode<Integer> node, Integer value) {
        if (node == null) {
            System.out.println(value + " not found");
            return null;
        } else if (node.value == value) {
            System.out.println(value + " found");
            return node;
        } else if (node.value >= value) {
            return search(node.left, value);
        } else {
            return search(node.right, value);
        }
    }

    public void delete(int val) {
        root = delete(root, val);
    }

    protected BinaryNode<Integer> delete(BinaryNode<Integer> node, int value) {
        if (node == null) {
            System.out.println(value + " not found");
            return null;
        }

        if (value < node.value) {
            node.left = delete(node.left, value);
        } else if (value > node.value) {
            node.right = delete(node.right, value);
        } else {
            if (node.left != null && node.right != null){
                BinaryNode<Integer> minNode = minimumNode(node.right);
                node.value = minNode.value;
                node.right = delete(node.right, minNode.value);
            } else if (node.left != null) {
                node = node.left;
            } else if (node.right != null) {
                node = node.right;
            } else {
                node = null;
            }
        }
        return node;
    }

    private BinaryNode<Integer> minimumNode(BinaryNode<Integer> node) {
        if (node.left == null) {
            return node;
        }
        return minimumNode(node.left);
    }

    public void deleteTree() {
        root = null;
        System.out.println("tree deleted");
    }

}
