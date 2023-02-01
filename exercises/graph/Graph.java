package exercises.graph;

import graph.ListGraph;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Temurbek Ismoilov on 30/01/23.
 */

public class Graph {


    static ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

    public enum State {
        Unvisited, Visited, Visiting;
    }

    public Graph(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
    }


    public void addDirectedEdge(int i, int j) {
        GraphNode first = nodeList.get(i);
        GraphNode second = nodeList.get(j);
        first.neighbors.add(second);
    }

    public boolean search(GraphNode firstNode, GraphNode secondNode) {
        LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
        queue.add(firstNode);
        while (!queue.isEmpty()) {
            GraphNode currentNode = queue.remove(0);
            System.out.print(currentNode.name + " ");
            currentNode.isVisited = true;

            for(GraphNode neighbor: currentNode.neighbors) {
                if (!neighbor.isVisited) {
                    if (neighbor == secondNode) {
                        return true;
                    } else {
                        queue.add(neighbor);
                        neighbor.isVisited = true;
                    }
                }
            }
        }
        return false;
    }

//  Route Between Nodes
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

}