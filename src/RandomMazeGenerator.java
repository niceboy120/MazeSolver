import java.util.*;


public class RandomMazeGenerator {
	
	public static Box[][] generateMaze()
	{
		Random generator = new Random();
		Scanner in = new Scanner(System.in);
		System.out.println("How many rows should the maze have?");
		int rows = in.nextInt();
		System.out.println("How many columns should the maze have?");
		int columns = in.nextInt();
		System.out.println("");
		
		Box[][] matrix = new Box[rows][columns];
		
		matrix[0][0] = new Box(1, 0, 0, 1);
		
		for (int n = 1; n < columns-1; n++)
		{
			int top = 1;
			int right = generator.nextInt(2);
			int bottom = generator.nextInt(2);
			int left;
			if (matrix[0][n-1].rightWall())
				left = 1;
			else
				left = 0;
			matrix[0][n] = new Box(top, right, bottom, left);
		}
		
		int tempBottom = generator.nextInt(2);
		int tempLeft;
		if (matrix[0][matrix[0].length-2].rightWall())
			tempLeft = 1;
		else
			tempLeft = 0;
		matrix[0][matrix[0].length-1] = new Box(1, 1, tempBottom, tempLeft);
		
		for (int i = 1; i < rows-1; i++)
		{
			int top1;
			if (matrix[i-1][0].bottomWall())
				top1 = 1;
			else
				top1 = 0;
			int right1 = generator.nextInt(2);
			int bottom1 = generator.nextInt(2);
			int left1 = 1;
			matrix[i][0] = new Box(top1, right1, bottom1, left1);
			for (int n = 1; n < columns-1; n++)
			{
				int top2;
				if (matrix[i-1][n].bottomWall())
					top2 = 1;
				else
					top2 = 0;
				int right2 = generator.nextInt(2);
				int bottom2 = generator.nextInt(2);
				int left2;
				if (matrix[i][n-1].rightWall())
					left2 = 1;
				else
					left2 = 0;
				matrix[i][n] = new Box(top2, right2, bottom2, left2);
			}
			
			int tempBottom1 = generator.nextInt(2);
			int tempLeft1;
			if (matrix[i][matrix[i].length-2].rightWall())
				tempLeft1 = 1;
			else
				tempLeft1 = 0;
			matrix[i][matrix[i].length-1] = new Box(1, 1, tempBottom1, tempLeft1);
		}
		
		int top3;
		if (matrix[rows-2][0].bottomWall())
			top3 = 1;
		else
			top3 = 0;
		int right3 = generator.nextInt(2);
		matrix[rows-1][0] = new Box(top3, right3, 1, 1);
		
		for (int n = 1; n < columns-1; n++)
		{
			int top4;
			if (matrix[rows-2][n].bottomWall())
				top4 = 1;
			else
				top4 = 0;
			int right4 = generator.nextInt(2);
			int left4;
			if (matrix[rows-1][n-1].rightWall())
				left4 = 1;
			else
				left4 = 0;
			matrix[rows-1][n] = new Box(top4, right4, 1, left4);
		}
		
		int tempTop2;
		if (matrix[rows-2][columns-1].bottomWall())
			tempTop2 = 1;
		else
			tempTop2 = 0;
		int tempLeft2;
		if (matrix[rows-1][columns-2].rightWall())
			tempLeft2 = 1;
		else
			tempLeft2 = 0;
		matrix[rows-1][columns-1] = new Box(tempTop2, 1, 1, tempLeft2);
		
		return matrix;
	}

}
