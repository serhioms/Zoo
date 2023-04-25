package codility.perfecttree2;

import java.util.Set;
import java.util.TreeSet;

public class PerfectTree {

	public Set<Integer> findMaxPerfectTree(Tree root) {

		int[] maxPerfect = new int[] {0};
		Tree[] maxRoot = new Tree[]{null};
		
		Tree.travers(0, root, (node, d)->{
			if( node.isPerfectNode() ) {
				/* 
				 * if node is perfect then minimal perfect deep is 
				 * the size of correspondent perfect tree!
				 */
				int minPerfect = findMinPerfectDeep(node);
				if( minPerfect > maxPerfect[0] ) {
					maxPerfect[0] = minPerfect;
					maxRoot[0] = node;
				}
			}
			return true; // continue traverse tree
		});
		
		TreeSet<Integer> perfectNodes = new TreeSet<Integer>();
		selectPerfectTree(maxRoot[0], maxPerfect[0], perfectNodes);
		
		return perfectNodes;
	}

	public int findMinPerfectDeep(Tree root) {
		
		int[] minDeep = new int[] {Integer.MAX_VALUE};
		
		Tree.travers(0, root, (node, deep)->{
			if( node.isPerfectNode() ) {
				return true;	// continue traverse tree
			} else {
				minDeep[0] = Math.min(minDeep[0], deep);
				return false;	// stop traverse tree
			}
		});
		
		return minDeep[0] == Integer.MAX_VALUE? -1: minDeep[0];
	}
	
	public void selectPerfectTree(Tree root, int maxDeep, Set<Integer> perfectNodes) {
		Tree.travers(0, root, (node, deep)->{
			if( deep <= maxDeep ) {
				perfectNodes.add(node.id);
				return true;	// continue traverse tree
			} else {
				return false;	// stop traverse tree
			}
		});
	}
}