package array;

import static java.lang.Math.max;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Array {
	/*
	 * ================================== 
	 * Array Problems
	 * ==================================
	 *
	 * 1. Two Sum Problem
	 * 2. Two Sum II 
	 * 3. Merge Sorted Array's
	 * 4. Move Zero's to Beginning of the array
	 * 5. Sort Given Array
	 * 6. Reverse Array
	 * 7. Reverse Array With Frequency
	 * 8. Sliding window maximum
	 * 9. Max sum sub array
	 * 10.Max product sub array
	 * 11.Find K'th largest element in an array
	 * 12.Sub Array Sum equals to k
	 * 13.Finding Peak Element
	 * 14.Longest increasing sub array
	 * 15.Candy's Distribution
	 * 16.Median of Two Sorted Array's
	 * 17.Search in  sorted array (Binary Search)
	 * 18.Search in rotated sorted array
	 * 19.Permutations of Array
	 * 20.Combinations of Array
	 * 21.Rotate Array
	 * 22.Find First and last position of given element in sorted array
	 * 23.Spiral matrix
	 * 24.Rotate Image
	 * 25.Search in 2D array
	 * 26.Subsets
	 * 27.Pascal Triangle
	 * 28.Missing number
	 * 29.Majority element
	 * 30.Majority element II
	 * 31.Finding numbers whose nth digit is x
	 * 32.Remove Duplicates from sorted array
	 * 33.Frequeny of most frequency element
	 * 34.Highest occurring element in an array
	 * 35.Trapping rain water
	 * 36.Best Time to buy and sell stock
	 * 37.Merge Interval
	 * 38.Insert Interval
	 * 39.Finding Second Largest Element In UnSorted Array
	 * 40.Finding union of sorted arrays
	 */

	/**
	 * 1. Two Sum : Finds indices of two numbers in an array that add up to the target sum.
	 * 
	 * <p>This method uses a hash map to store the indices of elements, enabling an 
	 * efficient lookup for the complement (target - current element). If a pair is 
	 * found that adds up to the target, their indices are returned. If no such pair 
	 * exists, {-1, -1} is returned.</p>
	 * 
	 * <p><strong>Time Complexity:</strong> O(n), where n is the length of `nums`, since each element is checked once.</p>
	 * <p><strong>Space Complexity:</strong> O(n), due to the hash map storage.</p>
	 * 
	 * @param nums   the array of integers
	 * @param target the target sum to find
	 * @return an array with the indices of the two numbers that add up to `target`, or  {-1, -1} if no such pair exists
	 * 
	 * <pre>
	 * Example:
	 * Input: nums = [2, 7, 11, 15], target = 9
	 * Output: [0, 1] // Explanation: nums[0] + nums[1] == 9
	 * </pre>
	 */
	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement))
				return new int[] { map.get(complement), i };
			else
				map.put(nums[i], i);
		}
		return new int[] { -1, -1 };
	}
	
	/**
	 * 2. Two Sum II : Finds indices of two numbers in a sorted array that add up to the target sum.
	 * 
	 * <p>This method assumes nums array is sorted in ascending order. Using a two-pointer 
	 * approach, it identifies the indices of two elements whose sum matches the target.
	 * If no such pair exists, it returns {-1, -1}.</p>
	 * 
	 * <p><strong>Time Complexity:</strong> O(n), where n is the length of `nums`.</p>
	 * <p><strong>Space Complexity:</strong> O(1), as it uses only a constant amount of extra space for the pointers.</p>
	 * 
	 * @param nums   the sorted array of integers
	 * @param target the target sum to find
	 * @return an array with the indices of the two numbers that add up to `target`, or  {-1, -1} if no such pair exists
	 * 
	 * <pre>
	 * Example:
	 * Input: nums = [1, 2, 3, 4, 6], target = 6
	 * Output: [1, 3]
	 * </pre>
	 */
	public static int[] twoSumII(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		while (start < end) {
			int sum = nums[start] + nums[end];
			if (sum == target)
				return new int[] { start, end };
			else if (sum < target)
				start++;
			else
				end--;
		}

		return new int[] { -1, -1 };
	}
	
	/**
	 * 3. Merge Sorted Array's : Merges two sorted arrays into a single sorted array.
	 * 
	 * <p>Merges arrayOne and arrayTwo, both sorted in ascending order, into a new array.
	 * Elements are added in sorted order, ensuring the output array is also sorted.</p>
	 * 
	 * <p><strong>Time Complexity:</strong> O(n + m), where n and m are the lengths of the arrays.</p>
	 * <p><strong>Space Complexity:</strong> O(n + m), as a new array is created to store the merged output.</p>
	 * 
	 * @param arrayOne the first sorted array
	 * @param arrayTwo the second sorted array
	 * @return a new sorted array containing all elements from `arrayOne` and `arrayTwo`
	 * 
	 * <pre>
	 * Example:
	 * Input: arrayOne = [1, 3, 5], arrayTwo = [2, 4, 6]
	 * Output: [1, 2, 3, 4, 5, 6]
	 * </pre>
	 */
	public static int[] mergeSortedArrays(int[] arrayOne, int[] arrayTwo) {
		int[] mergedArray = new int[arrayOne.length + arrayTwo.length];
		int i = 0; // arrayOne Index
		int j = 0; // arrayTwo Index
		int k = 0; // mergedArray Index

		// Scenario 1 : if two array's have same length
		while (i < arrayOne.length && j < arrayTwo.length) 
			if (arrayOne[i] < arrayTwo[j])
				mergedArray[k++] = arrayOne[i++];
			else
				mergedArray[k++] = arrayTwo[j++];

		// Scenario 2 : if arrayOne length is greater than arrayTwo length
		while (i < arrayOne.length)
			mergedArray[k++] = arrayOne[i++];

		// Scenario 3 : if arrayOne length is less than arrayTwo length
		while (j < arrayTwo.length)
			mergedArray[k++] = arrayTwo[j++];

		return mergedArray;
	}
	
	/**
	 * 4. Move Zero's to Beginning : Moves all zeros in the given array to the beginning, preserving the order of non-zero elements.
	 * 
	 * <p>This method uses two pointers to iterate through the array from the end. 
	 * Non-zero elements are moved to the back while zeros accumulate at the start of the array.</p>
	 * 
	 * <p><strong>Time Complexity:</strong> O(n), where n is the length of the array, as it requires a single pass through the array.</p>
	 * <p><strong>Space Complexity:</strong> O(1), as it performs the operation in-place without requiring additional space.</p>
	 * 
	 * @param array the input array of integers in which zeros will be moved to the start
	 * @return the modified array with all zeros at the beginning
	 * 
	 * <pre>
	 * Example:
	 * Input:  [1, 0, 2, 0, 3]
	 * Output: [0, 0, 1, 2, 3]
	 * </pre>
	 */
	public static int[] moveZerosToStarting(int[] array) {
		int startIndex = 0;
		int endIndex = array.length - 1;
		int swappingIndex = array.length - 1;
		while (endIndex >= startIndex) {
			if (array[endIndex] != 0) {
				int temp = array[swappingIndex];
				array[swappingIndex--] = array[endIndex];
				array[endIndex] = temp;
			}
			endIndex--;
		}
		return array;
	}
	
	/**
	 * 5. Sort Given Array : Sorts the given array of integers in ascending order using a selection sort approach.
	 * 
	 * <p>This method iterates through the array and selects the smallest element in 
	 * each pass to place it in its correct position. An optimization is added to exit early 
	 * if the array is already sorted during any pass.</p>
	 * 
	 * <p><strong>Time Complexity:</strong> O(n^2) 😉 in the worst case due to nested loops.</p>
	 * <p><strong>Space Complexity:</strong> O(1) as it sorts the array in place.</p>
	 * 
	 * @param array the input array of integers to be sorted
	 * @return the sorted array in ascending order
	 * 
	 * <pre>
	 * Example:
	 * Input:  [3, 1, 4, 1, 5]
	 * Output: [1, 1, 3, 4, 5]
	 * </pre>
	 */
	public static int[] sortArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			Boolean swapHappend = false;
			for (int j = i; j < array.length; j++)
				if (array[i] >= array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
					swapHappend = true;
				}
			if (!swapHappend)
				break;
		}
		return array;
	}
	
	/**
	 * 6. Reverse Given Array : Reverses the given array of integers in place.
	 * 
	 * <p>This method swaps elements from the start and end of the array, moving towards the center, until the entire array is reversed.</p>
	 * 
	 * <p><strong>Time Complexity:</strong> O(n), where n is the length of the array, as each element is swapped only once.</p>
	 * <p><strong>Space Complexity:</strong> O(1) as it reverses the array in place.</p>
	 * 
	 * @param array the input array of integers to be reversed
	 * @return the reversed array
	 * 
	 * <pre>
	 * Example:
	 * Input:  [1, 2, 3, 4, 5]
	 * Output: [5, 4, 3, 2, 1]
	 * </pre>
	 */
	public static int[] reverseArray(int[] array) {
		int startIndex = 0;
		int endIndex = array.length - 1;
		while (startIndex < endIndex) {
			int temp = array[startIndex];
			array[startIndex++] = array[endIndex];
			array[endIndex--] = temp;
		}
		return array;
	}
	
	/**
	 * 7. Reverse Given Array By Frequency : Reverses the elements of the input array in segments, where each segment 
	 * has a length specified by the given frequency count. If the remaining elements 
	 * are fewer than the frequency count, only those elements are reversed.
	 * 
	 * <p><strong>Time Complexity:</strong> O(n), where n is the length of the array, as each element is accessed only once.</p>
	 * <p><strong>Space Complexity:</strong> O(1), as the array is modified in place.</p>
	 * 
	 * @param array the input array of integers to be reversed in segments
	 * @param frequencyCount the size of each segment to reverse
	 * @return the array with segments reversed based on frequency count
	 * 
	 * <pre>
	 * Example:
	 * Input:  array = [1, 2, 3, 4, 5, 6, 7], frequencyCount = 3
	 * Output: [3, 2, 1, 6, 5, 4, 7]
	 * </pre>
	 */
	public static int[] reverseArrayByFrequency(int[] array, int frequencyCount) {
		int startIndex = 0;
		int endIndex = array.length-1;
		while (startIndex <= endIndex) {
			int frequecyStart = startIndex;
			//If the calculated end index exceeds the array boundary take minimum
			int frequencyEnd = Math.min(startIndex + frequencyCount - 1, endIndex);
			while (frequecyStart < frequencyEnd) {
				int temp = array[frequecyStart];
				array[frequecyStart++] = array[frequencyEnd];
				array[frequencyEnd--] = temp;
			}
			//Move to next segment
			startIndex = startIndex + frequencyCount;
		}
		return array;
	}
	
	/**
	 * 8. Sliding window maximum : Computes the maximum value in each sliding window of a specified size over the input array.
	 * Each sliding window shifts one position to the right, calculating the maximum within that window.
	 * 
	 * <p><strong>Time Complexity:</strong> O(n * w), where n is array size, and w is window size, since each window requires iterating through up to w elements.</p>
	 * <p><strong>Space Complexity:</strong> O(n - w + 1), as we store the maximum for each window position.</p>
	 * 
	 * @param array the input array of integers
	 * @param windowSize the size of each sliding window
	 * @return an array containing the maximum values for each sliding window position
	 * 
	 * <pre>
	 * Example:
	 * Input:  array = [1, 3, -1, -3, 5, 3, 6, 7], windowSize = 3
	 * Output: [3, 3, 5, 5, 6, 7]
	 * </pre>
	 */
	public static int[] slidingWindowMaximum(int[] array, int windowSize) {
		int[] windowMaxElements = new int[array.length - windowSize + 1];
		int windowMaxElement = 0;
		int startIndex = 0;
		int endIndex = array.length-1;
		while (startIndex <= (endIndex - windowSize+1)) {
			int windowStart = startIndex;
			int windowEnd = startIndex + windowSize;
			int max = Integer.MIN_VALUE;
			while (windowStart < windowEnd) {
				max = Math.max(array[windowStart++], max);
			}
			windowMaxElements[windowMaxElement++] = max;
			startIndex++;
		}
		return windowMaxElements;
	}
	
	/**
	 * 9. Max sum sub array : Finds the maximum sum of any contiguous sub array within the input array using 
	 * Kadane's Algorithm. This approach efficiently calculates the maximum sum by iterating through the array only once.
	 * 
	 * <p><strong>Time Complexity:</strong> O(n), where n is the length of the array, as it iterates over the array a single time.</p>
	 * <p><strong>Space Complexity:</strong> O(1), as it uses only a fixed amount of extra space.</p>
	 * 
	 * @param array the input array of integers
	 * @return the maximum sum of any contiguous sub array
	 * 
	 * <pre>
	 * Example:
	 * Input:  array = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
	 * Output: 6 // because [4, -1, 2, 1] has the largest sum
	 * </pre>
	 */
	public static int maxSumSubArray(int[] array) {
		if (array.length == 1) return array[0];
		// Initialize to track the highest sum, even if all array values are negative
		Integer max = Integer.MIN_VALUE;
		Integer sum = 0;

		int startIndex = 0;
		int endIndex = array.length - 1;
		
		// Iterate over the array to find the maximum sub array sum
		while (startIndex <= endIndex) {
			sum = sum + array[startIndex++];
			
			// Update max if the current sum is greater
			if (max < sum) max = sum;
			
			// Reset sum if it becomes negative
			if (sum < 0) sum = 0;
		}
		return max;
	}
	
	/**
	 * 10.Max product sub array : Finds the maximum product of any contiguous sub array within the input array.
	 * This method handles positive, negative, and zero values by tracking both the maximum
	 * and minimum products at each position, ensuring the largest possible product is achieved
	 * even when negative values are encountered.
	 *
	 * <p><strong>Algorithm:</strong> This approach uses a dynamic programming technique by
	 * maintaining a running maximum and minimum product for each position, swapping them
	 * whenever a negative element is encountered, to correctly handle the sign change. The
	 * maximum product found so far is updated after each element.</p>
	 *
	 * <p><strong>Time Complexity:</strong> O(n), where n is the length of the array, as each element is processed once.</p>
	 * <p><strong>Space Complexity:</strong> O(1), since only a fixed amount of extra space is required to track the maximum, minimum, and result.</p>
	 *
	 * @param array the input array of integers
	 * @return the maximum product of any contiguous sub array
	 *
	 * <pre>
	 * Example:
	 * Input:  array = [2, 3, -2, 4]
	 * Output: 6  // Maximum product sub array is [2, 3]
	 *
	 * Input:  array = [-2, 0, -1]
	 * Output: 0  // Maximum product sub array is [0]
	 * </pre>
	 */
	public static int maxProductSubArray(int[] array) {
		// Edge case: empty array
	    if (array.length == 0) return 0; 
	    
	    // Edge case: single element array
	    if (array.length == 1) return array[0]; 

	    int maxProduct = array[0];
	    int minProduct = array[0];
	    int result = array[0];

	    for (int i = 1; i < array.length; i++) {
	    	// Swap when the current number is negative
	        if (array[i] < 0) {
	            int temp = maxProduct;
	            maxProduct = minProduct;
	            minProduct = temp;
	        }

	        // Update maxProduct and minProduct
	        maxProduct = Math.max(array[i], maxProduct * array[i]);
	        minProduct = Math.min(array[i], minProduct * array[i]);

	        // Update the overall result
	        result = Math.max(result, maxProduct);
	    }
	    return result;
	}
	
	/**
	 * 11. Find k-th largest element in an array : Find the k-th largest element in the given array using a Min-Heap (PriorityQueue).
	 * This approach maintains a min-heap of size k, ensuring that after processing all elements, the root of the heap contains the k-th largest element.
	 *
	 * <p><strong>Time Complexity:</strong> O(n log k), where n is the number of elements in the array. Each element insertion in the heap takes O(log k) time, and only the k largest elements are maintained.</p>
	 * <p><strong>Space Complexity:</strong> O(k), as only the k largest elements are stored in the heap.</p>
	 *
	 * @param array the input array of integers
	 * @param k the position of the largest element to find (1-based index)
	 * @return the k-th largest element in the array
	 *
	 * <pre>
	 * Example:
	 * Input:  array = [3, 2, 1, 5, 6, 4], k = 2
	 * Output: 5  // The second largest element is 5
	 *
	 * Input:  array = [3, 2, 3, 1, 2, 4, 5, 5, 6], k = 4
	 * Output: 4  // The fourth largest element is 4
	 * </pre>
	 */
	public static int findKthLargestElement(int[] array, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		int startIndex = 0;
		int endIndex = array.length - 1;
		while (startIndex <= endIndex) {
			queue.offer(array[startIndex++]);
			if (queue.size() > k) {
				queue.poll();
			}
		}
		return queue.poll();
	}
	
	/**
     * 12. Sub Array Sum equals to k : Finds the number of continuous subarrays in the input array `nums` whose sum equals `k`.
     *
     * <p><strong>Time Complexity:</strong> O(n), where n is the number of elements in the array, since we iterate through the array once.</p>
     * <p><strong>Space Complexity:</strong> O(n), for storing cumulative sums in the hash map.</p>
     *
     * @param nums the input array of integers
     * @param k the target sum for subarrays
     * @return the number of continuous subarrays that sum to `k`
     */
	public static int subArraySumEqualsToK(int[] array, int k) {
		int count = 0;
		int currentSum = 0;

		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int startIndex = 0;
		int endIndex = array.length - 1;
		while (startIndex <= endIndex) {
			currentSum = currentSum + array[startIndex++];
			int targetDifference = currentSum - k;
			if (map.containsKey(targetDifference)) {
				count = count + map.get(targetDifference);
			}
			map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
		}
		return count;
	}
	
	/**
	 * 13. Finding Peak Element: Finds a peak element in the given array. A peak element is an element that is
	 * greater than its immediate neighbors. If the array has multiple peaks, this 
	 * method returns the index of the first peak found while scanning from left to right.
	 * If no peak is found in the middle, the last element is considered a peak.
	 * 
	 * <p><strong>Time Complexity:</strong> O(n), where n is the length of the array.</p>
	 * <p><strong>Space Complexity:</strong> O(1), as no additional data structures are used.</p>
	 * 
	 * @param array the input array of integers
	 * @return the index of a peak element in the array
	 * 
	 * <pre>
	 * Example:
	 * Input:  array = [1, 3, 20, 4, 1, 0]
	 * Output: 2 (index of peak element 20)
	 * 
	 * Input:  array = [10, 8, 9]
	 * Output: 0 (index of peak element 10)
	 * </pre>
	 */
	public static int findPeakElement(int[] array) {
		for(int i=0;i<array.length-1;i++) {
			if(array[i]>array[i+1]) {
				return i;
			}
		}
		return array.length-1;
	}
	
	/**
	 * 14.Longest increasing sub array: The Longest Continuous Increasing Subsequence is a sequence of consecutive 
	 * elements in an array where each element is strictly greater than the previous one.
	 * 
	 * <p><strong>Time Complexity:</strong> O(n), where n is the length of the array, as we only make a single pass.
	 * <p><strong>Space Complexity:</strong> O(1), as we use only a few additional variables.
	 * 
	 * @param nums The input array of integers
	 * @return The length of the longest continuous increasing subsequence in the input array
	 * 
	 * <pre>
	 * Example:
	 * Input:  nums = [1, 3, 5, 4, 7]
	 * Output: 3
	 * Explanation: The longest continuous increasing subsequence is [1, 3, 5], with length 3.
	 * </pre>
	 */
	public static int longestIncreasingSubArray(int[] array) {
		int count = 0;
		int max = 0;
		for(int i=0;i<array.length-1;i++) {
			if(array[i]<array[i+1]) {
				count=count+1;
				max=max<count?count:max;
			}else {
				count=0;
			}
		}
		return max+1;// Adding 1 to account for the start of the subsequence
	}
	
	/**
     * 15.Candy's Distribution: Calculates the minimum candies needed to distribute to children such that:
     * 1. Each child has at least one candy.
     * 2. A child with a higher rating than their immediate neighbors gets more candies than them.
     * 
     * <p>The solution makes two passes over the ratings array:
     * <ol>
     * <li>A left-to-right pass to ensure each child with a higher rating than the previous child has more candies.</li>
     * <li>A right-to-left pass to ensure each child with a higher rating than the next child has more candies.</li>
     * </ol>
     * 
     * <p><strong>Time Complexity:</strong> O(n), where n is the number of children.
     * <p><strong>Space Complexity:</strong> O(n), due to the additional candies array.
     * 
     * @param array an array representing the ratings of each child
     * @return the minimum number of candies required
     * 
     * <pre>
     * Example:
     * Input:  [1, 0, 2]
     * Output: 5
     * Explanation: [2, 1, 2]
     * </pre>
     */
	public static int candyDistribution(int[] array) {
		int[] candies = new int[array.length];
		Arrays.fill(candies, 1);

		for (int i = 1; i < array.length; i++) {
			if (array[i] > array[i - 1]) {
				candies[i] = candies[i - 1] + 1;
			}
		}

		for (int i = array.length - 2; i >= 0; i--) {
			if (array[i] > array[i + 1]) {
				candies[i] = max(candies[i], candies[i + 1] + 1);
			}
		}
		return Arrays.stream(candies).sum();
	}
	
	/**
	 * 16.Median of Two Sorted Array's: Finds the median of two sorted arrays by merging them and calculating the median 
	 * based on the combined length.
	 * 
	 * <p><strong>Time Complexity:</strong> O(m + n), where m and n are the lengths of 
	 * the two arrays, as each element is accessed once during the merge.</p>
	 * <p><strong>Space Complexity:</strong> O(m + n), due to the storage of merged elements 
	 * in a new array.</p>
	 * 
	 * @param arrayOne the first sorted array of integers
	 * @param arrayTwo the second sorted array of integers
	 * @return the median of the merged sorted array
	 * 
	 * <pre>
	 * Example:
	 * Input:  arrayOne = [1, 3], arrayTwo = [2]
	 * Output: 2.0
	 * 
	 * Input:  arrayOne = [1, 2], arrayTwo = [3, 4]
	 * Output: 2.5
	 * </pre>
	 */
	public static double medianOfSortedArrays(int[] arrayOne, int[] arrayTwo) {
		int mergedArrayLength = arrayOne.length + arrayTwo.length;
		int[] mergedArray = new int[mergedArrayLength];
		int arrayOneIndex = 0;
		int arrayTwoIndex = 0;
		int mergingIndex = 0;
		
		//Case 1: Both arrays have same length
		while (arrayOneIndex < arrayOne.length && arrayTwoIndex < arrayTwo.length) {
			if (arrayOne[arrayOneIndex] < arrayTwo[arrayTwoIndex]) {
				mergedArray[mergingIndex++] = arrayOne[arrayOneIndex++];
			} else {
				mergedArray[mergingIndex++] = arrayTwo[arrayTwoIndex++];
			}
		}
		
		//Case 2: First Array Length is Greater than second array length
		while (arrayOneIndex < arrayOne.length) {
			mergedArray[mergingIndex++] = arrayOne[arrayOneIndex++];
		}
		
		//Case 3: Second array length is Greater than First Array Length
		while (arrayTwoIndex < arrayTwo.length) {
			mergedArray[mergingIndex++] = arrayTwo[arrayTwoIndex++];
		}
		
		// Calculate the median
		int mid = mergedArrayLength / 2;
		if (mergedArrayLength % 2 == 0) {
			return (mergedArray[mid-1] + mergedArray[mid])/2.0;
		} else {
			return mergedArray[mid];
		}
	}
	
    /**
     * 17. Search in sorted array : Searches for a target integer within a sorted array using binary search.
     * Returns the index of the target if found; otherwise, returns -1.
     * 
     * <p>This method is efficient for sorted arrays as it continuously divides the search space in half
     * until the target element is located, or until the search space is exhausted.</p>
     * 
     * <p><strong>Time Complexity:</strong> O(log n), where n is the length of the array, due to halving the search space with each iteration.</p>
     * <p><strong>Space Complexity:</strong> O(1), as it only requires a constant amount of extra space for the pointers.</p>
     * 
     * @param array the sorted array of integers to search within
     * @param k the target integer value to search for
     * @return the index of the target integer `k` if found, otherwise -1
     * 
     * <pre>
     * Example:
     * Input: array = [1, 2, 3, 4, 5], k = 3
     * Output: 2
     * 
     * Input: array = [1, 2, 3, 4, 5], k = 6
     * Output: -1
     * </pre>
     */
	public static int searchInSortedArray(int[] array, int target) {
		int startIndex = 0;
		int endIndex = array.length - 1;
		while (startIndex <= endIndex) {
			int mid = startIndex + (endIndex - startIndex) / 2;
			if (array[mid] == target) {
				return mid;
			} else if (array[mid] > target) {
				endIndex = mid - 1;
			} else {
				startIndex = mid + 1;
			}
		}
		return -1;
	}
	
	/**
     * 18. Search in rotated sorted array : Searches for a target integer in a rotated sorted array using modified binary search.
     * Returns the index of the target if found; otherwise, returns -1.
     * 
     * <p><strong>Time Complexity:</strong> O(log n), where n is the length of the array, as each step halves the search space.</p>
     * <p><strong>Space Complexity:</strong> O(1), because no additional space is used.</p>
     * 
     * @param array the rotated sorted array of integers
     * @param target the integer value to search for
     * @return the index of the target integer if found, otherwise -1
     * 
     * <pre>
     * Example:
     * Input: array = [4, 5, 6, 7, 0, 1, 2], target = 0
     * Output: 4
     * 
     * Input: array = [4, 5, 6, 7, 0, 1, 2], target = 3
     * Output: -1
     * </pre>
     */
	public static int searchInRotatedSortedArray(int[] array, int target) {
		int startIndex = 0;
		int endIndex = array.length - 1;
		while (startIndex <= endIndex) {
			int mid = startIndex + (endIndex - startIndex) / 2;

			if (array[mid] == target) {
				return mid;
			}

			if (array[startIndex] <= array[mid]) { // Left half is sorted
				if (target >= array[startIndex] && target < array[mid]) {
					endIndex = mid - 1;
				} else {
					startIndex = mid + 1;
				}
			} else { // Right half is sorted
				if (target > array[mid] && target <= array[endIndex]) {
					startIndex = mid + 1;
				} else {
					endIndex = mid - 1;
				}
			}
		}
		return -1;
	}
	
    /**
     * 19.Permutations of array : Generates all permutations of an array of integers using backtracking.
     * 
     * <p><strong>Time Complexity:</strong> O(n * n!), where n is the number of elements in the array. Generating each permutation takes O(n) time, and there are n! permutations.</p>
     * <p><strong>Space Complexity:</strong> O(n!), due to the storage of all generated permutations.</p>
     * 
     * @param array the array of integers for which to generate all permutations
     * @return a list of lists, where each inner list is a unique permutation of the input array
     * 
     * <pre>
     * Example:
     * Input: [1, 2, 3]
     * Output: [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
     * </pre>
     */
	public static List<List<Integer>> permutationsOfArray(int[] array){
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> list=new ArrayList<>();
		generatePermutations(array, list, result);
		return result;
	}
    private static void generatePermutations(int[] array, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == array.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < array.length; i++) {
            if (current.contains(array[i])) continue;
            current.add(array[i]);
            generatePermutations(array, current, result);
            current.remove(current.size() - 1); // Backtrack
        }
    }
    
    /**
     * 20. Combinations of array : Generates all possible combinations of length k from an array of integers.
     * 
     * <p><strong>Time Complexity:</strong> O(nCk), where n is the length of the array and k is the combination length. This represents the number of k-combinations for n items.</p>
     * <p><strong>Space Complexity:</strong> O(k), for the recursion stack depth due to storing intermediate subsets.</p>
     * 
     * @param array the array of integers to generate combinations from
     * @param k the desired combination length
     * @return a list of lists, where each inner list is a unique combination of k elements from the input array
     * 
     * <pre>
     * Example:
     * Input: array = [1, 2, 3], k = 2
     * Output: [[1, 2], [1, 3], [2, 3]]
     * </pre>
     */
    public static List<List<Integer>> combinationsOfArray(int[] array,int k){
    	List<List<Integer>> result = new ArrayList<>();
    	List<Integer> list=new ArrayList<>();
    	generateCombinations(array,k,0,list,result);
    	return result;
    }
    private static void generateCombinations(int[] array, int k, int index, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == k) { // Combination of length k reached
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < array.length; i++) {
            current.add(array[i]); // Include array[i]
            generateCombinations(array, k, i + 1, current, result); // Recursive call
            current.remove(current.size() - 1); // Backtrack by removing last added element
        }
    }
    
    /**
     * 21. Rotate Array : Rotates an array to the right by k positions.
     * 
     * <p><strong>Time Complexity:</strong> O(n), where n is the length of the array, because we iterate through the array elements three times during the reversal process.</p>
     * <p><strong>Space Complexity:</strong> O(1), as no additional space is used apart from a few variables.</p>
     * 
     * @param array the array to rotate
     * @param k the number of positions to rotate the array
     * @return the rotated array
     * 
     * <pre>
     * Example:
     * Input: array = [1, 2, 3, 4, 5, 6], k = 2
     * Output: [5, 6, 1, 2, 3, 4]
     * 
     * Input: array = [1, 2, 3], k = 4
     * Output: [3, 1, 2] (as k = 4 % 3 = 1)
     * </pre>
     */
    public static int[] rotateArray(int[] array,int k) {
    	k=k%array.length;//k must be within range of the array length.
    	swap(array,0,array.length-1);
    	swap(array,0,k-1);
    	swap(array,k,array.length-1);
    	return array;
    }
    
    private static void swap(int[] array,int startIndex,int endIndex) {
    	while(startIndex<endIndex) {
    		int temp=array[startIndex];
    		array[startIndex++]=array[endIndex];
    		array[endIndex--]=temp;
    	}
    }
    
    /**
     * 22.Find First and last position of given element in sorted array: Finds the first and last index of a given target in a sorted array.
     * 
     * <p><strong>Time Complexity:</strong> O(n), where n is the length of the array. The solution iterates over the array twice in the worst case.</p>
     * <p><strong>Space Complexity:</strong> O(1), as no additional space is used apart from a few variables.</p>
     * 
     * @param array the sorted array in which to search for the target
     * @param target the value to find in the array
     * @return an integer array with two elements: the first and last indices of the target in the array.
     * If the target is not found, returns [-1, -1].
     * 
     * <pre>
     * Example:
     * Input: array = [5, 7, 7, 8, 8, 10], target = 8
     * Output: [3, 4]
     * 
     * Input: array = [5, 7, 7, 8, 8, 10], target = 6
     * Output: [-1, -1]
     * 
     * Input: array = [], target = 0
     * Output: [-1, -1]
     * </pre>
     */
    public static int[] findFirstAndLastIndex(int[] array,int target) {
    	//Base Cases
    	if(array.length==0) return new int[] {-1,-1};
    	if(array.length==1 && array[0]==target) return new int[] {0,0};
    	if(array.length==1 && array[0]!=target) return new int[] {-1,-1};
    	
    	int startIndex = -1;
    	int endIndex   = -1;
    	boolean startFound = false;
    	//Finding firstIndex
    	for (int i = 0; i < array.length; i++) {
			if(array[i]==target) {
				if(!startFound) {
					startIndex=i;
					startFound=true;
					break;
				}
			}
		}
    	//Finding EndIndex
		if (startFound) {
			for (int i = startIndex; i < array.length; i++) {
				if (array[i] == target) {
					endIndex = i;
				}else {
					break;
				}
			}
		}
    	return new int[] {startIndex,endIndex};
    }
	
    /**
     * 23. Spiral Matrix : Traverses a 2D matrix in a spiral order and returns the result as a list of characters.
     * 
     * <p>
     * This method performs a spiral traversal of the input matrix, starting from the top-left
     * corner and moving right, down, left, and up repeatedly, narrowing the traversal range
     * at each step.
     * </p>
     * 
     * <p><strong>Time Complexity:</strong> O(m * n), where m is the number of rows and n is  the number of columns, as every element in the matrix is visited exactly once.</p>
     * <p><strong>Space Complexity:</strong> O(m * n), due to the storage of elements in the result list.</p>
     * 
     * @param array a 2D array of characters representing the matrix
     * @return a list of characters in spiral order
     * 
     * <pre>
     * Example:
     * Input: array = {
     *     {'A', 'B', 'C'},
     *     {'H', 'I', 'D'},
     *     {'G', 'F', 'E'}
     * }
     * Output: ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I']
     * </pre>
     */
	public static List<Character> spiralMatrix(char[][] array) {
		List<Character> result = new ArrayList<>();
		int rowStart = 0;
		int rowEnd = array.length - 1;
		int colStart = 0;
		int colEnd = array[0].length - 1;
		while (rowStart <= rowEnd && colStart <= colEnd) {
			for (int col = colStart; col <= colEnd; col++) {
				result.add(array[rowStart][col]);
			}
			rowStart++;
			for (int row = rowStart; row <= rowEnd; row++) {
				result.add(array[row][colEnd]);
			}
			colEnd--;
			if (rowStart <= rowEnd) {
				for (int col = colEnd; col >= colStart; col--) {
					result.add(array[rowEnd][col]);
				}
			}
			rowEnd--;
			if (colStart <= colEnd) {
				for (int row = rowEnd; row >= rowStart; row--) {
					result.add(array[row][colStart]);
				}
			}
			colStart++;
		}
		return result;
	}
	
	/**
	 * 24. Rotate Image : Rotates a given n x n 2D matrix 90 degrees clockwise.
	 * 
	 * <p>
	 * The method first transposes the matrix by swapping elements across its diagonal.
	 * Then, it reverses each row of the transposed matrix to achieve a clockwise rotation.
	 * </p>
	 * 
	 * <p><strong>Time Complexity:</strong> O(n^2), where n is the number of rows/columns in the matrix, as each element is accessed twice during transposition and reversal.</p>
	 * <p><strong>Space Complexity:</strong> O(1), as the rotation is done in place without 
	 * requiring additional space.</p>
	 * 
	 * @param array a 2D square matrix to be rotated
	 * @return the rotated 2D square matrix
	 * 
	 * <pre>
	 * Example:
	 * Input: array = {
	 *     {1, 2, 3},
	 *     {4, 5, 6},
	 *     {7, 8, 9}
	 * }
	 * Output: {
	 *     {7, 4, 1},
	 *     {8, 5, 2},
	 *     {9, 6, 3}
	 * }
	 * </pre>
	 */

	public static int[][] rotateImage(int[][] array) {
		int n=array.length;
		// Step 1: Transpose the matrix (swap elements across the diagonal)
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				int temp=array[i][j];
				array[i][j]=array[j][i];
				array[j][i]=temp;
			}
		}
		// Step 2: Reverse each row to complete the rotation
		for(int i=0;i<n;i++) {
			for(int j=0;j<n/2;j++) {
				int temp=array[i][j];
				array[i][j]=array[i][n-j-1];
				array[i][n-j-1]=temp;
			}
		}
		return array;
	}
	
	/**
	 * 25.Search in 2D array : Searches for a target value in a 2D matrix sorted in ascending order
	 * both row-wise and column-wise.
	 *
	 * <p><strong>Time Complexity:</strong> O(m + n), where m is the number of rows
	 * and n is the number of columns. Each iteration either decreases the column
	 * index or increases the row index.</p>
	 * 
	 * <p><strong>Space Complexity:</strong> O(1), as no additional space is used.</p>
	 *
	 * @param array 2D array where each row and column is sorted in ascending order
	 * @param target the value to search for in the matrix
	 * @return true if the target exists in the matrix, false otherwise
	 *
	 * <pre>
	 * Example:
	 * Input: array = [
	 *    [1, 3, 5],
	 *    [7, 9, 11],
	 *    [13, 15, 17]
	 * ], target = 9
	 * Output: true
	 * 
	 * Input: array = [
	 *    [1, 3, 5],
	 *    [7, 9, 11],
	 *    [13, 15, 17]
	 * ], target = 8
	 * Output: false
	 * </pre>
	 */
	public static Boolean searchIn2DArray(int[][] array, int target) {
		int row = array.length; // Number of rows
		int col = array[0].length; // Number of columns

		int i = 0; // Start from the top-right corner
		int j = col - 1;

		while (i < row && j >= 0) {
			if (array[i][j] == target) {
				return true;
			} else if (array[i][j] > target) {
				j--; // Move left in the current row
			} else {
				i++; // Move down in the current column
			}
		}
		return false; // Target not found
	}
	
	/**
	 * 26. Subsets : Generates all possible subsets (the power set) of a given array of integers.
	 *
	 * <p><strong>Time Complexity:</strong> O(2^n), where n is the length of the input array. Each element
	 * can either be included or excluded in a subset, leading to 2^n subsets.</p>
	 * 
	 * <p><strong>Space Complexity:</strong> O(2^n * n), as we store all subsets, each of which can have up to n elements.</p>
	 * 
	 * @param nums an array of integers for which subsets need to be generated
	 * @return a list of all possible subsets, where each subset is represented as a list of integers
	 * 
	 * <pre>
	 * Example:
	 * Input: nums = [1, 2, 3]
	 * Output: [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]
	 * 
	 * Input: nums = [0]
	 * Output: [[], [0]]
	 * </pre>
	 */
	public static List<List<Integer>> subsets(int[] nums){
	    List<List<Integer>> result = new ArrayList<>();
	    generateSubsets(0, nums, new ArrayList<>(), result);
	    return result;
	}
	private static void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
	    if (index == nums.length) {
	        result.add(new ArrayList<>(current));
	        return;
	    }

	    // Exclude the current element
	    generateSubsets(index + 1, nums, current, result);

	    // Include the current element
	    current.add(nums[index]);
	    generateSubsets(index + 1, nums, current, result);
	    current.remove(current.size() - 1); // Backtrack
	}
	
	/**
	 * 27.Pascal Triangle :  Generates Pascal's Triangle up to the specified number of rows.
	 *
	 * <p><strong>Time Complexity:</strong> O(n^2), where n is the number of rows. For each row, we compute its elements, which requires iterating over the row index.</p>
	 * <p><strong>Space Complexity:</strong> O(n^2), for storing all rows of Pascal's Triangle in the result list.</p>
	 * 
	 * @param numRows the number of rows in Pascal's Triangle
	 * @return a list of lists representing Pascal's Triangle, where each inner list corresponds to a row
	 * 
	 * <pre>
	 * Example:
	 * Input: numRows = 5
	 * Output: [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]]
	 * 
	 * Input: numRows = 1
	 * Output: [[1]]
	 * </pre>
	 */
	public static List<List<Integer>> pascalsTriangle(int numRows) {
		if(numRows<=0) {
			return List.of();
		}
		List<List<Integer>> res = new ArrayList<>();
		res.add(List.of(1));
		for (int i = 1; i < numRows; i++) {
			List<Integer> currentList = new ArrayList<>();
			List<Integer> prevList = res.get(i - 1);
			currentList.add(1);
			for (int j = 1; j < i; j++) {
				currentList.add(prevList.get(j) + prevList.get(j - 1));
			}
			currentList.add(1);
			res.add(currentList);
		}
		return res;
	}
	
	/**
	 * 28.Missing number : Finds the missing number in an array containing n distinct numbers
	 * taken from the range [0, n].
	 *
	 * <p><strong>Time Complexity:</strong> O(n), where n is the length of the array. The algorithm iterates over the array once to compute the sum.</p>
	 * <p><strong>Space Complexity:</strong> O(1), as it uses only constant extra space.</p>
	 *
	 * @param nums the input array containing n numbers from the range [0, n], with one number missing
	 * @return the missing number
	 * 
	 * <pre>
	 * Example:
	 * Input: nums = [3, 0, 1]
	 * Output: 2
	 * 
	 * Input: nums = [0, 1]
	 * Output: 2
	 * 
	 * Input: nums = [9,6,4,2,3,5,7,0,1]
	 * Output: 8
	 * </pre>
	 */
	public static int missingNumber(int[] nums) {
		int n=nums.length;
		int firstNnumbersSum = (n*(n+1))/2;
		int numsSum = 0;
		for(int i =0;i<n;i++) {
			numsSum+=nums[i];
		}
		return firstNnumbersSum-numsSum;
	}
	
	/**
	 * 29.Majority element: Finds the majority element in an array, which is the element that appears more than n/2 times,
	 * where n is the size of the array.
	 *
	 * <p><strong>Time Complexity:</strong> O(n), where n is the length of the array, as it iterates over the array  and map operations are O(1) on average.</p>
	 * <p><strong>Space Complexity:</strong> O(n), due to the storage of elements in the hashmap.</p>
	 * 
	 * @param nums the input array of integers
	 * @return the majority element if it exists, otherwise 0
	 * 
	 * <pre>
	 * Example:
	 * Input: nums = [3, 2, 3]
	 * Output: 3
	 * 
	 * Input: nums = [2, 2, 1, 1, 1, 2, 2]
	 * Output: 2
	 * 
	 * Input: nums = [1, 1, 1, 1]
	 * Output: 1
	 * </pre>
	 */
	public static int majorityElement(int[] nums) {
		Map<Integer,Integer> map = new HashMap<>();
		for(int i:nums) {
			map.put(i, map.getOrDefault(i, 0)+1);
		}
		int n=nums.length;
		for(int key:map.keySet()) {
			if(map.get(key)>n/2) {
				return key;
			}
		}
		return 0;
	}
	
	/**
	 * 30.Majority element II: Finds all elements in the array that appear more than ⌊n/3⌋ times, where n is the size of the array.
	 *
	 * <p><strong>Time Complexity:</strong> O(n), where n is the length of the array, as it iterates over the array  and map operations are O(1) on average.</p>
	 * <p><strong>Space Complexity:</strong> O(n), due to the storage of elements and their counts in the hashmap.</p>
	 * 
	 * @param nums the input array of integers
	 * @return a list of elements that appear more than ⌊n/3⌋ times
	 * 
	 * <pre>
	 * Example:
	 * Input: nums = [3, 2, 3]
	 * Output: [3]
	 * 
	 * Input: nums = [1]
	 * Output: [1]
	 * 
	 * Input: nums = [1, 2]
	 * Output: [1, 2]
	 * </pre>
	 */
	public static List<Integer> majorityElementII(int[] nums) {
		List<Integer> list = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums)
			map.put(i, map.getOrDefault(i, 0) + 1);
		for (Integer key : map.keySet())
			if (map.get(key) > nums.length / 3)
				list.add(key);
		return list;
	}
	
    /**
     * 31. Finds all numbers in the given array whose second digit (from the right) is 1.
     * <p>
     * The method checks each number and determines if the second digit is 1.
     * Single-digit numbers equal to 1 are also included in the result.
     * </p>
     *
     * <p><strong>Time Complexity:</strong> O(n * d), where n is the number of elements in the array and d is the number of digits per number (in worst case).</p>
     * <p><strong>Space Complexity:</strong> O(k), where k is the number of numbers that match the condition.</p>
     *
     * @param nums the input array of integers
     * @return a list of integers whose second digit is 1
     *
     * <pre>
     * Example:
     * Input: nums = [1, 12, 21, 31, 45, 105, 91]
     * Output: [1, 12, 21, 31, 91]
     *
     * Input: nums = [5, 10, 20, 210, 1001]
     * Output: [10, 210, 1001]
     *
     * Input: nums = [3, 4, 5]
     * Output: []
     * </pre>
     */
	public static List<Integer> numWith2ndDigitIs1(int[] nums) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if (num == 1) {
				list.add(num);
			} else {
				while (num > 0) {
					if (num != 1 && num < 99 && num % 10 == 1) {
						list.add(num);
					}
					num = num / 10;
				}
			}
		}
		return list;
	}

    /**
     * 32. Removes duplicate elements from a sorted integer array in-place and returns a new array containing only the unique elements while preserving the original order.
     * <p>
     * The input array must be sorted in non-decreasing order for this method to work correctly.
     * It uses two pointers (read and write indices) to overwrite duplicate values.
     * </p>
     *
     * <p><strong>Time Complexity:</strong> O(n), where n is the length of the array,
     * as each element is visited once.</p>
     * <p><strong>Space Complexity:</strong> O(n), due to creating a new array with
     * the unique elements (copying the modified range).</p>
     *
     * @param array the input sorted array of integers
     * @return a new array containing only unique elements from the input
     *
     * <pre>
     * Example:
     * Input: array = [1, 1, 2]
     * Output: [1, 2]
     *
     * Input: array = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]
     * Output: [0, 1, 2, 3, 4]
     *
     * Input: array = []
     * Output: []
     * </pre>
     */
	public static int[] removeDuplicatesInSortedArray(int[] array) {
		if (array.length <= 0) {
			return array;
		}
		int writeIndex = 1;
		int readIndex = 1;
		while (readIndex < array.length) {
			if (array[readIndex - 1] != array[readIndex]) {
				array[writeIndex++] = array[readIndex];
			}
			readIndex++;
		}
		return Arrays.copyOfRange(array, 0, writeIndex);
	}
	
    /**
     * 33. Finds the maximum frequency of any element in the array after performing at most {@code k} increment operations.
     * <p>
     * Each increment operation allows increasing any element by 1. The goal is to maximize the frequency
     * of a particular element. The method sorts the array and uses a sliding window to determine the largest
     * possible frequency achievable.
     * </p>
     *
     * <p><strong>Time Complexity:</strong> O(n log n), due to sorting the array.
     * The sliding window traversal runs in O(n).</p>
     * <p><strong>Space Complexity:</strong> O(1), as it uses only a few extra variables.</p>
     *
     * @param array the input array of integers
     * @param k the maximum number of increment operations allowed
     * @return the maximum frequency of any element after at most {@code k} operations
     *
     * <pre>
     * Example:
     * Input: array = [1, 2, 4], k = 5
     * Output: 3
     * Explanation: Increment 2 → 4 (2 times), increment 1 → 4 (3 times), making array [4, 4, 4].
     *
     * Input: array = [1, 4, 8, 13], k = 5
     * Output: 2
     * Explanation: Best we can do is make [4, 4, 8, 13] or [8, 8, 8, 13].
     *
     * Input: array = [3, 9, 6], k = 2
     * Output: 1
     * Explanation: With only 2 increments, we cannot make two numbers equal.
     * </pre>
     */
	public static int frequencyOfMostFrequentElement(int[] array,int k) {
		//Step 1 : Sort Array
		Arrays.sort(array);
		
		//Step 2 : Sliding Window
		int left=0,right=0;
		long sum=0,res=0;
		while (right < array.length) {
			// Add current element (expand the window to the right)
			sum = sum + array[right];
			
	        // Check if the window is valid:
	        // (array[right] * windowSize) = target sum if we want all elements in window = array[right]
	        // (sum + k) = max sum achievable with at most k increments
	        // If we can't reach the target, shrink the window from the left
			if (sum + k < array[right] * (long) (right - left + 1)) {
				// Remove leftmost element from sum
				sum = sum - array[left];
				
				// Move left pointer rightward (shrink window)
				left++;
			}
			 // Update result with the maximum valid window size so far
			res = Math.max(res, (long) right - left + 1);
			
			// Move right pointer to expand the window further
			right++;
		}
		// Result is the size of the largest valid window (max frequency achievable)
		return (int)res;
	}
	
    /**
     * 34. Finds the element that occurs most frequently in the given array.
     * <p>
     * If the array is empty, returns -1. In case of multiple elements with the same highest
     * frequency, this method returns the one encountered first during iteration of the map.
     * </p>
     *
     * <p><strong>Time Complexity:</strong> O(n), where n is the length of the array,
     * since each element is processed once and map operations are O(1) on average.</p>
     * <p><strong>Space Complexity:</strong> O(n), due to storing counts of unique elements in the map.</p>
     *
     * @param nums the input array of integers
     * @return the element with the highest frequency in the array,
     *         or {@code -1} if the array is empty
     *
     * <pre>
     * Example:
     * Input: nums = [1, 2, 3, 2, 4, 2]
     * Output: 2
     *
     * Input: nums = [5, 5, 6, 6, 7]
     * Output: 5   // or 6, depending on map iteration order
     *
     * Input: nums = []
     * Output: -1
     * </pre>
     */

	public static int highestOccurringElementInArray(int[] nums) {
		if (nums.length <= 0) {
			return -1;
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			if (map.containsKey(i)) {
				map.compute(i, (k, v) -> v + 1);
			} else {
				map.put(i, 1);
			}
		}
		AtomicInteger max = new AtomicInteger(Integer.MIN_VALUE);
		map.entrySet().stream().forEach(e -> {
			if (max.get() < e.getValue()) {
				max.set(e.getKey());
			}
		});
		return max.get();
	}
	
	/**
	 * 35. Trapping Rain Water : Calculates the total amount of rainwater that can be trapped 
	 * between the bars represented by the given elevation map.
	 *
	 * This algorithm uses a two-pointer approach to efficiently find the trapped water 
	 * by maintaining the maximum heights from both left and right sides.
	 *
	 * @param height The array representing the elevation map, where each element's value 
	 *               corresponds to the height of a bar.
	 * @return The total amount of water trapped between the bars.
	 *
	 * Sample Input:
	 * <pre>{@code
	 * int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
	 * int result = trappingRainWater(height);
	 * }</pre>
	 *
	 * Sample Output:
	 * <pre>{@code
	 * result = 6;
	 * }</pre>
	 *
	 * Time Complexity:
	 * - O(n): The array is traversed once using two pointers.
	 *
	 * Space Complexity:
	 * - O(1): Only a constant amount of extra space is used.
	 *
	 * Approach:
	 * - Use two pointers (`left` and `right`) starting from both ends of the array.
	 * - Maintain two variables, `maxLeftHeight` and `maxRightHeight`, to store the highest bars seen so far.
	 * - Move the pointer with the smaller height inward:
	 *   - If `height[left]` is smaller, trapped water depends on `maxLeftHeight`.
	 *   - If `height[right]` is smaller, trapped water depends on `maxRightHeight`.
	 * - Accumulate trapped water at each step.
	 */
	public static int trappingRainWater(int[] height) {
		int totalTrappedWater = 0; 		// Total water accumulated
		int left = 0; 					// Left pointer
		int right = height.length - 1; 	// Right pointer
		int maxLeftHeight = 0; 			// Highest bar from the left
		int maxRightHeight = 0; 		// Highest bar from the right

		// Process bars from both ends toward the center
		while (left <= right) {
			if (height[left] <= height[right]) {
				// If current left bar is lower, trapped water depends on maxLeftHeight
				if (height[left] < maxLeftHeight) {
					totalTrappedWater += maxLeftHeight - height[left];
				} else {
					maxLeftHeight = height[left];
				}
				left++;
			} else {
				// If current right bar is lower, trapped water depends on maxRightHeight
				if (height[right] < maxRightHeight) {
					totalTrappedWater += maxRightHeight - height[right];
				} else {
					maxRightHeight = height[right];
				}
				right--;
			}
		}

		return totalTrappedWater;
	}
	
	/**
	 * 36. Best Time to Buy and Sell Stock : Finds the maximum profit that can be achieved 
	 * by buying and selling a stock exactly once, given the stock prices on different days.
	 *
	 * The algorithm iterates through the array while tracking the minimum price so far 
	 * and calculating the maximum possible profit at each step.
	 *
	 * @param prices The array where each element represents the stock price on a given day.
	 * @return The maximum profit achievable from a single buy and sell transaction.
	 *         Returns 0 if no profit is possible.
	 *
	 * Sample Input:
	 * <pre>{@code
	 * int[] prices = {7, 1, 5, 3, 6, 4};
	 * int result = bestToBuySellStock(prices);
	 * }</pre>
	 *
	 * Sample Output:
	 * <pre>{@code
	 * result = 5; // Buy at 1 and sell at 6
	 * }</pre>
	 *
	 * Sample Input 2:
	 * <pre>{@code
	 * int[] prices = {7, 6, 4, 3, 1};
	 * int result = bestToBuySellStock(prices);
	 * }</pre>
	 *
	 * Sample Output 2:
	 * <pre>{@code
	 * result = 0; // No profit possible
	 * }</pre>
	 *
	 * Time Complexity:
	 * - O(n): Single traversal of the price array.
	 *
	 * Space Complexity:
	 * - O(1): Only constant extra variables used.
	 *
	 * Approach:
	 * - Keep track of the minimum price seen so far.
	 * - For each price, compute the potential profit (current price - minimum price).
	 * - Update the maximum profit if the current profit is higher.
	 */
	public static int bestToBuySellStock(int[] prices) {
		if (prices == null || prices.length == 0) {
			throw new IllegalArgumentException("Price array cannot be null or empty");
		}

		int minPrice = prices[0]; // Minimum stock price seen so far
		int maxProfit = 0; // Maximum profit achievable

		// Iterate over the prices to find max profit
		for (int i = 1; i < prices.length; i++) {
			// Update minimum price if current is lower
			minPrice = Math.min(minPrice, prices[i]);

			// Calculate profit if sold today, update max profit
			maxProfit = Math.max(maxProfit, prices[i] - minPrice);
		}
		return maxProfit;
	}
	
	/**
	 * 37. Merges all overlapping intervals into a list of disjoint intervals.
	 *
	 * <p>Example:</p>
	 * <pre>
	 * Input:  [[1,3],[2,6],[8,10],[15,18]]
	 * Output: [[1,6],[8,10],[15,18]]
	 * </pre>
	 *
	 * <p>Approach:</p>
	 * <ul>
	 *   <li>Sort intervals by start time.</li>
	 *   <li>Iterate through them, merging overlapping intervals on the go.</li>
	 *   <li>Use LinkedList to efficiently append or modify the last merged interval.</li>
	 * </ul>
	 *
	 * <p>Time Complexity: O(N log N) due to sorting.</p>
	 * <p>Space Complexity: O(N) for the merged output.</p>
	 */
	public static int[][] mergeIntervals(int[][] intervals) {
		if (intervals == null || intervals.length == 0)
			return new int[0][];

		// Step 1: Sort intervals by start time
		Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

		// Step 2: Use LinkedList for easy merging
		LinkedList<int[]> merged = new LinkedList<>();
		merged.add(intervals[0]);

		// Step 3: Merge overlapping intervals
		for (int[] current : intervals) {
			int[] last = merged.getLast();

			// If overlapping: merge by updating end boundary
			if (last[1] >= current[0]) {
				last[1] = Math.max(last[1], current[1]);
			}
			// If not overlapping: just add new interval
			else {
				merged.add(current);
			}
		}

		// Step 4: Convert list to array
		return merged.toArray(new int[merged.size()][]);
	}
	
	/**
	 * 38. Insert Interval : Inserts a new interval into a list of non-overlapping intervals 
	 * and merges overlapping intervals to produce the correct sorted list of intervals.
	 *
	 * The algorithm iterates through all existing intervals and merges any that overlap 
	 * with the new interval, ensuring the final list remains non-overlapping and sorted.
	 *
	 * @param intervals   A 2D array where each subarray represents an interval [start, end],
	 *                    and all intervals are initially sorted and non-overlapping.
	 * @param newInterval A single interval [start, end] to be inserted and merged.
	 * @return A new 2D array of merged intervals after inserting the new interval.
	 *
	 * Sample Input:
	 * <pre>{@code
	 * int[][] intervals = {{1, 3}, {6, 9}};
	 * int[] newInterval = {2, 5};
	 * int[][] result = insertInterval(intervals, newInterval);
	 * }</pre>
	 *
	 * Sample Output:
	 * <pre>{@code
	 * result = [[1, 5], [6, 9]];
	 * }</pre>
	 *
	 * Sample Input 2:
	 * <pre>{@code
	 * int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
	 * int[] newInterval = {4, 8};
	 * int[][] result = insertInterval(intervals, newInterval);
	 * }</pre>
	 *
	 * Sample Output 2:
	 * <pre>{@code
	 * result = [[1, 2], [3, 10], [12, 16]];
	 * }</pre>
	 *
	 * Time Complexity:
	 * - O(n): Each interval is visited once.
	 *
	 * Space Complexity:
	 * - O(n): Due to the output list of merged intervals.
	 *
	 * Approach:
	 * - If the new interval comes after the current interval, add the current interval.
	 * - If it comes before, add the new interval and make the current one the new interval.
	 * - If they overlap, merge them into a single interval by updating the start and end.
	 */
	public static int[][] insertInterval(int[][] intervals, int[] newInterval) {
		if (intervals == null || newInterval == null) {
			throw new IllegalArgumentException("Input intervals or new interval cannot be null");
		}

		LinkedList<int[]> mergedIntervals = new LinkedList<>();

		for (int[] current : intervals) {
			// Case 1: If the new interval is after the current one (newInterval[0] > current[1]), add the current one.
			if (newInterval[0] > current[1]) {
				mergedIntervals.add(current);
			}
			// Case 2: If the new interval is before the current one (newInterval[1] < current[0]), add the new one and make the current one the new interval to continue.
			else if (newInterval[1] < current[0]) {
				mergedIntervals.add(newInterval);
				newInterval = current; // Continue with current as new interval
			}
			// Case 3: Overlapping intervals → merge
			else {
				newInterval[0] = Math.min(current[0], newInterval[0]);
				newInterval[1] = Math.max(current[1], newInterval[1]);
			}
		}

		// Add the last interval
		mergedIntervals.add(newInterval);

		return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
	}
	
	/**
	 * 39. Finds the second largest distinct element in an integer array.
	 *
	 * <p>Example:</p>
	 * <pre>
	 * Input:  [7, 2, 5, 10, 8]
	 * Output: 8
	 *
	 * Input:  [3, 3, 3]
	 * Output: -1  (No distinct second maximum)
	 * </pre>
	 *
	 * <p>Approach:</p>
	 * <ul>
	 *   <li>Traverse the array once while keeping track of the largest and second-largest distinct numbers.</li>
	 *   <li>Update second largest whenever a new maximum is found or a value lies between max and second max.</li>
	 * </ul>
	 *
	 * <p>Time Complexity: O(N)</p>
	 * <p>Space Complexity: O(1)</p>
	 *
	 * @param nums the input array of integers
	 * @return the second largest distinct integer, or -1 if no such value exists
	 * @throws IllegalArgumentException if the array is null or empty
	 */
	public static Integer findSecondMax(int[] nums) {
		Integer max = nums[0];
		Integer secondMax = -1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > max) {
				secondMax = max;
				max = nums[i];
			}
			if (nums[i] > secondMax && nums[i] < max) {
				secondMax = nums[i];
			}
		}
		if(secondMax==max) {
			return -1;
		}
		return secondMax;
	}
	
	/**
	 * 40. Finds the union of two sorted integer arrays and returns a list of unique elements in ascending order.
	 *
	 * <p>The union of two arrays contains all distinct elements that appear in either array.</p>
	 *
	 * <p>Example:</p>
	 * <pre>
	 * Input:
	 *   arr1 = [1, 2, 2, 3, 4]
	 *   arr2 = [2, 3, 5, 5]
	 * Output:
	 *   [1, 2, 3, 4, 5]
	 * </pre>
	 *
	 * <p>Approach:</p>
	 * <ul>
	 *   <li>Uses two-pointer technique to traverse both sorted arrays simultaneously.</li>
	 *   <li>Skips duplicates within each array.</li>
	 *   <li>Adds the smaller element to the result list, or both if equal.</li>
	 * </ul>
	 *
	 * <p>Time Complexity: O(n + m) — where n and m are lengths of the input arrays.</p>
	 * <p>Space Complexity: O(n + m) — for storing the resulting union list.</p>
	 *
	 * @param firstArray the first sorted integer array
	 * @param secondArray the second sorted integer array
	 * @return a list of unique integers representing the union of both arrays
	 * @throws IllegalArgumentException if either array is null
	 */
	public static List<Integer> findingUnionOfArrays(int[] firstArray, int[] secondArray) {
	    if (firstArray == null || secondArray == null) {
	        throw new IllegalArgumentException("Input arrays cannot be null");
	    }

	    List<Integer> unionList = new ArrayList<>();
	    int i = 0, j = 0;

	    // Traverse both arrays using two-pointer technique
	    while (i < firstArray.length && j < secondArray.length) {
	        // Skip duplicates in both arrays
	        if (i > 0 && firstArray[i] == firstArray[i - 1]) {
	            i++;
	            continue;
	        }
	        if (j > 0 && secondArray[j] == secondArray[j - 1]) {
	            j++;
	            continue;
	        }

	        // Compare and add smaller element, or advance both pointers if equal
	        if (firstArray[i] < secondArray[j]) {
	            unionList.add(firstArray[i++]);
	        } else if (firstArray[i] > secondArray[j]) {
	            unionList.add(secondArray[j++]);
	        } else {
	            unionList.add(firstArray[i]);
	            i++;
	            j++;
	        }
	    }

	    // Process remaining elements in first array
	    while (i < firstArray.length) {
	        if (i == 0 || firstArray[i] != firstArray[i - 1]) {
	            unionList.add(firstArray[i]);
	        }
	        i++;
	    }

	    // Process remaining elements in second array
	    while (j < secondArray.length) {
	        if (j == 0 || secondArray[j] != secondArray[j - 1]) {
	            unionList.add(secondArray[j]);
	        }
	        j++;
	    }

	    return unionList;
	}
}
