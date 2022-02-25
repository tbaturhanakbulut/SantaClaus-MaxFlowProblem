/**
 * Transporter class which is for reindeers and trains
 */

public class Transporter extends Vertice {
    /**
     * region(red or green)
     */
    public String region;
    /**
     * vehicle(train or reindeer)
     */
    public String vehicleType;
    /**
     * capacity of the transporter
     */
    public int capacity;

    /**
     * Constructor of the transporter class
     * @param capacity
     * @param region
     * @param vehicleType
     */
    public Transporter(int capacity, String region, String vehicleType){
        super(0);
        this.capacity=capacity;
        this.region=region;
        this.vehicleType=vehicleType;
    }

    /**
     * Connects transporters to the sink
     * @param sinkEdge
     */
    public void connectToSink(Edge sinkEdge){
        connectedEdges.add(sinkEdge);
    }
}
