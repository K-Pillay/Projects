package Question3;

import java.util.LinkedList;
//class for intialising the BusStop that will represent the nodes
public class BusStopNodes {

    protected String BusStopName;//
    protected LinkedList<BusStopNodes> edges; //

    // constructor to initialise the variables

    public BusStopNodes(String busStopName) {
        this.BusStopName = busStopName;
        this.edges = new LinkedList<>();
    }
    //constructor to add edges/ connections between each node
    public void addEdge(BusStopNodes edge) {
        this.edges.add(edge);// creates an edge between the current stop and the added stop, but this only covers a one way relationship
        edge.edges.add(this);// ensures that edges between nodes are bi-directional so traversal can be done both ways

    }
}
