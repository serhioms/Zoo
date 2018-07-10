package ca.mss.game.chess.min;

import ca.mss.game.base.AbstractPiece;
import ca.mss.game.base.Color;
import ca.mss.game.base.Face;
import ca.mss.game.chess.min.ChessGameSimple.ChessColor;
import ca.mss.game.chess.min.ChessGameSimple.ChessFace;

public class ChessPieceSimple extends AbstractPiece {
	
	final public ChessFace face;
	final public ChessColor color;

	public ChessPieceSimple(ChessFace face, ChessColor color) {
		this.face = face;
		this.color = color;
	}

	@Override
	public Face getFace() {
		return face;
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public int getRank() {
		return face.getRank();
	}

	@Override
	public String toString() {
		return color == ChessColor.White? face.toString().toUpperCase(): face.toString().toLowerCase();
	}
	
	
}

