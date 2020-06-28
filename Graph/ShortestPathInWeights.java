import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      int src = Integer.parseInt(br.readLine());
      Dijikstra(graph,src);
   }
   static public class pair implements Comparable<pair>{
       int vtx;
       String path;
       int wt;
       pair(int vtx,String path,int wt){
           this.vtx=vtx;
           this.path=path;
           this.wt=wt;
       }
       
       public int compareTo(pair o){
           return this.wt-o.wt;
       }
   }
   public static void Dijikstra(ArrayList<Edge>[] graph,int src){
       PriorityQueue<pair> pq=new PriorityQueue<>();
       boolean visited[]=new boolean[graph.length];
       pq.add(new pair(src,""+src,0));
       while(pq.size()>0)
       {
           pair temp=pq.remove();
           if(!visited[temp.vtx]){
               visited[temp.vtx]=true;
               System.out.println(temp.vtx+" via "+temp.path+" @ "+temp.wt);
               for(Edge e:graph[temp.vtx]){
                   if(!visited[e.nbr]){
                       pq.add(new pair(e.nbr,temp.path+e.nbr,temp.wt+e.wt));
                   }
               }
           }
       }
   }
}
