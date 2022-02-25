import java.util.ArrayList;

/**
 * Bag class for gift bags
 */
public class Bag extends Vertice {
    /**
     * total gift in a bag
     */
    int nofGift;
    /**
     * constraints for creating edges
     */
    String constraints;

    /**
     * Constructor for the bag class
     * @param constraints
     * @param nofGift
     * @param transporterList
     */
    public Bag(String constraints, int nofGift, ArrayList<Transporter> transporterList){
        super(0);
        createEdges(constraints, transporterList);
        this.nofGift=nofGift;
        this.constraints=constraints;
    }

    /**
     * Creates edges to the transporters due to the constraints
     * @param constraints
     * @param transporterList
     */
    public void createEdges(String constraints, ArrayList<Transporter> transporterList){
        if(constraints.equals("a")){
            for(int i=0;i< transporterList.size();i++){
                Edge edge= new Edge(this,transporterList.get(i),1);
                connectedEdges.add(edge);
            }
        }
        else if(constraints.equals("b")){
            for(int i=0;i< transporterList.size();i++){
                if(transporterList.get(i).region.equals("green"))
                    connectedEdges.add(new Edge(this,transporterList.get(i),transporterList.get(i).capacity));
            }
        }
        else if(constraints.equals("c")){
            for(int i=0;i< transporterList.size();i++){
                if(transporterList.get(i).region.equals("red"))
                    connectedEdges.add(new Edge(this,transporterList.get(i),transporterList.get(i).capacity));
            }
        }
        else if(constraints.equals("d")){
            for(int i=0;i< transporterList.size();i++){
                if(transporterList.get(i).vehicleType.equals("train"))
                    connectedEdges.add(new Edge(this,transporterList.get(i),transporterList.get(i).capacity));
            }
        }
        else if(constraints.equals("e")){
            for(int i=0;i< transporterList.size();i++){
                if(transporterList.get(i).vehicleType.equals("reindeer"))
                    connectedEdges.add(new Edge(this,transporterList.get(i),transporterList.get(i).capacity));
            }
        }
        else if(constraints.equals("ab")){
            for(int i=0;i< transporterList.size();i++){
                if(transporterList.get(i).region.equals("green"))
                    connectedEdges.add(new Edge(this,transporterList.get(i),1));
            }
        }
        else if(constraints.equals("ac")){
            for(int i=0;i< transporterList.size();i++){
                if(transporterList.get(i).region.equals("red"))
                    connectedEdges.add(new Edge(this,transporterList.get(i),1));
            }
        }
        else if(constraints.equals("ad")){
            for(int i=0;i< transporterList.size();i++){
                if(transporterList.get(i).vehicleType.equals("train"))
                    connectedEdges.add(new Edge(this,transporterList.get(i),1));
            }
        }
        else if(constraints.equals("ae")){
            for(int i=0;i< transporterList.size();i++){
                if(transporterList.get(i).vehicleType.equals("reindeer"))
                    connectedEdges.add(new Edge(this,transporterList.get(i),1));
            }
        }
        else if(constraints.equals("bd")){
            for(int i=0;i< transporterList.size();i++){
                if(transporterList.get(i).vehicleType.equals("train") && transporterList.get(i).region.equals("green"))
                    connectedEdges.add(new Edge(this,transporterList.get(i),transporterList.get(i).capacity));
            }
        }
        else if(constraints.equals("be")){
            for(int i=0;i< transporterList.size();i++){
                if(transporterList.get(i).vehicleType.equals("reindeer") && transporterList.get(i).region.equals("green"))
                    connectedEdges.add(new Edge(this,transporterList.get(i),transporterList.get(i).capacity));
            }
        }
        else if(constraints.equals("cd")){
            for(int i=0;i< transporterList.size();i++){
                if(transporterList.get(i).vehicleType.equals("train") && transporterList.get(i).region.equals("red"))
                    connectedEdges.add(new Edge(this,transporterList.get(i),transporterList.get(i).capacity));
            }
        }
        else if(constraints.equals("ce")){
            for(int i=0;i< transporterList.size();i++){
                if(transporterList.get(i).vehicleType.equals("reindeer") && transporterList.get(i).region.equals("red"))
                    connectedEdges.add(new Edge(this,transporterList.get(i),transporterList.get(i).capacity));
            }
        }
        else if(constraints.equals("abd")){
            for(int i=0;i< transporterList.size();i++){
                if(transporterList.get(i).vehicleType.equals("train") && transporterList.get(i).region.equals("green"))
                    connectedEdges.add(new Edge(this,transporterList.get(i),1));
            }
        }
        else if(constraints.equals("abe")){
            for(int i=0;i< transporterList.size();i++){
                if(transporterList.get(i).vehicleType.equals("reindeer") && transporterList.get(i).region.equals("green"))
                    connectedEdges.add(new Edge(this,transporterList.get(i),1));
            }
        }
        else if(constraints.equals("acd")){
            for(int i=0;i< transporterList.size();i++){
                if(transporterList.get(i).vehicleType.equals("train") && transporterList.get(i).region.equals("red"))
                    connectedEdges.add(new Edge(this,transporterList.get(i),1));
            }
        }
        else if(constraints.equals("ace")){
            for(int i=0;i< transporterList.size();i++){
                if(transporterList.get(i).vehicleType.equals("reindeer") && transporterList.get(i).region.equals("red"))
                    connectedEdges.add(new Edge(this,transporterList.get(i),1));
            }
        }

    }


}
