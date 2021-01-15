package coworkersdility.perfecttree;

import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class PerfectTreeRecursion {

	public int findMaxDeepnessRecursivelly(Tree node, int deep) {
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
	
	public void selectPerfectNodesRecursivelly(Tree node, int deep, Set<Integer> perfect) {
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
	
	public Set<Integer> findMaxPerfect(Tree root) {

		AtomicInteger maxd = new AtomicInteger(0);
		AtomicReference<Tree> maxr = new AtomicReference<Tree>(null);
		
		Tree.traversDeepFirst(0, root, (r, x)->{
			if( r != null && r.l != null && r.r != null ) {
				int deep = findMaxDeepnessRecursivelly(r, 0);
				if( deep > maxd.get() ) {
					maxd.set(deep);
					maxr.set(r);
				}
			}
		});
		
		TreeSet<Integer> treeSet = new TreeSet<Integer>();
		selectPerfectNodesRecursivelly(maxr.get(), maxd.get(), treeSet);
		
		return treeSet;
	}

}