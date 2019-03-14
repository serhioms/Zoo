package codility;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

import codility.Tree.Visitor;

public class PerfectBinaryTree {

	@Test
    public void test1() {
		Tree root =	
				new Tree(1)
					.left(new Tree(2)
							.right(new Tree(4)))
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

        assertEquals("[3, 5, 6, 7, 8, 9, 10]", findMaxPerfect(root).toString());
	}

	private Set<Integer> findMaxPerfect(Tree root) {
	
		roots.add(root);
		Tree.travers(root, node->breakTree(node, false));

		System.out.println(roots);

		roots.stream().forEach(node->{
			Tree.travers(node, (e)->{
				
			});
		});
		
		return new HashSet<Integer>();
	}

	List<Tree> roots = new ArrayList<Tree>();
	Map<Tree, AtomicInteger> weight = new HashMap<Tree, AtomicInteger>(); 

	private void breakTree(Tree node, boolean isRoot) {
		if( node.l != null && node.r != null ){
			if( isRoot ){
				roots.add(node);
			}
			increment(node);
			increment(node.l);
			increment(node.r);
			breakTree(node.l, false);
			breakTree(node.r, false);
		} else if( node.l != null ){
			breakTree(node.l, true);
			node.l = null;
		} else if( node.r != null ){
			breakTree(node.r, true);
			node.r = null;
		}
	}

	private void increment(Tree n) {
		AtomicInteger i = weight.get(n);
		if( i == null ){
			weight.put(n, new AtomicInteger(1));
		} else {
			i.incrementAndGet();
		}
	}
}