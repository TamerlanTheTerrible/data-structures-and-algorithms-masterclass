package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Temurbek Ismoilov on 26/01/23.
 */

public class MatrixGraph {
    private ArrayList<GraphNode> nodeList;
    int[][] adjacenyMatrix;

    public MatrixGraph(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
        adjacenyMatrix = new int[nodeList.size()][nodeList.size()];
    }

    public void addUndirectedEdge(int i, int j) {
        adjacenyMatrix[i][j] = 1;
        adjacenyMatrix[j][i] = 1;
    }

    public void addDirectedEdge(int i, int j) {
        adjacenyMatrix[i][j] = 1;
    }

    public void bfs() {
        for (GraphNode node: nodeList) {
            if (!node.isVisited) {
                bfsVisit(node);
            }
        }
    }

    private void bfsVisit(GraphNode node) {
        LinkedList<GraphNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            GraphNode currentNode = queue.remove(0);
            System.out.print(currentNode.name + " ");
            currentNode.isVisited = true;
            ArrayList<GraphNode> neighbors = getNeighbors(currentNode);
            for (GraphNode neighbor: neighbors) {
                if (!neighbor.isVisited) {
                    queue.add(neighbor);
                    neighbor.isVisited = true;
                }
            }
        }
    }

    public void dfs() {
        for (GraphNode node: nodeList) {
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
            ArrayList<GraphNode> neighbors = getNeighbors(currentNode);
            for(GraphNode neighbor: neighbors) {
                if (!neighbor.isVisited) {
                    stack.push(neighbor);
                    neighbor.isVisited = true;
                }
            }
        }
    }

    //get neighbors
    private ArrayList<GraphNode> getNeighbors(GraphNode node) {
        ArrayList<GraphNode> neighbors = new ArrayList<>();
        int nodeIndex = node.index;
        for (int i = 0; i < adjacenyMatrix.length; i++) {
            if (adjacenyMatrix[nodeIndex][i] == 1) {
                neighbors.add(nodeList.get(i));
            }
        }
        return neighbors;
    }

    public void topologicalSort() {
        Stack<GraphNode> stack = new Stack<>();
        for(GraphNode node: nodeList) {
            if (!node.isVisited) {
                topologicalVisit(node, stack);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().name + " ");
        }
        System.out.println();
    }

    private void topologicalVisit(GraphNode node, Stack<GraphNode> stack) {
        ArrayList<GraphNode> neighbors = getNeighbors(node);
        for (GraphNode neighbor: neighbors) {
            if (!neighbor.isVisited) {
                topologicalVisit(neighbor, stack);
            }
        }
        node.isVisited = true;
        stack.push(node);
    }

    public void bfsForSSSPP(MatrixGraph.GraphNode node) {
        LinkedList<MatrixGraph.GraphNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            MatrixGraph.GraphNode currentNode = queue.remove(0);
            currentNode.isVisited = true;
            System.out.print("Printing path for node " + currentNode.name + ": ");
            pathPrint(currentNode);
            System.out.println();
            for(MatrixGraph.GraphNode neighbor: getNeighbors(currentNode)) {
                if (!neighbor.isVisited) {
                    queue.add(neighbor);
                    neighbor.isVisited = true;
                    neighbor.parent = currentNode;
                }
            }
        }
    }

    public static void pathPrint(MatrixGraph.GraphNode node) {
        if (node.parent != null) {
            pathPrint(node.parent);
        }
        System.out.print(node.name + " ");
    }



    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("   ");
        for (GraphNode graphNode : nodeList) {
            s.append(graphNode.name).append(" ");
        }
        s.append("\n");
        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).name).append(": ");
            for (int j: adjacenyMatrix[i]) {
                s.append(j).append(" ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public static class GraphNode {
        public String name;
        public int index;
        public boolean isVisited = false;
        public GraphNode parent;

        public GraphNode(String name, int index) {
            this.name = name;
            this.index = index;
        }
    }
}
