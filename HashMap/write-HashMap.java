/*
Question
  1. You are required to complete the code of our Hashmap class. Please watch the question video carefully. The theoretical details of required functionality is explained in detail there. Implement the functions to achieve what is explained in the theoretical discussion in question video.
2. Input and Output is managed for you.
                               
                               
Input Format
Input is managed for you
Output Format
Output is managed for you
Constraints
None
Sample Input
put India 135
put Pak 80
put China 200
put US 10
put UK 20
put Aus 5
put Canada 3
display
get China
remove Aus
get Aus
containsKey US
remove US
containsKey US
put Utopia 0
put Nigeria 3
put India 138
put Sweden 1
display
put finland 20
display
quit
Sample Output
Display Begins
Bucket0 .
Bucket1 .
Bucket2 Pak@80 US@10 UK@20 Canada@3 .
Bucket3 India@135 China@200 Aus@5 .
Display Ends
200
5
null
true
10
false
Display Begins
Bucket0 Utopia@0 Sweden@1 .
Bucket1 .
Bucket2 Pak@80 UK@20 Canada@3 .
Bucket3 India@138 China@200 Nigeria@3 .
Display Ends
Display Begins
Bucket0 Utopia@0 .
Bucket1 .
Bucket2 Pak@80 finland@20 .
Bucket3 .
Bucket4 Sweden@1 .
Bucket5 .
Bucket6 UK@20 Canada@3 .
Bucket7 India@138 China@200 Nigeria@3 .
Display Ends
*/
import java.io.*;
import java.util.*;

public class Main {

  public static class HashMap<K, V> {
    private class HMNode {
      K key;
      V value;

      HMNode(K key, V value) {
        this.key = key;
        this.value = value;
      }
    }

    private int size; // n
    private LinkedList<HMNode>[] buckets; // N = buckets.length

    public HashMap() {
      initbuckets(4);
      size = 0;
    }

    private void initbuckets(int N) {
      buckets = new LinkedList[N];
      for (int bi = 0; bi < buckets.length; bi++) {
        buckets[bi] = new LinkedList<>();
      }
    }
    private int hashFunction(K key){
        return Math.abs(key.hashCode())%buckets.length;
    }
    private int findInBucket(int bi,K key){
        int di=0;
        for(HMNode node:buckets[bi]){
            if(node.key.equals(key)){
                //key found
                return di;
            }
            di++;
        }
        return -1;
    }
    private void rehashing() throws Exception {
       LinkedList<HMNode>[] oldBuckets=buckets;
       //create new bucket
       initbuckets(2*oldBuckets.length);
       size=0;
       //add nodes from oldBucket to new..
       for(LinkedList<HMNode> bucket:oldBuckets){
           for(HMNode node:bucket){
               put(node.key,node.value);
           }
       }
    }
    public void put(K key, V value) throws Exception {
        int bi=hashFunction(key);
        int di=findInBucket(bi,key);
        
        if(di!=-1){
            //key exists--->update
            HMNode node=buckets[bi].get(di);
            node.value=value;
        }else{
            //key doesn't exist--->inset
            HMNode node=new HMNode(key,value);
            buckets[bi].addLast(node);
            size++;
        }
        double lambda=(size*1.0)/buckets.length;
        if(lambda>2.0){
            //maintain no. of elements per bucket ratio..
            rehashing();
        }
    }

    public V get(K key) throws Exception {
       int bi=hashFunction(key);
        int di=findInBucket(bi,key);
        
        if(di!=-1){
            //key exists--->value
            HMNode node=buckets[bi].get(di);
            return node.value;
        }else{
            //key doesn't exist--->null
            return null;
        }
    }

    public boolean containsKey(K key) {
      int bi=hashFunction(key);
        int di=findInBucket(bi,key);
        
        if(di!=-1){
            //key exists--->true
            return true;
        }else{
            //key doesn't exist--->false
            return false;
        }
    }

    public V remove(K key) throws Exception {
      int bi=hashFunction(key);
        int di=findInBucket(bi,key);
        
        if(di!=-1){
            //key exists--->delete
            HMNode node=buckets[bi].remove(di);
            size--;
            return node.value;
        }else{
            //key doesn't exist--->return
            return null;
        }
    }

    public ArrayList<K> keyset() throws Exception {
        ArrayList<K> ans=new ArrayList<>();
         for(LinkedList<HMNode> bucket:buckets){
           for(HMNode node:bucket){
               ans.add(node.key);
           }
       }
       return ans;
    }

    public int size() {
      return size;
    }

    public void display() {
      System.out.println("Display Begins");
      for (int bi = 0; bi < buckets.length; bi++) {
        System.out.print("Bucket" + bi + " ");
        for (HMNode node : buckets[bi]) {
          System.out.print(node.key + "@" + node.value + " ");
        }
        System.out.println(".");
      }
      System.out.println("Display Ends");
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    HashMap<String, Integer> map = new HashMap();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("put")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        Integer val = Integer.parseInt(parts[2]);
        map.put(key, val);
      } else if (str.startsWith("get")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.get(key));
      } else if (str.startsWith("containsKey")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.containsKey(key));
      } else if (str.startsWith("remove")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.remove(key));
      } else if (str.startsWith("size")) {
        System.out.println(map.size());
      } else if (str.startsWith("keyset")) {
        System.out.println(map.keyset());
      } else if (str.startsWith("display")) {
        map.display();
      }
      str = br.readLine();
    }
  }
}
