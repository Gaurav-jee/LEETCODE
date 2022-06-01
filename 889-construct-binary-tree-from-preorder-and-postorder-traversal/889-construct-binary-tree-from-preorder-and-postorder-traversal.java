class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        if(preorder.length == 1 && postorder.length==1)
            return new TreeNode(preorder[0]);
            
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<postorder.length;i++){
            map.put(postorder[i],i);
        }
        return help(preorder,0,preorder.length-1,postorder,0,postorder.length-1,map);
    }
  
    private TreeNode help(int [] preorder,int pre_start,int pre_end,int [] postorder,int post_start,int post_end,HashMap<Integer,Integer> map){
        if(pre_start>pre_end || post_start>post_end)
            return null;
        TreeNode root = new TreeNode(preorder[pre_start]);
        if(pre_start+1<=pre_end){

        int diff = map.get(preorder[pre_start+1])-post_start;
            root.left=help(preorder,pre_start+1,pre_start+1+diff,postorder,post_start,post_start+diff,map);
            root.right = help(preorder,pre_start+1+diff+1,pre_end,postorder,post_start+diff+1,post_end-1,map);
        
        }
        return root;
    }
    
}