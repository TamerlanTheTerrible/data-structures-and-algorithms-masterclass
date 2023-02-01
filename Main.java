import graph.*;

import java.util.ArrayList;

/**
 * Created by Temurbek Ismoilov on 17/01/23.
 */

public class Main {

    public static void main(String[] args) {
        ArrayList<ListGraph.GraphNode> nodes = new ArrayList<>();
        nodes.add(new ListGraph.GraphNode("A",0));
        nodes.add(new ListGraph.GraphNode("B",1));
        nodes.add(new ListGraph.GraphNode("C",2));
        nodes.add(new ListGraph.GraphNode("D",3));
        nodes.add(new ListGraph.GraphNode("E",4));
        nodes.add(new ListGraph.GraphNode("F",5));
        nodes.add(new ListGraph.GraphNode("G",6));
        nodes.add(new ListGraph.GraphNode("H",7));
        nodes.add(new ListGraph.GraphNode("I",8));
        nodes.add(new ListGraph.GraphNode("J",9));

        ListGraph graph = new ListGraph(nodes);
        graph.addDirectedEdge(4,0);
        graph.addDirectedEdge(4,5);
        graph.addDirectedEdge(5,8);
        graph.addDirectedEdge(0,1);
        graph.addDirectedEdge(0,2);
        graph.addDirectedEdge(0,3);
        graph.addDirectedEdge(1,9);
        graph.addDirectedEdge(2,6);
        graph.addDirectedEdge(6,3);
        graph.addDirectedEdge(6,7);

        System.out.println(
                graph.hasRoute(nodes.get(5), nodes.get(6))
        );
    }
}
