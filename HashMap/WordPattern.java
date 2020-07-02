/*
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Example 1:

Input: pattern = "abba", str = "dog cat cat dog"
Output: true
Example 2:

Input:pattern = "abba", str = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false
Example 4:

Input: pattern = "abba", str = "dog dog dog dog"
Output: false
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters that may be separated by a single space.
*/
class Solution {
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character,String> ht=new HashMap<>();
        String values[]=str.split(" ");
       if(pattern.length()!=values.length){
           return false;
       }
        for(int i=0;i<pattern.length();i++){
            char ch=pattern.charAt(i);
            if(ht.containsKey(ch)){
                 // System.out.println(values[i]+" "+ch+"if");
                String val=ht.get(ch);
                if(val.equals(values[i])==false){
                    return false;
                }
            }else if(ht.containsValue(values[i])){
                // System.out.println(values[i]+" "+ch);
                return false;
                
            }else{
                 // System.out.println(values[i]+" "+ch+" else");
                ht.put(ch,values[i]);
            }
        }
        return true;
    }
}
