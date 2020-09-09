package codility.perfecttree2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestSimpleTree {

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
    public void test() {
        assertEquals("[3, 5, 6, 7, 8, 9, 10]", new PerfectTree().findMaxPerfectNodes(root).toString());
	}

	@Test
    public void showTree() {
		Tree.showTree(root, 5);
	}
}