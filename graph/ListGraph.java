package graph;

import exercises.graph.Graph;
import exercises.graph.GraphNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Temurbek Ismoilov on 26/01/23.
 */

public class ListGraph {
    ArrayList<GraphNode> nodeList;

    public ListGraph(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
    }

    public void addUndirectedEdge(int i, int j) {
        GraphNode first = nodeList.get(i);
        GraphNode second = nodeList.get(j);
        first.neighbors.add(second);
        second.neighbors.add(first);
    }

    public void addDirectedEdge(int i, int j) {
        GraphNode first = nodeList.get(i);
        GraphNode second = nodeList.get(j);
        first.neighbors.add(second);
    }

    public boolean hasRoute(GraphNode firstNode, GraphNode secondNode) {
        LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
        queue.add(firstNode);
        while (!queue.isEmpty()) {
            GraphNode currentNode = queue.remove(0);
//            System.out.print(currentNode.name + " ");
            currentNode.isVisited = true;

            for(GraphNode neighbor: currentNode.neighbors) {
                if (!neighbor.isVisited) {
                    queue.add(neighbor);
                    neighbor.isVisited = true;
                    if (neighbor == secondNode) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void bfs() {
        for(GraphNode node: nodeList) {
            if (!node.isVisited) {
                bfsVisit(node);
            }
        }
    }

    private void bfsVisit(GraphNode node) {
        LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
        queue.add(node);
        while (!queue.isEmpty()) {
            GraphNode currentNode = queue.remove(0);
            System.out.print(currentNode.name + " ");
            currentNode.isVisited = true;

            for(GraphNode neighbor: currentNode.neighbors) {
                if (!neighbor.isVisited) {
                    queue.add(neighbor);
                    neighbor.isVisited = true;
                }
            }
        }
    }

    public void dfs() {
        for(GraphNode node: nodeList) {
            if (!node.isVisited) {
                dfsVisit(node);
            }
        }
    }

    private void dfsVisit(GraphNode node) {
        Stack<GraphNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            GraphNode currentNode = stack.pop();
            System.out.print(currentNode.name + " ");
            currentNode.isVisited = true;
            for (GraphNode neighbor: currentNode.neighbors) {
                if (!neighbor.isVisited) {
                    stack.push(neighbor);
                    neighbor.isVisited=true;
                }
            }
        }
    }

    public void topologicalSort() {
        Stack<GraphNode> stack = new Stack<>();
        for(GraphNode node: nodeList) {
            if (!node.isVisited) {
                topologicalSort(node, stack);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().name + " ");
        }
        System.out.println();
    }

    private void topologicalSort(GraphNode node, Stack<GraphNode> stack) {
        for(GraphNode neighbor: node.neighbors) {
            if (!neighbor.isVisited) {
                topologicalSort(neighbor, stack);
            }
        }
        node.isVisited = true;
        stack.push(node);
    }

    public void bfsForSSSPP(GraphNode node) {
        LinkedList<GraphNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            GraphNode currentNode = queue.remove(0);
            currentNode.isVisited = true;
            System.out.print("Printing path for node " + currentNode.name + ": ");
            pathPrint(currentNode);
            System.out.println();
            for(GraphNode neighbor: currentNode.neighbors) {
                if (!neighbor.isVisited) {
                    queue.add(neighbor);
                    neighbor.isVisited = true;
                    neighbor.parent = currentNode;
                }
            }
        }
    }

    public static void pathPrint(GraphNode node) {
        if (node.parent != null) {
            pathPrint(node.parent);
        }
        System.out.print(node.name + " ");
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (GraphNode node : nodeList) {
            s.append(node.name).append(": ");
            for (int j = 0; j < node.neighbors.size(); j++) {
                if (j == node.neighbors.size() - 1) {
                    s.append(node.neighbors.get(j).name);
                } else {
                    s.append(node.neighbors.get(j).name).append(" -> ");
                }
            }
            s.append("\n");
        }
        s.append("\n");
        return s.toString();
    }

    public static class GraphNode {
        public String name;
        public int index;
        public ArrayList<GraphNode> neighbors = new ArrayList<>();
        public boolean isVisited = false;
        public GraphNode parent;

        public GraphNode(String name, int index) {
            this.name = name;
            this.index = index;
        }
    }
}
