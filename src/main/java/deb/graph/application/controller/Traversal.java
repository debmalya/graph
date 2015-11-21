/**
 * 
 */
package deb.graph.application.controller;

import deb.graph.application.model.MazePoint;

/**
 * @author 
 *
 */
public class Traversal {
	/**
	 * Current maze position
	 */
//	private Maze maze;
	
	/**
	 * Current maze board position.
	 */
	private MazePoint currentPosition;
	/**
	 * Path from starting point
	 */
	private StringBuilder pathFromStartingPoint = new StringBuilder();
	
	/**
	 * @return the pathFromStartingPoint
	 */
	public StringBuilder getPathFromStartingPoint() {
		return pathFromStartingPoint;
	}
	/**
	 * @param pathFromStartingPoint the pathFromStartingPoint to set
	 */
	public void setPathFromStartingPoint(StringBuilder pathFromStartingPoint) {
		this.pathFromStartingPoint = pathFromStartingPoint;
	}
	/**
	 * @return the currentPosition
	 */
	public MazePoint getCurrentPosition() {
		return currentPosition;
	}
	/**
	 * @param currentPosition the currentPosition to set
	 */
	public void setCurrentPosition(MazePoint currentPosition) {
		this.currentPosition = currentPosition;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		return getPathFromStartingPoint().toString();
	}
	
	
	
}
