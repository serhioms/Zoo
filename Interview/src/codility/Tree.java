package codility;

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
    	public void visit(Tree t);
    }
    
    public static void travers(Tree t, Visitor v){
    	if( t != null ){
    		v.visit(t);
	    	travers(t.l, v);
	    	travers(t.r, v);
    	}
    }}