package linkedlist;

import static linkedlist.SingleLinkedList.addAtEndOfHeadNode;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
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

}
