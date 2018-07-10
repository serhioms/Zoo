package junit.chess;

import static org.junit.Assert.assertTrue;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

import ca.mss.game.chess.hist.BoardLocation;
import ca.mss.game.chess.hist.ChessBoard;
import ca.mss.game.chess.hist.ChessGame;
import ca.mss.game.chess.hist.ChessHistory;
import ca.mss.game.chess.hist.ChessPiece;
import ca.mss.game.chess.min.ChessGameSimple.ChessFace;

public class ChessTest3 {

	ChessHistory history;
	ChessGame game;
	ChessPiece piece, rook, wrook, brook, bishop, queen, knight, king, wking, bking, bpawn, wpawn;
	BoardLocation a1,a8,h8,h1,e4,e1,e8,e2,e7;
	
	@Test
	public void testBPawnEnPassantMove() {
		
		game.setInitialPosition();

		String beginBoard = game.getWhiteBoard();

		// System.out.println( game.getWhiteBoard() );
		// System.out.println();
		
		history.addMove(piece=game.getOcupant(BoardLocation.e2), BoardLocation.e4);
		// System.out.println( game.getWhiteBoard() );
		// System.out.println();
		
		history.addMove(piece=game.getOcupant(BoardLocation.c7), BoardLocation.c6);
		// System.out.println( game.getWhiteBoard() );
		// System.out.println();
		
		history.addMove(piece=game.getOcupant(BoardLocation.e4), BoardLocation.e5);
		// System.out.println( game.getWhiteBoard() );
		// System.out.println();

		history.addMove(piece=game.getOcupant(BoardLocation.f7), BoardLocation.f5);
		// System.out.println( game.getWhiteBoard() );

		// System.out.println( "Legal moves for ["+(piece=game.getOcupant(BoardLocation.e5)).toRecord()+"]: "+piece.getLegalMoveList(history) );
		// System.out.println();

		history.addMove(piece=game.getOcupant(BoardLocation.e5), BoardLocation.f6);
		// System.out.println( game.getWhiteBoard() );
		// System.out.println();

		history.addMove(piece=game.getOcupant(BoardLocation.g7), BoardLocation.g6);
		// System.out.println( game.getWhiteBoard() );

		// System.out.println( "Legal moves for ["+(piece=game.getOcupant(BoardLocation.f6)).toRecord()+"]: "+piece.getLegalMoveList(history) );
		// System.out.println();

		// System.out.println( ChessBoard.getWhiteBoard(false) );

		history.goStart();
		
		String endBoard = game.getWhiteBoard();

		// System.out.println( game.getWhiteBoard(false) );

		assertTrue( endBoard.equals(beginBoard) );
		

	}	
	
	
	
	
	@Before
	public void setUp() throws Exception {
		history = new ChessHistory();
		game = new ChessGame();
		rook = (ChessPiece )game.getPiecesByFace(ChessFace.Rook).get(0);
		wrook = (ChessPiece )(game.getPiecesByFace(ChessFace.Rook).get(0).getColor() == Color.white? game.getPiecesByFace(ChessFace.Rook).get(0): game.getPiecesByFace(ChessFace.Rook).get(3));
		brook = (ChessPiece )(game.getPiecesByFace(ChessFace.Rook).get(3).getColor() == Color.black? game.getPiecesByFace(ChessFace.Rook).get(3): game.getPiecesByFace(ChessFace.Rook).get(0));
		bishop = (ChessPiece )game.getPiecesByFace(ChessFace.Bishop).get(0);
		queen = (ChessPiece )game.getPiecesByFace(ChessFace.Queen).get(0);
		knight = (ChessPiece )game.getPiecesByFace(ChessFace.Knight).get(0);
		king = (ChessPiece )game.getPiecesByFace(ChessFace.King).get(0);
		wking = (ChessPiece )(game.getPiecesByFace(ChessFace.King).get(0).getColor() == Color.white? game.getPiecesByFace(ChessFace.King).get(0): game.getPiecesByFace(ChessFace.King).get(1));
		bking = (ChessPiece )(game.getPiecesByFace(ChessFace.King).get(1).getColor() == Color.black? game.getPiecesByFace(ChessFace.King).get(1): game.getPiecesByFace(ChessFace.King).get(0));
		wpawn = (ChessPiece )(game.getPiecesByFace(ChessFace.Pawn).get(0).getColor() == Color.white? game.getPiecesByFace(ChessFace.Pawn).get(0): game.getPiecesByFace(ChessFace.Pawn).get(8));
		bpawn = (ChessPiece )(game.getPiecesByFace(ChessFace.Pawn).get(8).getColor() == Color.black? game.getPiecesByFace(ChessFace.Pawn).get(8): game.getPiecesByFace(ChessFace.Pawn).get(0));
		a1 = BoardLocation.a1;
		a8 = BoardLocation.a8;
		h1 = BoardLocation.h1;
		h8 = BoardLocation.h8;
		e4 = BoardLocation.e4;
		e1 = BoardLocation.e1;
		e8 = BoardLocation.e8;
		e2 = BoardLocation.e2;
		e7 = BoardLocation.e7;
	}


	public boolean dotest(ChessPiece piece, BoardLocation moveTo, String result) {
		try {
			history.addMove(piece, moveTo);
			
			boolean doprint;
			
			if( !(doprint=result.equals(piece.getLegalMoveList(history))) ){
				System .out.println( game.getWhiteBoard() );
				System .out.println( "Legal moves for ["+piece.toRecord()+"]: "+piece.getLegalMoveList(history) );
			}
			
			return doprint;
			
		} catch( RuntimeException e){
			e.printStackTrace();
			return false;
		}
	}	
	
}