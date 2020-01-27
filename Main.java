import model.NimGame;
import model.player.IA;

public class Main {

	public static void main(String[] args) {
		NimGame game = new NimGame(9);
		IA ia1 = new IA(9, game.getMax());
		IA ia2 = new IA(2, game.getMax());
		game.setPlayers(ia1, ia2);
		game.loop();
	}

}
