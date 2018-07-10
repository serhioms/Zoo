package ca.mss.game.base;

abstract public class AbstractPiece implements Piece {

	@Override
	abstract public Face getFace();

	@Override
	public Face getSecondFace() {
		return getFace();
	}

}
