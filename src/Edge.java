
/**
 * Edge class which is responsible for edges in the graph
 */
public class Edge {
    /**
     * Edge's start vertice
     */
    public Vertice start;
    /**
     * Edge's end vertice
     */
    public Vertice dest;
    /**
     * Edge's capacity
     */
    public int capacity;
    /**
     * Controller for dead end
     */
    public boolean deadEnd=false;
    /**
     * Edge's backward edge after DFS
     */
    public Edge reverseEdge=null;

    /**
     * Constructor for the Edge class
     * @param start
     * @param dest
     * @param capacity
     */
    public Edge(Vertice start,Vertice dest, int capacity){
        this.start=start;
        this.dest=dest;
        this.capacity=capacity;
        //dest.reverseConnectedEdges.add(this);

    }





}
