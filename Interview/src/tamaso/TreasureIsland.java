package tamaso;

import static org.junit.Assert.assertEquals;

import java.util.ArrayDeque;
import java.util.Queue;

import org.junit.Test;

import java8.lambdas.Arrays2List;
/*
 * Treasure Island
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
[['.', '.', '.', '.'],
 ['D', '.', 'D', '.'],
 ['.', '.', '.', '.'],
 ['X', 'D', 'D', '.']]

Output: 5
Explanation: Route is (0, 0), (0, 1), (1, 1), (2, 1), (2, 0), (3, 0) The minimum route takes 5 steps
 * 
 */
public class TreasureIsland {

	private String solution1(char[][] grid) {
		return foundTreasure(grid, 0, 0, "");
	}

	int sol1Count = 0;
	int sol2Count = 0;
	int sol3Count = 0;
	
	private String foundTreasure(char[][] grid, int r, int c, String result) {
		if( !isSafe(grid, r, c) ) {
			return null;
		}
		
		String step = "("+r+", "+c+")";
		
		if( result.contains(step)) {
			return null;
		}

		sol1Count++;

		result += (result.isEmpty()?"":", ")+step;

		if( grid[r][c] == 'X') {
			return result;
		} 

		String min = null;
		for(int[] dir : DIRS) {
			String rr = foundTreasure(grid, r+dir[0], c+dir[1], result);
			if( rr != null ) {
				if( min == null ) {
					min = rr;
				} else if( rr.length() < min.length() ) {
					min = rr;
				}
			}
		}
		return min;
	}
	
	@Test
	public void test1() {
		char[][] copy, grid = new char[][] {
			{'.', '.', '.', '.'},
            {'D', '.', 'D', '.'},
            {'.', '.', '.', '.'},
            {'X', 'D', 'D', '.'}};
            
//		assertEquals("(0, 0), (0, 1), (1, 1), (2, 1), (2, 0), (3, 0)", solution1(Arrays2List.copyOf(grid)));
//		assertEquals(22, sol1Count);

        System.out.println( String.join("\n",Arrays2List.toListOfString(grid)));
		assertEquals(5, minSteps(copy=Arrays2List.copyOf(grid)));
		assertEquals(5, minSteps2(copy=Arrays2List.copyOf(grid)));

        assertEquals("[0123, D2D4, 4345, XDD.]", Arrays2List.toListOfString(copy).toString());
		assertEquals(10, sol2Count);
	}

	/*
	 * Amazon solution
	 * BFS - Breadth-first search opposite to Depth-first 
	 */
    private final int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public int minSteps(char[][] grid) {
    	
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(0, 0));
        
        grid[0][0] = (char)('0'+0); // mark as visited
        
        for (int steps=1; !q.isEmpty(); steps++) {
            for (int i=q.size(); i > 0; i--) {
                Point p = q.poll();
            
                for (int[] dir : DIRS) {
                    int r = p.r + dir[0];
                    int c = p.c + dir[1];
                    
                    if (isSafe(grid, r, c)) {
                    	sol2Count++;
                        if (grid[r][c] == 'X') {
                        	return steps;
                        } else {
                        	grid[r][c] = (char)('0'+steps);
                        }
                        System.out.println("\n"+String.join("\n",Arrays2List.toListOfString(grid)));
                        q.add(new Point(r, c));
                    }
                }
            }
        }
        
        return -1;
    }
    
    public int minSteps2(char[][] grid) {
    	
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});
        
        grid[0][0] = (char)('0'+0); // mark as visited
        
        for (int steps=1; !q.isEmpty(); steps++) {
            for (int i=q.size(); i > 0; i--) {
            	int[] p = q.poll();
            
                for (int[] dir : DIRS) {
                    int r = p[0] + dir[0];
                    int c = p[1] + dir[1];
                    
                    if (isSafe(grid, r, c)) {
                    	sol3Count++;
                        if (grid[r][c] == 'X') {
                        	return steps;
                        } else {
                        	grid[r][c] = (char)('0'+steps);
                        }
                        System.out.println("\n"+String.join("\n",Arrays2List.toListOfString(grid)));
                        q.add(new int[]{r, c});
                    }
                }
            }
        }
        
        return -1;
    }
    
    private boolean isSafe(char[][] grid, int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && (grid[r][c] == '.' || grid[r][c] == 'X');
    }
    
    private class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
