//1. You've to count the number of digits in a number.
  //2. Take as input "n", the number for which the //digits has to be counted.
 // 3. Print the digits in that number.
import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
    // write your code here  
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int count=0;
    while(n!=0)
    {
        count++;
        n=n/10;
    }
      System.out.println(count);
  }
  }