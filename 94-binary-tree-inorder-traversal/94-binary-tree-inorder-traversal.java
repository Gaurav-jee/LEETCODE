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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        
        TreeNode temp = root;
        //Morris Traversal Code
        while(temp != null){
            if(temp.left != null){
                TreeNode iop = temp.left;
                while(iop.right != null && iop.right != temp){
                    iop = iop.right;
                }
                if(iop.right == null){ //if right child is null create the thread and call left child.
                    iop.right = temp;
                    temp = temp.left;
                }else{ // if right child is not null, break the thread, add the node to result, call the right of curr. 
                    iop.right = null;
                    res.add(temp.val);
                    temp = temp.right;
                }
            }else{
                res.add(temp.val);
                temp = temp.right;
            }
        }
        return res;
    }
}