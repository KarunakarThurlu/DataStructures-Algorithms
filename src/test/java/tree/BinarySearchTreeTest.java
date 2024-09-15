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
																													// tree
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
	@MethodSource("provideFindingHeightTestCases")
	@DisplayName("Test the height of different binary search trees")
	void testFindHeightOfBST(TreeNode<Integer> root, int expectedHeight) {
		assertEquals(expectedHeight, BinarySearchTree.findHeightOfBST(root));
	}

	private static Stream<Arguments> provideFindingHeightTestCases() {
		return Stream.of(Arguments.of(BinarySearchTree.addAll(List.of()), 0), // Zero node tree
				Arguments.of(BinarySearchTree.addAll(List.of(1)), 1), // Single node tree
				Arguments.of(BinarySearchTree.addAll(List.of(1, 2)), 2), // Two-node tree with one child
				Arguments.of(BinarySearchTree.addAll(List.of(3, 2, 1)), 3), // Left skewed tree with three nodes
				Arguments.of(BinarySearchTree.addAll(List.of(2, 1, 3)), 2) // Balanced tree with three nodes
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
	@MethodSource("provideDiameterOfBSTTestCases")
	@DisplayName("Test Find Diameter of Binary Search Tree")
	void testDiameterOfBST(TreeNode<Integer> root, Integer expected) {
		Integer actual= BinarySearchTree.diameteOfBST(root);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> provideDiameterOfBSTTestCases() {
		 return Stream.of(
		            // Case 1: Null tree
		            Arguments.of(null, 0),  // Empty tree, diameter should be 0
		            // Case 2: Single node
		            Arguments.of(BinarySearchTree.addAll(List.of(10)), 0),  // Single node, no edges, diameter should be 0
		            // Case 3: Linear tree (right skewed)
		            Arguments.of(BinarySearchTree.addAll(List.of(10, 15, 20)), 2),  // Linear tree: 10 -> 15 -> 20, diameter is 2
		            // Case 4: Balanced tree
		            Arguments.of(BinarySearchTree.addAll(List.of(10, 5, 15, 3, 7, 12, 20)), 4),  // Balanced tree, diameter is 4
		            // Case 5: Complex tree
		            Arguments.of(BinarySearchTree.addAll(List.of(10, 5, 15, 3, 7, 12, 20, 17)), 5),  // Complex tree, diameter is 5
		            // Case 6: Left skewed tree
		            Arguments.of(BinarySearchTree.addAll(List.of(10, 5, 3, 1)), 3)  // Left skewed, diameter is 3
		        );
	}
	
	@ParameterizedTest
	@MethodSource("provideBalanceBSTTestCases")
	@DisplayName("Test Balance a UnBalanced Binary Search Tree")
	void testBalanceBST(TreeNode<Integer> root, Boolean expected) {
		TreeNode<Integer> balanceBST = BinarySearchTree.balanceBST(root);
		Boolean actual = BinarySearchTree.balancedBST(balanceBST);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> provideBalanceBSTTestCases() {
		return Stream.of(Arguments.of(BinarySearchTree.addAll(List.of(10, 15, 25, 35, 45, 55, 65)), true));
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

				// Case 2: Non-symmetric trees (one tree is left-skewed, one is right-skewed)
				Arguments.of(BinarySearchTree.addAll(List.of(10, 5, 3)), BinarySearchTree.addAll(List.of(10, 5, 3)), false),
				// Case 3: One tree is null, the other is not
				Arguments.of(BinarySearchTree.addAll(List.of(10, 5, 5, 3, 7, 7, 3)), null, false));
	}

}
