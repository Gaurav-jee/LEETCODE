class Solution {
    class Pair implements Comparable<Pair>{
        int i;
        int j;
        int wt;
        Pair(int i, int j, int wt){
            this.i = i;
            this.j = j;
            this.wt = wt;
        }
        
        public int compareTo(Pair o){
            return this.wt - o.wt;
        }
    }
    
    public int swimInWater(int[][] grid) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        pq.add(new Pair(0, 0, grid[0][0]));
                
        while(pq.size() > 0){
            Pair rem = pq.remove();
            
            if(visited[rem.i][rem.j] == true){
                continue;
            }
            visited[rem.i][rem.j] = true;
            
            if(rem.i == grid.length-1 && rem.j == grid[0].length-1){
                return rem.wt;
            }
            
            addN(rem.i + 1, rem.j, rem.wt, visited, grid, pq);
            addN(rem.i - 1, rem.j, rem.wt, visited, grid, pq);
            addN(rem.i, rem.j + 1, rem.wt, visited, grid, pq);
            addN(rem.i, rem.j - 1, rem.wt, visited, grid, pq);
            
        }
        
        return -1;
    }
    
    
    public void addN(int i, int j, int wt, boolean[][] visited, int[][] grid, PriorityQueue<Pair> pq){
        if(i<0 || j<0 || i>= grid.length || j>= grid[0].length || visited[i][j] == true){
            return;
        }
        
        pq.add(new Pair(i, j, Math.max(wt, grid[i][j])));
    }
}