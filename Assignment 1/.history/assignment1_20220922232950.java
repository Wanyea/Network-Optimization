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

        //Run dijkstras's algorithm on dataset where UCF PID is: 4867444.

        runDijkstras(matrix, 48, 86); // {48 , 86}
        runDijkstras(matrix, 86, 7); // {86, 7}
        runDijkstras(matrix, 7, 4); // {7, 4}
        runDijkstras(matrix, 4, 44); // {4, 44}
        runDijkstras(matrix, 44, 44); // {44, 44}

    
        // Close scanner 
        dataFileInput.close();

        // Handle I/O exceptions
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    private static void runDijkstras(int[][] A, int start, int end)
    {
        int numOfVertices = A[0].length;
 
        // Contains each vertex that makes up shortest path from START to END.
        int[] shortestPath = new int[numOfVertices];
 
       
        boolean[] visitedVertex = new boolean[numOfVertices]; // Initialize array that keeps track of whether we have seen this vertex or not. 
 
        // Mark all nodes with infinity and set their visited state to false.
        for (int vertexIndex = 0; vertexIndex < numOfVertices; vertexIndex++)
        {
            shortestPath[vertexIndex] = Integer.MAX_VALUE;
            visitedVertex[vertexIndex] = false;
        }
         
        // If we are trying to find distance from vertex to itself, make this distance 0
        shortestPath[start] = 0;
 
        // Stores shortest path for printing later. 
        int[] shortestPathArray = new int[numOfVertices];
 
        // The source does not have a previous vertex. (Useful to mark for printing purposes later)
        shortestPathArray[start] = noPrevVertex;
 
        // Find shortest path from START to END
        for (int i = 1; i < numOfVertices; i++)
        {
            int closestVertex = -1; // Initialize with null for closest vertex to current. 
            int shortestDistance = Integer.MAX_VALUE; // Initalize with largest distance.

            for (int vertexIndex = 0; vertexIndex < numOfVertices; vertexIndex++)
            {
                // If we haven't marked this vertex as VISITED and there is a newest shortest path: update shortest path distance.
                if (!visitedVertex[vertexIndex] && shortestPath[vertexIndex] < shortestDistance)
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