package model;

import model.player.IA;
import model.player.Player;

public class NimGame 
{
	protected int maxN;
	protected int currentN;
	protected int currentPlayer;
	protected IA[] players;
	
	public NimGame(int n) 
	{
		maxN = n;
		currentN = n;
		currentPlayer = 0;
		players = new IA[2];
	}
	
	public int getMax()
	{
		return maxN;
	}
	
	public void setPlayers(IA player1, IA player2)
	{
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
	
	public void loop()
	{
		while(!isOver())
		{
			int p = players[currentPlayer].play();
			
			System.out.println("Le joueur " + (currentPlayer + 1) + " a retiré " + p + " allumette(s)");
			remove(p);
			
			if (currentPlayer == 0)
				currentPlayer = 1;
			else
				currentPlayer = 0;
			
			if	(!isOver())
			{
				players[0].removeTrees(p);
				players[0].addDepth();
				
				players[1].removeTrees(p);
				players[1].addDepth();
			}
		}
		System.out.println("Le joueur " + (currentPlayer + 1) + " a gagné !");
	}
}
