package linkedlist;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class SingleLinkedList {
	/*
	 * 1. Adding elements at the end of Head Node. 
	 * 2. Adding elements at the start of Head Node. 
	 * 3. Reverse sing single linked list 
	 * 4. Find Mid element of single linked list 
	 * 5. Remove element at nth position 
	 * 6. Remove element at nth position from end 
	 * 7. Adding element at nth position 
	 * 8. Remove duplicates from sorted list 
	 * 9. Merge sorted linked lists 
	 * 10.Delete nodes from list present in array 
	 * 11.Deleting node
	 */

	/**
	 * 11. Delete Node from Linked List
	 *
	 * <p> Description : Given the head of a singly linked list and a value, delete the <b>first occurrence</b> of the node containing that value and return the head of the modified linked list. </p>
	 *
	 * <p>
	 * <pre>
	 * Example 1: Input: head = [4,5,1,9], value = 5 Output: [4,1,9]
	 * Example 2: Input: head = [4,5,1,9], value = 1 Output: [4,5,9]
	 * Example 3: Input: head = [1], value = 1 Output: []
	 * Example 4: Input: head = [1,2,3], value = 4 Output: [1,2,3]
	 * Example 5: Input: head = [], value = 1 Output: []
	 * </pre>
	 * </p>
	 *
	 * <p>
	 * <b>Approach:</b>
	 * <pre>
	 * - Handle the edge case where the linked list is empty.
	 * - If the head node itself contains the value, delete it by returning head.next.
	 * - Traverse the list using a pointer.
	 * - When the next node contains the given value:
	 *     - Skip the node by updating current.next.
	 *     - Stop traversal since only the first occurrence is deleted.
	 * - Return the original head of the list.
	 * </pre>
	 * </p>
	 *
	 * <b>Time Complexity:</b> O(n)
	 * <br>
	 * where n is the number of nodes in the linked list.
	 *
	 * <br><br>
	 * <b>Space Complexity:</b> O(1)
	 * <br>
	 * No extra space is used apart from pointers.
	 *
	 * @param head  head of the singly linked list
	 * @param value value of the node to be deleted
	 * @return head of the linked list after deletion
	 */
	public static Node<Integer> deleteNode(Node<Integer> head, Integer value) {

		// Edge case: empty linked list
		if (head == null) {
			return null;
		}

		// If the head node itself contains the value to be deleted
		if (head.data.equals(value)) {
			return head.next;
		}

		// Pointer to traverse the linked list
		Node<Integer> currentNode = head;

		// Traverse until the second last node
		while (currentNode.next != null) {

			// If the next node contains the value, delete it
			if (currentNode.next.data.equals(value)) {
				currentNode.next = currentNode.next.next;
				break; // Only delete the first occurrence
			}

			// Move to the next node
			currentNode = currentNode.next;
		}

		// Return the unchanged head reference
		return head;
	}
	
	/**
	 * 10. Delete Nodes from Linked List Present in Array
	 *
	 * <p> Description : Given the head of a singly linked list and an array of integers, delete all nodes from the linked list whose values are present in the given array. Return the head of the modified linked list. </p>
	 *
	 * <p>
	 * <pre>
	 * Example 1: Input: list = [1,2,3,4,5], nums = [2,4] Output: [1,3,5]
	 * Example 2: Input: list = [1,1,1,2,3], nums = [1] Output: [2,3]
	 * Example 3: Input: list = [5,6,7], nums = [8,9] Output: [5,6,7]
	 * Example 4: Input: list = [1,2,3], nums = [1,2,3] Output: []
	 * Example 5: Input: list = [], nums = [1,2] Output: []
	 * </pre>
	 * </p>
	 *
	 * <p>
	 * <b>Approach:</b>
	 * <pre>
	 * - Convert the given array into a HashSet for O(1) lookup time.
	 * - Use a dummy (sentinel) node before the head to simplify deletions,
	 *   especially when the head node itself must be removed.
	 * - Traverse the linked list using a pointer:
	 *     - If the next node's value exists in the set, skip (delete) that node.
	 *     - Otherwise, move forward.
	 * - Continue until the end of the list is reached.
	 * - Return dummy.next as the new head of the modified list.
	 * </pre>
	 * </p>
	 *
	 * <b>Time Complexity:</b> O(n + m)
	 * <br>
	 * where n is the number of nodes in the linked list and m is the length
	 * of the input array.
	 *
	 * <br><br>
	 * <b>Space Complexity:</b> O(m)
	 * <br>
	 * Extra space is used for storing elements of the array in a HashSet.
	 *
	 * @param head head of the singly linked list
	 * @param nums array containing values to be deleted from the list
	 * @return head of the linked list after deleting specified nodes
	 */
	public static Node<Integer> deleteNodes(Node<Integer> head, Integer[] nums) {
		// Edge case: empty list
		if (head == null)
			return head;

		// Step1: Build a lookup set from nums for O(1) containment checks
		Set<Integer> lookUp = Arrays.stream(nums).collect(Collectors.toSet());

		// Step2: Dummy node to handle head deletion
		Node<Integer> temp = new Node<>(0);
		temp.next = head;

		// Step3: Start traversal from dummy node
		Node<Integer> current = temp;

		// Step4: Traverse the list
		while (current.next != null) {
			// Step4.1: If next node should be deleted, skip it
			if (lookUp.contains(current.next.data)) {
				current.next = current.next.next;
			} else {
				// Step4.2: Otherwise, move forward
				current = current.next;
			}
		}
		// Step5: Return new head (dummy.next handles head deletions)
		return temp.next;
	}

	/**
	 * 9. Merge Two Sorted Linked Lists
	 *
	 * <p> Given the heads of two sorted singly linked lists, merge them into one sorted linked list and return the head of the merged list. </p>
	 *
	 * <p>
	 * <pre>
	 * Example 1: Input: list1 = [1,2,4], list2 = [1,3,4] Output: [1,1,2,3,4,4]
	 * Example 2: Input: list1 = [], list2 = [] Output: []
	 * Example 3: Input: list1 = [], list2 = [0] Output: [0]
	 * Example 4: Input: list1 = [2,5,7], list2 = [1,3,6,8] Output: [1,2,3,5,6,7,8]
	 * Example 5: Input: list1 = [1,1,1], list2 = [1,1] Output: [1,1,1,1,1]
	 * </pre>
	 * </p>
	 *
	 * <p>
	 * <b>Approach:</b>
	 * <pre>
	 * - Use a dummy (sentinel) node to simplify handling edge cases.
	 * - Maintain a pointer to build the merged list.
	 * - Compare the current nodes of both lists:
	 *     - Append the smaller value to the merged list.
	 *     - Move the pointer of the list from which the value was taken.
	 * - Continue until one list is exhausted.
	 * - Attach the remaining nodes from the non-empty list.
	 * - Return the merged list starting from dummy.next.
	 * </pre>
	 * </p>
	 *
	 * <b>Time Complexity:</b> O(n + m)
	 * <br>
	 * where n and m are the lengths of the two linked lists.
	 *
	 * <br><br>
	 * <b>Space Complexity:</b> O(n + m)
	 * <br>
	 * A new linked list is created to store the merged result.
	 *
	 * @param firstHead  head of the first sorted linked list
	 * @param secondHead head of the second sorted linked list
	 * @return head of the merged sorted linked list
	 */
	public static Node<Integer> mergeSortedLists(Node<Integer> firstHead, Node<Integer> secondHead) {
	    // Dummy node to simplify edge cases (like empty result list)
	    Node<Integer> dummyHead = new Node<>(0);

	    // Pointer used to build the merged list
	    Node<Integer> current = dummyHead;

	    // Traverse both lists until one becomes null
	    while (firstHead != null && secondHead != null) {

	        // Compare current nodes of both lists
	        if (firstHead.data < secondHead.data) {
	            // Attach smaller node from first list
	            current.next = new Node<>(firstHead.data);
	            firstHead = firstHead.next;
	        } else {
	            // Attach smaller (or equal) node from second list
	            current.next = new Node<>(secondHead.data);
	            secondHead = secondHead.next;
	        }

	        // Move the pointer forward in the merged list
	        current = current.next;
	    }

	    // If any elements remain in the first list, attach them
	    if (firstHead != null) {
	        current.next = firstHead;
	    }

	    // If any elements remain in the second list, attach them
	    if (secondHead != null) {
	        current.next = secondHead;
	    }

	    // Return the head of the merged list (skip dummy node)
	    return dummyHead.next;
	}

	/**
	 * 8. Remove duplicates from sorted linked list
	 * 
	 * @param head
	 * @return head contains unique elements
	 */
	public static Node<Integer> removeDuplicates(Node<Integer> head) {
		if (head == null) {
			return head;
		}
		Node<Integer> temp = head;
		while (null != temp && null != temp.next) {
			while ((null != temp && null != temp.next) && (temp.data == temp.next.data)) {
				temp.next = temp.next.next;
			}
			temp = temp.next;
		}
		return head;
	}

	/**
	 * 7. Adding element at nth position
	 * 
	 * @param head
	 * @param data
	 * @param n
	 * @return head with added an element at nth position
	 */
	public static Node<Integer> addAtNthPosition(Node<Integer> head, Integer data, int n) {
		if (head == null || n < 0) {
			return head;
		}
		Node<Integer> dataNode = new Node<>(data);
		if (n == 0) {
			dataNode.next = head;
			return dataNode;
		}
		Node<Integer> temp = head;
		for (int i = 1; i < n; i++) {
			if (temp.next == null) {
				return head;
			}
			temp = temp.next;
		}
		Node<Integer> next = temp.next;
		temp.next = dataNode;
		dataNode.next = next;
		return head;
	}

	/**
	 * 6. Remove element at nth position from end
	 * 
	 * @param head
	 * @param n
	 * @return head with removed nth node from end
	 */
	public static Node<Integer> removeNthNodeFromEnd(Node<Integer> head, int n) {
		Node<Integer> fastPointer = head;
		Node<Integer> slowPointer = head;
		// Move fast Pointer n times forawd
		for (int i = 0; i < n; i++) {

			// If n is greater than list size
			if (fastPointer == null) {
				return head;
			}
			fastPointer = fastPointer.next;
		}

		// Remove Nth node from end (n==Size of LinkedList) i.e 1st node from start
		if (fastPointer == null) {
			return slowPointer.next;
		}

		// Move FP and SP by one step at a time
		while (fastPointer != null && fastPointer.next != null) {
			fastPointer = fastPointer.next;
			slowPointer = slowPointer.next;
		}
		// If Fastpointer at end then Slowpointer at Size-n poition
		slowPointer.next = slowPointer.next.next;
		return head;
	}

	/**
	 * 5. Remove element at nth position
	 * 
	 * @param head
	 * @param n
	 * @return List after removing nth element
	 */
	public static Node<Integer> removeElementAtNthPosition(Integer n, Node<Integer> head) {
		if (head == null || n < 0)
			return head;
		Node<Integer> temp = head;
		if (n == 0) {
			return head.next;
		}
		for (int i = 1; i < n; i++) {
			if (temp == null) {
				return head;
			}
			temp = temp.next;
		}
		temp.next = temp.next.next;
		return head;
	}

	/**
	 * 4. Find Mid element of single linked list
	 * 
	 * @param first
	 * @param second
	 * @return
	 */
	public static Node<Integer> mergingOfTwoSortedLists(Node<Integer> first, Node<Integer> second) {
		if (first == null)
			return second;
		if (second == null)
			return first;
		Node<Integer> t = new Node<>(0);
		Node<Integer> temp = t;
		while (first != null && second != null) {
			if (first.data <= second.data) {
				temp.next = first;
				first = first.next;
				temp = temp.next;
			} else {
				temp.next = second;
				second = second.next;
				temp = temp.next;
			}
		}
		temp.next = second == null ? first : second;
		return t.next;
	}

	/**
	 * 4. Find Mid element of single linked list
	 * 
	 * @param head
	 * @return
	 */
	public static String findMidElement(Node<String> head) {
		if (head == null)
			return null;
		Node<String> fast = head;
		Node<String> slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow.data;
	}

	/**
	 * 3. Reversing Single linked list
	 * 
	 * @param head
	 * @return
	 */
	public static Node<Integer> reverseSingleLinkedList(Node<Integer> head) {
		if (head.next == null)
			return head;
		Node<Integer> t = reverseSingleLinkedList(head.next);
		head.next.next = head;
		head.next = null;
		return t;
	}

	/**
	 * 2. Adding Elements at the start of Head Node.
	 * 
	 * @param data
	 * @return
	 */
	public static Node<String> addAtStartOfHeadNode(List<String> data) {
		Node<String> head = null;
		for (String s : data) {
			Node<String> dataNode = new Node<>(s);
			if (head == null) {
				head = dataNode;
			} else {
				dataNode.next = head;
				head = dataNode;
			}
		}
		return head;
	}

	/**
	 * 1. Adding Elements at the end of Head Node.
	 * 
	 * @param data
	 * @return head node
	 */
	public static Node<Integer> addAtEndOfHeadNode(List<Integer> data) {
		Node<Integer> head = null;
		for (Integer e : data) {
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
		}
		;
		return head;
	}
}

class Node<T> {
	T data;
	Node<T> next;
	
	public Node(T data) {
		super();
		this.data = data;
		this.next = null;
	}

	public Node() {
		super();
	}
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Node<?> other = (Node<?>) obj;

        return Objects.equals(this.data, other.data) && Objects.equals(this.next, other.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, next);
    }

	@Override
	public String toString() {
		return "[ " + data +" | -]-->"+ next+ "";
	}
	
}
