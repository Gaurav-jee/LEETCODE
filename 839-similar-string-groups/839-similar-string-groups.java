class Solution {
    public int numSimilarGroups(String[] strs) {
        
        int n = strs.length;
        
        parent = new int [n];
        rank = new int [n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        
        for (int i = 0; i < strs.length - 1; i++) {
            for (int j = 1; j < strs.length; j++) {
                if (similar(strs[i], strs[j])) {
                    union(i, j);
                }
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int root = find(i);
            set.add(root);
        }
        return set.size();
    }
    
     public boolean similar(String s1, String s2) {
        int i = 0;
        int n = s1.length();
        int swap = 0;
        while (i < n && swap <= 2) {
            if (s1.charAt(i) != s2.charAt(i)) {
                swap++;
            }
            i++;
        }
    
         if(swap == 0 || swap == 2){
             return true;
         }else return false;
    }
    
    int[] parent;
    int[] rank;
    
    int find(int x){
        if(parent[x] == x){
            return x;
        }else{
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
    
    void union(int x, int y){
        int xl = find(x);
        int yl = find(y);
        
        if(rank[xl] < rank[yl]){
            parent[xl] = yl;
            rank[yl]++;
        }else{
            parent[yl] = xl;
            rank[xl]++;
        }
    }
}