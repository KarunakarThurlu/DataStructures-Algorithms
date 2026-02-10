package linkedlist;

import static linkedlist.SingleLinkedList.addAtEndOfHeadNode;
import static linkedlist.SingleLinkedList.addAtStartOfHeadNode;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestSingleLinkedList {

	@ParameterizedTest
	@MethodSource("deleteNodeProvider")
	@DisplayName("Test deleteNode method")
	void testDeleteNode(Node<Integer> head, Integer data, Node<Integer> expected) {
		Node<Integer> actual = SingleLinkedList.deleteNode(head, data);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> deleteNodeProvider() {
		return Stream.of(
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(1, 2, 3, 4, 5)), 3,addAtEndOfHeadNode(Arrays.asList(1, 2, 4, 5))),
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(1, 2, 3, 4, 5)), 1,addAtEndOfHeadNode(Arrays.asList(2, 3, 4, 5))),
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(1, 2, 3, 4, 5)), 5,addAtEndOfHeadNode(Arrays.asList(1, 2, 3, 4))),
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(1)), 1, null),
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(1, 2, 3, 4, 5, 5)), 5,addAtEndOfHeadNode(Arrays.asList(1, 2, 3, 4, 5)))
			);
	}
	
	@ParameterizedTest
	@MethodSource("deleteNodesProvider")
	@DisplayName("Test deleteNode method")
	void testDeleteNodes(Node<Integer> head, Integer[] data, Node<Integer> expected) {
		Node<Integer> actual = SingleLinkedList.deleteNodes(head, data);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> deleteNodesProvider() {
		return Stream.of(
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(1, 2, 3, 4, 5)), new Integer[] { 2, 3 },addAtEndOfHeadNode(Arrays.asList(1, 4, 5))),
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(1, 2, 3, 4, 5)), new Integer[] { 1, 5 },addAtEndOfHeadNode(Arrays.asList(2, 3, 4))),
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(1, 2, 3, 4, 5)), new Integer[] { 1, 2, 3 }, addAtEndOfHeadNode(Arrays.asList(4, 5))),
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(1)), new Integer[] { 1 }, null),
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(1, 2, 3, 4, 5, 5)), new Integer[] { 4, 5, 5 }, addAtEndOfHeadNode(Arrays.asList(1, 2, 3)))
			);
	}
	
	@ParameterizedTest
	@MethodSource("mergeSortedListsProvider")
	@DisplayName("Test merge sorted lists")
	void testMergeSortedLists(Node<Integer> headOne,Node<Integer> headTwo, Node<Integer> expected) {
		Node<Integer> actual = SingleLinkedList.mergeSortedLists(headOne, headTwo);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> mergeSortedListsProvider() {
		return Stream.of(
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(1, 2, 4, 5)), addAtEndOfHeadNode(Arrays.asList(3,6,7,8)),addAtEndOfHeadNode(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8))),
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(8, 12)), addAtEndOfHeadNode(Arrays.asList(23, 25)),addAtEndOfHeadNode(Arrays.asList(8,12,23,25))),
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(10)), addAtEndOfHeadNode(Arrays.asList(100)), addAtEndOfHeadNode(Arrays.asList(10, 100))),
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(1,101,1001)), null, addAtEndOfHeadNode(Arrays.asList(1, 101,1001))),
				Arguments.of(null, null, null),
				Arguments.of(null, addAtEndOfHeadNode(Arrays.asList(9,99,999)),  addAtEndOfHeadNode(Arrays.asList(9,99,999)))
			);
	}
	
	@ParameterizedTest
	@MethodSource("removeDuplicateNodesProvider")
	@DisplayName("Test remove duplicates from sorted linkedlist method")
	void testRemoveDuplicateNodes(Node<Integer> head, Node<Integer> expected) {
		Node<Integer> actual = SingleLinkedList.removeDuplicates(head);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> removeDuplicateNodesProvider() {
		return Stream.of(
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(1, 1, 2, 3, 4, 5, 5)), addAtEndOfHeadNode(Arrays.asList(1, 2, 3, 4, 5))),
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(1, 2, 3, 3, 4, 5)), addAtEndOfHeadNode(Arrays.asList(1, 2, 3, 4, 5))),
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(1, 2, 3, 4, 4, 5)), addAtEndOfHeadNode(Arrays.asList(1, 2, 3, 4, 5))),
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(1, 1, 1, 1, 1)),  addAtEndOfHeadNode(Arrays.asList(1))),
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(1, 2, 3, 4, 5)), addAtEndOfHeadNode(Arrays.asList(1, 2, 3, 4, 5))),
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(1)), addAtEndOfHeadNode(Arrays.asList(1))),
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(1,1)), addAtEndOfHeadNode(Arrays.asList(1))),
				Arguments.of(addAtEndOfHeadNode(null), addAtEndOfHeadNode(null))
			);
	}
	
	@ParameterizedTest
	@MethodSource("provideAddAtNthPositionTestCases")
	@DisplayName("Test Add Element at Nth Position in Linked List")
	void testAddAtNthPosition(Node<Integer> head, Integer val, int index, Node<Integer> expected) {
	    Node<Integer> actual = SingleLinkedList.addAtNthPosition(head, val, index);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> provideAddAtNthPositionTestCases() {
		return Stream.of(
				// insert in middle
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(1, 2, 3, 4)), 5, 2, addAtEndOfHeadNode(Arrays.asList(1, 2, 5, 3, 4))),

				// insert at head
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(1, 2, 3)), 9, 0, addAtEndOfHeadNode(Arrays.asList(9, 1, 2, 3))),

				// insert at end
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(1, 2)), 8, 2, addAtEndOfHeadNode(Arrays.asList(1, 2, 8))),

				// position out of bounds (no change)
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(1, 2)), 7, 5, addAtEndOfHeadNode(Arrays.asList(1, 2))),

				// single element list
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(1)), 6, 1, addAtEndOfHeadNode(Arrays.asList(1, 6))),

				// null list
				Arguments.of(addAtEndOfHeadNode(null), 10, 0, addAtEndOfHeadNode(null))
			);
	}
	
	@ParameterizedTest
	@MethodSource("removeNthNodeFromEndProvider")
	@DisplayName("Test Remove Nth Node From End")
	void testRemoveNthNodeFromEnd(Node<Integer> head, int n, Node<Integer> expected) {
		Node<Integer> actual = SingleLinkedList.removeNthNodeFromEnd(head, n);
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> removeNthNodeFromEndProvider() {
		return Stream.of(
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(1, 2, 3, 4, 5)), 2, addAtEndOfHeadNode(Arrays.asList(1, 2, 3, 5))),
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(1, 2, 3)), 1, addAtEndOfHeadNode(Arrays.asList(1, 2))),
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(1, 2, 3)), 3, addAtEndOfHeadNode(Arrays.asList(2, 3))),
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(1)), 1, addAtEndOfHeadNode(null)),
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(1, 2)), 5, addAtEndOfHeadNode(Arrays.asList(1, 2))),
				Arguments.of(addAtEndOfHeadNode(null), 1, addAtEndOfHeadNode(null))
			);
	}
	
	@ParameterizedTest
	@MethodSource("removeElementAtNthPositionProvider")
	@DisplayName("Test Remove Element At Nth Position")
	void testRemoveElementAtNthPosition(Node<Integer> head, int n, Node<Integer> expected) {
		Node<Integer> actual = SingleLinkedList.removeElementAtNthPosition(n, head);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> removeElementAtNthPositionProvider() {
		return Stream.of(
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(1, 2, 3, 4, 5)), 2, addAtEndOfHeadNode(Arrays.asList(1, 2, 4, 5))),
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(10, 20, 30)), 0, addAtEndOfHeadNode(Arrays.asList(20, 30))),
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(5, 6, 7)), 5, addAtEndOfHeadNode(Arrays.asList(5, 6, 7))),
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(1)), 0, addAtEndOfHeadNode(null)),
				Arguments.of(addAtEndOfHeadNode(null), 1, addAtEndOfHeadNode(null))
			);
	}
	@ParameterizedTest
	@MethodSource("findMiddleElementProvider")
	@DisplayName("Test Find Middle Element of Linked List")
	void testFindMiddleElement(Node<Integer> head, Integer expected) {
		Integer actual = SingleLinkedList.findMidElement(head);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> findMiddleElementProvider() {
		return Stream.of(Arguments.of(addAtEndOfHeadNode(Arrays.asList(1,2,3,4,5,6,7)), 4),
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(1,2,3,4,5,6)), 4),
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(1)), 1),
				Arguments.of(addAtEndOfHeadNode(null), null)
			);
	}
	
	@ParameterizedTest
	@MethodSource("reverseSingleLinkedListProvider")
	@DisplayName("Test Reverse Singly Linked List")
	void testReverseSingleLinkedList(Node<Integer> input, Node<Integer> expected) {
		Node<Integer> actual = SingleLinkedList.reverseSingleLinkedList(input);
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> reverseSingleLinkedListProvider() {
		return Stream.of(
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(1, 2, 3, 4, 5)), addAtEndOfHeadNode(Arrays.asList(5, 4, 3, 2, 1))),
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(10, 20, 20)), addAtEndOfHeadNode(Arrays.asList(20, 20, 10))),
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(1, 1)), addAtEndOfHeadNode(Arrays.asList(1, 1))),
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(9)), addAtEndOfHeadNode(Arrays.asList(9))),
				Arguments.of(addAtEndOfHeadNode(null), addAtEndOfHeadNode(null))
			);
	}
	@ParameterizedTest
	@MethodSource("addAtStartOfHeadNodeProvider")
	@DisplayName("Test Add Elements at Start of Head Node")
	void testAddAtStartOfHeadNode(List<?> values, Node<?> expected) {
		Node<?> actual = addAtStartOfHeadNode(values);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> addAtStartOfHeadNodeProvider() {
		return Stream.of(
				Arguments.of(Arrays.asList(1, 2, 3), addAtEndOfHeadNode(Arrays.asList(3, 2, 1))),
				Arguments.of(Arrays.asList(1, 2), addAtEndOfHeadNode(Arrays.asList(2, 1))),
				Arguments.of(Arrays.asList(1), addAtEndOfHeadNode(Arrays.asList(1))),
				Arguments.of(Collections.emptyList(), addAtEndOfHeadNode(Collections.emptyList())),
				Arguments.of(null, addAtEndOfHeadNode(null))
			);
	}
	@ParameterizedTest
	@MethodSource("addAtEndOfHeadNodeProvider")
	@DisplayName("Test Add Elements at End of Head Node")
	void testAddAtEndOfHeadNode(List<?> values, Node<?> expected) {
		Node<?> actual = addAtEndOfHeadNode(values);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> addAtEndOfHeadNodeProvider() {
		return Stream.of(
				Arguments.of(Arrays.asList(1, 2, 3), addAtStartOfHeadNode(Arrays.asList(3, 2, 1))),
				Arguments.of(Arrays.asList('A'), addAtStartOfHeadNode(Arrays.asList('A'))),
				Arguments.of(Arrays.asList("foo", "bar", "baz", "jaz"), addAtStartOfHeadNode(Arrays.asList("jaz", "baz", "bar", "foo"))),
				Arguments.of(List.of(), addAtStartOfHeadNode(Collections.emptyList())),
				Arguments.of(List.of(), addAtStartOfHeadNode(null))
			);
	}
	
	@ParameterizedTest
	@MethodSource("swapNodesInPairProvider")
	@DisplayName("Test reverse nodes in pair")
	void testReverseNodesInPair(Node<Integer> input, Node<Integer> expected) {
		Node<Integer> actual = SingleLinkedList.swapNodesInPair(input);
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> swapNodesInPairProvider() {
		return Stream.of(
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(1, 2, 3, 4, 5)), addAtEndOfHeadNode(Arrays.asList(2,1,4,3,5))),
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(10, 20, 20)), addAtEndOfHeadNode(Arrays.asList(20, 10, 20))),
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(1, 1)), addAtEndOfHeadNode(Arrays.asList(1, 1))),
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(10, 11, 12, 13, 14, 15)), addAtEndOfHeadNode(Arrays.asList(11, 10, 13, 12, 15, 14))),
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(9)), addAtEndOfHeadNode(Arrays.asList(9))),
				Arguments.of(addAtEndOfHeadNode(null), addAtEndOfHeadNode(null))
			);
	}
	
	
	@ParameterizedTest
	@MethodSource("mergeKSortedListsProvider")
	@DisplayName("Test reverse nodes in pair")
	void testMergeSortedLists(List<Node<Integer>> input, Node<Integer> expected) {
		Node<Integer> actual = SingleLinkedList.mergeSortedLists(input);
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> mergeKSortedListsProvider() {
		return Stream.of(
				Arguments.of(List.of(addAtEndOfHeadNode(Arrays.asList(10, 20, 20)),
						addAtEndOfHeadNode(Arrays.asList(5, 10, 15, 20, 25)),
						addAtEndOfHeadNode(Arrays.asList(25, 30, 35))),
						addAtEndOfHeadNode(Arrays.asList(5, 10, 10, 15, 20, 20, 20, 25, 25, 30, 35))), 
				
				Arguments.of(List.of(addAtEndOfHeadNode(Arrays.asList(10, 20, 20))),
						addAtEndOfHeadNode(Arrays.asList(10, 20, 20))),
						
				Arguments.of(List.of(addAtEndOfHeadNode(Arrays.asList(10, 20, 20)),
						addAtEndOfHeadNode(Arrays.asList(25, 30, 35))),
						addAtEndOfHeadNode(Arrays.asList(10, 20,20, 25, 30, 35)))
			);
	}
	
	@ParameterizedTest
	@MethodSource("rotateLinkedListProvider")
	@DisplayName("Test rotate linked list")
	void testRotateLinkedList(Node<Integer> input,int k, Node<Integer> expected) {
		Node<Integer> actual = SingleLinkedList.rotateLinkedList(input,k);
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> rotateLinkedListProvider() {
		return Stream.of(
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(1, 2, 3, 4, 5)),2, addAtEndOfHeadNode(Arrays.asList(4,5,1,2,3))),
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(10, 20, 20)),1, addAtEndOfHeadNode(Arrays.asList(20, 10, 20))),
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(1, 1)),0, addAtEndOfHeadNode(Arrays.asList(1, 1))),
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(10, 11, 12, 13, 14, 15)),1, addAtEndOfHeadNode(Arrays.asList(15, 10, 11, 12, 13, 14))),
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(9)),0, addAtEndOfHeadNode(Arrays.asList(9))),
				Arguments.of(addAtEndOfHeadNode(null),100, addAtEndOfHeadNode(null))
			);
	}
	
	@ParameterizedTest
	@MethodSource("partitionLinkedListProvider")
	@DisplayName("Test partition linked list")
	void testPartitionLinkedList(Node<Integer> input, int k, Node<Integer> expected) {
		Node<Integer> actual = SingleLinkedList.partitionLinkedList(input, k);
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> partitionLinkedListProvider() {
		return Stream.of(
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(1, 4, 3, 2, 5, 2)), 3, addAtEndOfHeadNode(Arrays.asList(1, 2, 2, 4, 3, 5))),
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(10, 20, 25)), 35, addAtEndOfHeadNode(Arrays.asList(10, 20, 25))),
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(2, 1)), 2, addAtEndOfHeadNode(Arrays.asList(1, 2))),
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(9, 9, 9, 9, 9)), 9, addAtEndOfHeadNode(Arrays.asList(9, 9, 9, 9, 9))),
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(100)), 100, addAtEndOfHeadNode(Arrays.asList(100))),
				Arguments.of(addAtEndOfHeadNode(null), 100, addAtEndOfHeadNode(null))
			);
	}
	
	@ParameterizedTest
	@MethodSource("remoreDuplicatesLinkedListProvider")
	@DisplayName("Test removed uplicates II linked list")
	void testRemoveDuplicatesLinkedListII(Node<Integer> input,Node<Integer> expected) {
		Node<Integer> actual = SingleLinkedList.removeDuplicatesII(input);
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> remoreDuplicatesLinkedListProvider() {
		return Stream.of(
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(1, 4, 3, 3, 2, 5)), addAtEndOfHeadNode(Arrays.asList(1, 4, 2, 5))),
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(1, 1, 1, 2, 3, 4)), addAtEndOfHeadNode(Arrays.asList(2, 3, 4))),
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(2, 2)), addAtEndOfHeadNode(null)),
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(6, 7, 8, 9, 9)), addAtEndOfHeadNode(Arrays.asList(6, 7, 8))),
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(100)), addAtEndOfHeadNode(Arrays.asList(100))),
				Arguments.of(addAtEndOfHeadNode(null), addAtEndOfHeadNode(null))
			);
	}
	
	@ParameterizedTest
	@MethodSource("detectCycleProvider")
	@DisplayName("Test detect cycle in linked list")
	void testDetectCycle(Node<Integer> head, boolean expected) {
		boolean actual = SingleLinkedList.detectCycyle(head);
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> detectCycleProvider() {
		Node<Integer> headWithCycle = addAtEndOfHeadNode(Arrays.asList(1, 2));
		headWithCycle.next.next = headWithCycle.next; // create a cycle

		return Stream.of(
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(1, 2, 3, 4, 5)), false),
				Arguments.of(headWithCycle, true),
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(10)), false),
				Arguments.of(addAtEndOfHeadNode(null), false)
			);
	}
	
	@ParameterizedTest
	@MethodSource("reorderLinkedListProvider")
	@DisplayName("Test reorder linked list")
	void testReOrderLinkedList(Node<?> head, Node<?> expected) {
		Node<?> actual = SingleLinkedList.reorderLinkedList(head);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> reorderLinkedListProvider() {
		return Stream.of(
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(1, 2, 3, 4, 5, 6)), addAtEndOfHeadNode(Arrays.asList(1, 6, 2, 5, 3, 4))),
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(1, 2, 3, 4, 5)), addAtEndOfHeadNode(Arrays.asList(1, 5, 2, 4, 3))),
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(1, 2, 3, 4)), addAtEndOfHeadNode(Arrays.asList(1, 4, 2, 3)))
			);
	}
	
	@ParameterizedTest
	@MethodSource("sortLinkedListProvider")
	@DisplayName("Test sort linked list")
	void testSortLinkedList(Node<Integer> head, Node<Integer> expected) {
		Node<Integer> actual = SingleLinkedList.sortLinkedList(head);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> sortLinkedListProvider() {
		return Stream.of(
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(1, 3, 4, 5, 6, 2, 7)), addAtEndOfHeadNode(Arrays.asList(1, 2, 3, 4, 5, 6, 7))),
				Arguments.of(addAtEndOfHeadNode(Arrays.asList( 4, 5, 1, 2, 3)), addAtEndOfHeadNode(Arrays.asList(1, 2, 3, 4, 5))),
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(1)), addAtEndOfHeadNode(Arrays.asList(1))),
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(2,1)), addAtEndOfHeadNode(Arrays.asList(1,2)))
			);
	}

}
