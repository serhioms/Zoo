package amazon;

import static org.junit.Assert.assertEquals;

import java.util.ArrayDeque;
import java.util.Queue;

import org.junit.Test;

import java8.lambdas.Arrays2List;
/*
 * Amazon | OA 2019 | Treasure Island
 * https://leetcode.com/discuss/interview-question/347457
 * 
 * Assume the map area is a two dimensional grid, represented by a matrix of characters. 
 * You must start from the top-left corner of the map and can move one block up, down, left or right at a time. 
 * The treasure island is marked as X in a block of the matrix. 
 * X will not be at the top-left corner. 
 * Any block with dangerous rocks or reefs will be marked as D. 
 * You must not enter dangerous blocks. 
 * You cannot leave the map area. 
 * Other areas O are safe to sail in. 
 * The top-left corner is always safe. 
 * Output the minimum number of steps to get to the treasure.
 * 
 * Example:
Input:
[['O', 'O', 'O', 'O'],
 ['D', 'O', 'D', 'O'],
 ['O', 'O', 'O', 'O'],
 ['X', 'D', 'D', 'O']]

Output: 5
Explanation: Route is (0, 0), (0, 1), (1, 1), (2, 1), (2, 0), (3, 0) The minimum route takes 5 steps
 * 
 */
public class TreasureIsland {

	private String solution1(char[][] grid) {
		return foundTreasure(grid, 0, 0, "");
	}

	int sol1Count = 0;
	
	private String foundTreasure(char[][] gred, int i, int j, String result) {
		if( i < 0 || j < 0 || i == gred.length || j == gred[0].length ) {
			return null;
		}
		
		char nextStep = gred[i][j];
		if( nextStep == 'D') {
			return null;
		}
		
		String step = "("+i+", "+j+")";
		
		if( result.contains(step)) {
			return null;
		}
		
		result += (result.isEmpty()?"":", ")+step;

		sol1Count++;

		if( nextStep == 'X') {
			return result;
		}

		String result1 = foundTreasure(gred, i, j+1, result);
		String result2 = foundTreasure(gred, i+1, j, result);
		String result3 = foundTreasure(gred, i, j-1, result);
		String result4 = foundTreasure(gred, i-1, j, result);
		
		return min(result1, result2, result3, result4);
	}
	
	private String min(String... result) {
		String min = null;
		for(String r: result) {
			if( r != null ) {
				if( min == null ) {
					min = r;
				} else if( r.length() < min.length() ) {
					min = r;
				}
			}
		}
		return min;
	}

	@Test
	public void test1() {
		char[][] grid = new char[][] {{'O', 'O', 'O', 'O'},
            {'D', 'O', 'D', 'O'},
            {'O', 'O', 'O', 'O'},
            {'X', 'D', 'D', 'O'}};
            
		assertEquals("(0, 0), (0, 1), (1, 1), (2, 1), (2, 0), (3, 0)", solution1(grid));
		assertEquals(22, sol1Count);
		
		assertEquals(5, minSteps(grid));
		assertEquals(10, sol2Count);
		assertEquals("[DDDD, DDDD, DDDD, XDDO]", Arrays2List.toListOfString(grid));
	}

/*
 * Amazon solution
 */
	
	int sol2Count = 0;
    private final int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public int minSteps(char[][] grid) {
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(0, 0));
        grid[0][0] = 'D'; // mark as visited
        for (int steps = 1; !q.isEmpty(); steps++) {
            for (int sz = q.size(); sz > 0; sz--) {
                Point p = q.poll();
            
                for (int[] dir : DIRS) {
                    int r = p.r + dir[0];
                    int c = p.c + dir[1];
                    
                    if (isSafe(grid, r, c)) {
                    	sol2Count++;
                        if (grid[r][c] == 'X') return steps;
                        grid[r][c] = 'D';
                        q.add(new Point(r, c));
                    }
                }
            }
        }
        return -1;
    }
    
    private boolean isSafe(char[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] != 'D';
    }
    
    private class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
