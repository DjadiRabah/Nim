package view.menu;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.viewliseners.ButtonListener;
import model.Nim;

public class GameMenu extends JPanel 
{
	protected Nim game;
	protected JLabel label;
	public GameMenu(Nim game) 
	{
		this.game = game;
		setLayout(new GridLayout(2,1));
		setPanel(game.getMax());
	}
	
	protected void setPanel(int nbrObjectsLeft)
	{
		JPanel data = new JPanel();
		data.setLayout(new GridLayout(1,1));
		label = new JLabel(nbrObjectsLeft + "");
		label.setHorizontalAlignment((int) JPanel.CENTER_ALIGNMENT);
		data.add(label);
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridLayout(1,3));

		for(int i = 1; i <= 3; i++)
		{
			JButton button = new JButton(i + "");
			button.addActionListener(new ButtonListener(game));
			buttonsPanel.add(button);
		}
		
		add(data);
		add(buttonsPanel);
	}
	
	public void update(int nbrObjectsRemoved)
	{
		label.setText(game.getCurrentMatches() + "");
		repaint();
	}
	

}
