class Solution {
    int[][] memo;
    int n;
    int m;
    int[][] dir = {{0,-1}, {0, 1}, {-1, 0}, {1, 0}};
    
    public int longestIncreasingPath(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;
        memo = new int[n][m];
        int max = 0;
       
        
        for(int i=0; i<matrix.length; ++i){
            for(int j=0; j<matrix[0].length; ++j){
                max = Math.max(max, dfs(matrix, memo, i, j));
            }
        }
        
        return max - 1;
    }
    
    public int dfs(int[][] matrix, int[][] memo, int i, int j){
        if(memo[i][j] != 0){
            return memo[i][j];
        }      
        int max = 1;
        int curr_val = matrix[i][j];
        
        for(int[] d : dir){
            int call_max = 0;
            int x = i + d[0];
            int y = j + d[1];
            if(isValid(x, y, matrix) && curr_val < matrix[x][y]){
                call_max = dfs(matrix, memo, x, y);
            }
            max = Math.max(max, call_max);
        }
        
        memo[i][j] = 1 + max;
        return 1 + max;
    }
    
    public boolean isValid(int i, int j, int[][] matrix){
        if(i<0 || j < 0 || i>= matrix.length || j>= matrix[0].length){
            return false;
        }
        return true;
    }
 
                    
}