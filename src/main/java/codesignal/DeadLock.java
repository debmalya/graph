package codesignal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DeadLock {
	/**
	 * In a multi threaded environment, it's possible that different processes will
	 * need to use the same resource. A wait-for graph represents the different
	 * processes as nodes in a directed graph, where an edge from node i to node j
	 * means that the node j is using a resource that node i needs to use (and
	 * cannot use until node j releases it).
	 * 
	 * We are interested in whether or not this digraph has any cycles in it. If it
	 * does, it is possible for the system to get into a state where no process can
	 * complete.
	 * 
	 * We will represent the processes by integers 0, ...., n - 1. We represent the
	 * edges using a two-dimensional list connections. If j is in the list
	 * connections[i], then there is a directed edge from process i to process j.
	 * 
	 * Write a function that returns True if connections describes a graph with a
	 * directed cycle, or False otherwise.
	 * 
	 * @param connections
	 * @return
	 */
	boolean hasDeadLock(int[][] connections) {
		int v = connections.length;
		Graph graph = new Graph(v);
		
		for (int row = 0; row < v; row++) {
			for (int col = 0; col < connections[row].length; col++) {
				graph.addEdge(row, connections[row][col]);
			}
		}
		
		return graph.isCyclic();
	}



	class Graph {
		private final int noOfVertices;
		private final List<List<Integer>> adjacencyList;

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

		private boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack) {

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
				if (isCyclicUtil(c, visited, recStack))
					return true;

			recStack[i] = false;

			return false;
		}
		
		private boolean isCyclic() 
	    {
	          
	        // Mark all the vertices as not visited and
	        // not part of recursion stack
	        boolean[] visited = new boolean[noOfVertices];
	        boolean[] recStack = new boolean[noOfVertices];
	          
	          
	        // Call the recursive helper function to
	        // detect cycle in different DFS trees
	        for (int i = 0; i < noOfVertices; i++)
	            if (isCyclicUtil(i, visited, recStack))
	                return true;
	  
	        return false;
	    }
		
		private void addEdge(int source, int dest) {
			adjacencyList.get(source).add(dest);
	    }
	}
}
