package view.menu;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MainMenu extends JPanel {

	public MainMenu() 
	{
		setLayout(new GridLayout(2,1));
		add(new JButton("Jouer"));
		add(new JButton("Quitter"));	
	}

}
