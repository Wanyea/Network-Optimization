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
        int newestNode = -1;
        int toNode = -1;
        int fromNode = -1;
        int whichNode = 0;

        // Construct directed-unweighted graph.
        while(dataFileInput.hasNext() && toNode != -2 && fromNode != -2) 
        {
            if(dataFileInput.hasNext()) 
            {
                line.add(dataFileInput.next());
                StringTokenizer tokenizer = new StringTokenizer(line.get(0), "  ");

                if (whichNode == 0) 
                {
                    fromNode = Integer.parseInt(tokenizer.nextToken());
                    whichNode = 1;

                    // Add node to AmazonGraph if we haven't seen it before.
                    if (newestNode != fromNode) 
                    {
                        newestNode = fromNode;
                        AmazonGraph.addVertex(newestNode);
                    }

                    // Create edge between nodes. 

                } else {
                    toNode = Integer.parseInt(tokenizer.nextToken());
                    whichNode = 0;
                }

                line = new ArrayList<>(); // Clear to prepare for next row in the matrix.     
            }
            
            System.out.println("From Node: " + String.valueOf(fromNode) + "   To Node: " + String.valueOf(toNode));
            toNode = -2;
            fromNode = -2;
        }

        

        // Output text file with soltuion. 
        // for(String str : eulerCircuit) 
        // {
        //    writer.write(str + ", ");
        // }

        // Close scanners and writer.
        dataFileInput.close();
        sc.close();
        writer.close();


    // Handle I/O exceptions
    } catch (IOException e) {
        e.printStackTrace();
    }

    // Add some vertices to the graph
    // AmazonGraph.addVertex(0);
    // AmazonGraph.addVertex(1);
    // AmazonGraph.addVertex(2);
    // AmazonGraph.addVertex(3);
    // AmazonGraph.addVertex(4);

    // // Add some directed edges to the AmazonGraph
    // AmazonGraph.addDirectedEdge(AmazonGraph.vertices.get(0), AmazonGraph.vertices.get(1));
    // AmazonGraph.addDirectedEdge(AmazonGraph.vertices.get(0), AmazonGraph.vertices.get(2));
    // AmazonGraph.addDirectedEdge(AmazonGraph.vertices.get(1), AmazonGraph.vertices.get(2));
    // AmazonGraph.addDirectedEdge(AmazonGraph.vertices.get(2), AmazonGraph.vertices.get(0));
    // AmazonGraph.addDirectedEdge(AmazonGraph.vertices.get(2), AmazonGraph.vertices.get(3));
    // AmazonGraph.addDirectedEdge(AmazonGraph.vertices.get(3), AmazonGraph.vertices.get(3));

    // // Print the AmazonGraph
    // AmazonGraph.printAmazonGraph();
  }
}