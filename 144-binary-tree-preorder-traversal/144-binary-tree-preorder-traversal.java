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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        
        TreeNode temp = root;
        
        while(temp != null){
            if(temp.left != null){
                TreeNode iop = temp.left;
                
                while(iop.right != null && iop.right != temp){
                    iop = iop.right;
                }
                
                if(iop.right == null){
                    res.add(temp.val);
                    iop.right = temp;
                    temp = temp.left;
                }else{
                    iop.right = null;
                    temp= temp.right;
                }
            }else{
                res.add(temp.val);
                temp = temp.right;
            }
        }
        return res;
    }
}