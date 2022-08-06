class Solution {
    HashMap<Integer, ArrayList<Integer>> adj;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination){
            return true;
        }
        adj = new HashMap<>();
        
        for(int[] e: edges){
            int v = e[0];
            int u = e[1];
            
            if(!adj.containsKey(v)){
                adj.put(v, new ArrayList<>());
                adj.get(v).add(u);
            }else{
                adj.get(v).add(u);
            }
            
            if(!adj.containsKey(u)){
                adj.put(u, new ArrayList<>());
                adj.get(u).add(v);
            }else{
                adj.get(u).add(v);
            }
                        
        }
        
        boolean[] visited = new boolean[n];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        
        queue.add(source);
        
        while(queue.size() > 0){
            
            int rem = queue.remove();
            System.out.println("rem->" + rem);
            
            for(int nbr : adj.get(rem)){
            System.out.println("nbr->" + nbr);
            if(visited[nbr]== true){
                continue;
            }
            visited[nbr] = true;
            
            if(nbr == destination){
                return true;
            }
            
            queue.add(nbr);
            }
        }
        
        return false;
    }
}