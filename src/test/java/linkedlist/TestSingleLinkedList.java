package linkedlist;

import static linkedlist.SingleLinkedList.addAtEndOfHeadNode;
import static linkedlist.SingleLinkedList.addAtStartOfHeadNode;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
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
	void testAddAtStartOfHeadNode(Node<String> actual, Node<String> expected) {
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> addAtStartOfHeadNodeProvider() {
		return Stream.of(
				Arguments.of(addAtStartOfHeadNode(Arrays.asList(1, 2, 3)), addAtEndOfHeadNode(Arrays.asList(3, 2, 1))),
				Arguments.of(addAtStartOfHeadNode(Arrays.asList(1, 2)), addAtEndOfHeadNode(Arrays.asList(2, 1))),
				Arguments.of(addAtStartOfHeadNode(Arrays.asList(1)), addAtEndOfHeadNode(Arrays.asList(1))),
				Arguments.of(addAtStartOfHeadNode(Collections.emptyList()), addAtEndOfHeadNode(Collections.emptyList())),
				Arguments.of(addAtStartOfHeadNode(null), addAtEndOfHeadNode(null))
			);
	}
	@ParameterizedTest
	@MethodSource("addAtEndOfHeadNodeProvider")
	@DisplayName("Test Add Elements at End of Head Node")
	void testAddAtEndOfHeadNode(Node<Integer> actual, Node<Integer> expected) {
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> addAtEndOfHeadNodeProvider() {
		return Stream.of(
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(1, 2, 3)), addAtEndOfHeadNode(Arrays.asList(1, 2, 3))),
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(5)), addAtEndOfHeadNode(Arrays.asList(5))),
				Arguments.of(addAtEndOfHeadNode(Arrays.asList(10, 20, 30, 40)), addAtEndOfHeadNode(Arrays.asList(10, 20, 30, 40))),
				Arguments.of(addAtEndOfHeadNode(Collections.emptyList()), addAtEndOfHeadNode(Collections.emptyList())),
				Arguments.of(addAtEndOfHeadNode(null), addAtEndOfHeadNode(null))
			);
	}

}
