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
    static int res; 
    
    public int longestUnivaluePath(TreeNode root) {
        res = 0;
        helper(root, -1);
        if(res > 0){
            res = res -1;
        }
        return res;
    }
    
    public static int helper(TreeNode root, int val){
        
        if(root == null){
            return 0;
        }
        
        int lx = helper(root.left, root.val);
        int rx = helper(root.right, root.val);
        
        if(lx + rx + 1 > res){
            res = lx + rx + 1;
        }
        
        if(root.val == val){
            return Math.max(lx, rx) + 1;
        }else{
            return 0;
        }
        
    }
}