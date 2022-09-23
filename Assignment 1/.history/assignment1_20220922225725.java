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

        dijkstra(matrix, 48, 86); // {48 , 86}
        dijkstra(matrix, 86, 7); // {86, 7}
        dijkstra(matrix, 7, 4); // {7, 4}
        dijkstra(matrix, 4, 44); // {4, 44}
        dijkstra(matrix, 44, 44); // {44, 44}

    
        // Close scanner 
        dataFileInput.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
     
    }
 
        
    private static final int NO_PARENT = -1;
 
    private static void dijkstra(int[][] A, int start, int end)
    {
        int numOfVertices = A[0].length;
 
        // shortestPath[i] will hold the
        // shortest distance from src to i
        int[] shortestPath = new int[numOfVertices];
 
        // visitedVertex[i] will true if vertex i is
        // included / in shortest path tree
        // or shortest distance from src to
        // i is finalized
        boolean[] visitedVertex = new boolean[numOfVertices];
 
        // Initialize all distances as
        // INFINITE and visitedVertex[] as false
        for (int vertexIndex = 0; vertexIndex < numOfVertices; vertexIndex++)
        {
            shortestPath[vertexIndex] = Integer.MAX_VALUE;
            visitedVertex[vertexIndex] = false;
        }
         
       // If we are trying to find distance from vertex to itself, make this distance 0
        shortestPath[start] = 0;
 
        // Parent array to store shortest
        // path tree
        int[] shortestPathArray = new int[numOfVertices];
 
        // The starting vertex does not
        // have a parent
        shortestPathArray[start] = NO_PARENT;
 
        // Find shortest path for all
        // vertices
        for (int i = 1; i < numOfVertices; i++)
        {
 
            // Pick the minimum distance vertex
            // from the set of vertices not yet
            // processed. nearestVertex is
            // always equal to startNode in
            // first iteration.
            int nearestVertex = -1;
            int shortestDistance = Integer.MAX_VALUE;
            for (int vertexIndex = 0;
                     vertexIndex < numOfVertices;
                     vertexIndex++)
            {
                if (!visitedVertex[vertexIndex] &&
                    shortestPath[vertexIndex] <
                    shortestDistance)
                {
                    nearestVertex = vertexIndex;
                    shortestDistance = shortestPath[vertexIndex];
                }
            }
 
            // Mark the picked vertex as
            // processed
            visitedVertex[nearestVertex] = true;
 
            // Update dist value of the
            // adjacent vertices of the
            // picked vertex.
            for (int vertexIndex = 0;
                     vertexIndex < numOfVertices;
                     vertexIndex++)
            {
                int edgeDistance = A[nearestVertex][vertexIndex];
                 
                if (edgeDistance > 0
                    && ((shortestDistance + edgeDistance) <
                        shortestPath[vertexIndex]))
                {
                    shortestPathArray[vertexIndex] = nearestVertex;
                    shortestPath[vertexIndex] = shortestDistance +
                                                       edgeDistance;
                }
            }
        }
 
        printSolution(start, shortestPath, shortestPathArray);
    }
 
    // A utility function to print
    // the constructed distances
    // array and shortest paths
    private static void printSolution(int start,
                                      int[] distances,
                                      int[] shortestPathArray)
    {
        int numOfVertices = distances.length;
        System.out.print("Vertex\t Distance\tPath");
         
        for (int vertexIndex = 0; vertexIndex < numOfVertices; vertexIndex++)
        {
            if (vertexIndex != start)
            {
                System.out.print("\n" + start + " -> ");
                System.out.print(vertexIndex + " \t\t ");
                System.out.print(distances[vertexIndex] + "\t\t");
                printPath(vertexIndex, shortestPathArray);
            }
        }
    }
 
    // Function to print shortest path
    // from source to currentVertex
    // using shortestPathArray array
    private static void printPath(int currentVertex,
                                  int[] shortestPathArray)
    {
         
        // Base case : Source node has
        // been processed
        if (currentVertex == NO_PARENT)
        {
            return;
        }
        printPath(shortestPathArray[currentVertex], shortestPathArray);
        System.out.print(currentVertex + " ");
    }
}