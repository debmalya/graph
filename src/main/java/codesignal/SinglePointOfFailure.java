package codesignal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SinglePointOfFailure {
	/**
	 * Sue is a network administrator who consults for companies that have massive
	 * Local Area Networks (LANs). The computers are connected together with network
	 * cables, and Sue has been brought in to evaluate the company’s network. The
	 * networks are huge, and she wants to ensure that no single network cable
	 * failure can disconnect the network. Any cable that fails that leaves the
	 * network in two or more disconnected pieces is called a single point of
	 * failure.
	 * 
	 * She labels the different network devices from 0 to n - 1. She keeps an n × n
	 * matrix connections, where connections[i][j] = 1 if there is a network cable
	 * directly connecting devices i and j, and 0 otherwise. Write a function that
	 * takes the matrix of connections, and returns the number of cables that are a
	 * single point of failure.
	 * 
	 * @param connections - adjacency list.
	 * @return the number of cables that are a single point of failure.
	 * 
	 *         For connections = [[0, 1], [1, 0]], the output should be
	 *         solution(connections) = 1. A failure of the cable that connects
	 *         devices 0 and 1 would leave the network disconnected.
	 * 
	 *         For connections = [[0, 1, 1], [1, 0, 1], [1, 1, 0]], the output
	 *         should be solution(connections) = 0. No failure of a single network
	 *         cable would result in the network being disconnected.
	 * 
	 *         For connections = [[0, 1, 1, 1, 0, 0], [1, 0, 1, 0, 0, 0], [1, 1, 0,
	 *         0, 0, 0], [1, 0, 0, 0, 1, 1], [0, 0, 0, 1, 0, 0], [0, 0, 0, 1, 0,
	 *         0]], the output should be solution(connections) = 3.
	 * 
	 *         For connections = [[0, 1, 1, 1, 1], [1, 0, 0, 0, 0], [1, 0, 0, 0, 0],
	 *         [1, 0, 0, 0, 0], [1, 0, 0, 0, 0]], the output should be
	 *         solution(connections) = 4.
	 */
	int solution(int[][] connections) {
		int noOfVertices = connections.length;
		Graph graph = new Graph(noOfVertices);

		for (int vertexIndex = 0; vertexIndex < noOfVertices; vertexIndex++) {
			for (int connectionCount = 0; connectionCount < noOfVertices; connectionCount++) {
				if (connections[vertexIndex][connectionCount] == 1) {
					graph.addEdge(vertexIndex, connectionCount);
				}
			}
		}

		return graph.getNoOfSinglePointOfFailure();

	}

	class Graph {
		private final int noOfVertices;
		private final List<List<Integer>> adjacencyList;
		private int noOfEdges;

		/**
		 * 
		 * @param v - number of vertices
		 */
		public Graph(int v) {
			noOfVertices = v;
			adjacencyList = new ArrayList<>(noOfVertices);

			for (int i = 0; i < noOfVertices; i++)
				adjacencyList.add(new LinkedList<>());
		}

		public int getNoOfSinglePointOfFailure() {
			System.out.printf("No of edges :%d\n", noOfEdges);
			if (isCyclic()) {
				return 0;
			}
			return 0;
		}

		private boolean verticesInCycle(int i, boolean[] visited, boolean[] recStack) {

			// Mark the current node as visited and
			// part of recursion stack
			if (recStack[i])
				return true;

			if (visited[i])
				return false;

			visited[i] = true;

			recStack[i] = true;
			List<Integer> children = adjacencyList.get(i);

			for (Integer c : children)
				if (verticesInCycle(c, visited, recStack))
					return true;

			recStack[i] = false;

			return false;
		}

		private boolean isCyclic() {

			// Mark all the vertices as not visited and
			// not part of recursion stack
			boolean[] visited = new boolean[noOfVertices];
			boolean[] recStack = new boolean[noOfVertices];

			// Call the recursive helper function to
			// detect cycle in different DFS trees
			for (int i = 0; i < noOfVertices; i++)
				if (verticesInCycle(i, visited, recStack))
					return true;

			return false;
		}

		private void addEdge(int source, int dest) {
			List<Integer> sourceList = adjacencyList.get(source);
			if (!sourceList.contains(dest)) {
				if (!adjacencyList.get(dest).contains(source)) {
					noOfEdges = getNoOfEdges() + 1;
				}
				sourceList.add(dest);
			}
		}

		public int getNoOfEdges() {
			return noOfEdges;
		}
	}

}
