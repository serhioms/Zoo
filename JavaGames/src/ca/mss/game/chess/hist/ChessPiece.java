package ca.mss.game.chess.hist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ca.mss.game.chess.min.ChessPieceSimple;
import ca.mss.game.chess.min.ChessGameSimple.ChessColor;
import ca.mss.game.chess.min.ChessGameSimple.ChessFace;

public class ChessPiece extends ChessPieceSimple implements Iterator<BoardLocation> {

	final static public int FACE_PAWN_8_ID = 15;
	final static public int FACE_PAWN_7_ID = 14;
	final static public int FACE_PAWN_6_ID = 13;
	final static public int FACE_PAWN_5_ID = 12;
	final static public int FACE_PAWN_4_ID = 11;
	final static public int FACE_PAWN_3_ID = 10;
	final static public int FACE_PAWN_2_ID = 9;
	final static public int FACE_PAWN_1_ID = 8;
	final static public int FACE_KNIGHT_1_ID = 7;
	final static public int FACE_KNIGHT_2_ID = 6;
	final static public int FACE_BISHOP_1_ID = 5;
	final static public int FACE_BISHOP_2_ID = 4;
	final static public int FACE_ROOK_1_ID = 3;
	final static public int FACE_ROOK_2_ID = 2;
	final static public int FACE_QUEEN_ID = 1;
	final static public int FACE_KING_ID = 0;
	
	final public ChessGame game;
	final public int faceId, pieceId;
	
	final public String getLegalMoveList(ChessHistory ch){
		String legal = "";
		for(Iterator<BoardLocation> iter = iterator(ch); iter.hasNext(); legal += "".equals(legal)? iter.next(): ","+iter.next());
		return legal;
	}
	
	/*
	 * Legal moves support
	 */
	
	final public BoardLocation[][] legalMoves;
	final public int[][][] template;
	
	final public Iterator<BoardLocation> iterator(ChessHistory chessHistory){
		final int H=getLocation().h, V=getLocation().v;
		int toH, toV;

		enpassantPiece = null;
		
		for(int i=0; i<template.length; i++){
			for(int j=0; j<template[i].length; j++){
				legalMoves[i][j] = null;

				// get out of the board
				if( (toH=H+template[i][j][0]) <0 )
					break;
				
				if( toH>=BoardLocation.MAX_H)
					break;
				
				if( (toV=V+template[i][j][1]) <0 )
					break;
				
				if( toV>=BoardLocation.MAX_V)
					break;
				
				// king castling case
				if( face == ChessFace.King && template[i][j][0] == +2 ){
					if( size != 1)
						break;

					if( getLocation() != (color == ChessColor.White? BoardLocation.e1: BoardLocation.e8) )
						break;
					
					ChessPiece rook = (color == ChessColor.White)? game.board.ocupant[BoardLocation.h1.ordinal()]: game.board.ocupant[BoardLocation.h8.ordinal()];
					if( rook == null )
						break;
					else if( rook.size != 1 )
						break;
					else if( rook.color != color )
						break;
				}

				int to = BoardLocation.getLocationIndex(toH, toV);
				
				if( face == ChessFace.Pawn ){
					if( template[i][j][0] != 0 ){
						// pawn captures
						ChessPiece piece = game.board.ocupant[to];
						if( piece == null ){
							if( chessHistory.getSize() <= 0 )
								break;
							
							// Check En Passant
							ChessPiece prevPiece = chessHistory.getLastPiece();
							if( prevPiece.face == ChessFace.Pawn && prevPiece.color != this.color ){
								BoardLocation toloc = prevPiece.getLocation();
								BoardLocation frloc = prevPiece.getPrevLocation();
								if( toloc.h == toloc.h && toloc.h == toH && ((color == ChessColor.Black && toV < frloc.v && toV > toloc.v) || (color == ChessColor.White && toV > frloc.v && toV < toloc.v)) )
									enpassantPiece = prevPiece;
								else
									break;
							} else
								break;
						} else if( piece.color == color )
							break;
					} else if( template[i][j][1] == -2 || template[i][j][1] == +2 ){
						// pawn first long move
						if( size != 1 )
							break;

						if( getLocation().v != (color == ChessColor.White? BoardLocation.PAWN_WHITE_VERTICAL: BoardLocation.PAWN_BLACK_VERTICAL) )
							break;
						
					}
				}
				
				// standard piece move
				legalMoves[i][j] = ChessBoard.location[to];

				// standard piece capture
				if( game.board.ocupant[to] != null ){
					if( game.board.ocupant[to].color == this.color ){
						legalMoves[i][j] = null;
					}
					break;
				}
			}			
		}
		I = J = 0;
		findNext();
		return this;
	}

	private int I,J;
	private BoardLocation LOCATION;

	private void findNext() {
		for(LOCATION = null; (LOCATION == null) && (I >=0 && I < legalMoves.length )&&( J >=0 && J < legalMoves[I].length); ){
			LOCATION = legalMoves[I][J];
			if( LOCATION != null ){
				if( ++J == legalMoves[I].length ){
					J = 0;
					I++;
				}
			} else {
				J = 0;
				I++;
			}
		}
	}

	@Override
	public boolean hasNext() {
		return LOCATION != null;
	}

	@Override
	public BoardLocation next() {
		final BoardLocation location = LOCATION;
		if( location != null )
			findNext();
		else
			throw new RuntimeException("There is no next legal position for ["+this.toRecord()+"]. Mised hasNext()?");
		return location;
	}

	@Override
	public void remove() {}
	

	/*
	 * History support
	 */

	final public List<BoardLocation> history = new ArrayList<BoardLocation>(ChessHistory.INITIAL_HISTORY_SIZE/10);
	final public List<ChessPiece> captures = new ArrayList<ChessPiece>(ChessHistory.INITIAL_HISTORY_SIZE/10);

	private int size;
	private boolean isCaptured = false;
	private boolean isEnpassant = false;
	private ChessPiece enpassantPiece;
	
	
	final public boolean isCaptured(){
		return isCaptured;
	}
	
	final public BoardLocation getLocation(){
		return history.get(size-1);
	}

	public String toRecord() {
		return super.toString()+getLocation();
	}
	
	final public BoardLocation getPrevLocation(){
		return history.get(size-2);
	}
	
	final public ChessPiece getCapture(){
		return captures.get(size-1);
	}
	
	final public void setPiece(BoardLocation to){
		if( size != 0 )
			throw new RuntimeException("Piece ["+this+"] allready on the table");

		ChessPiece ocupant = game.board.ocupant[to.ordinal()];
		if( ocupant != null ){
			throw new RuntimeException("Can not set piece ["+this+"] to the place ["+to+"] occupied by ["+ocupant+"]");
		}

		if( size < captures.size() )
			captures.set(size, ocupant);
		else
			captures.add(ocupant);
		
		if( size < history.size() )
			history.set(size, to);
		else
			history.add(to);
		
		game.board.ocupant[to.ordinal()] = this;

		size++;
	}

	final public boolean isEnpassant(BoardLocation to){
		BoardLocation toloc = enpassantPiece.getLocation();
		BoardLocation frloc = enpassantPiece.getPrevLocation();
		return toloc.h == toloc.h && toloc.h == to.h && ((color == ChessColor.Black && to.v < frloc.v && to.v > toloc.v) || (color == ChessColor.White && to.v > frloc.v && to.v < toloc.v));
	}
	
	final public boolean addMove(BoardLocation to){
		boolean isCaptures = false;

		if( size > 0 )
			game.board.ocupant[getLocation().ordinal()] = null;

		ChessPiece ocupant = game.board.ocupant[to.ordinal()];
		if( ocupant != null ){
			isCaptures = ocupant.isCaptured = true;
		} else if( enpassantPiece != null && isEnpassant(to) ){
			System.out.println("Enpassant of ["+enpassantPiece.toRecord()+"] by ["+toRecord()+"] on ["+to+"]");
			ocupant = enpassantPiece;
			isCaptures = ocupant.isEnpassant = ocupant.isCaptured = true;
			game.board.ocupant[ocupant.getLocation().ordinal()] = null;
		}
		
		if( size < captures.size() )
			captures.set(size, ocupant);
		else
			captures.add(ocupant);
		
		if( size < history.size() )
			history.set(size, to);
		else
			history.add(to);
		
		game.board.ocupant[to.ordinal()] = this;

		size++;
		
		return isCaptures;
	}

	final public void goBack(){
		
		ChessPiece captured = captures.get(size-1);
		
		int capturedLocation = getLocation().ordinal();
		if( captured != null ){
			if( captured.isCaptured && captured.isEnpassant ){
				game.board.ocupant[capturedLocation] = null;
				if( captured.color == ChessColor.Black)
					capturedLocation -= 8;
				else
					capturedLocation += 8;
			}
			captured.isEnpassant = captured.isCaptured = false;
		}

		game.board.ocupant[capturedLocation] = captured;
		
		size--;

		game.board.ocupant[getLocation().ordinal()] = this;
	}

	
	
	/*
	 * Initial position support
	 */
	
	final BoardLocation initial;

	final public void setInitialPosition(){
		size = 0;
		history.clear();
		captures.clear();
		addMove(initial);
	}

	
	public ChessPiece(ChessGame game, ChessFace face, ChessColor color, int faceId, int pieceId) {
		super(face, color);
		
		this.game = game;
		this.faceId = faceId;
		this.pieceId = pieceId;
		this.template = ChessBoard.getLegalMove(this);
		this.legalMoves = new BoardLocation[template.length][];
		
		for(int i=0; i<legalMoves.length; i++){
			legalMoves[i] = new BoardLocation[template[i].length];
		}
		
		if( color == ChessColor.White )
			switch( faceId ){
			case FACE_ROOK_1_ID:
				initial = BoardLocation.a1;
				return;
			case FACE_KNIGHT_1_ID:
				initial = BoardLocation.b1;
				return;
			case FACE_BISHOP_1_ID:
				initial = BoardLocation.c1;
				return;
			case FACE_QUEEN_ID:
				initial = BoardLocation.d1;
				return;
			case FACE_KING_ID:
				initial = BoardLocation.e1;
				return;
			case FACE_BISHOP_2_ID:
				initial = BoardLocation.f1;
				return;
			case FACE_KNIGHT_2_ID:
				initial = BoardLocation.g1;
				return;
			case FACE_ROOK_2_ID:
				initial = BoardLocation.h1;
				return;
				
			case FACE_PAWN_1_ID:
				initial = BoardLocation.a2;
				return;
			case FACE_PAWN_2_ID:
				initial = BoardLocation.b2;
				return;
			case FACE_PAWN_3_ID:
				initial = BoardLocation.c2;
				return;
			case FACE_PAWN_4_ID:
				initial = BoardLocation.d2;
				return;
			case FACE_PAWN_5_ID:
				initial = BoardLocation.e2;
				return;
			case FACE_PAWN_6_ID:
				initial = BoardLocation.f2;
				return;
			case FACE_PAWN_7_ID:
				initial = BoardLocation.g2;
				return;
			case FACE_PAWN_8_ID:
				initial = BoardLocation.h2;
				return;
			}
		else if( color == ChessColor.Black )
			switch( faceId ){
			case FACE_ROOK_1_ID:
				initial = BoardLocation.a8;
				return;
			case FACE_KNIGHT_1_ID:
				initial = BoardLocation.b8;
				return;
			case FACE_BISHOP_1_ID:
				initial = BoardLocation.c8;
				return;
			case FACE_QUEEN_ID:
				initial = BoardLocation.d8;
				return;
			case FACE_KING_ID:
				initial = BoardLocation.e8;
				return;
			case FACE_BISHOP_2_ID:
				initial = BoardLocation.f8;
				return;
			case FACE_KNIGHT_2_ID:
				initial = BoardLocation.g8;
				return;
			case FACE_ROOK_2_ID:
				initial = BoardLocation.h8;
				return;
				
			case FACE_PAWN_1_ID:
				initial = BoardLocation.a7;
				return;
			case FACE_PAWN_2_ID:
				initial = BoardLocation.b7;
				return;
			case FACE_PAWN_3_ID:
				initial = BoardLocation.c7;
				return;
			case FACE_PAWN_4_ID:
				initial = BoardLocation.d7;
				return;
			case FACE_PAWN_5_ID:
				initial = BoardLocation.e7;
				return;
			case FACE_PAWN_6_ID:
				initial = BoardLocation.f7;
				return;
			case FACE_PAWN_7_ID:
				initial = BoardLocation.g7;
				return;
			case FACE_PAWN_8_ID:
				initial = BoardLocation.h7;
				return;
			}
		throw new RuntimeException("Can not set up initial pozition for piece [id="+faceId+"][color="+color+"][face="+face+"]");
	}

}
