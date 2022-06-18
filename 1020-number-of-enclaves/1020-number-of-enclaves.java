class Solution {
    int len = 0;
    boolean flag = true;
    
    public int numEnclaves(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        
        for(int i=0; i<grid.length; ++i){
            for(int j=0; j<grid[0].length; ++j){
                if(visited[i][j] == false && grid[i][j] == 1){
                    len = 0;
                    flag = true;
                    traverse(grid, i , j, visited);
                    if(flag == true){
                        count += len;
                    }
                }
            }
        }
        return count;
    }
    
    
    public void traverse(int[][] grid, int i, int j, boolean[][] visited){
        if(i <0 || j <0 || i>= grid.length || j >= grid[0].length){
            flag = false;
            return;
        }else if(grid[i][j] == 0){
            return;
        }else if(visited[i][j] == true){
            return;
        }
        
        len++;
        visited[i][j] = true;
        
        traverse(grid, i+1, j, visited);
        traverse(grid, i-1, j, visited);
        traverse(grid, i, j+1, visited);
        traverse(grid, i, j-1, visited);
        
    }
}