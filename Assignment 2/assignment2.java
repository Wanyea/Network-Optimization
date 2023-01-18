import java.util.*;
import java.io.*;

public class assignment2 {
 
    private int vertices; 
    private ArrayList<Integer>[] adjacencyList; 
    private static ArrayList<String> eulerCircuit = new ArrayList<String>();
 
    public static void main(String args[])
    {
         // Try to read file, throw exception if not possible. 
         try 
         {
 
             // Read file.
             File dataFile = new File("C:/Users/wanye/source/Network-Optimization/Assignment 2/assignment2_data.txt");
             Scanner dataFileInput = new Scanner(dataFile);  
             Scanner sc = new Scanner(System.in);
             FileWriter writer = new FileWriter("assignment2_output.txt"); 
             
             
             // Declare/Initialize matrix 'A' and helpers.
             int n = 100;
             int[][] matrix = new int[n][n];
             List<String> line = new ArrayList<String>();
             
             //Populate n x n matrix. 
             for(int i = 0; i < n; i++) 
             {
                 if(dataFileInput.hasNext()) 
                 {
                     line.add(dataFileInput.next());
                     StringTokenizer tokenizer = new StringTokenizer(line.get(0), ",");

                     for(int k = 0; tokenizer.hasMoreTokens(); k++) 
                     {
                         matrix[i][k] = Integer.parseInt(tokenizer.nextToken());
                     }
                 }
                 
                 line = new ArrayList<>(); // Clear to prepare for next row in the matrix.   
             }
 
             // User input used as starting/ending vertex for Euler circuit (e.g PID: 4867444 --> Starting/Ending vertex": 44)
             int startVertex = sc.nextInt();
             eulerCircuit.add(Integer.toString(startVertex));

             Fleury(matrix, startVertex); // Run Fleury's algorithm on matrix A, starting at user defined vertex (startVertex).
 
             // Output text file with soltuion. 
             for(String str : eulerCircuit) 
             {
                writer.write(str + ", ");
             }

             // Close scanners and writer.
             dataFileInput.close();
             sc.close();
             writer.close();

 
         // Handle I/O exceptions
         } catch (IOException e) {
             e.printStackTrace();
         }
    }

        // Graph that makes up each vertex and edge of given adjacency matrix. (Can't make more than one file so name isn't accurate).
        assignment2(int numOfVertices)
        {
            this.vertices = numOfVertices;
            createGraph();
        }
     
        // utility method to initialise adjacencyListacency list.
        @SuppressWarnings("unchecked") public void createGraph()
        {
    
            adjacencyList = new ArrayList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjacencyList[i] = new ArrayList<>();
            }
        }
     
        // connect one vertex to another. 
        public void newEdge(Integer start, Integer end)
        {
            adjacencyList[start].add(end);
            adjacencyList[end].add(start);
        }
     
        // deletes edges between vertices. 
        public void deleteEdge(Integer start, Integer end)
        {
            adjacencyList[start].remove(end);
            adjacencyList[end].remove(start);
        }
     
        // Print Euler tour starting from vertex u
        public void findEulerCircuit(Integer startIndex)
        {
            // Find all vertices connected to given vertex.
            for (int i = 0; i < adjacencyList[startIndex].size(); i++) {
    
                Integer vertex = adjacencyList[startIndex].get(i);
    
                // If edge from start to end is valid, add edge.
                if (isValidNewEdge(startIndex, vertex)) {
                    eulerCircuit.add(Integer.toString(vertex));
     
                    // Remove seen edge. 
                    deleteEdge(startIndex, vertex);
                    findEulerCircuit(vertex);
                }
            }
        }
     
        // Checks if creating a new edge between start and end is valid. 
        public boolean isValidNewEdge(Integer start, Integer end)
        {
          
            if (adjacencyList[start].size() == 1) return true;
     
            boolean[] isVisited = new boolean[this.vertices];
            int counter = primsCount(start, isVisited);
     
            deleteEdge(start, end);
            isVisited = new boolean[this.vertices];
            int updatedCounter = primsCount(start, isVisited);
     
         
            newEdge(start, end);
            return (counter > updatedCounter) ? false : true;
        }
     
        // Checks if removing edge would disconnect graph and stores number of edges connected to given vertex. 
        public int primsCount(Integer vertex, boolean[] isVisited)
        {
            // Mark the current vertex as visited.
            isVisited[vertex] = true;
            int counter = 1;
    
            for (int adjacencyList : adjacencyList[vertex]) {
                if (!isVisited[adjacencyList]) {
                    counter = counter + primsCount(adjacencyList, isVisited);
                }
            }
            return counter;
        }
    
        public static void Fleury(int[][] A, int startVertex) 
        {
              int n = 100;
    
              assignment2 newGraph = new assignment2(n);
    
              for (int i = 0; i < n; i++) 
              {
                  for (int j = 0; j < n; j++) 
                  {
                      if(A[i][j] == 1) 
                      {
                          newGraph.newEdge(i, j);
                      }
                  }
              }
              
              newGraph.findEulerCircuit(startVertex);
              System.out.print(eulerCircuit);
        }
     
}
