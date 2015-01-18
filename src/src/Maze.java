package src;

/**
 * @author      Daniel Green		<green131@purdue.edu>
 * @version     2.0
 * @since       2015-01-18
 */

public class Maze {
	/**
	 * Maze array.
	 */
	int[][] maze;

	/**
	 * Beginning point of maze.
	 */
	final int[] STARTPOINT;
	
	/**
	 * Ending point of maze.
	 */
	int[] ENDPOINT;

	/**
	 * Height of maze.
	 */
	final int MAZEHEIGHT;
	
	/**
	 * Length of maze.
	 */
	final int MAZELENGTH;

	/**
	 * An object class representing the maze.
	 *
	 * @param	maze		A 2D representation of a maze.
	 * @param	MAZEHEIGHT	The height of the coordinate maze.
	 * @param	MAZELENGTH	The length of the coordinate maze.
	 * @param	STARTPOINT	The coordinates of the starting location.
	 * @param	ENDPOINT	The coordinates of the starting location.
	 */
	public Maze(int[][] maze, int[] startPoint, int[] endPoint) {
		this.maze = maze;
		this.MAZEHEIGHT = maze.length;
		this.MAZELENGTH = maze[0].length;
		this.STARTPOINT = startPoint;
		this.ENDPOINT = endPoint;
	}

	/**
	 * Return X-coordinate of starting point.
	 */
	int getStartX() {
		return STARTPOINT[0];
	}

	/**
	 * Return Y-coordinate of starting point.
	 */
	int getStartY() {
		return STARTPOINT[1];
	}

	/**
	 * Return X-coordinate of ending point.
	 */
	int getEndX() {
		return ENDPOINT[0];
	}

	/**
	 * Return Y-coordinate of ending point.
	 */
	int getEndY() {
		return ENDPOINT[1];
	}

}
