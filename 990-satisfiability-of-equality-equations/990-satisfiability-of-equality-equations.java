class Solution {
    static int parent[];
    static int rank[];
    public static boolean equationsPossible(String[] equations) {

        parent = new int[26];
        rank = new int[26];
        for(int i=0; i<26; i++){
            parent[i] = i;
            rank[i]=0;
        }
        for(String eq: equations){
            if(eq.charAt(1)=='='){
                int c1 = eq.charAt(0) - 'a';
                int c2 = eq.charAt(3) - 'a';
                int lx = find(c1);
                int ly = find(c2);

                if(lx!=ly){
                    union(lx, ly);
                }
            }
        }
        for(String eq: equations){
            if(eq.charAt(1)=='!'){
                int c1 = eq.charAt(0) - 'a';
                int c2 = eq.charAt(3) - 'a';
                int lx = find(c1);
                int ly = find(c2);

                if(lx==ly){
                    return false;
                }
            }
        }
        return true;
    }

    static int find(int x){
        if(parent[x]==x){
            return x;
        }else{
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
    static void union(int x, int y){
        if(rank[x]>rank[y]){
            parent[y] = x;
        }else if(rank[x] < rank[y]){
            parent[x] = y;
        }else{
            parent[y] = x;
            rank[x]++;
        }
    }
}