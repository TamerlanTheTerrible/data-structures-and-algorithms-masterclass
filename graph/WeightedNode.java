package graph;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Temurbek Ismoilov on 30/01/23.
 */

public class WeightedNode implements Comparable<WeightedNode>{
    public String name;
    public ArrayList<WeightedNode> neighbors = new ArrayList<>();
    public HashMap<WeightedNode, Integer> weightMap = new HashMap<>();
    public boolean isVisited = false;
    public WeightedNode parent;
    public int distance;
    public int index;
    public DisjointSet set;

    public WeightedNode(String name, int index) {
        this.name = name;
        this.distance = Integer.MAX_VALUE;
        this.index = index;
    }

    public WeightedNode(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(WeightedNode o) {
        return this.distance - o.distance;
    }
}