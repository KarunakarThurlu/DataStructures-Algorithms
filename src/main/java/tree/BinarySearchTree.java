package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
	 */

	/**
	 * 1 Adding Element into BinarySearchTree
	 * 
	 * @param root
	 * @param data
	 * @return root node
	 */
	public static TreeNode<Integer> add(TreeNode<Integer> root, Integer data) {
		if (root == null)
			return new TreeNode<>(data);
		if (root.data < data)
			root.right = add(root.right, data);
		else if (root.data > data)
			root.left = add(root.left, data);
		return root;
	}

	/**
	 * 2. Adding List of Elements at once into BinarySearchTree
	 * 
	 * @param list
	 * @return root node
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
	 * @param rootNode
	 * @param list
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
	 * 4. InOrder Traversal (Left-->Root-->Right)
	 * 
	 * @param root
	 * @param list
	 * @return InOrder Elements List
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
		List<Integer> levelOrderTraversal = new ArrayList<>();
		if (rootNode == null) {
			return levelOrderTraversal;
		}
		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		queue.offer(rootNode);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode<Integer> currentNode = queue.poll();
				levelOrderTraversal.add(currentNode.data);
				if (currentNode.left != null)
					queue.offer(currentNode.left);
				if (currentNode.right != null)
					queue.offer(currentNode.right);
			}
		}
		return levelOrderTraversal;
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
	 * 20 Invert Binary Search Tree (Mirror Tree)
	 * @param root
	 * @return
	 */
	public static TreeNode<Integer> invertBST(TreeNode<Integer> root) {
		if (root == null) {
			return root;
		}
		TreeNode<Integer> left = invertBST(root.left);
		TreeNode<Integer> right = invertBST(root.right);
		root.left = right;
		root.right = left;
		return root;
	}
	
	/**
	 * 21 Symmetric Binary Search Tree (Mirror Tree)
	 * @param root
	 * @return
	 */
	public static Boolean symmetricBST(TreeNode<Integer> rootOne,TreeNode<Integer> rootTwo) {
		if (rootOne == null && rootTwo == null) {
			return true;
		}
		if((rootOne != null && rootTwo != null) && (rootOne.data.equals(rootTwo.data))) {
			return symmetricBST(rootOne.left,rootTwo.right) && symmetricBST(rootOne.right,rootTwo.left);
		}
		return false;
	}
}
