import java.util.*;
import java.io.*;
import DirectedGraph.DirectedGraph;
import DirectedGraph.DirectedGraph.Vertex;

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
        initializeGraph(AmazonGraph); // Initalize Amazon Graph before using.

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
                    if (!nodeExists(AmazonGraph, fromNode)) 
                    {
                        newestFromNode = fromNode;
                        AmazonGraph.addVertex(newestFromNode, newestFromNode);
                    }

                } else {
                    toNode = Integer.parseInt(tokenizer.nextToken());
                    whichNode = 0;

                    // Add node to AmazonGraph if we haven't seen it before.
                    if (!nodeExists(AmazonGraph, toNode)) 
                    {
                        newestToNode = toNode;
                        AmazonGraph.addVertex(newestToNode, newestToNode);
                    }

                    AmazonGraph.addDirectedEdge(AmazonGraph.vertices.get(fromNode), AmazonGraph.vertices.get(toNode));
                }
            
                line = new ArrayList<>(); // Clear to prepare for next row in the matrix.     
            }
            
            
        }

        

        // Output text file with soltuion. 
        writer.write("Your input item: ");
        writer.write("Your top five recommended items: ");
        writer.write(String.valueOf(makePrediction()).getData() + ", ");
    

        // Close scanners and writer.
        dataFileInput.close();
        sc.close();
        writer.close();

    // Print the AmazonGraph
    AmazonGraph.printGraph();

    // Handle I/O exceptions
    } catch (IOException e) {
        e.printStackTrace();
    }

    
  }

  public static boolean nodeExists(DirectedGraph AmazonGraph, int data) 
  {
        for (Vertex v : AmazonGraph.vertices) 
        {
            if (v.getData() == data)
                return true;
        }

        return false;
  }

  public static void initializeGraph(DirectedGraph AmazonGraph) 
  {
    for (int i = 0; i < 403393; i++) 
    {
        AmazonGraph.vertices.add(new Vertex(0));
    }
  }

  public CollaborativeAlgorithm(List<Vertex> vertices, List<Edge> edges) {
    this.vertices = vertices;
    this.edges = edges;
}

public Vertex makePredictions() {

    //iterate through each vertex

    for (Vertex vertex : vertices) {

        // find all neighboring vertices
        List<Vertex> neighbors = findNeighbors(vertex);

        // calculate the average value of the neighboring vertices
        
        int averageValue = calculateAverageValue(neighbors);

        // predict the value of the current vertex based on the average value of its neighbors
        int prediction = predictValue(vertex, averageValue);

        // update the value of the current vertex with the predicted value
        updateValue(vertex, prediction);
    }
}

private List<Vertex> findNeighbors(Vertex vertex) {
    List<Vertex> neighbors = new ArrayList<>();

    // Iterate through each edge to find the neighboring vertices
    for (Edge edge : edges) {
        if (edge.contains(vertex)) {
            Vertex neighbor = edge.getOtherVertex(vertex);
            neighbors.add(neighbor);
        }
    }
    return neighbors;
}

private int calculateAverageValue(List<Vertex> vertices) {
    int sum = 0;
    for (Vertex vertex : vertices) {
        sum += vertex.getValue();
    }
    return sum / vertices.size();
}

private int predictValue(Vertex vertex, int averageValue) {

    // Predict the value based on the average value of the neighboring vertices
    // and the current value of the vertex
    return (vertex.getValue() + averageValue) / 2;
}

private void updateValue(Vertex vertex, int prediction) {
    vertex.setValue(prediction);
}

}