package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Queue;
import java.util.TreeMap;

public class BinarySearchTree {

	/*
	 * ========================================================= 
	 * Binary Tree
	 * ========================================================= 
	 * 1. BinaryTree is a hierarchical data structure 
	 * 2. In Binary Tree each Node have at most 2 children Nodes.(i.e either 0 OR 1 OR 2) 
	 * 3. These children are usually referred to as the left child and the right child.
	 * 
	 * General Structure: It doesn't impose any specific rules on how the values of the nodes should be arranged. 
	 * -------------------
	 * 
	 * Usage: expression trees, decision trees, and binary heaps. 
	 * ------
	 * 
	 * ========================================================= 
	 * Binary Search Tree
	 * ========================================================= 
	 * A binary tree where the left child node is less than parent node and right child node is greater than parent node.
	 * 
	 * 
	 * Usage: BSTs are used for efficient searching, insertion, and deletion operations. Because of the ordering property, search operations in a balanced BST can be performed in O(log n) time. 
	 * -----
	 * 
	 * 
	 * -----------------------------------------
	 *  Coding challenges on Binary Search Tree 
	 * -----------------------------------------
	 * 
	 * 1  Adding Element into BinarySearchTree 
	 * 2  Adding List of Elements at once into BinarySearchTree 
	 * 3  PreOrder Traversal 
	 * 4  InOrder Traversal 
	 * 5  PostOrder Traversal 
	 * 6  LevelOrder Traversal 
	 * 7  Delete all nodes those are grater than k 
	 * 8  Deleting specific node in BinarySearchTree 
	 * 9  Left View Of BinarySearchTree 
	 * 10 Right View Of BinarySearchTree 
	 * 11 Find Height of Binary Search Tree 
	 * 12 Valid BinarySearchTree 
	 * 13 Balanced BinarySearchTree 
	 * 14 Two BSTtrees are identical or not 
	 * 15 Delete all nodes those are smaller than k 
	 * 16 Top View of Binary Search Tree 
	 * 17 Bottom View of Binary Search Tree 
	 * 18 Find Diameter of Binary Search Tree
	 * 19 Balance Binary Search Tree 
	 * 20 Invert Binary Search Tree (Mirror Tree)
	 * 21 Symmetric Tree
	 * 22 Same Tree
	 * 23 Lowest Common Ancestor in Binary Search Tree
	 * 24 Kth Smallest Element in Binary Search Tree
	 * 25 Kth Largest Element in Binary Search Tree
	 * 26 Convert Sorted Array to Binary Search Tree
	 * 27 Diameter of Binary Search Tree
	 * 28 Serialize and Deserialize Binary Search Tree
	 * 29 Binary Search Tree Iterator
	 * 30 Merge Two Binary Search Trees
	 */

	/**
	 * 1 Adding Element into BinarySearchTree
	 * 
	 * <pre>
	 * 
	 * Description: To add an element to a binary search tree, we start at the root and compare the value to be added with the current node's value. If the value is smaller, we move to the left child; if it's larger, we move to the right child. We continue this process until we find an appropriate null position where we can insert the new node.
	 * 
	 * Example 1: Adding 5 to the following BST: 
	 *          10
	 *         /  \
	 *        5    15
	 * 
	 * After adding 5, the BST remains unchanged because 5 is already present in the tree.
	 * 
	 * Example 2: Adding 3 to the same BST:
	 *         10
	 *        /  \
	 *       5    15
	 *      /
	 *     3
	 * 
	 * After adding 3, it becomes the left child of 5, as 3 is smaller than 5.
	 * 
	 * Example 3: Adding 12 to the same BST:
	 *       10
	 *      /  \
	 *     5    15
	 *    /     /
	 *   3     12
	 *   
	 * After adding 12, it becomes the left child of 15, as 12 is smaller than 15 but larger than 10.
	 * 
	 * Time Complexity: O(h), where h is the height of the tree. In a balanced BST, this is O(log n), but in the worst case (when the tree is skewed), it can be O(n).
	 * Space Complexity: O(1) for iterative implementation, O(h) for recursive implementation due to call stack.
	 * 
	 * </pre>
	 * 
	 * @param root root node of the BST
	 * @param data value to be added to the BST
	 * @return root node of the BST after adding the new value
	 */
	public static TreeNode<Integer> add(TreeNode<Integer> root, Integer data) {
		// Base case: If the root is null, create a new node with the given data and return it as the new root of the subtree.
		if (root == null)
			return new TreeNode<>(data);
		
		// Recursive case: Compare the data to be added with the current node's data. If the data is smaller, recursively call add on the left subtree; if it's larger, recursively call add on the right subtree. If the data is equal to the current node's data, we do not add it to maintain the property of a binary search tree (no duplicate values).
		if (root.data < data)
			root.right = add(root.right, data);
		// If the data is smaller than the current node's data, we add it to the left subtree.
		else if (root.data > data)
			root.left = add(root.left, data);
		return root;
	}

	/**
	 * 2. Adding List of Elements at once into BinarySearchTree
	 * 
	 * <pre>
	 * Description: To add a list of elements to a binary search tree, we can iterate through the list and use the add method for each element. This will ensure that each element is added in the correct position according to the properties of the binary search tree.
	 * 
	 * Example: Adding the list [7, 3, 9, 8] to the following BST:
	 *      7
	 *    /  \
	 *   3    9
	 *       /
	 *      8
	 * 
	 * Time Complexity: O(n log n) in the average case, where n is the number of elements in the list. This is because each add operation takes O(log n) time on average, and we perform this operation for each of the n elements. In the worst case (when the tree becomes skewed), the time complexity can degrade to O(n^2).
	 * Space Complexity: O(1) for iterative implementation, O(h) for recursive implementation due to call stack, where h is the height of the tree.
	 * 
	 * </pre>
	 * @param list list of integers to be added to the BST
	 * @return root node of the BST after adding all the elements from the list
	 */
	public static TreeNode<Integer> addAll(List<Integer> list) {
		TreeNode<Integer> root = null;
		for (Integer data : list)
			root = add(root, data);
		return root;
	}

	/**
	 * 3. PreOrder Traversal (Root-->Left-->right)
	 * 
	 * <pre>
	 * 
	 * Description: Pre-order traversal is a depth-first traversal method where we visit the root node first, then recursively traverse the left subtree, and finally recursively traverse the right subtree. This traversal method is often used to create a copy of the tree or to get a prefix expression of an expression tree.
	 * 
	 * Example: For the following BST:
	 * 
	 *      10
	 *     /  \
	 *    5    15
	 *   / \    \
	 *  3   6    20
	 *  
	 *  
	 *  The pre-order traversal of this tree would be: [10, 5, 3, 6, 15, 20]
	 *  
	 *  Time Complexity: O(n), where n is the number of nodes in the tree, because we visit each node exactly once.
	 *  Space Complexity: O(h) for recursive implementation due to call stack, where h is the height of the tree. In the worst case (skewed tree), this can be O(n).
	 *  
	 * @param rootNode root node of the BST
	 * @param list list to store the pre-order traversal result
	 * @return PreOrder Elements List 
	 */
	public static List<Integer> preOrderTraversal(TreeNode<Integer> rootNode, List<Integer> list) {
		if (rootNode != null) {
			list.add(rootNode.data);
			preOrderTraversal(rootNode.left, list);
			preOrderTraversal(rootNode.right, list);
		}
		return list;
	}

	
	
	/**
	 * 4. InOrder Tr
	 * @param root
	 * @param list
	 * @return
	 */
	public static List<Integer> inOrderTraversal(TreeNode<Integer> root, List<Integer> list) {
		if (root != null) {
			inOrderTraversal(root.left, list);
			list.add(root.data);
			inOrderTraversal(root.right, list);
		}
		return list;
	}

	/**
	 * 5. PostOrder Traversal (Left-->Right-->Root)
	 * 
	 * @param root
	 * @param list
	 * @return PostOrder Elements List
	 */
	public static List<Integer> postOrderTraversal(TreeNode<Integer> root, List<Integer> list) {
		if (root != null) {
			postOrderTraversal(root.left, list);
			postOrderTraversal(root.right, list);
			list.add(root.data);
		}
		return list;
	}

	/**
	 * 6. Level Order Traversal of BinarySearch Tree
	 * 
	 * @param rootNode
	 * @return List of levelOrderTraversal elements
	 */
	public static List<Integer> levelOrderTraversal(TreeNode<Integer> rootNode) {
		List<Integer> list = new ArrayList<>();
		if(rootNode==null)
			return list;
		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		queue.offer(rootNode);
		while(!queue.isEmpty()) {
			TreeNode<Integer> current = queue.poll();
			list.add(current.data);
			if(current.left!=null) queue.offer(current.left);
			if(current.right!=null) queue.offer(current.right);
		}
		return list;
	}

	/**
	 * 7. Delete all nodes those are grater than k
	 * 
	 * @param root
	 * @param k
	 * @return
	 */
	public static TreeNode<Integer> deleteNodeII(TreeNode<Integer> root, Integer k) {
		if (root == null)
			return root;
		if (root.data > k)
			root = deleteNodeII(root.left, k);
		else
			root.right = deleteNodeII(root.right, k);
		return root;
	}

	/**
	 * 8. Deleting specific node in BinarySearchTree
	 * 
	 * @param root
	 * @param data
	 * @return
	 */
	public static TreeNode<Integer> deleteNode(TreeNode<Integer> root, Integer target) {
		// If the root is null, the tree is empty or we've reached a leaf node, so
		// return null.
		if (root == null) {
			return null;
		}

		// If the target is smaller than the root's data, it lies in the left subtree
		// else right subtree
		if (target < root.data) {
			root.left = deleteNode(root.left, target);
		} else if (target > root.data) {
			root.right = deleteNode(root.right, target);
		} else { // If the target matches the root's data, this is the node to be deleted.

			// Case 1: Node with only one child or no child
			if (root.left == null) {
				return root.right; // Replace node with its right subtree (or null)
			} else if (root.right == null) {
				return root.left; // Replace node with its left subtree (or null)
			}

			// Case 2: Node with two children
			// Find the smallest node in the right subtree (in-order successor)
			TreeNode<Integer> current = root.right;
			while (current.left != null) {
				current = current.left;
			}
			// Replace root's data with the in-order successor's data
			root.data = current.data;

			// Delete the in-order successor from the right subtree
			root.right = deleteNode(root.right, root.data);
		}

		return root;
	}
	
	/**
	 * 9 Left View Of BinarySearchTree
	 * 
	 * @param rootNode
	 * @return List<Integer> that contains left view elements
	 */
	public static List<Integer> bstLeftSideView(TreeNode<Integer> rootNode) {
		List<Integer> list = new ArrayList<>();
		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		if (rootNode == null)
			return list;
		queue.add(rootNode);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode<Integer> poll = queue.poll();
				if (i == 0)
					list.add(poll.data);
				if (poll.left != null)
					queue.add(poll.left);
				if (poll.right != null)
					queue.add(poll.right);
			}
		}
		return list;
	}

	/**
	 * 10 Right View Of BinarySearchTree
	 * 
	 * @param rootNode
	 * @return List<Integer> that contains right view elements
	 */
	public static List<Integer> bstRightSideView(TreeNode<Integer> rootNode) {
		List<Integer> list = new ArrayList<>();
		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		if (rootNode == null)
			return list;
		queue.add(rootNode);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode<Integer> poll = queue.poll();
				if (i == size - 1)
					list.add(poll.data);
				if (poll.left != null)
					queue.add(poll.left);
				if (poll.right != null)
					queue.add(poll.right);
			}
		}
		return list;
	}

	/**
	 * 11 Finding Height of BST
	 * 
	 * @param rootNode
	 * @return Integer
	 */
	public static Integer findHeightOfBST(TreeNode<Integer> rootNode) {
		if (rootNode == null)
			return 0;
		Integer leftNodeHeight = findHeightOfBST(rootNode.left);
		Integer rightNodeHeight = findHeightOfBST(rootNode.right);
		return Math.max(leftNodeHeight, rightNodeHeight) + 1;
	}

	/**
	 * 12 Valid BinarySearchTree
	 * 
	 * @param root
	 * @return true if valid BinarySearchTree otherwise false
	 */
	public static Boolean validBST(TreeNode<Integer> root) {
		return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static Boolean isValidBST(TreeNode<Integer> root, int minValue, int maxValue) {
		if (root == null)
			return true;
		if (root.data <= minValue || root.data >= maxValue)
			return false;
		return isValidBST(root.left, minValue, root.data) && isValidBST(root.right, root.data, maxValue);
	}

	/**
	 * 13 Balanced BinarySearchTree
	 * 
	 * @param root
	 * @return true for balanced BinarySearchTree otherwise false
	 */
	public static Boolean balancedBST(TreeNode<Integer> root) {
		if (root == null)
			return true;
		int leftChildHeight = findHeightOfBST(root.left);
		int rightChildHeight = findHeightOfBST(root.right);
		return (Math.abs(leftChildHeight - rightChildHeight) <= 1 && balancedBST(root.left) && balancedBST(root.right));

	}

	/**
	 * 14 Two BSTtrees are identical or not
	 * 
	 * @param rootOne
	 * @param rootTwo
	 * @return true if both trees are equal otherwise false
	 */
	public static Boolean twoTreesAreEqual(TreeNode<Integer> rootOne, TreeNode<Integer> rootTwo) {
		if (rootOne == null && rootTwo == null)
			return true;
		if (rootOne == null || rootTwo == null)
			return false;
		return rootOne.data.equals(rootTwo.data) && twoTreesAreEqual(rootOne.left, rootTwo.left)
				&& twoTreesAreEqual(rootOne.right, rootTwo.right);
	}

	/**
	 * 15. Delete all nodes those are smaller than k
	 * 
	 * @param root
	 * @param k
	 * @return
	 */
	public static TreeNode<Integer> deleteNodeIII(TreeNode<Integer> root, Integer k) {
		if (root == null)
			return root;
		if (root.data < k)
			root = deleteNodeIII(root.right, k);
		else
			root.left = deleteNodeIII(root.left, k);
		return root;
	}
	
	/**
	 * 16 Top View of Binary Search Tree
	 * @param root
	 * @return
	 */
	public static List<Integer> topViewOfBST(TreeNode<Integer> root){
		List<Integer> list = new LinkedList<>();
		if(root == null) {
			return list;
		}
		Queue<Integer> distanceQueue = new LinkedList<>();
		Queue<TreeNode<Integer>> nodeQueue = new LinkedList<>();
		Map<Integer, Integer> map = new TreeMap<>();
		distanceQueue.add(0);
		nodeQueue.add(root);
		while(!nodeQueue.isEmpty()) {
			TreeNode<Integer> node = nodeQueue.poll();
			Integer distance = distanceQueue.poll();
			map.computeIfAbsent(distance, key -> node.data);
			if(node.left!=null) {
				nodeQueue.add(node.left);
				distanceQueue.add(distance-1);
			}
			if(node.right!=null) {
				nodeQueue.add(node.right);
				distanceQueue.add(distance+1);
			}
		}
		return map.entrySet().stream().map(Entry::getValue).toList();
	}
	
	/**
	 * 17 Bottom View of Binary Search Tree
	 * @param root
	 * @return
	 */
	public static List<Integer> bottomViewOfBST(TreeNode<Integer> root) {
		if (root == null)
			return List.of();

		Queue<TreeNode<Integer>> nodeQueue = new LinkedList<>();
		Queue<Integer> distanceQueue = new LinkedList<>();
		Map<Integer, Integer> map = new TreeMap<>();
		nodeQueue.add(root);
		distanceQueue.add(0);
		while (!nodeQueue.isEmpty()) {
			TreeNode<Integer> node = nodeQueue.poll();
			Integer distance = distanceQueue.poll();
			map.put(distance, node.data);
			if (node.left != null) {
				nodeQueue.add(node.left);
				distanceQueue.add(distance - 1);
			}
			if (node.right != null) {
				nodeQueue.add(node.right);
				distanceQueue.add(distance + 1);
			}
		}
		return map.entrySet().stream().map(Entry::getValue).toList();
	}
	
	/**
	 * 18 Find Diameter of Binary Search Tree
	 * @param root
	 * @return
	 */
	public static Integer diameteOfBST(TreeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		int[] diameter = new int[1];
		findDiameter(root,diameter);
		return diameter[0];
	}

	private static Integer findDiameter(TreeNode<Integer> root, int[] diameter) {
		if(root == null) {
			return 0;
		}
		Integer leftSubTreeHeight  = findDiameter(root.left,diameter);
		Integer rightSubTreeHeight = findDiameter(root.right,diameter);
		diameter[0] = Math.max( diameter[0],leftSubTreeHeight+rightSubTreeHeight);
		return Math.max(leftSubTreeHeight, rightSubTreeHeight)+1;
	}

	/**
	 * 19 Balance a UnBalanced Binary Search Tree
	 * 
	 * @param root
	 * @return Balance Binary Search Tree root
	 */
	public static TreeNode<Integer> balanceBST(TreeNode<Integer> root) {
		List<Integer> list = inOrderTraversal(root, new ArrayList<>());
		return buildBalacedTree(list, 0, list.size() - 1);
	}

	private static TreeNode<Integer> buildBalacedTree(List<Integer> list, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = (start + end) / 2;
		TreeNode<Integer> node = new TreeNode<>(list.get(mid));
		node.left = buildBalacedTree(list, start, mid - 1);
		node.right = buildBalacedTree(list, mid + 1, end);
		return node;
	}
	
	/**
	 * 20. Invert Binary Search Tree (Mirror Tree)
	 *
	 * <pre>
	 * Description: Given the root of a binary tree, invert the tree, and return its root.
	 *
	 * Inverting a binary tree means swapping the left and right children of every node in the tree.
	 *
	 * Example 1:
	 * Input:
	 *          4
	 *         / \
	 *        2   7
	 *       / \ / \
	 *      1  3 6  9
	 *
	 * Output:
	 *          4
	 *         / \
	 *        7   2
	 *       / \ / \
	 *      9  6 3  1
	 *
	 * Example 2:
	 * Input:
	 *          2
	 *         / \
	 *        1   3
	 *
	 * Output:
	 *          2
	 *         / \
	 *        3   1
	 *
	 * Example 3:
	 * Input: root = null
	 * Output: null
	 *
	 * Approach:
	 * - Use Recursion (Post-order traversal).
	 * - Base Case:
	 *      If root is null → return null.
	 * - Recursively invert left subtree.
	 * - Recursively invert right subtree.
	 * - Swap left and right children.
	 * - Return root.
	 *
	 * Time Complexity: O(n)
	 *      Every node is visited exactly once.
	 *
	 * Space Complexity: O(h)
	 *      h = height of the tree (recursion stack).
	 *      Worst case: O(n) for skewed tree.
	 *      Best case: O(log n) for balanced tree.
	 *
	 * </pre>
	 *
	 * @param root root of the binary tree
	 * @return root of the inverted (mirrored) binary tree
	 */
	public static TreeNode<Integer> invertBST(TreeNode<Integer> root) {
		if (root == null) {
			return null;
		}

		// Recursively invert left and right subtrees
		TreeNode<Integer> invertedLeftSubtree = invertBST(root.left);
		TreeNode<Integer> invertedRightSubtree = invertBST(root.right);

		// Swap children
		root.left = invertedRightSubtree;
		root.right = invertedLeftSubtree;

		return root;
	}
	
	/**
	 * 21. Symmetric Binary Tree
	 *
	 * <pre>
	 * Description: Given the roots of two binary trees (typically left and right subtrees), determine whether they are mirror images of each other.
	 *
	 * A binary tree is symmetric if:
	 * - The left subtree is a mirror reflection of the right subtree.
	 * - Corresponding nodes have equal values.
	 *
	 * Mirror condition:
	 *      rootOne.data == rootTwo.data
	 *      rootOne.left  ↔ rootTwo.right
	 *      rootOne.right ↔ rootTwo.left
	 *
	 * Example 1:
	 * Input:
	 *          1
	 *         / \
	 *        2   2
	 *       / \ / \
	 *      3  4 4  3
	 *
	 * Output: true
	 *
	 * Example 2:
	 * Input:
	 *          1
	 *         / \
	 *        2   2
	 *         \    \
	 *          3    3
	 *
	 * Output: false
	 *
	 * Example 3:
	 * Input: rootOne = null, rootTwo = null
	 * Output: true
	 *
	 * Approach:
	 * - Use Recursion (Mirror DFS).
	 * - Base Case:
	 *      If both nodes are null → symmetric → return true.
	 * - If only one node is null → not symmetric → return false.
	 * - If values are equal:
	 *      Recursively compare:
	 *          rootOne.left  with rootTwo.right
	 *          rootOne.right with rootTwo.left
	 * - If all recursive checks pass → symmetric.
	 *
	 * Time Complexity: O(n)
	 *      Each node is visited once.
	 *
	 * Space Complexity: O(h)
	 *      h = height of tree (recursion stack).
	 *      Worst case: O(n) for skewed tree.
	 *      Best case: O(log n) for balanced tree.
	 *
	 * </pre>
	 *
	 * @param rootOne root of first subtree
	 * @param rootTwo root of second subtree
	 * @return true if both subtrees are mirror images, otherwise false
	 */
	public static Boolean symmetricBST(TreeNode<Integer> rootOne,TreeNode<Integer> rootTwo) {
	    if (rootOne == null && rootTwo == null)
	        return true;

	    if (rootOne == null || rootTwo == null)
	        return false;

	    if (!Objects.equals(rootOne.data, rootTwo.data))
	        return false;

	    return symmetricBST(rootOne.left, rootTwo.right) && symmetricBST(rootOne.right, rootTwo.left);
	}
	
	/**
	 * 22. Same Tree
	 *
	 * <pre>
	 * Description: Given the roots of two binary trees, determine whether they are identical.
	 *
	 * Two binary trees are considered the same if:
	 * - They are structurally identical.
	 * - Corresponding nodes have equal values.
	 *
	 * Example 1:
	 * Input:
	 *      Tree 1:       1
	 *                   / \
	 *                  2   3
	 *
	 *      Tree 2:       1
	 *                   / \
	 *                  2   3
	 *
	 * Output: true
	 *
	 * Example 2:
	 * Input:
	 *      Tree 1:       1
	 *                   /
	 *                  2
	 *
	 *      Tree 2:       1
	 *                     \
	 *                      2
	 *
	 * Output: false
	 *
	 * Example 3:
	 * Input:
	 *      Tree 1:       1
	 *                   / \
	 *                  2   1
	 *
	 *      Tree 2:       1
	 *                   / \
	 *                  1   2
	 *
	 * Output: false
	 *
	 * Approach:
	 * - Use Recursion (Depth-First Search).
	 * - Base Case:
	 *      If both nodes are null → trees are identical at this branch → return true.
	 * - If only one node is null → structures differ → return false.
	 * - If node values are equal:
	 *      Recursively compare:
	 *          left subtree of rootOne with left subtree of rootTwo
	 *          right subtree of rootOne with right subtree of rootTwo
	 * - If all recursive calls return true → trees are identical.
	 *
	 * Time Complexity: O(n)
	 *      Where n is the number of nodes (each node is visited once).
	 *
	 * Space Complexity: O(h)
	 *      Where h is the height of the tree (recursion stack).
	 *      Worst case: O(n) for skewed tree.
	 *      Best case: O(log n) for balanced tree.
	 *
	 * </pre>
	 *
	 * @param rootOne root of the first binary tree
	 * @param rootTwo root of the second binary tree
	 * @return true if both trees are structurally identical and have equal node values, otherwise false
	 */
	public static Boolean sameTree(TreeNode<Integer> rootOne, TreeNode<Integer> rootTwo) {
		if (rootOne == null && rootTwo == null)
			return true;
		if ((rootOne != null && rootTwo != null) && Objects.equals(rootOne.data, rootTwo.data))
			return sameTree(rootOne.left, rootTwo.left) && sameTree(rootOne.right, rootTwo.right);
		return false;
	}
}
