

##MazeSolver
```java
public MazeSolver(Maze maze)
```
The MazeSolver constructor.
 
Determines the size of solution and visited tables, and
records the Maze properties.

**params**

* `solution` - A representation of the maze that records previous successful moves.
* `visited` - A 2D representation of the map where previous moves have been recorded.

##None
```java
private int[] findRoute(int[] newLocation, int priority)
```
Find the best next move given current position
and priority of move.
 
Each move query consists of a boundary test, a test to compare 
if previously travelled to the locations, and a test to 
determine priority should all other options be exhausted.

**params**

* `visited` - A 2D representation of the map where previous moves have been recorded.
* `priority` - Increments if no route found to unlock more options for movement.
**returns** newLocation	coordinate of next move.


##printDouble
```java
void printDouble(int[][] map)
```
Prints the double arrays used to represent the MAZE space.
 
Function checks beginning and ending constrains, overlaying
these landmarks with the printout for reference. It also
displays the walls of the maze.


##MAZE;
`final Maze MAZE;`
Primary MAZE object.


##solution;
`int[][] solution;`
Tracks MAZE solution.


##visited;
`private int[][] visited;`
Tracks visited areas of MAZE.


##location;
`private int[] location;`
Tracks current position in MAZE.


