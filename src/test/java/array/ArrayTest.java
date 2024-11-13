package array;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
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

}
