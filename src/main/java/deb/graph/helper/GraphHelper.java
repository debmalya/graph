/**
 * 
 */
package deb.graph.helper;

import deb.graph.Graph;

/**
 * @author debmalyajash
 *
 */
public class GraphHelper {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Compute degree of v.
	 * 
	 * @param g
	 *            graph
	 * @param v
	 *            vertex
	 * @return degree of v.
	 */
	public static int degree(Graph g, int v) {
		int degree = 0;
		if (g != null) {
			for (int w : g.adj(v))
				degree++;
		}
		return degree;
	}

	/** 
	 * Compute maximum degree
	 * @param g graph
	 * @return maximum degree of the graph.
	 */
	public static int maxDegree(Graph g) {
		int max = 0;
		if (g != null) {
			for (int i = 0; i < g.getVertices(); i++) {
				max = Math.max(max,degree(g,i));
			}
		}
		return max;
	}
	
	/**
	 * Compute average degree
	 * @param g graph
	 * @return average degree
	 */
	public static double averageDegree(Graph g) {
		return 2.0 * g.getEdges() / g.getVertices();
	}
	
	/**
	 * Count self loops.
	 * @param g graph
	 * @return number of self loops.
	 */
	public int numberOfSelfLoop(Graph g) {
		int selfLoops= 0;
		for (int i = 0; i < g.getVertices(); i++){
			for (int w : g.adj(i)) {
				if ( w == i) {
					selfLoops++;
				}
			}
		}
		// Each edge counted for both the vertices.
		return selfLoops / 2;
	}
}
