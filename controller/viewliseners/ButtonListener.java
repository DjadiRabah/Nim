package controller.viewliseners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Nim;


public class ButtonListener implements ActionListener
{
	protected Nim game;
	
	public ButtonListener(Nim game)
	{
		this.game = game;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(!game.isOver())
		{
			String text = e.getActionCommand();
			int value = Integer.valueOf(text);
			game.play(game.getCurrentPlayer(), value);
		}
	}
}
