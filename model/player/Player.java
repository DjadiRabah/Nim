package model.player;

import model.Nim;

public abstract class  Player 
{
	protected String name;
	
	public Player(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public abstract void play(Nim game);
}
