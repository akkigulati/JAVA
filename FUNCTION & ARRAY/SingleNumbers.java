/*
Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/

class Solution {
    public int singleNumber(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        Arrays.sort(nums);
        if(nums[0]!=nums[1]){
            return nums[0];
        }
        else if(nums[nums.length-2]!=nums[nums.length-1]){
            return nums[nums.length-1];
        }
        int ans=0;
        for(int i=1;i<nums.length;i++){
             if(nums[i]!=nums[i-1]&&nums[i]!=nums[i+1]){
                 ans=nums[i];
                 break;
             }   
        }
        return ans;
    }
}
