/*
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max=0;
        // int sub="";
       ArrayList<Character> ai=new ArrayList<>();
        int i=0,j=0;
        while(i<s.length()&&j<s.length()){
            if(!ai.contains(s.charAt(j))){
                ai.add(s.charAt(j));
                j++;
                max=Math.max(max,j-i);
            }else{
                ai.remove(new Character(s.charAt(i)));
                i++;
            }
        }
        return max;
    }
}
