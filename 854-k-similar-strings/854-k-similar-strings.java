class Solution {  
    public int kSimilarity(String s1, String s2) {
        HashSet<String> vis = new HashSet<>();
        ArrayDeque<String> queue = new ArrayDeque<>();
        
        queue.add(s1);
        int level = 0;
        
        while(queue.size() > 0){
            int sz = queue.size();
            for(int i=0; i< sz; ++i){
                //remove
                String rem = queue.remove();
                //mark*
                if(vis.contains(rem)){
                    continue;
                }
                vis.add(rem);
                //work
                if(rem.equals(s2)){
                    return level;
                }
                //add*
                for(String s : getNeighbors(rem, s2)){
                    if(!vis.contains(s)){
                        queue.add(s);
                    }
                }
            }
            level++;
        }
        return -1;
    }
    
    public ArrayList<String> getNeighbors(String rem, String s2){
        ArrayList<String> res = new ArrayList<>();
            
        int idx = -1;
        for(int i=0; i<rem.length(); ++i){
            if(rem.charAt(i) != s2.charAt(i)){
                idx = i;
                break;
            }
        }
        char ch = s2.charAt(idx);
        
        for(int j= idx + 1; j<rem.length(); ++j){
            if(ch == rem.charAt(j)){
                res.add(swap(rem, idx, j));
            }    
        }
        return res;
    }
    
    public String swap(String s, int i, int j){
        StringBuilder sb = new StringBuilder(s);
        char chi = s.charAt(i);
        char chj = s.charAt(j);
        
        sb.setCharAt(i, chj);
        sb.setCharAt(j, chi);
        
        return sb.toString();
    }
    
}