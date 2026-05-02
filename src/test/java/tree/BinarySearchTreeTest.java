package tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BinarySearchTreeTest {

	@ParameterizedTest
	@MethodSource("adingNodesTestCases")
	@DisplayName("Test adding nodes to the binary search tree")
	void testAddNodes(TreeNode<Integer> root, Integer dataToAdd, Integer expectedRoot, Integer expectedLeft,
			Integer expectedRight) {

		root = BinarySearchTree.add(root, dataToAdd);
		assertEquals(expectedRoot, root.data, "Root should have the correct value.");

		if (expectedLeft != null) {
			assertNotNull(root.left, "Left child should not be null.");
			assertEquals(expectedLeft, root.left.data, "Left child should have the correct value.");
		} else {
			assertNull(root.left, "Left child should be null.");
		}

		if (expectedRight != null) {
			assertNotNull(root.right, "Right child should not be null.");
			assertEquals(expectedRight, root.right.data, "Right child should have the correct value.");
		} else {
			assertNull(root.right, "Right child should be null.");
		}
	}

	private static Stream<Arguments> adingNodesTestCases() {
		return Stream.of(Arguments.of(null, 10, 10, null, null), // Single node test case
				Arguments.of(BinarySearchTree.addAll(List.of(10)), 15, 10, null, 15), // Increasing order test case
				Arguments.of(BinarySearchTree.addAll(List.of(20)), 15, 20, 15, null), // Decreasing order test case
				Arguments.of(BinarySearchTree.addAll(List.of(15, 10)), 20, 15, 10, 20), // Balanced tree test case
				Arguments.of(BinarySearchTree.addAll(List.of(10, 15)), 15, 10, null, 15) // Duplicate node test case (left
																					// unchanged)
		);
	}

	@ParameterizedTest
	@MethodSource("providePreOrderTestCases")
	@DisplayName("Test the PreOrder Traversal of Binary Search Tree")
	void testPreOrderTraversal(TreeNode<Integer> rootNode, List<Integer> expectedOrder) {
		List<Integer> actualOrder = BinarySearchTree.preOrderTraversal(rootNode, new ArrayList<>());
		assertEquals(actualOrder, expectedOrder, "Pre-order traversal should match the expected order.");
	}

	private static Stream<Arguments> providePreOrderTestCases() {
		return Stream.of(Arguments.of(BinarySearchTree.addAll(List.of(3)), List.of(3)), // Single node test case
				Arguments.of(null, List.of()), // Null root (negative test case)
				Arguments.of(BinarySearchTree.addAll(List.of(10, 5, 1, 7, 15, 12)), List.of(10, 5, 1, 7, 15, 12)), // Complex test case
				Arguments.of(BinarySearchTree.addAll(List.of(5, 4, 1)), List.of(5, 4, 1)), // Left skewed tree test case
				Arguments.of(BinarySearchTree.addAll(List.of(8, 11, 13)), List.of(8, 11, 13)), // Right skewed tree test case
				Arguments.of(BinarySearchTree.addAll(List.of(10, 5, 11)), List.of(10, 5, 11)), // Left skewed tree test case
				Arguments.of(BinarySearchTree.addAll(List.of(5, 4, 1)), List.of(5, 4, 1)) // Left skewed tree test case
		);
	}

	@ParameterizedTest
	@MethodSource("provideInOrderTestCases")
	@DisplayName("Test the InOrder Traversal of Binary Search Tree")
	void testInOrderTraversal(TreeNode<Integer> rootNode, List<Integer> expectedOrder) {
		List<Integer> actualOrder = BinarySearchTree.inOrderTraversal(rootNode, new ArrayList<>());
		assertEquals(actualOrder, expectedOrder, "In-order traversal should match the expected order.");
	}

	private static Stream<Arguments> provideInOrderTestCases() {
		return Stream.of(Arguments.of(null, List.of()), // Null root
				Arguments.of(BinarySearchTree.addAll(List.of(10)), List.of(10)), // Single node
				Arguments.of(BinarySearchTree.addAll(List.of(10, 5, 1)), List.of(1, 5, 10)), // Left skewed tree
				Arguments.of(BinarySearchTree.addAll(List.of(10, 15, 20)), List.of(10, 15, 20)), // Right skewed tree
				Arguments.of(BinarySearchTree.addAll(List.of(10, 5, 15)), List.of(5, 10, 15)), // Balanced tree
				Arguments.of(BinarySearchTree.addAll(List.of(10, 5, 1, 7, 15, 12, 20)), List.of(1, 5, 7, 10, 12, 15, 20)) // Complex
																													// tree
		);
	}

	@ParameterizedTest
	@MethodSource("providePostOrderTestCases")
	@DisplayName("Test the postOrder Traversal of Binary Search Tree")
	void testPostOrderTraversal(TreeNode<Integer> rootNode, List<Integer> expectedOrder) {
		List<Integer> actualOrder = BinarySearchTree.postOrderTraversal(rootNode, new ArrayList<>());
		assertEquals(actualOrder, expectedOrder, "Post-order traversal should match the expected order.");
	}

	private static Stream<Arguments> providePostOrderTestCases() {
		return Stream.of(Arguments.of(null, List.of()), // Null root
				Arguments.of(BinarySearchTree.addAll(List.of(10)), List.of(10)), // Single node
				Arguments.of(BinarySearchTree.addAll(List.of(10, 5, 1)), List.of(1, 5, 10)), // Left skewed tree
				Arguments.of(BinarySearchTree.addAll(List.of(10, 15, 20)), List.of(20, 15, 10)), // Right skewed tree
				Arguments.of(BinarySearchTree.addAll(List.of(10, 5, 15)), List.of(5, 15, 10)), // Balanced tree
				Arguments.of(BinarySearchTree.addAll(List.of(10, 5, 1, 7, 15, 12, 20)), List.of(1, 7, 5, 12, 20, 15, 10)) // Complex
																													// tree
		);
	}

	@ParameterizedTest
	@MethodSource("provideLevelOrderTestCases")
	@DisplayName("Test the LevelOrder Traversal of Binary Search Tree")
	void testLevelOrderTraversal(TreeNode<Integer> rootNode, List<Integer> expectedOrder) {
		List<Integer> actualOrder = BinarySearchTree.levelOrderTraversal(rootNode);
		assertEquals(actualOrder, expectedOrder, "Level-order traversal should match the expected order.");
	}

	private static Stream<Arguments> provideLevelOrderTestCases() {
		return Stream.of(Arguments.of(null, List.of()), // Null root
				Arguments.of(BinarySearchTree.addAll(List.of(10)), List.of(10)), // Single node
				Arguments.of(BinarySearchTree.addAll(List.of(10, 5, 1)), List.of(10, 5, 1)), // Left skewed tree
				Arguments.of(BinarySearchTree.addAll(List.of(10, 15, 20)), List.of(10, 15, 20)), // Right skewed tree
				Arguments.of(BinarySearchTree.addAll(List.of(10, 5, 15)), List.of(10, 5, 15)), // Balanced tree
				Arguments.of(BinarySearchTree.addAll(List.of(10, 5, 1, 7, 15, 12, 20)), List.of(10, 5, 15, 1, 7, 12, 20)) // Complex
		);
	}

	@ParameterizedTest
	@MethodSource("provideDeleteNodeIITestcases")
	@DisplayName("Delete all nodes those are grater than k")
	void testDeleteNodeII(TreeNode<Integer> rootNode, Integer k, TreeNode<Integer> expected) {
		TreeNode<Integer> actual = BinarySearchTree.deleteNodeII(rootNode, k);
		assertTrue(BinarySearchTree.twoTreesAreEqual(expected, actual));
	}

	private static Stream<Arguments> provideDeleteNodeIITestcases() {
		return Stream.of(
				// Case 1: Simple tree, delete all nodes greater than 10
				Arguments.of(BinarySearchTree.addAll(List.of(10, 5, 15, 3, 7, 20)), 10,
						BinarySearchTree.addAll(List.of(10, 5, 3, 7))),
				// Case 2: Deleting nodes greater than 5
				Arguments.of(BinarySearchTree.addAll(List.of(10, 5, 15, 3, 7, 20)), 5, BinarySearchTree.addAll(List.of(5, 3))),
				// Case 3: Deleting nodes greater than 20 (no node is deleted)
				Arguments.of(BinarySearchTree.addAll(List.of(10, 5, 15, 3, 7, 20)), 20,
						BinarySearchTree.addAll(List.of(10, 5, 15, 3, 7, 20))),
				// Case 4: Deleting all nodes greater than 0 (entire tree is deleted)
				Arguments.of(BinarySearchTree.addAll(List.of(10, 5, 15, 3, 7, 20)), 0, null), // Tree becomes null
				// Case 5: Empty tree (no deletion)
				Arguments.of(null, 10, null));
	}

	@ParameterizedTest
	@MethodSource("provideDeleteNodeTestCases")
	@DisplayName("Test the Deleting a Node of a binary search tree")
	void testDeleteNode(TreeNode<Integer> rootNode, Integer dataToDelete, TreeNode<Integer> expected) {
		// Perform the deletion operation
		TreeNode<Integer> actual = BinarySearchTree.deleteNode(rootNode, dataToDelete);

		// Compare the actual tree structure with the expected structure
		assertTrue(BinarySearchTree.twoTreesAreEqual(actual, expected),
				"The tree after deletion should match the expected tree.");
	}

	private static Stream<Arguments> provideDeleteNodeTestCases() {
		return Stream.of(
				// Case 1: Deleting a leaf node
				Arguments.of(BinarySearchTree.addAll(List.of(10, 5, 15, 3, 7)), 7, BinarySearchTree.addAll(List.of(10, 5, 15, 3))));
	}

	@ParameterizedTest
	@MethodSource("provideBSTLeftSideViewTestCases")
	@DisplayName("Test the binary search tree Left Side View")
	void testBSTLeftSideView(TreeNode<Integer> root, List<Integer> expected) {
		List<Integer> actual = BinarySearchTree.bstLeftSideView(root);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> provideBSTLeftSideViewTestCases() {
		return Stream.of(Arguments.of(BinarySearchTree.addAll(List.of(15, 20, 10, 18, 5, 13, 25)), List.of(15, 10, 5)),
				Arguments.of(BinarySearchTree.addAll(List.of(5, 8, 3, 6, 9)), List.of(5, 3, 6)),
				Arguments.of(BinarySearchTree.addAll(List.of(8, 5)), List.of(8, 5)), Arguments.of(null, List.of()));
	}

	@ParameterizedTest
	@MethodSource("provideBSTRightSideViewTestCases")
	@DisplayName("Test the binary search tree Right Side View")
	void testBSTRightSideView(TreeNode<Integer> root, List<Integer> expected) {
		List<Integer> actual = BinarySearchTree.bstRightSideView(root);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> provideBSTRightSideViewTestCases() {
		return Stream.of(Arguments.of(BinarySearchTree.addAll(List.of(15, 20, 10, 18, 5, 13, 25, 4)), List.of(15, 20, 25, 4)),
				Arguments.of(BinarySearchTree.addAll(List.of(5, 8, 3, 6, 9)), List.of(5, 8, 9)),
				Arguments.of(BinarySearchTree.addAll(List.of(8, 5)), List.of(8, 5)), Arguments.of(null, List.of()));
	}

	@ParameterizedTest
	@MethodSource("provideFindHeightBSTTestCases")
	@DisplayName("Test Find Height of Binary Search Tree")
	void testFindHeightBST(TreeNode<Integer> root, int expectedHeight) {

	    int actualHeight = BinarySearchTree.findHeightOfBST(root);

	    assertEquals(expectedHeight, actualHeight);
	}

	private static Stream<Arguments> provideFindHeightBSTTestCases() {
	    return Stream.of(

	            // Case 1: Empty tree
	            Arguments.of(null, 0),

	            // Case 2: Single node
	            Arguments.of(BinarySearchTree.addAll(List.of(10)), 1),

	            // Case 3: Balanced tree
	            Arguments.of(BinarySearchTree.addAll(List.of(4,2,6,1,3,5,7)), 3),

	            // Case 4: Left skewed tree
	            Arguments.of(BinarySearchTree.addAll(List.of(5,4,3,2,1)), 5),

	            // Case 5: Right skewed tree
	            Arguments.of(BinarySearchTree.addAll(List.of(1,2,3,4,5)), 5),

	            // Case 6: Random BST
	            Arguments.of(BinarySearchTree.addAll(List.of(10,5,15,3,7,18)), 3)
	    );
	}

	@ParameterizedTest
	@MethodSource("provideValidBSTTestCases")
	@DisplayName("Test valid BinarSearchTree or not")
	void testValidBST(TreeNode<Integer> root, Boolean expected) {
		Boolean actual = BinarySearchTree.validBST(root);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> provideValidBSTTestCases() {
		return Stream.of(Arguments.of(null, true), Arguments.of(BinarySearchTree.addAll(List.of(1)), true),
				Arguments.of(BinarySearchTree.addAll(List.of(5, 6, 7, 8, 9)), true),
				Arguments.of(BinarySearchTree.addAll(List.of(10, 1, 6, 3, 9, 5)), true),
				Arguments.of(BinarySearchTree.addAll(List.of(19, 18, 20)), true));
	}

	@ParameterizedTest
	@MethodSource("provideTwoTreesAreEqualTestCases")
	@DisplayName("Test two BST are equal or not")
	void testTwoTreesAreEqual(TreeNode<Integer> rootOne, TreeNode<Integer> rootTwo, Boolean expected) {
		Boolean actual = BinarySearchTree.twoTreesAreEqual(rootOne, rootTwo);
		assertEquals(actual, expected);
	}

	private static Stream<Arguments> provideTwoTreesAreEqualTestCases() {
		return Stream.of(
				// Case 1: Both trees are null
				Arguments.of(null, null, true),
				// Case 2: One tree is null, the other is not
				Arguments.of(BinarySearchTree.addAll(List.of(10, 5, 15)), null, false),
				Arguments.of(null, BinarySearchTree.addAll(List.of(10, 5, 15)), false),
				// Case 3: Both trees have the same structure and same values
				Arguments.of(BinarySearchTree.addAll(List.of(10, 5, 15)), BinarySearchTree.addAll(List.of(10, 5, 15)), true),
				// Case 4: Both trees have the same structure but different values
				Arguments.of(BinarySearchTree.addAll(List.of(10, 5, 15)), BinarySearchTree.addAll(List.of(10, 4, 15)), false),
				// Case 5: Both trees have different structures
				Arguments.of(BinarySearchTree.addAll(List.of(10, 5, 15)), BinarySearchTree.addAll(List.of(10, 5)), false),
				// Case 6: Complex trees, identical structure and values
				Arguments.of(BinarySearchTree.addAll(List.of(10, 5, 1, 7, 15, 12, 20)),
						BinarySearchTree.addAll(List.of(10, 5, 1, 7, 15, 12, 20)), true),
				// Case 7: Complex trees, different values
				Arguments.of(BinarySearchTree.addAll(List.of(10, 5, 1, 7, 15, 12, 20)),
						BinarySearchTree.addAll(List.of(10, 5, 1, 6, 15, 12, 20)), false));
	}

	@ParameterizedTest
	@MethodSource("provideDeleteNodeIIITestcases")
	@DisplayName("Delete all nodes those are smaller than k")
	void testDeleteNodeIII(TreeNode<Integer> rootNode, Integer k, TreeNode<Integer> expected) {
		TreeNode<Integer> actual = BinarySearchTree.deleteNodeIII(rootNode, k);
		assertTrue(BinarySearchTree.twoTreesAreEqual(expected, actual));
	}

	private static Stream<Arguments> provideDeleteNodeIIITestcases() {
		return Stream.of(
				// Case 1: Simple tree, delete all nodes smaller than 10
				Arguments.of(BinarySearchTree.addAll(List.of(10, 5, 15, 3, 7, 20)), 10,
						BinarySearchTree.addAll(List.of(10, 15, 20))),
				// Case 2: Deleting nodes smaller than 5
				Arguments.of(BinarySearchTree.addAll(List.of(10, 5, 15, 3, 7, 20)), 5,
						BinarySearchTree.addAll(List.of(10, 5, 15, 7, 20))),
				// Case 3: Deleting nodes smaller than 20 (no node is deleted)
				Arguments.of(BinarySearchTree.addAll(List.of(10, 5, 15, 3, 7, 20)), 20, BinarySearchTree.addAll(List.of(20))),
				// Case 4: Deleting all nodes smaller than 0 (entire tree is deleted)
				Arguments.of(BinarySearchTree.addAll(List.of(10, 5, 15, 3, 7, 20)), 21, null), // Tree becomes null
				// Case 5: Empty tree (no deletion)
				Arguments.of(null, 10, null));
	}

	@ParameterizedTest
	@MethodSource("provideTopViewOfBSTTestCases")
	@DisplayName("Test Top View Of Binary Search Tree")
	void testTopViewOfBST(TreeNode<Integer> root, List<Integer> expected) {
		List<Integer> actual = BinarySearchTree.topViewOfBST(root);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> provideTopViewOfBSTTestCases() {
		return Stream.of(
				// Case 1: Null tree
				Arguments.of(null, List.of()),
				// Case 2: Single node tree
				Arguments.of(BinarySearchTree.addAll(List.of(10)), List.of(10)),
				// Case 3: Left-skewed tree
				Arguments.of(BinarySearchTree.addAll(List.of(10, 5, 1)), List.of(1, 5, 10)),
				// Case 4: Right-skewed tree
				Arguments.of(BinarySearchTree.addAll(List.of(10, 15, 20)), List.of(10, 15, 20)),
				// Case 5: Balanced tree
				Arguments.of(BinarySearchTree.addAll(List.of(10, 5, 15)), List.of(5, 10, 15)),
				// Case 6: Complex tree
				Arguments.of(BinarySearchTree.addAll(List.of(10, 5, 15, 3, 7, 12, 18)), List.of(3, 5, 10, 15, 18)),
				// Case 7: Larger tree with more complex structure
				Arguments.of(BinarySearchTree.addAll(List.of(20, 10, 30, 5, 15, 25, 35, 3, 8, 12, 18, 28, 40)),
						List.of(3, 5, 10, 20, 30, 35, 40)));
	}

	@ParameterizedTest
	@MethodSource("provideBottomViewOfBSTTestCases")
	@DisplayName("Test Bottom View Of Binary Search Tree")
	void testBottomViewOfBST(TreeNode<Integer> root, List<Integer> expected) {
		List<Integer> actual = BinarySearchTree.bottomViewOfBST(root);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> provideBottomViewOfBSTTestCases() {
		return Stream.of(
				// Case 1: Null tree (no nodes)
				Arguments.of(null, List.of()),

				// Case 2: Single node tree
				Arguments.of(BinarySearchTree.addAll(List.of(10)), List.of(10)),

				// Case 3: Left skewed tree (bottom view includes all nodes)
				Arguments.of(BinarySearchTree.addAll(List.of(10, 5, 1)), List.of(1, 5, 10)),

				// Case 4: Right skewed tree (bottom view includes all nodes)
				Arguments.of(BinarySearchTree.addAll(List.of(10, 15, 20)), List.of(10, 15, 20)),

				// Case 5: Balanced tree
				Arguments.of(BinarySearchTree.addAll(List.of(10, 5, 15)), List.of(5, 10, 15))
			);
	}
	
	@ParameterizedTest
	@MethodSource("provideDiameterBSTTestCases")
	@DisplayName("Test Diameter of Binary Search Tree")
	void testDiameterBST(TreeNode<Integer> root, Integer expectedDiameter) {
	    Integer actual = BinarySearchTree.diameterOfBST(root);
	    assertEquals(expectedDiameter, actual);
	}

	private static Stream<Arguments> provideDiameterBSTTestCases() {
	    return Stream.of(

	            // Case 1: Empty tree
	            Arguments.of(null, 0),

	            // Case 2: Single node
	            Arguments.of(BinarySearchTree.addAll(List.of(1)), 0),

	            // Case 3: Two nodes
	            Arguments.of(BinarySearchTree.addAll(List.of(2,1)), 1),

	            // Case 4: Balanced tree
	            //        4
	            //       / \
	            //      2   6
	            //     / \ / \
	            //    1  3 5  7
	            Arguments.of(BinarySearchTree.addAll(List.of(4,2,6,1,3,5,7)), 4),

	            // Case 5: Left skewed tree
	            // 5 → 4 → 3 → 2 → 1
	            Arguments.of(BinarySearchTree.addAll(List.of(5,4,3,2,1)), 4),

	            // Case 6: Right skewed tree
	            // 1 → 2 → 3 → 4 → 5
	            Arguments.of(BinarySearchTree.addAll(List.of(1,2,3,4,5)), 4),

	            // Case 7: Mixed tree
	            Arguments.of(BinarySearchTree.addAll(List.of(10,5,15,3,7,18)), 4)
	    );
	}
	
	@ParameterizedTest
	@MethodSource("provideBalanceBSTTestCases")
	@DisplayName("Test Balance Binary Search Tree")
	void testBalanceBST(TreeNode<Integer> inputRoot) {
	    TreeNode<Integer> actual = BinarySearchTree.balanceBST(inputRoot);
	    List<Integer> original = BinarySearchTree.inOrderTraversal(inputRoot, new ArrayList<>());
	    List<Integer> balanced = BinarySearchTree.inOrderTraversal(actual, new ArrayList<>());
	    // Verify BST property preserved
	    assertEquals(original, balanced);
	    // Verify tree is balanced
	    assertTrue(BinarySearchTree.balancedBST(actual));
	}

	private static Stream<Arguments> provideBalanceBSTTestCases() {
	    return Stream.of(

	            // Case 1: Empty tree
	            Arguments.of((TreeNode<Integer>) null),

	            // Case 2: Single node
	            Arguments.of(BinarySearchTree.addAll(List.of(1))),

	            // Case 3: Already balanced tree
	            Arguments.of(BinarySearchTree.addAll(List.of(2,1,3))),

	            // Case 4: Right skewed tree
	            Arguments.of(BinarySearchTree.addAll(List.of(1,2,3,4))),

	            // Case 5: Larger skewed tree
	            Arguments.of(BinarySearchTree.addAll(List.of(10,20,30,40,50)))
	    );
	}

	@ParameterizedTest
	@MethodSource("provideInvertBSTTestCases")
	@DisplayName("Test Invert Binary Search Tree")
	void testInvertBST(TreeNode<Integer> root, TreeNode<Integer> expected) {
		TreeNode<Integer> actual = BinarySearchTree.invertBST(root);
		assertTrue(BinarySearchTree.twoTreesAreEqual(expected, actual));
	}

	private static Stream<Arguments> provideInvertBSTTestCases() {
		TreeNode<Integer> twoLevel = new TreeNode<>(10);
		twoLevel.right = new TreeNode<>(5);
		
		TreeNode<Integer> rightSkewed = new TreeNode<>(10);
		rightSkewed.right = new TreeNode<>(5);
		rightSkewed.right.right = new TreeNode<>(3);
		rightSkewed.right.right.right = new TreeNode<>(1);
		
		TreeNode<Integer> leftSkewed = new TreeNode<>(10);
		leftSkewed.left = new TreeNode<>(15);
		leftSkewed.left.left = new TreeNode<>(20);

		return Stream.of(
				// Case 1: Null tree
				Arguments.of(null, null),

				// Case 2: Single node
				Arguments.of(BinarySearchTree.addAll(List.of(10)), BinarySearchTree.addAll(List.of(10))),

				// Case 3: Two-level tree
				Arguments.of(BinarySearchTree.addAll(List.of(10, 5)), twoLevel),

				// Case 4: Left-skewed tree
				Arguments.of(BinarySearchTree.addAll(List.of(10, 5, 3, 1)), rightSkewed),

				// Case 5: Right-skewed tree
				Arguments.of(BinarySearchTree.addAll(List.of(10, 15, 20)), leftSkewed)
			);
	}
	@ParameterizedTest
	@MethodSource("provideSymmetricBSTTestCases")
	@DisplayName("Test Symmetric Binary Search Tree")
	void testSymmetricBST(TreeNode<Integer> rootOne,TreeNode<Integer> rootTwo, Boolean expected) {
		Boolean actual= BinarySearchTree.symmetricBST(rootOne,rootTwo);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> provideSymmetricBSTTestCases() {
		return Stream.of(
				// Case 1: Both trees are null (symmetric by definition)
				Arguments.of(null, null, true),
				// Case 2: Second tree is  null (symmetric by definition)
				Arguments.of(BinarySearchTree.addAll(List.of(10, 5, 15)), null, false ),
				// Case 3: Non-symmetric trees (one tree is left-skewed, one is right-skewed)
				Arguments.of(BinarySearchTree.addAll(List.of(10, 5, 3)), BinarySearchTree.addAll(List.of(10, 5, 3)), false),
				// Case 4: One tree is null, the other is not
				Arguments.of(BinarySearchTree.addAll(List.of(10, 5, 5, 3, 7, 7, 3)), null, false)
			);
	}
	
	@ParameterizedTest
	@MethodSource("provideSameTreeTestCases")
	@DisplayName("Test Same Binary Tree")
	void testSameTree(TreeNode<Integer> rootOne, TreeNode<Integer> rootTwo, Boolean expected) {
		Boolean actual = BinarySearchTree.sameTree(rootOne, rootTwo);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> provideSameTreeTestCases() {
		return Stream.of(
				// Case 1: Both trees are null → identical
				Arguments.of(null, null, true),
				// Case 2: Identical BST structures and values
				Arguments.of(BinarySearchTree.addAll(List.of(10, 5, 15, 3, 7)), BinarySearchTree.addAll(List.of(10, 5, 15, 3, 7)), true),
				// Case 3: Same values but different structure
				Arguments.of(BinarySearchTree.addAll(List.of(10, 5, 3)), BinarySearchTree.addAll(List.of(10, 15, 20)), false),
				// Case 4: Different values but same structure
				Arguments.of(BinarySearchTree.addAll(List.of(10, 5, 15)), BinarySearchTree.addAll(List.of(10, 5, 20)), false),
				// Case 5: One tree null, other not
				Arguments.of(BinarySearchTree.addAll(List.of(10, 5, 15)), null, false),
				// Case 6: Larger identical trees
				Arguments.of(BinarySearchTree.addAll(List.of(50, 30, 70, 20, 40, 60, 80)),BinarySearchTree.addAll(List.of(50, 30, 70, 20, 40, 60, 80)), true)
			);
	}
	
	@ParameterizedTest
	@MethodSource("provideBalancedBSTTestCases")
	@DisplayName("Test Balanced Binary Search Tree")
	void testBalancedBST(TreeNode<Integer> root, Boolean expected) {
	    Boolean actual = BinarySearchTree.balancedBST(root);
	    assertEquals(expected, actual);
	}

	private static Stream<Arguments> provideBalancedBSTTestCases() {
	    return Stream.of(
	            // Case 1: Empty tree
	            Arguments.of(null, true),
	            // Case 2: Single node
	            Arguments.of(BinarySearchTree.addAll(List.of(10)), true),
	            // Case 3: Perfect balanced tree
	            Arguments.of(BinarySearchTree.addAll(List.of(4,2,6,1,3,5,7)), true),
	            // Case 4: Left skewed tree
	            Arguments.of(BinarySearchTree.addAll(List.of(5,4,3,2,1)), false),
	            // Case 5: Right skewed tree
	            Arguments.of(BinarySearchTree.addAll(List.of(1,2,3,4,5)), false),
	            // Case 6: Slightly unbalanced but valid
	            Arguments.of(BinarySearchTree.addAll(List.of(10,5,15,3,7)), true),
	            // Case 7: Deep imbalance
	            Arguments.of(BinarySearchTree.addAll(List.of(10,9,8,7,6,5)), false)
	    );
	}
	
	@ParameterizedTest
	@MethodSource("provideLcaTestCases")
	@DisplayName("Test Lowest Common Ancestor in Binary Tree")
	void testLowestCommonAncestor(TreeNode<Integer> root,
            Integer pVal,
            Integer qVal,
			Integer expected) {
		TreeNode<Integer> p = findNode(root, pVal);
		TreeNode<Integer> q = findNode(root, qVal);
		TreeNode<Integer> result = BinarySearchTree.lowestCommonAncestor(root, p, q);
		Integer actual = (result != null) ? result.data : null;
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> provideLcaTestCases() {

		TreeNode<Integer> root = createSampleTree();

		return Stream.of(

				// Case 1: Different subtrees
				Arguments.of(root, 5, 1, 3),

				// Case 2: One node is ancestor
				Arguments.of(root, 5, 4, 5),

				// Case 3: Same node
				Arguments.of(root, 6, 6, 6),

				// Case 4: Root is LCA
				Arguments.of(root, 6, 8, 3),

				// Case 5: Node not present
				Arguments.of(root, 5, 999, 5),

				// Case 6: Null root
				Arguments.of(null, null, null, null));
	}
	private static TreeNode<Integer> createSampleTree() {
	    /*
	            3
	           / \
	          5   1
	         / \ / \
	        6  2 0  8
	          / \
	         7   4
	     */
	    TreeNode<Integer> root = new TreeNode<>(3);

	    root.left = new TreeNode<>(5);
	    root.right = new TreeNode<>(1);

	    root.left.left = new TreeNode<>(6);
	    root.left.right = new TreeNode<>(2);
	    root.right.left = new TreeNode<>(0);
	    root.right.right = new TreeNode<>(8);

	    root.left.right.left = new TreeNode<>(7);
	    root.left.right.right = new TreeNode<>(4);

	    return root;
	}

	private static TreeNode<Integer> findNode(TreeNode<Integer> root, Integer value) {
		if (root == null)
			return null;
		if (root.data == value)
			return root;
		TreeNode<Integer> left = findNode(root.left, value);
		if (left != null)
			return left;
		return findNode(root.right, value);
	}

}
