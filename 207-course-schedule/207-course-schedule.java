class Solution {
    HashMap<Integer, ArrayList<Integer>> adj;
    boolean isCycle;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adj = new HashMap<>();
        
        for(int i=0; i<prerequisites.length; ++i){
            int v = prerequisites[i][0];
            int u = prerequisites[i][1];
            
            if(adj.containsKey(v) == false){
                adj.put(v , new ArrayList<>());
                adj.get(v).add(u);
            }else{
                adj.get(v).add(u);
            }
            
        }
        isCycle = false;
        
        boolean[] vis = new boolean[numCourses];
        boolean[] dfsvis = new boolean[numCourses];
                
        for(int i=0; i<numCourses; ++i){
            if(vis[i] == false){
                dfs(adj, vis, dfsvis, i);
            }
        }
        
        return !isCycle;
    }
    
    public void dfs(HashMap<Integer, ArrayList<Integer>> adj, boolean[] vis, boolean[] dfsvis, int i){
        vis[i] = true;
        dfsvis[i] = true;
        
        if(adj.containsKey(i) == false){
            dfsvis[i] = false;
            return;
        }
        
        for(int nbr : adj.get(i)){
            if(vis[nbr] == true && dfsvis[nbr] == true){
                //is Cycle
                isCycle = true;
            }
            else if(vis[nbr] == false){
                dfs(adj, vis, dfsvis, nbr);
            }
        }
        dfsvis[i] = false;
    }
    
}