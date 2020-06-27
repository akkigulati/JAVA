/*
Question
1. You are given a graph.
2. You are required to find and print if the graph is bipartite

Note -> A graph is called bipartite if it is possible to split it's vertices in two sets of mutually exlusive and exhaustive vertices such that all edges are across sets
Input Format
Input has been managed for you
Output Format
true if the graph is bipartite, false otherwise
Constraints
None
Sample Input
7
8
0 1 10
1 2 10
2 3 10
0 3 10
3 4 10
4 5 10
5 6 10
4 6 10
Sample Output
false
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
        ArrayList < Edge > [] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList < > ();
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

        System.out.println(isGraphBipartite(graph));
    }
    public static boolean isGraphBipartite(ArrayList < Edge > [] graph) {
        HashMap < Integer, Integer > visited = new HashMap < > ();

        for (int i = 0; i < graph.length; i++) {

            if (!visited.containsKey(i)) {
                if (!isBipartite(graph, i, visited)) {
                    return false;
                }

            }
        }
        return true;
    }
    static class pair {
        int vtx;
        int l;
        pair(int vtx, int l) {
            this.vtx = vtx;
            this.l = l;
        }
    }
    public static boolean isBipartite(ArrayList < Edge > [] graph, int src, HashMap<Integer,Integer> visited) {
        Queue < pair > qu = new ArrayDeque <  > ();
        qu.add(new pair(src,0));
        while (qu.size() > 0) {
            pair temp = qu.remove();
            
           if(visited.containsKey(temp.vtx)){
               //already visited
               if(temp.l%2!=visited.get(temp.vtx)%2)
               return false;
           }else{
               //first visited
               visited.put(temp.vtx,temp.l);
           }
           for(Edge e:graph[temp.vtx]){
               if(visited.containsKey(e.nbr)==false){
                   qu.add(new pair(e.nbr,temp.l+1));
               }
           }
            
            
        }
        return true;
    }


}
