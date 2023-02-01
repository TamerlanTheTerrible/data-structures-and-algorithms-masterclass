package exercises.graph;

import java.util.ArrayList;

/**
 * Created by Temurbek Ismoilov on 30/01/23.
 */

public  class GraphNode {
    public String name;
    public int index;
    public boolean isVisited = false;
    public GraphNode parent;
    public Graph.State state;

    public ArrayList<GraphNode> neighbors = new ArrayList<GraphNode>();

    public GraphNode(String name, int index) {
        this.name = name;
        this.index = index;
    }
}
