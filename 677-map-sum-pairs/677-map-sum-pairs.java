class MapSum {
    MapSum[] child;
    int value;

    public MapSum() {
        child=new MapSum[26];
    }

    public void insert(String key, int val) {
        MapSum trie=this;
        for(int i=0;i<key.length();i++){
            if(trie.child[key.charAt(i)-'a']==null){
                trie.child[key.charAt(i)-'a']=new MapSum();
            }
            trie=trie.child[key.charAt(i)-'a'];
             if(i==key.length()-1){
                trie.value=val;
                return;
            }
        }
    }

    public int sum(String prefix) {
        MapSum trie=this;
        for(int i=0;i<prefix.length();i++){
            if(trie.child[prefix.charAt(i)-'a']==null){
                return 0;
            }
           trie=trie.child[prefix.charAt(i)-'a']; 
        }
        return sum(trie);
    }
    public int sum(MapSum trie){
        int res=0;
        res+=trie.value;
        for(MapSum m: trie.child){
           if(m!=null){
               res+=sum(m);
           }
        }
        return res;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */