import java.util.ArrayList;


public class Maze {
	
	private Box[][] maze;
	private ArrayList<Location> path;
	
	public Maze(Box[][] mazeStructure)
	{
		maze = mazeStructure;
		path = new ArrayList<Location>();
	}
	
	public boolean solveMaze()
	{
		return solveMaze(0, 0, 0);
	}
	
	private boolean solveMaze(int currentY, int currentX, int currentDirection)
	{
		path.add(new Location(currentX, currentY));
		if (currentY == maze.length-1 && currentX == maze[0].length-1)
			return true;
		else if (currentY == 0 && currentX == 0 && currentDirection == 3)
			return false;
		else
		{
			if (currentDirection == 0)
			{
				if (maze[currentY][currentX].leftWall() == false)
					return solveMaze(currentY, currentX-1, 3);
				else if (maze[currentY][currentX].bottomWall() == false)
					return solveMaze(currentY+1, currentX, 0);
				else if (maze[currentY][currentX].rightWall() == false)
					return solveMaze(currentY, currentX+1, 1);
				else
					return solveMaze(currentY-1, currentX, 2);
			}
			
			else if (currentDirection == 1)
			{
				if (maze[currentY][currentX].bottomWall() == false)
					return solveMaze(currentY+1, currentX, 0);
				else if (maze[currentY][currentX].rightWall() == false)
					return solveMaze(currentY, currentX+1, 1);
				else if (maze[currentY][currentX].topWall() == false)
					return solveMaze(currentY-1, currentX, 2);
				else
					return solveMaze(currentY, currentX-1, 3);
			}
			
			else if (currentDirection == 2)
			{
				if (maze[currentY][currentX].rightWall() == false)
					return solveMaze(currentY, currentX+1, 1);
				else if (maze[currentY][currentX].topWall() == false)
					return solveMaze(currentY-1, currentX, 2);
				else if (maze[currentY][currentX].leftWall() == false)
					return solveMaze(currentY, currentX-1, 3);
				else
					return solveMaze(currentY+1, currentX, 0);
			}
			
			else
			{
				if (maze[currentY][currentX].topWall() == false)
					return solveMaze(currentY-1, currentX, 2);
				else if (maze[currentY][currentX].leftWall() == false)
					return solveMaze(currentY, currentX-1, 3);
				else if (maze[currentY][currentX].bottomWall() == false)
					return solveMaze(currentY+1, currentX, 0);
				else
					return solveMaze(currentY, currentX+1, 1);
			}
			
		}
	}
	
	public String giveSolution()
	{
		simplifyPath();
		String solution = "";
		for (int i = 1; i < path.size()-1; i++)
			solution += (path.get(i-1).directionTo(path.get(i))) + ", ";
		return "To solve the maze, just go " + solution + "and finally " + path.get(path.size()-2).directionTo(path.get(path.size()-1)) + ". ";
	}
	
	private void simplifyPath()
	{
		int i = 0;
		while(i < path.size()-1)
		{
			boolean returnToSameLocation = false;
			int j = i+1;
			while (j < path.size() && !returnToSameLocation)
			{
				if (path.get(i).equals(path.get(j)))
					returnToSameLocation = true;
				j++;
			}
			if (returnToSameLocation)
			{
				for (int n = i+1; n < j; j--)
					path.remove(n);
			}
			i++;
		}
	}
}
