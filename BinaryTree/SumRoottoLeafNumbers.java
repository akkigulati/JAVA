/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.

Example:

Input: [1,2,3]
    1
   / \
  2   3
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.
Example 2:

Input: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.
*/
class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        int[] res = new int[]{0};
        dfs(root, res, 0);
        return res[0];
    }
    
    private void dfs(TreeNode root, int[] res, int cur){
        if (root == null) return;
        if (root.left == null && root.right == null){
            res[0] += cur * 10 + root.val;
            return;
        }
        dfs(root.left, res, 10 * cur + root.val);
        dfs(root.right, res, 10 * cur + root.val);
    }
}
////////////////////////////////////////////
class Solution {
    
    public int sumNumbers(TreeNode root) {
        ArrayList<String> ans=new ArrayList<>();
        rootToLeaf(root,"",ans);
        int sum=0;
        for(String s:ans){
            sum+=Integer.valueOf(s);
        }
        return sum;
    }
    public static void  rootToLeaf(TreeNode node,String asf,ArrayList<String> ans){
        if(node==null){
            return;
        }
        if(node.left==null&node.right==null){
            asf=asf+node.val;
            ans.add(asf);
            return;
        }
        
        rootToLeaf(node.left,asf+node.val,ans);
        rootToLeaf(node.right,asf+node.val,ans);
    }
}
