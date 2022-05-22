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
    public void recoverTree(TreeNode root) {
        TreeNode temp = root;
        TreeNode a= null, b = null, prev = null;
        
        //ArrayList<Integer> ans = new ArrayList<>();
        while(temp != null){
            if(temp.left != null){
                TreeNode iop = temp.left;
                while(iop.right != null && iop.right != temp){
                    iop = iop.right;
                }
                
                if(iop.right == null){
                    //ans.add(temp.val);
                    iop.right = temp;
                    temp = temp.left;
                }else{
                    if(prev.val > temp.val){
                        if(a == null){
                            a = prev;
                        }
                        b = temp;
                    }
                    prev = temp;
                    iop.right = null;
                    temp = temp.right;
                }
                    
            }else{
                if(prev != null && prev.val > temp.val){
                    if(a == null){
                        a = prev;
                    }
                    b = temp;
                }
                prev = temp;
                //ans.add(temp.val);
                temp = temp.right;
            }
        }
        if(a != null){
            int t = a.val;
            a.val = b.val;
            b.val = t;
        }
        //System.out.print(ans);
    }
}