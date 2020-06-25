import java.util.*;

public class Main{
private static class Edge<I>{
    I sr;
    I dt;
    int cost;
    Edge(I sr,I dt,int cost){
        this.sr=sr;
        this.dt=dt;
        this.cost=cost;
    }
}
public static void main(String[] args) {

    int vertices=7;
    //array of arraylist
    ArrayList<Edge<Integer>> graph[]=new ArrayList[vertices];
    for(int i=0;i<graph.length;i++){
        graph[i]=new ArrayList<>();
    }
        graph[0].add(new Edge(0,1,10));
        graph[0].add(new Edge(0,3,40));
        
        graph[1].add(new Edge(1,0,10));
        graph[1].add(new Edge(1,2,10));
        
        graph[2].add(new Edge(2,1,10));
        graph[2].add(new Edge(2,3,10));
        
        graph[3].add(new Edge(3,0,40));
        graph[3].add(new Edge(3,2,10));
        graph[3].add(new Edge(3,4,5));
        
        graph[4].add(new Edge(4,3,5));
        graph[4].add(new Edge(4,5,5));
        graph[4].add(new Edge(4,6,8));
        
        graph[5].add(new Edge(5,4,3));
        graph[5].add(new Edge(5,6,4));
        
        graph[6].add(new Edge(6,4,8));
        graph[6].add(new Edge(6,5,4));
        
        for(int i=0;i<graph.length;i++){
            System.out.print("Vertex is "+i+" -> ");
            for(Edge ei:graph[i]){
                System.out.print(ei.dt+"@"+ei.cost+" , ");
            }
            System.out.println(".");
        }
        
        
        
 }
}