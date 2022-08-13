package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
		
		
		
		logger.log(Level.INFO, "Left  Rotating Array {0}",Arrays.toString(leftrRotateArray(new int[] {1,2,3,4,5,6,7,8,9},3))); //Left  Rotating Array [4, 5, 6, 7, 8, 9, 1, 2, 3]
		logger.log(Level.INFO, "Right Rotating Array {0}",Arrays.toString(rightRotateArray(new int[] {1,2,3,4,5,6,7,8,9},3))); //Right Rotating Array [7, 8, 9, 1, 2, 3, 4, 5, 6]
		logger.log(Level.INFO, "Reversed  Array      {0}",Arrays.toString(reverseArray(new int[] {1,2,3,4,5,6,7,8,9})));      //Reversed  Array  [9, 8, 7, 6, 5, 4, 3, 2, 1]
		logger.log(Level.INFO, "Reverse Array By Frequency {0}",Arrays.toString(reverseArrayByFrequency(new int[] {1,2,3,4,5,6,7,8,9},3))); //Reversed  Array  by frequency 3  [3, 2, 1, 6, 5, 4, 9, 8, 7]
		*/
		
		
		logger.log(Level.INFO, "Move Zeros to end {0}",Arrays.toString(moveZerosToEnd(new int[] {1,0,2,3,0,4,0,7,8,9})));
		

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
	 * @param i
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
