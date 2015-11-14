/**
 * 
 */
package deb.graph.helper;

import deb.graph.Graph;

/**
 * @author debmalyajash
 *
 */
public class Search {
	/**
	 * Graph to be searched.
	 */
	private Graph graph;
	
	/**
	 * To distinguish the vertex provided as argument to the constructor.
	 */
	private int source;
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Constructor
	 * @param G - graph to be searched. 
	 * @param s - vertex to be used as origin (source).
	 */
	public Search(Graph G,int s) {
		graph = G;
		source = s;
		
	}
	
	/**
	 * is v connected to source ?
	 * @param v
	 * @return
	 */
	public boolean marked(int v) {
		return false;
	}

}
