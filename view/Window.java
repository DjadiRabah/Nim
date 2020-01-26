package view;

import javax.swing.JFrame;

import view.menu.GameMenu;
import view.menu.MainMenu;

public class Window extends JFrame {

	public Window() 
	{
		setTitle("Nim");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1920,1200);
		add(new GameMenu(8));
		
	}

}
