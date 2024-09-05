package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

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
	 * A binary tree where the left child node is less than parent node and  right child node is greater than parent node.
	 * 
	 * 
	 * Usage: BSTs are used for efficient searching, insertion, and deletion operations. Because of the ordering property, search operations in a balanced BST can be performed in O(log n) time.
	 * -----
	 * 
	 * 
	 * -----------------------------------------
	 * Coding challenges on Binary Search Tree
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
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	private static final Logger logger= Logger.getLogger(BinarySearchTree.class.getName());
 
	public static void main(String[] args) {
		
		/*
		   	     6
       		   /   \
      		  4     8
     		 / \   / \
    		2   5 7   9
    				   \
    				   12
    				  /  \
                     11  13
		 */
		var list = Arrays.asList(6,4,8,2,5,7,9,12,11,13);
		TreeNode<Integer> root=addAll(list);
	  	
		logger.log(Level.INFO,"PreOrder Traversal   : {0}  ", preOrderTraversal(root, new ArrayList<>()));   
		logger.log(Level.INFO,"InOrder  Traversal   : {0}  ", inOrderTraversal(root, new ArrayList<>()));    
		logger.log(Level.INFO,"PostOrder Traversal  : {0}  ", postOrderTraversal(root, new ArrayList<>()));
		logger.log(Level.INFO,"LevelOrder Traversal : {0}  ", levelOrderTraversal(root));
		logger.log(Level.INFO,"Left view of BinarySearch Tree   : {0} ",bstLeftSideView(root)); 
		logger.log(Level.INFO,"Right view of BinarySearch Tree  : {0} ",bstRightSideView(root)); 
		logger.log(Level.INFO,"Height of BinarySearch Tree      : {0} ",findHeightOfBST(root)); 
	    logger.log(Level.INFO,"Deleting Elements grater than 11 : {0} ",preOrderTraversal(deleteNodeII(root,11), new ArrayList<>())); 
		logger.log(Level.INFO,"Deleting element  8  : {0}  ", preOrderTraversal(deleteNode(root,8), new ArrayList<>()));
	}
	
	
	/**
	 * 11 Finding Height of BST
	 * @param rootNode
	 * @return Integer 
	 */
	public static Integer findHeightOfBST(TreeNode<Integer> rootNode) {
		if(rootNode==null) return 0;
		Integer leftNodeHeight  = findHeightOfBST(rootNode.left);
		Integer rightNodeHeight = findHeightOfBST(rootNode.right);
		return Math.max(leftNodeHeight, rightNodeHeight)+1;
	}

	/**
	 * 10  Right View Of BinarySearchTree
	 * @param rootNode
	 * @return List<Integer> that contains right view elements
	 */
	public static List<Integer> bstRightSideView(TreeNode<Integer> rootNode){
		List<Integer> list = new ArrayList<>();
		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		if(rootNode==null) return list;
		queue.add(rootNode);
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i=0;i<size;i++) {
				TreeNode<Integer> poll = queue.poll();
				if(i==size-1) list.add(poll.data);
				if(poll.left!=null) queue.add(poll.left);
				if(poll.right!=null) queue.add(poll.right);
			}
		}
		return list;
	}
	
	/**
	 * 9  Left View Of BinarySearchTree
	 * @param rootNode
	 * @return List<Integer> that contains left view elements
	 */
	public static List<Integer> bstLeftSideView(TreeNode<Integer> rootNode){
		List<Integer> list = new ArrayList<>();
		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		if(rootNode==null) return list;
		queue.add(rootNode);
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i=0;i<size;i++) {
				TreeNode<Integer> poll = queue.poll();
				if(i==0) list.add(poll.data);
				if(poll.left!=null) queue.add(poll.left);
				if(poll.right!=null) queue.add(poll.right);
			}
		}
		return list;
	}

	/**
	 * 8. Deleting specific node in BinarySearchTree
	 * @param root
	 * @param data
	 * @return
	 */
	public static TreeNode<Integer> deleteNode(TreeNode<Integer> root,Integer data){
		if(root==null) 
			return root;
		
		if(root.data<data) {
			root.right=deleteNode(root.right,data);
		} else if(root.data>data) {
			root.left=deleteNode(root.left,data);
		} else {
			if(root.left==null) {
				return root.right;
			} else if(root.right==null) {
				return root.left;
		    } else if(root.left!=null && root.right!=null) {
				root.data=findMinFromRightSubTree(root.right);
				root.right=deleteNode(root.right, root.data);
			} else {
				return null;
			}
		}
		return root;
	}
	/**
	 *
	 * @param root
	 * @return
	 */
	private static Integer findMinFromRightSubTree(TreeNode<Integer> root) {
		while(root.left!=null)
			root=root.left;
		return root.data;
	}

	/**
	 * 7. Delete all nodes those are grater than k
	 * @param root
	 * @param k
	 * @return
	 */
	public static TreeNode<Integer> deleteNodeII(TreeNode<Integer> root,Integer k){
		if(root==null)
			return root;
		if(root.data>k)
			root=deleteNodeII(root.left,k);
		else
			root.right=deleteNodeII(root.right,k);
		return root;
	}
	 
	/**
	 * 6. Level Order Traversal of BinarySearch Tree
	 * @param rootNode
	 * @return List of levelOrderTraversal elements
 	 */
	public static List<List<Integer>> levelOrderTraversal(TreeNode<Integer> rootNode){
		List<List<Integer>> levelOrderTraversal = new ArrayList<>();
		Queue<TreeNode<Integer>> queue =new LinkedList<>();
		queue.offer(rootNode);
		while(!queue.isEmpty()) {
			List<Integer> level =new ArrayList<>();
			int size=queue.size();
			for(int i=0;i<size;i++) {
				TreeNode<Integer> currentNode=queue.poll();
				level.add(currentNode.data);
				if(currentNode.left!=null)
					queue.offer(currentNode.left);
				if(currentNode.right!=null)
					queue.offer(currentNode.right);
			}
			levelOrderTraversal.add(level);
		}
		return levelOrderTraversal;
	}

	/**
	 * 5. PostOrder Traversal (Left-->Right-->Root)
	 * @param root
	 * @param list
	 * @return PostOrder Elements List
	 */
	public static List<Integer> postOrderTraversal(TreeNode<Integer> root,List<Integer> list){
		if(root!=null) {
			postOrderTraversal(root.left,list);
			postOrderTraversal(root.right,list);
			list.add(root.data);
		}
		return list;
	}

	/**
	 * 4. InOrder Traversal  (Left-->Root-->Right)
	 * @param root
	 * @param list
	 * @return InOrder Elements List
	 */
	public static List<Integer> inOrderTraversal(TreeNode<Integer> root,List<Integer> list){
		if(root!=null) {
			inOrderTraversal(root.left,list);
			list.add(root.data);
			inOrderTraversal(root.right,list);
		}
		return list;
	}
	
	/**
	 * 3. PreOrder Traversal (Root-->Left-->right)
	 * @param rootNode
	 * @param list
	 * @return PreOrder Elements List
	 */
	public static List<Integer> preOrderTraversal(TreeNode<Integer> rootNode,List<Integer> list){
		if(rootNode!=null) {
			list.add(rootNode.data);
			preOrderTraversal(rootNode.left,list);
			preOrderTraversal(rootNode.right,list);
		}
		return list;
	}

	/**
	 * 2. Adding List of Elements at once into BinarySearchTree
	 * @param list
	 * @return root node
	 */
	public static TreeNode<Integer> addAll(List<Integer> list){
		TreeNode<Integer> root=null;
		for(Integer data:list)
			root=add(root,data);
		return root;
	}

	/**
	 * 1  Adding Element into BinarySearchTree
	 * @param root
	 * @param data
	 * @return root node
	 */
	public static TreeNode<Integer> add(TreeNode<Integer> root,Integer data){
		if(root==null)
			return new TreeNode<>(data);
		if(root.data<data)
			root.right=add(root.right,data);
		else if(root.data>data)
			root.left=add(root.left,data);
		return root;
	}
}
