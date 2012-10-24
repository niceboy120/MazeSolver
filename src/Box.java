
public class Box {
	
	private boolean top;
	private boolean right;
	private boolean bottom;
	private boolean left;
	
	public Box(int side1, int side2, int side3, int side4)
	{
		if (side1 == 1)
			top = true;
		else
			top = false;
		if (side2 == 1)
			right = true;
		else
			right = false;
		if (side3 == 1)
			bottom = true;
		else
			bottom = false;
		if (side4 == 1)
			left = true;
		else
			left = false;
	}
	
	public boolean topWall()
	{
		return top;
	}
	
	public boolean rightWall()
	{
		return right;
	}
	
	public boolean bottomWall()
	{
		return bottom;
	}
	
	public boolean leftWall()
	{
		return left;
	}

}
