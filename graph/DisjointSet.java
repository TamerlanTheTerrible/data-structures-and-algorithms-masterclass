package graph;

import java.util.ArrayList;

/**
 * Created by Temurbek Ismoilov on 30/01/23.
 */

public class DisjointSet {
    private ArrayList<WeightedNode> nodeList = new ArrayList<>();

    public static void makeSet(ArrayList<WeightedNode> nodeList) {
        for (WeightedNode node : nodeList) {
            DisjointSet set = new DisjointSet();
            set.nodeList.add(node);
            node.set = set;
        }
    }

    public static DisjointSet findSet(WeightedNode node) {
        return node.set;
    }

    public static DisjointSet union(WeightedNode node1, WeightedNode node2) {
        if (node1.set.equals(node2.set)) {
            return null;
        }

        DisjointSet set1 = node1.set;
        DisjointSet set2 = node2.set;

        if (set1.nodeList.size() > set2.nodeList.size()) {
            ArrayList<WeightedNode> set2NodeList = set2.nodeList;
            for (WeightedNode node: set2NodeList) {
                node.set =set1;
                set1.nodeList.add(node);
            }
            return set1;
        } else {
            ArrayList<WeightedNode> set1NodeList = set1.nodeList;
            for (WeightedNode node: set1NodeList) {
                node.set =set2;
                set2.nodeList.add(node);
            }
            return set2;
        }
    }

    public void printAllNodesOfThisSEt() {
        System.out.println("Printing all nodes of the set: ");
        for (WeightedNode node: nodeList) {
            System.out.print(node + " ");
        }
        System.out.println();
    }
}
