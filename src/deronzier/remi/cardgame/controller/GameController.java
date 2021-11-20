package deronzier.remi.cardgame.controller;

import java.util.ArrayList;
import java.util.List;

import deronzier.remi.cardgame.games.GameEvaluator;
import deronzier.remi.cardgame.model.Deck;
import deronzier.remi.cardgame.model.Player;
import deronzier.remi.cardgame.model.PlayingCard;
import deronzier.remi.cardgame.view.GameViewable;

public class GameController {

	enum GameState {
		AddingPlayers, CardsDealt, WinnerRevealed;
	}

	private Deck deck;
	private List<Player> players;
	private Player winner;
	private GameViewable view;

	private GameState gameState;
	private GameEvaluator evaluator;

	public GameController(Deck deck, GameViewable view, GameEvaluator evaluator) {
		super();
		this.view = view;
		this.deck = deck;
		this.players = new ArrayList<Player>();
		this.gameState = GameState.AddingPlayers;
		view.setController(this);
		this.evaluator = evaluator;
	}

	public void run() {
		while (gameState == GameState.AddingPlayers) {
			view.promptForPlayerName();
		}

		switch (gameState) {
		case CardsDealt:
			view.promptForFlip();
			break;
		case WinnerRevealed:
			view.promptForNewGame();
			break;
		default:
			break;
		}
	}

	public void addPlayer(String playerName) {
		if (gameState == GameState.AddingPlayers) {
			players.add(new Player(playerName));
			view.showPlayerName(players.size(), playerName);
		}
	}

	public void startGame() {
		if (gameState != GameState.CardsDealt) {
			deck.shuffle();
			int playerIndex = 1;
			for (Player player : players) {
				player.addCardToHand(deck.returnTopCard());
				view.showFaceDownCardForPlayer(playerIndex++, player.getName());
			}
			gameState = GameState.CardsDealt;
		}
		this.run();
	}

	public void flipCards() {
		int playerIndex = 1;
		for (Player player : players) {
			PlayingCard pc = player.getCard(0);
			pc.flip();
			view.showCardForPlayer(playerIndex++, player.getName(), pc.getRank().toString(), pc.getSuit().toString());
		}
		evaluateWinner();
		displayWinner();
		rebuidDeck();
		gameState = GameState.WinnerRevealed;
		this.run();
	}

	void evaluateWinner() {
		winner = evaluator.evaluateWinner(players);
	}

	private void displayWinner() {
		view.showWinner(winner.getName());
	}

	private void rebuidDeck() {
		for (Player player : players) {
			deck.returnCardToDeck(player.removeCard());
		}
	}

	private void exitGame() {
		System.exit(0);
	}

	public void nextAction(String nextChoice) {
		if ("+q".equals(nextChoice)) {
			exitGame();
		} else {
			startGame();
		}
	}

}
