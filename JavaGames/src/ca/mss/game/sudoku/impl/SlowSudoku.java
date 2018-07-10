package ca.mss.game.sudoku.impl;

import java.util.HashSet;
import java.util.Set;

public class SlowSudoku extends Sudoku {
	
	public SlowSudoku() {
		super();
	}

	public boolean isValid() {
		return isInvalid9x9() && isInvalid3x3();
	}

	public boolean isInvalid9x9() {
		try {
			Set<Integer> row = new HashSet<Integer>();
			Set<Integer> col = new HashSet<Integer>();
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					if( row.contains(sudoku[i][j]) ) {
						return false;
					} else {
						row.add(sudoku[i][j]); 
					}
					if( col.contains(sudoku[j][i]) ) {
						return false;
					} else {
						col.add(sudoku[j][i]); 
					}
				}
				row.clear();
				col.clear();
			}
			return true;
		} catch(Exception e) {
			return false;
		}
	}

	public boolean isInvalid3x3(int[][] sudoku) {
		try {
			Set<Integer> region = new HashSet<Integer>();
			for(int k=0; k<9; k+=3) {
				for(int l=0; l<9; l+=3) {
					for(int i=k+2; i>=k; i--) {
						for(int j=l+2; j>=l; j--) {
							if( region.contains(sudoku[i][j]) ) {
								return false;
							} else {
								region.add(sudoku[i][j]); 
							}
						}
					}
					region.clear();
				}
			}
			return true;
		} catch(Exception e) {
			return false;
		}
	}

}
