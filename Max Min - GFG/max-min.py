class Solution:
    def findSum(self,A,N): 
        #code here
        min_ = 0;
        max_ = 0;
        
        for i in A:
            min_ = min(min_ , i);
            max_ = max(max_ , i);
            
        return min_ + max_    
            



#{ 
 # Driver Code Starts
#Initial Template for Python 3



t=int(input())
for _ in range(0,t):
    n=int(input())
    a=list(map(int,input().split()))
    ob = Solution()
    print(ob.findSum(a,n))
# } Driver Code Ends