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
        int newestFromNode = -1;
        int newestToNode = -1;
        int toNode = -1;
        int fromNode = -1;
        int whichNode = 0;

        // Construct directed-unweighted graph.
        while(dataFileInput.hasNext()) 
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
                    if (newestFromNode != fromNode) 
                    {
                        newestFromNode = fromNode;
                        AmazonGraph.addVertex(newestFromNode, newestFromNode);
                    }

                } else {
                    toNode = Integer.parseInt(tokenizer.nextToken());
                    whichNode = 0;

                    // Add node to AmazonGraph if we haven't seen it before.
                    if (newestToNode != toNode) 
                    {
                        newestToNode = toNode;
                        AmazonGraph.addVertex(newestToNode, newestToNode);
                    }

                    System.out.println((AmazonGraph.vertices.get(fromNode)).getData());
                    System.out.println(AmazonGraph.vertices.get(toNode).getData());
                    AmazonGraph.addDirectedEdge(AmazonGraph.vertices.get(fromNode), AmazonGraph.vertices.get(toNode));
                }
            
                line = new ArrayList<>(); // Clear to prepare for next row in the matrix.     
            }
            
            
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

    // Print the AmazonGraph
    //AmazonGraph.printGraph();

    // Handle I/O exceptions
    } catch (IOException e) {
        e.printStackTrace();
    }

    
  }
}