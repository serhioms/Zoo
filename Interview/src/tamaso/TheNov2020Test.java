package tamaso;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.Test;

import java8.lambdas.Arrays2List;


public class TheNov2020Test {

	Random rand = new Random();
	
	@Test
	public void testNumberTreasureTrucks() {
		List<List<Integer>> grid = new ArrayList<>(); 
		
		grid.add(Arrays2List.toListOf(new int[] {1,1,0,0}));
		grid.add(Arrays2List.toListOf(new int[] {0,0,1,0}));
		grid.add(Arrays2List.toListOf(new int[] {0,0,0,0}));
		grid.add(Arrays2List.toListOf(new int[] {1,0,1,1}));
		grid.add(Arrays2List.toListOf(new int[] {1,1,1,1}));
        assertEquals(3, numberTreasureTrucks(5, 4, grid));
        assertEquals(3, numberTreasureTrucksVieGraphAlgo(5, 4, grid));
        
        grid.clear();
		grid.add(Arrays2List.toListOf(new int[] {1,0,0,0}));
		grid.add(Arrays2List.toListOf(new int[] {0,1,0,0}));
		grid.add(Arrays2List.toListOf(new int[] {0,0,1,0}));
		grid.add(Arrays2List.toListOf(new int[] {0,0,0,1}));
        assertEquals(4, numberTreasureTrucks(4, 4, grid));
        assertEquals(4, numberTreasureTrucksVieGraphAlgo(4, 4, grid));
        
        grid.clear();
		grid.add(Arrays2List.toListOf(new int[] {0,1,0,0,0}));
		grid.add(Arrays2List.toListOf(new int[] {1,0,1,1,0}));
		grid.add(Arrays2List.toListOf(new int[] {1,1,0,1,1}));
		grid.add(Arrays2List.toListOf(new int[] {0,0,1,0,0}));
		grid.add(Arrays2List.toListOf(new int[] {1,1,1,0,0}));
        assertEquals(4, numberTreasureTrucks(5, 5, grid));
        assertEquals(4, numberTreasureTrucksVieGraphAlgo(5, 5, grid));
	}

	private int numberTreasureTrucksVieGraphAlgo(int rows, int cols, List<List<Integer>> grid) {
		
		LinkedList<List<Integer>> graph = createGraphFromGrid(rows, cols, grid, cell->cell==1); 

		AtomicInteger cost = new AtomicInteger(0);
		List<List<List<Integer>>> subgraphs = separateSubgraphByLinks(graph, 
				(subgraph, link)-> canCellBeJoinedToBlock(subgraph, link), 
				cost);

		System.out.println("numberTreasureTrucksVieGraphAlgo = "+"cost = "+cost.intValue()+" "+graph.stream().map(arr->arr.stream().collect(Collectors.toList())).collect(Collectors.toList()));

		return subgraphs.size();
	}

	int numberTreasureTrucks(int rows, int cols, List<List<Integer>> grid) {
		int result = 0, cost = 0;
		
		LinkedList<List<Integer>> graph = createGraphFromGrid(rows, cols, grid, cell->cell==1); 
		
		while( graph.size() != 0 ) {

			LinkedList<List<Integer>> block = new LinkedList<>(); 
			block.add(graph.poll());

			for(int restsize=0; graph.size() > 0 && graph.size() != restsize; ++cost) {
				List<Integer> cell = graph.poll();
				
				if( canCellBeJoinedToBlock(block, cell) ) {
					block.add(cell);
					restsize = 0;
				} else {
					graph.add(cell);
					restsize++;
				}
			}
			
			result++;
		}

		System.out.println("numberTreasureTrucks = "+"cost = "+cost+" "+graph.stream().map(arr->arr.stream().collect(Collectors.toList())).collect(Collectors.toList()));

		return result;
	}

	private boolean canCellBeJoinedToBlock(List<List<Integer>> block, List<Integer> cell) {
		for(List<Integer> bcell: block ) {
			if( isItBlock(bcell, cell) ) {
				return true;
			}
		}
		return false;
	}

	private boolean isItBlock(List<Integer> bcell, List<Integer> cell) {
		if( bcell.get(0) == cell.get(0) &&  Math.abs(bcell.get(1) - cell.get(1)) == 1) {
			return true;
		} else if( bcell.get(1) == cell.get(1) &&  Math.abs(bcell.get(0) - cell.get(0)) == 1) {
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
		System.out.println(grid);
        assertEquals("[2, 3, 5]", criticalRouters(7, 7, grid).toString());
        assertEquals("[2, 3, 5]", criticalRoutersVieGraphAlgo(7, 7, grid).toString());
        
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
		System.out.println(grid);
        assertEquals("[3, 4, 7, 8]", criticalRouters(10, 13, grid).toString());
        assertEquals("[3, 4, 7, 8]", criticalRoutersVieGraphAlgo(10, 13, grid).toString());
        
	}

	List<Integer> criticalRouters(int numrouters, int numLinks, List<List<Integer>> links) {
		List<Integer> result = new ArrayList<>();
		AtomicInteger counter = new AtomicInteger(0);
		
		for (int remrouter=0; remrouter < numrouters; remrouter++) {
			
			LinkedList<List<Integer>> restlinks = new LinkedList<>();
			for( List<Integer> link: links) {
				if (!link.contains(remrouter)) {
					restlinks.add(link);
				}
			}
			
			Set<Integer> restRouters = new HashSet<>();
			
			restRouters.addAll(restlinks.poll());
			
			int expectRouters = numrouters-1;
			
			for(int restSize=0; restRouters.size() < expectRouters && restlinks.size() > 0; ) {
				counter.getAndIncrement();
				
				List<Integer> link = restlinks.poll();
				
				if( restRouters.contains(link.get(0)) || restRouters.contains(link.get(1))) {
					restRouters.addAll(link);
					restSize = 0;
				} else {
					restlinks.add(link);
					restSize++;
				}
				if( restSize == restlinks.size() ) {
					break;
				}
			}
			
			if( restRouters.size() != expectRouters ) {
				result.add(remrouter);
			}
		}
		
		System.out.println("criticalRouters full cost = "+counter.intValue());
		
		return result;
	}

	List<Integer> criticalRoutersVieGraphAlgo(int numrouters, int numLinks, List<List<Integer>> links) {
		List<Integer> result = new ArrayList<>();
		AtomicInteger counter = new AtomicInteger(0);
		AtomicInteger counter2 = new AtomicInteger(0);
		
		for (int remrouter=0; remrouter < numrouters; remrouter++) {
			
			LinkedList<List<Integer>> restlinks = new LinkedList<>();
			Set<Integer> lonevertex = removeLink(links, restlinks, remrouter);

			separateSubgraphByVertex(restlinks, 
					(vset, link)->vset.contains(link.get(0)) || vset.contains(link.get(1)), 
					counter);

			if( lonevertex.isEmpty() ) {
				List<Set<Integer>> vsubgraphl = separateSubgraphByVertex(restlinks, 
						(vset, link)->vset.contains(link.get(0)) || vset.contains(link.get(1)), 
						counter2);
				System.out.println(remrouter+" = "+restlinks+" = "+vsubgraphl);
				if( vsubgraphl.size() > 1 ) {
					result.add(remrouter);
				}
			} else {
				result.add(remrouter);
				System.out.println(remrouter+" = "+restlinks+" = -"+lonevertex);
			}
		}
		
		System.out.println("separateVertexBySubgraph full cost = "+counter.intValue());
		System.out.println("separateVertexBySubgraph reduced cost= "+counter2.intValue());
		
		return result;
	}

	/*
	 * Merging algoritm - cost m*n where m is number of subgraphs n number of links
	 * Input - list of links
	 * Output - list of subgraph's vertexes
	 */
	List<Set<Integer>> separateSubgraphByVertex(List<List<Integer>> links, VertexPredicate doesLinkBelongsToGraph, AtomicInteger counter) {
		LinkedList<Set<Integer>> subgraphs = new LinkedList<>();
		
		for(List<Integer> link: links) {
			
			Set<Integer> merge = new HashSet<>(links.size()+links.size());
			link.stream().forEach(merge::add);
			
			for(int i=subgraphs.size(); i>0; --i) {
				counter.incrementAndGet();
				
				Set<Integer> subgraph = subgraphs.poll();
				
				if( doesLinkBelongsToGraph.test(subgraph, link) ) {
					merge.addAll(subgraph);
				} else {
					subgraphs.add(subgraph);
				}
			}
			subgraphs.add(merge);
		}
		return subgraphs;
	}

	public static interface VertexPredicate {
		public boolean test(Set<Integer> subgaph, List<Integer> link);
	}

	List<List<List<Integer>>> separateSubgraphByLinks(List<List<Integer>> links, LinkPredicate doesLinkBelongsToGraph, AtomicInteger counter) {
		LinkedList<List<List<Integer>>> subgraphs = new LinkedList<>();
		
		for(List<Integer> link: links) {
			
			List<List<Integer>> merge = new LinkedList<>();
			merge.add(link);
			
			for(int i=subgraphs.size(); i>0; --i) {
				counter.incrementAndGet();
				
				List<List<Integer>> subgraph = subgraphs.poll();
				
				if( doesLinkBelongsToGraph.test(subgraph, link) ) {
					merge.addAll(subgraph);
				} else {
					subgraphs.add(subgraph);
				}
			}
			subgraphs.add(merge);
		}
		return subgraphs;
	}

	public static interface LinkPredicate {
		public boolean test(List<List<Integer>> subgraph, List<Integer> link);
	}

	private Set<Integer> removeLink(List<List<Integer>> links, LinkedList<List<Integer>> restlinks, int remvertex) {
		Set<Integer> vlone = new HashSet<>(links.size());
		Set<Integer> vrest = new HashSet<>(links.size());

		for( List<Integer> link: links) {
			if (!link.contains(remvertex)) {
				restlinks.add(link);
				vrest.add(link.get(0));
				vrest.add(link.get(1));
			} else {
				vlone.add(link.get(0));
				vlone.add(link.get(1));
			}
		}
		
		vlone.removeAll(vrest);
		vlone.remove(remvertex);
		return vlone;
	}

	private LinkedList<List<Integer>> createGraphFromGrid(int rows, int cols, List<List<Integer>> grid, Predicate<Integer> isOccupied) {
		LinkedList<List<Integer>> graph = new LinkedList<>(); 
		
		for (int r = 0; r < rows; r++) {
			List<Integer> column = grid.get(r);
			for (int c = 0; c < cols; c++) {
				Integer cell = column.get(c);
				if ( isOccupied.test(cell) ) {
					graph.add(Arrays.asList(r, c));
				}
			}
		}

		graph.sort((List<Integer> a, List<Integer> b)->rand.nextBoolean()?1:-1);

		return graph;
	}

}
