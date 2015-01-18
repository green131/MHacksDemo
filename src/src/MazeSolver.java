package src;

/**
 * @author      Daniel Green		<green131@purdue.edu>
 * @version     1.0
 * @since       2015-01-18
 */

public class MazeSolver {
	
	/**
	 * Primary MAZE object.
	 */
	final Maze MAZE;
	
	/**
	 * Tracks MAZE solution.
	 */
	int[][] solution;
	
	/**
	 * Tracks visited areas of MAZE.
	 */
	private int[][] visited;
	
	/**
	 * Tracks current position in MAZE.
	 */
	private int[] location;

	/**
	 * The MazeSolver constructor.
	 * <p>
	 * Determines the size of solution and visited tables, and
	 * records the Maze properties.
	 *
	 * @param	solution	A representation of the maze that records
	 *						previous successful moves.
	 * @param	visited		A 2D representation of the map where
	 *						previous moves have been recorded.
	 */
	public MazeSolver(Maze maze) {
		this.MAZE = maze;
		this.visited = new int[MAZE.MAZEHEIGHT][MAZE.MAZELENGTH];
		this.solution = new int[MAZE.MAZEHEIGHT][MAZE.MAZELENGTH];
		this.location = MAZE.STARTPOINT;
	}

	/**
	 * Find the best next move given current position
	 * and priority of move.
	 * <p>
	 * Each move query consists of a boundary test, a test to compare 
	 * if previously travelled to the locations, and a test to 
	 * determine priority should all other options be exhausted.
	 *
	 * @param	visited		A 2D representation of the map where
	 *						previous moves have been recorded.
	 * @param	priority	Increments if no route found to unlock
	 *						more options for movement.
	 * @return	newLocation	coordinate of next move.
	 */
	private int[] findRoute(int[] newLocation, int priority) {
		if (
				(newLocation[0] < MAZE.MAZEHEIGHT - 1) &&
				(MAZE.maze[newLocation[0] + 1][newLocation[1]] == 0) && 
				(visited[newLocation[0] + 1][newLocation[1]] < priority)) {
			newLocation[0]++;
		} else if (
				(newLocation[0] > 0) &&
				(MAZE.maze[newLocation[0] - 1][newLocation[1]] == 0) && 
				(visited[newLocation[0] - 1][newLocation[1]] < priority)) {
			newLocation[0]--;
		} else if (
				(newLocation[1] < MAZE.MAZELENGTH - 1) &&
				(MAZE.maze[newLocation[0]][newLocation[1] + 1] == 0) && 
				(visited[newLocation[0]][newLocation[1] + 1] < priority)) {
			newLocation[1]++;
		} else if (
				(newLocation[1] > 0) &&
				(MAZE.maze[newLocation[0]][newLocation[1] - 1] == 0) &&
				(visited[newLocation[0]][newLocation[1] - 1] < priority)) {
			newLocation[1]--;
		}
		return newLocation;
	}

	/**
	 * The driver for identifying the next move, tracking priority, and
	 * updating the solution table.
	 * <p>
	 * Finds the next best move while also maintaining a priority
	 * system to identify impossible solutions.
	 *
	 * @param	solution		A representation of the maze that records
	 *							previous successful moves.
	 * @param	priority		Increments if no route found to unlock
	 *							more options for movement.
	 * @throws	Exception		If no untried moves remain.
	 * @return	newLocation		The coordinate of the next location.
	 */
	private int[] findBestOption() throws Exception {
		int[] newLocation = location.clone();
		int priority = 0;
		while (this.location[0] == newLocation[0] && this.location[1] == newLocation[1]) {
			newLocation = findRoute(newLocation, ++priority);
			// Record solution path
			if (solution[newLocation[0]][newLocation[1]] == 0) {
				solution[this.location[0]][this.location[1]] = 1;
			} else {
				solution[this.location[0]][this.location[1]] = 0;
			}
			if (priority > 4) {
				throw new Exception("Puzzle Has No Solution");
			}
		}
		return newLocation;
	}

	/**
	 * Function to solve the MAZE.
	 * <p>
	 * Updates the current MAZE position and tests for MAZE 
	 * completion.
	 * <p>
	 * Sends solution to {@link printDouble} when found.
	 */
	void solve() throws Exception {
		while ((location[0] != MAZE.getEndX()) || (location[1] != MAZE.getEndY())) {
			visited[location[0]][location[1]] += 1;
			this.location = findBestOption();
		}
		System.out.println("---------------------");
		System.out.println("=== Puzzle Solved ===");
		System.out.println("---------------------");
		this.printDouble(solution);
	}

	/**
	 * Prints the double arrays used to represent the MAZE space.
	 * <p>
	 * Function checks beginning and ending constrains, overlaying
	 * these landmarks with the printout for reference. It also
	 * displays the walls of the maze.
	 */
	void printDouble(int[][] map) {
		String ch;
		for (int i=0; i<map.length; i++) {
			for (int j=0; j<map[i].length; j++) {
				if (MAZE.getStartX() == i && MAZE.getStartY() == j) {
					ch = "S";
				} else if (MAZE.getEndX() == i && MAZE.getEndY() == j) {
					ch = "E";
				} else {
					ch = String.valueOf(map[i][j]);
				}
				System.out.print(ch);
			}
			System.out.print('\n');
		}
	}
	
	/**
	 * Solves a 2D maze given a start location and an end location.
	 * <p>
	 * The maze solver is run by calling {@link .solve} on the
	 * available object.
	 *
	 * @see solve() for return.
	 */
	public static void main(String[] args) throws Exception {
		MazeSolver solver = new MazeSolver(SampleMaze.MAZE);
		solver.printDouble(solver.MAZE.maze);
		solver.solve();
	}

}