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
    public List<Integer> rightSideView(TreeNode root) {
       ArrayList<Integer> ls = new ArrayList<Integer>();
      
      if(root == null){
          return ls;
      }
      
      Queue<TreeNode> q = new LinkedList<>();
      
      q.add(root);
      
      
      while(q.size() > 0){
          
          int lsize = q.size();
          
          for(int i=0;i<lsize; ++i){
              TreeNode temp = q.remove();
              
              if(i ==  lsize-1){
                  ls.add(temp.val);
              }
              
              if(temp.left != null){
                  q.add(temp.left);
              }
          
              if(temp.right != null){
                  q.add(temp.right);
              }
        }
          
      }
      
      
      return ls;
    }
}