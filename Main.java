import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.modellisteners.CliListener;
import controller.modellisteners.WindowListener;
import model.Nim;
import model.player.Human;
import model.player.IA;
import model.player.Player;
import view.Window;
import view.menu.GameMenu;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Nim game = new Nim(500);

		Player player1 = new IA("Joueur", 10, game.getMax());
		Player player2 = new IA("Bob", 8, game.getMax());
		
		game.setPlayers(player1, player2);
		game.addListener(new CliListener());
		
		JPanel info = new JPanel();
		info.add(new JLabel("info"));
		GameMenu menu = new GameMenu(game);
		game.addListener(new WindowListener(menu));
		
		
		Window window = new Window(game, info, menu, info);
		window.setVisible(true);
		
		while (!game.isOver())
		{	
			if (!game.isOver())
			{
				player1.play(game);
			}
			if (!game.isOver())
			{
				player2.play(game);
			}
		}
	}

}
