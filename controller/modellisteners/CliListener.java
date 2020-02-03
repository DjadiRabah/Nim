package controller.modellisteners;

import model.player.Player;

public class CliListener implements GameListener
{
	public void isOver(Player winner)
	{
		System.out.println(winner.getName() + " a gagné");
	}
	
	public void hasPlayed(String name, int matches)
	{
		System.out.println(name + " a retiré " + matches + " allumette(s)");
	}
}
