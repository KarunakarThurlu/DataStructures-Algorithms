package sorting;

import java.util.Arrays;

public class SortingProblems {
	/*
	 * ================================== 
	 * Sorting Problems
	 * ================================== 
	 * 1. Bubble Sort
	 * 2. Quick Sort
	 * 3. Merge Sort
	 */
	
	/**
	 * 1. Bubble Sort : Sorts an array of integers using the Bubble Sort algorithm.
	 * Bubble Sort repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order. 
	 * The process repeats until the list is sorted.
	 *
	 * @param array The array of integers to be sorted.
	 * @return The sorted array in ascending order.
	 *
	 * Sample Input:
	 * <pre>{@code
	 * Integer[] arr = {5, 3, 8, 4, 2};
	 * Integer[] sortedArr = bubbleSort(arr);
	 * }</pre>
	 *
	 * Sample Output:
	 * <pre>{@code
	 * sortedArr = [2, 3, 4, 5, 8];
	 * }</pre>
	 *
	 * Time Complexity:
	 * - Worst-case: O(n^2) (when the array is sorted in reverse order)
	 * - Best-case: O(n) (when the array is already sorted)
	 * - Average-case: O(n^2)
	 *
	 * Space Complexity:
	 * - O(1) (in-place sorting, no extra space used)
	 */
	public static Integer[] bubbleSort(Integer[] array) {
		for(int i=0;i<array.length;i++) {
			Boolean isSwapHappened = false;
			for(int j=i+1;j<array.length;j++) {
				if(array[i]>array[j]) {
					Integer temp = array[i];
					array[i]=array[j];
					array[j]=temp;
					isSwapHappened=true;
				}
			}
			if(!isSwapHappened) {
				break;
			}
		}
		return array;
	}
	
	
	/**
	 * 2. Quick Sort : Sorts an array of integers using the QuickSort algorithm.
	 * QuickSort is a divide-and-conquer algorithm that selects a pivot,
	 * partitions the array into two halves, and recursively sorts them.
	 *
	 * @param array The array of integers to be sorted.
	 * @param left  The starting index of the portion to be sorted.
	 * @param right The ending index of the portion to be sorted.
	 * @return The sorted array in ascending order.
	 *
	 * Sample Input:
	 * <pre>{@code
	 * Integer[] arr = {5, 3, 8, 4, 2};
	 * Integer[] sortedArr = quickSort(arr, 0, arr.length - 1);
	 * }</pre>
	 *
	 * Sample Output:
	 * <pre>{@code
	 * sortedArr = [2, 3, 4, 5, 8];
	 * }</pre>
	 *
	 * Time Complexity:
	 * - Worst-case: O(n^2) (when the smallest or largest element is always chosen as the pivot)
	 * - Best-case: O(n log n) (when the pivot divides the array into nearly equal parts)
	 * - Average-case: O(n log n)
	 *
	 * Space Complexity:
	 * - O(log n) (recursive stack space)
	 */
	public static Integer[] quickSort(Integer[] array, Integer left, Integer right) {
		// Base condition to stop recursion
		if (left >= right)
			return array;
		Integer i = left;
		Integer j = right;
		Integer pivot = left + (right - left) / 2;
		while (i <= j) {
			while (array[i] < array[pivot])
				i++;
			while (array[j] > array[pivot])
				j--;
			if (i <= j) {
				// Swap elements
				Integer temp = array[i];
				array[i++] = array[j];
				array[j--] = temp;
			}
		}

		// Recursively sort the left and right sub-arrays
		if (left < j)
			quickSort(array, left, j);
		if (i < right)
			quickSort(array, i, right);
		return array;
	}
	
	public static Integer[] mergeSort(Integer[] array) {
		if(array.length<=1) return array;
		Integer mid = array.length/2;
		Integer[] leftSubArray = Arrays.copyOfRange(array, 0, mid);
		Integer[] rightSubArray= Arrays.copyOfRange(array, mid, array.length);
		mergeSortedArrays(array,leftSubArray,rightSubArray);
		return array;
	}

	/**
	 * 3. Merge Sort : Implements the MergeSort algorithm to sort an array of integers.
	 * MergeSort is a divide-and-conquer algorithm that splits the array into 
	 * smaller subarrays, sorts them, and then merges the sorted subarrays.
	 *
	 * @param array The array of integers to be sorted.
	 * @return The sorted array in ascending order.
	 *
	 * Sample Input:
	 * <pre>{@code
	 * Integer[] arr = {5, 3, 8, 4, 2};
	 * Integer[] sortedArr = mergeSort(arr);
	 * }</pre>
	 *
	 * Sample Output:
	 * <pre>{@code
	 * sortedArr = [2, 3, 4, 5, 8];
	 * }</pre>
	 *
	 * Time Complexity:
	 * - Worst-case: O(n log n)
	 * - Best-case: O(n log n)
	 * - Average-case: O(n log n)
	 *
	 * Space Complexity:
	 * - O(n) (due to auxiliary arrays used in merging)
	 */
	private static void mergeSortedArrays(Integer[] array, Integer[] leftSubArray, Integer[] rightSubArray) {
		int i=0,j=0,k=0;
		// Merge two sorted sub arrays
		while(i<leftSubArray.length && j<rightSubArray.length) {
			if(leftSubArray[i]<rightSubArray[j]) {
				array[k++]=leftSubArray[i++];
			}else {
				array[k++]=rightSubArray[j++];
			}
		}
		
		// Copy any remaining elements from leftSubArray
		while(i<leftSubArray.length) {
			array[k++]=leftSubArray[i++];
		}
		
		// Copy any remaining elements from rightSubArray
		while(j<rightSubArray.length) {
			array[k++]=rightSubArray[j++];
		}
	}
}
