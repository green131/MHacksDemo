package src;

/**
 * @author      Daniel Green		<green131@purdue.edu>
 * @version     1.0
 * @since       2015-01-18
 */
 
public class SampleMaze {
	
	/**
	 * Define X,Y coordinates of starting point
	 */
	static int[] startPoint = {0, 0};
	
	/**
	 * Define X,Y coordinates of ending point
	 */
	static int[] endPoint = {5, 0};
	
	/**
	 * The integer representation of the maze to solve
	 */
	static int[][] maze = {
			{0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1, 0},
			{0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1},
			{0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
			{1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0},
			{0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
			{0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1},
			{0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}
			};
	
	/**
	 * Constructor statement to build maze object
	 */
	final static Maze MAZE = new Maze(maze, startPoint, endPoint);
}