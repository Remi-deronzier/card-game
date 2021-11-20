package deronzier.remi.cardgame.games;

import java.util.List;

import deronzier.remi.cardgame.model.IPlayer;

public interface GameEvaluator {
	public IPlayer evaluateWinner(List<IPlayer> players);
}
