class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, List<int[]>> graph = new HashMap<>();
        
        for(int[] time : times){
            int source = time[0];
            int target = time[1];
            int weight = time[2];
            
            if(!graph.containsKey(source)){
                graph.put(source, new ArrayList<>());
            }
            graph.get(source).add(new int[]{target, weight});
               
        }
        
        //minHeap
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        //visited array\
        Set<Integer> visited = new HashSet<Integer>();
        
        int result = 0;
        
        minHeap.add(new int[]{k, 0});
        
        while(!minHeap.isEmpty()){
            //rem
            int[] rem = minHeap.poll();
            int source = rem[0];
            int sourceWeight = rem[1];
            
            //mark
            if(visited.contains(source)) continue;
            visited.add(source);
            
            //work
            result = sourceWeight;            
            //add*
            if(!graph.containsKey(source))continue; // lead nodes
            for(int[] nbr : graph.get(source)){
                int target = nbr[0];
                int targetWeight = nbr[1];
                
                minHeap.add(new int[]{target, sourceWeight + targetWeight});
            }
        }
        
       return visited.size() == n ?  result : -1;
        
    }
}