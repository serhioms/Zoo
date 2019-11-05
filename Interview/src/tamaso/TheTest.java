package tamaso;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

import java8.lambdas.Arrays2List;


public class TheTest {

	@Test
	public void testNumberTreasureTrucks() {
		List<List<Integer>> grid = new ArrayList<>(); 
		
		grid.add(Arrays2List.toListOf(new int[] {1,1,0,0}));
		grid.add(Arrays2List.toListOf(new int[] {0,0,1,0}));
		grid.add(Arrays2List.toListOf(new int[] {0,0,0,0}));
		grid.add(Arrays2List.toListOf(new int[] {1,0,1,1}));
		grid.add(Arrays2List.toListOf(new int[] {1,1,1,1}));
        assertEquals(3, numberTreasureTrucks(5, 4, grid));
        
        grid.clear();
		grid.add(Arrays2List.toListOf(new int[] {1,0,0,0}));
		grid.add(Arrays2List.toListOf(new int[] {0,1,0,0}));
		grid.add(Arrays2List.toListOf(new int[] {0,0,1,0}));
		grid.add(Arrays2List.toListOf(new int[] {0,0,0,1}));
        assertEquals(4, numberTreasureTrucks(4, 4, grid));
        
        grid.clear();
		grid.add(Arrays2List.toListOf(new int[] {0,1,0,0,0}));
		grid.add(Arrays2List.toListOf(new int[] {1,0,1,1,0}));
		grid.add(Arrays2List.toListOf(new int[] {1,1,0,1,1}));
		grid.add(Arrays2List.toListOf(new int[] {0,0,1,0,0}));
		grid.add(Arrays2List.toListOf(new int[] {1,1,1,0,0}));
        assertEquals(4, numberTreasureTrucks(5, 5, grid));
	}

	int numberTreasureTrucks(int rows, int column, List<List<Integer>> grid) {
		int result = 0;
		
		LinkedList<int[]> cells = new LinkedList<>(); 
		
		for (int r = 0; r < rows; r++) {
			List<Integer> cols = grid.get(r);
			for (int c = 0; c < column; c++) {
				Integer cell = cols.get(c);
				if (cell == 1) {
					cells.add(new int[]{r,c});
				}
			}
		}

		System.out.println(cells.stream().map(arr->Arrays.stream(arr).boxed().collect(Collectors.toList())).collect(Collectors.toList()));
		
		while( cells.size() != 0 ) {

			LinkedList<int[]> block = new LinkedList<>(); 
			block.add(cells.poll());

			for(int restSize=0; cells.size() > 0 && cells.size() != restSize; ) {
				int[] cell = cells.poll();
				
				if( isItOneBlock(block, cell) ) {
					block.add(cell);
					restSize = 0;
				} else {
					cells.add(cell);
					restSize++;
				}
			}
			
			result++;
		}
		return result;
	}

	private boolean isItOneBlock(List<int[]> block, int[] cell) {
		for(int[] bcel: block ) {
			if( isItOneBlock(bcel, cell) ) {
				return true;
			}
		}
		return false;
	}

	private boolean isItOneBlock(int[] bcel, int[] cell) {
		if( bcel[0] == cell[0] &&  Math.abs(bcel[1] - cell[1]) == 1) {
			return true;
		} else if( bcel[1] == cell[1] &&  Math.abs(bcel[0] - cell[0]) == 1) {
			return true;
		}
		return false;
	}

	
	
	
	
	@Test
	public void testCriticalRouters() {
		List<List<Integer>> grid = new ArrayList<>(); 
		
		grid.add(Arrays2List.toListOf(new int[] {0,1}));
		grid.add(Arrays2List.toListOf(new int[] {0,2}));
		grid.add(Arrays2List.toListOf(new int[] {1,3}));
		grid.add(Arrays2List.toListOf(new int[] {2,3}));
		grid.add(Arrays2List.toListOf(new int[] {2,5}));
		grid.add(Arrays2List.toListOf(new int[] {5,6}));
		grid.add(Arrays2List.toListOf(new int[] {3,4}));
        assertEquals("[2, 3, 5]", criticalRouters(7, 7, grid).toString());
        
        grid.clear();
		grid.add(Arrays2List.toListOf(new int[] {1,2}));
		grid.add(Arrays2List.toListOf(new int[] {1,3}));
		grid.add(Arrays2List.toListOf(new int[] {2,3}));
		grid.add(Arrays2List.toListOf(new int[] {3,4}));
		grid.add(Arrays2List.toListOf(new int[] {4,5}));
		grid.add(Arrays2List.toListOf(new int[] {4,6}));
		grid.add(Arrays2List.toListOf(new int[] {5,6}));
		grid.add(Arrays2List.toListOf(new int[] {5,7}));
		grid.add(Arrays2List.toListOf(new int[] {6,7}));
		grid.add(Arrays2List.toListOf(new int[] {7,8}));
		grid.add(Arrays2List.toListOf(new int[] {8,9}));
		grid.add(Arrays2List.toListOf(new int[] {8,10}));
		grid.add(Arrays2List.toListOf(new int[] {9,10}));
        assertEquals("[3, 4, 7, 8]", criticalRouters(10, 13, grid).toString());
        
	}

	List<Integer> criticalRouters(int numRouters, int numLinks, List<List<Integer>> links) {
		List<Integer> result = new ArrayList<>();
		
		for (int remRouter=1; remRouter <= numRouters; remRouter++) {
			
			LinkedList<List<Integer>> restLinks = new LinkedList<>();
			for( List<Integer> link: links) {
				if (!link.contains(remRouter)) {
					restLinks.add(link);
				}
			}
			
			Set<Integer> restRouters = new HashSet<>();
			
			restRouters.addAll(restLinks.poll());
			
			int expectRouters = numRouters-1;
			
			for(int restSize=0; restRouters.size() < expectRouters && restLinks.size() > 0; ) {
				List<Integer> link = restLinks.poll();
				
				if( restRouters.contains(link.get(0)) || restRouters.contains(link.get(1))) {
					restRouters.addAll(link);
					restSize = 0;
				} else {
					restLinks.add(link);
					restSize++;
				}
				if( restSize == restLinks.size() ) {
					break;
				}
			}
			
			if( restRouters.size() != expectRouters ) {
				result.add(remRouter);
			}
		}
		
		return result;
	}

}
