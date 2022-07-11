class Solution {
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        parent = new int[n+1];
        size = new int[n+1];
        for(int i=0;i<parent.length;i++){
            parent[i]=i;
        }
        for(int div=threshold+1; div<=n; div++){
            for(int m=1; m*div<=n; m++){
                unionHelper(div, m*div);
            }
        }
        ArrayList<Boolean> al = new ArrayList<>();
        for(int q[]: queries){
            int lx = find(q[0]);
            int ly = find(q[1]);
            al.add(lx==ly);
        }
        return al;
    }

    int[] parent;
    int[] size;
    int find(int x){
        if(parent[x] == x){
            return x;
        } else {
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
    void unionHelper(int x, int y){
        int xl = find(x);
        int yl = find(y);
        
        if(size[xl] < size[yl]){
            parent[xl] = yl;
            size[yl] += size[xl];
        } else {
            parent[yl] = xl;
            size[xl] += size[yl];
        }
    }
}