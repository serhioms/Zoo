package ca.mss.game.chess.hist;

import ca.mss.game.chess.min.ChessPieceSimple;
import ca.mss.game.chess.min.ChessGameSimple.ChessColor;


public class ChessBoard {

	final static public BoardLocation[] location = BoardLocation.values();
	final public ChessPiece[] ocupant = new ChessPiece[location.length];

	final static protected int[][][] getLegalMove(ChessPieceSimple piece){
		switch( piece.face ){
		case Bishop:
			return BISHOP_MOVES;
		case King: 
			return KING_MOVES;
		case Knight: 
			return KNIGHT_MOVES;
		case Pawn: 
			return piece.color == ChessColor.Black? PAWN_BLACK_MOVES: PAWN_WHITE_MOVES;
		case Queen: 
			return QUEEN_MOVES;
		case Rook: 
			return ROOK_MOVES;
		}
		throw new RuntimeException("Unexpected face ["+piece.face+"] for legal move invocation");
	}
	
	final static public int[][][] BISHOP_MOVES = new int[][][]{
		new int[][]{{+1,+1},{+2,+2},{+3,+3},{+4,+4},{+5,+5},{+6,+6},{+7,+7}},
		new int[][]{{+1,-1},{+2,-2},{+3,-3},{+4,-4},{+5,-5},{+6,-6},{+7,-7}},
		new int[][]{{-1,+1},{-2,+2},{-3,+3},{-4,+4},{-5,+5},{-6,+6},{-7,+7}},
		new int[][]{{-1,-1},{-2,-2},{-3,-3},{-4,-4},{-5,-5},{-6,-6},{-7,-7}}
	}; 
	
	final static public int[][][] ROOK_MOVES = new int[][][]{
		new int[][]{{0,+1},{0,+2},{0,+3},{0,+4},{0,+5},{0,+6},{0,+7}},
		new int[][]{{0,-1},{0,-2},{0,-3},{0,-4},{0,-5},{0,-6},{0,-7}},
		new int[][]{{+1,0},{+2,0},{+3,0},{+4,0},{+5,0},{+6,0},{+7,0}},
		new int[][]{{-1,0},{-2,0},{-3,0},{-4,0},{-5,0},{-6,0},{-7,0}}
	};

	final static public int[][][] QUEEN_MOVES = new int[][][]{
		new int[][]{{+1,+1},{+2,+2},{+3,+3},{+4,+4},{+5,+5},{+6,+6},{+7,+7}},
		new int[][]{{+1,-1},{+2,-2},{+3,-3},{+4,-4},{+5,-5},{+6,-6},{+7,-7}},
		new int[][]{{-1,+1},{-2,+2},{-3,+3},{-4,+4},{-5,+5},{-6,+6},{-7,+7}},
		new int[][]{{-1,-1},{-2,-2},{-3,-3},{-4,-4},{-5,-5},{-6,-6},{-7,-7}},
		new int[][]{{0,+1},{0,+2},{0,+3},{0,+4},{0,+5},{0,+6},{0,+7}},
		new int[][]{{0,-1},{0,-2},{0,-3},{0,-4},{0,-5},{0,-6},{0,-7}},
		new int[][]{{+1,0},{+2,0},{+3,0},{+4,0},{+5,0},{+6,0},{+7,0}},
		new int[][]{{-1,0},{-2,0},{-3,0},{-4,0},{-5,0},{-6,0},{-7,0}}
	};

	final static public int[][][] KING_MOVES = new int[][][]{
		new int[][]{{+1,+1}},
		new int[][]{{+1,-1}},
		new int[][]{{-1,+1}},
		new int[][]{{-1,-1}},
		new int[][]{{ 0,+1}},
		new int[][]{{ 0,-1}},
		new int[][]{{+1,0},{+2,0}}, // rokirovka
		new int[][]{{-1,0}}
	};

	final static public int[][][] PAWN_WHITE_MOVES = new int[][][]{
		new int[][]{{0,-1},{0,-2}},
		new int[][]{{-1,-1}},
		new int[][]{{+1,-1}},
	};

	final static public int[][][] PAWN_BLACK_MOVES = new int[][][]{
		new int[][]{{0,+1},{0,+2}},
		new int[][]{{+1,+1}},
		new int[][]{{-1,+1}},
	};
	
	final static public int[][][] KNIGHT_MOVES = new int[][][]{
		new int[][]{{-2,-1}},
		new int[][]{{-2,+1}},
		new int[][]{{-1,+2}},
		new int[][]{{+1,+2}},
		new int[][]{{+2,+1}},
		new int[][]{{+2,-1}},
		new int[][]{{+1,-2}},
		new int[][]{{-1,-2}}
	};
	
	/*

8  a8 b8 c8 d8 e8 f8 g8 h8 
7  a7 b7 c7 d7 e7 f7 g7 h7 
6  a6 b6 c6 d6 e6 f6 g6 h6 
5  a5 b5 c5 d5 e5 f5 g5 h5 
4  a4 b4 c4 d4 e4 f4 g4 h4 
3  a3 b3 c3 d3 e3 f3 g3 h3 
2  a2 b2 c2 d2 e2 f2 g2 h2 
1  a1 b1 c1 d1 e1 f1 g1 h1 
   a  b  c  d  e  f  g  h
   
8   0  1  2  3  4  5  6  7 
7   8  9 10 11 12 13 14 15 
6  16 17 18 19 20 21 22 23 
5  24 25 26 27 28 29 30 31 
4  32 33 34 35 36 37 38 39 
3  40 41 42 43 44 45 46 47 
2  48 49 50 51 52 53 54 55 
1  56 57 58 59 60 61 62 63 
   a  b  c  d  e  f  g  h
	
	*/
	
	
	public static String getWhiteBoard(boolean f) {
		String board = "";
		
		int v=0;
		for(int i=0; i< location.length; i++ ){
			if( i % 8 == 0 ){
				if( i > 0 )
					board += "\n";
				board += BoardLocation.VERTICAL[v++];
				board += "  ";
			}
			
			String ordinal = "  "+location[i].ordinal();
			
			if( f )
				board += location[i];
			else
				board += ordinal.substring(ordinal.length()-2, ordinal.length());
			
			board += " ";
		}
		board += "\n";
		
		board += " ";
		for(int h=0; h< 8; h++ ){
			board += "  ";
			board += BoardLocation.HORIZONTAL[h].toLowerCase();
		}
		board += "\n\n";

		return board;
	}

	public static void main(String[] args) {
		getWhiteBoard(true);
		getWhiteBoard(false);
	}
	
}
