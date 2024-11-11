package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import static java.lang.Math.max;

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
	 * 17.Find given element is present or not in given array
	 * 18.Search in rotated sorted array
	 * 19.Permutations of Array
	 * 20.Combinations of Array
	 * 
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
	 * Output: 1 (index of peak element 8)
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
	
}
