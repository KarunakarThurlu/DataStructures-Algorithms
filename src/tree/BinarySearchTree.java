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
	 * 11 Valid BinarySearchTree
	 * 12 Balanced BinarySearchTree  
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
		var list = Arrays.asList(40, 30, 50,25,35,15,28,45,60,55,54,70);
		TreeNode<Integer> root=addAll(list);
		/*logger.log(Level.INFO,"PreOrder Traversal  for  : {0}   is   : {1}",new Object[] {list,PreOrderTraversal(root, new ArrayList<>())});   //INFO: preOrder Traversal  for  : [40, 30, 50, 25, 35, 15, 28, 45, 60, 55, 70]   is   : [40, 30, 25, 15, 28, 35, 50, 45, 60, 55, 70]
		  logger.log(Level.INFO,"InOrder  Traversal  for  : {0}   is   : {1}",new Object[] {list,InOrderTraversal(root, new ArrayList<>())});    //INFO: InOrder Traversal   for  : [40, 30, 50, 25, 35, 15, 28, 45, 60, 55, 70]   is   : [15, 25, 28, 30, 35, 40, 45, 50, 55, 60, 70]
		  logger.log(Level.INFO,"PostOrder Traversal for  : {0}   is   : {1}",new Object[] {list,PostOrderTraversal(root, new ArrayList<>())});  //INFO: postOrder Traversal for  : [40, 30, 50, 25, 35, 15, 28, 45, 60, 55, 70]   is   : [15, 25, 28, 30, 35, 45, 50, 55, 60, 70, 40]
		  logger.log(Level.INFO,"Deleting Elements those are grater than 50   : {0}  ",preOrderTraversal(deleteNodeII(root,50), new ArrayList<>())); //INFO: Deleting Elements those are grater than 50   : [40, 30, 25, 15, 28, 35, 50, 45] 
		  logger.log(Level.INFO,"Deleting element  50   : {0}  ",preOrderTraversal(deleteNode(root,50), new ArrayList<>()));  //INFO: Deleting element  50   : [40, 30, 25, 15, 28, 35, 55, 45, 60, 70] 


		 */
		logger.log(Level.INFO,"Left view of BinarySearch Tree   : {0}  ",binarySearchTreeLeftSideView(root)); 
	}


	


	/**
	 * 
	 * @param treeNode
	 * @return
	 */
	static int maxLevel=0;
	public static List<Integer> binarySearchTreeLeftSideView(TreeNode<Integer> treeNode){
		return binarySearchTreeLeftSideView(treeNode,new ArrayList<>(),1);
	}
	
	/**
	 * 
	 * @param treeNode
	 * @param list
	 * @param maxLevel
	 * @param currentLevel
	 * @return
	 */
	private static List<Integer> binarySearchTreeLeftSideView(TreeNode<Integer> treeNode, List<Integer> list,int currentLevel) {
		if(treeNode==null)
			return list;
		if(maxLevel<currentLevel) {
			list.add(treeNode.data);
			maxLevel=currentLevel;
		}
		
		binarySearchTreeLeftSideView(treeNode.left,list,currentLevel+1);
		binarySearchTreeLeftSideView(treeNode.right,list,currentLevel+1);
		return list;
	}





	/**
	 * 8. Deleting specific node in BinarySearchTree
	 * @param root
	 * @param data
	 * @return
	 */
	public static TreeNode<Integer> deleteNode(TreeNode<Integer> root,Integer data){
		if(root==null) {
			return root;
		}
		if(root.data<data)
			root.right=deleteNode(root.right,data);
		else if(root.data>data)
			root.left=deleteNode(root.left,data);
		else {
			if(root.left==null)
				return root.right;
			else if(root.right==null)
				return root.left;
			else if(root.left!=null && root.right!=null) {
				root.data=findMinFromRightSubTree(root.right);
				root.right=deleteNode(root.right, root.data);
			}else {
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
		List<List<Integer>> levelOrderTraversal=new ArrayList<>();
		Queue<TreeNode<Integer>> queue=new LinkedList<>();
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
			inOrderTraversal(root.left,list);
			inOrderTraversal(root.right,list);
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
	 * @return root
	 */
	public static TreeNode<Integer> addAll(List<Integer> list){
		TreeNode<Integer> root=null;
		for(Integer data:list)
			root=add(root,data);
		return root;
	}

	/**
	 * 1. Adding Element into BinarySearchTree
	 * @param root
	 * @param data
	 * @return
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
