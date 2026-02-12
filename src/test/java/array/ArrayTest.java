package array;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.IntStream;
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
	
    @ParameterizedTest
    @MethodSource("provideFindKthLargestElementTestCases")
    @DisplayName("Test Find K-th Largest Element")
    void testFindKthLargestElement(int[] array, int k, int expected) {
        int actual = Array.findKthLargestElement(array, k);
        assertEquals(expected, actual, "Expected and actual k-th largest elements should be equal");
    }

    private static Stream<Arguments> provideFindKthLargestElementTestCases() {
        return Stream.of(
            Arguments.of(new int[] {3, 2, 1, 5, 6, 4}, 2, 5),    		// 2nd largest element is 5
            Arguments.of(new int[] {3, 2, 3, 1, 2, 4, 5, 5, 6}, 4, 4), 	// 4th largest is 4
            Arguments.of(new int[] {7, 10, 4, 3, 20, 15}, 3, 10), 		// 3rd largest is 10
            Arguments.of(new int[] {1, 2, 3, 4, 5, 6}, 1, 6),    		// Largest element is 6
            Arguments.of(new int[] {5, 5, 5, 5, 5}, 3, 5),       		// All elements are 5, so 3rd largest is also 5
            Arguments.of(new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1}, 5, 5)   // 5th largest is 5
        );
    }
    
    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Test cases for subarraySumEqualsK method")
    void testSubarraySumEqualsK(int[] array, int k, int expected) {
        int actual = Array.subArraySumEqualsToK(array, k);
        assertEquals(expected, actual, "Expected and actual counts of subarrays should match");
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, 3, 2), 
                Arguments.of(new int[]{1, 1, 1}, 2, 2),
                Arguments.of(new int[]{1, 2, 3, -2, 5}, 5, 2),
                Arguments.of(new int[]{-1, -1, 1}, 0, 1),
                Arguments.of(new int[]{1, -1, 1}, 0, 2),
                Arguments.of(new int[]{3, 4, 7, 2, -3, 1, 4, 2, -3}, 7, 4),
                Arguments.of(new int[]{0, 0, 0, 0}, 0, 10),
                Arguments.of(new int[]{-2, -3, 4, -1, -2, 1, 5, -3}, 3, 3)
        );
    }
    
    @ParameterizedTest
    @MethodSource("providePeakElementTestCases")
    @DisplayName("Test Peak Element Finder")
    void testFindPeakElement(int[] nums, int expected) {
        int actual = Array.findPeakElement(nums);
        assertEquals(expected, actual, "Expected and actual peak element index should match");
    }

    private static Stream<Arguments> providePeakElementTestCases() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 1}, 2),
                Arguments.of(new int[]{1, 2, 1, 3, 5, 6, 4}, 1),
                Arguments.of(new int[]{3, 4, 3, 2, 1}, 1),
                Arguments.of(new int[]{1}, 0),
                Arguments.of(new int[]{10, 20, 15, 2, 23, 90, 67}, 1)
        );
    }
    
    @ParameterizedTest
    @MethodSource("provideTestCasesForLCIS")
    @DisplayName("Test findLengthOfLCIS with various cases")
    void testFindLengthOfLCIS(int[] nums, int expected) {
    	int actual = Array.longestIncreasingSubArray(nums);
        assertEquals(expected, actual, "Expected and Actual count should match");
    }

    private static Stream<Arguments> provideTestCasesForLCIS() {
        return Stream.of(
            Arguments.of(new int[] {1, 3, 5, 4, 7}, 3),
            Arguments.of(new int[] {2, 2, 2, 2}, 1),
            Arguments.of(new int[] {1, 3, 5, 7}, 4),
            Arguments.of(new int[] {5, 4, 3, 2, 1}, 1),
            Arguments.of(new int[] {1, 2, 3, 2, 2, 4, 5}, 3),
            Arguments.of(new int[] {10, 20, 30, 1, 2, 3, 40}, 4)
        );
    }
    
    @ParameterizedTest
    @MethodSource("provideTestCasesForCandyDistribution")
    @DisplayName("Test Candy Distribution with various cases")
    void testCandyDistribution(int[] array, int expected) {
    	int actual = Array.candyDistribution(array);
        assertEquals(expected, actual,"Expected and Actual Candies count should match");
    }

    private static Stream<Arguments> provideTestCasesForCandyDistribution() {
        return Stream.of(
            Arguments.of(new int[]{1, 0, 2}, 5),  		// Expected: [2, 1, 2] -> Total: 5
            Arguments.of(new int[]{1, 2, 2}, 4),  		// Expected: [1, 2, 1] -> Total: 4
            Arguments.of(new int[]{1, 3, 2, 2, 1}, 7),  // Expected: [1, 3, 2, 1, 1] -> Total: 7
            Arguments.of(new int[]{1, 2, 3, 4, 5}, 15), // All increasing sequence: [1, 2, 3, 4, 5] -> Total: 15
            Arguments.of(new int[]{5, 4, 3, 2, 1}, 15), // All decreasing sequence: [5, 4, 3, 2, 1] -> Total: 15
            Arguments.of(new int[]{1, 1, 1, 1}, 4), 	// All equal ratings: [1, 1, 1, 1] -> Total: 4
            Arguments.of(new int[]{1}, 1)  				// Single child: [1] -> Total: 1
        );
    }
    
    @ParameterizedTest
    @DisplayName("Test Median of two sorted arrays with various cases")
    @MethodSource("provideMedianTestCases")
    void testMedianOfSortedArrays(int[] arrayOne, int[] arrayTwo, double expected) {
        double result = Array.medianOfSortedArrays(arrayOne, arrayTwo);
        // Using a tolerance of 0.0001 to account for minor floating-point precision errors 
        // in the median calculation, allowing the test to pass if the actual result is within 
        // 0.0001 of the expected value.
        assertEquals(expected, result, 0.0001, "Expected and actual median should be equal");
    }

    private static Stream<Arguments> provideMedianTestCases() {
        return Stream.of(
            Arguments.of(new int[]{1, 3}, new int[]{2}, 2.0),                // Odd length
            Arguments.of(new int[]{1, 2}, new int[]{3, 4}, 2.5),             // Even length
            Arguments.of(new int[]{0, 0}, new int[]{0, 0}, 0.0),             // All zeros
            Arguments.of(new int[]{}, new int[]{1}, 1.0),                    // One empty array
            Arguments.of(new int[]{1, 2, 6}, new int[]{3, 4, 5}, 3.5),       // Mixed elements
            Arguments.of(new int[]{1, 5, 9}, new int[]{2, 6, 10, 15}, 6.0)   // Unbalanced lengths
        );
    }
    
    @ParameterizedTest
    @DisplayName("Test Search in sorted array with various cases")
    @MethodSource("provideTestCasesForSearchInSortedArray")
    void testSearchInSortedArray(int[] array, int k, int expectedIndex) {
        int actualIndex = Array.searchInSortedArray(array, k);
        assertEquals(expectedIndex, actualIndex, "Expected index and actual index should be equal");
    }

    private static Stream<Arguments> provideTestCasesForSearchInSortedArray() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 3, 4, 5}, 3, 2),          // Element in middle
            Arguments.of(new int[]{1, 2, 3, 4, 5}, 1, 0),          // Element at start
            Arguments.of(new int[]{1, 2, 3, 4, 5}, 5, 4),          // Element at end
            Arguments.of(new int[]{1, 2, 3, 4, 5}, 6, -1),         // Element not in array
            Arguments.of(new int[]{}, 1, -1),                      // Empty array
            Arguments.of(new int[]{1, 3, 5, 7, 9, 11}, 9, 4),      // Element in second half
            Arguments.of(new int[]{1, 3, 5, 7, 9, 11}, 4, -1),     // Element missing, between elements
            Arguments.of(new int[]{10}, 10, 0),                    // Single element found
            Arguments.of(new int[]{10}, 5, -1)                     // Single element not found
        );
    }
    
    @ParameterizedTest
    @DisplayName("Test Search in rotated sorted array with various cases")
    @MethodSource("provideRotatedArrayTestCases")
    void testSearchInRotatedSortedArray(int[] array, int target, int expected) {
        int actualIndex=Array.searchInRotatedSortedArray(array, target);
        assertEquals(expected, actualIndex, "Expected index and actual index should be equal");
    }

    private static Stream<Arguments> provideRotatedArrayTestCases() {
        return Stream.of(
            Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 0, 4),    // Target found at index 4
            Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 3, -1),   // Target not found
            Arguments.of(new int[]{1}, 0, -1),                     // Single element, target not present
            Arguments.of(new int[]{1, 3}, 3, 1),                   // Small array, target found
            Arguments.of(new int[]{6, 7, 0, 1, 2, 4, 5}, 4, 5),    // Target found in rotated portion
            Arguments.of(new int[]{6, 7, 0, 1, 2, 4, 5}, 6, 0),    // Target at the beginning
            Arguments.of(new int[]{6, 7, 0, 1, 2, 4, 5}, 5, 6),    // Target at the end
            Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 6, 2),    // Target found in first half
            Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 1, 5)     // Target found in second half
        );
    }
    
    @ParameterizedTest
    @DisplayName("Test Permutations array with various cases")
    @MethodSource("providePermutationTestCases")
    void testPermutationsOfArray(int[] array, List<List<Integer>> expected) {
        assertEquals(expected, Array.permutationsOfArray(array));
    }

    private static Stream<Arguments> providePermutationTestCases() {
        return Stream.of(
            Arguments.of(new int[]{1}, List.of(List.of(1))),                     // Single element
            Arguments.of(new int[]{1, 2}, List.of(List.of(1, 2), List.of(2, 1))), // Two elements
            Arguments.of(new int[]{1, 2, 3},                                     // Three elements
                List.of(
                    List.of(1, 2, 3), List.of(1, 3, 2), List.of(2, 1, 3),
                    List.of(2, 3, 1), List.of(3, 1, 2), List.of(3, 2, 1)
                )
            )
        );
    }
    
    @ParameterizedTest
    @DisplayName("Test Combinations array with various cases")
    @MethodSource("provideCombinationTestCases")
    void testCombinationsOfArray(int[] array, int k, List<List<Integer>> expected) {
        assertEquals(expected, Array.combinationsOfArray(array, k));
    }

    private static Stream<Arguments> provideCombinationTestCases() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 3}, 2, 
                         List.of(List.of(1, 2), List.of(1, 3), List.of(2, 3))),
            Arguments.of(new int[]{1, 2, 3, 4}, 3, 
                         List.of(List.of(1, 2, 3), List.of(1, 2, 4), List.of(1, 3, 4), List.of(2, 3, 4))),
            Arguments.of(new int[]{1, 2, 3}, 1, 
                         List.of(List.of(1), List.of(2), List.of(3))),
            Arguments.of(new int[]{1, 2, 3}, 3, 
                         List.of(List.of(1, 2, 3))),
            Arguments.of(new int[]{1, 2, 3}, 0, 
                         List.of(List.of())) // Combination of length 0: only empty set
        );
    }
    
    @ParameterizedTest
    @DisplayName("Test Rotate array Clock wise with various cases")
    @MethodSource("provideRotateArrayTestCases")
    void testRotateArray(int[] input, int k, int[] expected) {
        assertArrayEquals(expected, Array.rotateArray(input, k));
    }

    private static Stream<Arguments> provideRotateArrayTestCases() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, 2, new int[]{5, 6, 1, 2, 3, 4}),
            Arguments.of(new int[]{1, 2, 3}, 4, new int[]{3, 1, 2}), // k > array length
            Arguments.of(new int[]{1}, 3, new int[]{1}), // Single-element array
            Arguments.of(new int[]{1, 2, 3, 4, 5}, 0, new int[]{1, 2, 3, 4, 5}), // k = 0
            Arguments.of(new int[]{10, 20, 30, 40}, 4, new int[]{10, 20, 30, 40}), // k = array length
            Arguments.of(new int[]{7, 8, 9}, 1, new int[]{9, 7, 8}) // Small k
        );
    }
    
    @ParameterizedTest
    @MethodSource("provideFirstAndLastIndexTestCases")
    @DisplayName("Test Find First and Last Index Finder")
    void testFindFirstAndLastIndex(int[] nums, int target, int[] expected) {
        int[] actual = Array.findFirstAndLastIndex(nums, target);
        assertArrayEquals(expected, actual, "Expected and actual indices should match.");
    }

    private static Stream<Arguments> provideFirstAndLastIndexTestCases() {
        return Stream.of(
                Arguments.of(new int[]{5, 7, 7, 8, 8, 10}, 8, new int[]{3, 4}),        // Target in the middle
                Arguments.of(new int[]{5, 7, 7, 8, 8, 10}, 6, new int[]{-1, -1}),      // Target not present
                Arguments.of(new int[]{}, 1, new int[]{-1, -1}),                       // Empty array
                Arguments.of(new int[]{1}, 1, new int[]{0, 0}),                        // Single element, target matches
                Arguments.of(new int[]{1}, 2, new int[]{-1, -1}),                      // Single element, target doesn't match
                Arguments.of(new int[]{2, 2, 2, 2, 2}, 2, new int[]{0, 4}),            // All elements match the target
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 3, new int[]{2, 2}),            // Target is a single occurrence in the middle
                Arguments.of(new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3}, 2, new int[]{3, 5}) // Target with multiple occurrences
        );
    }
    
    @ParameterizedTest
    @MethodSource("provideSpiralMatrixTestCases")
    @DisplayName("Test Spiral Matrix Traversal")
    void testSpiralMatrix(char[][] matrix, List<Character> expected) {
        List<Character> actual = Array.spiralMatrix(matrix);
        assertEquals(expected, actual, "Expected and actual spiral traversal results should match.");
    }

    private static Stream<Arguments> provideSpiralMatrixTestCases() {
        return Stream.of(
                Arguments.of(new char[][]{
                        {'A', 'B', 'C'},
                        {'H', 'I', 'D'},
                        {'G', 'F', 'E'}
                }, List.of('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I')),  // Standard 3x3 matrix

                Arguments.of(new char[][]{
                        {'1', '2', '3', '4'},
                        {'5', '6', '7', '8'},
                        {'9', 'A', 'B', 'C'},
                        {'D', 'E', 'F', 'G'}
                }, List.of('1', '2', '3', '4', '8', 'C', 'G', 'F', 'E', 'D', '9', '5', '6', '7', 'B', 'A')), // Larger 4x4 matrix

                Arguments.of(new char[][]{
                        {'X'}
                }, List.of('X')),  // Single element matrix

                Arguments.of(new char[][]{
                        {'A', 'B'},
                        {'C', 'D'}
                }, List.of('A', 'B', 'D', 'C')),  // Simple 2x2 matrix

                Arguments.of(new char[][]{
                        {'A', 'B', 'C'}
                }, List.of('A', 'B', 'C')),  // Single row matrix

                Arguments.of(new char[][]{
                        {'A'},
                        {'B'},
                        {'C'}
                }, List.of('A', 'B', 'C'))  // Single column matrix
        );
    }
    
    @ParameterizedTest
    @MethodSource("provideRotateImageTestCases")
    @DisplayName("Test Rotate Image 90 Degrees Clockwise")
    void testRotateImage(int[][] input, int[][] expected) {
        int[][] actual = Array.rotateImage(input);
        assertArrayEquals(expected, actual, "The rotated matrix should match the expected result.");
    }

    private static Stream<Arguments> provideRotateImageTestCases() {
        return Stream.of(
                Arguments.of(new int[][]{
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                }, new int[][]{
                        {7, 4, 1},
                        {8, 5, 2},
                        {9, 6, 3}
                }), // 3x3 Matrix

                Arguments.of(new int[][]{
                        {5, 1},
                        {2, 4}
                }, new int[][]{
                        {2, 5},
                        {4, 1}
                }), // 2x2 Matrix

                Arguments.of(new int[][]{
                        {1}
                }, new int[][]{
                        {1}
                }), // 1x1 Matrix (Edge case)

                Arguments.of(new int[][]{
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}
                }, new int[][]{
                        {13, 9, 5, 1},
                        {14, 10, 6, 2},
                        {15, 11, 7, 3},
                        {16, 12, 8, 4}
                }) // 4x4 Matrix
        );
    }
    
    @ParameterizedTest
    @MethodSource("provideSearchIn2DArrayTestCases")
    @DisplayName("Test Search in 2D Array")
    void testSearchIn2DArray(int[][] array, int target, boolean expected) {
        boolean actual = Array.searchIn2DArray(array, target);
        assertEquals(expected, actual, "Expected and actual results should match.");
    }

    private static Stream<Arguments> provideSearchIn2DArrayTestCases() {
        return Stream.of(
                Arguments.of(new int[][]{
                        {1, 3, 5},
                        {7, 9, 11},
                        {13, 15, 17}
                }, 9, true),   // Target exists

                Arguments.of(new int[][]{
                        {1, 3, 5},
                        {7, 9, 11},
                        {13, 15, 17}
                }, 8, false),  // Target does not exist

                Arguments.of(new int[][]{
                        {1, 3, 5, 7},
                        {8, 10, 12, 14},
                        {15, 17, 19, 21}
                }, 10, true),  // Target is in the middle of the matrix

                Arguments.of(new int[][]{
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12}
                }, 13, false), // Target outside the range of the matrix

                Arguments.of(new int[][]{
                        {1}
                }, 1, true),  // Single element matching the target

                Arguments.of(new int[][]{
                        {1}
                }, 2, false), // Single element not matching the target

                Arguments.of(new int[][]{
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                }, 7, true)   // Target at the beginning of a row
        );
    }
    
    @ParameterizedTest
    @MethodSource("provideSubsetsTestCases")
    @DisplayName("Test Subsets Generation")
    void testSubsets(int[] nums, List<List<Integer>> expected) {
        List<List<Integer>> actual = Array.subsets(nums);
        assertEquals(expected, actual, "Expected and actual subsets should match.");
    }

    private static Stream<Arguments> provideSubsetsTestCases() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 2, 3},
                        List.of(
                                List.of(),          // Empty subset
                                List.of(3),         // Subset with just 1
                                List.of(2),         // Subset with just 2
                                List.of(2,3),      // Subset with 1 and 2
                                List.of(1),         // Subset with just 3
                                List.of(1, 3),      // Subset with 1 and 3
                                List.of(1,2),      // Subset with 2 and 3
                                List.of(1, 2, 3)    // Subset with all elements
                        )
                ),
                Arguments.of(
                        new int[]{0},
                        List.of(
                                List.of(),
                                List.of(0)
                        )
                ),
                Arguments.of(
                        new int[]{},
                        List.of(
                                List.of() // Only the empty subset
                        )
                ),
                Arguments.of(
                        new int[]{1, 2},
                        List.of(
                                List.of(),
                                List.of(2),
                                List.of(1),
                                List.of(1, 2)
                        )
                )
        );
    }
    
    @ParameterizedTest
    @MethodSource("providePascalsTriangleTestCases")
    @DisplayName("Test Pascal's Triangle Generation")
    void testPascalsTriangle(int numRows, List<List<Integer>> expected) {
        List<List<Integer>> actual = Array.pascalsTriangle(numRows);
        assertEquals(expected, actual, "Expected and actual Pascal's Triangle should match.");
    }

    private static Stream<Arguments> providePascalsTriangleTestCases() {
        return Stream.of(
                Arguments.of(1, List.of(
                        List.of(1)
                )), // Single row
                Arguments.of(2, List.of(
                        List.of(1),
                        List.of(1, 1)
                )), // Two rows
                Arguments.of(3, List.of(
                        List.of(1),
                        List.of(1, 1),
                        List.of(1, 2, 1)
                )), // Three rows
                Arguments.of(5, List.of(
                        List.of(1),
                        List.of(1, 1),
                        List.of(1, 2, 1),
                        List.of(1, 3, 3, 1),
                        List.of(1, 4, 6, 4, 1)
                )), // Five rows
                Arguments.of(0, List.of()), // Zero rows
                Arguments.of(-1, List.of()) // Negative rows
        );
    }
    
    @ParameterizedTest
    @MethodSource("provideMissingNumberTestCases")
    @DisplayName("Test Missing Number Finder")
    void testMissingNumber(int[] nums, int expected) {
        int actual = Array.missingNumber(nums);
        assertEquals(expected, actual, "Expected and actual missing numbers should match.");
    }

    private static Stream<Arguments> provideMissingNumberTestCases() {
        return Stream.of(
                Arguments.of(new int[]{3, 0, 1}, 2),  // Missing 2 in range [0, 3]
                Arguments.of(new int[]{0, 1}, 2),    // Missing 2 in range [0, 2]
                Arguments.of(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}, 8), // Missing 8 in range [0, 9]
                Arguments.of(new int[]{1}, 0),       // Missing 0 in range [0, 1]
                Arguments.of(new int[]{0}, 1),       // Missing 1 in range [0, 1]
                Arguments.of(new int[]{}, 0)        // Empty array (edge case), missing 0
        );
    }

    @ParameterizedTest
    @MethodSource("provideMajorityElementTestCases")
    @DisplayName("Test Majority Element Finder")
    void testMajorityElement(int[] nums, int expected) {
        int actual = Array.majorityElement(nums);
        assertEquals(expected, actual, "Expected and actual majority elements should match.");
    }

    private static Stream<Arguments> provideMajorityElementTestCases() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 3}, 3),                  // Majority element is 3
                Arguments.of(new int[]{2, 2, 1, 1, 1, 2, 2}, 2),      // Majority element is 2
                Arguments.of(new int[]{1, 1, 1, 1}, 1),               // All elements are the same
                Arguments.of(new int[]{1, 2, 3, 1, 1}, 1),            // Majority element is 1
                Arguments.of(new int[]{1}, 1),                        // Single element, it is the majority
                Arguments.of(new int[]{}, 0),                         // Empty array, no majority element
                Arguments.of(new int[]{1, 2, 2, 1, 2}, 2)             // Majority element is 2
        );
    }
    
    @ParameterizedTest
    @MethodSource("provideMajorityElementIITestCases")
    @DisplayName("Test Majority Element II Finder")
    void testMajorityElementII(int[] nums, List<Integer> expected) {
        List<Integer> actual = Array.majorityElementII(nums);
        assertEquals(expected, actual, "Expected and actual majority elements should match.");
    }

    private static Stream<Arguments> provideMajorityElementIITestCases() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 3}, List.of(3)),                  // Single majority element
                Arguments.of(new int[]{1}, List.of(1)),                       // Single element array
                Arguments.of(new int[]{1, 2}, List.of(1, 2)),                 // Both elements are majority
                Arguments.of(new int[]{3, 3, 4, 4, 4}, List.of(3,4)),           // Majority element is 4
                Arguments.of(new int[]{}, List.of()),                         // Empty array, no majority element
                Arguments.of(new int[]{1, 2, 3, 4, 5}, List.of()),            // No element is a majority
                Arguments.of(new int[]{1, 1, 1, 2, 2, 3, 3, 3}, List.of(1, 3)) // Multiple majority elements
        );
    }
    
    @ParameterizedTest
    @MethodSource("provideNumWith2DigitIs1TestCases")
    @DisplayName("Test numbers whose 2nd digit is 1")
    void testNumsWith2DigitIs1(int[] nums, List<Integer> expected) {
    	List<Integer> actual = Array.numWith2ndDigitIs1(nums);
    	assertEquals(expected, actual);
    }
    private static Stream<Arguments> provideNumWith2DigitIs1TestCases() {
        return Stream.of(
                Arguments.of(new int[]{31, 2, 32}, List.of(31)),
                Arguments.of(new int[]{11}, List.of(11)),          
                Arguments.of(new int[]{1, 11}, List.of(1,11)),               	
                Arguments.of(new int[]{39, 31, 41, 48, 42}, List.of(31,41)),    
                Arguments.of(new int[]{}, List.of()),                       
                Arguments.of(new int[]{5}, List.of()),          
                Arguments.of(new int[]{11, 21, 31, 42, 52, 63, 73, 83}, List.of(11, 21, 31))
        );
    }
    
    @ParameterizedTest
    @MethodSource("provideremoveDuplicatesInSortedArrayTestCases")
    @DisplayName("Test Remove Duplicates From SortedArray")
    void testremoveDuplicatesInSortedArray(int[] nums, int[] expected) {
    	int[] actual = Array.removeDuplicatesInSortedArray(nums);
    	assertArrayEquals(expected, actual);
    }
    private static Stream<Arguments> provideremoveDuplicatesInSortedArrayTestCases() {
        return Stream.of(
                Arguments.of(new int[]{1,1,2,3,4,4,4,4,4,5,6,7,8,8},new int[] {1,2,3,4,5,6,7,8}),
                Arguments.of(new int[]{11}, new int[] {11}),
                Arguments.of(new int[]{2,2,2,2,2,2,2,2}, new int[] {2}), 
                Arguments.of(new int[]{1, 11}, new int[] {1,11}),               	
                Arguments.of(new int[]{1,2,3,4,5,6}, new int[] {1,2,3,4,5,6}),    
                Arguments.of(new int[]{}, new int[] {}),                       
                Arguments.of(new int[]{11, 21, 31, 42, 52, 63, 73, 83}, new int[] {11, 21, 31, 42, 52, 63, 73, 83})
        );
    }
    
    
    @ParameterizedTest
    @MethodSource("provideFrequencyOfMostFrequentElementTestCases")
    @DisplayName("Test Frequency Of Most Frequent Element")
	void testFrequencyOfMostFrequentElement(int[] nums, int k, int expected) {
		int actual = Array.frequencyOfMostFrequentElement(nums, k);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> provideFrequencyOfMostFrequentElementTestCases() {
		return Stream.of(Arguments.of(new int[] { 1, 2, 4 }, 5, 3), 
				Arguments.of(new int[] { 1, 4, 8, 13 }, 5, 2),
				Arguments.of(new int[] { 2, 6, 9 }, 2, 1));
	}
	
    @ParameterizedTest
    @MethodSource("provideHighestOccurringElementInArrayTestCases")
    @DisplayName("Test Highest Occurring Element In Array")
	void testHighestOccurringElementInArray(int[] nums,int expected) {
		int actual = Array.highestOccurringElementInArray(nums);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> provideHighestOccurringElementInArrayTestCases() {
		return Stream.of(Arguments.of(new int[] { 1, 2, 4 }, 1), 
				Arguments.of(new int[] { 4, 4, 8, 13 }, 4),
				Arguments.of(new int[] { 2, 6, 9, 6, 6, 7 }, 6), 
				Arguments.of(new int[] {}, -1),
				Arguments.of(new int[] { 1, 1, 1, 1, 1, 1 }, 1));
	}
	
	
    @ParameterizedTest
    @MethodSource("provideTrappingRainWaterTestCases")
    @DisplayName("Test Trapping Rain Water")
	void testTrappingRainWater(int[] heights, int expected) {
		int actual = Array.trappingRainWater(heights);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> provideTrappingRainWaterTestCases() {
		return Stream.of(Arguments.of(new int[] { 0,1,0,2,1,0,1,3,2,1,2,1 }, 6), 
				Arguments.of(new int[] { 4,2,0,3,2,5}, 9));
	}
    @ParameterizedTest
    @MethodSource("provideBestToBuySellStockTestCases")
    @DisplayName("Test Best To Buy Sell And Stocks")
	void testbestToBuySellStock(int[] prices,int expected) {
		int actual = Array.bestToBuySellStock(prices);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> provideBestToBuySellStockTestCases() {
		return Stream.of(Arguments.of(new int[] { 7, 1, 5, 3, 6, 4 }, 5), Arguments.of(new int[] { 7, 6, 4, 3, 1 }, 0));
	}
	
	@ParameterizedTest
	@MethodSource("prodeTestInputsForMergeIntervals")
	@DisplayName("Test Merge Intervals")
	void testMergeIntervals(int[][] intervals,int[][] expected) {
		int[][] actual = Array.mergeIntervals(intervals);
		assertArrayEquals(expected, actual);
	}

	static Stream<Arguments> prodeTestInputsForMergeIntervals() {
		return Stream.of(
				Arguments.of(new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } },
						new int[][] { { 1, 6 }, { 8, 10 }, { 15, 18 } }),
				Arguments.of(new int[][] { { 1, 4 }, { 4, 5 } }, new int[][] { { 1, 5 } }),
				Arguments.of(new int[][] { { 4, 7 }, { 1, 4 } }, new int[][] { { 1, 7 } }));
	}
	
	@ParameterizedTest
	@MethodSource("prodeTestInputsForInsertIntervals")
	@DisplayName("Test Insert Intervals")
	void testInsertIntervals(int[][] intervals,int[] newInterval,int[][] expected) {
		int[][] actual = Array.insertInterval(intervals,newInterval);
		assertArrayEquals(expected, actual);
	}

	static Stream<Arguments> prodeTestInputsForInsertIntervals() {
		return Stream.of(
				Arguments.of(new int[][] { { 1, 3 }, { 6, 9 } }, new int[] { 2, 5 }, new int[][] { { 1, 5 }, { 6, 9 } }),
				Arguments.of(new int[][] { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } }, new int[] { 4, 8 }, new int[][] { { 1, 2 }, { 3, 10 }, { 12, 16 } }));
	}
	
    @ParameterizedTest
    @MethodSource("provideFindSecondMaxTestCases")
    @DisplayName("Test Find Second Max Element In Array")
	void testFindSecondMax(int[] nums,int expected) {
		int actual = Array.findSecondMax(nums);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> provideFindSecondMaxTestCases() {
		return Stream.of(Arguments.of(new int[] { 1, 2, 4 }, 2),
				Arguments.of(new int[] { 4, 4, 8, 13 }, 8),
				Arguments.of(new int[] { 2, 6, 9, 6, 6, 7 }, 7),
				Arguments.of(new int[] { 5, 5, 5, 5, 5, 5 }, -1),
				Arguments.of(new int[] { 9, 5, 18, 12, 11, 8, 12, 11 }, 12));
	}
	
    @ParameterizedTest
    @MethodSource("provideFindUnionTestCases")
    @DisplayName("Test Find Union")
    void testFindUnion(int[] arr1,int[] arr2, List<Integer> expected) {
    	List<Integer> actual = Array.findingUnionOfArrays(arr1,arr2);
    	assertEquals(expected, actual);
    }

	private static Stream<Arguments> provideFindUnionTestCases() {
		return Stream.of(
				Arguments.of(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, new int[] { 2, 3, 4, 4, 5, 11, 12 }, List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)),
				Arguments.of(new int[] { 1, 1, 2, 2, 2, 4 }, new int[] { 2, 2, 4, 4 }, List.of(1, 2, 4)),
				Arguments.of(new int[] { 3, 5, 10, 10, 10, 15, 15, 20 }, new int[] { 5, 10, 10, 15, 30 }, List.of(3, 5, 10, 15, 20, 30))
		);
	}
	
    @ParameterizedTest
    @MethodSource("provideSingleNumberTestCases")
    @DisplayName("Test single number in array")
	void testSingleNumber(int[] nums,int expected) {
		int actual = Array.singleNumber(nums);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> provideSingleNumberTestCases() {
		return Stream.of(Arguments.of(new int[] { 1, 2, 2 }, 1), 
				Arguments.of(new int[] { 4, 4, 8, 13, 8, 13, 7 }, 7),
				Arguments.of(new int[] { 2, 6, 9, 6, 6, 7, 7, 9, 6 }, 2),
				Arguments.of(new int[] { -1, 5, 5, 5, 5, 5, 5 }, -1), 
				Arguments.of(new int[] { 1, 1, 5 }, 5));
	}
	
    @ParameterizedTest
    @MethodSource("provideMinimumJumpsTestCases")
    @DisplayName("Test minimum jumps to reach array end")
	void testMinJumps(int[] nums,int expected) {
		int actual = Array.minJumps(nums);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> provideMinimumJumpsTestCases() {
		return Stream.of(Arguments.of(new int[] { 2,3,1,1,4 }, 2), 
				Arguments.of(new int[] {2,3,0,1,4 }, 2),
				Arguments.of(new int[] { 2, 6, 9, 6, 6, 7 ,7,9}, 2), 
				Arguments.of(new int[] {2, 10, 20}, 1)
				);
	}
	
    @ParameterizedTest
    @MethodSource("provideJumpGameTestCases")
    @DisplayName("Test jump to reach array end")
	void testJumpGame(int[] nums,Boolean expected) {
		Boolean actual = Array.jumpGame(nums);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> provideJumpGameTestCases() {
		return Stream.of(Arguments.of(new int[] { 2,3,1,1,4 }, true), 
				Arguments.of(new int[] {3,2,1,0,4 }, false),
				Arguments.of(new int[] { 2, 6, 9, 6, 6, 7 ,7,9}, true), 
				Arguments.of(new int[] {2, 1, 0}, true)
				);
	}
	
    @ParameterizedTest
    @MethodSource("provideMaxLengthSubArrayTestCases")
    @DisplayName("Test Max Length Sub array")
	void testMaxLengthSubArry(int[] nums,int target,int expected) {
		int actual = Array.maxLengthSubarray(nums,target);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> provideMaxLengthSubArrayTestCases() {
		return Stream.of(Arguments.of(new int[] { 10, 5, 2, 7, 1, -10 }, 15, 6),
				Arguments.of(new int[] { -5, 8, -14, 2, 4, 12 }, -5, 5),
				Arguments.of(new int[] { 10, -10, 20, 30 }, 5, 0));
	}
	
    @ParameterizedTest
    @MethodSource("provideCheckSortedRoatatedTestCases")
    @DisplayName("Test array is sorted and roatated")
	void testArraysSortedRoatated(int[] nums,boolean expected) {
		boolean actual = Array.checkArrayIsSortedRoatated(nums);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> provideCheckSortedRoatatedTestCases() {
		return Stream.of(Arguments.of(new int[] { 8,9,1,2,3,4,5,6,7 },true),
				Arguments.of(new int[] {8,1,2,3,6,4,7}, false),
				Arguments.of(new int[] {1,2,3,6,8,7}, false),
				Arguments.of(new int[] { 1,2,3 }, true));
	}
	
    @ParameterizedTest
    @MethodSource("provideSort012TestCases")
    @DisplayName("Test sort array that contains 0's, 1's and 2's ")
	void testSort012s(int[] nums, int[] expected) {
		int[] actual = Array.sort012s(nums);
		assertArrayEquals(expected, actual);
	}

	private static Stream<Arguments> provideSort012TestCases() {
		return Stream.of(Arguments.of(new int[] { 1, 1, 2, 0, 1, 1 }, new int[] { 0, 1, 1, 1, 1, 2 }),
				Arguments.of(new int[] { 1, 1, 1, 1, 1 }, new int[] { 1, 1, 1, 1, 1 }),
				Arguments.of(new int[] { 1, 1, 2 }, new int[] { 1, 1, 2 }),
				Arguments.of(new int[] { 1, 2, 0 }, new int[] { 0, 1, 2 }),
				Arguments.of(new int[] { 0, 0, 0 }, new int[] { 0, 0, 0 }),
				Arguments.of(new int[] { 1 }, new int[] { 1 }));
	}
	
    @ParameterizedTest
    @MethodSource("provideColorfulRopeTestCases")
    @DisplayName("Test colorful rope")
	void testColorfulRope(String colors, int[] time,int expectedTime) {
		int actual = Array.colorfulRope(colors,time);
		assertEquals(expectedTime, actual);
	}

	private static Stream<Arguments> provideColorfulRopeTestCases() {
		return Stream.of(Arguments.of("abaac", new int[] { 1, 2, 3, 4, 5 }, 3),
				Arguments.of("abc", new int[] { 1, 2, 3 }, 0), 
				Arguments.of("aabaa", new int[] { 1, 2, 3, 4, 1 }, 2),
				Arguments.of("aaaaa", new int[] { 1, 2,3,4,5 }, 10));
	}
	
    @ParameterizedTest
    @MethodSource("provideCoinChangeTestCases")
    @DisplayName("Test Coin Change")
	void testCoinChange(int[] coins, int amount, int expectedTime) {
		int actual = Array.coinChange(coins, amount);
		assertEquals(expectedTime, actual);
	}

	private static Stream<Arguments> provideCoinChangeTestCases() {
		return Stream.of(Arguments.of(new int[] { 1, 2, 5 },26, 6),
				Arguments.of(new int[] { 1, 2, 5, 10 }, 1,1), 
				Arguments.of(new int[] { 1, 2, 5, 10, 50 }, 78, 6),
				Arguments.of(new int[] { 1,2,5,10 }, 20,2));
	}
	
    @ParameterizedTest
    @MethodSource("provideNextPermutationTestCases")
    @DisplayName("Test Next Permutation ")
	void testNextPermutation(int[] nums, int[] expected) {
		int[] actual = Array.nextPermutation(nums);
		assertArrayEquals(expected, actual);
	}

	private static Stream<Arguments> provideNextPermutationTestCases() {
		return Stream.of(Arguments.of(new int[] { 1, 2, 3 }, new int[] { 1, 3, 2 }),
				Arguments.of(new int[] { 3, 2, 1 }, new int[] { 1, 2, 3 }),
				Arguments.of(new int[] { 1, 1, 5 }, new int[] { 1, 5, 1 }));
	}
	
    @ParameterizedTest
    @MethodSource("provideFindLeadersTestCases")
    @DisplayName("Test Find Leaders")
	void testFindLeaders(int[] nums, List<Integer> expected) {
		List<Integer> actual = Array.findLeaders(nums);
		assertEquals(expected.size(), actual.size());
		IntStream.range(0, expected.size()).forEach(i -> assertEquals(expected.get(i), actual.get(i)));
	}

	private static Stream<Arguments> provideFindLeadersTestCases() {
		return Stream.of(Arguments.of(new int[] { 16, 17, 4, 3, 5, 2 }, List.of(17, 5, 2)),
				Arguments.of(new int[] { 10, 4, 2, 4, 1 }, List.of(10, 4, 4, 1)),
				Arguments.of(new int[] { 5, 10, 20, 40 }, List.of(40)),
				Arguments.of(new int[] { 30, 10, 10, 5 }, List.of(30, 10, 10, 5)));
	}
	
    @ParameterizedTest
    @MethodSource("provideLongestSequenceTestCases")
    @DisplayName("Test longest consecutive sequence")
	void testLongestConsecutiveSequence(int[] coins, int expected) {
		int actual = Array.longestConsecutiveSequence(coins);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> provideLongestSequenceTestCases() {
		return Stream.of(Arguments.of(new int[] { 100,4,200,1,3,2}, 4),
				Arguments.of(new int[] { 0,3,7,2,5,8,4,6,0,1}, 9), 
				Arguments.of(new int[] { 1,0,1,2 }, 3),
				Arguments.of(new int[] { 1,2,5,10 }, 2));
	}
	
    @ParameterizedTest
    @MethodSource("provideSetMatrixZerosTestCases")
    @DisplayName("Test Set Matrix Zeros")
	void testSetMatrixZeros(int[][] matrix, int[][] expected) {
		int[][] actual = Array.setMatrixZeroes(matrix);
		for(int i=0;i<expected.length;i++) {
			assertArrayEquals(actual[i],expected[i]);
		}
	}

	private static Stream<Arguments> provideSetMatrixZerosTestCases() {
		return Stream.of(Arguments.of(new int[][] { {1,1,1},{1,0,1},{1,1,1}}, new int[][] {{1,0,1},{0,0,0},{1,0,1}}),
				Arguments.of(new int[][] {{0,1,2,0},{3,4,5,2},{1,3,1,5}}, new int[][] {{0,0,0,0},{0,4,5,0},{0,3,1,0}}) 
				);
	}
    
    @ParameterizedTest
    @MethodSource("provide3SumTestCases")
    @DisplayName("Test 3Sum")
	void test3Sum(int[] nums, List<List<Integer>> expected) {
    	List<List<Integer>> actual = Array.threeSum(nums);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> provide3SumTestCases() {
		return Stream
				.of(Arguments.of(new int[] { -1, 0, 1, 2, -1, -4 }, List.of(List.of(-1, -1, 2), List.of(-1, 0, 1))),
						Arguments.of(new int[] { 1, 1, 1, 0, 3, -2, }, List.of(List.of(-2, 1, 1))),
						Arguments.of(new int[] { 1, 1, 1, 0, -1, -2, 3, -2, }, List.of(List.of(-2, -1, 3),List.of(-2, 1,1),List.of(-1, 0, 1))),
						Arguments.of(new int[] { 0, 1, 1 }, List.of()),
						Arguments.of(new int[] { 1, 1, 0, 3, -2, }, List.of(List.of(-2, 1, 1))),
						Arguments.of(new int[] { 0, 0, 0 }, List.of(List.of(0, 0, 0))));
	}
	
    @ParameterizedTest
    @MethodSource("provideLargestSumSubArrayTestCases")
    @DisplayName("Test largest sum subarray with 0 sum ")
	void testLargestSumSubArray(int[] nums, int expected) {
		int actual = Array.largestSumSubArray(nums);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> provideLargestSumSubArrayTestCases() {
		return Stream.of(Arguments.of(new int[] {15, -2, 2, -8, 1, 7, 10, 23 }, 5),
				Arguments.of(new int[] { 2, 10, 4 }, 0),
				Arguments.of(new int[] { 0, 1, 5 }, 1));
	}
	
    @ParameterizedTest
    @MethodSource("provideCountSubArraysSumWithKTestCases")
    @DisplayName("Test largest sum subarray with 0 sum ")
	void testCountSubArraysWithSumK(int[] nums,int k, int expected) {
		int actual = Array.countSubArraysWithSumK(nums,k);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> provideCountSubArraysSumWithKTestCases() {
		return Stream.of(Arguments.of(new int[] {3,4,7,2,-3,1,4,2}, 7, 4),
				Arguments.of(new int[] {1,-1,0}, 0,3),
				Arguments.of(new int[] {1,1,1}, 2,2),
				Arguments.of(new int[] { 1,2,3 }, 3,2));
	}
	
    @ParameterizedTest
    @MethodSource("provideRotateMatrix90DegreesTestCases")
    @DisplayName("Test rotate matrix 90 degrees")
	void testRotateMatrix90Degrees(int[][] matrix, int[][] expected) {
		int[][] actual = Array.rotateMatrix90Degrees(matrix);
		for (int i = 0; i < expected.length; i++) {
			assertArrayEquals(actual[i], expected[i]);
		}
	}

	private static Stream<Arguments> provideRotateMatrix90DegreesTestCases() {
		return Stream.of(
				Arguments.of(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }, new int[][] { { 7, 4, 1 }, { 8, 5, 2 }, { 9, 6, 3 } }),
				Arguments.of(new int[][] { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } }, new int[][] { { 15, 13, 2, 5 }, { 14, 3, 4, 1 }, { 12, 6, 8, 9 }, { 16, 7, 10, 11 } })
				);
	}
	
    @ParameterizedTest
    @MethodSource("provideSearchInsertPositionTestCases")
    @DisplayName("Test search insert position ")
	void testSearchInsertPosition(int[] nums,int target, int expected) {
		int actual = Array.searchInsertPosition(nums,target);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> provideSearchInsertPositionTestCases() {
		return Stream.of(Arguments.of(new int[] { 1, 3, 5, 6 }, 7, 4), 
				Arguments.of(new int[] { 1, 3, 5, 6 }, 2, 1),
				Arguments.of(new int[] { 1, 2, 5, 6 }, 5, 2)
			);
	}
	
    @ParameterizedTest
    @MethodSource("provideGetFloorAndCeilTestCases")
    @DisplayName("Test floor and ceil of target number")
	void testgetFloorAndCeil(int[] nums,int target, List<Integer> expected) {
		List<Integer> actual = Array.getFloorAndCeil(nums,target);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> provideGetFloorAndCeilTestCases() {
		return Stream.of(
				Arguments.of(new int[] { 1, 3, 5, 6 }, 7, List.of(6, 7)),
				Arguments.of(new int[] { 1, 3, 5, 6 }, 2, List.of(1, 3)),
				Arguments.of(new int[] { 4, 6, 7, 8 }, 2, List.of(2, 4)),
				Arguments.of(new int[] { 4, 6, 7, 8 }, 9, List.of(8, 9)),
				Arguments.of(new int[] { 4, 6, 7, 9 }, 8, List.of(7, 9)),
				Arguments.of(new int[] { 2, 3, 5, 6 }, 5, List.of(5, 5))
			);
	}
	
    @ParameterizedTest
    @MethodSource("provideFirstAndLastPostionTestCases")
    @DisplayName("Test first and last postion of an element")
	void testFirstAndLastPostion(int[] nums,int target, int[] expected) {
		int[] actual = Array.firstAndLastPostion(nums,target);
		assertArrayEquals(expected, actual);
	}

	private static Stream<Arguments> provideFirstAndLastPostionTestCases() {
		return Stream.of(Arguments.of(new int[] { 5, 7, 7, 8, 8, 10 }, 8, new int[] { 3, 4 }),
				Arguments.of(new int[] { 5, 7, 7, 8, 8, 10 }, 6, new int[] { -1, -1 }),
				Arguments.of(new int[] { 1, 2, 5, 6, 7, 8, 9, 9 }, 9, new int[] { 6, 7 }),
				Arguments.of(new int[] { 1, 1 }, 1, new int[] { 0, 1 }),
				Arguments.of(new int[] { }, 1, new int[] { -1, -1 }),
				Arguments.of(new int[] { 1 ,3 }, 1, new int[] { 0, 0 }),
				Arguments.of(new int[] { 5 }, 5, new int[] { 0, 0 }),
				Arguments.of(new int[] { 1 }, 6, new int[] { -1, -1 }),
				Arguments.of(new int[] { 1, 1, 5 }, 1, new int[] { 0, 1 })
			);
	}
	
    @ParameterizedTest
    @MethodSource("provideCountOccurrencesTestCases")
    @DisplayName("Test count occurrences of element in sorted array")
	void testCountOccurrences(int[] nums,int target, int expected) {
		int actual = Array.countOccurrences(nums,target);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> provideCountOccurrencesTestCases() {
		return Stream.of(Arguments.of(new int[] { 5, 7, 7, 8, 8, 10 }, 8,2),
				Arguments.of(new int[] { 5, 7, 7, 8, 8, 10 }, 6, 0),
				Arguments.of(new int[] { 1, 2, 5, 6, 7, 8,9, 9, 9 }, 9, 3),
				Arguments.of(new int[] { 1, 1 }, 1,2),
				Arguments.of(new int[] { }, 1, 0),
				Arguments.of(new int[] { 1 ,3 }, 1, 1),
				Arguments.of(new int[] { 5 }, 5, 1),
				Arguments.of(new int[] { 1 }, 6, 0),
				Arguments.of(new int[] { 1, 1, 5 }, 1,2)
			);
	}
	
    @ParameterizedTest
    @MethodSource("provideSearchInRoatedSortedArrayTestCases")
    @DisplayName("Test search in roated sorted array ")
	void testSearchInRoatedSortedArray(int[] nums,int target, int expected) {
		int actual = Array.searchInRoatedSortedArray(nums,target);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> provideSearchInRoatedSortedArrayTestCases() {
		return Stream.of(
				Arguments.of(new int[] { 1, 3, 5, 6 }, 7, -1), 
				Arguments.of(new int[] { 1, 3, 5, 6 }, 6, 3),
				Arguments.of(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 5, 1),
				Arguments.of(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 3, -1), 
				Arguments.of(new int[] { 1, 2, 5, 6 }, 1, 0)
			);
	}
	
    @ParameterizedTest
    @MethodSource("provideSearchInRoatedSortedIIArrayTestCases")
    @DisplayName("Test search in roated sorted array II ")
	void testSearchInRoatedSortedArrayII(int[] nums,int target, Boolean expected) {
		Boolean actual = Array.searchInRoatedSortedArrayII(nums,target);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> provideSearchInRoatedSortedIIArrayTestCases() {
		return Stream.of(
				Arguments.of(new int[] { 1, 3, 5, 6 }, 7, false), 
				Arguments.of(new int[] { 1, 3, 5, 6 }, 6, true),
				Arguments.of(new int[] { 2,5,6,0,0,1,2 }, 0, true),
				Arguments.of(new int[] { 2,5,6,0,0,1,2 }, 3, false), 
				Arguments.of(new int[] { 1, 2, 5, 6 }, 1, true)
			);
	}
	
    @ParameterizedTest
    @MethodSource("provideMinInRoatedSortedArrayTestCases")
    @DisplayName("Test Minimum in roated sorted array ")
	void testMinInRoatedSortedArray(int[] nums,int expected) {
		int actual = Array.findMinimumInRoatedSortedArray(nums);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> provideMinInRoatedSortedArrayTestCases() {
		return Stream.of(
				Arguments.of(new int[] { 1, 3, 5, 6 },1), 
				Arguments.of(new int[] { 1, 3, 5, 6 }, 1),
				Arguments.of(new int[] { 4, 5, 6, 7, 0, 1, 2 },0),
				Arguments.of(new int[] { 1, 2, 4, 5, 6, 7, 0, },0), 
				Arguments.of(new int[] { 1, 2, 5, 6 }, 1)
			);
	}
	
    @ParameterizedTest
    @MethodSource("provideRoatationCountTestCases")
    @DisplayName("Test count roatations ")
	void testRoatationCount(int[] nums,int expected) {
		int actual = Array.roatationCount(nums);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> provideRoatationCountTestCases() {
		return Stream.of(
				Arguments.of(new int[] { 1, 3, 5, 6 },0), 
				Arguments.of(new int[] { 8, 1, 3, 5, 6, 7 }, 1),
				Arguments.of(new int[] { 4, 5, 6, 7, 0, 1, 2 },4),
				Arguments.of(new int[] { 1, 2, 4, 5, 6, 7 },0), 
				Arguments.of(new int[] { 7, 6, 5, 2, 1}, 4)
			);
	}
	
    @ParameterizedTest
    @MethodSource("provideFindSingleInSortedArrayTestCases")
    @DisplayName("Test find single in sorted array")
	void testFindSingleInSortedArray(int[] nums,int expected) {
		int actual = Array.findSingleInSortedArray(nums);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> provideFindSingleInSortedArrayTestCases() {
		return Stream.of(
				Arguments.of(new int[] { 1,1,2,3,3,4,4,8,8},2), 
				Arguments.of(new int[] { 3,3,7,7,10,11,11}, 10),
				Arguments.of(new int[] { 1,2,2,3,3,4,4,8,8 },1),
				Arguments.of(new int[] { 1,1,2,2,3,3,4,4,8 },8), 
				Arguments.of(new int[] { 1,1,2,2,3,3,4,4,7,8,8}, 7)
			);
	}
	
    @ParameterizedTest
    @MethodSource("provideFindSquareRootTestCases")
    @DisplayName("Test Finding Square Root")
	void testFindSquareRoot(int num,int expected) {
		int actual = Array.findSquareRoot(num);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> provideFindSquareRootTestCases() {
		return Stream.of(
				Arguments.of(36,6), 
				Arguments.of(50, 7),
				Arguments.of(100,10),
				Arguments.of(144,12), 
				Arguments.of(12, 3)
			);
	}
	
    @ParameterizedTest
    @MethodSource("provideKokoEatingBananasTestCases")
    @DisplayName("Test koko eating bananas")
	void testKokoEatingBananas(int[] piles,int hours,int minimumHours) {
		int actual = Array.kokoEatingBananas(piles,hours);
		assertEquals(minimumHours, actual);
	}

	private static Stream<Arguments> provideKokoEatingBananasTestCases() {
		return Stream.of(Arguments.of(new int[] { 3, 6, 7, 11 }, 8, 4),
				Arguments.of(new int[] { 30, 11, 23, 4, 20 }, 5, 30),
				Arguments.of(new int[] { 30, 11, 23, 4, 20 }, 6, 23)
			);
	}
	
    @ParameterizedTest
    @MethodSource("provideMinimumDaysToMakeMbucketsTestCases")
    @DisplayName("Test Minimum Days To Make Mbuckets")
	void testMinimumDaysToMakeMbuckets(int[] bloomDay,int m, int k,int expected) {
		int actual = Array.minimumDaysToMakeMbuckets(bloomDay,m,k);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> provideMinimumDaysToMakeMbucketsTestCases() {
		return Stream.of(Arguments.of(new int[] { 1, 10, 3, 10, 2 }, 3, 1, 3),
				Arguments.of(new int[] { 1, 10, 3, 10, 2 }, 3, 2, -1),
				Arguments.of(new int[] { 7, 7, 7, 7, 12, 7, 7 }, 2, 3, 12));
	}
	
    @ParameterizedTest
    @MethodSource("provideSearchIn2DArrayIITestCases")
    @DisplayName("Test Search in 2D Array II")
    void testSearchIn2DArrayII(int[][] array, int target, boolean expected) {
        boolean actual = Array.searchIn2DmatrixII(array, target);
        assertEquals(expected, actual, "Expected and actual results should match.");
    }
    
	private static Stream<Arguments> provideSearchIn2DArrayIITestCases() {
		return Stream.of(
				Arguments.of(new int[][] { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 },
						{ 10, 13, 14, 17, 24 }, { 18, 21, 23, 26, 30 } }, 5, true),
				Arguments.of(new int[][] { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 },
						{ 10, 13, 14, 17, 24 }, { 18, 21, 23, 26, 30 } }, 55, false),
				Arguments.of(new int[][] { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 },
						{ 10, 13, 14, 17, 24 }, { 18, 21, 23, 26, 30 } }, 21, true),
				Arguments.of(new int[][] { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 },
						{ 10, 13, 14, 17, 24 }, { 18, 21, 23, 26, 30 } }, 19, true));
	}
	
    @ParameterizedTest
    @MethodSource("provideCountZerosTestCases")
    @DisplayName("Test Count Zeros")
	void testCountZeros(int[] nums,int expected) {
		int actual = Array.countZeros(nums);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> provideCountZerosTestCases() {
		return Stream.of(Arguments.of(new int[] { 1, 1, 1, 1, 1, 1, 0, 0, 0, 0 }, 4),
				Arguments.of(new int[] { 1, 1, 1, 1, 1 }, 0), 
				Arguments.of(new int[] { 1, 0, 0, 0, 0, 0, 0, 0, 0 }, 8),
				Arguments.of(new int[] { 1, 1, 1, 0, 0, 0 }, 3), 
				Arguments.of(new int[] { 0, 0, 0, 0, 0, 0, 0 }, 7));
	}
	
	@ParameterizedTest
	@MethodSource("provideFindEquilibriumTestCases")
	@DisplayName("Test Find Equilibrium Index")
	void testFindEquilibrium(int[] arr, int expected) {
	    int actual = Array.findEquilibrium(arr);
	    assertEquals(expected, actual);
	}

	private static Stream<Arguments> provideFindEquilibriumTestCases() {
	    return Stream.of(
	        Arguments.of(new int[]{1, 3, 5, 2, 2}, 2),   // equilibrium at index 2
	        Arguments.of(new int[]{2, -2, 2, -2, 2}, 0), // equilibrium at index 0
	        Arguments.of(new int[]{0, 0, 0, 0}, 0),      // any index works, returns first
	        Arguments.of(new int[]{1, 2, 3}, -1),        // no equilibrium
	        Arguments.of(new int[]{}, -1),               // empty array edge case
	        Arguments.of(new int[]{5}, 0),               // single element → equilibrium at 0
	        Arguments.of(new int[]{3, 4, 8, -9, 20, 6}, 4) // equilibrium at index 4
	    );
	}
	
    @ParameterizedTest
    @MethodSource("inputsForIntersectionOfTwoArrays")
    @DisplayName("Test Intersection Of Two Arrays")
	void testIntersectionOfTwoArrays(int[] first, int[] second, int[] expected) {
		int[] actual = Array.intersectionOfTwoArrays(first, second);
		assertArrayEquals(expected, actual);
	}

	private static Stream<Arguments> inputsForIntersectionOfTwoArrays() {
		return Stream.of(Arguments.of(new int[] { 1, 2, 2, 1 }, new int[] { 2, 2 }, new int[] { 2 }),
				Arguments.of(new int[] { 9, 4, 9, 8, 4 }, new int[] { 4, 9, 5 }, new int[] { 9, 4 }),
				Arguments.of(new int[] { 1, 2, 2, 1 }, new int[] { 2, 2, 1 }, new int[] { 1, 2 }),
				Arguments.of(new int[] { 1, 2, 3, 4 }, new int[] { 5, 6, 7, 8 }, new int[] {}),
				Arguments.of(new int[] { 100 }, new int[] { 100 }, new int[] { 100 }));
	}
	
	@ParameterizedTest
	@MethodSource("provideIntersectionOfTwoArraysIITestCases")
	@DisplayName("Test Intersection of Two Arrays II")
	void testIntersectionOfTwoArraysII(int[] first, int[] second, int[] expected) {
	    int[] actual = Array.intersectionOfTwoArraysII(first, second);
	    assertArrayEquals(expected, actual);
	}

	private static Stream<Arguments> provideIntersectionOfTwoArraysIITestCases() {
	    return Stream.of(
	        // Standard case with duplicates
	        Arguments.of(new int[] {1, 2, 2, 1},new int[] {2, 2}, new int[] {2, 2}),

	        // Different ordering, multiple duplicates
	        Arguments.of( new int[] {4, 9, 5},new int[] {9, 4, 9, 8, 4}, new int[] {9, 4}),

	        // All elements same
	        Arguments.of(new int[] {1, 1, 1}, new int[] {1, 1}, new int[] {1, 1}),

	        // No intersection
	        Arguments.of( new int[] {1, 2, 3},new int[] {4, 5, 6},new int[] {}),

	        // First array empty
	        Arguments.of( new int[] {},new int[] {1, 2, 3},new int[] {}),

	        // Second array empty
	        Arguments.of( new int[] {1, 2, 2, 3}, new int[] {},  new int[] {} )
	    );
	}
	
    @ParameterizedTest
    @MethodSource("provideFindSmallestLetterGraterThanTargetTestCases")
    @DisplayName("Test provide find smallest letter grater than target")
	void testFindSmallestLetterGraterThanTarget(char[] letters, char target, char expected) {
		char actual = Array.findSmallestLetterGraterThanTarget(letters, target);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> provideFindSmallestLetterGraterThanTargetTestCases() {
		return Stream.of(Arguments.of(new char[] { 'c', 'f', 'j' }, 'c', 'f'),
				Arguments.of(new char[] { 'c', 'f', 'j' }, 'c', 'f'),
				Arguments.of(new char[] { 'c', 'f', 'j', 'j' }, 'f', 'j'),
				Arguments.of(new char[] { 'a', 'b', 'c', 'd' }, 'c', 'd'),
				Arguments.of(new char[] { 'c', 'f', 'j' }, 'x', 'c'),
				Arguments.of(new char[] { 'x', 'x', 'f', 'j', 'y', 'y' }, 'z', 'x'));
	}
	
    @ParameterizedTest
    @MethodSource("provideContainerWithMostWaterTestCases")
    @DisplayName("Test container with most water")
    void testContainerWithMostWater(int[] heights, int expected) {
        assertEquals(expected, Array.containerWithMostWater(heights));
    }

    static Stream<Arguments> provideContainerWithMostWaterTestCases() {
        return Stream.of(
            Arguments.of(new int[]{1,8,6,2,5,4,8,3,7}, 49), // standard case
            Arguments.of(new int[]{1,1}, 1),               // minimum size
            Arguments.of(new int[]{4,3,2,1,4}, 16),        // same heights at ends
            Arguments.of(new int[]{1,2,1}, 2),             // small array
            Arguments.of(new int[]{2,3,10,5,7,8,9}, 36),   // max in middle
            Arguments.of(new int[]{1,2,3,4,5}, 6)          // increasing heights
        );
    }
    
    @ParameterizedTest
    @MethodSource("provideHouseRobberTestCases")
    @DisplayName("Test house robber")
	void testHouseRobber(int[] nums,int expected) {
		int actual = Array.houseRobber(nums);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> provideHouseRobberTestCases() {
		return Stream.of(Arguments.of(new int[] { 1, 2, 3, 1 }, 4),
				Arguments.of(new int[] { 2, 7, 9, 3, 1 }, 12), 
				Arguments.of(new int[] { 1, 0, 0, 0, 0, 0, 0, 0, 0 }, 1),
				Arguments.of(new int[] { 1, 1, 1, 0, 0, 0 }, 2), 
				Arguments.of(new int[] { 0, 0, 0, 0, 0, 0, 0 }, 0)
			);
	}
	
	
	
}
