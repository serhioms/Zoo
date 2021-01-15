package coworkersdility.perfecttree;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestComplex {

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

        assertEquals("[3, 5, 6, 7, 8, 9, 10]", new PerfectTreeRecursion().findMaxPerfect(root).toString());
        assertEquals("[3, 5, 6, 7, 8, 9, 10]", new PerfectTreeBreadedFirst().findMaxPerfect(root).toString());
        assertEquals("[3, 5, 6, 7, 8, 9, 10]", new PerfectTreeQueue().findMaxPerfect(root).toString());
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
		
        assertEquals("[3, 5, 6, 7, 8, 9, 10]", new PerfectTreeRecursion().findMaxPerfect(root).toString());
        assertEquals("[3, 5, 6, 7, 8, 9, 10]", new PerfectTreeBreadedFirst().findMaxPerfect(root).toString());
        assertEquals("[3, 5, 6, 7, 8, 9, 10]", new PerfectTreeQueue().findMaxPerfect(root).toString());
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
		
		Tree.showTree(root, 7);
		
        assertEquals("[4, 44, 45, 441, 442, 451, 452]", new PerfectTreeRecursion().findMaxPerfect(root).toString());
        assertEquals("[3, 5, 6, 7, 8, 9, 10]", new PerfectTreeBreadedFirst().findMaxPerfect(root).toString());
        assertEquals("[3, 5, 6, 7, 8, 9, 10]", new PerfectTreeQueue().findMaxPerfect(root).toString());

	}
	
	@Test
	public void test31(){
		Tree root = 
			new Tree(1)
				.left(new Tree(2)
						.right(new Tree(4)
								.left(new Tree(44)
										.left(new Tree(441)
											.left(new Tree(4411))
											.right(new Tree(4412))
											)
										.right(new Tree(442)
											.left(new Tree(4421))
											.right(new Tree(4422))
											)
										)
								.right(new Tree(45)
										.left(new Tree(451)
											.left(new Tree(4511))
											.right(new Tree(4512))
											)
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
		
		Tree.showTree(root, 7);
		
        assertEquals("[4, 44, 45, 441, 442, 451, 452, 4411, 4412, 4421, 4422, 4511, 4512, 4521, 4522]", new PerfectTreeRecursion().findMaxPerfect(root).toString());
        assertEquals("[4, 44, 45, 441, 442, 451, 452, 4411, 4412, 4421, 4422, 4511, 4512, 4521, 4522]", new PerfectTreeBreadedFirst().findMaxPerfect(root).toString());
        assertEquals("[4, 44, 45, 441, 442, 451, 452, 4411, 4412, 4421, 4422, 4511, 4512, 4521, 4522]", new PerfectTreeQueue().findMaxPerfect(root).toString());
	}
	
	@Test
	public void test4(){
		Tree root = 
			new Tree(1)
				.left(new Tree(2)
						.right(new Tree(4)
								.left(new Tree(44)
										.left(new Tree(441)
											.left(new Tree(4411))
											.right(new Tree(4412))
											)
										.right(new Tree(442)
											.left(new Tree(4421))
											.right(new Tree(4422))
											)
										)
								.right(new Tree(45)
										.left(new Tree(451)
											.left(new Tree(4511))
											.right(new Tree(4512))
											)
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

		Tree.showTree(root, 10);

        assertEquals("[4, 44, 45, 441, 442, 451, 452, 4411, 4412, 4421, 4422, 4511, 4512, 4521, 4522]", new PerfectTreeRecursion().findMaxPerfect(root).toString());
        assertEquals("[4, 44, 45, 441, 442, 451, 452, 4411, 4412, 4421, 4422, 4511, 4512, 4521, 4522]", new PerfectTreeBreadedFirst().findMaxPerfect(root).toString());
        assertEquals("[4, 44, 45, 441, 442, 451, 452, 4411, 4412, 4421, 4422, 4511, 4512, 4521, 4522]", new PerfectTreeQueue().findMaxPerfect(root).toString());
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
		
        assertEquals("[64, 644, 645, 6441, 6442, 6451, 6452]", new PerfectTreeRecursion().findMaxPerfect(root).toString());
        assertEquals("[3, 5, 6, 7, 8, 9, 10]", new PerfectTreeBreadedFirst().findMaxPerfect(root).toString());
        assertEquals("[3, 5, 6, 7, 8, 9, 10]", new PerfectTreeQueue().findMaxPerfect(root).toString());
	}
	@Test
	public void test51(){
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
																														.right(new Tree(84412))
																														)
																												.right(new Tree(8442)
																														.left(new Tree(84421))
																														.right(new Tree(84422))
																														)
																												)
																										.right(new Tree(845)
																												.left(new Tree(8451)
																														.left(new Tree(84511))
																														.right(new Tree(84512))
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
		
        assertEquals("[84, 844, 845, 8441, 8442, 8451, 8452, 84411, 84412, 84421, 84422, 84511, 84512, 84521, 84522]", new PerfectTreeRecursion().findMaxPerfect(root).toString());
        assertEquals("[84, 844, 845, 8441, 8442, 8451, 8452, 84411, 84412, 84421, 84422, 84511, 84512, 84521, 84522]", new PerfectTreeBreadedFirst().findMaxPerfect(root).toString());
        assertEquals("[84, 844, 845, 8441, 8442, 8451, 8452, 84411, 84412, 84421, 84422, 84511, 84512, 84521, 84522]", new PerfectTreeQueue().findMaxPerfect(root).toString());
	}
	
}
