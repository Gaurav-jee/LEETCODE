class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];
        
        for(int i=0;i<graph.length; ++i){
            if(visited[i] == 0){
                boolean isBip = traverse(graph, visited, i);
                if(isBip == false){
                    return false;
                }
            }
        }
        return true;
        
    }
    
    class Pair{
        int v;
        int color;
        
        Pair(int v, int color){
            this.v = v;
            this.color = color;
        }
    }
    
    
    public boolean traverse(int[][] graph, int[] visited, int v){
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        
        queue.add(new Pair(v, 1));    
    
        while(queue.size() > 0){
            //rm*wa*
            
            Pair rem = queue.remove();
            
            if(visited[rem.v] != 0){
                int oc = visited[rem.v];
                int nc = rem.color;
                
                if(oc == nc){
                    continue;
                }else{
                    return false;
                }
            }
            
            
            visited[rem.v] = rem.color;
            
            
            for(int nbr:graph[rem.v]){
                if(visited[nbr] == 0){
                    queue.add(new Pair(nbr, rem.color * -1));
                }               
            }
            
        }
        return true;
    }
}