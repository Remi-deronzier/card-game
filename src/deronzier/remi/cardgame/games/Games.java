package deronzier.remi.cardgame.games;

import deronzier.remi.cardgame.controller.GameController;
import deronzier.remi.cardgame.model.DeckFactory;
import deronzier.remi.cardgame.model.DeckFactory.DeckType;
import deronzier.remi.cardgame.view.GameSwingPassiveView;
import deronzier.remi.cardgame.view.GameSwingView;
import deronzier.remi.cardgame.view.GameViewables;

public class Games {

	public static void main(String[] args) {
		GameViewables views = new GameViewables();

		GameSwingView gsv = new GameSwingView();
		gsv.createAndShowGUI();
		views.addViewables(gsv);

		for (int i = 0; i < 3; i++) {
			GameSwingPassiveView passiveView = new GameSwingPassiveView();
			passiveView.createAndShowGUI();

			views.addViewables(passiveView);

			try {
				Thread.sleep(2500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		GameController gc = new GameController(DeckFactory.makeDeck(DeckType.Normal), views,
				new HighCardGameEvaluator());
		gc.run();
	}
}
