package view.menu;

import java.awt.GridLayout;

import javax.swing.JPanel;

import controller.MatchController;
import view.components.Match;

public class GameMenu extends JPanel 
{
	protected int n;

	public GameMenu(int n) 
	{
		setLayout(new GridLayout(1,n));
		for(int i = 0; i < n; i++)
		{
			Match match = new Match();
			match.addMouseListener(new MatchController());
			add(match);
		}
	}

}
