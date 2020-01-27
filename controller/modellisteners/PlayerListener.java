package controller.modellisteners;

import java.util.EventListener;

public class PlayerListener implements EventListener 
{
	public void hasPlayed(String name, int match)
	{
		System.out.println(name + " a retiré " + match + " allumette(s)");
	}
}

