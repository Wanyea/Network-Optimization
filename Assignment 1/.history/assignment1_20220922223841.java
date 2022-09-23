import java.util.*;
import java.io.*;

class Graph_Shortest_Path { 
 
}

public class assignment1 
{
    public static void main(String args[]) {

        // Try to read file, throw exception if not possible. 
        try {

            // Read file.
            File dataFile = new File("C:/Users/wanye/source/Network-Optimization/Assignment 1/input/Data.txt");
            Scanner dataFileInput = new Scanner(dataFile);   
            
               
        // Declare/Initialize matrix and helpers.
        int n = 100;
        Vector<Vector<Integer>> matrix = new Vector<Vector<Integer>>();
        List<String> line = new ArrayList<String>();
        Vector<Integer> rows = new Vector<Integer>();
        

        //Populate n x n matrix. 
        for(int i = 0; i < n; i++) {
            if(dataFileInput.hasNext()) {
                line.add(dataFileInput.next());
                StringTokenizer tokenizer = new StringTokenizer(line.get(0), ",");
                for(int k = 0; tokenizer.hasMoreTokens(); k++) {
                     rows.add(Integer.parseInt(tokenizer.nextToken()));
                }

            }

            line = new ArrayList<>();
            //rows = new ArrayList<>();
        }

        
        //System.out.println(Arrays.deepToString(matrix));
        //Run Dijkstra's algoritm on dataset where UCF PID is: 4867444.

        // System.out.println(runDijkstras(matrix, 48, 86)); // {48 , 86}
        // System.out.println(runDijkstras(matrix, 86, 7)); // {86, 7}
        // System.out.println(runDijkstras(matrix, 7, 4)); // {7, 4}
        // System.out.println(runDijkstras(matrix, 4, 44)); // {4, 44}
        // System.out.println(runDijkstras(matrix, 44, 44)); // {44, 44}

        algo_dijkstra(matrix, 48);
       
        // Close scanner 
        dataFileInput.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
     
    }
 
        
    static final int num_Vertices = 100;  //max number of vertices in graph

    // find a vertex with minimum distance
  static  int minDistance(int path_array[], Boolean sptSet[])   { 
        // Initialize min value 
        int min = Integer.MAX_VALUE, min_index = -1; 
        for (int v = 0; v < num_Vertices; v++) 
            if (sptSet[v] == false && path_array[v] <= min) { 
                min = path_array[v]; 
                min_index = v; 
            } 
   
        return min_index; 
    } 
   
    // print the array of distances (path_array)
   static void printMinpath(int path_array[])   { 
        System.out.println("Vertex# \t Minimum Distance from Source"); 
        for (int i = 0; i < num_Vertices; i++) 
            System.out.println(i + " \t\t\t " + path_array[i]); 
    }
    
// Implementation of Dijkstra's algorithm for graph (adjacency matrix) 
    static void algo_dijkstra(int graph[][], int src_node)  { 
        System.out.println(Arrays.deepToString(graph));
        int path_array[] = new int[num_Vertices]; // The output array. dist[i] will hold 
        // the shortest distance from src to i 
   
        // spt (shortest path set) contains vertices that have shortest path 
        Boolean sptSet[] = new Boolean[num_Vertices]; 
   
        // Initially all the distances are INFINITE and stpSet[] is set to false 
        for (int i = 0; i < num_Vertices; i++) { 
            path_array[i] = Integer.MAX_VALUE; 
            sptSet[i] = false; 
        } 
   
        // Path between vertex and itself is always 0 
        path_array[src_node] = 0; 
   // now find shortest path for all vertices  
        for (int count = 0; count < num_Vertices - 1; count++) { 
            // call minDistance method to find the vertex with min distance
            int u = minDistance(path_array, sptSet); 
              // the current vertex u is processed
            sptSet[u] = true; 
              // process adjacent nodes of the current vertex
            for (int v = 0; v < num_Vertices; v++) 
   
                // if vertex v not in sptset then update it  
                if (!sptSet[v] && graph[u][v] != 0 && path_array[u] != 
                            Integer.MAX_VALUE && path_array[u] 
                            + graph[u][v] < path_array[v]) 
                            path_array[v] = path_array[u] + graph[u][v]; 
        } 
   
        // print the path array 
        printMinpath(path_array); 
    } 

    public static int runDijkstras(int[][] A, int start, int end) 
    {

        return -1;
    }
}