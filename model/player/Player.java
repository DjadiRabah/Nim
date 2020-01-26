package model.player;

public abstract class Player 
{
	protected int maxMatches;
	
	public Player(int maxMatches)
	{
		this.maxMatches = maxMatches;
	}
	
	public abstract int play();
}
