package codility.perfecttree2;

import java.util.stream.IntStream;

public class Tree {
	
	/*
	 * Tree model 
	 */
	public int id;
	public Tree l;
	public Tree r;
	
	public Tree(int id, Tree l, Tree r) {
		this.id = id;
		this.l = l;
		this.r = r;
	}
	
	@Override
	public String toString() {
		return Integer.toString(id);
	}

	/*
	 * Tree builder
	 */
	public Tree(int id) {
		this.id = id;
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
	 * Tree traversal 
	 */
    public static interface Visitor {
    	public boolean visit(Tree node, int deep);
    }
    
    public static void traversTree(int deep, Tree node, Visitor v) {
    	if( node != null ){
    		if( v.visit(node, deep) ) {
		    	traversTree(deep+1, node.l, v);
		    	traversTree(deep+1, node.r, v);
    		}
    	}
	}
    
	/*
	 * Tree view 
	 */
    public static void showTree(Tree root, int mid) {
		IntStream.range(0, mid).forEach(i->System.out.print("\t"));
		System.out.println(root);
		Tree.traversTree(mid, root, (t, d)->{
			IntStream.range(0, d-1).forEach(i->System.out.print("\t"));
			System.out.print(t.l==null?".":t.l);
			IntStream.range(0, 2).forEach(i->System.out.print("\t"));
			System.out.println(t.r==null?".":t.r);
			return true;
		});
	}

}