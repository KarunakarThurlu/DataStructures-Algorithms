package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BinarySearchTree {
	
	private static final Logger logger= Logger.getLogger(BinarySearchTree.class.getName());
	
	public static void main(String[] args) {
		TreeNode<Integer> root=addAll(Arrays.asList(50,40,30,20,10,60,70,90,80));
		logger.log(Level.INFO,"InOrder Traversal : {0} ",inOrderTraversal(root, new ArrayList<>()));
	}
	
	/**
	 * Delete Given key TreeNode
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
	 * Delete all nodes those are grater than k
	 * @param root
	 * @param k
	 * @return
	 */
	public static TreeNode<Integer> deleteNodeII(TreeNode<Integer> root,Integer k){
		if(root==null)
			return root;
		if(root.data>=k)
			root=deleteNodeII(root.left,k);
		else
			root.right=deleteNodeII(root.right,k);
		return root;
	}
	/**
	 * 
	 * @param root
	 * @param list
	 * @return
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
	 * 
	 * @param list
	 * @return
	 */
	public static TreeNode<Integer> addAll(List<Integer> list){
		TreeNode<Integer> root=null;
		for(Integer data:list)
			root=add(root,data);
		return root;
	}
	
	/**
	 * 
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
