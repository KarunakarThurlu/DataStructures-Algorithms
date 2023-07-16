package linkedlist.singlelinklinkedlist;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SingleLinkedList {
	/*
	  1. Adding elements at the end of Head Node.
	  2. Adding elements at the start of Head Node.
	  3. Reversing single linked list
	  4. Find Mid element of single linked list
	  5. Remove element at nth position
	 
	 
	 */
	private static final Logger logger = Logger.getLogger(SingleLinkedList.class.getName());

	
	
	public static void main(String[] args) {
		//logger.log(Level.INFO, "Adding Element At End of HeadNode : {0}", addAtEndOfHeadNode(List.of(10, 20,30,40,50)));
		//logger.log(Level.INFO, "Reverse Single Linked List : {0}", reverseSingleLinkedList(head));
		//logger.log(Level.INFO, "Adding Element At Start of HeadNode : {0}", addAtStartOfHeadNode(List.of("java","go","node","scala","kotlin")));
		//logger.log(Level.INFO, "Adding Element At Start of HeadNode : {0}", findMidElement(addAtStartOfHeadNode(List.of("java","go","node","scala","kotlin"))));
		//logger.log(Level.INFO, "Merging of Two sorted lists : {0}", mergingOfTwoSortedLists(addAtEndOfHeadNode(List.of(10,30,50,70)),addAtEndOfHeadNode(List.of(15, 20,40,60,80))));
		
		
		logger.log(Level.INFO, "After Removing nth element  {0}", removeElementAtNthPosition(1,addAtStartOfHeadNode(List.of("java","go","node","scala","kotlin"))));
	}
	
	/**
	 * 5. Remove element at nth position
	 * @param head
	 * @param n
	 * @return List after removing nth element
	 */
	public static Node<String> removeElementAtNthPosition(Integer n,Node<String> head){
		logger.log(Level.INFO, "Original List : {0}",head);
		if(head==null)
			return null;
		if(n==0)
			return head.next;
		Integer count=1;
		Node<String> temp = head;
		while(temp.next!=null) {
			if(count==n) {
				temp.next=temp.next.next;
				break;
			}
			count++;
			temp=temp.next;
		}
		return head;
	}
	/**
	 * 4. Find Mid element of single linked list
	 * @param first
	 * @param second
	 * @return
	 */
	public static Node<Integer> mergingOfTwoSortedLists(Node<Integer> first,Node<Integer> second){
		if(first==null)
			return second;
		if(second==null)
			return first;
		Node<Integer> t=new Node<>(0);
		Node<Integer> temp=t;
		while(first!=null && second!=null) {
			if(first.data<=second.data) {
				temp.next=first;
				first=first.next;
				temp=temp.next;
			}else {
				temp.next=second;
				second=second.next;
				temp=temp.next;
			}
		}
		temp.next=second==null?first:second;
		return t.next;
	}
	
	/**
	 * 4. Find Mid element of single linked list
	 * @param head
	 * @return
	 */
	public static String findMidElement(Node<String> head) {
		if(head==null)
			return null;
		Node<String> fast=head;
		Node<String> slow=head;
		while(fast!=null && fast.next!=null) {
			fast=fast.next.next;
			slow=slow.next;
		}
		return slow.data;
	}
	
	/**
	 * 3. Reversing Single linked list
	 * @param head
	 * @return
	 */
	public static Node<Integer> reverseSingleLinkedList(Node<Integer> head) {
		if (head.next == null)
			return head;
		Node<Integer> t = reverseSingleLinkedList(head.next);
		head.next.next=head;
		head.next=null;
		return t;
	}
	
	/**
	 * 2. Adding Elements at the start of Head Node.
	 * @param data
	 * @return
	 */
	public static Node<String> addAtStartOfHeadNode(List<String> data){
		Node<String> head=null;
		for(String s:data) {
			Node<String> dataNode = new Node<>(s);
			if(head==null) {
				head=dataNode;
			}else {
				dataNode.next=head;
				head=dataNode;
			}
		}
		return head;
	}
	
	/**
	 * 1. Adding Elements at the end of Head Node.
	 * @param data
	 * @return 
	 */
	public static Node<Integer> addAtEndOfHeadNode(List<Integer> data) {
		Node<Integer> head=null;
		for(Integer e:data){
			Node<Integer> dataNode = new Node<>(e);
			if (head == null)
				head = dataNode;
			else {
				Node<Integer> temp = head;
				while (temp.next != null) {
					temp = temp.next;
				}
				temp.next = dataNode;
			}
		};
		return head;
	}
}
