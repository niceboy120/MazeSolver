
public class Location {
	
	private int x;
	private int y;
	
	public Location(int xLoc, int yLoc)
	{
		x = xLoc;
		y = yLoc;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public boolean equals(Location otherLocation)
	{
		return (x == otherLocation.getX() && y == otherLocation.getY());
	}
	
	public String directionTo(Location other)
	{
		if (x+1 == other.getX())
			return "right";
		else if (x-1 == other.getX())
			return "left";
		else if (y+1 == other.getY())
			return "down";
		else
			return "up";
	}

}
