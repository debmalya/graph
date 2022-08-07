/**
 * 
 */
package deb.graph.helper;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

	@BeforeEach
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
	 * Test method for {@link deb.graph.helper.Paths#Paths(deb.graph.Graph, int)}.
	 */
	@Test
	public final void testPaths() {
		setUp();
		assertNotNull(paths);

	}

	/**
	 * Test method for {@link deb.graph.helper.Paths#hasDirectPathTo(int)}.
	 */
	@Test
	public final void testHasPathTo() {
		setUp();
		assertFalse(paths.hasDirectPathTo(4), "There is no direct path between 0 and 4.");
		assertTrue(paths.hasDirectPathTo(5), "There is path between 0 and 5.");
	}

	/**
	 * Test method for {@link deb.graph.helper.Paths#pathTo(int)}.
	 */
	@Test
	public final void testPathTo() {
		Iterable<Integer> path = paths.pathTo(5);
		assertNotNull(path);
		assertTrue(path.iterator().hasNext());
	}

	@Test
	public final void testIndirectPathTo() {
		setUp();
		assertFalse(paths.hasDirectPathTo(4), "There is no direct path between 0 and 4.");
		assertFalse(paths.hasDirectPathTo(7), "There is no direct path between 0 and 7.");
		assertFalse(paths.hasDirectPathTo(8), "There is no direct path between 0 and 8.");
		assertFalse(paths.hasIndirectPathTo(7), "There is no indirect path between 0 and 7.");
		assertFalse(paths.hasDirectPathTo(8), "There is no direct path between 0 and 8.");
		assertFalse(paths.hasIndirectPathTo(8), "There is no indirect path between 0 and 8.");
		assertTrue(paths.hasIndirectPathTo(4), "There is indirect path between 0 and 4. 0->5->4");
	}

}
