import java.io.*;
import java.util.*;

/**
 * Main class for the project
 * @author Taha Baturhan Akbulut
 */
public class project4main {

    public static void main(String[] args) throws IOException {
            File myInputFile = new File(args[0]);
            File myOutputFile = new File(args[1]);
            Scanner sc= new Scanner(myInputFile);
            PrintStream out= new PrintStream(myOutputFile);
            HashMap<String,Integer> constraintCounter= new HashMap<>();
            ArrayList<Vertice> graph=new ArrayList<>();
            ArrayList<Transporter> transporterList=new ArrayList<>();
            Vertice source= new Vertice(0);
            Vertice sink= new Vertice(0);
            graph.add(source);
            graph.add(sink);
            int TOTAL_NOF_GIFTS=0;
            //READING INPUTS
            int nofSCEGreen=sc.nextInt();
            if(nofSCEGreen!=0){
                while(nofSCEGreen!=0){
                    Transporter vertice = new Transporter(sc.nextInt(),"green","train");
                    vertice.connectToSink(new Edge(vertice,sink, vertice.capacity));
                    transporterList.add(vertice);
                    graph.add(vertice);
                    nofSCEGreen--;
                }
            }
            int nofSCERed=sc.nextInt();
            if(nofSCERed!=0){
                while(nofSCERed!=0){
                    Transporter vertice = new Transporter(sc.nextInt(),"red","train");
                    vertice.connectToSink(new Edge(vertice,sink, vertice.capacity));
                    transporterList.add(vertice);
                    graph.add(vertice);
                    nofSCERed--;
                }
            }
            int nofReindeerGreen=sc.nextInt();

            if(nofReindeerGreen!=0){
                while(nofReindeerGreen!=0){
                    Transporter vertice = new Transporter(sc.nextInt(),"green","reindeer");
                    vertice.connectToSink(new Edge(vertice,sink, vertice.capacity));
                    transporterList.add(vertice);
                    graph.add(vertice);
                    nofReindeerGreen--;
                }
            }
            int nofReindeerRed=sc.nextInt();
            if(nofReindeerRed!=0){
                while(nofReindeerRed!=0){
                    Transporter vertice = new Transporter(sc.nextInt(),"red","reindeer");
                    vertice.connectToSink(new Edge(vertice,sink, vertice.capacity));
                    transporterList.add(vertice);
                    graph.add(vertice);
                    nofReindeerRed--;
                }
            }
            ArrayList<Bag> bagsList=new ArrayList<>();
            int nofBags=sc.nextInt();
            if(nofBags!=0){
                sc.nextLine();

                String[] splittedBagConst= sc.nextLine().split(" ");
                String constraints="";
                for(int i=0;i<splittedBagConst.length;i++){
                    if(i%2==0){
                        constraints=splittedBagConst[i];
                    }
                    else{
                        if(constraints.length()==0){
                            System.out.println("ERROR!");
                        }
                        int nofGift=Integer.parseInt(splittedBagConst[i]);
                        TOTAL_NOF_GIFTS+=nofGift;
                        if(!constraints.contains("a")){
                            if(constraintCounter.containsKey(constraints)){
                                for(Bag bag: bagsList){
                                    if(constraints.equals(bag.constraints)){
                                        bag.nofGift+=nofGift;
                                        for(Edge edge: source.connectedEdges){
                                            if(edge.dest.equals(bag)){
                                                edge.capacity+=nofGift;
                                            }
                                        }
                                    }
                                }
                            }
                            else{
                                constraintCounter.put(constraints,0);
                                Bag vertice= new Bag(constraints, nofGift, transporterList);
                                source.connectedEdges.add(new Edge(source,vertice,vertice.nofGift));
                                bagsList.add(vertice);
                                graph.add(vertice);
                            }
                        }
                        else{
                            Bag vertice= new Bag(constraints, nofGift, transporterList);
                            source.connectedEdges.add(new Edge(source,vertice,vertice.nofGift));
                            bagsList.add(vertice);
                            graph.add(vertice);
                        }


                    }

                }
            }
            //RUNNING THE ALGORITHM
            Stack<Edge> path= new Stack<>();
            int result=Dinic.dinic(source,sink,path,graph);
            //PRINT THE RESULT
            out.print(TOTAL_NOF_GIFTS-result);
            sc.close();
            out.close();

    }



}
