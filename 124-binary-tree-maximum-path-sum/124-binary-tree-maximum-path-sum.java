class Solution {
    public int maxPathSum(TreeNode root) {
        sum = Integer.MIN_VALUE;
        ntnHelper(root);
        return sum;
    }
    int sum =0;
    int ntnHelper(TreeNode node){
        if(node==null)
            return Integer.MIN_VALUE;
        
        int left = ntnHelper(node.left);
        int right = ntnHelper(node.right);
        sum = Math.max(sum, Math.max(left, right));

        int takeLeft = (left!=Integer.MIN_VALUE?left:0) +node.val;
        int takeRight = (right!=Integer.MIN_VALUE?right:0)+node.val;
        int takeAll = takeLeft+takeRight-node.val;
        sum = Math.max(sum, Math.max(node.val, Math.max(sum, Math.max(Math.max(takeLeft, takeRight), takeAll))) );
        return Math.max(node.val,Math.max(takeLeft, takeRight));

    }
}