package array;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ArrayTest {

	@ParameterizedTest
	@MethodSource("provideTwoSumTestCases")
	@DisplayName("Two Sum Problem Test Cases")
	void testTwo(int[] input, int target, int[] expected) {
		int[] actual = Array.twoSum(input, target);
		assertArrayEquals(expected, actual, "Expected and Actual Arrays should be equal");
	}

	private static Stream<Arguments> provideTwoSumTestCases() {
		return Stream.of(
				Arguments.of(new int[] { 2, 7, 11, 15 }, 9, new int[] { 0, 1 }),
				Arguments.of(new int[] { 3, 2, 4, 6 }, 6, new int[] { 1, 2 }),
				Arguments.of(new int[] { -3, 4, 3, 90 }, 0, new int[] { 0, 2 }),
				Arguments.of(new int[] { 3, 3 }, 6, new int[] { 0, 1 }),
				Arguments.of(new int[] { 1, 2, 3 }, 7, new int[] { -1, -1 })
			);
	}
	
	@ParameterizedTest
	@MethodSource("provideTwoSumIITestCases")
	@DisplayName("Two Sum II Problem Test Cases")
	void testTwoII(int[] input, int target, int[] expected) {
		int[] actual = Array.twoSumII(input, target);
		assertArrayEquals(expected, actual, "Expected and Actual Arrays should be equal");
	}

	private static Stream<Arguments> provideTwoSumIITestCases() {
		return Stream.of(
				Arguments.of(new int[] { 2, 7, 11, 15 }, 13, new int[] { 0, 2 }),
				Arguments.of(new int[] { 3, 6, 9, 16 }, 22, new int[] { 1, 3 }),
				Arguments.of(new int[] { -3, -1, 3, 90 }, 0, new int[] { 0, 2 }),
				Arguments.of(new int[] { 3, 3, 3, 3, 3 }, 6, new int[] { 0, 4 }),
				Arguments.of(new int[] { 0, 2, 7 }, 7, new int[] { 0, 2 }),
				Arguments.of(new int[] { 0, 2, 6 }, 7, new int[] { -1, -1 }),
				Arguments.of(new int[] { 7 }, 7, new int[] { -1, -1 })
			);
	}
	
	@ParameterizedTest
	@MethodSource("provideMergeSortedArraysTestCases")
	@DisplayName("Merge Sorted Arrays Test Cases")
	void testMergeSortedArrays(int[] arrayOne, int[] arrayTwo, int[] expected) {
		int[] actual = Array.mergeSortedArrays(arrayOne, arrayTwo);
		assertArrayEquals(expected, actual, "Expected and Actual Arrays should be equal");
	}

	private static Stream<Arguments> provideMergeSortedArraysTestCases() {
		return Stream.of(
				Arguments.of(new int[] { 2, 7, 11},new int[] {3,5}, new int[] { 2, 3, 5, 7, 11}),
				Arguments.of(new int[] { 3, 6}, new int[] {-3}, new int[] { -3, 3, 6 }),
				Arguments.of(new int[] { -3, -1 },new int[]{ 0 }, new int[] { -3, -1, 0}),
				Arguments.of(new int[] { 3, 3, 3}, new int[] {3}, new int[] { 3, 3, 3, 3}),
				Arguments.of(new int[] { 0, 2, 7 }, new int[] {}, new int[] { 0, 2, 7 }),
				Arguments.of(new int[] { 7 }, new int[] {8}, new int[] { 7, 8}),
				Arguments.of(new int[] { }, new int[] {}, new int[] { })
			);
	}
	
	@ParameterizedTest
	@MethodSource("provideMoveZerosToStartingTestCases")
	@DisplayName("Moving Zero's to starting of the Array Test Cases")
	void testMoveZerosToStarting(int[] array, int[] expected) {
		int[] actual = Array.moveZerosToStarting(array);
		assertArrayEquals(expected, actual, "Expected and Actual Arrays should be equal");
	}

	private static Stream<Arguments> provideMoveZerosToStartingTestCases() {
		return Stream.of(
				Arguments.of(new int[] { 2, 7, 0, 0, 11, 0}, new int[] {0, 0, 0, 2, 7, 11}),
				Arguments.of(new int[] { 3, 6, 0}, new int[] {0, 3, 6}),
				Arguments.of(new int[] { -3, 0, -1 }, new int[]{0, -3, -1}),
				Arguments.of(new int[] { 0, 0, 0}, new int[] {0, 0, 0}),
				Arguments.of(new int[] { 0, 2, 7 }, new int[] {0, 2, 7}),
				Arguments.of(new int[] { 7 }, new int[] {7}),
				Arguments.of(new int[] { }, new int[] {})
			);
	}
	
	@ParameterizedTest
	@MethodSource("provideSortArrayTestCases")
	@DisplayName("Sorting Array Test Cases")
	void testSortArray(int[] array, int[] expected) {
		int[] actual = Array.sortArray(array);
		assertArrayEquals(expected, actual, "Expected and Actual Arrays should be equal");
	}

	private static Stream<Arguments> provideSortArrayTestCases() {
		return Stream.of(
				Arguments.of(new int[] { 2, 7, 0, 0, 11}, new int[] {0, 0, 2, 7, 11}),
				Arguments.of(new int[] { 3, 6, 0}, new int[] {0, 3, 6}),
				Arguments.of(new int[] { -3, 0, -1 }, new int[]{-3, -1, 0}),
				Arguments.of(new int[] { 0, 0, 0}, new int[] {0, 0, 0}),
				Arguments.of(new int[] { 0, 2, 7 }, new int[] {0, 2, 7}),
				Arguments.of(new int[] { 1, 2, 8, 9 }, new int[] {1, 2, 8, 9}),
				Arguments.of(new int[] { 7 }, new int[] {7}),
				Arguments.of(new int[] { }, new int[] {})
			);
	}
	
	@ParameterizedTest
	@MethodSource("provideReverseArrayTestCases")
	@DisplayName("Reverse Array Test Cases")
	void testReverseArray(int[] array, int[] expected) {
		int[] actual = Array.reverseArray(array);
		assertArrayEquals(expected, actual, "Expected and Actual Arrays should be equal");
	}

	private static Stream<Arguments> provideReverseArrayTestCases() {
		return Stream.of(
				Arguments.of(new int[] { 2, 7, 8, 0, 11}, new int[] {11, 0, 8, 7, 2}),
				Arguments.of(new int[] { 3, 6, 0}, new int[] {0, 6, 3}),
				Arguments.of(new int[] { -3, 0, -1 }, new int[]{-1, 0, -3}),
				Arguments.of(new int[] { 0, 0, 0}, new int[] {0, 0, 0}),
				Arguments.of(new int[] { 0, 2, 7 }, new int[] {7, 2, 0}),
				Arguments.of(new int[] { 1, 2, 8, 9 }, new int[] {9, 8, 2, 1}),
				Arguments.of(new int[] { 7 }, new int[] {7}),
				Arguments.of(new int[] { }, new int[] {})
			);
	}
	
	@ParameterizedTest
	@MethodSource("provideReverseArrayByFrequencyTestCases")
	@DisplayName("Test Reverse Array By Frequency Test Cases")
	void testReverseArrayByFrequency(int[] array, int frequency, int[] expected) {
		int[] actual = Array.reverseArrayByFrequency(array, frequency);
		assertArrayEquals(expected, actual, "Expected and Actual Arrays should be equal");
	}

	private static Stream<Arguments> provideReverseArrayByFrequencyTestCases() {
		return Stream.of(
				Arguments.of(new int[] { 1, 2, 3, 4, 5 }, 3, new int[] { 3, 2, 1, 5, 4 }),
				Arguments.of(new int[] { 3, 6, 0, 7, 8, 9, 1 }, 3, new int[] { 0, 6, 3, 9, 8, 7, 1 }),
				Arguments.of(new int[] { -3, 0, -1 }, 2, new int[] { 0, -3, -1 }),
				Arguments.of(new int[] { 0, 0, 0 }, 2, new int[] { 0, 0, 0 }),
				Arguments.of(new int[] { 0, 2, 7 }, 1 , new int[] { 0, 2, 7 }),
				Arguments.of(new int[] { 1, 2, 8, 9 }, 2, new int[] { 2, 1, 9, 8 }),
				Arguments.of(new int[] { 7 }, 2, new int[] { 7 }), 
				Arguments.of(new int[] {}, 1, new int[] {})
			);
	}
	
	@ParameterizedTest
	@MethodSource("provideSlidingWindowMaximumTestCases")
	@DisplayName("Test Sliding Window Maximum Test Cases")
	void testSlidingWindowMaximum(int[] array, int windowSize, int[] expected) {
		int[] actual = Array.slidingWindowMaximum(array, windowSize);
		assertArrayEquals(expected, actual, "Expected and Actual Arrays should be equal");
	}

	private static Stream<Arguments> provideSlidingWindowMaximumTestCases() {
		return Stream.of(
				Arguments.of(new int[] { 1, 2, -3, 4, 5 }, 3, new int[] {2, 4, 5 }),
				Arguments.of(new int[] { -3, 6, 0, -7, 8, -9, 1 }, 4, new int[] {6, 8, 8, 8 }),
				Arguments.of(new int[] { -3, 0, -1 }, 2, new int[] { 0, 0 }),
				Arguments.of(new int[] { 0, 0, 0 }, 2, new int[] { 0, 0 }),
				Arguments.of(new int[] { 0, 2, 7 }, 2 , new int[] {2, 7}),
				Arguments.of(new int[] { 1, 2, 8, 9 }, 2, new int[] { 2, 8, 9}),
				Arguments.of(new int[] { 7 }, 1, new int[] { 7 }), 
				Arguments.of(new int[] {}, 1, new int[] {})
			);
	}
	
	@ParameterizedTest
	@MethodSource("provideMaxSumSubArrayTestCases")
	@DisplayName("Max Sum Subarray Test Cases")
	void testMaxSumSubArray(int[] array, int expected) {
	    int actual = Array.maxSumSubArray(array);
	    assertEquals(expected, actual, "Expected and Actual sums should be equal");
	}

	private static Stream<Arguments> provideMaxSumSubArrayTestCases() {
	    return Stream.of(
	        Arguments.of(new int[] {1, -2, 3, 4, -1, 2, 1, -5, 4}, 9),        // max subarray [3, 4, -1, 2, 1]
	        Arguments.of(new int[] {-2, -3, -1, -4}, -1),                     // all negative, max subarray is [-1]
	        Arguments.of(new int[] {5, 4, -1, 7, 8}, 23),                     // entire array is the max subarray
	        Arguments.of(new int[] {-3, 6, -7, 4, -2, 2, 6, -2, 4}, 12),      // max subarray [4, -2, 2, 6, -2, 4]
	        Arguments.of(new int[] {1, 2, 3, 4, 5}, 15),                      // all positive, entire array is max subarray
	        Arguments.of(new int[] {5}, 5),                                   // single element array
	        Arguments.of(new int[] {0, 0, 0}, 0),                             // all zeroes, max sum is 0
	        Arguments.of(new int[] {3, -1, 2, -1, 2, -3, 4}, 6)               // max subarray [3, -1, 2, -1, 2]
	    );
	}
	
	@ParameterizedTest
	@MethodSource("provideMaxProductSubArrayTestCases")
	@DisplayName("Max Product Subarray Test Cases")
	void testMaxProductSubArray(int[] array, int expected) {
	    int actual = Array.maxProductSubArray(array);
	    assertEquals(expected, actual, "Expected and Actual products should be equal");
	}

	private static Stream<Arguments> provideMaxProductSubArrayTestCases() {
	    return Stream.of(
	        Arguments.of(new int[] {2, 3, -2, 4}, 6),               // max product subarray is [2, 3]
	        Arguments.of(new int[] {-2, 0, -1}, 0),                 // max product subarray is [0]
	        Arguments.of(new int[] {-2, 3, -4}, 24),                // max product subarray is [-2, 3, -4]
	        Arguments.of(new int[] {-2, -3, 0, -2, -40}, 80),       // max product subarray is [-2, -40]
	        Arguments.of(new int[] {2, 3, -2, 4, -1}, 48),          // max product subarray is [2, 3, -2, 4, -1]
	        Arguments.of(new int[] {0, 0, 0}, 0),                   // all zeros
	        Arguments.of(new int[] {-2, -3, -4, -5}, 120),          // all negatives, product of entire array
	        Arguments.of(new int[] {5}, 5)                          // single element array
	    );
	}
}
