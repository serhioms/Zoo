package ca.mss.game.chess;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import ca.mss.game.chess.hist.BoardLocation;
import ca.mss.game.chess.hist.ChessBoard;
import ca.mss.game.chess.hist.ChessGame;
import ca.mss.game.chess.hist.ChessHistory;
import ca.mss.game.chess.hist.ChessPiece;
import ca.mss.game.chess.min.ChessGameSimple;

public class ChessTest {

	ChessGameSimple game;
	ChessGame game2;
	
	@Before
	public void setUp() throws Exception {
		game = new ChessGameSimple();
		game2 = new ChessGame();
	}


	@Test
	public void testGame() {
		assertTrue(game.getGame().size() == 32);
	}

	@Test
	public void testColors() {
		for(ChessGameSimple.ChessColor color: ChessGameSimple.ChessColor.values()) {
			assertTrue(game.getPiecesByColor(color).size() == 16);
		}
	}


	@Test
	public void testFaces() {
		for(ChessGameSimple.ChessFace face: ChessGameSimple.ChessFace.values()) {
			switch( face) {
				case Bishop:
				case Knight:
				case Rook:
					assertTrue(game.getPiecesByFace(face).size() == 4);
					break;
				case Pawn:
					assertTrue(game.getPiecesByFace(face).size() == 16);
					break;
				case King:
				case Queen:
					assertTrue(game.getPiecesByFace(face).size() == 2);
					break;
			}
		}
	}

	@Test
	public void testRanks() {
		int[] ranks = ChessGameSimple.getRanks();
		for(int i=0; i<ranks.length ; i++) {
			switch(ranks[i] ){
			case 0:
				assertTrue( game.getPiecesByRank(ranks[i]).size() == 2 );					
				break;
			case 8:
				assertTrue( game.getPiecesByRank(ranks[i]).size() == 2 );					
				break;
			case 4:
				assertTrue( game.getPiecesByRank(ranks[i]).size() == 4 );					
				break;
			case 3:
				assertTrue( game.getPiecesByRank(ranks[i]).size() == 4 );					
				break;
			case 2:
				assertTrue( game.getPiecesByRank(ranks[i]).size() == 4 );					
				break;
			case 1: 
				assertTrue( game.getPiecesByRank(ranks[i]).size() == 16 );					
				break;
			default:
				assertTrue( false );					
			}
		}
	}
	
	
	@Test
	public void testMovesWhithoutCaptures() {
		
		try {
			Random rnd = new Random();
			int pieceLimit = game2.getGameSize();
			
			ChessHistory history = new ChessHistory();
			
			game2.setInitialPosition();
			
			String beginBoard = game2.getWhiteBoard();
			// System.out.println( beginBoard );
			// System.out.println();
			
			for(int i=0; i<100; i++){
				ChessPiece piece = (ChessPiece )game2.getPiece(rnd.nextInt(pieceLimit));
				
				// no drops 
				BoardLocation moveTo = ChessBoard.location[rnd.nextInt(ChessBoard.location.length)];
				while( game2.getOcupant(moveTo) != null ){
					moveTo =  ChessBoard.location[rnd.nextInt(ChessBoard.location.length)];
				}
				
				history.addMove(piece, moveTo);
				
				// System.out.println( history.getRecord() );
				// System.out.println( game2.getWhiteBoard());
			}

			// System.out.println( game2.getWhiteBoard());
		
			history.goStart();
			
			String endBoard = game2.getWhiteBoard();
			
			// System.out.println( endBoard);

			assertTrue( endBoard.equals(beginBoard) );
		} catch( RuntimeException e){
			assertTrue(false);
		}
	}
	
	@Test
	public void testMovesWithCaptures() {
		
		try {
			Random rnd = new Random();
			int pieceLimit = game2.getGameSize();
			
			ChessHistory history = new ChessHistory();
			
			game2.setInitialPosition();
			
			String beginBoard = game2.getWhiteBoard();
			// System.out.println( beginBoard );
			// System.out.println();
			
			for(int i=0; i<100; i++){
				
				ChessPiece piece = (ChessPiece )game2.getPiece(rnd.nextInt(pieceLimit));
				while( piece.isCaptured() ){
					piece = (ChessPiece )game2.getPiece(rnd.nextInt(pieceLimit));
				}
				
				final BoardLocation location = game2.getLocation(rnd.nextInt(ChessBoard.location.length));
				
				history.addMove(piece, location);

				// System.out.println( history.getRecord() );
				// System.out.println( game2.getWhiteBoard());
			}

			// System.out.println( game2.getWhiteBoard());
		
			history.goStart();
			
			String endBoard = game2.getWhiteBoard();
			
			// System.out.println( endBoard);

			assertTrue( endBoard.equals(beginBoard) );
		} catch( RuntimeException e){
			assertTrue(false);
		}
	}	
	
	@Test
	public void testMovesLegal() {
		
		try {
			Random rnd = new Random();
			
			ChessHistory history = new ChessHistory();
			
			game2.setInitialPosition();
			
			String beginBoard = game2.getWhiteBoard();
			// System.out.println( beginBoard );
			// System.out.println();
			
			List<ChessPiece> pieces = new ArrayList<ChessPiece>();
			List<BoardLocation> locations = new ArrayList<BoardLocation>();

			for(int i=0; i<100; i++){
				
				pieces.clear();
				for(Iterator<ChessPiece> iter=game2.iterator(history.isBlackMove()); iter.hasNext(); ){
					pieces.add(iter.next());
				}

				if( pieces.size() == 0 ){
					// System.out.println("NO PIECES TO MOVE!!!");
					break;
				}

				ChessPiece piece = pieces.get(rnd.nextInt(pieces.size()));
				
				locations.clear();
				for(Iterator<BoardLocation> iter=piece.iterator(history); iter.hasNext(); ){
					locations.add(iter.next());
				}

				if( locations.size() == 0 )
					continue;
				
				BoardLocation location = locations.get(rnd.nextInt(locations.size()));

				history.addMove(piece, location);

				// System.out.println( history.getRecord() );
				// System.out.println( game2.getWhiteBoard());
				// System.out.println();
			}

			// System.out.println( game2.getWhiteBoard());
		
			history.goStart();
			
			String endBoard = game2.getWhiteBoard();
			
			// System.out.println( endBoard);

			assertTrue( endBoard.equals(beginBoard) );
		} catch( RuntimeException e){
			e.printStackTrace();
			assertTrue(false);
		}
	}	
	
	@Test
	public void testRookException() {
		
		try {
			ChessHistory history = new ChessHistory();
			
			game2.setInitialPosition();
			
			history.addMove(game2.getOcupant(BoardLocation.e2), BoardLocation.e4);
			history.addMove(game2.getOcupant(BoardLocation.a7), BoardLocation.a5);
			history.addMove(game2.getOcupant(BoardLocation.d2), BoardLocation.d4);
			history.addMove(game2.getOcupant(BoardLocation.a8), BoardLocation.a6);

			Iterator<BoardLocation> iter = game2.getOcupant(BoardLocation.a6).iterator(history);
			while( iter.hasNext() && iter.hasNext() && iter.hasNext() ){
				iter.next();
				iter.next();
				iter.next();
				iter.next();
			}

			assertTrue( false );
		} catch( RuntimeException e){
			assertTrue( true );
		}
	}	
	
	
	@Test
	public void testRookLeft() {
		
		try {
			ChessHistory history = new ChessHistory();
			
			game2.setInitialPosition();
			
			history.addMove(game2.getOcupant(BoardLocation.e2), BoardLocation.e4);
			history.addMove(game2.getOcupant(BoardLocation.a7), BoardLocation.a5);
			history.addMove(game2.getOcupant(BoardLocation.d2), BoardLocation.d4);
			history.addMove(game2.getOcupant(BoardLocation.a8), BoardLocation.a6);

			// System.out.println( game2.getWhiteBoard() );
			// System.out.println( "Legal moves for ["+game2.getOcupant(BoardLocation.a6).toRecord()+"]: "+game2.getOcupant(BoardLocation.a6).getLegalMoveList(history) );
			assertTrue( "a7,a8,b6,c6,d6,e6,f6,g6,h6".equals(game2.getOcupant(BoardLocation.a6).getLegalMoveList(history)) );
			
			// System.out.println( game2.getWhiteBoard() );
			// System.out.println( "Legal moves for ["+game2.getOcupant(BoardLocation.h8).toRecord()+"]: "+game2.getOcupant(BoardLocation.h8).getLegalMoveList(history) );
			assertTrue( "".equals(game2.getOcupant(BoardLocation.h8).getLegalMoveList(history)) );
			
		} catch( RuntimeException e){
			e.printStackTrace();
			assertTrue(false);
		}
	}	
	
	@Test
	public void testRookRight() {
		
		try {
			ChessHistory history = new ChessHistory();
			
			game2.setInitialPosition();
			
			history.addMove(game2.getOcupant(BoardLocation.e2), BoardLocation.e4);
			history.addMove(game2.getOcupant(BoardLocation.h7), BoardLocation.h5);
			history.addMove(game2.getOcupant(BoardLocation.d2), BoardLocation.d4);
			history.addMove(game2.getOcupant(BoardLocation.h8), BoardLocation.h6);

			// System.out.println( ChessBoard.getWhiteBoard(false) );
			// System.out.println( game2.getWhiteBoard() );
			// System.out.println( "Legal moves for ["+game2.getOcupant(BoardLocation.h6).toRecord()+"]: "+game2.getOcupant(BoardLocation.h6).getLegalMoveList(history) );
			assertTrue( "h7,h8,g6,f6,e6,d6,c6,b6,a6".equals(game2.getOcupant(BoardLocation.h6).getLegalMoveList(history)) );
			
			// System.out.println( game2.getWhiteBoard() );
			// System.out.println( "Legal moves for ["+game2.getOcupant(BoardLocation.a8).toRecord()+"]: "+game2.getOcupant(BoardLocation.a8).getLegalMoveList(history) );
			assertTrue( "".equals(game2.getOcupant(BoardLocation.a8).getLegalMoveList(history)) );
			
		} catch( RuntimeException e){
			e.printStackTrace();
			assertTrue(false);
		}
	}	

}


