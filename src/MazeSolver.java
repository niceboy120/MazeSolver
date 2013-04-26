import java.io.*;
import java.util.Scanner;


public class MazeSolver {
	
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner in = new Scanner(System.in);
		System.out.println("How many rows are in the maze?");
		int rows = in.nextInt();
		System.out.println("How many columns are in the maze?");
		int columns = in.nextInt();
		System.out.println("");
		File file = new File("/users/bestja/documents/E - Data Structures/maze.txt");
		in = new Scanner(file);
		
		Box[][] matrix = new Box[rows][columns];
		for (int i = 0; i < rows; i++)
			for (int n = 0; n < columns; n++)
			{
				int top = in.nextInt();
				int right = in.nextInt();
				int bottom = in.nextInt();
				int left = in.nextInt();
				matrix[i][n] = new Box(top, right, bottom, left);
			}
		
		Maze maze = new Maze(matrix);
		boolean solvable = maze.solveMaze();
		if (solvable)
			System.out.print(maze.giveSolution());
		else
			System.out.print("This maze has no solution!");
	}

}
