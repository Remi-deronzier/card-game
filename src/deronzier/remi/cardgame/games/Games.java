package deronzier.remi.cardgame.games;

import deronzier.remi.cardgame.controller.GameController;
import deronzier.remi.cardgame.model.DeckFactory;
import deronzier.remi.cardgame.model.DeckFactory.DeckType;
import deronzier.remi.cardgame.view.GameSwingView;

public class Games {

	public static void main(String[] args) {
		GameSwingView gsv = new GameSwingView();
		gsv.createAndShowGUI();
		GameController gc = new GameController(DeckFactory.makeDeck(DeckType.Normal), gsv, new HighCardGameEvaluator());
		gc.run();
	}
}
