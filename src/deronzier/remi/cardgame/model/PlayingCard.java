package deronzier.remi.cardgame.model;

public class PlayingCard {
	private Rank rank;
	private Suit suit;
	private boolean faceUp;

	public PlayingCard(Rank rank, Suit suit) {
		super();
		this.rank = rank;
		this.suit = suit;
	}

	public Suit getSuit() {
		return suit;
	}

	public Rank getRank() {
		return rank;
	}

	public boolean isFaceUp() {
		return faceUp;
	}

	public boolean flip() {
		faceUp = !faceUp;
		return faceUp;
	}

}
