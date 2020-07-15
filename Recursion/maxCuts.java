/*Max Cuts of a rod */
import java.util.*;

public class Main{

public static void main(String[] args) {

int length=44;
int a=11;
int b=12;
int c=13;

System.out.println(MaxCuts(length,a,b,c));

 }
 static public int MaxCuts(int len,int a,int b,int c){
     if(len<0){
         return -1;
     }
     if(len==0){
         return 0;
     }
     
     int res=Math.max(MaxCuts(len-a,a,b,c),Math.max(MaxCuts(len-b,a,b,c),MaxCuts(len-c,a,b,c)));
     if(res!=-1){
         return res+1;
     }else{
         return -1;
     }
 }
}
