/**
 * 
 */
package deb.graph.application.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class MazeTest {

	/**
	 * Test method for {@link model.Maze#Maze(java.lang.String[])}.
	 */
	@Test
	public final void testMaze() {
		String[] mazeBoard = new String[] { 
				"XXXXXXXXXXXXXXX",
				"X             X", 
				"X XXXXXXXXXXX X",
				"X XS        X X",
				"X XXXXXXXXX X X",
				"X XXXXXXXXX X X",
				"X XXXX      X X",
				"X XXXX XXXX X X",
				"X XXXX XXXX X X",
				"X X    XXXXXX X",
				"X X XXXXXXXXX X",
				"X X XXXXXXXXX X",
				"X X         X X",
				"X XXXXXXXXX   X",
				"XFXXXXXXXXXXXXX"
				};
		Maze maze = new Maze(mazeBoard);
		
		// Test for starting point
		Assert.assertEquals(3, (int)maze.getStartingPoint().getX());
		Assert.assertEquals(3, (int)maze.getStartingPoint().getY());
		
		// Test for end point
		Assert.assertEquals(14, (int)maze.getEndPoint().getX());
		Assert.assertEquals(1, (int)maze.getEndPoint().getY());
		
		Assert.assertEquals(15, maze.getHeight());
		Assert.assertEquals(15, maze.getWidth());
		
		// get walls
		Assert.assertNotNull(maze.getWallLocations());
		Assert.assertEquals(maze.getHeight()*maze.getWidth(), maze.getWallLocations().size()+maze.getEmptySpaces().size()+2);
		
		
		
	}


}
