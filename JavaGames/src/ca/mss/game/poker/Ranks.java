package ca.mss.game.poker;

public enum Ranks {
	two("2",0), three("3",1), four("4",2), five("5",3), six("6",4), seven("7",5), eight("8",6), nine("9",7), ten("T",8), jack("J",9), queen("Q",10), king("K",11), ace("A",12);
	
	final public String face;
	final public int order;
	
	private Ranks(String face, int order) {
		this.face = face;
		this.order = order;
	}

	@Override
	public String toString() {
		return face;
	}
	
	
}
