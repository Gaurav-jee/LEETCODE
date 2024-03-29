class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
    int min = Integer.MIN_VALUE;
    
    int product = 1;
    
    for (int i=0;i<nums.length;i++){
        product *=nums[i];
        if(product>max){
            max = product;
        }
        if(product==0){
            product = 1;
        }
    }
    product = 1;
    for (int i=nums.length-1;i>=0;i--){
        product *=nums[i];
        if(product>max){
            min = product;
        }
        if(product==0){
            product = 1;
        }
    }
    
    int result = Math.max(max,min);
    return result;
    

    }
}