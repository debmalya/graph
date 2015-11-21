/**
 * 
 */
package deb.graph.application.controller;

import org.junit.Assert;
import org.junit.Test;

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
	        Assert.assertEquals('X', point.getValue());
	        Assert.assertNull(point.getLeft());

	        Assert.assertNotNull(point.getRight());
	        Assert.assertEquals('X', point.getRight().getValue());

	        Assert.assertNotNull(point.getForward());
	        Assert.assertEquals('X', point.getForward().getValue());

	        Assert.assertNull(point.getBackWard());
	        
	        
	        point = maze.getMazeBoard()[1][2];
	        Assert.assertEquals(' ', point.getValue());
	        
	        
	        point = maze.getMazeBoard()[1][1];
	        
	        Assert.assertEquals('S', point.getValue());
	        Assert.assertNotNull(point.getLeft());
	        Assert.assertEquals('X',point.getLeft().getValue());
	        
	        Assert.assertNotNull(point.getBackWard());
	        Assert.assertEquals('X',point.getBackWard().getValue());
	        
	        Assert.assertNotNull(point.getRight());
	        
	        Assert.assertEquals(' ',point.getRight().getValue());
	        
	        Assert.assertNotNull(point.getForward());
	        Assert.assertEquals('X',point.getBackWard().getValue());

	        MazeExplorer explorer = new MazeExplorer(maze);
	        explorer.explore();
	       
	        Assert.assertEquals("RRF", explorer.getPossiblePaths().get(0));
	        Assert.assertEquals("RRF", explorer.getSuccessfulPaths().get(0));
	}

}
