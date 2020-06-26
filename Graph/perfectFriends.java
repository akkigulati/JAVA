/*
Question
1. You are given a number n (representing the number of students). Each student will have an id from 0 to n - 1.
2. You are given a number k (representing the number of clubs)
3. In the next k lines, two numbers are given separated by a space. The numbers are ids of students belonging to same club.
4. You have to find in how many ways can we select a pair of students such that both students are from different clubs.
Input Format
Input has been managed for you
Output Format
Check the sample output
Constraints
None
Sample Input
7
5
0 1
2 3
4 5
5 6
4 6
Sample Output
16
*/
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
         int wt = 0;
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
      boolean visited[]=new boolean[vtces];
      for(int i=0;i<vtces;i++){
          if(!visited[i]){
              ArrayList<Integer> comp=new ArrayList<>();
             gcc(graph,i,visited,comp);
              comps.add(comp);
          }
      }
      
    int combinations=0;
    for(int i=0;i<comps.size()-1;i++){
        for(int j=i+1;j<comps.size();j++){
            combinations+=comps.get(i).size()*comps.get(j).size();
        }
    }
      System.out.println(combinations);
   }
   
   public static void gcc(ArrayList<Edge>[] graph,int vertex,boolean visited[],ArrayList<Integer> comp){

       visited[vertex]=true;
       comp.add(vertex);
       for(Edge e:graph[vertex]){
           if(visited[e.nbr]==false){
               gcc(graph,e.nbr,visited,comp);
           }
       }
   }
}
