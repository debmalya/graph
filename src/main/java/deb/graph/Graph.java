/**
 * 
 */
package deb.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class Graph {
	/**
	 * Number of vertices
	 */
	private int vertices;

	/**
	 * Number of edges.
	 */
	private int edges = 0;
	private List<Integer>[] adj = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Constructor.
	 * 
	 * @param numberOfVertices
	 *            - Number of vertices.
	 */
	public Graph(int numberOfVertices) {
		if (numberOfVertices < 0) {
			throw new IllegalArgumentException("Size must be positive.");
		}

		vertices = numberOfVertices;

		for (int i = 0; i < numberOfVertices; i++) {
			adj[i] = new ArrayList<Integer>();
		}

	}

	/**
	 * Constructor.
	 * @param scanner to scan parameters.
	 */
	public Graph(Scanner scanner) {
		this(scanner.nextInt());

		int edges = scanner.nextInt();
		if (edges < 1) {
			throw new IllegalArgumentException("Edges must be greater than 0.");
		}
		for (int i = 0; i < edges; i++) {
			int v = scanner.nextInt();
			int w = scanner.nextInt();
			
			addEdge(v,w);
		}
	}
	
	/**
	 * Add edge v-w to this graph
	 * @param v source vertex.
	 * @param w destination vertex.
	 */
	public void addEdge(int v,int w) {
		validateVertex(v);
		validateVertex(w);
		adj[v].add(w);
		adj[w].add(v);
		edges++;
	}
	
	/**
	 * vertices adjacent to v.
	 * @param v vertices.
	 * @return neighbours of v.
	 */
	public Iterable<Integer> adj(int v) {
		validateVertex(v);
		return adj[v];
	}
	
	 // throw an IndexOutOfBoundsException unless 0 <= v < V
    private void validateVertex(int v) {
        if (v < 0 || v >= vertices)
            throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (vertices-1));
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder aboutMe = new StringBuilder();
		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < adj[i].size(); j++) {
				aboutMe.append(i+" - " + adj[i].get(j)+"\n");
			}
		}
		return aboutMe.toString();
	}

	/**
	 * @return the vertices
	 */
	public int getVertices() {
		return vertices;
	}

	/**
	 * @param vertices the vertices to set
	 */
	public void setVertices(int vertices) {
		this.vertices = vertices;
	}

	/**
	 * @return the edges
	 */
	public int getEdges() {
		return edges;
	}

	/**
	 * @param edges the edges to set
	 */
	public void setEdges(int edges) {
		this.edges = edges;
	}

	/**
	 * @return the adj
	 */
	public List<Integer>[] getAdj() {
		return adj;
	}

	/**
	 * @param adj the adj to set
	 */
	public void setAdj(List<Integer>[] adj) {
		this.adj = adj;
	}
	
	
	

    
}
