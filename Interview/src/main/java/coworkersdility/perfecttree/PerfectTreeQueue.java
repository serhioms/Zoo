package coworkersdility.perfecttree;

import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class PerfectTreeQueue extends PerfectTreeRecursion {
	
	public Set<Integer> findMaxPerfect(Tree root) {

		LinkedList<Tree> queue = new LinkedList<Tree>();
		queue.add(root);
		
		AtomicInteger maxd = new AtomicInteger(0);
		AtomicReference<Tree> maxr = new AtomicReference<Tree>(null);
		
		for(Tree node=queue.poll(); node != null; node=queue.poll()) {
			if( node.l != null && node.r != null ) {
				int deep = findMaxDeepnessRecursivelly(node, 0);
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
		
		TreeSet<Integer> treeSet = new TreeSet<Integer>();
		selectPerfectNodesRecursivelly(maxr.get(), maxd.get(), treeSet);
		
		return treeSet;
	}
}