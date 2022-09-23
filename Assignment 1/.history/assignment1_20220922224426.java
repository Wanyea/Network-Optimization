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
        int[][] matrix = new int[n][n];
        List<String> line = new ArrayList<String>();
        List<Integer> rows = new ArrayList<Integer>();
        

        //Populate n x n matrix. 
        for(int i = 0; i < n; i++) {
            if(dataFileInput.hasNext()) {
                line.add(dataFileInput.next());
                StringTokenizer tokenizer = new StringTokenizer(line.get(0), ",");
                for(int k = 0; tokenizer.hasMoreTokens(); k++) {
                    matrix[i][k] = Integer.parseInt(tokenizer.nextToken());
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

        //algo_dijkstra(matrix, 48);
       
        dijkstra(matrix, 48);

        // Close scanner 
        dataFileInput.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
     
    }
 
        
    private static final int NO_PARENT = -1;
 
    // Function that implements Dijkstra's
    // single source shortest path
    // algorithm for a graph represented
    // using adjacency matrix
    // representation
    private static void dijkstra(int[][] adjacencyMatrix, int start, int end)
    {
        int nVertices = adjacencyMatrix[0].length;
 
        // shortestDistances[i] will hold the
        // shortest distance from src to i
        int[] shortestDistances = new int[nVertices];
 
        // added[i] will true if vertex i is
        // included / in shortest path tree
        // or shortest distance from src to
        // i is finalized
        boolean[] added = new boolean[nVertices];
 
        // Initialize all distances as
        // INFINITE and added[] as false
        for (int vertexIndex = 0; vertexIndex < nVertices;
                                            vertexIndex++)
        {
            shortestDistances[vertexIndex] = Integer.MAX_VALUE;
            added[vertexIndex] = false;
        }
         
        // Distance of source vertex from
        // itself is always 0
        shortestDistances[start] = 0;
 
        // Parent array to store shortest
        // path tree
        int[] parents = new int[nVertices];
 
        // The starting vertex does not
        // have a parent
        parents[start] = NO_PARENT;
 
        // Find shortest path for all
        // vertices
        for (int i = 1; i < nVertices; i++)
        {
 
            // Pick the minimum distance vertex
            // from the set of vertices not yet
            // processed. nearestVertex is
            // always equal to startNode in
            // first iteration.
            int nearestVertex = -1;
            int shortestDistance = Integer.MAX_VALUE;
            for (int vertexIndex = 0;
                     vertexIndex < nVertices;
                     vertexIndex++)
            {
                if (!added[vertexIndex] &&
                    shortestDistances[vertexIndex] <
                    shortestDistance)
                {
                    nearestVertex = vertexIndex;
                    shortestDistance = shortestDistances[vertexIndex];
                }
            }
 
            // Mark the picked vertex as
            // processed
            added[nearestVertex] = true;
 
            // Update dist value of the
            // adjacent vertices of the
            // picked vertex.
            for (int vertexIndex = 0;
                     vertexIndex < nVertices;
                     vertexIndex++)
            {
                int edgeDistance = adjacencyMatrix[nearestVertex][vertexIndex];
                 
                if (edgeDistance > 0
                    && ((shortestDistance + edgeDistance) <
                        shortestDistances[vertexIndex]))
                {
                    parents[vertexIndex] = nearestVertex;
                    shortestDistances[vertexIndex] = shortestDistance +
                                                       edgeDistance;
                }
            }
        }
 
        printSolution(start, shortestDistances, parents);
    }
 
    // A utility function to print
    // the constructed distances
    // array and shortest paths
    private static void printSolution(int start,
                                      int[] distances,
                                      int[] parents)
    {
        int nVertices = distances.length;
        System.out.print("Vertex\t Distance\tPath");
         
        for (int vertexIndex = 0;
                 vertexIndex < nVertices;
                 vertexIndex++)
        {
            if (vertexIndex != start)
            {
                System.out.print("\n" + start + " -> ");
                System.out.print(vertexIndex + " \t\t ");
                System.out.print(distances[vertexIndex] + "\t\t");
                printPath(vertexIndex, parents);
            }
        }
    }
 
    // Function to print shortest path
    // from source to currentVertex
    // using parents array
    private static void printPath(int currentVertex,
                                  int[] parents)
    {
         
        // Base case : Source node has
        // been processed
        if (currentVertex == NO_PARENT)
        {
            return;
        }
        printPath(parents[currentVertex], parents);
        System.out.print(currentVertex + " ");
    }
}