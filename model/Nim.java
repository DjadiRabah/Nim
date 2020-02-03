package model;

import java.util.ArrayList;
import java.util.List;

import controller.modellisteners.GameListener;
import model.player.IA;
import model.player.Player;

public class Nim 
{
	protected int currentPlayer;
	protected List<Player> players;
	protected int maxN;
	protected int currentN;
	protected List<GameListener> listeners;
	
	public Nim(int n) 
	{
		maxN = n;
		currentN = n;
		listeners = new ArrayList<>();
		currentPlayer = 0;
		players = new ArrayList<>();
	}
	
	public void setPlayers(Player player1, Player player2)
	{
		players.add(player1);
		players.add(player2);
	}
	
	public Player getCurrentPlayer()
	{
		return players.get(currentPlayer);
	}
	
	public void addListener(GameListener newListener)
	{
		listeners.add(newListener);
	}
	
	public int getCurrentMatches()
	{
		return currentN;
	}
	
	public int getMax()
	{
		return maxN;
	}
	
	public boolean isOver()
	{
		return currentN == 0;
	}
	
	public boolean isPlayerTurn(Player player)
	{
		return player.equals(getCurrentPlayer());
	}
	
	public void play(Player player, int match)
	{
		if(player.equals(getCurrentPlayer()))
		{
			remove(match);
			for(GameListener listener : listeners)
			{
				listener.hasPlayed(player.getName(), match);
			}
			
			if (currentPlayer == 0)
				currentPlayer = 1;
			else
				currentPlayer = 0;
			
			if(isOver())
			{
				for(GameListener listener : listeners)
				{
					listener.isOver(getCurrentPlayer());
				}
			}
		}
	}
	
	private void remove(int p)
	{
		if (p > currentN)
			currentN = 0;
		else
			currentN = currentN - p;
	}
}
