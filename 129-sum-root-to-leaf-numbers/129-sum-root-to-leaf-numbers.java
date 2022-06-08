/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int sum = 0;
    
    public void helper(TreeNode root, String str){
        if(root == null){
            return;
        }
        
        //on a leaf node
        if(root.left == null && root.right == null){
            sum += Integer.parseInt(str + root.val);
        }
        
        helper(root.left, str + root.val);
        helper(root.right, str + root.val);  
       
    }
    
    public int sumNumbers(TreeNode root) {
        sum = 0;
        helper(root, "");
        return sum;
    }
}