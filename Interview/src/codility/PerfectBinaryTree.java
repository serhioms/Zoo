package codility;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PerfectBinaryTree {

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

	@Test
    public void testPerfect() {
        assertEquals("[3, 5, 6, 7, 8, 9, 10]", Tree.findMaxPerfect(root).toString());
	}

	@Test
    public void testShowTree() {
		Tree.showTree(root, 5);
	}

	@Test
    public void testTreeFullPath() {
		Tree.travers(root, (t, d)->{
			System.out.println(t);
		}, 0);
	}

}