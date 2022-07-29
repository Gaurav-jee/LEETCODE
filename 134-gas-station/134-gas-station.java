class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int osum = 0;
        int csum = 0;
        int si = 0;
        
        for(int i=0; i<cost.length; ++i){
            osum += (gas[i] - cost[i]);
            csum += (gas[i] - cost[i]);
            
            if(csum < 0){
                csum = 0;
                si = i + 1;
            }
        }
        
        if(osum >= 0){
            return si;
        }else 
            return -1;
    }
}