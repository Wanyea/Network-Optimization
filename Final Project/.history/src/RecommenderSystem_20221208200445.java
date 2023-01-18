import java.util.*;
import java.io.*;
import DirectedGraph.DirectedGraph;

public class RecommenderSystem 
{

  public static void main(String[] args) 
  {

    DirectedGraph graph = new DirectedGraph();

    // Add some vertices to the graph
    graph.addVertex(0);
    graph.addVertex(1);
    graph.addVertex(2);
    graph.addVertex(3);
    graph.addVertex(4);

    // Add some directed edges to the graph
    graph.addDirectedEdge(graph.vertices.get(0), graph.vertices.get(1));
    graph.addDirectedEdge(graph.vertices.get(0), graph.vertices.get(2));
    graph.addDirectedEdge(graph.vertices.get(1), graph.vertices.get(2));
    graph.addDirectedEdge(graph.vertices.get(2), graph.vertices.get(0));
    graph.addDirectedEdge(graph.vertices.get(2), graph.vertices.get(3));
    graph.addDirectedEdge(graph.vertices.get(3), graph.vertices.get(3));

    // Print the graph
    graph.printGraph();
  }
}