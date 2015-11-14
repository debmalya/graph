/**
 * 
 */
package deb.graph.helper;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import deb.graph.Graph;

/**
 * @author debmalyajash
 *
 */
public class PathsTest {
	/**
	 * Graph
	 */
	private Graph graph = null;

	/**
	 * Number of vertices of the graph.
	 */
	private int numberOfVertices = 13;

	/**
	 * Path to traverse the graph.
	 */
	private Paths paths = null;
	/**
	 * Source of the graph
	 */
	private int source = 0;

	@Before
	public void setUp() {
		graph = new Graph(numberOfVertices);
		graph.addEdge(0, 5);
		graph.addEdge(4, 3);
		graph.addEdge(0, 1);
		graph.addEdge(9, 12);

		graph.addEdge(6, 4);
		graph.addEdge(5, 4);
		graph.addEdge(0, 2);
		graph.addEdge(11, 12);

		graph.addEdge(9, 10);
		graph.addEdge(0, 6);
		graph.addEdge(7, 8);
		graph.addEdge(9, 11);
		graph.addEdge(5, 3);

		paths = new Paths(graph, source);
	}

	/**
	 * Test method for
	 * {@link deb.graph.helper.Paths#Paths(deb.graph.Graph, int)}.
	 */
	@Test
	public final void testPaths() {
		Assert.assertNotNull(paths);
		

	}

	/**
	 * Test method for {@link deb.graph.helper.Paths#hasDirectPathTo(int)}.
	 */
	@Test
	public final void testHasPathTo() {
		Assert.assertFalse("There is no path between 0 and 4.",
				paths.hasDirectPathTo(4));
		Assert.assertTrue("There is path between 0 and 5.",
				paths.hasDirectPathTo(5));
	}

	/**
	 * Test method for {@link deb.graph.helper.Paths#pathTo(int)}.
	 */
	@Test
	public final void testPathTo() {
		Iterable<Integer> path = paths.pathTo(5);
		Assert.assertNotNull(path);
		Assert.assertTrue(path.iterator().hasNext());
	}

}
