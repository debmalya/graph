/**
 * 
 */
package deb.graph.application.model;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author debmalyajash
 */
public class Maze {
	/**
	 * 
	 */
	private static final char EMPTY_SPACE_INDICATOR = ' ';

	/**
	 * 'F' indicates finshing point.
	 */
	private static final char FINISH_INDICATOR = 'F';

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
	public Point getStartingPoint() {
		return startingPoint;
	}

	/**
	 * @return the endPoint
	 */
	public Point getEndPoint() {
		return endPoint;
	}

	/**
	 * @return the mazeBoard
	 */
	public boolean[][] getMazeBoard() {
		return mazeBoard;
	}

	/**
	 * 'S' indicates starting point.
	 */
	private static final char START_INDICATOR = 'S';

	/**
	 * 'X' indicates wall.
	 */
	private static final char WALL_INDICATOR = 'X';

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
	private Point startingPoint;

	/**
	 * End point of Maze.
	 */
	private Point endPoint;

	/**
	 * 
	 */
	private boolean[][] mazeBoard;

	/**
	 * Locations where we have walls.
	 */
	private Set<Point> wallLocations = new HashSet<Point>();

	/**
	 * Locations where we have empty spaces.
	 */
	private Set<Point> emptySpaces = new HashSet<Point>();

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

		mazeBoard = new boolean[height][width];

		for (int x = 0; x < height; x++) {
			for (int y = 0; y < width; y++) {
				if (mazeDescription[x].charAt(y) == WALL_INDICATOR) {
					// there is wall 'X'.
					wallLocations.add(new Point(x, y));
				} else if (mazeDescription[x].charAt(y) == START_INDICATOR) {
					// Starting point.
					startingPoint = new Point(x, y);
				} else if (mazeDescription[x].charAt(y) == FINISH_INDICATOR) {
					// end point.
					endPoint = new Point(x, y);
				} else {
					emptySpaces.add(new Point(x, y));
				}
			}

		}

	}

	/**
	 * @return the wallLocations
	 */
	public Set<Point> getWallLocations() {
		return wallLocations;
	}

	/**
	 * @return the emptySpaces
	 */
	public Set<Point> getEmptySpaces() {
		return emptySpaces;
	}

	/**
	 * 
	 * @param x
	 *            x coordinate
	 * @param y
	 *            y coordinate
	 * @return X - wall. ' ' - free space S - starting point F - end point
	 */
	public char whatExists(int x, int y) {
		Point askingPoint = new Point(x, y);
		if (wallLocations.contains(askingPoint)) {
			return WALL_INDICATOR;
		} else if (askingPoint.equals(startingPoint)) {
			return START_INDICATOR;
		} else if (endPoint.equals(startingPoint)) {
			return FINISH_INDICATOR;
		}
		return EMPTY_SPACE_INDICATOR;
	}

}
