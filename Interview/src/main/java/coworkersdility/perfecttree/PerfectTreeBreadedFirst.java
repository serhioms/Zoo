package coworkersdility.perfecttree;

import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class PerfectTreeBreadedFirst extends PerfectTreeRecursion {

	public Set<Integer> findMaxPerfect(Tree root) {

		AtomicInteger maxd = new AtomicInteger(0);
		AtomicReference<Tree> maxr = new AtomicReference<Tree>(null);
		
		Tree.traversBreadedFirst(root, (r, x)->{
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