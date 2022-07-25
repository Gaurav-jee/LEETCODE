class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i<s.length(); ++i){
            char ch = s.charAt(i);
            map.put(ch, i);
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        int start = 0;
        int end = 0;
        
        for(int i=0; i<s.length(); ++i){
            char ch = s.charAt(i);
            end = Math.max(end, map.get(ch));
            
            if(end == i){
                res.add(end - start + 1);
                end = start = i + 1;
            }
        }
        
        return res;
    }
}