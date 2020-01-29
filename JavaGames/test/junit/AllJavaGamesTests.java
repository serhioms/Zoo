package junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import junit.card.CardTest;
import junit.chess.ChessTest2;
import junit.chess.ChessTest3;
import junit.domino.DominoTest;
import junit.sudoku.SudokuTest;

@RunWith(Suite.class)
@SuiteClasses({CardTest.class, ChessTest2.class, ChessTest3.class, DominoTest.class, SudokuTest.class})
public class AllJavaGamesTests {

}
