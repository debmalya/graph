/**
 * 
 */
package deb.graph;


import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class GraphTest {

	@Test
	public final void test() {
		Graph graph = new Graph(13);
		graph.addEdge(0, 5);
		graph.addEdge(4, 3);
		graph.addEdge(0, 1);
		graph.addEdge(9,12);
		
		graph.addEdge(6, 4);
		graph.addEdge(5, 4);
		graph.addEdge(0, 2);
		graph.addEdge(11,12);
		
		graph.addEdge(9, 10);
		graph.addEdge(0, 6);
		graph.addEdge(7, 8);
		graph.addEdge(9,11);
		graph.addEdge(5,3);
		
		Assert.assertEquals(13, graph.getEdges());
		Assert.assertEquals(13, graph.getVertices());
		
		System.out.println(graph);
	}

}
