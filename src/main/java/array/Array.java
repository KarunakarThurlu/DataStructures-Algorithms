package array;

import static java.lang.Math.max;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

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
	 * 33.Frequency of most frequency element
	 * 34.Highest occurring element in an array
	 * 35.Trapping rain water
	 * 36.Best Time to buy and sell stock
	 * 37.Merge Interval
	 * 38.Insert Interval
	 * 39.Finding Second Largest Element In UnSorted Array
	 * 40.Finding union of sorted arrays
	 * 41.Max consecutive ones
	 * 42.Single element
	 * 43.Minimum jumps to reach end
	 * 44.Longest Subarray with Sum K
	 * 45.Check array is sorted and rotated
	 * 46.Jump game can we reach at end of array or not
	 * 47.Sort the array that contains 0's, 1's and 2's only
	 * 48.Colorful rope
	 * 49.Coin change
	 * 50.Next Permutation
	 * 51.Leaders in an array
	 * 52.Longest consecutive sequence
	 * 53.Set matrix zeros
	 * 54.Three sum
	 * 55.Largest sub array sum with 0 
	 * 56.Count number of sub array's with given sum
	 * 57.Rotate the matrix by 90 degrees
	 * 58.Search insert position
	 * 59.Find floor and ceil value of target
	 * 60.First and last position of target in sorted array
	 * 61.Count occurrences of a number in a sorted array with duplicates
	 * 62.Search in Rotated Sorted Array I
	 * 63.Search in Rotated Sorted Array II
	 * 64.Find minimum in Rotated Sorted Array
	 * 65.Find out how many times has an array been rotated
	 * 66.Single element in a Sorted Array
	 * 67.Find square root of a number in log n
	 * 68.Koko eating bananas
	 * 69.Minimum number of days to make m buckets
	 * 70.Search in 2D array II
	 * 71.Find Equilibrium
	 * 72.Count Zeros
	 * 73.Intersection of two array's
	 * 74.Intersection of two array's II
	 * 75.Find smallest letter grater than target
	 * 76.Container with most water
	 * 77.House Robber
	 * 78.House Robber II
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

	    int maxEndingHere  = array[0];
	    int minEndingHere  = array[0];
	    int maxSoFar = array[0];

	    for (int i = 1; i < array.length; i++) {
	    	// Swap when the current number is negative
	        if (array[i] < 0) {
	            int temp = maxEndingHere;
	            maxEndingHere = minEndingHere;
	            minEndingHere = temp;
	        }

	        // Update maxProduct and minProduct
	        maxEndingHere = Math.max(array[i], maxEndingHere * array[i]);
	        minEndingHere = Math.min(array[i], minEndingHere * array[i]);

	        // Update the overall result
	        maxSoFar = Math.max(maxSoFar, maxEndingHere);
	    }
	    return maxSoFar;
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
     * Input: array = [5, 7, 7, 8, 8, 10], target = 8 Output: [3, 4]
     * Input: array = [5, 7, 7, 8, 8, 10], target = 6 Output: [-1, -1]
     * Input: array = [], target = 0 Output: [-1, -1]
     * </pre>
     * 
     * @param sortedArray sorted input array
     * @param targetValue value to search
     * @return array of size 2 → [firstIndex, lastIndex]
     */
	public static int[] findFirstAndLastIndex(int[] sortedArray, int targetValue) {
        int[] resultIndices = { -1, -1 };
        if (sortedArray == null || sortedArray.length == 0)
            return resultIndices;
        resultIndices[0] = findBoundary(sortedArray, targetValue, true);
        resultIndices[1] = findBoundary(sortedArray, targetValue, false);
        return resultIndices;
	}
	
	private static int findBoundary(int[] array, int target, boolean searchFirst) {
		int leftPointer = 0;
		int rightPointer = array.length - 1;
		int boundaryIndex = -1;
		while (leftPointer <= rightPointer) {
			int midIndex = leftPointer + (rightPointer - leftPointer) / 2;
			if (array[midIndex] == target) {
				boundaryIndex = midIndex;
				if (searchFirst)// Move towards left boundary
					rightPointer = midIndex - 1;
				else // Move towards right boundary
					leftPointer = midIndex + 1;
			} else if (array[midIndex] < target) {
				leftPointer = midIndex + 1;
			} else {
				rightPointer = midIndex - 1;
			}
		}
		return boundaryIndex;
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
	
	/**
	 * 41. Finds the length of the longest consecutive sequence of 1s in a binary array.
	 *
	 * <p>This method scans the array and counts consecutive 1s. 
	 * Whenever a 0 is encountered, the counter resets to zero.
	 * The maximum streak of 1s encountered during traversal is returned.</p>
	 *
	 * <p>Example:</p>
	 * <pre>
	 * Input:  [1, 1, 0, 1, 1, 1]
	 * Output: 3
	 * Explanation: The longest consecutive run of 1s is of length 3.
	 * </pre>
	 *
	 * <p>Time Complexity: O(n) — single pass through the array.</p>
	 * <p>Space Complexity: O(1) — only uses constant extra variables.</p>
	 *
	 * @param nums an integer array consisting of 0s and 1s
	 * @return the maximum number of consecutive 1s
	 * @throws IllegalArgumentException if the input array is null
	 */
	public static int maxConsicutiveOnes(int[] nums) {
		if (nums == null) {
			throw new IllegalArgumentException("Input array cannot be null");
		}

		int currentCount = 0; // Tracks current streak of consecutive 1s
		int maxCount = 0; // Stores the maximum streak found so far

		for (int num : nums) {
			if (num == 1) {
				currentCount++; // Continue current streak
				maxCount = Math.max(maxCount, currentCount); // Update max if needed
			} else {
				currentCount = 0; // Reset streak when 0 encountered
			}
		}
		return maxCount;
	}
	
	/**
	 * 42. Finds the unique element in an array where every other element appears exactly twice.
	 *
	 * <p>This method uses a {@link java.util.HashSet} to track elements:
	 * - If a number is seen for the first time, it is added to the set.
	 * - If it appears again, it is removed.
	 * After processing all numbers, the remaining element in the set is the single (non-duplicate) number.</p>
	 *
	 * <p>Example:</p>
	 * <pre>
	 * Input:  [4, 1, 2, 1, 2]
	 * Output: 4
	 * Explanation: Every element appears twice except for 4, which appears once.
	 * </pre>
	 *
	 * <p>Time Complexity: O(n) — iterates once through the array.</p>
	 * <p>Space Complexity: O(n) — uses a set to store unique elements.</p>
	 *
	 * @param nums an array of integers where exactly one element appears once and all others appear twice
	 * @return the single non-duplicate number
	 * @throws IllegalArgumentException if the input array is null or empty
	 */
	public static Integer singleNumber(int[] nums) {
		int result = 0;
		for (int n : nums) {
			result ^= n; // XOR cancels out duplicate numbers
		}
		return result;
	}
	
	/**
	 * 43. Minimum jumps to reach end
	 *
	 * <p>Each element in the array represents your maximum jump length at that position.
	 * The goal is to determine the fewest jumps needed to reach the last index starting from index 0.</p>
	 *
	 * <p>Algorithm (Greedy approach):</p>
	 * <ul>
	 *   <li>Traverse the array while keeping track of the farthest position you can reach (`maxReach`).</li>
	 *   <li>Use `currentPos` to mark the end of the current jump's range.</li>
	 *   <li>When you reach the end of this range (i.e., `i == currentPos`), it means you must jump — increment `jumps` and update `currentPos` to `maxReach`.</li>
	 * </ul>
	 *
	 * <p>Example:</p>
	 * <pre>
	 * Input:  [2, 3, 1, 1, 4]
	 * Output: 2
	 * Explanation: Jump from index 0 → 1 (reach index 1), then index 1 → 4 (reach the end).
	 *
	 * Input:  [2, 1]
	 * Output: 1
	 * </pre>
	 *
	 * <p>Time Complexity:</p> O(n) — single traversal of the array.  
	 * <p>Space Complexity:</p> O(1) — only uses constant extra variables.</p>
	 *
	 * @param nums an integer array where each element represents the maximum jump length from that position
	 * @return the minimum number of jumps required to reach the last index
	 */
	public static int minJumps(int[] nums) {
		if (nums.length == 1) {
			return 0; // Already at the last index
		}

		int jumps = 0; 		// Counts the number of jumps made
		int maxReach = 0; 	// The farthest index reachable so far
		int currentPos = 0; // The end of the current jump range
		int n = nums.length;

		for (int i = 0; i < n - 1; i++) {
			// Update the farthest we can reach from current position
			maxReach = max(maxReach, i + nums[i]);

			// If we reach the end of the range of the current jump
			if (i == currentPos) {
				jumps++; // We need to make another jump
				currentPos = maxReach; // Update the new range end
			}
		}
		return jumps;
	}
	
	/**
	 * 44. Finds the length of the longest subarray whose sum equals the given target {@code k}.
	 *
	 * <p>This method uses a prefix-sum and HashMap approach to efficiently track cumulative sums
	 * and their earliest occurrence indices. For each element, it checks whether a previous prefix sum
	 * exists such that the difference between the current sum and that prefix equals {@code k}.
	 * If found, it calculates the subarray length and updates the maximum length accordingly.</p>
	 *
	 * <p>Example:</p>
	 * <pre>
	 * Input:  nums = [10, 5, 2, 7, 1, 9], k = 15
	 * Output: 4
	 * Explanation: The subarray [5, 2, 7, 1] sums to 15 and has length 4.
	 * </pre>
	 *
	 * <p>Time Complexity: O(n) — each element is processed once.</p>
	 * <p>Space Complexity: O(n) — stores prefix sums in a HashMap.</p>
	 *
	 * @param nums an integer array that may contain positive, negative, or zero values
	 * @param k the target sum to find among subarrays
	 * @return the maximum length of a subarray whose sum equals {@code k};
	 *         returns 0 if no such subarray exists
	 */
	public static int maxLengthSubarray(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int maxLength = 0, sum = 0;
		for (int i = 0; i < nums.length; i++) {
			// calculate the prefix sum till index i:
			sum = sum + nums[i];

			// Store the first occurrence of a prefix sum only
			map.putIfAbsent(sum, i);

			// if the sum = k, update the maxLen:
			if (sum == k) {
				maxLength = i + 1;
			}

			// calculate the sum of remaining part i.e. x-k:
			int remaining = sum - k;

			// If there exists a previous prefix sum (sum - k), it means the subarray between that index + 1 and i sums to k.
			if (map.containsKey(remaining)) {
				int length = i - map.get(remaining);
				maxLength = Math.max(maxLength, length);
			}

		}
		return maxLength;
	}
	
	/**
	 * 45. Checks whether the given array is sorted in ascending order and then rotated.
	 *
	 * <p>An array is considered sorted and rotated if it can be obtained
	 * by rotating a sorted (ascending) array some number of times.
	 * 
	 * For example:
	 * <pre>
	 * [3, 4, 5, 1, 2] → true  (rotation of [1, 2, 3, 4, 5])
	 * [1, 2, 3, 4, 5] → true  (no rotation, still sorted)
	 * [2, 1, 3, 4, 5] → false (not a valid rotation of a sorted array)
	 * </pre>
	 *
	 * <p>Logic:</p>
	 * - Traverse the array and count how many times the current element
	 *   is greater than the next element (considering circular rotation).
	 * - If this happens more than once, the array is not sorted and rotated.
	 *
	 * <p>Time Complexity:</p> O(n) — single pass through the array.
	 * <p>Space Complexity:</p> O(1) — uses only a few variables.
	 *
	 * @param arr the input integer array
	 * @return {@code true} if the array is sorted and rotated; {@code false} otherwise
	 */
	public static boolean checkArrayIsSortedRoatated(int[] arr) {
		int breakCount = 0; // Counts the number of places where the ascending order breaks
		int n = arr.length;

		for (int i = 0; i < n; i++) {
			// Compare each element with its next (circularly using modulo)
			// If current > next, it's a "break" in sorted order
			if (arr[i] > arr[(i + 1) % n]) {
				breakCount++;
			}
		}

		// Valid rotated sorted array has at most one such break
		return breakCount <= 1;
	}
	
	/**
	 * 46. Jump game can we reach at end of array or not
	 *
	 * <p>Each element in the array represents the maximum jump length at that position.
	 * The goal is to check whether you can start at index 0 and reach the last index.</p>
	 *
	 * <p>Algorithm:</p>
	 * - Iterate through the array while maintaining the farthest index you can reach (`maxReach`).
	 * - If at any point the current index `i` exceeds `maxReach`, it means you cannot move further — return false.
	 * - Update `maxReach` as the maximum of its current value and `i + nums[i]` (the new reach from this index).
	 * - If you finish the loop, you can reach the end — return true.
	 *
	 * <p>Example:</p>
	 * <pre>
	 * Input:  [2, 3, 1, 1, 4]
	 * Output: true
	 * Explanation: Jump 1 step to index 1, then 3 steps to the end.
	 *
	 * Input:  [3, 2, 1, 0, 4]
	 * Output: false
	 * Explanation: You will get stuck at index 3.
	 * </pre>
	 *
	 * <p>Time Complexity:</p> O(n) — single traversal of the array.
	 * <p>Space Complexity:</p> O(1) — only uses a few extra variables.
	 *
	 * @param nums an integer array where each element represents the maximum jump length
	 * @return {@code true} if it is possible to reach the last index; {@code false} otherwise
	 */
	public static boolean jumpGame(int[] nums) {
		int maxReach = 0; // The farthest index we can reach so far
		int n = nums.length;

		for (int i = 0; i < n; i++) {
			// If the current index is beyond our maximum reachable index, we can't move forward
			if (maxReach < i) {
				return false;
			}

			// Update the farthest reachable index from the current position
			maxReach = Math.max(maxReach, i + nums[i]);
		}

		// If we finished the loop, we can reach the last index
		return true;
	}
	
	/**
	 * 47. Sorts an array containing only 0s, 1s, and 2s in ascending order (0s → 1s → 2s).
	 * 
	 * <p>This method uses a simple two-pass approach:
	 * <ul>
	 *   <li>In the first pass, it moves all 0s to the beginning of the array.</li>
	 *   <li>In the second pass, it moves all 1s next to the 0s.</li>
	 *   <li>The remaining elements (2s) are already in the correct position.</li>
	 * </ul>
	 * 
	 * <p>Although this solution runs in O(n) time, it performs two passes through the array
	 * (less optimal than the single-pass Dutch National Flag algorithm). However, it is simple
	 * and easy to understand.
	 *
	 * @param nums an integer array containing only 0s, 1s, and 2s
	 * @return the same array sorted in-place
	 *
	 * <p><b>Example:</b>
	 * <pre>
	 * Input:  [0, 2, 1, 2, 0, 1]
	 * Output: [0, 0, 1, 1, 2, 2]
	 * </pre>
	 */
	public static int[] sort012s(int[] nums) {
		int low = 0; // Boundary for 0s
		int mid = 0; // Current element
		int high = nums.length - 1; // Boundary for 2s

		while (mid <= high) {
			if (nums[mid] == 0) {
				// Swap current element with boundary of 0s
				int temp = nums[low];
				nums[low] = nums[mid];
				nums[mid] = temp;
				low++;
				mid++;
			} else if (nums[mid] == 1) {
				// Move mid pointer
				mid++;
			} else {
				// Swap current element with boundary of 2s
				int temp = nums[mid];
				nums[mid] = nums[high];
				nums[high] = temp;
				high--;
			}
		}
		return nums;
	}
	
	/**
	 * 48. Colorful rope
	 * Calculates the minimum total time required to remove balloons from a rope so that 
	 * no two adjacent balloons have the same color.
	 * 
	 * <p>Each balloon has a color and a time value representing how long it takes to remove it. 
	 * If two adjacent balloons have the same color, one of them must be removed to make all 
	 * adjacent balloons distinct. The goal is to minimize the total time spent removing balloons.</p>
	 * 
	 * <p>The algorithm iterates once through the string. For every consecutive pair of 
	 * same-colored balloons, it removes the one with the smaller removal time and carries 
	 * forward the larger time to ensure the next comparison uses the correct reference.</p>
	 * 
	 * <p><b>Example:</b></p>
	 * <pre>
	 * Input:
	 *   colors = "aabaa"
	 *   time   = [1, 2, 3, 4, 1]
	 *
	 * Output: 2
	 *
	 * Explanation:
	 *   - Between the first two 'a's → remove the first (min(1,2) = 1)
	 *   - Between the last two 'a's  → remove the last  (min(4,1) = 1)
	 *   Total = 1 + 1 = 2
	 * </pre>
	 * 
	 * <p><b>Time Complexity:</b> O(n) — single linear pass through the string.</p>
	 * <p><b>Space Complexity:</b> O(1) — operates in place using the input array.</p>
	 * 
	 * @param colors a string representing balloon colors
	 * @param time an array of integers where time[i] is the time to remove the i-th balloon
	 * @return the minimum total time needed to remove balloons such that no two adjacent balloons have the same color
	 */
	public static int colorfulRope(String colors, int[] time) {
		int minTime = 0;

	    // Start from the second balloon to compare each with its previous one
	    for (int i = 1; i < colors.length(); i++) {

	        // If two adjacent balloons have the same color, one must be removed
	        if (colors.charAt(i) == colors.charAt(i - 1)) {

	            // Remove the one with smaller removal time (to minimize total cost)
	            minTime += Math.min(time[i], time[i - 1]);

	            // Keep the larger removal time as the "surviving" balloon's cost so it can be compared with the next balloon if needed
	            time[i] = Math.max(time[i], time[i - 1]);
	        }
	    }
	    return minTime;
	}
	
	/**
	 * 49. Solves the Coin Change problem using Dynamic Programming (Bottom-Up approach).
	 *
	 * <p>This method computes the minimum number of coins required to make up a given `amount`
	 * using the provided denominations in the `coins` array. If it's impossible to form
	 * the target amount using any combination of the given coins, the method returns -1.</p>
	 *
	 * <p>Example:</p>
	 * <pre>
	 * Input:
	 *   coins = [1, 2, 5]
	 *   amount = 11
	 *
	 * Output:
	 *   3
	 *
	 * Explanation:
	 *   The minimum number of coins to make 11 is 3 (5 + 5 + 1).
	 * </pre>
	 *
	 * <p>Dynamic Programming Recurrence Relation:</p>
	 * <pre>
	 * dp[i] = min(1 + dp[i - coin]) for each coin <= i
	 * dp[0] = 0
	 * </pre>
	 *
	 * <p>Time Complexity: O(n * m)</p>
	 * where:
	 * - n = target amount
	 * - m = number of coin denominations
	 *
	 * <p>Space Complexity: O(n)</p>
	 * — uses a 1D DP array of size `amount + 1`.</p>
	 *
	 * @param coins an array of available coin denominations
	 * @param amount the target amount to form
	 * @return the minimum number of coins required, or -1 if impossible
	 */
	public static int coinChange(int[] coins, int amount) {
		int[] minCoins = new int[amount + 1];
		Arrays.fill(minCoins, amount + 1); // initialize with large number (acts as infinity)
		minCoins[0] = 0; // base case

		// Build up solutions for all amounts up to target
		for (int i = 1; i <= amount; i++) {
			for (int coin : coins) {
				if (i - coin >= 0) {
					minCoins[i] = Math.min(minCoins[i], 1 + minCoins[i - coin]);
				}
			}
		}
		return minCoins[amount] != amount + 1 ? minCoins[amount] : -1;
	}
	
	/**
	 * 50. Next permutation
	 * Rearranges the given array of integers into the lexicographically next greater permutation.
	 * <p>
	 * If no such permutation exists (i.e., the array is in descending order),
	 * it rearranges the numbers into the lowest possible order (ascending).
	 * <p>
	 * This method modifies the input array in place and also returns it for convenience.
	 * <p>
	 * <b>Example 1:</b><br>
	 * Input:  [1, 2, 3]<br>
	 * Output: [1, 3, 2]
	 * <p>
	 * <b>Example 2:</b><br>
	 * Input:  [3, 2, 1]<br>
	 * Output: [1, 2, 3]
	 * <p>
	 * <b>Example 3:</b><br>
	 * Input:  [1, 1, 5]<br>
	 * Output: [1, 5, 1]
	 * <p>
	 * <b>Algorithm Steps:</b>
	 * <ol>
	 *   <li>Find the first index <code>pivot</code> from right to left where <code>nums[pivot] &lt; nums[pivot + 1]</code>.</li>
	 *   <li>If no pivot is found, reverse the entire array (already the highest permutation).</li>
	 *   <li>Otherwise, find the smallest element on the right side of the pivot that is greater than <code>nums[pivot]</code>.</li>
	 *   <li>Swap the pivot and that element.</li>
	 *   <li>Reverse the subarray to the right of the pivot to get the smallest possible order.</li>
	 * </ol>
	 *
	 * @param nums an array of integers representing the current permutation
	 * @return the modified array representing the next lexicographical permutation
	 */
	public static int[] nextPermutation(int[] nums) {
	    int n = nums.length;
	    int pivotIndex = -1;

	    // Step 1: Find pivot
	    for (int i = n - 2; i >= 0; i--) {
	        if (nums[i] < nums[i + 1]) {
	            pivotIndex = i;
	            break;
	        }
	    }

	    // Step 2: Reverse if already descending
	    if (pivotIndex == -1) {
	       return reverseArray(nums);
	    }

	    // Step 3: Find rightmost successor and swap
	    for (int i = n - 1; i > pivotIndex; i--) {
	        if (nums[i] > nums[pivotIndex]) {
	        	swap(nums, pivotIndex, i);
	            break;
	        }
	    }

	    // Step 4: Reverse the suffix
	    reverse(nums, pivotIndex + 1);
	    return nums;
	}

	private static void reverse(int[] nums, int start) {
		int end = nums.length - 1;
		while (start < end) {
			swap(nums, start++, end--);
		}
	}
	
	/**
	 * 51. Finds all the "leaders" in the given array.
	 * <p>
	 * A leader is an element that is greater than or equal to all the elements to its right.
	 * The rightmost element of the array is always considered a leader.
	 * <p>
	 * The method traverses the array from right to left, keeps track of the current maximum (leader),
	 * and adds any number that is greater than or equal to this maximum.
	 * <p>
	 * Finally, the list of leaders is reversed to maintain the original left-to-right order of appearance.
	 * <p>
	 * <b>Example 1:</b><br>
	 * Input:  [16, 17, 4, 3, 5, 2]<br>
	 * Output: [17, 5, 2]
	 * <p>
	 * <b>Example 2:</b><br>
	 * Input:  [10, 9, 8, 7]<br>
	 * Output: [10, 9, 8, 7]
	 *
	 * @param nums the input array of integers
	 * @return a list of leader elements in the array (in the same order as they appear)
	 */
	public static List<Integer> findLeaders(int[] nums) {
	    List<Integer> leaders = new ArrayList<>();

	    int n = nums.length;
	    // Step 1: Initialize the last element as the rightmost leader
	    int leader = nums[n - 1];
	    leaders.add(leader);

	    // Step 2: Traverse the array from right to left
	    for (int i = n - 2; i >= 0; i--) {
	        // If current element is greater than or equal to the current leader
	        if (nums[i] >= leader) {
	            leader = nums[i];
	            leaders.add(leader);
	        }
	    }

	    // Step 3: Reverse the list to restore left-to-right order of leaders
	    Collections.reverse(leaders);
	    return leaders;
	}
	
	/**
	 * 52. Finds the length of the longest consecutive sequence in an unsorted integer array.
	 * <p>
	 * A consecutive sequence is defined as a set of integers where each number
	 * is exactly one greater than the previous number.
	 * <p>
	 * The algorithm sorts the array first to bring consecutive elements together,
	 * then performs a single linear scan to count the maximum streak of consecutive numbers.
	 * Duplicate elements are skipped to avoid breaking valid sequences.
	 * <p>
	 * <b>Example 1:</b><br>
	 * Input:  [100, 4, 200, 1, 3, 2]<br>
	 * Output: 4<br>
	 * Explanation: The longest consecutive sequence is [1, 2, 3, 4].
	 * <p>
	 * <b>Example 2:</b><br>
	 * Input:  [0, 3, 7, 2, 5, 8, 4, 6, 0, 1]<br>
	 * Output: 9<br>
	 * Explanation: The sequence is [0, 1, 2, 3, 4, 5, 6, 7, 8].
	 * <p>
	 * <b>Time Complexity:</b> O(n log n) — due to sorting.<br>
	 * <b>Space Complexity:</b> O(1) — in-place sort and constant extra variables.
	 *
	 * @param nums the input array of integers (unsorted, may contain duplicates)
	 * @return the length of the longest consecutive sequence
	 */
	public static int longestConsecutiveSequence(int[] nums) {
	    int n = nums.length;
	    if (n == 0) {
	        return 0;
	    }

	    // Step 1: Sort the array to bring consecutive numbers together
	    Arrays.sort(nums);

	    int count = 1;     // Current consecutive streak
	    int maxCount = 1;  // Longest streak found so far

	    // Step 2: Traverse the sorted array
	    for (int i = 1; i < n; i++) {
	        if (nums[i] != nums[i - 1]) { // Skip duplicates
	            if (nums[i] - nums[i - 1] == 1) {
	                // Consecutive number found → extend streak
	                count++;
	            } else {
	                // Non-consecutive number → reset streak
	                count = 1;
	            }
	            // Track the maximum streak
	            maxCount = Math.max(maxCount, count);
	        }
	    }

	    return maxCount;
	}
	
	/**
	 * 53. Sets entire rows and columns to zero in a matrix if any element in them is zero.
	 *
	 * <p>This method performs the classic "Set Matrix Zeroes" operation.  
	 * If matrix[i][j] == 0, then the entire row i and column j will be converted to zeros.
	 *
	 * <p>Approach:
	 * <ul>
	 *   <li>First pass: Identify all rows and columns that contain at least one zero.</li>
	 *   <li>Second pass: Set matrix cells to zero if they belong to a marked row or column.</li>
	 * </ul>
	 *
	 * <p>Time Complexity: O(m × n)  
	 * Space Complexity: O(m + n)
	 *
	 * @param matrix The input 2D matrix of integers.
	 * @return The modified matrix where rows/columns containing a zero are entirely set to zero.
	 */
	public static int[][] setMatrixZeroes(int[][] matrix){
	    int rows = matrix.length;
	    int cols = matrix[0].length;

	    // Tracks which rows need to be zeroed
	    boolean[] zeroRows = new boolean[rows];

	    // Tracks which columns need to be zeroed
	    boolean[] zeroCols = new boolean[cols];

	    // First pass → Identify rows and columns that contain a zero
	    for (int r = 0; r < rows; r++) {
	        for (int c = 0; c < cols; c++) {
	            if (matrix[r][c] == 0) {
	                zeroRows[r] = true; // mark entire row
	                zeroCols[c] = true; // mark entire column
	            }
	        }
	    }

	    // Second pass → Set cells to zero based on marked rows/columns
	    for (int r = 0; r < rows; r++) {
	        for (int c = 0; c < cols; c++) {
	            if (zeroRows[r] || zeroCols[c]) {
	                matrix[r][c] = 0;
	            }
	        }
	    }

	    return matrix;
	}
	
	/**
	 * 54. Finds all unique triplets in the array whose sum is equal to zero.
	 *
	 * <p>This method solves the classic "3Sum" problem using sorting and the two-pointer technique.
	 * After sorting the array, each element is considered as a potential first number of the triplet.
	 * Two pointers (left and right) are then used to find pairs that sum with the first number to zero.</p>
	 *
	 * <p>To avoid duplicate triplets:</p>
	 * <ul>
	 *   <li>Skip duplicate values for the first index.</li>
	 *   <li>After finding a valid triplet, skip duplicates for left and right pointers.</li>
	 * </ul>
	 *
	 * <p>Time Complexity: O(n²) — sorting + nested two-pointer search</p>
	 * <p>Space Complexity: O(1) — ignoring output list</p>
	 *
	 * @param nums the input integer array
	 * @return a list of unique triplets where the sum of each triplet is zero
	 */
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();

		// Sort the array to enable two-pointer search
		Arrays.sort(nums);

		// Iterate each number as the first element of the triplet
		for (int i = 0; i < nums.length; i++) {

			// Skip duplicate values to avoid repeated triplets
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			int left = i + 1; // Second pointer
			int right = nums.length - 1; // Third pointer

			// Two-pointer search for pairs that sum to -nums[i]
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];

				if (sum < 0) {
					left++; // Need a larger value
				} else if (sum > 0) {
					right--; // Need a smaller value
				} else {
					// Valid triplet found
					result.add(List.of(nums[i], nums[left++], nums[right--]));

					// Skip duplicate second values
					while (left < right && nums[left] == nums[left - 1]) {
						left++;
					}

					// Skip duplicate third values
					while (left < right && nums[right] == nums[right + 1]) {
						right--;
					}
				}
			}
		}
		return result;
	}
	
	/**
	 * 55. Finds the length of the largest contiguous subarray whose sum is zero.
	 *
	 * <p>The method uses prefix-sum + HashMap technique:</p>
	 * <ul>
	 *   <li>Maintain a running prefix sum.</li>
	 *   <li>If the prefix sum becomes zero at index <code>i</code>,
	 *       then the subarray from index 0 to i has sum 0.</li>
	 *   <li>If the same prefix sum has appeared before at index <code>j</code>,
	 *       then the subarray from <code>j+1</code> to <code>i</code> must sum to 0
	 *       (because the prefix sum cancel out).</li>
	 *   <li>We always store the first occurrence of a prefix sum
	 *       to ensure the subarray is the longest.</li>
	 * </ul>
	 *
	 * <p>Time Complexity: O(n) — Single pass through the array</p>
	 * <p>Space Complexity: O(n) — HashMap to store prefix sums</p>
	 *
	 * @param nums the input array of integers
	 * @return the length of the largest subarray with sum equal to zero
	 */
	public static int largestSumSubArray(int[] nums) {
		int maxLength = 0;
		// Stores: prefixSum → first index where it occurred
		Map<Integer, Integer> prefixIndexMap = new HashMap<>();
		int prefixSum = 0;
		for (int i = 0; i < nums.length; i++) {
			prefixSum += nums[i];
			// Case 1: If prefix sum becomes zero, subarray [0..i] is valid
			if (prefixSum == 0) {
				maxLength = i + 1;
			}
			// Case 2: If this prefix sum was seen before
			else if (prefixIndexMap.containsKey(prefixSum)) {
				int prevIndex = prefixIndexMap.get(prefixSum);
				// Subarray between previous index + 1 and current index has sum = 0
				maxLength = Math.max(maxLength, i - prevIndex);
			}
			// Case 3: Store prefix sum's first occurrence only
			else {
				prefixIndexMap.put(prefixSum, i);
			}
		}
		return maxLength;
	}
	
	/**
	 * 56. Counts the number of contiguous subarrays whose sum equals k.
	 *
	 * <p>This method uses the Prefix-Sum + HashMap technique:</p>
	 * <ul>
	 *     <li>Maintain a running prefix sum while scanning the array.</li>
	 *     <li>If at any index we have: prefixSum - k previously seen at index j,
	 *         then the subarray (j+1 ... i) has sum = k.</li>
	 *     <li>The HashMap stores the frequency of each prefix sum encountered.</li>
	 *     <li>Initialize map with (0 → 1) to count subarrays starting from index 0.</li>
	 * </ul>
	 *
	 * <p>Example:</p>
	 * <pre>
	 * Input:  nums = [1, 1, 1], k = 2
	 * Output: 2
	 * Explanation:
	 * Subarrays with sum 2 → [1,1] at (0,1) and (1,2)
	 * </pre>
	 *
	 * <p>Time Complexity: O(n)</p>
	 * <p>Space Complexity: O(n)</p>
	 *
	 * @param nums The input integer array
	 * @param k The target sum
	 * @return The number of subarrays whose sum equals k
	 */
	public static int countSubArraysWithSumK(int[] nums,int k) {
	    // Map: prefixSum → frequency of how many times it has appeared
	    Map<Integer, Integer> prefixFreq = new HashMap<>();
	    prefixFreq.put(0, 1); // Important: prefix sum 0 appears once initially

	    int prefixSum = 0;
	    int count = 0;

	    for (int num : nums) {

	        prefixSum += num;

	        // Check if prefixSum - k has appeared before
	        // If yes, then subarrays ending here with sum k exist
	        if (prefixFreq.containsKey(prefixSum - k)) {
	            count += prefixFreq.get(prefixSum - k);
	        }

	        // Record the prefix sum occurrence
	        prefixFreq.put(prefixSum, prefixFreq.getOrDefault(prefixSum, 0) + 1);
	    }

	    return count;
	}
	
	/**
	 * 57 Rotate Image
	 *
	 * <p>Given an n x n 2D matrix representing an image, rotate the image by 90 degrees clockwise.
	 * The rotation must be performed in-place, meaning the input matrix must be modified directly
	 * without allocating another matrix.
	 *
	 * <p><b>Input:</b>
	 * matrix = [
	 *   [1, 2, 3],
	 *   [4, 5, 6],
	 *   [7, 8, 9]
	 * ]
	 *
	 * <p><b>Output (after rotation):</b>
	 * matrix = [
	 *   [7, 4, 1],
	 *   [8, 5, 2],
	 *   [9, 6, 3]
	 * ]
	 *
	 * <p>The rotation is achieved in two steps:
	 * <ul>
	 *   <li><b>Transpose:</b> Convert rows into columns.</li>
	 *   <li><b>Reverse each row:</b> Produces the final 90° clockwise rotation.</li>
	 * </ul>
	 *
	 * <p><b>Time Complexity:</b> O(n²)<br>
	 * <b>Space Complexity:</b> O(1) — in-place</p>
	 *
	 * @param matrix the n x n matrix to be rotated in-place
	 */
	public static int[][] rotateMatrix90Degrees(int[][] nums) {
		int n = nums.length;
		// Step1 : Transpose the matrix
		for (int row = 0; row < n; row++) {
			for (int col = row + 1; col < n; col++) {
				int temp = nums[row][col];
				nums[row][col] = nums[col][row];
				nums[col][row] = temp;
			}
		}
		// Step2 : Reverse each row
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n / 2; col++) {
				int temp = nums[row][n - col - 1];
				nums[row][n - col - 1] = nums[row][col];
				nums[row][col] = temp;
			}
		}
		return nums;
	}
	
	/**
	 * 58. Search insert position
	 * Returns the index where the target should be inserted in a sorted array.
	 * 
	 * <p>
	 * If the target exists in the array, its existing index is returned.  
	 * If it does not exist, the index where it should be inserted to maintain
	 * sorted order is returned.
	 * </p>
	 *
	 * <p><b>Example:</b><br>
	 * nums = [1,3,5,6], target = 5  →  returns 2<br>
	 * nums = [1,3,5,6], target = 2  →  returns 1<br>
	 * nums = [1,3,5,6], target = 7  →  returns 4
	 * </p>
	 *
	 * <p><b>Time Complexity:</b> O(n) — Linear scan.</p>
	 *
	 * @param nums    A sorted integer array (ascending order)
	 * @param target  The value to search or insert
	 * @return The index of the target or its insertion position
	 */
	public static int searchInsertPosition(int[] nums, int target) {
		// Scan until you find an element >= target
		for (int index = 0; index < nums.length; index++) {
			if (nums[index] >= target) {
				return index;
			}
		}
		// If not found, the target should be inserted at the end
		return nums.length;
	}
	
	/**
	 * 59. Find floor and ceil value
	 * Finds the floor and ceil values of the given target in a sorted array.
	 *
	 * <p>
	 * Floor = largest value ≤ target  
	 * Ceil  = smallest value ≥ target
	 * </p>
	 *
	 * <p>
	 * If the target is smaller than the smallest element → floor = target, ceil = nums[0].  
	 * If the target is larger than the largest element → floor = nums[n-1], ceil = target.
	 * </p>
	 *
	 * @param nums    A sorted array of integers (ascending order)
	 * @param target  The value for which floor and ceil are to be found
	 * @return A list of size 2: [floor, ceil]
	 */
	public static List<Integer> getFloorAndCeil(int[] nums, int target) {
	    int n = nums.length;
	    // Case 1: target is smaller than smallest element
	    if (target < nums[0]) {
	        return List.of(target, nums[0]);
	    }
	    // Case 2: target is larger than largest element
	    if (target > nums[n - 1]) {
	        return List.of(nums[n - 1], target);
	    }
	    // Iterate to locate floor and ceil
	    for (int i = 0; i < n; i++) {
	        // Exact match → floor and ceil are target
	        if (nums[i] == target) {
	            return List.of(nums[i], nums[i]);
	        }
	        // First element greater than target → previous is floor, current is ceil
	        if (nums[i] > target) {
	            return List.of(nums[i - 1], nums[i]);
	        }
	    }
	    // This line won't be reached logically, kept for safety
	    return List.of(nums[n - 1], target);
	}
	
	/**
	 * 60. First and last position of element in sorted array
	 * 
	 * Finds the starting and ending position of a given target in a sorted array.
	 * If the target is not found, returns [-1, -1].
	 *
	 * <p>This solution performs a binary search to locate an occurrence of the target,
	 * then expands left and right to find the full range of the target values.</p>
	 *
	 * @param nums   Sorted integer array (may contain duplicates)
	 * @param target The value to search for
	 * @return An array of size 2: [firstPosition, lastPosition]
	 */
	public static int[] firstAndLastPostion(int[] nums, int target) {
		int[] result = new int[] { -1, -1 };
		// Edge case: empty array
		if (nums.length == 0) {
			return result;
		}
		int left = 0;
		int right = nums.length - 1;
		// Standard binary search
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				// Expand left from mid
				int start = mid;
				while (start > 0 && nums[start - 1] == target) {
					start--;
				}
				// Expand right from mid
				int end = mid;
				while (end < nums.length - 1 && nums[end + 1] == target) {
					end++;
				}

				result[0] = start;
				result[1] = end;
				return result;
			}
			// Move search boundaries
			if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		// Target not found
		return result;
	}
	
	/**
	 * 61. Counts how many times a target value appears in a sorted array.
	 *
	 * <p>
	 * This method performs a binary search to find any occurrence of the target.
	 * Once found, it expands left and right from the matched index to count all
	 * duplicates. Useful when the array is sorted and contains repeated values.
	 * </p>
	 *
	 * <p><b>Example:</b><br>
	 * nums = [1, 2, 2, 2, 3], target = 2 → returns 3<br>
	 * nums = [5, 7, 7, 8, 8, 10], target = 8 → returns 2<br>
	 * nums = [1, 3, 5], target = 4 → returns 0
	 * </p>
	 *
	 * <p><b>Time Complexity:</b> O(log n + k), where k is number of duplicates near mid</p>
	 *
	 * @param nums    A sorted integer array
	 * @param target  The value whose occurrence count is needed
	 * @return Count of occurrences of target (0 if not found)
	 */
	public static int countOccurrences(int[] nums, int target) {
		// Edge case: empty array
		if (nums.length == 0) {
			return 0;
		}
		int count = 0;
		int left = 0;
		int right = nums.length - 1;
		// Standard binary search
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				// Expand left from mid
				int start = mid;
				count = 1;
				while (start > 0 && nums[start - 1] == target) {
					count++;
					start--;
				}
				// Expand right from mid
				int end = mid;
				while (end < nums.length - 1 && nums[end + 1] == target) {
					count++;
					end++;
				}
				return count;
			}
			// Move search boundaries
			if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		// Target not found
		return count;
	}
	
	/**
	 * 62. Search in Rotated Sorted Array
	 * 
	 * Searches for a target value in a rotated sorted array and returns its index.
	 *
	 * <p>A rotated sorted array is an array that was originally sorted in ascending
	 * order but then rotated at some pivot. Example: [4,5,6,7,0,1,2].
	 * This method uses modified binary search to determine whether the
	 * target lies in the left-sorted or right-sorted portion.</p>
	 *
	 * <p><b>Example:</b><br>
	 * nums = [4,5,6,7,0,1,2], target = 0 → returns 4<br>
	 * nums = [4,5,6,7,0,1,2], target = 3 → returns -1
	 * </p>
	 *
	 * <p><b>Time Complexity:</b> O(log n)<br>
	 * <b>Space Complexity:</b> O(1)</p>
	 *
	 * @param nums    A rotated sorted integer array
	 * @param target  The value to search for
	 * @return The index of target if found, otherwise -1
	 */
	public static int searchInRoatedSortedArray(int[] nums, int target) {
	    int left = 0;
	    int right = nums.length - 1;
	    while (left <= right) {
	        int mid = left + (right - left) / 2;

	        // Found target
	        if (nums[mid] == target) {
	            return mid;
	        }

	        // Check if left half is sorted
	        if (nums[left] <= nums[mid]) {

	            // Target lies within the sorted left half
	            if (nums[left] <= target && target < nums[mid]) {
	                right = mid - 1;
	            } else { // Target is in right half
	                left = mid + 1;
	            }

	        } else {
	            // Right half is sorted

	            // Target lies within the sorted right half
	            if (nums[mid] < target && target <= nums[right]) {
	                left = mid + 1;
	            } else { // Target is in left half
	                right = mid - 1;
	            }
	        }
	    }
	    // Target does not exist
	    return -1;
	}
	
	/**
	 * 63. Search in Rotated Sorted Array II
	 * Searches for a target value in a rotated sorted array that may contain duplicates.
	 * This is the solution for LeetCode Problem 81 — Search in Rotated Sorted Array II.
	 *
	 * <p>The array is assumed to be originally sorted in ascending order, then rotated
	 * at some pivot. Because duplicates are allowed, the algorithm may degrade to O(n)
	 * time in the worst case. However, it still maintains O(log n) behavior when
	 * duplicates do not interfere.</p>
	 *
	 * <p>Algorithm overview:</p>
	 * <ul>
	 *   <li>Use modified binary search.</li>
	 *   <li>If nums[left] == nums[mid], increment left to skip duplicates.</li>
	 *   <li>Determine which half is sorted and decide direction.</li>
	 * </ul>
	 *
	 * @param nums   the rotated sorted array (may contain duplicates)
	 * @param target the value to search for
	 * @return true if target exists in the array; false otherwise
	 */
	public static boolean searchInRoatedSortedArrayII(int[] nums, int target) {
	    int left = 0, right = nums.length - 1;

	    while (left <= right) {
	        int mid = (left + right) / 2;

	        if (nums[mid] == target) return true;

	        // Handle duplicates
	        if (nums[left] == nums[mid]) {
	            left++;
	            continue;
	        }

	        // Left half is sorted
	        if (nums[left] < nums[mid]) {
	            if (nums[left] <= target && target < nums[mid]) {
	                right = mid - 1;
	            } else {
	                left = mid + 1;
	            }
	        }
	        // Right half is sorted
	        else {
	            if (nums[mid] < target && target <= nums[right]) {
	                left = mid + 1;
	            } else {
	                right = mid - 1;
	            }
	        }
	    }
	    return false;
	}
	
	/**
	 * 64. Find Minimum in Rotated Sorted Array
	 * Finds the minimum element in a rotated sorted array with no duplicate values.
	 * <p>
	 * This is the solution for LeetCode Problem 153 — "Find Minimum in Rotated Sorted Array".
	 * The array was originally sorted in ascending order and then rotated at an unknown pivot.
	 * The minimum element is always located at the pivot point.
	 *
	 * <h3>Algorithm</h3>
	 * The method uses modified binary search:
	 * <ul>
	 *   <li>If nums[mid] < nums[right], the minimum lies in the left half (including mid).</li>
	 *   <li>Otherwise, the minimum lies in the right half (excluding mid).</li>
	 * </ul>
	 *
	 * <h3>Time Complexity</h3>
	 * O(log n) — binary search  
	 *
	 * <h3>Space Complexity</h3>
	 * O(1) — constant extra space
	 *
	 * @param nums the rotated sorted array (must contain no duplicates)
	 * @return the minimum value in the array
	 */
	public static int findMinimumInRoatedSortedArray(int[] nums) {
	    int left = 0;
	    int right = nums.length - 1;

	    while (left < right) {
	        int mid = left + (right - left) / 2;
	        if (nums[mid] < nums[right]) {
	            right = mid; // Minimum is at mid or to the left
	        } else {
	            left = mid + 1; // Minimum is to the right of mid
	        }
	    }
	    return nums[left]; // left == right → minimum element
	}
	
	/**
	 * 65. Rotation count of an array
	 * Computes the rotation count of a rotated sorted array (without duplicates).
	 * <p>
	 * A sorted array is rotated at some pivot unknown beforehand.
	 * The rotation count is the index of the minimum element.
	 * Example:
	 *   nums = [4,5,6,7,0,1,2]
	 *   Minimum = 0 at index 4 → rotation count = 4
	 *
	 * <h3>Algorithm</h3>
	 * Uses binary search:
	 * <ul>
	 *   <li>If nums[mid] < nums[right], the minimum is in the left half.</li>
	 *   <li>Otherwise, minimum is in the right half.</li>
	 * </ul>
	 *
	 * <h3>Time Complexity</h3>
	 * O(log n)
	 *
	 * @param nums the rotated sorted array (no duplicates)
	 * @return rotation count (index of minimum element)
	 */
	public static int roatationCount(int[] nums) {
		int left = 0;
		int right = nums.length - 1;

		while (left < right) {
			int mid = left + (right - left) / 2;

			// Minimum element lies in the left half (including mid)
			if (nums[mid] < nums[right]) {
				right = mid;
			}
			// Minimum lies in the right half (excluding mid)
			else {
				left = mid + 1;
			}
		}
		return left; // Index of the minimum element ⇒ rotation count
	}
	
	/**
	 * 66. Single element in sorted array
	 * Finds the single non-duplicate element in a sorted array where every other element
	 * appears exactly twice. The array is guaranteed to have one unique element.
	 *
	 * <p>This method uses a binary search approach with O(log n) time complexity.
	 * Key idea:
	 * <ul>
	 *   <li>The duplicate elements always appear in pairs.</li>
	 *   <li>Before the unique element, pairs start at even indices.</li>
	 *   <li>After the unique element, pairs start at odd indices.</li>
	 * </ul>
	 *
	 * <h3>Algorithm</h3>
	 * <ol>
	 *   <li>Perform binary search on index space.</li>
	 *   <li>If mid is odd, adjust it to make mid even (pair boundary).</li>
	 *   <li>If nums[mid] == nums[mid + 1], the unique element is in the right half.</li>
	 *   <li>Otherwise, it lies in the left half (including mid).</li>
	 * </ol>
	 *
	 * @param nums a sorted integer array where every element appears twice except one
	 * @return the single non-duplicate element
	 */
	public static int findSingleInSortedArray(int[] nums) {
	    int left = 0;
	    int right = nums.length - 1;
	    while (left < right) {
	        int mid = left + (right - left) / 2;
	        // Ensure mid is even (start of a pair)
	        if (mid % 2 == 1) {
	            mid--;
	        }
	        // If mid and mid+1 are equal, the unique element is farther right
	        if (nums[mid] == nums[mid + 1]) {
	            left = mid + 2;
	        } 
	        // Otherwise the unique element is at mid or to the left of mid
	        else {
	            right = mid;
	        }
	    }
	    // left == right, pointing to the unique element
	    return nums[left];
	}
	
	/**
	 * 67. Find square root of a number in log n
	 * Computes the integer square root (floor value) of a given non-negative integer n.
	 * The result is the largest integer x such that x*x <= n.
	 *
	 * <p>This method uses binary search in the range [1, n/2] for n > 1,
	 * which guarantees O(log n) time complexity.</p>
	 *
	 * <h3>Edge Cases:</h3>
	 * <ul>
	 *   <li>If n = 0 → return 0</li>
	 *   <li>If n = 1 → return 1</li>
	 * </ul>
	 *
	 * @param n the number for which the integer square root is to be computed
	 * @return the integer square root (floor value)
	 */
	public static int findSquareRoot(int n) {
	    // Handle trivial small cases
	    if (n < 2) {
	        return n;
	    }
	    int sqrt = -1;
	    int left = 1;
	    int right = n / 2; // sqrt(n) cannot be larger than n/2 for n > 1

	    while (left <= right) {
	        int mid = left + (right - left) / 2;

	        long square = (long) mid * mid; // avoid overflow for large n

	        if (square == n) {
	            return mid; // perfect square case
	        }
	        if (square < n) {
	            sqrt = mid;   // mid is a valid floor candidate
	            left = mid + 1;
	        } else {
	            right = mid - 1;
	        }
	    }
	    return sqrt;
	}
	
	/**
	 * 68. Finds the minimum eating speed K such that Koko can finish all banana piles within the given number of hours using Binary Search on the answer. 
	 * 
	 * Approach:
	 * - The minimum possible speed = 1 
	 * - The maximum possible speed = max(piles) 
	 * - Use binary search on K and check if Koko can finish with that speed.
	 * 
	 * Algorithm: 
	 * - Minimum possible K = 1 
	 * - Maximum possible K = max(piles) 
	 * - Binary search for the smallest K where Koko can finish in <= h hours.
	 *
	 * Time Complexity: O(n * log(maxPile)) - log(maxPile) for the binary search
	 * range of speeds - O(n) for checking total hours needed for a given speed
	 *
	 * Space Complexity: O(1) - Uses only constant extra space
	 *
	 * @param piles the array representing banana piles.
	 * @param hours the maximum allowed hours.
	 * @return the minimum integer eating speed K.
	 */
	public static int kokoEatingBananas(int[] piles, int hours) {
		int left = 1; // Minimum possible speed
		int right = Arrays.stream(piles).max().getAsInt(); // Maximum possible speed
		int result = right; // Store the best possible result
		// Binary search on eating speed
		while (left <= right) {
			int mid = left + (right - left) / 2; // Current speed guess
			if (canFinish(piles, hours, mid)) {
				// If Koko can finish at speed mid, try a smaller speed
				result = mid;
				right = mid - 1;
			} else {
				// Otherwise increase speed
				left = mid + 1;
			}
		}
		return result;
	}

	public static boolean canFinish(int[] piles, int h, int k) {
		long totalHours = 0;
		for (int pile : piles) {
			// Add the required hours = ceil(pile / k)
			totalHours += pile / k;
			if (pile % k != 0) {
				totalHours++;
			}
			// Optional optimization: stop early if exceeding limit
			if (totalHours > h)
				return false;
		}
		return totalHours <= h;
	}
	
	/**
	 * 69. Determines the minimum number of days required to make `m` bouquets,
	 * where each bouquet needs `k` adjacent flowers. Each flower blooms on the
	 * day given in the `bloomDay` array.
	 *
	 * <p><b>Approach:</b><br>
	 * We apply **Binary Search on Days**:
	 * <ul>
	 *   <li>Search range = [min(bloomDay), max(bloomDay)]</li>
	 *   <li>For a given mid = day, check if we can make at least m bouquets.</li>
	 *   <li>To check feasibility, count how many adjacent groups of size k
	 *       exist where bloomDay <= mid.</li>
	 * </ul>
	 *
	 * If bouquets can be made → try earlier days (high = mid - 1)  
	 * If not → try later days (low = mid + 1)
	 *
	 * <p><b>Time Complexity:</b>  
	 * O(n log maxDay)  
	 * where n = bloomDay.length, maxDay = maximum bloom value
	 *
	 * <p><b>Space Complexity:</b>  
	 * O(1)
	 *
	 * @param bloomDay array where bloomDay[i] = day i-th flower blooms
	 * @param m number of bouquets needed
	 * @param k number of adjacent flowers required per bouquet
	 * @return minimum day to make m bouquets, else -1
	 */
	public static int minimumDaysToMakeMbuckets(int[] bloomDay, int m, int k) {
	    int n = bloomDay.length;
	    // If total flowers needed exceed available flowers → impossible
	    if ((long) m * k > n)
	        return -1;
	    int low = Arrays.stream(bloomDay).min().orElseThrow();
	    int high = Arrays.stream(bloomDay).max().orElseThrow();
	    // Binary Search on number of days
	    while (low <= high) {
	        int mid = low + (high - low) / 2;

	        if (canMakeBouquets(bloomDay, mid, k, m)) {
	            high = mid - 1; // try earlier day
	        } else {
	            low = mid + 1; // need more days
	        }
	    }
	    return low;
	}
	private static boolean canMakeBouquets(int[] bloomDay, int dayLimit, int k, int m) {
	    int consecutive = 0;   // count of consecutive flowers available
	    int bouquets = 0;      // total bouquets formed
	    for (int day : bloomDay) {
	        if (day <= dayLimit) {
	            consecutive++; // this flower has bloomed by 'dayLimit'
	        } else {
	            // break in adjacency → convert consecutive to bouquets
	            bouquets += (consecutive / k);
	            consecutive = 0;
	        }
	    }
	    // Add remaining segment
	    bouquets += (consecutive / k);
	    return bouquets >= m;
	}
	
	/**
	 * 70. Search in 2D array II
	 * Searches for a target value inside a 2D matrix where:
	 * - Each row is sorted in ascending order.
	 * - Each column is also sorted in ascending order.
	 *
	 * <p><b>Approach:</b>
	 * We start from the top-right element of the matrix:
	 * <ul>
	 *   <li>If the current element equals the target → return true.</li>
	 *   <li>If the current element is greater than the target → move left (decrease column).</li>
	 *   <li>If the current element is smaller than the target → move down (increase row).</li>
	 * </ul>
	 * This works because moving left reduces the value and moving down increases the value,
	 * leveraging the matrix’s sorted properties.
	 *
	 * <p><b>Time Complexity:</b> O(m + n)  
	 * (At most you move left `n` times and down `m` times.)
	 *
	 * <p><b>Space Complexity:</b> O(1)  
	 * (Only constant extra variables are used.)
	 *
	 * @param matrix 2D sorted matrix (sorted row-wise and column-wise)
	 * @param target value to search for
	 * @return true if target is found; false otherwise
	 */
	public static boolean searchIn2DmatrixII(int[][] matrix, int target) {
		int rows = matrix.length;
	    int cols = matrix[0].length;
	    int row = 0;         // Start at top row
	    int col = cols - 1;  // Start at last column (top-right corner)
	    // Move within bounds of matrix
	    while (row < rows && col >= 0) {
	        int current = matrix[row][col];
	        if (current == target) {
	            return true; // Found target
	        } else if (target < current) {
	            col--;       // Move left to reduce value
	        } else {
	            row++;       // Move down to increase value
	        }
	    }
	    return false; // Not found
	}
	
	/**
	 * 71. Find Equilibrium
	 * Finds the equilibrium index of an array.
	 *
	 * <p><b>Definition:</b>
	 * An equilibrium index is an index {@code i} such that:
	 * <pre>
	 * sum(arr[0] ... arr[i-1]) == sum(arr[i+1] ... arr[n-1])
	 * </pre>
	 *
	 * <p><b>Approach:</b>
	 * 1. Compute the total sum of all elements.  
	 * 2. Iterate through the array keeping track of the left-prefix sum.  
	 * 3. For each index {@code i}, the right-prefix sum is:
	 *    <pre>
	 *    right = totalSum - leftPrefix - arr[i]
	 *    </pre>
	 * 4. If {@code leftPrefix == right}, the index is equilibrium.
	 * 5. Update {@code leftPrefix} as we move forward.
	 *
	 * <p><b>Time Complexity:</b> O(n)  
	 * (One pass to compute total sum + one pass to find equilibrium.)
	 *
	 * <p><b>Space Complexity:</b> O(1)  
	 * (No extra space except constant variables.)
	 *
	 * @param arr input array of integers
	 * @return equilibrium index (0-based); -1 if no such index exists
	 */
	public static int findEquilibrium(int[] arr) {
	    int n = arr.length;

	    // Step 1: compute total array sum
	    int totalSum = 0;
	    for (int i = 0; i < n; i++) {
	        totalSum += arr[i];
	    }

	    // Step 2: iterate again to find equilibrium index
	    int leftPrefix = 0;
	    for (int i = 0; i < n; i++) {
	        // Right side sum = total - left side - current element
	        int rightPrefix = totalSum - leftPrefix - arr[i];
	        // Check equilibrium condition
	        if (leftPrefix == rightPrefix) {
	            return i;
	        }
	        // Update left-prefix sum
	        leftPrefix += arr[i];
	    }

	    // No equilibrium found
	    return -1;
	}
	
	/**
	 * 72. Count Zeros
	 * Counts the number of zeroes in a sorted binary array where all 1s come first
	 * followed by all 0s.
	 *
	 * <p>The array pattern is:
	 * <pre>
	 * [1, 1, 1, ..., 1, 0, 0, 0, ..., 0]
	 * </pre>
	 *
	 * <p><b>Approach:</b>
	 * Use binary search to find the first occurrence of 0.
	 * - If mid element is 1 → search right half
	 * - If mid is 0 → record it and search left half to find the earliest zero
	 *
	 * Once the first 0 (index = zerosStartIndex) is found:
	 * <pre>
	 * count = totalLength - zerosStartIndex
	 * </pre>
	 *
	 * <p><b>Time Complexity:</b> O(log n)  
	 * (Binary search)
	 *
	 * <p><b>Space Complexity:</b> O(1)
	 *
	 * @param arr sorted array of 0s and 1s where all 1s precede all 0s
	 * @return number of zeroes in the array
	 */
	public static int countZeros(int[] arr) {
		int left = 0;
		int right = arr.length-1;

		// If no zero is found, start index = arr.length
		int zerosStartIndex = arr.length;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			// If mid is 1 → move right
			if (arr[mid] == 1) {
				left = mid + 1;
			} else {
				// If mid is 0 → possible first zero, go left to check earlier positions
				zerosStartIndex = mid;
				right = mid - 1;
			}
		}
		// Total zero count
		return arr.length - zerosStartIndex;
	}
	
	/**
	 * 73. Intersection of Two Arrays : Given two integer arrays, return an array of their intersection.
	 * 
	 * <p>
	 * <pre>
	 * Example 1: arr1 = [1,2,2,1], arr2 = [2,2] → Output: [2]
	 * Example 2: arr1 = [4,9,5], arr2 = [9,4,9,8,4] → Output: [9,4]
	 * Example 3: arr1 = [1,2,3], arr2 = [4,5,6] → Output: []
	 * Example 4: arr1 = [], arr2 = [1,2,3] → Output: []
	 * Example 5: arr1 = [1,2,2,1], arr2 = [] → Output: []
	 * </pre>
	 * </p>
	 * 
	 * <b>Time Complexity:</b> O(n + m) where n and m are the lengths of the two arrays.<br>
	 * <b>Space Complexity:</b> O(min(n, m)) for storing the intersection elements.
	 * 
	 * <p>
	 * <pre>
	 * Approach:	
	 * - Convert both arrays to sets to remove duplicates.
	 * - Iterate through one set and check for presence in the other set.
	 * - Collect common elements into a result set.
	 * - Convert the result set back to an array and return.
	 * </pre>
	 * </p>
	 * 
	 * @param one first input array
	 * @param two second input array
	 * @return array of intersection elements
	 */
	public static int[] intersectionOfTwoArrays(int[] one, int[] two) {
		return Arrays.stream(one)
				.distinct()
				.filter(y -> Arrays.stream(two).distinct().anyMatch(x -> x == y))
				.toArray();
	}
	
	
	/**
	 * 74. Intersection of Two Arrays II : Given two integer arrays, return an array of their intersection such that each element appears as many times as it shows in both arrays.
	 *
	 * <p>
	 * <pre>
	 * Example 1:
	 * Input:  arr1 = [1,2,2,1], arr2 = [2,2]
	 * Output: [2,2]
	 *
	 * Example 2:
	 * Input:  arr1 = [4,9,5], arr2 = [9,4,9,8,4]
	 * Output: [4,9]
	 *
	 * Example 3:
	 * Input:  arr1 = [1,1,1], arr2 = [1,1]
	 * Output: [1,1]
	 *
	 * Example 4:
	 * Input:  arr1 = [1,2,3], arr2 = [4,5,6]
	 * Output: []
	 *
	 * Example 5:
	 * Input:  arr1 = [], arr2 = [1,2]
	 * Output: []
	 * </pre>
	 * </p>
	 *
	 * <b>Time Complexity:</b> O(n + m)  
	 * where n is the length of the first array and m is the length of the second array.
	 *
	 * <br>
	 * <b>Space Complexity:</b> O(n)  
	 * for storing element frequencies of the first array in a HashMap.
	 *
	 * <p>
	 * <pre>
	 * Approach:
	 * - Create a frequency map from the first array where:
	 *     key   → element
	 *     value → number of occurrences
	 * - Traverse the second array:
	 *     - If the element exists in the map and count > 0:
	 *         - Add it to the result
	 *         - Decrease its frequency
	 * - Convert the result list to an array and return.
	 * </pre>
	 * </p>
	 *
	 * @param first the first input integer array
	 * @param second the second input integer array
	 * @return an array representing the intersection including duplicate occurrences
	 */
	public static int[] intersectionOfTwoArraysII(int[] first, int[] second) {
		List<Integer> result = new ArrayList<>();
		Map<Integer, Long> freqMap = Arrays.stream(first)
											.boxed()
											.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		for(int num : second) {
			if(freqMap.containsKey(num) && freqMap.get(num)>0) {
				result.add(num);
				freqMap.put(num, freqMap.get(num)-1);
			}
		}
		return result.stream().mapToInt(Integer::intValue).toArray();
	}
	
	/**
	 * 75. Find Smallest Letter Greater Than Target
	 *
	 * <p> Given a sorted array of lowercase letters and a target letter, this method returns the smallest character in the array that is strictly greater than the target. If no such character exists,it wraps around and returns the first character of the array. </p>
	 *
	 * <p>
	 * <pre>
	 * Example 1: Input:  letters = ['c','f','j'], target = 'a' Output: 'c'
	 * Example 2:Input:  letters = ['c','f','j'], target = 'c' Output: 'f'
	 * Example 3:Input:  letters = ['c','f','j'], target = 'd' Output: 'f'
	 * Example 4: Input:  letters = ['c','f','j'], target = 'j'Output: 'c'  
	 * Example 5: Input:  letters = ['a','b'], target = 'z' Output: 'a'   (wrap-around)
	 * </pre>
	 * </p>
	 *
	 * <h3>Approach</h3>
	 * <pre>
	 * - Use a frequency array of size 256 to mark the presence of characters.
	 * - Populate the frequency array using the given letters.
	 * - Iterate from (target + 1) to the maximum ASCII value:
	 *     - Return the first character whose frequency is greater than 0.
	 * - If no such character is found, return the first character of the array
	 *   (wrap-around case).
	 * </pre>
	 *
	 * <p>Time Complexity :  O(n + 256) → effectively O(n), where n is the number of letters. </p>
	 * <p>Space Complexity : O(256) → constant extra space for the frequency array.</p>
	 *
	 * @param letters sorted array of lowercase characters
	 * @param target  the target character
	 * @return the smallest character strictly greater than the target
	 */
	public static char findSmallestLetterGraterThanTarget(char[] letters, char target) { 
		// Frequency array to mark presence of characters
		int[] frequency = new int[256];

		// Mark all characters present in the input array
		for (char ch : letters) {
			frequency[ch]++;
		}

		// Find the smallest character greater than target
		for (int ascii = target + 1; ascii < 256; ascii++) {
			if (frequency[ascii] > 0) {
				return (char) ascii;
			}
		}

		// If no greater character exists, wrap around
		return letters[0];
	}
	
	/**
	 * 76. Container With Most Water
	 *
	 * <p> Given an integer array where each element represents the height of a vertical line, this method finds two lines that together with the x-axis form a container, such that the container holds the maximum amount of water. </p>
	 *
	 * <p>
	 * <pre>
	 * Example 1: Input:  heights = [1,8,6,2,5,4,8,3,7] Output: 49
	 * Example 2: Input:  heights = [1,1] Output: 1
	 * Example 3: Input:  heights = [4,3,2,1,4] Output: 16
	 * Example 4: Input:  heights = [1,2,1] Output: 2
	 * Example 5: Input:  heights = [2,3,10,5,7,8,9] Output: 36
	 * </pre>
	 * </p>
	 *
	 * <h3>Approach</h3>
	 * <pre>
	 * - Use two pointers: one at the beginning (left) and one at the end (right).
	 * - The width of the container is (right - left).
	 * - The height is the minimum of heights[left] and heights[right].
	 * - Calculate area = width × height and update maximum area.
	 * - Move the pointer pointing to the smaller height inward:
	 *     - This may lead to a taller boundary and a larger area.
	 * - Continue until left meets right.
	 * </pre>
	 *
	 * <p> Time Complexity O(n), where n is the number of elements in the array. </p>
	 * <p>Space Complexity O(1), as no extra space is used.</p>
	 *
	 * @param heights array representing heights of vertical lines
	 * @return maximum amount of water that can be contained
	 */
	public static int containerWithMostWater(int[] heights) {
		int left = 0;
		int right = heights.length - 1;
		int maxArea = 0;
		while (left < right) {
			int width  = right - left;
			int height = Math.min(heights[left], heights[right]);
			int currentArea = width * height;
			maxArea = Math.max(maxArea, currentArea);
			if (heights[left] < heights[right]) {
				left++;
			} else {
				right--;
			}
		}
		return maxArea;
	}
	
    /**
     * 77. House Robber (LeetCode 198)
     *
     * <pre>
     * Description: Given an integer array where each element represents money in a house, determine the maximum amount that can be robbed without robbing adjacent houses.
     *
     * Example1: Input: [1,2,3,1] → Output: 4
     * Example2: Input: [2,7,9,3,1] → Output: 12
     * Example3: Input: [2,1,1,2] → Output: 4
     *
     * Approach:
     * 1. At each house, choose either:
     *    - Rob it (previous skip + current value)
     *    - Skip it (previous max)
     * 2. Track only two variables instead of full DP array.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * </pre>
     *
     * @param houses array representing money in each house
     * @return maximum amount that can be robbed
     */
	public static int houseRobber(int[] houses) {
		return robRange(houses, 0, houses.length - 1);
	}
	
    private static int robRange(int[] houses, int start, int end) {
		// Maximum money if previous house was robbed
		int robPrevious = 0;

		// Maximum money if previous house was skipped
		int skipPrevious = 0;

		for (int i = start; i <= end; i++) {

			// If we rob current house, we must have skipped previous
			int robCurrent = skipPrevious + houses[i];

			// If we skip current house, take max of previous states
			skipPrevious = Math.max(skipPrevious, robPrevious);

			// Update robPrevious for next iteration
			robPrevious = robCurrent;
		}

		// Final answer is max of robbing or skipping last house
		return Math.max(robPrevious, skipPrevious);
    }
    
    /**
	 * 78. House Robber II (LeetCode 213)
	 *
	 * <pre>
	 * Description: Similar to House Robber I, but houses are arranged in a circle. The first and last houses are adjacent, so you cannot rob both.
	 *
	 * Example1: Input: [2,3,2] → Output: 3
	 * Example2: Input: [1,2,3,1] → Output: 4
	 * Example3: Input: [0] → Output: 0
	 *
	 * Approach:
	 * - Since the first and last houses are adjacent, we have two scenarios:
	 *   1. Rob from the first house to the second-to-last house (exclude last).
	 *   2. Rob from the second house to the last house (exclude first).
	 * - Compute both scenarios using the same helper function and take the maximum.
	 *
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * </pre>
	 *
	 * @param houses array representing money in each house arranged in a circle
	 * @return maximum amount that can be robbed
	 */
	public static int houseRobberII(int[] houses) {
		// Edge case: if there's only one house, rob it
		if (houses.length == 1) {
			return houses[0]; 
		}
		// Scenario 1: Rob from first to second-to-last house
		int firstOneSkip = robRange(houses, 1, houses.length - 1);
		// Scenario 2: Rob from second to last house
		int lastOneSkip  = robRange(houses, 0, houses.length - 2);
		return Math.max(firstOneSkip, lastOneSkip);
	}
	
}
