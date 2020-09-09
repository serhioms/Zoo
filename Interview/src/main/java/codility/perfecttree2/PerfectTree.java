package codility.perfecttree2;

import java.util.Set;
import java.util.TreeSet;

public class PerfectTree {

	public Set<Integer> findMaxPerfectNodes(Tree root) {

		int[] maxDeep = new int[] {0};
		Tree[] maxRoot = new Tree[]{null};
		
		Tree.traversTree(0, root, (node, d)->{
			if( node.l != null && node.r != null ) {
				// node is perfect then minimal perfect deep is the size of correspondent perfect tree!
				int minDeep = findMinPerfectDeep(node);
				if( minDeep > maxDeep[0] ) {
					maxDeep[0] = minDeep;
					maxRoot[0] = node;
				}
			}
			return true;
		});
		
		TreeSet<Integer> perfectNodes = new TreeSet<Integer>();
		selectPerfectNodes(maxRoot[0], maxDeep[0], perfectNodes);
		
		return perfectNodes;
	}

	public int findMinPerfectDeep(Tree root) {
		
		int[] minDeep = new int[] {Integer.MAX_VALUE};
		
		Tree.traversTree(0, root, (node, deep)->{
			if( node.l != null && node.r != null ) {
				return true; // still perfect!
			} else {
				minDeep[0] = Math.min(minDeep[0], deep);
				return false;
			}
		});
		
		return minDeep[0] == Integer.MAX_VALUE? -1: minDeep[0];
	}
	
	public void selectPerfectNodes(Tree root, int maxDeep, Set<Integer> perfectNodes) {
		Tree.traversTree(0, root, (node, deep)->{
			if( deep <= maxDeep ) {
				perfectNodes.add(node.id);
				return true;
			} else {
				return false;
			}
		});
	}
}