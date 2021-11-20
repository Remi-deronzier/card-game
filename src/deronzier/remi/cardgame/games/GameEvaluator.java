package deronzier.remi.cardgame.games;

import java.util.List;

import deronzier.remi.cardgame.model.Player;

public interface GameEvaluator {
	public Player evaluateWinner(List<Player> players);
}
