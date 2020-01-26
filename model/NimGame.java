package model;

import model.player.Player;

public class NimGame 
{
	protected int maxN;
	protected int currentN;
	protected int currentPlayer;
	protected Player[] players;
	
	public NimGame(int n, Player player1, Player player2) 
	{
		maxN = n;
		currentN = n;
		currentPlayer = 0;
		players = new Player[2];
		players[0] = player1;
		players[1] = player2;
	}
	
	public boolean isOver()
	{
		return currentN == 0;
	}
	
	public void remove(int p)
	{
		if (p > currentN)
			currentN = 0;
		else
			currentN = currentN - p;
	}
	
	public void game()
	{
		while(!isOver())
		{
			players[currentPlayer].play();
			if	(!isOver())
			{
				if (currentPlayer == 0)
					currentPlayer = 1;
				else
					currentPlayer = 0;
				
			}
		}
	}
}
