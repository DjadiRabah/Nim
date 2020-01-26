package model.player;

public class Human extends Player 
{
	public Human(int maxMatchs) 
	{
		super(maxMatchs);
	}

	@Override
	public int play() {
		return 0;
	}
}
