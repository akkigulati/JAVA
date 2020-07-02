/*
Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.

Examples:
Input: S = "a1b2"
Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

Input: S = "3z4"
Output: ["3z4", "3Z4"]

Input: S = "12345"
Output: ["12345"]
Note:

S will be a string with length between 1 and 12.
S will consist only of letters or digits.
*/
class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> ans=new ArrayList<>();
        perm(S,ans,"");
        return ans;
  
    }
   public static void perm(String str,List<String> ans,String ssf){
        if(str.length()==0){
            ans.add(ssf);
            return;
        }
        char ch=str.charAt(0);
        str=str.substring(1);
        if((ch>=65&&ch<=90)||(ch>=97&&ch<=122)){
            if(ch>=65&&ch<=90){
              perm(str,ans,ssf+ch);
                ch=Character.toLowerCase(ch);
                perm(str,ans,ssf+ch);
            }else{
               perm(str,ans,ssf+ch);
                ch=Character.toUpperCase(ch);
                perm(str,ans,ssf+ch); 
            }
            
        }else{
            perm(str,ans,ssf+ch); 
        }     
    }
}
