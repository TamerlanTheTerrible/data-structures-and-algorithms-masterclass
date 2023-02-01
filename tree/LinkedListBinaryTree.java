package tree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * Created by Temurbek Ismoilov on 21/01/23.
 */

public class LinkedListBinaryTree<T> {
    public BinaryNode<T> root;

    public LinkedListBinaryTree(){
        this.root = null;
    }

    // pre-order traversal
    public void preOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // in-order traversal
    public void inOrder(BinaryNode<T> node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    // post-order traversal
    public void postOrder(BinaryNode<T> node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value + " ");
    }

    // lever-order traversal
    public void leverOder() {
        if (root == null) {
            System.out.println("tree is empty");
            return;
        }
        Queue<BinaryNode<T>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode<T> currentQueue = queue.remove();
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

    // search
    public void search(T value) {
        Queue<BinaryNode<T>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode<T> currentQueue = queue.remove();
            if (Objects.equals(currentQueue.value, value)) {
                System.out.println(value + " found");
            } else {
                if (currentQueue.left != null) {
                    queue.add(currentQueue.left);
                }
                if (currentQueue.right != null) {
                    queue.add(currentQueue.right);
                }
            }
        }
        System.out.println(value + " not found");
    }

    // insert
//    public void insert (String value) {
//        BinaryNode newNode = new BinaryNode(value);
//        if (root == null) {
//            root = newNode;
//            System.out.println(value + " inserted at root");
//            return;
//        }
//            Queue<BinaryNode> queue = new LinkedList<>();
//            queue.add(root);
//            while (!queue.isEmpty()) {
//                BinaryNode currentNode = queue.remove();
//                if (currentNode.left == null) {
//                    currentNode.left = newNode;
//                    System.out.println(value + " inserted");
//                    break;
//                } else if (currentNode.right == null) {
//                    currentNode.right = newNode;
//                    System.out.println(value + " inserted");
//                    break;
//                } else {
//                    queue.add(currentNode.right);
//                    queue.add(currentNode.right);
//                }
//            }
//    }
    public void insert(T value) {
        BinaryNode<T> newNode = new BinaryNode(value);
        if (root == null) {
            root = newNode;
            System.out.println("Inserted new node at Root");
        } else {
            Queue<BinaryNode<T>> queue = new LinkedList<BinaryNode<T>>();
            queue.add(root);
            while (!queue.isEmpty()) {
                BinaryNode<T> presentNode = queue.remove();
                if (presentNode.left == null) {
                    presentNode.left = newNode;
                    System.out.println(value + " inserted");
                    break;
                } else if (presentNode.right == null) {
                    presentNode.right = newNode;
                    System.out.println(value + " inserted");
                    break;
                } else {
                    queue.add(presentNode.left);
                    queue.add(presentNode.right);
                }
            }
        }
    }

    public void delete(T value) {
        if (root == null) {
            System.out.println("Inserted new node at Root");
        } else {
            Queue<BinaryNode<T>> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                BinaryNode<T> presentNode = queue.remove();
                if (Objects.equals(presentNode.value, value)) {
                    presentNode.value = deleteDeepestNode();
                    System.out.println(value + " deleted");
                    return;
                } else {
                    if (presentNode.left != null) {
                        queue.add(presentNode.left);
                    }
                    if (presentNode.right != null) {
                        queue.add(presentNode.right);
                    }
                }
            }
        }
    }

    // delete deepest node
    private T deleteDeepestNode() {
        if (root == null) {
            System.out.println("Inserted new node at Root");
            return null;
        }
        Queue<BinaryNode<T>> queue = new LinkedList<>();
        queue.add(root);
        BinaryNode<T> presentNode = null;
        BinaryNode<T> previousNode = null;
        while (!queue.isEmpty()) {
            previousNode = presentNode;
            presentNode = queue.remove();
            if (presentNode.left == null) {
                T value = previousNode.right.value;
                previousNode.right = null;
                return value;
            } else if (presentNode.right == null) {
                T value = presentNode.left.value;
                presentNode.left = null;
                return value;
            }
            queue.add(presentNode.left);
            queue.add(presentNode.right);
        }
        return null;
    }

    public T getDeepestNodeValue() {
        if (root == null) {
            System.out.println("empty tree");
            return null;
        }
        Queue<BinaryNode<T>> queue = new LinkedList<>();
        queue.add(root);
        BinaryNode<T> node = null;
        while (!queue.isEmpty()) {
            node = queue.remove();
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return node.value;
    }

    public void deleteTree() {
        root = null;
        System.out.println("tree is deleted");
    }
}



