// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        
        //DFS and store in Stack in PostOrder
        //Transpose the Graph
        //pop stack, DFS the transposed Graph and keep printing 
        
        boolean[] visited = new boolean[V];
        Stack<Integer> st = new Stack<>();
        
        
        //Step I. building the stack
        for(int i=0;i<V; ++i){
            if(!visited[i]){
                dfs(adj, i, visited, st);
            }
        }
        
        //Step II transpose of the Graph
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<ArrayList<Integer>>();
        
        for(int i =0; i<V; ++i){
            transpose.add(new ArrayList<Integer>()); 
        }
        
        for(int i=0; i<V; ++i){
            for(int v : adj.get(i)){
                transpose.get(v).add(i);
            }
        }
        
        
        int count = 0;
        Arrays.fill(visited, false);
        while(st.size() > 0){
            int u = st.peek();
            st.pop();
            
            if(!visited[u]){
                count++;
                dfs2(u, transpose, visited);
            }
        }
    
        return count;
    }
    
    
    public void dfs(ArrayList<ArrayList<Integer>> adj, int v, boolean[] visited, Stack<Integer> st){
        visited[v] = true;
        
        for(int nbr : adj.get(v)){
            if(!visited[nbr]){
                dfs(adj, nbr, visited, st);
            }
        }
        
        st.push(v);
    }
    
    public void dfs2(int u, ArrayList<ArrayList<Integer>> transpose, boolean[] visited){
        visited[u] = true;
        
        for(int v : transpose.get(u)){
            if(!visited[v]){
                dfs2(v, transpose, visited);    
            }
            
        }
    }
    
}
