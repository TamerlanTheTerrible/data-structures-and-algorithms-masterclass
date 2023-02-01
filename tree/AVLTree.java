package tree;

import java.util.Base64;

/**
 * Created by Temurbek Ismoilov on 23/01/23.
 */

public class AVLTree extends BinarySearchTree {
    @Override
    public void insert(Integer value) {
        root = insertNode(root, value);
    }

    @Override
    public void delete(int value) {
        this.root = this.delete(root, value);
    }

    @Override
    protected BinaryNode<Integer> delete(BinaryNode<Integer>  node, int value) {
        if (node == null) {
            System.out.println("Value not found in AVL");
            return node;
        }
        if (value < node.value) {
            node.left = delete(node.left, value);
        } else if (value > node.value) {
            node.right = delete(node.right, value);
        } else {
            if (node.left != null && node.right != null) {
                BinaryNode<Integer> temp = node;
                BinaryNode<Integer> minNodeForRight = minimumNode(temp.right);
                node.value = minNodeForRight.value;
                node.right = delete(node.right, minNodeForRight.value);
            } else if (node.left != null) {
                node = node.left;
            } else if (node.right != null) {
                node = node.right;
            } else {
                node = null;
            }
        }
        // Case 2 - rotation required

        // System.out.println("1");
        // System.out.println(previous.value);

        // node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        int balance = getBalance(node);

        if (balance > 1 && getBalance(node.left) >= 0) {
            return rotateRight(node);
        }
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        if (balance < -1 && getBalance(node.right) <= 0) {
            return rotateLeft(node);
        }

        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    //  getHeight
    public int getHeight(BinaryNode<Integer>  node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    // rotateRight
    private BinaryNode<Integer> rotateRight(BinaryNode<Integer>  disbalancedNode) {
        BinaryNode<Integer>  newRoot = disbalancedNode.left;
        disbalancedNode.left = disbalancedNode.left.right;
        newRoot.right = disbalancedNode;
        disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    // rotateLeft
    private BinaryNode<Integer>  rotateLeft(BinaryNode<Integer>  disbalancedNode) {
        BinaryNode<Integer>  newRoot = disbalancedNode.right;
        disbalancedNode.right = disbalancedNode.right.left;
        newRoot.left = disbalancedNode;
        disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    // getBalance
    public int getBalance(BinaryNode<Integer>  node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    // insertNode Method
    private BinaryNode<Integer>  insertNode(BinaryNode<Integer>  node, int nodeValue) {
        if (node == null) {
            BinaryNode<Integer>  newNode = new BinaryNode<>();
            newNode.value = nodeValue;
            newNode.height = 1;
            return newNode;
        } else if (nodeValue < node.value) {
            node.left = insertNode(node.left, nodeValue);
        } else {
            node.right = insertNode(node.right, nodeValue);
        }

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        int balance = getBalance(node);

        if (balance > 1 && nodeValue < node.left.value) {
            return rotateRight(node);
        }

        if (balance > 1 && nodeValue > node.left.value) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        if (balance < -1 && nodeValue > node.right.value) {
            return rotateLeft(node);
        }

        if (balance < - 1 && nodeValue < node.right.value) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;

    }

    public void insert(int value) {
        root = insertNode(root, value);
    }

    // // Minimum node
    public static BinaryNode<Integer>  minimumNode(BinaryNode<Integer>  root) {
        if (root.left == null) {
            return root;
        } else {
            return minimumNode(root.left);
        }
    }
}
