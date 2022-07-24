class Solution {
    HashMap<String, PriorityQueue<String>> adj;
    
    public List<String> findItinerary(List<List<String>> tickets) {
        adj = new HashMap<>();
        for(List<String> ticket : tickets){
            //System.out.println(s);
            String src = ticket.get(0);
            String dest = ticket.get(1);
            
            if(adj.containsKey(src)){
                adj.get(src).add(dest);
            }else{
                adj.put(src, new PriorityQueue<>());
                adj.get(src).add(dest);
            }
        }
        
        ArrayList<String> res = new ArrayList<>();
        dfs("JFK", res);
        return res;
    }
    
    public void dfs(String v, ArrayList<String> res){
        if(adj.containsKey(v) == false || adj.get(v).size() == 0){
            res.add(0, v);
            return;
        }
        
        while(adj.get(v).size() > 0){
            String nbr = adj.get(v).remove();
            dfs(nbr, res);
        }
        
        res.add(0, v);
    }
}