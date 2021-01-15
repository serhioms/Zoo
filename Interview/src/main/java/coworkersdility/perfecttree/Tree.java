package coworkersdility.perfecttree;

import java.util.LinkedList;
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
    
    public static void traversDeepFirst(int deep, Tree t, Visitor v) {
    	if( t != null ){
    		v.visit(t, deep);
	    	traversDeepFirst(deep-1, t.l, v);
	    	traversDeepFirst(deep+1, t.r, v);
    	}
	}
    
    public static void traversBreadedFirst(Tree root, Visitor v) {
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
		Tree.traversDeepFirst(mid, root, (t, d)->{
			IntStream.range(0, d-1).forEach(i->System.out.print("\t"));
			System.out.print(t.l==null?".":t.l);
			IntStream.range(0, 2).forEach(i->System.out.print("\t"));
			System.out.println(t.r==null?".":t.r);
		});
	}

}