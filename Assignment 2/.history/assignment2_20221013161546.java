import java.util.*;
import java.io.*;

 
// An Undirected graph using
// adjacency list representation
public class assignment2 {
 
    private int vertices; // No. of vertices
    private ArrayList<Integer>[] adj; // adjacency list
 
    // Constructor
    Graph(int numOfVertices)
    {
        // initialise vertex count
        this.vertices = numOfVertices;
 
        // initialise adjacency list
        initGraph();
    }
 
    // utility method to initialise adjacency list
    @SuppressWarnings("unchecked") private void initGraph()
    {
        adj = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            adj[i] = new ArrayList<>();
        }
    }
 
    // add edge u-v
    private void addEdge(Integer u, Integer v)
    {
        adj[u].add(v);
        adj[v].add(u);
    }
 
    // This function removes edge u-v from graph.
    private void removeEdge(Integer u, Integer v)
    {
        adj[u].remove(v);
        adj[v].remove(u);
    }
 
    // Print Euler tour starting from vertex u
    private void printEulerUtil(Integer startIndex)
    {
        // Recur for all the vertices adjacent to this
        // vertex
        for (int i = 0; i < adj[startIndex].size(); i++) {
            Integer v = adj[startIndex].get(i);
            // If edge u-v is a valid next edge
            if (isValidNextEdge(startIndex, v)) {
                System.out.print(startIndex + "-" + v + " ");
 
                // This edge is used so remove it now
                removeEdge(startIndex, v);
                printEulerUtil(v);
            }
        }
    }
 
    // The function to check if edge u-v can be
    // considered as next edge in Euler Tout
    private boolean isValidNextEdge(Integer u, Integer v)
    {
        // The edge u-v is valid in one of the
        // following two cases:
 
        // 1) If v is the only adjacent vertex of u
        // ie size of adjacent vertex list is 1
        if (adj[u].size() == 1) {
            return true;
        }
 
        // 2) If there are multiple adjacents, then
        // u-v is not a bridge Do following steps
        // to check if u-v is a bridge
        // 2.a) count of vertices reachable from u
        boolean[] isVisited = new boolean[this.vertices];
        int count1 = dfsCount(u, isVisited);
 
        // 2.b) Remove edge (u, v) and after removing
        //  the edge, count vertices reachable from u
        removeEdge(u, v);
        isVisited = new boolean[this.vertices];
        int count2 = dfsCount(u, isVisited);
 
        // 2.c) Add the edge back to the graph
        addEdge(u, v);
        return (count1 > count2) ? false : true;
    }
 
    // A DFS based function to count reachable
    // vertices from v
    private int dfsCount(Integer v, boolean[] isVisited)
    {
        // Mark the current node as visited
        isVisited[v] = true;
        int count = 1;
        // Recur for all vertices adjacent to this vertex
        for (int adj : adj[v]) {
            if (!isVisited[adj]) {
                count = count + dfsCount(adj, isVisited);
            }
        }
        return count;
    }

    public static void Fleury(int[][] A, int startVertex) 
    {
          int n = 100;

          Graph newGraph = new Graph(n);

          for (int i = 0; i < n; i++) 
          {
              for (int j = 0; j < n; j++) 
              {
                  if(A[i][j] == 1) 
                  {
                      newGraph.addEdge(i, j);
                  }
              }
          }
          
          newGraph.printEulerUtil(44);
    }
 
    // Driver program to test above function
    public static void main(String args[])
    {
         // Try to read file, throw exception if not possible. 
         try 
         {
 
             // Read file.
             File dataFile = new File("C:/Users/wanye/source/Network-Optimization/Assignment 2/assignment2_data.txt");
             Scanner dataFileInput = new Scanner(dataFile);  
             Scanner sc = new Scanner(System.in);
             
             
             // Declare/Initialize matrix 'A' and helpers.
             int n = 100;
             int[][] matrix = new int[n][n];
             List<String> line = new ArrayList<String>();
             
             //Populate n x n matrix. 
             for(int i = 0; i < n; i++) {
                 if(dataFileInput.hasNext()) {
                     line.add(dataFileInput.next());
                     StringTokenizer tokenizer = new StringTokenizer(line.get(0), ",");
                     for(int k = 0; tokenizer.hasMoreTokens(); k++) {
                         matrix[i][k] = Integer.parseInt(tokenizer.nextToken());
                     }
                 }
                 line = new ArrayList<>(); // Clear to prepare for next row in the matrix.   
             }
 
             // User input used as starting/ending vertex for Euler circuit (e.g PID: 4867444 --> Starting/Ending vertex": 44)
             int startVertex = sc.nextInt();
             Fleury(matrix, startVertex);
 
 
             // Close scanners 
             dataFileInput.close();
             sc.close();

 
         // Handle I/O exceptions
         } catch (IOException e) {
             e.printStackTrace();
         }

      
    }
}

public class Graph 
{

}