import java.io.*;


public class RandomMazeSolver {
	
	public static void main(String[] args) throws FileNotFoundException
	{
		Box[][] matrix = RandomMazeGenerator.generateMaze();
		Maze maze = new Maze(matrix);
		boolean solvable = maze.solveMaze();
		if (solvable)
			System.out.print(maze.giveSolution());
		else
			System.out.print("This maze has no solution!");
	}

}
