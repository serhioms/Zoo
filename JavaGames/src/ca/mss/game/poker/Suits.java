package ca.mss.game.poker;

public enum Suits {
	Hearts("H",0), Spades("S",1), Diamonds("D",2), Clubs("C",3);
	
	final public String face;
	final public int order;

	private Suits(String face, int order) {
		this.face = face;
		this.order = order;
	}

	@Override
	public String toString() {
		return face;
	}
	
}
