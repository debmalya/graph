/**
 * 
 */
package deb.graph.application.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import deb.graph.application.model.Maze;
import deb.graph.application.model.MazePoint;

/**
 * @author debmalyajash
 *
 */
public class MazeExplorerTest {

	/**
	 * Test method for {@link deb.graph.application.controller.MazeExplorer#explore()}.
	 */
	@Test
	public final void testExplore() {
		 Maze maze = new Maze(new String[]{"XXXX", "XS  ", "XXXF"});

	        // test whether maze populated correctly or not.
	        MazePoint point = maze.getMazeBoard()[0][0];
	        assertEquals('X', point.getValue());
	        assertNull(point.getLeft());

	        assertNotNull(point.getRight());
	        assertEquals('X', point.getRight().getValue());

	        assertNotNull(point.getForward());
	        assertEquals('X', point.getForward().getValue());

	        assertNull(point.getBackWard());
	        
	        
	        point = maze.getMazeBoard()[1][2];
	        assertEquals(' ', point.getValue());
	        
	        
	        point = maze.getMazeBoard()[1][1];
	        
	        assertEquals('S', point.getValue());
	        assertNotNull(point.getLeft());
	        assertEquals('X',point.getLeft().getValue());
	        
	        assertNotNull(point.getBackWard());
	        assertEquals('X',point.getBackWard().getValue());
	        
	        assertNotNull(point.getRight());
	        
	        assertEquals(' ',point.getRight().getValue());
	        
	        assertNotNull(point.getForward());
	        assertEquals('X',point.getBackWard().getValue());

	        MazeExplorer explorer = new MazeExplorer(maze);
	        explorer.explore();
	       
	        assertEquals("RRF", explorer.getPossiblePaths().get(0));
	        assertEquals("RRF", explorer.getSuccessfulPaths().get(0));
	}

}
