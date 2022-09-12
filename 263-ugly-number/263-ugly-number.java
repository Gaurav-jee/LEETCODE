class Solution {
    public boolean isUgly(int n) {
        int[] arr = {2,3,5};
        for(int i = 0; i<arr.length; i++){
            while(n>=arr[i] && n%arr[i]==0){
                n /= arr[i];
            }
        }
        return n==1;
    }
}