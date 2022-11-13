#User function Template for python3
def swap(arr, i, e):
    temp = arr[i]
    arr[i] = arr[e]
    arr[e] = temp

def reverse(arr, start, end):
    
    while(start < end):
        swap(arr, start, end)
        start += 1
        end -= 1

def rotate( arr, n):
    k = 1
    reverse(arr, 0, n-k-1)
    reverse(arr, n-k, n-1)
    reverse(arr, 0, n-1)
    
    
    



#{ 
 # Driver Code Starts
#Initial Template for Python 3

def main():

    T = int(input())

    while(T > 0):
        n = int(input())
        a = [int(x) for x in input().strip().split()]
        rotate(a, n)
        print(*a)

        T -= 1


if __name__ == "__main__":
    main()





    
# } Driver Code Ends