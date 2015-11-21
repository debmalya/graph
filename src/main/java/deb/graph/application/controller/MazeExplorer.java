/**
 * 
 */
package deb.graph.application.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import deb.graph.application.model.Maze;
import deb.graph.application.model.MazePoint;

/**
 * @author
 * 
 *         Purpose of this class to fulfill following requirement.
 * 
 *         Given a maze the explorer should be able to drop in to the Start
 *         point.
 * 
 *         An explorer on a maze must be able to: Move forward Turn left and
 *         right Understand what is in front of them Understand all movement
 *         options from their given location Have a record of where they have
 *         been Once an explorer has exited a maze they must be able to state
 *         the route they took in an understandable fashion.
 * 
 */
public class MazeExplorer {

	/**
	 * Move right
	 */
	private static final String MOVE_RIGHT = "R";

	/**
	 * Move left
	 */
	private static final String MOVE_LEFT = "L";

	/**
	 * Move upwards.
	 */
	private static final String MOVE_UP = "U";

	/**
	 * Move forward
	 */
	private static final String MOVE_FORWARD = "F";

	/*
	 * This value will be true, if able to reach the finish point.
	 */
	private boolean done = false;

	private Stack<Traversal> combinations = new Stack<>();

	private List<String> possiblePaths = new ArrayList<String>();

	/**
	 * @return the possiblePaths
	 */
	public List<String> getPossiblePaths() {
		return possiblePaths;
	}

	/**
	 * @return the successfulPaths
	 */
	public List<String> getSuccessfulPaths() {
		return successfulPaths;
	}

	private List<String> successfulPaths = new ArrayList<String>();

	private Maze mazeBoard;

	/**
	 * After getting this maze, explorer will start from starting point.
	 * 
	 * @param maze
	 *            - Initialized maze.
	 */
	public MazeExplorer(Maze maze) {
		mazeBoard = maze;
	}

	public void explore() {
		start(mazeBoard.getStartingPoint());

		while (!done) {
			if (!combinations.isEmpty()) {

				Traversal traversal = combinations.pop();

				moveLeft(traversal.getCurrentPosition(), traversal);
				moveRight(traversal.getCurrentPosition(), traversal);
				moveUp(traversal.getCurrentPosition(), traversal);
				moveForward(traversal.getCurrentPosition(), traversal);

			} else {
				// no more possible ways left.
				// Finished exploration.
				break;
			}
		}
	}

	/**
	 * @param startingPoint
	 */
	private void start(MazePoint startingPoint) {
		moveLeft(startingPoint, new Traversal());
		moveRight(startingPoint, new Traversal());
		moveUp(startingPoint, new Traversal());
		moveForward(startingPoint, new Traversal());

	}

	/**
	 * @param startingPoint
	 * @param traversal
	 */
	private void moveForward(MazePoint currentPoint, Traversal traversal) {
		if (currentPoint.getForward() == null) {
			//
			possiblePaths.add(traversal.getPathFromStartingPoint().toString());
		} else {

			if (currentPoint.getForward().getValue() == Maze.EMPTY_SPACE
					&& !currentPoint.getForward().isVisited()) {

				traversal.setPathFromStartingPoint(traversal
						.getPathFromStartingPoint().append(MOVE_FORWARD));
				combinations.push(traversal);
				traversal.setCurrentPosition(currentPoint.getForward());

			} else if (currentPoint.getForward().getValue() == Maze.FINISH_INDICATOR
					&& !currentPoint.getForward().isVisited()) {
				traversal.setPathFromStartingPoint(traversal
						.getPathFromStartingPoint().append(MOVE_FORWARD));

				done = true;
				successfulPaths.add(traversal.getPathFromStartingPoint()
						.toString());
				possiblePaths.add(traversal.getPathFromStartingPoint()
						.toString());

			} else if (currentPoint.getForward().getValue() == Maze.WALL_INDICATOR
					&& !currentPoint.isVisited()) {

				
				
				if (traversal.getPathFromStartingPoint().length() > 0)
					possiblePaths.add(traversal.getPathFromStartingPoint()
							.toString());

			}
			currentPoint.getForward().setVisited(true);


		}

	}

	/**
	 * @param startingPoint
	 * @param traversal
	 */
	private void moveUp(MazePoint currentPoint, Traversal traversal) {
		if (currentPoint.getBackWard() == null) {
			//
			possiblePaths.add(traversal.getPathFromStartingPoint().toString());
		} else {

			if (currentPoint.getBackWard().getValue() == Maze.EMPTY_SPACE
					&& !currentPoint.isVisited()) {

				traversal.setPathFromStartingPoint(traversal
						.getPathFromStartingPoint().append(MOVE_UP));

				traversal.setCurrentPosition(currentPoint.getBackWard());
				combinations.push(traversal);

			} else if (currentPoint.getBackWard().getValue() == Maze.FINISH_INDICATOR
					&& !currentPoint.isVisited()) {
				traversal.setPathFromStartingPoint(traversal
						.getPathFromStartingPoint().append(MOVE_UP));
				done = true;
				successfulPaths.add(traversal.getPathFromStartingPoint()
						.toString());
				possiblePaths.add(traversal.getPathFromStartingPoint()
						.toString());

			} else if (currentPoint.getBackWard().getValue() == Maze.WALL_INDICATOR
					&& !currentPoint.isVisited()) {

				if (traversal.getPathFromStartingPoint().length() > 0)
					possiblePaths.add(traversal.getPathFromStartingPoint()
							.toString());

			}
			currentPoint.getBackWard().setVisited(true);

		}

	}

	/**
	 * @param startingPoint
	 * @param traversal
	 */
	private void moveRight(MazePoint currentPoint, Traversal traversal) {
		if (currentPoint.getRight() == null) {
			//
			possiblePaths.add(traversal.getPathFromStartingPoint().toString());
		} else {

			if (currentPoint.getRight().getValue() == Maze.EMPTY_SPACE
					&& !currentPoint.getRight().isVisited()) {

				traversal.setPathFromStartingPoint(traversal
						.getPathFromStartingPoint().append(MOVE_RIGHT));
				combinations.push(traversal);
				traversal.setCurrentPosition(currentPoint.getRight());

			} else if (currentPoint.getRight().getValue() == Maze.FINISH_INDICATOR
					&& !currentPoint.isVisited()) {
				traversal.setPathFromStartingPoint(traversal
						.getPathFromStartingPoint().append(MOVE_RIGHT));
				done = true;
				successfulPaths.add(traversal.getPathFromStartingPoint()
						.toString());
				possiblePaths.add(traversal.getPathFromStartingPoint()
						.toString());

			} else if (currentPoint.getRight().getValue() == Maze.WALL_INDICATOR
					&& !currentPoint.isVisited()) {

				if (traversal.getPathFromStartingPoint().length() > 0)
					possiblePaths.add(traversal.getPathFromStartingPoint()
							.toString());

			}
			currentPoint.getRight().setVisited(true);

		}

	}

	/**
	 * @param currentPoint
	 */
	private void moveLeft(MazePoint currentPoint, Traversal traversal) {

		if (currentPoint.getLeft() == null) {
			//
			possiblePaths.add(traversal.getPathFromStartingPoint().toString());
		} else {

			if (currentPoint.getLeft().getValue() == Maze.EMPTY_SPACE
					&& !currentPoint.isVisited()) {

				traversal.setPathFromStartingPoint(traversal
						.getPathFromStartingPoint().append(MOVE_LEFT));
				combinations.push(traversal);
				traversal.setCurrentPosition(currentPoint.getLeft());

			} else if (currentPoint.getLeft().getValue() == Maze.FINISH_INDICATOR
					&& !currentPoint.isVisited()) {
				traversal.setPathFromStartingPoint(traversal
						.getPathFromStartingPoint().append(MOVE_LEFT));
				done = true;
				successfulPaths.add(traversal.getPathFromStartingPoint()
						.toString());
				possiblePaths.add(traversal.getPathFromStartingPoint()
						.toString());

			} else if (currentPoint.getLeft().getValue() == Maze.WALL_INDICATOR
					&& !currentPoint.isVisited()) {

				if (traversal.getPathFromStartingPoint().length() > 0)
					possiblePaths.add(traversal.getPathFromStartingPoint()
							.toString());

			}
			currentPoint.getLeft().setVisited(true);

			// traversal.setMaze(mazeBoard);

		}

	}

}
