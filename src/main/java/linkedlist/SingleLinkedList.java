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
	 * 12.Swaps nodes of a singly linked list in pairs.
	 * 13.Reverse linked list by frequency
	 * 14.Merge k sorted lists
	 * 15.Rotate linked list
	 */
	/**
	 * 15. Rotate Linked List
	 *
	 * <p>
	 * <b>Description:</b><br> Given the head of a singly linked list and a non-negative integer <code>k</code>, rotate the linked list to the right by <code>k</code> positions.
	 * </p>
	 *
	 * <p>
	 * A right rotation means that each rotation moves the last node to the front.
	 * </p>
	 *
	 * <p>
	 * <pre>
	 * Example 1: Input:  head = [1, 2, 3, 4, 5], k = 2 Output: [4, 5, 1, 2, 3]
	 * Example 2: Input:  head = [0, 1, 2], k = 4 Output: [2, 0, 1]
	 * Example 3: Input:  head = [1], k = 3 Output: [1]
	 * Example 4: Input:  head = [], k = 1 Output: []
	 * </pre>
	 * </p>
	 *
	 * <p>
	 * <b>Approach:</b>
	 * <pre>
	 * 1. Handle edge cases (empty list or single node).
	 * 2. Traverse the list to find:
	 *    - Length of the linked list
	 *    - Last node (tail)
	 * 3. Normalize k using k = k % length.
	 * 4. Convert the list into a circular linked list by connecting tail.next = head.
	 * 5. Move (length - k) steps to find the new tail.
	 * 6. Set newHead = newTail.next.
	 * 7. Break the circular link.
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
	 * Rotation is done in-place without extra memory.
	 *
	 * @param <T>  the type of data stored in the linked list
	 * @param head head of the singly linked list
	 * @param k    number of times the list should be rotated to the right
	 * @return new head of the rotated linked list
	 */
	public static <T> Node<T> rotateLinkedList(Node<T> head, int k) {
		  // Edge cases: empty list or single node
	    if (head == null || head.next == null || k == 0) {
	        return head;
	    }

	    // Step 1: Find length of the linked list and last node
	    Node<T> tail = head;
	    int length = 1;

	    while (tail.next != null) {
	        length++;
	        tail = tail.next;
	    }

	    // Step 2: Normalize k when k > length
	    k = k % length;
	    if (k == 0) {
	        return head; // No rotation needed
	    }

	    // Step 3: Make the linked list circular
	    tail.next = head;

	    // Step 4: Find the new tail (length - k steps)
	    Node<T> newTail = head;
	    for (int i = 1; i < length - k; i++) {
	        newTail = newTail.next;
	    }

	    // Step 5: Set new head and break the circular link
	    Node<T> newHead = newTail.next;
	    newTail.next = null;

	    return newHead;
	}
	 
	/**
	 * 14. Merge K Sorted Linked Lists
	 * 
	 * <p>
	 * <pre>
	 * Description: Given a list of k sorted singly linked lists, merge them into one sorted linked list and return the head of the merged list.
	 *
	 * Example 1: Input: lists = [[1,4,5],[1,3,4],[2,6]] Output: [1,1,2,3,4,4,5,6]
	 * Example 2: Input: lists = [] Output: []
	 * Example 3: Input: lists = [[]] Output: []
	 * Example 4: Input: lists = [[1,2,3],[4,5,6],[7,8,9]] Output: [1,2,3,4,5,6,7,8,9]
	 * Example 5: Input: lists = [[1,4,5],[1,3,4],[2,6],[0,9]] Output: [0,1,1,2,3,4,4,5,6,9]
	 * 
	 * Approach:
	 * - Use a min-heap (priority queue) to keep track of the smallest current node among the k lists.
	 * - Initialize the min-heap with the head nodes of all non-empty lists.
	 * - Create a dummy node to simplify edge cases when building the merged list.
	 * - While the min-heap is not empty:
	 *    - Extract the node with the smallest value from the min-heap.
	 *    - Append this node to the merged list.
	 *    - If the extracted node has a next node, add that next node to the min-heap.
	 *    - Return the merged list starting from dummy.next.
	 *    - This approach efficiently merges k sorted lists with a time complexity of O(N log k), where N is the total number of nodes across all lists.
	 *    - Alternatively, we can iteratively merge the lists two at a time using the mergeSortedLists method defined earlier, which has a time complexity of O(kN) in the worst case.
	 * 
	 * <b>Time Complexity:</b> O(N log k) where N is the total number of nodes across all lists and k is the number of lists.
	 * <b>Space Complexity:</b> O(k) for the min-heap storing the current nodes of each list.
	 * 
	 * </pre>
	 * </p>
	 * 
	 * @param lists a list of head nodes of k sorted linked lists
	 * @return head of the merged sorted linked list
	 */
	public static Node<Integer> mergeSortedLists(List<Node<Integer>> lists) {
		
		// Edge case: if the list of linked lists is empty, return null
		if (lists.size() == 0)
			return null;
		
		// If there is only one linked list, return its head as the merged result
		if (lists.size() == 1)
			return lists.get(0);
		
		// Initialize the head of the merged list with the first linked list
		Node<Integer> head = lists.get(0);
		
		// Merge each subsequent list with the current merged result
		for (int i = 1; i < lists.size(); i++)
			// Merge the current head with the next list and update head to the new merged list
			head = mergeSortedLists(head, lists.get(i));
		
		// Return the head of the fully merged linked list
		return head;
	}

	/**
	 * 13. Reverse Linked List by Frequency (Group Size)
	 *
	 * <p>
	 * <b>Description:</b><br>
	 * Given the head of a singly linked list and a positive integer <code>frequency</code>,
	 * reverse the linked list in groups of size <code>frequency</code>.
	 * </p>
	 *
	 * <p>If the number of remaining nodes is less than <code>frequency</code>, those nodes are also reversed.</p>
	 *
	 * <p>
	 * <pre>
	 * Example 1: Input:  head = [1, 2, 3, 4, 5, 6], frequency = 2 Output: [2, 1, 4, 3, 6, 5]
	 * Example 2: Input:  head = [1, 2, 3, 4, 5], frequency = 3 Output: [3, 2, 1, 5, 4]
	 * Example 3: Input:  head = [1, 2], frequency = 3 Output: [2, 1]
	 * Example 4: Input:  head = [], frequency = 2 Output: []
	 * </pre>
	 * </p>
	 *
	 * <p>
	 * <b>Approach:</b>
	 * <pre>
	 * - Traverse the linked list group by group.
	 * - For each group:
	 *     - Count up to 'frequency' nodes.
	 *     - Reverse the collected nodes.
	 *     - Connect the reversed group to the previous group.
	 * - Keep track of:
	 *     - newHead: head of the final modified list
	 *     - previousGroupTail: tail of the previously processed group
	 * - Continue until all nodes are processed.
	 * </pre>
	 * </p>
	 *
	 * <b>Time Complexity:</b> O(n) Each node is visited exactly once.
	 * <br>
	 * <b>Space Complexity:</b> O(1) In-place reversal using constant extra space.
	 *
	 * @param <T>          the type of data stored in the linked list
	 * @param originalHead head of the singly linked list
	 * @param frequency    number of nodes to reverse in each group
	 * @return head of the modified linked list
	 */
	public static <T> Node<T> reverseLinkedListByFrequency(Node<T> originalHead, int frequency) {

	    // Edge cases:
	    // - Empty list
	    // - Invalid frequency
	    // - Single node list
	    if (originalHead == null || frequency <= 0 || originalHead.next == null) {
	        return originalHead;
	    }

	    Node<T> newHead = null;              // Head of the final modified list
	    Node<T> currentNode = originalHead;  // Pointer to traverse the list
	    Node<T> previousGroupTail = null;    // Tail of the previously reversed group

	    while (currentNode != null) {

	        int count = 0;
	        Node<T> groupStart = currentNode; // Starting node of the current group

	        // Move currentNode ahead by 'frequency' nodes
	        while (count < frequency && currentNode != null) {
	            count++;
	            currentNode = currentNode.next;
	        }

	        // Reverse exactly 'count' nodes (handles last partial group as well)
	        Node<T> reversedGroupHead = reverseGroup(groupStart, count);

	        // If this is the first group, set it as the new head
	        if (newHead == null) {
	            newHead = reversedGroupHead;
	        }

	        // Connect previous group to current reversed group
	        if (previousGroupTail != null) {
	            previousGroupTail.next = reversedGroupHead;
	        }

	        // After reversal, groupStart becomes the tail of this group
	        previousGroupTail = groupStart;
	    }

	    return newHead;
	}

	/**
	 * Reverses exactly 'count' nodes starting from the given node.
	 *
	 * <p>
	 * This method performs an in-place reversal of a linked list segment.
	 * </p>
	 *
	 * <p>
	 * Example:
	 * <pre>
	 * Input:  startNode = [1 -> 2 -> 3], count = 2
	 * Output: [2 -> 1]
	 * </pre>
	 * </p>
	 *
	 * @param <T>        the type of data stored in the linked list
	 * @param startNode starting node of the group to be reversed
	 * @param count     number of nodes to reverse
	 * @return head of the reversed group
	 */
	private static <T> Node<T> reverseGroup(Node<T> startNode, int count) {

	    Node<T> reversedHead = null;     // Head of the reversed group
	    Node<T> currentNode = startNode; // Pointer to traverse the group
	    Node<T> nextNode;                // Temporary pointer to store next node

	    // Reverse 'count' nodes
	    while (count-- > 0 && currentNode != null) {

	        nextNode = currentNode.next;     // Save next node
	        currentNode.next = reversedHead; // Reverse pointer
	        reversedHead = currentNode;      // Move reversed head
	        currentNode = nextNode;          // Move forward
	    }

	    return reversedHead;
	}
	
	/**
	 * 12. Swaps nodes of a singly linked list in pairs.
	 *
	 * <p>Description :  Given a linked list, swap every two adjacent nodes and return the head of the modified list.</p>
	 *
	 * <pre>
	 * Example 1: Input: [1,2,3,4]   Output: [2,1,4,3]
	 * Example 2: Input: [1,2,3]     Output: [2,1,3]
	 * Example 3: Input: [1]         Output: [1]
	 * Example 4: Input: []          Output: []
	 * </pre>
	 *
	 * <b>Approach (Iterative):</b>
	 * <pre>
	 * - Use a dummy node before the head to simplify swapping at the start.
	 * - Maintain a pointer (previousNode) to track the node before the pair.
	 * - For each iteration:
	 *     - Identify the two nodes to be swapped.
	 *     - Rewire their next pointers to swap them.
	 *     - Move previousNode forward to the end of the swapped pair.
	 * - Continue until fewer than two nodes remain.
	 * </pre>
	 *
	 * <b>Time Complexity:</b> O(n)  
	 * <b>Space Complexity:</b> O(1)
	 *
	 * @param head head of the linked list
	 * @param <T>  type of data stored in the linked list
	 * @return head of the list after swapping nodes in pairs
	 */
	public static <T> Node<T> swapNodesInPair(Node<T> head) {
		return reverseLinkedListByFrequency(head, 2);
	}
	
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
	 * 8. Remove Duplicates from Sorted Linked List
	 *
	 * <p>
	 * Description : Given the head of a <b>sorted</b> singly linked list,
	 * remove all duplicate elements such that each value appears only once.
	 * The list must be modified in-place and the original head should be returned.
	 * </p>
	 *
	 * <p>
	 * <pre>
	 * Example 1: Input: list = [1,1,2,3,3] Output: [1,2,3]
	 * Example 2: Input: list = [1,1,1,1]   Output: [1]
	 * Example 3: Input: list = [1,2,3]     Output: [1,2,3]
	 * Example 4: Input: list = []          Output: []
	 * Example 5: Input: list = [1]         Output: [1]
	 * </pre>
	 * </p>
	 *
	 * <p>
	 * <b>Approach:</b>
	 * <pre>
	 * - Since the linked list is sorted, duplicate elements will be adjacent.
	 * - Traverse the list using a pointer.
	 * - If the current node's value is equal to the next node's value:
	 *     - Skip the next node by adjusting the next pointer.
	 * - Otherwise, move to the next node.
	 * - Continue until the end of the list is reached.
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
	 * No extra space is used; duplicates are removed in-place.
	 *
	 * @param head head of the sorted singly linked list
	 * @return head of the linked list with duplicates removed
	 */
	public static Node<Integer> removeDuplicates(Node<Integer> head) {

	    // Edge case: empty list or single node
	    if (head == null || head.next == null) {
	        return head;
	    }

	    // Pointer used to traverse the list
	    Node<Integer> currentNode = head;

	    // Traverse until the end of the list
	    while (currentNode != null && currentNode.next != null) {

	        // If duplicate found, skip the next node
	        if (currentNode.data.equals(currentNode.next.data)) {
	            currentNode.next = currentNode.next.next;
	        } 
	        // Otherwise move forward
	        else {
	            currentNode = currentNode.next;
	        }
	    }

	    // Return the original head
	    return head;
	}

	/**
	 * 7. Add Element at Nth Position in Linked List
	 *
	 * <p>
	 * Description : Given the head of a singly linked list, an integer value, and
	 * an index n, insert a new node with the given value at the n-th position
	 * (0-based indexing) and return the head of the modified list.
	 * </p>
	 *
	 * <p>
	 * <pre>
	 * Example 1: Input: list = [1,2,3,4], data = 5, n = 2  Output: [1,2,5,3,4]
	 * Example 2: Input: list = [1,2,3],   data = 9, n = 0  Output: [9,1,2,3]
	 * Example 3: Input: list = [1,2],     data = 7, n = 5  Output: [1,2]
	 * Example 4: Input: list = [],        data = 1, n = 0  Output: []
	 * Example 5: Input: list = [1],       data = 8, n = 1  Output: [1,8]
	 * </pre>
	 * </p>
	 *
	 * <p>
	 * <b>Approach:</b>
	 * <pre>
	 * - If the list is empty or n is negative, return the original head.
	 * - If n == 0:
	 *     - Create a new node and point it to the current head.
	 *     - Return the new node as the head.
	 * - Traverse the list until (n-1)th position.
	 * - If traversal reaches the end before n, return the original list.
	 * - Insert the new node by adjusting pointers.
	 * </pre>
	 * </p>
	 *
	 * <b>Time Complexity:</b> O(n)
	 * <br>
	 * where n is the position at which the node is inserted.
	 *
	 * <br><br>
	 * <b>Space Complexity:</b> O(1)
	 * <br>
	 * Only one new node is created.
	 *
	 * @param head head of the singly linked list
	 * @param data value to be inserted
	 * @param n    position (0-based index)
	 * @return head of the modified linked list
	 */
	public static Node<Integer> addAtNthPosition(Node<Integer> head, Integer data, int n) {
		// Invalid index or empty list
		if (head == null || n < 0) {
			return head;
		}

		// Create the new node
		Node<Integer> newNode = new Node<>(data);

		// Insert at head position
		if (n == 0) {
			newNode.next = head;
			return newNode;
		}

		// Traverse to (n-1)th position
		Node<Integer> current = head;
		for (int index = 1; index < n; index++) {
			if (current.next == null) {
				// Position out of bounds
				return head;
			}
			current = current.next;
		}

		// Insert the node
		newNode.next = current.next;
		current.next = newNode;

		return head;
	}

	/**
	 * 6. Remove Nth Node From End of Linked List
	 *
	 * <p>
	 * <b>Description:</b>
	 * Given the head of a singly linked list, remove the nth node from the end
	 * of the list and return the head of the modified list.
	 * </p>
	 *
	 * <pre>
	 * Example 1: Input: list = [1,2,3,4,5], n = 2 → Output: [1,2,3,5]
	 * Example 2: Input: list = [1,2,3], n = 1 → Output: [1,2]
	 * Example 3: Input: list = [1,2,3], n = 3 → Output: [2,3]
	 * Example 4: Input: list = [1], n = 1 → Output: []
	 * Example 5: Input: list = [1,2], n = 5 → Output: [1,2]
	 * </pre>
	 *
	 * <p>
	 * <b>Approach:</b>
	 * <pre>
	 * - Use two pointers: fastPointer and slowPointer.
	 * - Move fastPointer n steps ahead.
	 * - If fastPointer becomes null after moving n steps,
	 *   it means the head node must be removed.
	 * - Move both pointers together until fastPointer reaches the last node.
	 * - slowPointer will then point to the node just before the one to delete.
	 * - Adjust pointers to remove the nth node from the end.
	 * </pre>
	 * </p>
	 *
	 * <b>Time Complexity:</b> O(n) — single traversal of the list  
	 * <br>
	 * <b>Space Complexity:</b> O(1) — no extra space used
	 *
	 * @param head head of the singly linked list
	 * @param n position from the end (1-based)
	 * @return head of the linked list after removal
	 */
	public static Node<Integer> removeNthNodeFromEnd(Node<Integer> head, int n) {

		// Edge case: empty list or invalid n
		if (head == null || n <= 0) {
			return head;
		}

		Node<Integer> fastPointer = head;
		Node<Integer> slowPointer = head;

		// Move fastPointer n steps ahead
		for (int i = 0; i < n; i++) {
			if (fastPointer == null) {
				// n is greater than the length of the list
				return head;
			}
			fastPointer = fastPointer.next;
		}

		// If fastPointer is null, remove the head node
		if (fastPointer == null) {
			return head.next;
		}

		// Move both pointers until fastPointer reaches the end
		while (fastPointer.next != null) {
			fastPointer = fastPointer.next;
			slowPointer = slowPointer.next;
		}

		// Delete the target node
		slowPointer.next = slowPointer.next.next;

		return head;
	}

	/**
	 * 5. Remove Element at Nth Position in Linked List
	 *
	 * <p>
	 * <b>Description:</b>
	 * Given the head of a singly linked list and an integer n (0-based index),
	 * remove the node present at the nth position and return the updated list.
	 * </p>
	 *
	 * <pre>
	 * Example 1: Input: list = [1,2,3,4,5], n = 2 → Output: [1,2,4,5]
	 * Example 2: Input: list = [10,20,30], n = 0 → Output: [20,30]
	 * Example 3: Input: list = [5,6,7], n = 5 → Output: [5,6,7]
	 * Example 4: Input: list = [1], n = 0 → Output: []
	 * Example 5: Input: list = [], n = 1 → Output: []
	 * </pre>
	 *
	 * <p>
	 * <b>Approach:</b>
	 * <pre>
	 * - Handle edge cases: empty list or invalid index.
	 * - If n == 0, remove the head node directly.
	 * - Traverse the list until the (n-1)th node.
	 * - Adjust pointers to skip the nth node.
	 * - If n exceeds list length, return the original list.
	 * </pre>
	 * </p>
	 *
	 * <b>Time Complexity:</b> O(n) — traversal up to nth node  
	 * <br>
	 * <b>Space Complexity:</b> O(1) — constant extra space
	 *
	 * @param n zero-based index of the node to remove
	 * @param head head of the singly linked list
	 * @return head of the list after removing the nth node
	 */
	public static Node<Integer> removeElementAtNthPosition(Integer n, Node<Integer> head) {
		// Edge case: empty list or invalid index
		if (head == null || n < 0) {
			return head;
		}

		// If the head node itself must be removed
		if (n == 0) {
			return head.next;
		}

		Node<Integer> currentNode = head;

		// Traverse to the (n-1)th node
		for (int index = 1; index < n; index++) {
			if (currentNode.next == null) {
				// Index exceeds list length
				return head;
			}
			currentNode = currentNode.next;
		}

		// If nth node exists, remove it
		if (currentNode.next != null) {
			currentNode.next = currentNode.next.next;
		}

		return head;
	}

	/**
	 * 4. Find Middle Element of a Singly Linked List
	 *
	 * <p>
	 * <b>Description:</b>
	 * Given the head of a singly linked list, return the value of the middle node.
	 * If the list contains an even number of nodes, the second middle element is returned.
	 * </p>
	 *
	 * <pre>
	 * Example 1: Input: list = ["A","B","C","D","E"] → Output: "C"
	 * Example 2: Input: list = ["1","2","3","4"] → Output: "3"
	 * Example 3: Input: list = ["X"] → Output: "X"
	 * Example 4: Input: list = [] → Output: null
	 * </pre>
	 *
	 * <p>
	 * <b>Approach:</b>
	 * <pre>
	 * - Use two pointers:
	 *     - slowPointer moves one step at a time
	 *     - fastPointer moves two steps at a time
	 * - When fastPointer reaches the end of the list,
	 *   slowPointer will be positioned at the middle node.
	 * - For even-length lists, this naturally returns the second middle element.
	 * </pre>
	 * </p>
	 *
	 * <b>Time Complexity:</b> O(n)
	 * <br>
	 * <b>Space Complexity:</b> O(1)
	 *
	 * @param head head of the singly linked list
	 * @return value of the middle node, or null if the list is empty
	 */
	public static Integer findMidElement(Node<Integer> head) {
		// Edge case: empty list
		if (head == null) {
			return null;
		}

		Node<Integer> slowPointer = head;
		Node<Integer> fastPointer = head;

		// Move slow by 1 step and fast by 2 steps
		while (fastPointer != null && fastPointer.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
		}

		// slowPointer now points to the middle node
		return slowPointer.data;
	}

	/**
	 * 3. Reverse a Singly Linked List (Recursive)
	 *
	 * <p>
	 * <b>Description:</b>
	 * Given the head of a singly linked list, reverse the list and return
	 * the new head.
	 * </p>
	 *
	 * <pre>
	 * Example 1: Input: list = [1,2,3,4,5] Output: [5,4,3,2,1]
	 * Example 2: Input: list = [10,20] Output: [20,10]
	 * Example 3: Input: list = [1] Output: [1]
	 * Example 4: Input: list = [] Output: []
	 * </pre>
	 *
	 * <p>
	 * <b>Approach (Recursive):</b>
	 * <pre>
	 * - Base Case:
	 *     - If the list is empty or contains only one node, return head.
	 * - Recursive Case:
	 *     - Reverse the remaining list starting from head.next.
	 *     - Make head.next.next point back to head.
	 *     - Set head.next to null to avoid cycle.
	 * - Return the new head obtained from recursion.
	 * </pre>
	 * </p>
	 *
	 * <b>Time Complexity:</b> O(n)
	 * <br>
	 * <b>Space Complexity:</b> O(n)
	 * <br>
	 * Space is used due to recursive call stack.
	 *
	 * @param head head of the singly linked list
	 * @return head of the reversed linked list
	 */
	public static Node<Integer> reverseSingleLinkedList(Node<Integer> head) {
		// Base case: empty list or single node list
		if (head == null || head.next == null) {
			return head;
		}

		// Recursively reverse the remaining list
		Node<Integer> reversedHead = reverseSingleLinkedList(head.next);

		// Reverse the current node's link
		head.next.next = head;

		// Set current node's next to null to avoid cycle
		head.next = null;

		// Return the new head of the reversed list
		return reversedHead;
	}

	/**
	 * 2. Add Elements at the Start of Head Node
	 *
	 * <p>
	 * <b>Description:</b>
	 * Given a list of values, create a singly linked list by inserting
	 * each element at the beginning (head) of the linked list.
	 * </p>
	 *
	 * <pre>
	 * Example 1: Input: data = ["A","B","C"] Output: ["C","B","A"]
	 * Example 2: Input: data = ["1","2"] Output: ["2","1"]
	 * Example 3: Input: data = ["X"] Output: ["X"]
	 * Example 4: Input: data = [] Output: []
	 * Example 5: Input: data = null Output: null
	 * </pre>
	 *
	 * <p>
	 * <b>Approach:</b>
	 * <pre>
	 * - Initialize head as null.
	 * - Iterate through each element in the input list.
	 * - For every element:
	 *     - Create a new node.
	 *     - Point new node's next to current head.
	 *     - Move head to the new node.
	 * - Return head after processing all elements.
	 * </pre>
	 * </p>
	 *
	 * <b>Time Complexity:</b> O(n)
	 * <br>
	 * <b>Space Complexity:</b> O(n)
	 *
	 * @param values list of values to be added at the start of the linked list
	 * @return head of the constructed linked list
	 */
	public static <T> Node<T> addAtStartOfHeadNode(List<T> values) { 
		// Edge case: null input list
		if (values == null || values.isEmpty()) {
			return null;
		}

		Node<T> headNode = null;

		// Insert each value at the beginning of the list
		for (int i = 0; i < values.size(); i++) {

			// Create a new node for the current value
			Node<T> newNode = new Node<>(values.get(i));

			// Point new node to the existing head
			newNode.next = headNode;

			// Update head to the new node
			headNode = newNode;
		}

		return headNode;
	}

	/**
	 * 1. Add Elements at the End of Head Node
	 *
	 * <p>
	 * <b>Description:</b>
	 * Given a list of integers, create a singly linked list by appending
	 * each element at the end (tail) of the linked list.
	 * </p>
	 *
	 * <pre>
	 * Example 1: Input: data = [1,2,3] Output: [1,2,3]
	 * Example 2: Input: data = [5] Output: [5]
	 * Example 3: Input: data = [] Output: []
	 * Example 4: Input: data = null Output: null
	 * Example 5: Input: data = [10,20,30,40] Output: [10,20,30,40]
	 * </pre>
	 *
	 * <p>
	 * <b>Approach:</b>
	 * <pre>
	 * - If input list is null or empty, return null.
	 * - Initialize head as null.
	 * - For each element in the list:
	 *     - Create a new node.
	 *     - If head is null, assign new node as head.
	 *     - Otherwise, traverse to the last node and append the new node.
	 * - Return the head of the constructed linked list.
	 * </pre>
	 * </p>
	 *
	 * <b>Time Complexity:</b> O(n²)
	 * <br>
	 * Traversing the list for each insertion.
	 *
	 * <br><br>
	 * <b>Space Complexity:</b> O(n)
	 *
	 * @param values list of integers to be added at the end of the linked list
	 * @return head of the linked list
	 */
	public static <T> Node<T> addAtEndOfHeadNode(List<T> values) {

		// Edge case: null or empty input list
		if (values == null || values.isEmpty()) {
			return null;
		}

		Node<T> headNode = null;

		// Iterate through input values
		for (int i = 0; i < values.size(); i++) {

			// Create a new node for current value
			Node<T> newNode = new Node<>(values.get(i));

			// If list is empty, assign new node as head
			if (headNode == null) {
				headNode = newNode;
			} else {
				// Traverse to the last node
				Node<T> currentNode = headNode;
				while (currentNode.next != null) {
					currentNode = currentNode.next;
				}
				// Append new node at the end
				currentNode.next = newNode;
			}
		}

		return headNode;
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
	
	public Node(T data, Node<T> next) {
		super();
		this.data = data;
		this.next = next;
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
