
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
