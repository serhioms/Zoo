package codility;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class Tree implements Runnable {
	
	public int i;
	public Tree l;
	public Tree r;
	
	public Tree(int x, Tree l, Tree r) {
		this.i = x;
		this.l = l;
		this.r = r;
	}
	
	

	@Override
	public String toString() {
		return Integer.toString(i);
	}



	/*
	 * High Order implementation
	 */
	@Override
	public void run() {
		System.out.println(i);
	}
	
	/*
	 * Implement tree builder
	 */
	public Tree(int x) {
		this.i = x;
	}

	public Tree add(Tree l, Tree r){
		this.l = l;
		this.r = r;
		return this;
	}
	
	public Tree left(Tree l){
		this.l = l;
		return this;
	}
	
	public Tree right(Tree r){
		this.r = r;
		return this;
	}
	
	/*
	 * 
	 */
    public static interface Visitor {
    	public void visit(Tree t, int d);
    }
    
    public static void travers(Tree t, Visitor v, int d) {
    	if( t != null ){
    		v.visit(t, d);
	    	travers(t.l, v, d-1);
	    	travers(t.r, v, d+1);
    	}
	}
    
    public static void show(Tree root, int mid) {
		IntStream.range(0, mid).forEach(i->System.out.print("\t"));
		System.out.println(root);
		Tree.travers(root, (t, d)->{
			IntStream.range(0, d-1).forEach(i->System.out.print("\t"));
			System.out.print(t.l==null?".":t.l);
			IntStream.range(0, 2).forEach(i->System.out.print("\t"));
			System.out.println(t.r==null?".":t.r);
		}, mid);
	}
    
    /*
     * 
     */
	public static Set<Integer> findMaxPerfect(Tree root) {
		
		Map<Integer, Pair<Integer,Integer>> perf = new HashMap<>();
		
		Tree.travers(root, (t, d)->{
			if( t.l != null && t.r != null ) {
				perf.put(t.i, new ImmutablePair<>(t.l.i, t.r.i));
			} else {
				perf.put(t.i, null);
			}
		}, 0);

		System.out.println("Perfect: "+perf.toString());
		
		AtomicInteger maxl = new AtomicInteger(0);
		AtomicInteger maxr = new AtomicInteger(0);
		
		perf.keySet()
			.stream()
			.forEach(r->{
				int nmaxl = findMaxLength(0, perf, r);
				System.out.println(r+" max = "+nmaxl);
				if( nmaxl > maxl.get() ) {
					maxl.set(nmaxl);
					maxr.set(r);
				}
			});
		
		System.out.println("==========");
		System.out.println(maxr.get()+" MAX = "+maxl.get());
		
		
		return selectMaxNodes(perf, maxr.get(), new HashSet<Integer>(), maxl.get());
	}

	public static int findMaxLength(int l, Map<Integer, Pair<Integer,Integer>> perf, int r) {
		Pair<Integer, Integer> pair = perf.get(r);
		if( pair == null ) {
			return l;
		} else if( pair.getLeft() == null || pair.getRight() == null ) {
			return l+1;
		} else {
			return Integer.min(findMaxLength(l+1, perf, pair.getLeft()), findMaxLength(l+1, perf, pair.getRight()));
		}
	}

	public static Set<Integer> selectMaxNodes(Map<Integer, Pair<Integer, Integer>> perf, int r, HashSet<Integer> fin, int l) {
		if( l >= 0 ) {
			Pair<Integer, Integer> pair = perf.get(r);
			if( pair == null ) {
				fin.add(r);
			} else if( pair.getLeft() == null && pair.getRight() == null ) {
				fin.add(r);
			} else if( pair.getLeft() != null && pair.getRight() != null ) {
				fin.add(r);
				selectMaxNodes(perf, pair.getLeft(), fin, l-1);
				selectMaxNodes(perf, pair.getRight(), fin, l-1);
			}
		}
		return fin;
	}

}