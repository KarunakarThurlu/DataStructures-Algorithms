package array;

import java.util.HashMap;
import java.util.Map;

public class Array {

	/*
	 * ================================== 
	 * Array Problems
	 * ==================================
	 *
	 * 1. Two Sum Problem
	 */
	
    /**
     * 1. Two Sum :
     * 
     * Finds the indices of two numbers in the array such that their sum equals the specified target.
     * 
     * <p>This method efficiently uses a HashMap to store and look up the complement of each number 
     * (i.e., the difference between the target and the current number). As the array is traversed, 
     * it checks if the complement already exists in the map. If found, the indices of the two numbers 
     * are returned immediately. Otherwise, the current number and its index are added to the map.</p>
     *
     * @param nums   the array of integers in which to find two numbers that add up to the target
     * @param target the sum that the two numbers should add up to
     * @return       an array containing the indices of the two numbers that add up to the target, 
     *               or {-1, -1} if no such pair exists
     *
     * <ul>
     * <li><strong>Time Complexity:</strong> O(n), where n is the length of the input array.</li>
     * <li><strong>Space Complexity:</strong> O(n), due to the use of the HashMap.</li>
     * </ul>
     *
     * <p>Example:</p>
     * <pre>
     *   Input: nums = [2, 7, 11, 15], target = 9
     *   Output: [0, 1]  (because nums[0] + nums[1] = 2 + 7 = 9)
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
}
