import model.player.IA;
import view.Window;

public class Main 
{

	public static void main(String[] args) 
	{
		IA ia = new IA(4, 10);
		System.out.println(ia.getTree());
		ia.play();
		
		Window window = new Window();
		window.setVisible(true);
	}

}
