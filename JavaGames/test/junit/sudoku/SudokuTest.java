package junit.sudoku;

import static org.junit.Assert.*;

import org.junit.Test;

import ca.mss.game.sudoku.impl.SlowSudoku;
import ca.mss.game.sudoku.impl.Sudoku;

public class SudokuTest {

	private Sudoku validSudoku = new Sudoku().generateSimple(0);
	private Sudoku invalidSudoku_00_01 =  new Sudoku().generateSimple(0).swapCol(0, 1, 0);
	private Sudoku invalidSudoku_02_03 = new Sudoku().generateSimple(0).swapCol(2, 3, 0);
	private Sudoku invalidSudoku_10 = new Sudoku().generateSimple(0).setVal(0, 0, 10);

	@Test
	public void timingValidSudoku() {
		System.out.println("\ntimingValidSudoku:");

		int N = 100_000;
		
		// Duration1 (boolean) 100000 = 78 mls = 55 mls without additional vars in 3x3
		long start = System.currentTimeMillis();
		for(int i=0; i<N; i++ ) {
			validSudoku.isValid();
		}
		long durmls = System.currentTimeMillis() - start;
		System.out.printf("Duration1 (boolean) %d = %d mls\n", N, durmls);
		
		// Duration2 (HashSet) 100000 = 812 mls 760 mls without additional vars in 3x3
		Sudoku slow = new SlowSudoku().generateSimple(0);
		start = System.currentTimeMillis();
		for(int i=0; i<N; i++ ) {
			slow.isValid();
		}
		durmls = System.currentTimeMillis() - start;
		System.out.printf("Duration2 (HashSet) %d = %d mls\n", N, durmls);
	}

	@Test
	public void testValidSudoku() {
		System.out.println("\ntestValidSudoku:");
		validSudoku.print(System.out);
		assertTrue(validSudoku.isValid());
	}

	@Test
	public void testInvalid9x9_00_01() {
		System.out.println("\ntestInvalid9x9_00_01:");
		invalidSudoku_00_01.print(System.out);
		assertFalse(invalidSudoku_00_01.isInvalid9x9());
	}

	@Test
	public void testValid3x3_00_01() {
		System.out.println("\ntestValid3x3_00_01:");
		invalidSudoku_00_01.print(System.out);
		assertTrue(invalidSudoku_00_01.isInvalid3x3());
	}

	@Test
	public void testInvalid3x3_02_03() {
		System.out.println("\ntestInvalid3x3_02_03:");
		invalidSudoku_02_03.print(System.out);
		assertFalse(invalidSudoku_02_03.isInvalid3x3());
	}

	@Test
	public void testInvalidSudoku_10() {
		System.out.println("\ntestInvalidSudoku_10:");
		invalidSudoku_10.print(System.out);
		assertFalse(invalidSudoku_10.isValid());
	}

	@Test
	public void testGenerateSudoku() {
		System.out.println("\ntestGenerateSudoku:");
		Sudoku sudoku = new Sudoku().generateSimple(1000);
		sudoku.print(System.out);
		assertTrue(sudoku.isValid());
	}

}
