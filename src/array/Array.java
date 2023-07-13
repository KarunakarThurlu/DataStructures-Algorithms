package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Array {
	
	/*
	 *==================================
	 * Array Problems
	 *==================================
	 *
	 * 1. 	Two Sum Problem
	 * 2. 	Three Sum Problem
	 * 4. 	Merge Sorted Arrays
	 * 5. 	Sort Given Array
	 * 6. 	Reverse Given Array
	 * 7. 	Reverse Given Array by frequency
	 * 8. 	Sliding Window Maximum
	 * 9. 	Combination Sum
	 * 10.	Move Zeros to End
	 * 11.	Find  K'th largest element in array
	 * 12.  Permutations of Array 
	 * 13.  Combinations of Array
	 * 14.  Sub Array Sum equals to k
	 * 15.  Finding Peak Element
	 * 16.  Longest increasing sub array
	 * 17.  Candy's Distribution
	 * 18.  Median of Two Sorted Array's
	 * 19.  Find given element is present or not in given array
	 * 20.  Search in rotated sorted array
	 * 21.  Rotate Array(left,right)
	 * 22.  Find First and last position of given element in sorted array
	 * 23.  Spiral matrix
	 * 24.  Rotate Image
	 * 25.  Search in 2D array
	 * 26.  Subsets
	 * 27.  Pascal Triangle
	 * 28.  Missing number
	 * 29.  Majority element
	 * 30.  Intersection of two arrays
	 * 31.  Merge Interval
	 * 32.  Insert Interval
	 * 33.  Squares of sorted array
	 * 34.  Minimum Cost Climbing Stairs 
	 * 35.  Climbing Stairs
	 * 36.  Rain Water Trapping
	 * 37.  Best Time to buy and sell
	 * 38.  House Robber
	 * 39.  Flood Fill
	 * 40.  Max Area of Island
	 * 41.  Number of Islands
	 * 42.  Container with most water
	 * 43. 	Minimum Moves to Equal Array Elements
	 * 44.  Minimum Moves to Equal Array Elements II
	 * 45.  Find All Numbers Disappeared in an Array
	 * 49.  Top K Frequent Elements
	 * 50. 	Count of Smaller Numbers After Self
	 * 51.  Count Primes
	 * 52.  Jump Game
	 * 53.  Group Anagrams
	 * 54.  Search Insert Position
	 * 55. 	Remove Duplicates from Sorted Array
	 * 56.  Non-decreasing Array
	 * 57.  Find Duplicate Elements
	 * 58.  Two Sum II
	 * 59.  Two Sum less than target
	 * 60.  Shortest Word Distance
	 * 61.  Sum of Unique Elements
	 */
	private static final Logger logger= Logger.getLogger(Array.class.getName());
	
	public static void main(String... args) {
		
		/*
		logger.log(Level.INFO, "Two Sum  {0}",Arrays.toString(twoSum(new int[] {1,2,3,4,5,6,7,8,9},12)));  //indices of two elements whose sum is equal to 3  [4,6]
		logger.log(Level.INFO, "Three Sum  {0}",threeSum(new int[] {-1,0,1,2,-1,-4},0));  //Sum of Three elements in array whose sum is 0 ==> [[-1, -1, 2], [-1, 0, 1], [-1, 0, 1]]
		logger.log(Level.INFO, "Merge Sorted Arrays  {0}",Arrays.toString(mergeSortedArrays(new int[] {1,4,8,10,19},new int[] {3,5,9,12}))); //Merge Sorted Arrays  [1, 3, 4, 5, 8, 9, 10, 12, 19]
		logger.log(Level.INFO, "Sort array elements  {0}",Arrays.toString(sortGivenArray(new int[] {-1,0,1,2,12,44,78,19,-4},0,8))); //Sorted array elements  [-4, -1, 0, 1, 2, 12, 19, 44, 78]
		logger.log(Level.INFO, "Reverse Given Array {0}",Arrays.toString(reverseArray(new int[] {1,4,8,10,19}))); //Reverse Given Array Elements  [19, 10, 8, 4, 1]
		logger.log(Level.INFO, "Reverse Array By Frequency {0}",Arrays.toString(reverseArrayByFrequency(new int[] {1,4,8,10,19,21,23,25,27,29,31},3))); //Reverse Array By Frequency [8, 4, 1, 21, 19, 10, 27, 25, 23, 31, 29]
		logger.log(Level.INFO, "Sliding Window maximum {0}",Arrays.toString(slidingWindowMaximum(new int[] {1,3,-1,-3,5,3,6,7},3))); //Sliding Window maximum [3, 3, 5, 5, 6, 7]
		logger.log(Level.INFO, "Combination Sum {0}",combinationSum(new int[] {2,3,5},8)); //Combination Sum [[2, 2, 2, 2], [2, 3, 3], [3, 5]]
		logger.log(Level.INFO, "Move Zeros to end {0}",Arrays.toString(moveZerosToEnd(new int[] {1,0,2,3,0,4,0,7,8,9}))); //Move Zeros to end [1, 2, 3, 4, 7, 8, 9, 0, 0, 0]
		logger.log(Level.INFO, "Kth largest Element  {0}",kthLargestElementInArray(new int[] {3,5,1,2,6,9,7,8},4)); //4th largest Element  6
		logger.log(Level.INFO, "Permutations of Array {0}",permutationsOfGivenArrayElements(new int[] {1,2,3})); // Permutations of Array [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
		logger.log(Level.INFO, "Combinations of Array {0}",combinations(5,2)); // Combinations of Array [[1, 2], [1, 3], [1, 4], [1, 5], [2, 3], [2, 4], [2, 5], [3, 4], [3, 5], [4, 5]]
		logger.log(Level.INFO, "Merge Interval  {0} :", mergeInterVal(new int[][] {{1,4},{3,6},{7,9},{8,12}})); //Merge Intervals: [{1,6},{7,12},{13,16}]
		logger.log(Level.INFO, "Merge Interval  {0} :", mergeInterVal(new int[][] {{1,4},{3,6},{7,9},{8,12},new int[]{13,16}})); //[{1,6},{7,12},{13,16}]
		logger.log(Level.INFO, "Insert Interval {0} :", insertInterVal(new int[][] {{1,3},{6,9}},new int[] {2,5})); //[{1,5},{6,9}}]
		logger.log(Level.INFO, "Sub array Sum is equal to k  :  {0} ", subArraySumIsEqualToK(new int[] {1,2,3},3)); //Sub array Sum is equal to k  :  2 
		logger.log(Level.INFO, "Finding Longest Increasing SubArray  {0} ", findingLongestIncreasingSubArray(new int[] {12, 13, 1, 5, 4, 7, 8, 10, 10, 11})); //Finding Longest Increasing SubArray  4 
		logger.log(Level.INFO, "Candies required for Distribution  {0}  ", candysDistribution(new int[] {1,0,2}));  //Candys required for Distribution  5  
		logger.log(Level.INFO, "Median of Two Sorted Arrays :  {0}  ", medianOfTwoSortedArrays(new int[] {1,2,6,9,12,15},new int[] {3,5,7,10,13})); // Median of Two Sorted Arrays :  7 
		logger.log(Level.INFO, "Find given element is present or not in given array :  {0}  ", findGivenElementIsPresentOrNot(new int[] {1,2,6,9,12,15,19,21,25,29,31},29)); // 29 is present  at 9th index
		logger.log(Level.INFO, "Search in rotated sorted array :  {0}  ", searchInRoatedSortedArray(new int[] {25,29,31,1,2,6,9,12,15,19,21},0,10,9));  //Search in rotated sorted array :  6 
		logger.log(Level.INFO, "Left  Rotating Array {0}",Arrays.toString(leftrRotateArray(new int[] {1,2,3,4,5,6,7,8,9},3))); //Left  Rotating Array [4, 5, 6, 7, 8, 9, 1, 2, 3]
		logger.log(Level.INFO, "Right Rotating Array {0}",Arrays.toString(rightRotateArray(new int[] {1,2,3,4,5,6,7,8,9},3))); //Right Rotating Array [7, 8, 9, 1, 2, 3, 4, 5, 6]
		logger.log(Level.INFO, "Find First and last position of given element in sorted array {0}",Arrays.toString(findFirstAndLastPositionOfElement(new int[] {1,2,3,4,5,6,7,7,7,7,8,9},0,11,7))); //First and Last position of 7 is [6,9]
		logger.log(Level.INFO, "Spiral Matrix {0}",sprialMatrix(new int[][] {{11,22,33,44},{42,51,62,54},{71,88,19,67},{61,18,91,98}}));  //Spiral Matrix [11, 22, 33, 44, 54, 67, 98, 91, 18, 61, 71, 42, 51, 62, 19, 88]
		logger.log(Level.INFO, "Rotate Image {0}",Arrays.toString(rotateImage(new int[][] {{11,22,33},{42,51,62},{71,88,19}}))); //Rotate Image  {{71, 42, 11},{88, 51, 22},{19, 62, 33}}
		
		
		logger.log(Level.INFO, "Two Sum Less Than Target  {0}",twoSumLessThanTarget(new int[] {34,23,1,24,75,33,54,8},60)); //Two Sum Less Tthan Target  58
		logger.log(Level.INFO, "Reversed  Array      {0}",Arrays.toString(reverseArray(new int[] {1,2,3,4,5,6,7,8,9})));      //Reversed  Array  [9, 8, 7, 6, 5, 4, 3, 2, 1]
		logger.log(Level.INFO, "Reverse Array By Frequency {0}",Arrays.toString(reverseArrayByFrequency(new int[] {1,2,3,4,5,6,7,8,9},3))); //Reversed  Array  by frequency 3  [3, 2, 1, 6, 5, 4, 9, 8, 7]
		
		*/
		
		
	
		logger.log(Level.INFO, "Rotate Image {0}",Arrays.toString(rotateImage(new int[][] {{11,22,33},{42,51,62},{71,88,19}}))); 
   
	}
	
	/**
	 * 
	 * @param matrix
	 * @return
	 */
	public static Integer searchIn2DMatrix(int[][] matrix,int key) {
		for(int[] i : matrix) {
			for(int j:i) {
				if(j==key)
					return j;
			}
		}
		return -1;
	}
	/**
	 * 
	 * @param matrix
	 * @return
	 */
	public static int[][] rotateImage(int[][] matrix){
		int row=matrix.length;
		int col=matrix[0].length;
		for(int i=0;i<row;i++) {
			for(int j=i+1;j<col;j++) {
				int t=matrix[i][j];
				matrix[i][j]=matrix[j][i];
				matrix[j][i]=t;
			}
		}
		for(int i=0;i<row;i++) {
			for(int j=0;j<col/2;j++) {
				int t=matrix[i][j];
				matrix[i][j]=matrix[i][row-j-1];
				matrix[i][row-j-1]=t;
			}
		}
		for(int[] a:matrix) {
			logger.log(Level.INFO,"{0}",Arrays.toString(a));
		}
		return matrix;
	}
	/**
	 * 
	 * @param matrix
	 * @return
	 */
	public static List<Integer> spiralMatrix(int[][] matrix) {
		List<Integer> result=new ArrayList<>();
		int rowStart=0;
		int rowEnd=matrix.length-1;
		int colStart=0;
		int colEnd=matrix[0].length-1;
		while(colStart<=colEnd && rowStart<=rowEnd) {
			for(int i=colStart;i<=colEnd;i++)
				result.add(matrix[rowStart][i]);
			rowStart++;
			for(int i=rowStart;i<=rowEnd;i++)
				result.add(matrix[i][colEnd]);
			colEnd--;
			if(rowStart<=rowEnd)
				for(int i=colEnd;i>=colStart;i--)
					result.add(matrix[rowEnd][i]);
			rowEnd--;
			if(colStart<=colEnd)
				for(int i=rowEnd;i>=rowStart;i--)
					result.add(matrix[i][colStart]);
			colStart++;
		}
		return result;
	}
	
	/**
	 * 
	 * @param array
	 * @param key
	 * @return
	 */
	public static int[] findFirstAndLastPositionOfElement(int[] array,int left,int right,int key) {
		if(left>right)
			return new int[] {-1,-1};
		int mid=left+(right-left)/2;
		if(key==array[mid]) {
			int l=mid;
			int r=mid;
			while(array[l]==array[mid])
				l--;
			while(array[r]==array[mid])
				r++;
			return new int[] {l+1,r-1};
		}else if(array[mid]<key) {
			return findFirstAndLastPositionOfElement(array,mid+1,right,key);
		}else {
			return findFirstAndLastPositionOfElement(array,left,mid-1,key);
		}
	}
	
	/**
	 * 
	 * @param array
	 * @param key
	 * @return
	 */
	public static Integer searchInRoatedSortedArray(int[] array,int left ,int right,int key) {
		if(left>right)
			return -1;

		int mid=left+(right-left)/2;
		if(array[mid]==key)
			return mid;
		if(array[left]<=array[mid]) {
			if(array[left]<=key && array[mid]>=key)
				return searchInRoatedSortedArray(array,left,mid-1,key);
			else
				return searchInRoatedSortedArray(array,mid+1,right,key);
		}else {
			if(array[mid]<=key && array[right]>=key)
				return searchInRoatedSortedArray(array,mid+1,right,key);
			else
				return searchInRoatedSortedArray(array,left,mid-1,key);
		}
	}
	/**
	 * 
	 * @param  array
	 * @param target
	 * @return element index
	 */
	public static Integer findGivenElementIsPresentOrNot(int[] array,int target) {
		int left=0;
		int right=array.length-1;
		
		while(left<=right) {
			int mid=left+(right-left)/2;
			if(array[mid]==target)
				return mid;
			else if(array[mid]<target)
				left=mid+1;
			else
				right=mid-1;
		}
		return -1;
	}
	
	/**
	 * Finding median of given two sorted arrays
	 * @param firstArray
	 * @param secondArray
	 * @return 
	 */
	public static Double medianOfTwoSortedArrays(int[] firstArray,int[] secondArray) {
		Integer firstArrayLength=firstArray.length;
		Integer secondArrayLength=secondArray.length;
		double[] resultArray=new double[firstArrayLength+secondArrayLength];
		
		Integer resultArrayIndex=0;
		Integer firstArrayIndex=0;
		Integer secondArrayIndex=0;
		
		while(firstArrayIndex<firstArrayLength && secondArrayIndex< secondArrayLength) {
			if(firstArray[firstArrayIndex]<secondArray[secondArrayIndex])
				resultArray[resultArrayIndex++]=firstArray[firstArrayIndex++];
			else
				resultArray[resultArrayIndex++]=secondArray[secondArrayIndex++];
		}
			
		while(firstArrayIndex<firstArrayLength) 
			resultArray[resultArrayIndex++]=firstArray[firstArrayIndex++];
		
		while(secondArrayIndex<secondArrayLength) 
			resultArray[resultArrayIndex++]=secondArray[secondArrayIndex++];
		
		double result=0;
		int mid=resultArray.length/2;
		
		if(resultArray.length%2==0) {
			result = resultArray[mid-1]+resultArray[mid];
		}else {
			result = resultArray[mid];
		}
		return result;
	}
	
	/**
	 * Find two elements those two elements sum is equal to target element
	 * @param array
	 * @param target
	 * @return two elements index position
	 */
	public static int[] twoSum(int[] array,int target) {
		Map<Integer, Integer> map=new HashMap<>();
		for(int i=0;i<array.length;i++) 
			if(map.containsKey(target-array[i]))
				return new int[] {map.get(target-array[i]),i};
			else
				map.put(array[i],i);	
		return new int[] {-1,-1};
	}
	
	/**
	 * Two Sum II (Array Elements are already sorted
	 * @param array
	 * @param target
	 * @return
	 */
	public static int[] twoSumII(int[] array,int target) {
		int l=0;
		int r=array.length-1;
		while(l<=r) {
			int s=array[l]+array[r];
			if(s==target)
				return new int[] {l+1,r+1};
			else if(s<target)
				l++;
			else 
				r--;
		}
		return new int[] {-1,-1};
	}
	/**
	 * Two Sum less Than target
	 * @param array
	 * @param target
	 * @return 
	 */
	public static int twoSumLessThanTarget(int[] array,int target) {
		Arrays.sort(array);
		int max=Integer.MIN_VALUE;
		int l=0;
		int r=array.length-1;
		while(l<r) {
			int s=array[l]+array[r];
			if(s<=target) {
				max=Math.max(max, s);
				l++;
			}else {
				r--;
			}
		}
		return max;
	}
	/**
	 * 
	 * @param array
	 * @param target
	 * @return
	 */
	public static List<List<Integer>> threeSum(int[] array,int target){
		List<List<Integer>> res=new ArrayList<>();
		Arrays.sort(array);
		for(int i=0;i<array.length;i++) {
			int j=i+1;
			int k=array.length-1;
			while(j<k) {
				int s=array[i]+array[j]+array[k];
				if(s==target) 
					res.add(Arrays.asList(array[i],array[j++],array[k--]));
				if(s<target) 
					j++;
				if(s>0)
					k--;
			}
		}
		return res;
	}
	
	/**
	 * Merge Given Sorted arrays
	 * @param x
	 * @param y
	 * @return merged array
	 */
	public static int[] mergeSortedArrays(int[] x,int[] y) {
		int i=0;
		int j=0;
		int k=0;
		int[] z=new int[x.length+y.length];
		while(i<x.length && j<y.length) {
			if(x[i]<=y[j])
				z[k++]=x[i++];
			else
				z[k++]=y[j++];
		}
		while(i<x.length)
			z[k++]=x[i++];
		while(j<y.length)
			z[k++]=y[j++];
		return z;
	}
	
	/**
	 * Sort Given array elements
	 * @param array
	 * @param left
	 * @param right
	 * @return
	 */
	public static int[] sortGivenArray(int[] array,int left,int right) {
		int i=left;
		int j=right;
		int p=array[(left+right)/2];
		while(i<=j) {
			while(array[i]<p)
				i++;
			while(array[j]>p)
				j--;
			if(i<=j) {
				int t=array[i];
				array[i++]=array[j];
				array[j--]=t;
			}
		}
		if(left<j)
			sortGivenArray(array,left,j);
		if(i<right)
			sortGivenArray(array,i,right);
		return array;
	}
	
	/**
	 * Reverse given array
	 * @param array
	 * @return reversed array
	 */
	public static int[] reverseArray(int[] array) {
		int left =0;
		int right=array.length-1;
		swap(array, left, right);
		return array;
	}
	
	/**
	 * Reverse array by frequency
	 * @param array
	 * @param k
	 * @return
	 */
	public static int[] reverseArrayByFrequency(int[] array,int k) {
		for(int i=0;i<array.length;i=i+k) {
			int left=i;
			int right=Math.min(i+k-1, array.length-1);
			swap(array, left, right);
		}
		return array;
	}
	
	/**
	 * 
	 * @param array
	 * @param k
	 * @return
	 */
	public static int[] slidingWindowMaximum(int[] array,int k) {
		int[] res=new int[array.length-k+1];
		int c=0;
		for(int i=0;i<=array.length-k;i++) {
			int l=i;
			int r=i+k;
			
			Integer max=Integer.MIN_VALUE;
			for(int j=l;j<r;j++) {
				max=Math.max(max, array[j]);
			}
			res[c++]=max;
		}
		return res;
	}
	
	/**
	 * 
	 * @param array
	 * @param target
	 * @return
	 */
	public static List<List<Integer>> combinationSum(int[] array,int target){
		List<List<Integer>> res=new ArrayList<>();
		List<Integer> list=new ArrayList<>();
		combinationSum(res,list,array,target,0);
		return res;
	}
	
	/**
	 * 
	 * @param res
	 * @param list
	 * @param array
	 * @param target
	 * @param index
	 */
	private static void combinationSum(List<List<Integer>> res, List<Integer> list, int[] array, int target, int index) {
		if(target==0) {
			res.add(new ArrayList<>(list));
			return;
		}
		for(int i=index;i<array.length;i++) {
			if(target-array[i]>=0) {
				list.add(array[i]);
				combinationSum(res,list,array,target-array[i],i);
				list.remove(list.size()-1);
			}else {
				continue;
			}
		}
		
	}
	
	/**
	 * 
	 * @param array
	 * @return array all zeros moved to end
	 */
	public static int[] moveZerosToEnd(int[] array) {
		int zeroindex=0;
		for(int i=0;i<array.length;i++) {
			if(array[i]!=0) {
				int t=array[zeroindex];
				array[zeroindex++]=array[i];
				array[i]=t;
			}
		}
		return array;
	}
	
	/**
	 * 
	 * @param array
	 * @param k
	 * @return
	 */
	public static int kthLargestElementInArray(int[] array,int k) {
		Queue<Integer> queue=new PriorityQueue<>();
		for(int i=0;i<array.length;i++) {
			queue.offer(array[i]);
			if(queue.size()>k) {
				queue.remove();
			}
		}
		return queue.peek();
	}

	/**
	 * 
	 * @param a
	 * @return
	 */
	public static List<List<Integer>> permutationsOfGivenArrayElements(int[] a) {
		List<List<Integer>> res=new ArrayList<>();
		List<Integer> list=new ArrayList<>();
		boolean[] visited=new boolean[a.length];
		permutationsOfGivenArrayElements(res,list,a,visited);
		return res;
	}
	
	/**
	 * 
	 * @param res
	 * @param list
	 * @param a
	 * @param visited
	 */
	private static void permutationsOfGivenArrayElements(List<List<Integer>> res, List<Integer> list, int[] a,boolean[] visited) {
		if(list.size()==a.length) {
			res.add(new ArrayList<>(list));
			return;
		}
		for(int i=0;i<a.length;i++) {
			if(!visited[i]) {
				visited[i]=true;
				list.add(a[i]);
				permutationsOfGivenArrayElements(res,list,a,visited);
				visited[i]=false;
				list.remove(list.size()-1);
			}
		}
		
	}
	
	/**
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
	public static List<List<Integer>> combinations(int n,int k){
		List<List<Integer>> res=new ArrayList<>();
		List<Integer> l=new ArrayList<>();
		combinations(res,l,n,k,1);
		return res;
	}
	
	/**
	 * Merge Intervals of given array
	 * @param array
	 * @return
	 */
	public static String mergeInterVal(int[][] array){
		Arrays.sort(array, (a,b)->a[0]-b[0]);
		List<int[]> res=new ArrayList<>();
		int[] prev=array[0];
		for(int[] curr:array) {
			int cs=curr[0];
			int ce=curr[1];
			int pe=prev[1];
			if(cs<=pe) {
				prev[1]=Math.max(ce, pe);
			}else {
				res.add(prev);	
				prev=curr;
			}
		}
		res.add(prev);
		for(int i=0;i<res.size();i++)
			logger.log(Level.INFO, "MergeInterval of Array {0}", Arrays.toString(res.get(i)));
		return "Merge Intervals: ";
	}
	
	/**
	 * { {1,4},{5,6},{9,10}} {7,8}
	 * @param array
	 * @param interval
	 * @return
	 */
	public static String insertInterVal(int[][] array,int[] interval) {
		Arrays.sort(array,(a,b)->a[0]-b[0]);
		List<int[]> list=new ArrayList<>();
		int[] temp=interval;
		for(int i=0;i<array.length;i++) {
			if(temp[0]>array[i][1]) {
				list.add(array[i]);
			}else if(temp[1]<array[i][1]) {
				list.add(temp);
				temp=array[i];
			}else {
				temp[0]=Math.min(temp[0], array[i][0]);
				temp[1]=Math.max(temp[1], array[i][1]);
			}
		}
		list.add(temp);
		for(int i=0;i<list.size();i++)
			logger.log(Level.INFO, "MergeInterval of Array {0}", Arrays.toString(list.get(i)));
		return "Insert Interval: ";
	}
	
	/**
	 * 
	 * @param array
	 * @param k
	 * @return
	 */
	public static int subArraySumIsEqualToK(int[] array,int k) {
		int n=array.length;
		int sum=0;
		int count=0;
		for(int i=0;i<n;i++) {
			sum=array[i];
			if(sum==k)
				count++;
			for(int j=i+1;j<n;j++) {
				sum=sum+array[j];
				if(sum==k)
					count++;
			}
		}
		return count;		
	}
	/**
	 * Find peak element
	 * @param array
	 * @return
	 */
	public static int findPeakElement(int[] array) {
		for(int i=0;i<array.length-1;i++) {
			if(array[i]>array[i+1] ){
				return i;
			}
		}
		return array.length-1;
	}
	/**
	 * 
	 * @param array
	 * @return
	 */
	public static int findingLongestIncreasingSubArray(int[] array) {
		int count=1;
		int max=0;
		for(int i=0;i<array.length-1;i++) {
			if(array[i+1]>array[i]) {
				count++;
			}else {
				max=Math.max(max, count);
				count=1;
			}
		}
		return max;
	}
	
	/**
	 * 
	 * @param ratings
	 * @return
	 */
	public static int candysDistribution(int[] ratings) {
		int n=ratings.length;
		int[] cost=new int[n];
		Arrays.fill(cost, 1);
		for(int i=1;i<n;i++) {
			if(ratings[i]>ratings[i-1])
				cost[i]=cost[i-1]+1;
		}
		int s=cost[cost.length-1];
		for(int i=ratings.length-2;i>=0;i--) {
			if(ratings[i]>ratings[i+1])
				cost[i]=Math.max(cost[i], cost[i+1]+1);
			s=s+cost[i];
		}
		return s;
	}
	
	/**
	 * 
	 * @param nums
	 * @return
	 */
	public static int sumOfUniqueElements(int[] nums) {
		
		Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]))
                map.put(nums[i],map.get(nums[i])+1);
            else
                map.put(nums[i],1);
        }
        int s=0;
        for(Entry<Integer,Integer> e:map.entrySet()) {
        	if(e.getValue()==1) {
        		s=s+e.getKey();
        	}
        }
        return s;
	}
	/**
	 * 
	 * @param res
	 * @param l
	 * @param n
	 * @param k
	 * @param index
	 */
	private static void combinations(List<List<Integer>> res, List<Integer> l, int n, int k, int index) {
		if(k==0) {
			res.add(new ArrayList<>(l));
			return;
		}
		for(int i=index;i<=n-k+1;i++) {
			l.add(i);
			combinations(res,l,n,k-1,i+1);
			l.remove(l.size()-1);
		}
	}

	/**
	 * 
	 * @param n
	 * @return
	 */
	public static int climbStairs(int n) {
		if(n==1)
			return n;
		if(n==2)
			return n;
		int p=1;
		int q=1;
		for(int i=2;i<=n;i++) {
			int t=q;
			q=p+q;
			p=t;
		}
		return q;
	}
	
	/**
	 * 
	 * @param cost
	 * @return
	 */
	public static int minimumCostClimbingStairs(int[] cost) {
		int n=cost.length;
		int[]  res = new int[n];
		Arrays.fill(res, -1);
		res[0]=cost[0];
		res[1]=cost[1];
		
		for(int i=2;i<=n;i++) {
			res[i]=cost[i]+Math.min(res[i-1], res[i-2]);
		}
		return Math.min(res[n-1], res[n-2]);
	}
	/**
	 * 
	 * @param array
	 * @return
	 */
	public static int houseRobber(int[] array) {
		int p=0;
		int q=0;
		for(int i=0;i<array.length;i++) {
			int t=q+array[i];
			q=Math.max(q, p);
			p=t;
		}
		return Math.max(p, q);
	}
	

	/**
	 * 
	 * @param str
	 * @return
	 */
	public static Boolean robotReturnToOriginPosition(String str) {
		Integer x=0;
		Integer y=0;
		for(Character c:str.toCharArray()) {
			if(c=='U')
				y=y+1;
			else if(c=='D')
				y=y-1;
			else if(c=='L')
				x=x-1;
			else
				x=x+1;
		}
		return x==0 && y==0;
	}
	/**
	 * 
	 * @param array
	 * @return
	 */
	public static int[] removeDuplicatesFromSortedArray(int[] array) {
		return Arrays.stream(array).distinct().toArray();
	}
	
	/**
	 * 
	 * @param array
	 * @return
	 */
	public static Integer jumpGameII(int[] array) {
		int jumps = 0;
		int farthest = 0;
		int current = 0;
		for (int i = 0; i < array.length - 1; i++) {
			farthest = Math.max(farthest, array[i] + i);
			if (i == current) {
				current = farthest;
				jumps++;
			}
			if (current == array.length - 1) {
				return jumps;
			}
		}
		return jumps;
	}
	
	/**
	 * 
	 * @param array
	 * @return
	 */
	public static Boolean jumpGame(int[] array) {
		Integer currentPosition=0;
		for(int index=0;index<array.length;index++) {
			if(index>currentPosition)
				return Boolean.FALSE;
			currentPosition=Math.max(currentPosition,array[index]+index);
		}
		return Boolean.TRUE;
	}
	
	/**
	 * 
	 * @param words
	 * @param word1
	 * @param word2
	 * @return
	 */
	public static int shortestWordDistance(String[] words,String word1,String word2) {
		int i1=-1;
		int i2=-1;
		int max=words.length;
		for(int i=0;i<words.length;i++) {
			if(words[i].equals(word1)) {
				i1=i;
			}
			if(words[i].equals(word2)) {
				i2=i;
			}
			if(i1!=-1 && i2!=-1) {
				max=Math.min(max, Math.abs(i1-i2));
			}
		}
		return max;
	}
	
	
	/**
	 * Rotate Right to  n times
	 * @param array
	 * @param rotationCount
	 * @return right rotated array
	 */
	public static int[] rightRotateArray(int[] array,int rotationCount) {
		int larrayLength=array.length;
		swap(array,0,larrayLength-rotationCount-1);
		swap(array,larrayLength-rotationCount, larrayLength-1);
		swap(array,0,larrayLength-1);
		return array;
	}
	
	/**
	 * Rotate Left to  n times
	 * @param array
	 * @param rotationCount
	 * @return left Rotated Array
	 */
	public static int[] leftrRotateArray(int[] array,int rotationCount) {
		int larrayLength=array.length;
		swap(array,0,rotationCount-1);
		swap(array,rotationCount,larrayLength-1);
		swap(array,0,larrayLength-1);
		return array;
	}
	
	/**
	 * Swap given array elements
	 * @param array
	 * @param left
	 * @param right
	 */
	public static void swap(int[] array,int left,int right) {
		while(left<right) {
			int t=array[left];
			array[left++]=array[right];
			array[right--]=t;
		}
	}
}
