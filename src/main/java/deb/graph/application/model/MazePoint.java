/**
 * 
 */
package deb.graph.application.model;

/**
 * @author debmalyajash
 *
 */
public class MazePoint {
	/**
	 * x coordinate
	 */
	private int x;
	/**
	 * y coordinate
	 */
	private int y;
	/**
	 * value it can be any of this 'S',' ','X','F'.
	 */
	private char value;
	/**
	 * WHether this point is visited or not?
	 */
	private boolean visited;
	/**
	 * Neighbor at x , y - 1
	 */
	private MazePoint backWard;
	/**
	 * Neighbor at x , y + 1
	 */
	private MazePoint forward;
	
	/**
	 * Neighbor at x - 1, y
	 */
	private MazePoint left;
	/**
	 * Neighbor at x + 1, y
	 */
	private MazePoint right;

	/**
	 * @param x2
	 * @param y2
	 * @param c
	 */
	public MazePoint(int x2, int y2, char c) {

		x = x2;
		y = y2;
		value = c;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the backWard
	 */
	public MazePoint getBackWard() {
		return backWard;
	}

	/**
	 * @param backWard
	 *            the backWard to set
	 */
	public void setBackWard(MazePoint backWard) {
		this.backWard = backWard;
	}

	/**
	 * @return the forward
	 */
	public MazePoint getForward() {
		return forward;
	}

	/**
	 * @return the value
	 */
	public char getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(char value) {
		this.value = value;
	}

	/**
	 * @param forward
	 *            the forward to set
	 */
	public void setForward(MazePoint forward) {
		this.forward = forward;
	}

	/**
	 * @return the left
	 */
	public MazePoint getLeft() {
		return left;
	}

	/**
	 * @param left
	 *            the left to set
	 */
	public void setLeft(MazePoint left) {
		this.left = left;
	}

	/**
	 * @return the right
	 */
	public MazePoint getRight() {
		return right;
	}

	/**
	 * @param right
	 *            the right to set
	 */
	public void setRight(MazePoint right) {
		this.right = right;
	}

	/**
	 * @return the visited
	 */
	public boolean isVisited() {
		return visited;
	}

	/**
	 * @param visited the visited to set
	 */
	public void setVisited(boolean visited) {
		this.visited = visited;
	}

}
