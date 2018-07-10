package ca.mss.game.chess.hist;

import java.util.ArrayList;
import java.util.List;

public class ChessHistory {

	final public static int INITIAL_HISTORY_SIZE = 100;
	
	/*
	 * Proper play order
	 */
	
	private boolean isBlackMove;


	
	public final boolean isBlackMove() {
		return isBlackMove;
	}

	/*
	 * Legal move implementation
	 */
	private List<ChessPiece> history = new ArrayList<ChessPiece>(INITIAL_HISTORY_SIZE);
	private int size;
	
	final public int getSize(){
		return size;
	}
	
	final public void setPiece(ChessPiece piece, BoardLocation to){
		
		piece.setPiece(to);
		
		if( size < history.size() )
			history.set(size, piece);
		else
			history.add(piece);
		
		size++;
	}
	
	final public boolean addMove(ChessPiece piece, BoardLocation moveTo){
		
		boolean isCapture = piece.addMove(moveTo);
		
		if( size < history.size() )
			history.set(size, piece);
		else
			history.add(piece);
		
		size++;
		isBlackMove = !isBlackMove;
		
		return isCapture;
	}
	
	final public void goBack(int n){
		while( n-- > 0 ){
			history.get(--size).goBack();
			isBlackMove = !isBlackMove;
		}
	}
	
	final public void goStart(){
		goBack(history.size());
	}
	
	final public ChessPiece getLastPiece(){
		return history.get(size-1);
	}
	
	final public String getRecord(){
		ChessPiece piece = getLastPiece();
		if( piece.getCapture() != null )
			return getSize()+") "+piece+" "+piece.getPrevLocation()+" x "+piece.getCapture()+" "+piece.getLocation();
		else
			return getSize()+") "+piece+" "+piece.getPrevLocation()+" - "+piece.getLocation();
	}

}
