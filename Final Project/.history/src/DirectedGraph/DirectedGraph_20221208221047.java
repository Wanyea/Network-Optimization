package DirectedGraph;

import java.util.ArrayList;
import java.util.List;

public class DirectedGraph 
{

  // A class to represent a vertex in a directed graph
  public static class Vertex 
  {
    int data;
    List<Vertex> neighbors;

    public Vertex(int data) 
    {
      this.data = data;
      this.neighbors = new ArrayList<>();
    }

    // Getter
    public int getData() 
    {
        return data;
    }
  
    // Setter
    public void setData(int data) 
    {
        this.data = data;
    }
  }

  public List<Vertex> vertices = new ArrayList<Vertex>(403393);

  for (int i = 0; i < 403393; i++) 
  {
    vertices.add(new Vertex(0));
  }

  public DirectedGraph() 
  {
    this.vertices = new ArrayList<>();
  }

  // Add a new vertex to the graph
  public void addVertex(int position, int data) {
    vertices.add(position, new Vertex(data));
  }

  // Add a directed edge from vertex A to vertex B
  public void addDirectedEdge(Vertex from, Vertex to) {
    from.neighbors.add(to);
  }

  // Print the graph-
  public void printGraph() {
    for (Vertex v : vertices) {
      System.out.print(v.data + ": ");
      for (Vertex n : v.neighbors) {
        System.out.print(n.data + " ");
      }
      System.out.println();
    }
  }

}

