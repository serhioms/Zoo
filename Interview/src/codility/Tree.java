package codility;

import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

public class Tree {
	
	/*
	 * Tree model 
	 */
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
	 * Implement tree traversal/visitor 
	 */
    public static interface Visitor {
    	public void visit(Tree t, int d);
    }
    
    public static void traversR(Tree t, Visitor v, int d) { // deep first
    	if( t != null ){
    		v.visit(t, d);
	    	traversR(t.l, v, d-1);
	    	traversR(t.r, v, d+1);
    	}
	}
    
    public static void traversR(Tree t, Visitor v) {	// deep first
    	if( t != null ){
    		v.visit(t, 0);
	    	traversR(t.l, v, -1);
	    	traversR(t.r, v, +1);
    	}
	}
    
    public static void traversQ(Tree root, Visitor v) { // breaded first
		LinkedList<Tree> queue = new LinkedList<Tree>();
		queue.add(root);
		for(Tree t=queue.poll(); t != null; t=queue.poll()) {
    		v.visit(t, 0);
			if( t.l != null ) {
				queue.add(t.l);
			}
			if( t.r != null ) {
				queue.add(t.r);
			}
		}
	}
    
    public static void showTree(Tree root, int mid) {
		IntStream.range(0, mid).forEach(i->System.out.print("\t"));
		System.out.println(root);
		Tree.traversR(root, (t, d)->{
			IntStream.range(0, d-1).forEach(i->System.out.print("\t"));
			System.out.print(t.l==null?".":t.l);
			IntStream.range(0, 2).forEach(i->System.out.print("\t"));
			System.out.println(t.r==null?".":t.r);
		}, mid);
		System.out.println("\n=============================================================================\n");
	}
    
    /*
     * Implement perfect tree finder: double traversal/double recursive
     */
	private static int findMaxDeepnessRecursivelly(Tree node, int deep) {
		if( node != null ) {
			if( node.l != null || node.r != null ) {
				return Integer.min(
						findMaxDeepnessRecursivelly(node.l, deep+1), 
						findMaxDeepnessRecursivelly(node.r, deep+1));
			} else if( node.l == null || node.r == null ) {
				return deep+1;
			}
		}
		return deep;
	}
	
	private static void selectPerfectNodesRecursivelly(Tree node, int deep, Set<Integer> perfect) {
		if( node != null && deep > 0 ) {
			if( node.l != null && node.r != null ) {
				perfect.add(node.i);
				selectPerfectNodesRecursivelly(node.l, deep-1, perfect);
				selectPerfectNodesRecursivelly(node.r, deep-1, perfect);
			} else {
				perfect.add(node.i);
			}
		}
	}
	
	public static Set<Integer> findMaxPerfectRR(Tree root) {

		AtomicInteger maxd = new AtomicInteger(0);
		AtomicReference<Tree> maxr = new AtomicReference<Tree>(null);
		
		Tree.traversR(root, (r, x)->{
			if( r != null && r.l != null && r.r != null ) {
				int deep = findMaxDeepnessRecursivelly(r, 0);
				System.out.println("[root="+r+"][deep="+deep+"]");
				if( deep > maxd.get() ) {
					maxd.set(deep);
					maxr.set(r);
				}
			}
		});
		
		System.out.println("====================\nMAX[root="+maxr.get()+"][deep="+maxd.get()+"]");
		
		TreeSet<Integer> treeSet = new TreeSet<Integer>();
		selectPerfectNodesRecursivelly(maxr.get(), maxd.get(), treeSet);
		
		return treeSet;
	}
	
	public static Set<Integer> findMaxPerfectQR(Tree root) {

		AtomicInteger maxd = new AtomicInteger(0);
		AtomicReference<Tree> maxr = new AtomicReference<Tree>(null);
		
		Tree.traversQ(root, (r, x)->{
			if( r != null && r.l != null && r.r != null ) {
				int deep = findMaxDeepnessRecursivelly(r, 0);
				System.out.println("[root="+r+"][deep="+deep+"]");
				if( deep > maxd.get() ) {
					maxd.set(deep);
					maxr.set(r);
				}
			}
		});
		
		System.out.println("====================\nMAX[root="+maxr.get()+"][deep="+maxd.get()+"]");
		
		TreeSet<Integer> treeSet = new TreeSet<Integer>();
		selectPerfectNodesRecursivelly(maxr.get(), maxd.get(), treeSet);
		
		return treeSet;
	}
	
	public static Set<Integer> findMaxPerfectQ(Tree root) {

		LinkedList<Tree> queue = new LinkedList<Tree>();
		queue.add(root);
		
		AtomicInteger maxd = new AtomicInteger(0);
		AtomicReference<Tree> maxr = new AtomicReference<Tree>(null);
		
		for(Tree node=queue.poll(); node != null; node=queue.poll()) {
			if( node.l != null && node.r != null ) {
				int deep = findMaxDeepnessRecursivelly(node, 0);
				System.out.println("[root="+node+"][deep="+deep+"]");
				if( deep > maxd.get() ) {
					maxd.set(deep);
					maxr.set(node);
				}
			}
			if( node.l != null ) {
				queue.add(node.l);
			}
			if( node.r != null ) {
				queue.add(node.r);
			}
		}
		
		System.out.println("====================\nMAX[root="+maxr.get()+"][deep="+maxd.get()+"]");
		
		TreeSet<Integer> treeSet = new TreeSet<Integer>();
		selectPerfectNodesRecursivelly(maxr.get(), maxd.get(), treeSet);
		
		return treeSet;
	}
}