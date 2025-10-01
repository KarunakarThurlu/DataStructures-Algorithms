package sorting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestSortingProblems {
	
	@ParameterizedTest
	@MethodSource("provideBubbleSortTestcases")
	@DisplayName("Test Bubble Sort")
	void testBubbleSort(Integer[] input, Integer[] expected) {
		Integer[] actual = SortingProblems.bubbleSort(input);
		assertArrayEquals(expected, actual);
	}
	
	private static Stream<Arguments> provideBubbleSortTestcases(){
		return Stream.of(Arguments.of(new Integer[] {3,2,5},new Integer[] {2,3,5}),
				Arguments.of(new Integer[] {1,2,3},new Integer[] {1,2,3}),
				Arguments.of(new Integer[] {9,-9},new Integer[] {-9,9}),
				Arguments.of(new Integer[] {},new Integer[] {}));
	}
	
	@ParameterizedTest
	@MethodSource("provideQuickSortTestcases")
	@DisplayName("Test Quick Sort")
	void testQuickSort(Integer[] input, Integer[] expected) {
		Integer[] actual = SortingProblems.quickSort(input,0,input.length-1);
		assertArrayEquals(expected, actual);
	}
	
	private static Stream<Arguments> provideQuickSortTestcases(){
		return Stream.of(Arguments.of(new Integer[] {3,2,5},new Integer[] {2,3,5}),
				Arguments.of(new Integer[] {1,2,3},new Integer[] {1,2,3}),
				Arguments.of(new Integer[] {9,-9},new Integer[] {-9,9}),
				Arguments.of(new Integer[] {},new Integer[] {}));
	}
	
	@ParameterizedTest
	@MethodSource("provideMergeSortTestcases")
	@DisplayName("Test Merge Sort")
	void testMergeSort(Integer[] input, Integer[] expected) {
		Integer[] actual = SortingProblems.mergeSort(input);
		assertArrayEquals(expected, actual);
	}
	
	private static Stream<Arguments> provideMergeSortTestcases(){
		return Stream.of(Arguments.of(new Integer[] {3,2,5},new Integer[] {2,3,5}),
				Arguments.of(new Integer[] {1,2,3},new Integer[] {1,2,3}),
				Arguments.of(new Integer[] {9,-9},new Integer[] {-9,9}),
				Arguments.of(new Integer[] {},new Integer[] {}));
	}
	
	@ParameterizedTest
	@MethodSource("provideSelectionSortTestcases")
	@DisplayName("Test Selection Sort")
	void testSelectionSort(Integer[] input, Integer[] expected) {
		if (input == null) {
			assertThrows(IllegalArgumentException.class, () -> SortingProblems.selectionSort(input));
		} else {
			Integer[] actual = SortingProblems.selectionSort(input);
			assertArrayEquals(expected, actual);
		}
	}
	
	private static Stream<Arguments> provideSelectionSortTestcases() {
		return Stream.of(Arguments.of(new Integer[] { 3, 2, 5 }, new Integer[] { 2, 3, 5 }),
				Arguments.of(new Integer[] { 1, 2, 3 }, new Integer[] { 1, 2, 3 }),
				Arguments.of(new Integer[] { 9, -9 }, new Integer[] { -9, 9 }),
				Arguments.of(new Integer[] { 1, 6, 2, 5, 4, 7, 3, 8, 5, 9 }, new Integer[] { 1, 2, 3, 4, 5, 5, 6, 7, 8, 9 }),
				Arguments.of(new Integer[] {}, new Integer[] {}),
				Arguments.of(null, null));
	}
	
}
