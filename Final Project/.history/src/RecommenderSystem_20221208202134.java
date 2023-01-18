import java.util.*;
import java.io.*;
import DirectedGraph.DirectedGraph;

public class RecommenderSystem 
{

  public static void main(String[] args) 
  {

    // Try to read file, throw exception if not possible. 
    try 
    {

        // Read file.
        File dataFile = new File("C:/Users/wanye/source/Network-Optimization/Final Project/AmazonDataset.txt");
        Scanner dataFileInput = new Scanner(dataFile);  
        Scanner sc = new Scanner(System.in);
        FileWriter writer = new FileWriter("amazon_predictions_output.txt"); 
        
        
        // Declare/Initialize 'AmazonGraph' and helpers.
        DirectedGraph AmazonGraph = new DirectedGraph();
        List<String> line = new ArrayList<String>();
        
        // Construct directed-unweighted graph.
        while(dataFileInput.hasNext()) 
        {
            if(dataFileInput.hasNext()) 
            {
                line.add(dataFileInput.next());
                StringTokenizer tokenizer = new StringTokenizer(line.get(0), "  ");

                while(tokenizer.hasMoreTokens()) 
                {
                    System.out.println(Integer.parseInt(tokenizer.nextToken()));
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

    // Add some vertices to the graph
    AmazonGraph.addVertex(0);
    AmazonGraph.addVertex(1);
    AmazonGraph.addVertex(2);
    AmazonGraph.addVertex(3);
    AmazonGraph.addVertex(4);

    // Add some directed edges to the AmazonGraph
    AmazonGraph.addDirectedEdge(AmazonGraph.vertices.get(0), AmazonGraph.vertices.get(1));
    AmazonGraph.addDirectedEdge(AmazonGraph.vertices.get(0), AmazonGraph.vertices.get(2));
    AmazonGraph.addDirectedEdge(AmazonGraph.vertices.get(1), AmazonGraph.vertices.get(2));
    AmazonGraph.addDirectedEdge(AmazonGraph.vertices.get(2), AmazonGraph.vertices.get(0));
    AmazonGraph.addDirectedEdge(AmazonGraph.vertices.get(2), AmazonGraph.vertices.get(3));
    AmazonGraph.addDirectedEdge(AmazonGraph.vertices.get(3), AmazonGraph.vertices.get(3));

    // Print the AmazonGraph
    AmazonGraph.printAmazonGraph();
  }
}