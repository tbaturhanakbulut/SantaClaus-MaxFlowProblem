import java.util.ArrayList;

/**
 * Parent vertice class for bags, transporters, source and sink
 */
public class Vertice {
    /**
     * check whether it is visited or not
     */
    public boolean visited=false;
    /**
     * Outgoing edges
     */
    public ArrayList<Edge> connectedEdges=new ArrayList<>();
   /*
    public ArrayList<Edge> reverseConnectedEdges=new ArrayList<>();*/
    /**
     * Level number for dinic/BFS
     */
    public int levelNumber;

    /**
     * Constructor for Vertice class
     * @param levelNumber
     */
    public Vertice(int levelNumber){
        this.levelNumber=levelNumber;


    }

}
