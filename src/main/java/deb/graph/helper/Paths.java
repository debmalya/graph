/**
 * 
 */
package deb.graph.helper;

import java.util.ArrayList;
import java.util.List;

import deb.graph.Graph;

/**
 * Searching path in graph
 * 
 * @author debmalyajash
 */
public class Paths {

	/**
	 * Graph on which path will be decided.
	 */
	private Graph graph;

	/**
	 * This is the source of the graph.
	 */
	private int source;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	/**
	 * Find paths in G from S.
	 * 
	 * @param g
	 *            - graph
	 * @param s
	 *            - source
	 */
	public Paths(Graph g, int s) {
		graph = g;
		source = s;
	}

	/**
	 * Is there a direct path from s to v ?
	 * 
	 * @param v
	 *            - destination vertex.
	 * @return true if there is a path, false otherwise.
	 */
	boolean hasDirectPathTo(int v) {
		if (v > -1 && v <= graph.getVertices()) {
			List<Integer> adjacency = graph.getAdj()[v];

			if (adjacency.contains(source)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Is there a indirect path from s to v ?
	 * 
	 * @param v
	 *            - destination vertex.
	 * @return true if there is a path, false otherwise.
	 */
	boolean hasIndirectPathTo(int v) {

		if (v > -1 && v <= graph.getVertices()) {
			List<Integer> adjacency = graph.getAdj()[v];
			for (Integer each : adjacency) {
				if (graph.getAdj()[each].contains(source)) {
					return true;
				} else {
					if (hasDirectPathTo(each)) {
						// There is no direct path between source and v.
						// But each is directly connected to source.
						// v is connected to each.
						// So there is indirect connection between source and v.
						return true;
					}
				}
			}

		}
		return false;
	}

	/**
	 * Path from s to v, null if no such path exists.
	 * 
	 * @param v
	 *            destination vertex.
	 * @return the integers to reach from s to v. Null if it is not possible to
	 *         reach.
	 */
	Iterable<Integer> pathTo(int v) {
		List<Integer> path = null;
		if (v > -1 && v <= graph.getVertices()) {

			if (hasDirectPathTo(v)) {
				List<Integer> adjacency = graph.getAdj()[source];
				for (Integer each : adjacency) {
					if (path == null) {
						path = new ArrayList<Integer>();
					}
					path.add(each);
					if (each == v) {
						return path;
					}
				}
			}
		}
		return path;
	}
}
