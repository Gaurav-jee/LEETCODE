class Solution {
    int[] parent;
    int[] rank;
        
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int v;
        int u;
        int xl;
        int yl;
        int count = n;
        
        parent = new int[n];
        rank = new int[n];
        
        for(int i=0;i<n; ++i){
            parent[i] = i;
            rank[i] = 0;
        }
            
        for(int i=0;i<n; ++i){
            for(int j=0; j<n; ++j){
                if(i != j && isConnected[i][j] == 1){
                    u = find(i);
                    v = find(j);
                    
                    if(u != v){
                        count--;
                        union(v, u);
                    }
                }
            }
        }
        
        
       
        return count;
    }
    
    public int find(int x){
        if(parent[x] == x){
            return x;
        }
        else { // path compression
            int temp = find(parent[x]);
            parent[x] = temp;
            return parent[x];
        }
    }
    
    public void union(int xl, int yl){
            if(rank[xl] > rank[yl]){
                parent[yl] = xl;
            }else if (rank[yl] > rank[xl]){
                parent[xl] = yl;
            }else{
                parent[xl] = yl;
                rank[yl]++;
            }
    }
}