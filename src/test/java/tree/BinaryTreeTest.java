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

class BinaryTreeTest {

	@ParameterizedTest
    @MethodSource("adingNodesTestCases")
    @DisplayName("Test adding nodes to the binary search tree")
    void testAddNodes(TreeNode<Integer> root, Integer dataToAdd, Integer expectedRoot, Integer expectedLeft, Integer expectedRight) {
        
		root = BinaryTree.add(root, dataToAdd);
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
        return Stream.of(
            Arguments.of(null, 10, 10, null, null),                            // Single node test case
            Arguments.of(BinaryTree.addAll(List.of(10)), 15, 10, null, 15),    // Increasing order test case
            Arguments.of(BinaryTree.addAll(List.of(20)), 15, 20, 15, null),    // Decreasing order test case
            Arguments.of(BinaryTree.addAll(List.of(15, 10)), 20, 15, 10, 20),  // Balanced tree test case
            Arguments.of(BinaryTree.addAll(List.of(10, 15)), 15, 10, null, 15) // Duplicate node test case (left unchanged)
        );
    }
	
    
    @ParameterizedTest
    @MethodSource("providePreOrderTestCases")
    @DisplayName("Test the PreOrder Traversal of Binary Search Tree")
    void testPreOrderTraversal(TreeNode<Integer> rootNode,List<Integer> expectedOrder) {
    	List<Integer> actualOrder = BinaryTree.preOrderTraversal(rootNode, new ArrayList<>());
    	assertEquals(actualOrder, expectedOrder,"Pre-order traversal should match the expected order.");
    }
    
	private static Stream<Arguments> providePreOrderTestCases() {
		return Stream.of(
				Arguments.of(BinaryTree.addAll(List.of(3)),List.of(3)),										// Single node test case
				Arguments.of(null, List.of()),  															// Null root (negative test case)
				Arguments.of(BinaryTree.addAll(List.of(10, 5, 1, 7, 15, 12)), List.of(10, 5, 1, 7, 15, 12)),// Complex tree test case
				Arguments.of(BinaryTree.addAll(List.of(5, 4, 1)), List.of(5, 4, 1)),     					// Left skewed tree test case
				Arguments.of(BinaryTree.addAll(List.of(8, 11, 13)), List.of(8, 11, 13)),  					// Right skewed tree test case
				Arguments.of(BinaryTree.addAll(List.of(10, 5, 11)), List.of(10, 5, 11)),     				// Left skewed tree test case
				Arguments.of(BinaryTree.addAll(List.of(5, 4, 1)), List.of(5, 4, 1))    						// Left skewed tree test case
			);
	}
	
	@ParameterizedTest
	@MethodSource("provideInOrderTestCases")
	@DisplayName("Test the InOrder Traversal of Binary Search Tree")
	void testInOrderTraversal(TreeNode<Integer> rootNode,List<Integer> expectedOrder) {
		List<Integer> actualOrder = BinaryTree.inOrderTraversal(rootNode, new ArrayList<>());
		assertEquals(actualOrder, expectedOrder,"In-order traversal should match the expected order.");
	}
	
    private static Stream<Arguments> provideInOrderTestCases() {
        return Stream.of(
            Arguments.of(null, List.of()),																		// Null root
            Arguments.of(BinaryTree.addAll(List.of(10)), List.of(10)),  										// Single node
            Arguments.of(BinaryTree.addAll(List.of(10, 5, 1)), List.of(1, 5, 10)),  							// Left skewed tree
            Arguments.of(BinaryTree.addAll(List.of(10, 15, 20)), List.of(10, 15, 20)),  						// Right skewed tree
            Arguments.of(BinaryTree.addAll(List.of(10, 5, 15)), List.of(5, 10, 15)),  							// Balanced tree
            Arguments.of(BinaryTree.addAll(List.of(10, 5, 1, 7, 15, 12, 20)), List.of(1, 5, 7, 10, 12, 15, 20)) // Complex tree
        );
    }
    
	@ParameterizedTest
	@MethodSource("providePostOrderTestCases")
	@DisplayName("Test the postOrder Traversal of Binary Search Tree")
	void testPostOrderTraversal(TreeNode<Integer> rootNode,List<Integer> expectedOrder) {
		List<Integer> actualOrder = BinaryTree.postOrderTraversal(rootNode, new ArrayList<>());
		assertEquals(actualOrder, expectedOrder,"Post-order traversal should match the expected order.");
	}
    private static Stream<Arguments> providePostOrderTestCases() {
        return Stream.of(
            Arguments.of(null, List.of()),  																	// Null root
            Arguments.of(BinaryTree.addAll(List.of(10)), List.of(10)),  										// Single node
            Arguments.of(BinaryTree.addAll(List.of(10, 5, 1)), List.of(1, 5, 10)),  							// Left skewed tree
            Arguments.of(BinaryTree.addAll(List.of(10, 15, 20)), List.of(20, 15, 10)),  						// Right skewed tree
            Arguments.of(BinaryTree.addAll(List.of(10, 5, 15)), List.of(5, 15, 10)),  							// Balanced tree
            Arguments.of(BinaryTree.addAll(List.of(10, 5, 1, 7, 15, 12, 20)), List.of(1, 7, 5, 12, 20, 15, 10)) // Complex tree
        );
    }
    
    
    @ParameterizedTest
    @MethodSource("provideLevelOrderTestCases")
    @DisplayName("Test the LevelOrder Traversal of Binary Search Tree")
    void testLevelOrderTraversal(TreeNode<Integer> rootNode,List<Integer> expectedOrder) {
    	List<Integer> actualOrder = BinaryTree.levelOrderTraversal(rootNode);
    	assertEquals(actualOrder, expectedOrder,"Level-order traversal should match the expected order.");
    }
    private static Stream<Arguments> provideLevelOrderTestCases(){
    	return Stream.of(
    			Arguments.of(null, List.of()),  																	// Null root
                Arguments.of(BinaryTree.addAll(List.of(10)), List.of(10)),  										// Single node
                Arguments.of(BinaryTree.addAll(List.of(10, 5, 1)), List.of(10, 5, 1)),  							// Left skewed tree
                Arguments.of(BinaryTree.addAll(List.of(10, 15, 20)), List.of(10, 15, 20)),  						// Right skewed tree
                Arguments.of(BinaryTree.addAll(List.of(10, 5, 15)), List.of(10, 5, 15)),  							// Balanced tree
                Arguments.of(BinaryTree.addAll(List.of(10, 5, 1, 7, 15, 12, 20)), List.of(10, 5, 15, 1, 7, 12, 20)) // Complex tree
    		);
    }
    
    @ParameterizedTest
    @MethodSource("provideDeleteNodeIITestcases")
    @DisplayName("Delete all nodes those are grater than k")
    void testDeleteNodeII(TreeNode<Integer> rootNode,Integer k,TreeNode<Integer> expected) {
    	TreeNode<Integer> actual = BinaryTree.deleteNodeII(rootNode, k);
    	assertTrue(BinaryTree.twoTreesAreEqual(expected, actual));
    }
    
	private static Stream<Arguments> provideDeleteNodeIITestcases() {
		return Stream.of(
				// Case 1: Simple tree, delete all nodes greater than 10
				Arguments.of(BinaryTree.addAll(List.of(10, 5, 15, 3, 7, 20)), 10, BinaryTree.addAll(List.of(10, 5, 3, 7))),
				// Case 2: Deleting nodes greater than 5
				Arguments.of(BinaryTree.addAll(List.of(10, 5, 15, 3, 7, 20)), 5, BinaryTree.addAll(List.of(5, 3))),
				// Case 3: Deleting nodes greater than 20 (no node is deleted)
				Arguments.of(BinaryTree.addAll(List.of(10, 5, 15, 3, 7, 20)), 20, BinaryTree.addAll(List.of(10, 5, 15, 3, 7, 20))),
				// Case 4: Deleting all nodes greater than 0 (entire tree is deleted)
				Arguments.of(BinaryTree.addAll(List.of(10, 5, 15, 3, 7, 20)), 0, null), // Tree becomes null
				// Case 5: Empty tree (no deletion)
				Arguments.of(null, 10, null)
		  );
	}
    
	@ParameterizedTest
	@MethodSource("provideDeleteNodeTestCases")
	@DisplayName("Test the Deleting a Node of a binary search tree")
	void testDeleteNode(TreeNode<Integer> rootNode, Integer dataToDelete,TreeNode<Integer> expected) {
		 // Perform the deletion operation
        TreeNode<Integer> actual = BinaryTree.deleteNode(rootNode, dataToDelete);

        // Compare the actual tree structure with the expected structure
        assertTrue(BinaryTree.twoTreesAreEqual(actual, expected), "The tree after deletion should match the expected tree.");
	}
	
	private static Stream<Arguments> provideDeleteNodeTestCases() {
		return Stream.of(
				// Case 1: Deleting a leaf node
				Arguments.of(BinaryTree.addAll(List.of(10, 5, 15, 3, 7, 20)), 7, BinaryTree.addAll(List.of(10, 5, 15, 3, 20))),
				// Case 2: Deleting a node with one child
				Arguments.of(BinaryTree.addAll(List.of(10, 5, 15, 3, 7, 20)), 15, BinaryTree.addAll(List.of(10, 5, 3, 7, 20))),
				// Case 3: Deleting a node with two children
				Arguments.of(BinaryTree.addAll(List.of(10, 5, 15, 3, 7, 12, 20)), 15, BinaryTree.addAll(List.of(10, 5, 12, 3, 7, 20))),
				// Case 4: Deleting the root node
				Arguments.of(BinaryTree.addAll(List.of(10, 5, 15, 3, 7, 20)), 10, BinaryTree.addAll(List.of(7, 5, 15, 3, 20))),
				// Case 5: Deleting a node that doesn't exist
				Arguments.of(BinaryTree.addAll(List.of(10, 5, 15, 3, 7, 20)), 99, BinaryTree.addAll(List.of(10, 5, 15, 3, 7, 20))),
				// Case 6: Deleting from an empty tree
				Arguments.of(null, 10, null)
		 );
	}
	
	@ParameterizedTest
	@MethodSource("provideFindingHeightTestCases")
	@DisplayName("Test the height of different binary search trees")
	void testFindHeightOfBST(TreeNode<Integer> root, int expectedHeight) {
		assertEquals(expectedHeight, BinaryTree.findHeightOfBST(root));
	}
	
	private static Stream<Arguments> provideFindingHeightTestCases() {
		return Stream.of(
				Arguments.of(BinaryTree.addAll(List.of()), 0),       // Zero node tree
				Arguments.of(BinaryTree.addAll(List.of(1)), 1),      // Single node tree
				Arguments.of(BinaryTree.addAll(List.of(1, 2)), 2),   // Two-node tree with one child
				Arguments.of(BinaryTree.addAll(List.of(3, 2, 1)), 3),// Left skewed tree with three nodes
				Arguments.of(BinaryTree.addAll(List.of(2, 1, 3)), 2) // Balanced tree with three nodes
		);
	}
	
	@ParameterizedTest
	@MethodSource("provideTwoTreesAreEqualTestCases")
	@DisplayName("Test two BST are equal or not")
	void testTwoTreesAreEqual(TreeNode<Integer> rootOne,TreeNode<Integer> rootTwo,Boolean expected) {
		Boolean actual = BinaryTree.twoTreesAreEqual(rootOne, rootTwo);
		assertEquals(actual, expected);
	}

	private static Stream<Arguments> provideTwoTreesAreEqualTestCases() {
		return Stream.of(
				Arguments.of(null,null,true),
				Arguments.of(BinaryTree.addAll(List.of(10, 5, 15, 3, 7, 20)), BinaryTree.addAll(List.of(10, 5, 3, 7)), false),
				Arguments.of(BinaryTree.addAll(List.of(10, 5, 3, 7)), BinaryTree.addAll(List.of(10, 5, 3, 7)), true)
		);
	}
}
