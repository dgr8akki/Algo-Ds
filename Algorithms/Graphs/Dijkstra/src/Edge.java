package Algorithms.Graphs.Dijkstra.src;

public class Edge {
  private Vertex sourceVertex;
  private Vertex destinationVertex;
  private double weight;

  public Edge(double weight, Vertex sourceVertex, Vertex destinationVertex) {
    this.sourceVertex = sourceVertex;
    this.destinationVertex = destinationVertex;
    this.weight = weight;
  }

  public Vertex getSourceVertex() {
    return sourceVertex;
  }

  public void setSourceVertex(Vertex sourceVertex) {
    this.sourceVertex = sourceVertex;
  }

  public Vertex getDestinationVertex() {
    return destinationVertex;
  }

  public void setDestinationVertex(Vertex destinationVertex) {
    this.destinationVertex = destinationVertex;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }
}
