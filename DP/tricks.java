/*min days to complete n items.either produces 1 extra on previous day or double on previous day..*/
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t = sc.nextInt();
        int n=  sc.nextInt();
        int arr[]=new int[n+1];
        arr[0]=0;
        arr[1]=0;
        
        for(int i=2;i<=n;i++){

            if(i%2==0){
                
                arr[i]=Math.min(arr[i-1],arr[i/2])+1;
                
            }else{
                
                arr[i]=arr[i-1]+1;
                
            }
            
        }
        System.out.println(arr[n]);
    }
}
