package view.components;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class Match extends JComponent 
{
	protected boolean chosen;

	public Match() 
	{
		chosen = false;
	}
	
	/**
	 * @return the chosen
	 */
	public boolean isChosen() {
		return chosen;
	}
	
	public void update(boolean chosen)
	{
		this.chosen = chosen;
		repaint();
	}
	
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics newGraphics = g.create();
		
		Color color = null;
		if (chosen)
			color = Color.BLUE;
		else
			color = Color.GRAY;
		
		newGraphics.setColor(color);
		
		newGraphics.fillRect(getWidth() / 4, 0, getWidth() / 2, getHeight());
			
	}

}
