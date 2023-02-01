package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created by Temurbek Ismoilov on 28/01/23.
 */

public class WeightedGraph {

    ArrayList<WeightedNode> nodeList;

    public WeightedGraph(ArrayList<WeightedNode> nodeList) {
        this.nodeList = nodeList;
    }

    public void addWeightedEdge(int i, int j, int weight) {
        WeightedNode first = nodeList.get(i);
        WeightedNode second = nodeList.get(j);
        first.neighbors.add(second);
        first.weightMap.put(second, weight);
    }

    public void dijkstra(WeightedNode node) {
        PriorityQueue<WeightedNode> queue = new PriorityQueue<>();
        node.distance = 0;
        queue.addAll(nodeList);
        while (!queue.isEmpty()) {
            WeightedNode currentNode = queue.remove();
            for (WeightedNode neighbor: currentNode.neighbors) {
                if (queue.contains(neighbor)) {
                    if (neighbor.distance > currentNode.distance + currentNode.weightMap.get(neighbor)) {
                        neighbor.distance = currentNode.distance + currentNode.weightMap.get(neighbor);
                        neighbor.parent = currentNode;
                        queue.remove(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }

        for (WeightedNode nodeToCheck: nodeList) {
            System.out.print("Node " + nodeToCheck + ", distance: " + nodeToCheck.distance + ", Path: ");
            pathPrint(nodeToCheck);
            System.out.println();
        }
    }

    public void bellmanFord(WeightedNode node) {
        node.distance = 0;
        for (int i = 0; i < nodeList.size(); i++) {
            for (WeightedNode currentNode: nodeList) {
                for (WeightedNode neighbor: currentNode.neighbors) {
                    if (neighbor.distance > currentNode.distance + currentNode.weightMap.get(neighbor)) {
                        neighbor.distance = currentNode.distance + currentNode.weightMap.get(neighbor);
                        neighbor.parent = currentNode;
                    }
                }
            }
        }
        //checking for a negative cycle
        System.out.println("Checking for negative cycle...");
        for (WeightedNode currentNode: nodeList) {
            for (WeightedNode neighbor: currentNode.neighbors) {
                if (neighbor.distance > currentNode.distance + currentNode.weightMap.get(neighbor)) {
                    System.out.println("Negative cycle found: \n");
                    System.out.println("Vertex name: " + neighbor.name);
                    System.out.println("Old value: " + neighbor.distance);
                    System.out.println("New value: " + currentNode.distance + currentNode.weightMap.get(neighbor));
                    return;
                }
            }
        }
        System.out.println("Negative cycle not found");

        //print path
        for (WeightedNode nodeToCheck: nodeList) {
            System.out.print("Node " + nodeToCheck + ", distance: " + nodeToCheck.distance + ", Path: ");
            pathPrint(nodeToCheck);
            System.out.println();
        }
    }

    public static void pathPrint(WeightedNode node) {
        if (node.parent != null) {
            pathPrint(node.parent);
        }
        System.out.print(node.name + " ");
    }

    public void floydWarshall() {
        int size = nodeList.size();
        //fill matrix
        int[][] V = new int[size][size];
        for (int i = 0; i < size; i++) {
            WeightedNode firstNode = nodeList.get(i);
            for (int j = 0; j < size; j++) {
                WeightedNode secondNOde = nodeList.get(j);
                if (i==j) {
                    V[i][j] = 0;
                } else if (firstNode.weightMap.containsKey(secondNOde)) {
                    V[i][j] = firstNode.weightMap.get(secondNOde);
                } else {
                    V[i][j] = Integer.MAX_VALUE/10;
                }
            }
        }

        //calculate the shortest paths via floyd-warshall
        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (V[i][j] > V[i][k] + V[k][j]) {
                        V[i][j] = V[i][k] + V[k][j];
                    }
                }
            }
        }

        for (int i = 0; i < size; i++) {
            System.out.print("Printing distance list for node: " + nodeList.get(i) + " ");
            for (int j = 0; j < size; j++) {
                System.out.print(V[i][j] + " ");
            }
            System.out.println();
        }
    }
}
