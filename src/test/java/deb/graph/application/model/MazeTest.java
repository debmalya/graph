/**
 * 
 */
package deb.graph.application.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

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
		assertEquals(3, (int)maze.getStartingPoint().getX());
		assertEquals(3, (int)maze.getStartingPoint().getY());
		
		// Test for end point
		assertEquals(14, (int)maze.getEndPoint().getX());
		assertEquals(1, (int)maze.getEndPoint().getY());
		
		assertEquals(15, maze.getHeight());
		assertEquals(15, maze.getWidth());
		
		// get walls
		assertNotNull(maze.getWallLocations());
		assertEquals(maze.getHeight()*maze.getWidth(), maze.getWallLocations().size()+maze.getEmptySpaces().size()+2);
		
		
		
	}


}
