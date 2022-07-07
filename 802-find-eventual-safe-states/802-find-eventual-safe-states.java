class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        
        visited = new int[graph.length];
        for(int i=0; i<graph.length; ++i){
            boolean flag = dfs(i, graph);
            if(flag == true){
                res.add(i);
            }
        }
        
        return res; 
    }
    int[] visited;
    
    public boolean dfs(int src, int[][] graph){
        if(visited[src] == 2){
            return true;
        } else if(visited[src] == 1){
            return false;
        } else{
            visited[src] = 1;
            
            for(int nbr : graph[src]){
                boolean isNbrSafe = dfs(nbr, graph);
                if(isNbrSafe == false){
                    return false;
                }
            }
            
            visited[src] = 2;
            return true;
        }
        
    }
}