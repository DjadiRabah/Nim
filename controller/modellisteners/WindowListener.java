package controller.modellisteners;

import model.player.Player;
import view.menu.GameMenu;

public class WindowListener implements GameListener 
{
	protected GameMenu menu;
	public WindowListener(GameMenu menu)
	{
		this.menu = menu;
	}
	@Override
	public void isOver(Player winner) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void hasPlayed(String name, int matches) 
	{
		menu.update(matches);		
	}
	
}
