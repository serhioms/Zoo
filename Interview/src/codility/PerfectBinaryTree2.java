package codility;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class PerfectBinaryTree2 {

    Set<Integer> N = new TreeSet<Integer>();
    List<String> P = new ArrayList<String>();

	@Test
    public void test1() {
		Tree root =	
				new Tree(1, 
					new Tree(2, 
							null, 
							new Tree(4, 
									null, 
									null)
							),
					new Tree(3,
							new Tree(5, 
								new Tree(7, 
										null, 
										null), 
								new Tree(8, 
										null, 
										null)
								), 				
							new Tree(6,
								new Tree(9, 
										null, 
										null), 
								new Tree(10,
										new Tree(11, 
												null, 
												null), 
										null)
								)
							)
					);

		N.clear();
		P.clear();
		howManyNodesInMaxPerfectSubtree(root);
        assertEquals("[3, 5, 6, 7, 8, 9, 10]", N.toString());
	}

    public boolean isRight(Tree t, Set<Integer> N){
    	return t.r != null && N.contains(t.r.i);
    }
    
    public boolean isLeft(Tree t, Set<Integer> N){
    	return t.l != null && N.contains(t.l.i);
    }

    public boolean isPerfect(Tree t, Set<Integer> N){
    	return t != null && N.contains(t.i);
    }


    public void howManyNodesInMaxPerfectSubtree(Tree T) {
        collectPerfectNodes(T, true);
        System.out.println("collectPerfectNodes= "+N);

        removeUnbalancedNodes(T);
        System.out.println("removeUnbalancedNodes= "+N);
    }

    private void removeUnbalancedNodes(Tree t){
         if( !isPerfect(t, N) ){
        	 // skip
         } else if( isLeft(t, N) && isRight(t, N) ){
        	 
            int l = calcWeight(t.l);
            int r = calcWeight(t.r);
            
            System.out.println(l+" "+t.i+" "+r);
            
            if( l == r ){
            	// return; // bingo! lets check if another one exists... 
            	// copyToPerfectList(t, t.x); // todo: not implemented
            }

            N.remove(t.i);
           	removeUnbalancedNodes(t.r);
           	removeUnbalancedNodes(t.l);
         } else if( isLeft(t, N) ){
             N.remove(t.i);
             removeUnbalancedNodes(t.l);
         } else if( isRight(t, N) ){
             N.remove(t.i);
             removeUnbalancedNodes(t.r);
          }       
    }
    
    private String copyToPerfectList(Tree t, String perf) {
		N.remove(t.i);
		if( isLeft(t, N)){
			copyToPerfectList(t.l, perf+","+t.l);
		}
		if( isRight(t, N)){
			copyToPerfectList(t.r, perf+","+t.r);
		}
		return "???";
    }

	private int calcWeight(Tree t){
        int left=0, right=0;
        if( isLeft(t, N)){
            left = calcWeight(t.l);
        }
        if( isRight(t, N)){
            right = calcWeight(t.r);
        }
       return left+right+1;
    }
    
    private void collectPerfectNodes(Tree t, boolean ifParentIn){
        if( t.l != null && t.r != null ){
            N.add(t.i);
            N.add(t.l.i);
            N.add(t.r.i);
        	collectPerfectNodes(t.l, true);
        	collectPerfectNodes(t.r, true);
        } else if( t.l == null && t.r == null ){
        	if( ifParentIn ){
        		N.add(t.i);
        	}
        } else if( t.l != null ){
        	collectPerfectNodes(t.l, false);
        } else if( t.r != null ){
        	collectPerfectNodes(t.r, false);
        }
    }

	@Test
	public void test2(){
		Tree root = 
			new Tree(1)
				.left(new Tree(2)
						.right(new Tree(4))
						)
				.right(new Tree(3)
						.left(new Tree(5)
								.left(new Tree(7))
								.right(new Tree(8))
								)
						.right(new Tree(6)
								.left(new Tree(9))
								.right(new Tree(10)
										.left(new Tree(11))
										)
								)
						)
			;
		
		N.clear();
		P.clear();
		howManyNodesInMaxPerfectSubtree(root);
        assertEquals("[3, 5, 6, 7, 8, 9, 10]", N.toString());
	}

	@Test
	public void test3(){
		Tree root = 
			new Tree(1)
				.left(new Tree(2)
						.right(new Tree(4)
								.left(new Tree(44)
										.left(new Tree(441))
										.right(new Tree(442)
												.left(new Tree(4421))
												.right(new Tree(4422))
												)
										)
								.right(new Tree(45)
										.left(new Tree(451))
										.right(new Tree(452)
												.left(new Tree(4521))
												.right(new Tree(4522))
												)
										)
								)
						)
				.right(new Tree(3)
						.left(new Tree(5)
								.left(new Tree(7))
								.right(new Tree(8))
								)
						.right(new Tree(6)
								.left(new Tree(9))
								.right(new Tree(10)
										.left(new Tree(11))
										)
								)
						)
			;
		
		N.clear();
		P.clear();
		howManyNodesInMaxPerfectSubtree(root);
        assertEquals("[4, 4521, 4522, 44, 45, 441, 442, 451, 452, 4421, 4422]", N.toString());
	}
	
	@Test
	public void test4(){
		Tree root = 
			new Tree(1)
				.left(new Tree(2)
						.right(new Tree(4)
								.left(new Tree(44)
										.left(new Tree(441))
										.right(new Tree(442)
												.left(new Tree(4421))
												.right(new Tree(4422))
												)
										)
								.right(new Tree(45)
										.left(new Tree(451))
										.right(new Tree(452)
												.left(new Tree(4521))
												.right(new Tree(4522))
												)
										)
								)
						)
				.right(new Tree(3)
						.left(new Tree(5)
								.left(new Tree(7))
								.right(new Tree(8)
										.left(new Tree(88)
												.left(new Tree(888)
														.left(new Tree(8888)
																.left(new Tree(88888)
																		.left(new Tree(888888)
																				.left(new Tree(8888888)
																						.left(new Tree(88888888)
																								)
																						)
																				)
																		)
																)
														)
												)
										)
								)
						.right(new Tree(6)
								.left(new Tree(9))
								.right(new Tree(10)
										.left(new Tree(11))
										)
								)
						)
			;
		
		N.clear();
		P.clear();
		howManyNodesInMaxPerfectSubtree(root);
        assertEquals("[4, 4521, 4522, 44, 45, 441, 442, 451, 452, 4421, 4422]", N.toString());
	}
	
	@Test
	public void test5(){
		Tree root = 
			new Tree(1)
				.left(new Tree(2)
						.right(new Tree(64)
								.left(new Tree(644)
										.left(new Tree(6441))
										.right(new Tree(6442)
												.left(new Tree(64421))
												.right(new Tree(64422))
												)
										)
								.right(new Tree(645)
										.left(new Tree(6451))
										.right(new Tree(6452)
												.left(new Tree(64521))
												.right(new Tree(64522))
												)
										)
								)
						)
				.right(new Tree(3)
						.left(new Tree(5)
								.left(new Tree(7))
								.right(new Tree(8)
										.left(new Tree(88)
												.left(new Tree(888)
														.left(new Tree(8888)
																.left(new Tree(88888)
																		.left(new Tree(888888)
																				.left(new Tree(8888888)
																						.left(new Tree(88888888)
																								.right(new Tree(84)
																										.left(new Tree(844)
																												.left(new Tree(8441)
																														.left(new Tree(84411))
																														)
																												.right(new Tree(8442)
																														.left(new Tree(84421))
																														.right(new Tree(84422))
																														)
																												)
																										.right(new Tree(845)
																												.left(new Tree(8451)
																														.left(new Tree(84511))
																														)
																												.right(new Tree(8452)
																														.left(new Tree(84521))
																														.right(new Tree(84522))
																														)
																												)
																										)
																								
																								)
																						)
																				)
																		)
																)
														)
												)
										)
								)
						.right(new Tree(6)
								.left(new Tree(9))
								.right(new Tree(10)
										.left(new Tree(11))
										)
								)
						)
			;
		
		N.clear();
		P.clear();
		howManyNodesInMaxPerfectSubtree(root);
        assertEquals("[4, 4521, 4522, 44, 45, 441, 442, 451, 452, 4421, 4422]", N.toString());
	}
	
}
