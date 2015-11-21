/**
 * 
 */
package deb.graph.application.model;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 *
 */
public class Maze {
	
	/**
	 * Empty space indicator
	 */
	public static final char EMPTY_SPACE = ' ';

	/**
	 * 'F' indicates finishing point.
	 */
	public static final char FINISH_INDICATOR = 'F';

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @return the startingPoint
	 */
	public MazePoint getStartingPoint() {
		return startingPoint;
	}

	/**
	 * @return the endPoint
	 */
	public MazePoint getEndPoint() {
		return endPoint;
	}

	/**
	 * @return the mazeBoard
	 */
	public MazePoint[][] getMazeBoard() {
		return mazeBoard;
	}

	/**
	 * 'S' indicates starting point.
	 */
	public static final char START_INDICATOR = 'S';

	/**
	 * 'X' indicates wall.
	 */
	public static final char WALL_INDICATOR = 'X';

	/**
	 * Width of Maze.
	 */
	private int width;

	/**
	 * Height of Maze.
	 */
	private int height;

	/**
	 * Starting point of Maze
	 */
	private MazePoint startingPoint;

	/**
	 * End point of Maze.
	 */
	private MazePoint endPoint;

	/**
	 * 
	 */
	private MazePoint[][] mazeBoard;

	/**
	 * Locations where we have walls.
	 */
	private Set<MazePoint> wallLocations = new HashSet<>();

	/**
	 * Locations where we have empty spaces.
	 */
	private Set<MazePoint> emptySpaces = new HashSet<>();

	/**
	 * This method will process the passed string and determine. Wall location.
	 * Starting point. End Point.
	 * 
	 * @param mazeDescription
	 *            will describe the maze. Sample can be contents of Maze
	 * 
	 * 
	 */
	public Maze(final String[] mazeDescription) {
		height = mazeDescription.length;
		width = mazeDescription[0].length();

		mazeBoard = new MazePoint[height][width];

		for (int x = 0; x < height; x++) {
			for (int y = 0; y < width; y++) {
				char c = mazeDescription[x].charAt(y);

				MazePoint point = new MazePoint(x, y, c);
				mazeBoard[x][y] = point;

				if (c == WALL_INDICATOR) {
					// there is wall 'X'.
					wallLocations.add(point);
				} else if (c == START_INDICATOR) {
					// Starting point.
					startingPoint = point;
				} else if (mazeDescription[x].charAt(y) == FINISH_INDICATOR) {
					// end point.
					endPoint = point;
				} else {
					emptySpaces.add(point);
				}

				// update left,right neighbor.
				// later this will be used for left right motion.
				if (x - 1 > -1) {
					// current one is at right side of it.
					mazeBoard[x - 1][y].setForward(mazeBoard[x][y]);
					// setting left neighbor of current one.
					mazeBoard[x][y].setBackWard(mazeBoard[x - 1][y]);
				}

				// update up,neighbor.
				// later it will be used for backward and forward motion
				if (y - 1 > -1) {
					// current one is at beneath it.
					mazeBoard[x][y - 1].setRight(mazeBoard[x][y]);
					// in backward motion from current where it will reach
					mazeBoard[x][y].setLeft(mazeBoard[x][y - 1]);
				}

			}

		}

	}

	/**
	 * @return the wallLocations
	 */
	public Set<MazePoint> getWallLocations() {
		return wallLocations;
	}

	/**
	 * @return the emptySpaces
	 */
	public Set<MazePoint> getEmptySpaces() {
		return emptySpaces;
	}

	/**
	 * What exists in the said location. is it wall ? is it free space? is it
	 * starting point? it it finishing point?
	 * 
	 * To answer all these questions.
	 * 
	 * @param x
	 *            x coordinate
	 * @param y
	 *            y coordinate
	 * @return X - wall. ' ' - free space S - starting point F - end point
	 */
	public char whatExists(int x, int y) {

		return mazeBoard[x][y].getValue();
	}

}
