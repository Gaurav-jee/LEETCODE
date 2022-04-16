class Solution {
    public int numIslands(char[][] grid) {
        
        int count=0;
        for(int i=0; i<grid.length; ++i){
            for(int j=0; j<grid[i].length; ++j){
                if(grid[i][j] == '1'){
                    count++;
                }
                
                dfs(grid, i, j);                
            }
        }
        return count;
    }
    
    public static void dfs(char[][] grid, int row, int col){
         // checking the boundary conditions and if the current element is 0, then we don't care.
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0')
            return;
        //Marking the adjacent 1 to be 0.So, in future if we visit this element then we should not count this as a separate island.(You can mark it as anything except 1)
        grid[row][col] = '0'; 
        
        dfs(grid,row+1,col); // check for the uppper adjacent element
        dfs(grid,row-1,col); // check for the bottom adjacent element
        dfs(grid,row,col+1); // check for the right adjacent element
        dfs(grid,row,col-1); // check for the left adjacent element
    }
}