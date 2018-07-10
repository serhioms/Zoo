package ca.mss.game.sudoku.impl;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Sudoku {
	
	final public int N,M;
	protected int[][] sudoku;
	
	public Sudoku(int n, int m) {
		super();
		N = n;
		M = m;
	}

	public Sudoku() {
		this(9, 9);
	}

	public int[][] getSudoku() {
		return sudoku;
	}

	public void setSudoku(int[][] sudoku) {
		this.sudoku = sudoku;
	}

	public boolean isValid() {
		return isInvalid9x9() && isInvalid3x3();
	}

	public boolean isInvalid9x9() {
		try {
			for(int i=0; i<9; i++) {
				boolean[] row = new boolean[10];
				boolean[] col = new boolean[10];
				for(int j=0; j<9; j++) {
					if( row[sudoku[i][j]] ) {
						return false;
					} else {
						row[sudoku[i][j]] = true; 
					}
					if( col[sudoku[j][i]] ) {
						return false;
					} else {
						col[sudoku[j][i]] = true; 
					}
				}
			}
			return true;
		} catch(Exception e) {
//			System.out.flush();
//			e.printStackTrace(System.err);
//			System.err.flush();
			return false;
		}
	}

	public boolean isInvalid3x3() {
		try {
			for(int k=0; k<9; k+=3) {
				for(int l=0; l<9; l+=3) {
					boolean[] region = new boolean[10];
					for(int i=k+2; i>=k; i--) {
						for(int j=l+2; j>=l; j--) {
							if( region[sudoku[i][j]] ) {
								return false;
							} else {
								region[sudoku[i][j]] = true; 
							}
						}
					}
					
				}
			}
			return true;
		} catch(Exception e) {
//			System.out.flush();
//			e.printStackTrace(System.err);
//			System.err.flush();
			return false;
		}
	}

	public Sudoku generateSimple(int swaps) {
		sudoku = new int[][] {
			new int[] {1,2,3,4,5,6,7,8,9},
			new int[] {4,5,6,7,8,9,1,2,3},
			new int[] {7,8,9,1,2,3,4,5,6},
			new int[] {2,3,4,5,6,7,8,9,1},
			new int[] {5,6,7,8,9,1,2,3,4},
			new int[] {8,9,1,2,3,4,5,6,7},
			new int[] {3,4,5,6,7,8,9,1,2},
			new int[] {6,7,8,9,1,2,3,4,5},
			new int[] {9,1,2,3,4,5,6,7,8}
		};
		while( swaps-- > 0 ) {
			if( rand.nextBoolean() ) {
				swapRaw(0);
			}
			if( rand.nextBoolean() ) {
				swapRaw(1);
			}
			if( rand.nextBoolean() ) {
				swapRaw(2);
			}
			if( rand.nextBoolean() ) {
				swapCol(0);
			}
			if( rand.nextBoolean() ) {
				swapCol(1);
			}
			if( rand.nextBoolean() ) {
				swapCol(2);
			}
			if( rand.nextBoolean() ) {
				swapRowRegion();
			}
			if( rand.nextBoolean() ) {
				swapColRegion();
			}
		}
		return this;
	}

	/*
	 * Generate implementation
	 */
	static final Random rand = new Random(System.currentTimeMillis());

	public Sudoku swapRaw(int region) {
		int row = randOtherThen(-1);
		swapRaw(row+region*3, randOtherThen(row)+region*3);
		return this;
	}

	public int randOtherThen(int r) {
		for(int o=r; true; o=rand.nextInt(3)) {
			if( o != r ) return o;
		}
	}

	public Sudoku swapRaw(int i, int j) {
		int[] irow = sudoku[i];
		sudoku[i] = sudoku[j];
		sudoku[j] = irow;
		return this;
	}

	public Sudoku swapCol(int region) {
		int col = randOtherThen(-1);
		swapCol(col+region*3, randOtherThen(col)+region*3);
		return this;
	}

	public Sudoku swapCol(int i, int j) {
		for(int r=0; r<9; r++) {
			swapCol(i, j, r);
		}
		return this;
	}

	public Sudoku swapCol(int i, int j, int r) {
		int rcol = sudoku[r][i];
		sudoku[r][i] = sudoku[r][j];
		sudoku[r][j] = rcol;
		return this;
	}

	public Sudoku swapRowRegion() {
		int row = randOtherThen(-1);
		swapRowRegion(row, randOtherThen(row));
		return this;
	}

	public Sudoku swapRowRegion(int i, int j) {
		for(int k=0, i3=i*3, j3=j*3; k<3; k++) {
			swapRaw(i3+k, j3+k);
		}
		return this;
	}

	public Sudoku swapColRegion() {
		int col = randOtherThen(-1);
		swapColRegion(col, randOtherThen(col));
		return this;
	}

	public Sudoku swapColRegion(int i, int j) {
		for(int k=0, i3=i*3, j3=j*3; k<3; k++) {
			swapCol(i3+k, j3+k);
		}
		return this;
	}

	public Sudoku setVal(int i, int j, int val) {
		sudoku[i][j] = val;
		return this;
	}

	public Sudoku print(PrintStream out) {
		final AtomicInteger count = new AtomicInteger(0);
		Arrays.stream(sudoku).forEach(x -> Arrays.stream(x).forEach(y -> out.print(y+(count.incrementAndGet()%9==0?"\n":" "))));
		return this;
	}
}