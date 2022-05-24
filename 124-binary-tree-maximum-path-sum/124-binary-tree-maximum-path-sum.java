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
    int max = Integer.MIN_VALUE;
    
    public int solve(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int left = solve(root.left);
        int right = solve(root.right);
        
        int left_dash = Math.max(0, left);
        int right_dash = Math.max(0, right);
        
        int max_sum_NTN = left_dash + right_dash + root.val;
        
        if(max_sum_NTN > max){
            max = max_sum_NTN;
        }
        
        return Math.max(left_dash, right_dash) + root.val;
    }
    
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        solve(root);
        return max;
    }
}