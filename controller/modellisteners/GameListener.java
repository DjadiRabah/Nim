package controller.modellisteners;

import java.util.EventListener;

import model.player.Player;

public interface GameListener extends EventListener 
{
	public void isOver(Player winner);
	public void hasPlayed(String name, int matches);
}
