// { Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}// } Driver Code Ends


class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    static int[] JobScheduling(Job arr[], int n){
        // Your code here
        Arrays.sort(arr ,(a,b)->{
            return b.profit-a.profit;
        });
        parent = new int[101];
        for(int i=0; i<parent.length; i++){
            parent[i]=i;
        }
        int ans=0;
        int count = 0;
        for(Job job: arr){
            int lx = find(job.deadline);
            if(lx>0){
                count++;
                ans+=job.profit;
                parent[lx] = find(lx-1); 
            }
        }
        
        int ret[] ={count, ans};
        return ret;
    }
    static int parent[];
    static int find(int x){
        if(parent[x]==x){
            return x;
        }else{
            int temp = find(parent[x]);
            parent[x] = temp;
            return temp;
        }
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/