import java.util.*;

public class Main{

public static void main(String[] args) {

//for max:
//PriorityQueue<String> pq=new PriorityQueue<String>(Collections.reverseOrder());
//for min:
//PriorityQueue<String> pq=new PriorityQueue<String>();

 PriorityQueue<String> pq=new PriorityQueue<String>();
  pq.add("hello");
    pq.add("hello1");
    pq.add("he");
    pq.add("1");
    pq.add("c");
    pq.add("cb");
    pq.add("cbd");
    while(pq.size()>0){
        System.out.println(pq.remove());
    }

 }
}
