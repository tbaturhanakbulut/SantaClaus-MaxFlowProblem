import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Dinic class for the main algorithm of the problem
 * @author Taha Baturhan Akbulut
 */
public class Dinic {


    /**
     * BFS for attaching level numbers and whether there is path to the sink or not
     * @param source
     * @param sink
     * @param graph
     * @return
     */
    private static boolean BFS(Vertice source, Vertice sink,ArrayList<Vertice> graph){
        Queue<Vertice> queue= new LinkedList<>();
        queue.add(source);
        source.visited=true;
        while(!queue.isEmpty()){
            Vertice currentVertice=queue.poll();
            for(Edge edge: currentVertice.connectedEdges){
                if(!edge.dest.visited && edge.capacity!=0){
                    queue.add(edge.dest);
                    edge.dest.levelNumber=currentVertice.levelNumber+1;
                    edge.dest.visited=true;
                }
            }
        }
        return sink.visited;
    }

    /**
     * DFS for finding paths due to the level numbers
     * @param source
     * @param sink
     * @param path
     * @return
     */
    private static boolean DFS(Vertice source, Vertice sink, Stack<Edge> path) {
        source.visited=true;

        if(source.equals(sink)){
            return true;
        }
        for(Edge edge: source.connectedEdges){
            if(!edge.dest.visited && edge.capacity!=0 && !edge.deadEnd&&(edge.dest.levelNumber> source.levelNumber)){
                path.add(edge);
                boolean check=DFS(edge.dest,sink,path);
                if(check){

                    return true;
                }
            }
        }
        if(!path.isEmpty()){
            path.peek().deadEnd=true;
            path.pop();
        }
        return false;
    }

    /**
     * Main dinic controller
     * @param source Source of the graph
     * @param sink  Sink of the graph
     * @param path Path after one DFS
     * @param graph Main graph ArrayList
     * @return
     */
     static int dinic(Vertice source, Vertice sink, Stack<Edge> path, ArrayList<Vertice> graph){
        int max_flow=0;

        while(BFS(source,sink,graph)) {
            while (true) {
                for(Vertice v:graph){
                    v.visited=false;
                }
                path.clear();
                DFS(source, sink, path);
                if(path.isEmpty()){
                    break;
                }
                int min_cap=Integer.MAX_VALUE;
                for(Edge edge: path){
                    if(edge.capacity<min_cap){
                        min_cap= edge.capacity;
                    }
                }
                for(Edge edge: path){
                    edge.capacity-=min_cap;

                    if(edge.reverseEdge==null){
                        Edge edgeReverse= new Edge(edge.dest,edge.start,min_cap);
                        edge.dest.connectedEdges.add(edgeReverse);
                        edge.reverseEdge=edgeReverse;
                        edgeReverse.reverseEdge=edge;
                    }
                    else{
                        edge.reverseEdge.capacity+=min_cap;
                    }
                }
                for(Edge edge: path){
                    if(edge.capacity<0){
                        edge.capacity=0;
                    }
                }
                //System.out.println(max_flow);
                max_flow += min_cap;


            }
            for(Vertice v:graph){
                v.visited=false;
                v.levelNumber=0;
                for(Edge edge:v.connectedEdges){
                    edge.deadEnd=false;
                }
            }
        }
        return max_flow;
    }
}
