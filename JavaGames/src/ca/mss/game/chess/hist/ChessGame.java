package ca.mss.game.chess.hist;

import java.util.Iterator;
import java.util.List;

import ca.mss.game.base.Piece;
import ca.mss.game.chess.min.ChessGameSimple;

public class ChessGame extends ChessGameSimple implements Iterator<ChessPiece>{

	final public List<Piece> blackPiece;
	final public List<Piece> whitePiece;
	private int isWhite;

	public final ChessBoard board;

	public ChessGame() {
		super();
		this.board = new ChessBoard();
		this.blackPiece = super.getPiecesByColor(ChessColor.Black);
		this.whitePiece = super.getPiecesByColor(ChessColor.White);
		this.isWhite = -1;
	}

	/*
	 * Colored pieces set implementation
	 */
	
	final public ChessPiece getColoredPiece(int index) {
		if( isWhite==1 )
			return (ChessPiece )whitePiece.get(index);
		else
			return (ChessPiece )blackPiece.get(index);
	}

	final public int getColoredSize() {
		if( isWhite==1 )
			return whitePiece.size();
		else 
			return blackPiece.size();
	}

	/*
	 * Piece/Field methods
	 */
	
	final public BoardLocation getLocation(int ordinal) {
		return board.location[ordinal];
	}
	
	final public ChessPiece getOcupant(int ordinal) {
		return board.ocupant[ordinal];
	}
	
	final public ChessPiece getOcupant(BoardLocation location) {
		return board.ocupant[location.ordinal()];
	}
	

	/*
	 * Iterator implementation
	 * 
	 */
	private int I;
	private ChessPiece PIECE;

	private void findNext() {
		PIECE = null;
		for(int MAX=getGameSize(); PIECE == null && I >=0 && I < MAX;){
			ChessPiece piece = (ChessPiece )getPiece(I++);
			if( !piece.isCaptured() )
				PIECE = piece;
		}
	}
	
	@Override
	public boolean hasNext() {
		return PIECE != null;
	}

	@Override
	public ChessPiece next() {
		final ChessPiece piece = PIECE;
		if( piece != null )
			findNext();
		else
			throw new RuntimeException("There is no pieces to move!\n"+getWhiteBoard()+"\n");
		return piece;
	}

	@Override
	public void remove() {}


	public Iterator<ChessPiece> iterator(){
		this.I = 0;
		this.isWhite = -1;
		return this;
	}
	
	public Iterator<ChessPiece> iterator(boolean isBlack){
		this.I = 0;
		this.isWhite = isBlack?0:1;
		findNext();
		return this;
	}
	
	/*
	 * New chess piece implementation 
	 */
	
	@Override
	protected Piece createPiece(ChessFace face, ChessColor color, int faceId, int pieceId) {
		return new ChessPiece(this, face, color, faceId, pieceId);
	}


	public void setInitialPosition(){
		List<Piece> pieces = getGame();
		
		for(int i=0; i<pieces.size(); i++){
			ChessPiece cpiece = (ChessPiece )pieces.get(i);
			cpiece.setInitialPosition();
		}
	}

	/*
	 * Print board  
	 * 
	 */
	
	public String getWhiteBoard(){
		return getWhiteBoard(true);
	}
	
	public String getBlackBoard(){
		return getBlackBoard(true);
	}
	
	public String getWhiteBoard(boolean showFaces){
		String str = "";
		
		int v = 0;
		
		for(int i=0; i< ChessBoard.location.length; i++ ){
			if( i % 8 == 0 ){
				if( i > 0 )
					str += "\n";
				str += BoardLocation.VERTICAL[v++];
				str += "  ";
			}
			
			BoardLocation loaction = ChessBoard.location[i];
			ChessPiece ocupant;
			
			if( (ocupant=board.ocupant[i]) != null ){
				String piece = "";
				if( showFaces )
					piece = ocupant.toString();
				else
					piece = Integer.toString(ocupant.pieceId);
				
				if( piece.length() == 1)
					piece += " ";
				
				str += piece;
			} else if( loaction.isBlack ){
				str += ". ";
				//str += location;
			} else {
				str += "  ";
				//str += location;
			}
			
			str += " ";
		}
		str += "\n";

		str += " ";
		for(int h=0; h< 8; h++ ){
			str += "  ";
			str += BoardLocation.HORIZONTAL[h].toLowerCase();
		}
		return str;
	}
	
	public String getBlackBoard(boolean showFaces){
		String str = "";
		
		int v = 8;
		
		for(int i=ChessBoard.location.length-1; i>= 0; i-- ){
			if( (i+1) % 8 == 0 ){
				if( (i+1) > 0 )
					str += "\n";
				str += BoardLocation.VERTICAL[--v];
				str += "  ";
			}
			
			BoardLocation loaction = ChessBoard.location[i];
			ChessPiece ocupant;
			
			if( (ocupant=board.ocupant[i]) != null ){
				String piece = "";
				if( showFaces )
					piece = ocupant.toString();
				else
					piece = Integer.toString(ocupant.pieceId);
				
				if( piece.length() == 1)
					piece += " ";
				
				str += piece;
			} else if( loaction.isBlack ){
				str += ". ";
				//str += location;
			} else {
				str += "  ";
				//str += location;
			}
			
			str += " ";
		}
		str += "\n";

		str += " ";
		for(int h=7; h>= 0; h-- ){
			str += "  ";
			str += BoardLocation.HORIZONTAL[h].toUpperCase();
		}
		return str;
	}
}
