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

        //Run Dijkstra's algorithm on dataset where UCF PID is: 4867444.

        dijkstra(matrix, 48, 86); // {48 , 86}
        dijkstra(matrix, 86, 7); // {86, 7}
        dijkstra(matrix, 7, 4); // {7, 4}
        dijkstra(matrix, 4, 44); // {4, 44}
        dijkstra(matrix, 44, 44); // {44, 44}

    
        // Close scanner 
        dataFileInput.close();

        // Handle I/O exceptions
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
        
    private static final int noPrevVertex = -1;
 
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
        shortestPathArray[start] = noPrevVertex;
 
        // Find shortest path for all
        // vertices
        for (int i = 1; i < numOfVertices; i++)
        {
 
            // Pick the minimum distance vertex
            // from the set of vertices not yet
            // processed. closestVertex is
            // always equal to startNode in
            // first iteration.
            int closestVertex = -1;
            int shortestDistance = Integer.MAX_VALUE;
            
            for (int vertexIndex = 0; vertexIndex < numOfVertices; vertexIndex++)
            {
                if (!visitedVertex[vertexIndex] &&
                    shortestPath[vertexIndex] <
                    shortestDistance)
                {
                    closestVertex = vertexIndex;
                    shortestDistance = shortestPath[vertexIndex];
                }
            }
 
           // We have visited this vertex and we no longer want to search it.
            visitedVertex[closestVertex] = true;
 
            // Update dist value of the
            // adjacent vertices of the
            // picked vertex.
            for (int vertexIndex = 0; vertexIndex < numOfVertices; vertexIndex++)
            {
                int edgeDistance = A[closestVertex][vertexIndex];
                 
                if (edgeDistance > 0 && ((shortestDistance + edgeDistance) < shortestPath[vertexIndex]))
                {
                    shortestPathArray[vertexIndex] = closestVertex;
                    shortestPath[vertexIndex] = shortestDistance + edgeDistance;
                }
            }
        }
 
        displayData(start, end, shortestPath, shortestPathArray);
    }
 
    // Helper method that displays start/end, shortest path traveled and shortest path distance. 
    private static void displayData(int start, int end, int[] distances, int[] shortestPathArray)
    {
        System.out.print("\n" + "{" + start + " : " + end + "}" + "\n");
        System.out.print("Path traveled: ");
        displayShortestPath(end, shortestPathArray);
        System.out.print("\n" + "Shortest path distance: " + distances[end] + "\n");
            
    }
    
 
    // Helper method that displays sequence of vertices that make up the shortest path from START to END. 
    private static void displayShortestPath(int end, int[] shortestPathArray)
    {
         
        // Handle printing first vertex (source) without triggering out of bounds exception.
        if (end == noPrevVertex)
        {
            return;
        }

        displayShortestPath(shortestPathArray[end], shortestPathArray);
        System.out.print(end + " ");
    }
}