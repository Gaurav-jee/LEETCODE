class Solution {
    long MOD = 1000000007;
    
    public int sumSubseqWidths(int[] nums) {
        Arrays.sort(nums);
        
        long ans = 0;
        long p = 1;
        
        int j = nums.length - 1;
        for(int i=0; i<nums.length; ++i){
            ans = (ans + p * nums[i] - p * nums[j]) % MOD;
            p = (p * 2)%MOD;
            j--;
        }
        
        return (int)ans;
    }
}