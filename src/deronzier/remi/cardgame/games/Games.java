package deronzier.remi.cardgame.games;

import deronzier.remi.cardgame.controller.GameController;
import deronzier.remi.cardgame.model.Deck;
import deronzier.remi.cardgame.view.GameSwingView;

public class Games {

	public static void main(String[] args) {
		GameSwingView gsv = new GameSwingView();
		gsv.createAndShowGUI();
		GameController gc = new GameController(new Deck(), gsv, new HighCardGameEvaluator());
		gc.run();
	}
}
