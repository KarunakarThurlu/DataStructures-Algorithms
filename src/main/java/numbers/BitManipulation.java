package numbers;

import java.util.ArrayList;
import java.util.List;

public class BitManipulation {
	/*
	 * 
	 * What is bit manipulation?
	 * 
	 * 1. Bit manipulation is a technique used to perform operations on individual bits of data.
	 * 2. It is often used in low-level programming, such as embedded systems and operating systems, where performance and memory efficiency are critical.
	 * 3. Bit manipulation can be used to perform a variety of operations, such as setting, clearing, toggling, and checking the value of specific bits in a binary representation of a number.
	 * 	 
	 * Common bit manipulation operations include:
	 * 	  - Bitwise AND (&): This operation takes two bits and returns 1 if both bits are 1, otherwise it returns 0.
	 * 	 	Example: 5 & 3 = 1 (in binary: 0101 & 0011 = 0001)
	 *    
	 *    - Bitwise OR (|): This operation takes two bits and returns 1 if at least one of the bits is 1, otherwise it returns 0.
	 * 		Example: 5 | 3 = 7 (in binary: 0101 | 0011 = 0111)	  
	 * 	  
	 *    - Bitwise XOR (^): This operation takes two bits and returns 1 if the bits are different, otherwise it returns 0.
	 * 	    Example: 5 ^ 3 = 6 (in binary: 0101 ^ 0011 = 0110)
	 * 	  
	 *    - Bitwise NOT (~): This operation takes a single bit and returns the opposite value (0 becomes 1, and 1 becomes 0).
	 *    	Example: ~5 = -6 (in binary: ~0101 = 1010, which is -6 in two's complement representation)
	 *    
	 *    - Left Shift (<<): This operation shifts the bits of a number to the left by a specified number of positions, filling the rightmost bits with zeros.
	 *      Example: 5 << 1 = 10 (in binary: 0101 << 1 = 1010)
	 *    
	 *    - Right Shift (>>): This operation shifts the bits of a number to the right by a specified number of positions. The behavior of the right shift depends on the type of the number (signed or unsigned).
	 *      Example: 5 >> 1 = 2 (in binary: 0101 >> 1 = 0010)
	 *      
	 *      
	 *    Bit manipulation is often used in various applications, such as:
	 *    - Optimizing performance by reducing the number of operations needed to manipulate data.
	 *    - Implementing algorithms that require direct manipulation of bits, such as encryption, compression, and error detection.
	 * 
	 * 
	 * 
	 * 
	 * ---------------------------------
	 * Bit manipulation coding questions
	 * ---------------------------------
	 * 
	 * 1. Count the number of set bits in an integer.
	 * 2. Check if a number is a power of two.
	 * 3. Find the single non-repeated element in an array where every other element is repeated twice.
	 * 4. Swap two numbers without using a temporary variable.
	 * 5. Reverse the bits of a given integer.
	 * 6. Determine if two integers have opposite signs.
	 * 7. Find the position of the rightmost set bit in an integer.
	 * 8. Check if a number is a power of four.
	 * 9. Check if a number is a even or odd using bit manipulation.
	 * 10.Find the missing number in an array of size n-1 containing numbers from 1 to n.
	 * 11.Find number appearing one time repeated twice in an array.
	 * 12.Find the two non-repeated elements in an array where every other element is repeated twice.
	 * 13.Subsets of a set using bit manipulation.
	 * 14.Count number of 1 bits
	 * 15.Find the duplicate number
	 * 
	 * 
	 */
	
	/**
	 * 1. Count the number of set bits in an integer.
	 * 
	 * <pre>
	 * Description: Given an integer n, count the number of set bits (1s) in its binary representation.
	 * 
	 * Example 1: Input: n = 5 (binary: 101) Output: 2
	 * Example 2: Input: n = 7 (binary: 111) Output: 3
	 * Example 3: Input: n = 0 (binary: 0) Output: 0
	 * Example 4: Input: n = 15 (binary: 1111) Output: 4
	 * 
	 * Time complexity: O(log n), where n is the value of the integer, because we are checking each bit.
	 * Space complexity: O(1), as we are using a constant amount of space to store the count.
	 * 
	 * Approach:
	 * 
	 * 1. Initialize a count variable to 0 to keep track of the number of set bits.
	 * 2. Use a while loop to iterate until n becomes 0.
	 * 3. In each iteration, increment the count by 1 and update n by performing a bitwise AND operation between n and (n-1). This operation removes the rightmost set bit from n.
	 * 4. Return the count after the loop ends, which will give the total number of set bits in the integer n.
	 * 
	 * </pre>
	 * 
	 * @param n the integer for which we want to count the set bits
	 * @return the number of set bits in the binary representation of n
	 */
	public static int countSetBits(int n) {
		int count=0;
		while(n>0) {
			count++;
			n = n & (n-1); // This operation removes the rightmost set bit from n
		}
		return count;
	}
	
	
	/**
	 * 2. Check if a number is a power of two.
	 * 
	 * <pre>
	 * Description: Given an integer n, determine if it is a power of two. A number is a power of two if it has exactly one set bit in its binary representation.
	 * 
	 * Example 1: Input: n = 1 (binary: 1) Output: true
	 * Example 2: Input: n = 2 (binary: 10) Output: true
	 * Example 3: Input: n = 3 (binary: 11) Output: false
	 * Example 4: Input: n = 4 (binary: 100) Output: true
	 * Example 5: Input: n = 0 (binary: 0) Output: false
	 * 
	 * Time complexity: O(1), as we are performing a constant number of operations to check if n is a power of two.
	 * Space complexity: O(1), as we are using a constant amount of space to store the result.
	 * 
	 * Approach:
	 * 
	 * 1. A number that is a power of two has exactly one set bit in its binary representation. For example, 1 (2^0), 2 (2^1), 4 (2^2), etc.
	 * 2. To check if n is a power of two, we can use the expression (n & (n - 1)). This expression will be equal to zero if n has only one set bit, because it will remove that set bit and leave us with zero.
	 * 3. Additionally, we need to ensure that n is greater than zero, as powers of two are positive integers.
	 * 
	 * </pre>
	 * 
	 * @param n the integer to check for being a power of two
	 * @return true if n is a power of two, false otherwise
	 */
	public static boolean isPowerOfTwo(int n) {
		return n > 0 && (n & (n - 1)) == 0;
	}
	
	
	/**
	 * 3. Find the single non-repeated element in an array where every other element is repeated twice.
	 * 
	 * <pre>
	 * Description: Given an array of integers where every element appears twice except for one, find the single non-repeated element.
	 * 
	 * Example 1: Input: arr = [2, 3, 5, 4, 5, 3, 4] Output: 2
	 * Example 2: Input: arr = [1, 1, 2] Output: 2
	 * Example 3: Input: arr = [4, 1, 2, 1, 2] Output: 4
	 * 
	 * Time complexity: O(n), where n is the number of elements in the array, as we need to iterate through the array once.
	 * Space complexity: O(1), as we are using a constant amount of space to store the result.
	 * 
	 * Approach:
	 * 
	 * 1. We can use the XOR operator (^) to find the single non-repeated element. The XOR operator has a property that it returns zero when two identical numbers are XORed together and returns the number itself when XORed with zero.
	 * 2. Initialize a variable result to zero and iterate through each element in the array. For each element, perform a XOR operation with result and update result with the new value.
	 * 3. After iterating through the entire array, result will hold the value of the single non-repeated element.
	 * 
	 * </pre>
	 * 
	 * @param arr the input array containing integers where every element appears twice except for one
	 * @return the single non-repeated element in the array
	 */
	public static int findSingleNonRepeated(int[] arr) {
		int result = 0;
		for (int num : arr) {
			result ^= num; // XOR operation to find the single non-repeated element
		}
		return result;
	}
	
	/**
	 * 4. Swap two numbers without using a temporary variable.
	 * 
	 * <pre>
	 * Description: Given two integers a and b, swap their values without using a temporary variable.
	 * 
	 * Example 1: Input: a = 5, b = 10 Output: a = 10, b = 5
	 * Example 2: Input: a = -3, b = 7 Output: a = 7, b = -3
	 * 
	 * Time complexity: O(1), as we are performing a constant number of operations to swap the values.
	 * Space complexity: O(1), as we are using a constant amount of space to store the variables.
	 * 
	 * Approach:
	 * 
	 * 1. We can use the XOR operator (^) to swap the values of a and b without using a temporary variable.
	 * 2. First, we perform a XOR operation between a and b and store the result in a. This will give us the combined value of both numbers.
	 * 3. Next, we perform a XOR operation between the new value of a and b, which will give us the original value of a and store it in b.
	 * 4. Finally, we perform another XOR operation between the new value of a and the new value of b, which will give us the original value of b and store it in a.
	 * 
	 * </pre>
	 * 
	 * @param a the first integer to be swapped
	 * @param b the second integer to be swapped
	 */
	public static int[] swapWithoutTemp(int a, int b) {
		a = a ^ b; // Step 1: a now holds the combined value of a and b
		b = a ^ b; // Step 2: b now holds the original value of a
		a = a ^ b; // Step 3: a now holds the original value of b
		return new int[]{a, b}; // Return the swapped values as an array
	}
	
	/**
	 * 5. Reverse the bits of a given integer.
	 * 
	 * <pre>
	 * Description: Given an integer n, reverse its bits and return the resulting integer.
	 * 
	 * Example 1: Input: n = 5 (binary: 00000000000000000000000000000101) Output: 2684354560 (binary: 10100000000000000000000000000000)
	 * Example 2: Input: n = 1 (binary: 00000000000000000000000000000001) Output: 2147483648 (binary: 10000000000000000000000000000000)
	 * Example 3: Input: n = 0 (binary: 00000000000000000000000000000000) Output: 0 (binary: 00000000000000000000000000000000)
	 *
	 * Time complexity: O(1), as we are performing a constant number of operations to reverse the bits.
	 * Space complexity: O(1), as we are using a constant amount of space to store the result.
	 * 
	 * </pre>
	 * 
	 * @param n the integer whose bits are to be reversed
	 * @return the integer resulting from reversing the bits of n
	 */
	public static int reverseBits(int n) {
		int result = 0;
		for (int i = 0; i < 32; i++) {
			result <<= 1; // Shift result to the left to make room for the next bit
			result |= (n & 1); // Add the least significant bit of n to result
			n >>= 1; // Shift n to the right to process the next bit
		}
		return result;
	}
	
	/**
	 * 6. Determine if two integers have opposite signs.
	 * 
	 * <pre>
	 * Description: Given two integers a and b, determine if they have opposite signs. Two integers have opposite signs if one is positive and the other is negative.
	 * 
	 * Example 1: Input: a = 5, b = -3 Output: true
	 * Example 2: Input: a = -4, b = 7 Output: true
	 * Example 3: Input: a = 0, b = -1 Output: false (0 is considered non-negative)
	 * Example 4: Input: a = -2, b = -5 Output: false (both are negative)
	 * 
	 * Time complexity: O(1), as we are performing a constant number of operations to check the signs.
	 * Space complexity: O(1), as we are using a constant amount of space to store the result.
	 * 
	 * Approach:
	 * 
	 * 1. We can use the XOR operator (^) to determine if two integers have opposite signs. If a and b have opposite signs, then their XOR will have its most significant bit set to 1 (indicating a negative result).
	 * 2. Additionally, we need to ensure that neither a nor b is zero, as zero is considered non-negative and would not be considered as having an opposite sign with any number.
	 * 
	 * </pre>
	 * 
	 * @param a the first integer
	 * @param b the second integer
	 * @return true if a and b have opposite signs, false otherwise
	 */
	public static boolean haveOppositeSigns(int a, int b) {
		return (a ^ b) < 0; // If a and b have opposite signs, their XOR will be negative
	}
	
	/**
	 * 7. Find the position of the rightmost set bit in an integer.
	 * 
	 * <pre>
	 * Description: Given an integer n, find the position of the rightmost set bit (1) in its binary representation. The position is counted from 1 starting from the least significant bit.
	 * 
	 * Example 1: Input: n = 18 (binary: 10010) Output: 2 (the rightmost set bit is at position 2)
	 * Example 2: Input: n = 12 (binary: 1100) Output: 3 (the rightmost set bit is at position 3)
	 * Example 3: Input: n = 0 (binary: 0) Output: -1 (no set bits)
	 * 
	 * Time complexity: O(1), as we are performing a constant number of operations to find the position of the rightmost set bit.
	 * Space complexity: O(1), as we are using a constant amount of space to store the result.
	 * 
	 * Approach:
	 * 
	 * 1. We can use the expression n & (-n) to isolate the rightmost set bit in n. This works because -n is the two's complement of n, which flips all bits and adds one, effectively isolating the rightmost set bit.
	 * 2. Once we have isolated the rightmost set bit, we can use a loop to count how many bits we need to shift to the right until we reach that bit, which will give us its position.
	 * 
	 * </pre>
	 * 
	 * @param n the integer for which we want to find the position of the rightmost set bit
	 * @return the position of the rightmost set bit in n, or -1 if there are no set bits
	 */
	public static int rightmostSetBitPosition(int n) {
		if (n == 0) {
			return -1; // No set bits
		}
		int rightmostSetBit = n & (-n); // Isolate the rightmost set bit
		int position = 1; // Position starts from 1
		while (rightmostSetBit > 1) {
			rightmostSetBit >>= 1; // Shift right to find the position
			position++;
		}
		return position;
	}
	
	/**
	 * 8. Check if a number is a power of four.
	 * 
	 * <pre>
	 * Description: Given an integer n, determine if it is a power of four. A number is a power of four if it can be expressed as 4^k for some non-negative integer k.
	 * 
	 * Example 1: Input: n = 1 (4^0) Output: true
	 * Example 2: Input: n = 4 (4^1) Output: true
	 * Example 3: Input: n = 16 (4^2) Output: true
	 * Example 4: Input: n = 5 Output: false
	 * Example 5: Input: n = 0 Output: false
	 * 
	 * Time complexity: O(1), as we are performing a constant number of operations to check if n is a power of four.
	 * Space complexity: O(1), as we are using a constant amount of space to store the result.
	 * 
	 * Approach:
	 * 
	 * 1. A number that is a power of four has exactly one set bit in its binary representation, and that set bit must be in an odd position (1st, 3rd, 5th, etc.).
	 * 2. To check if n is a power of four, we can first check if it is greater than zero and has only one set bit using the expression (n & (n - 1)) == 0.
	 * 3. Additionally, we need to ensure that the single set bit is in an odd position. We can do this by checking if n & 0x55555555 is not equal to zero, which ensures that the set bit is in one of the odd positions.
	 * 
	 * </pre>
	 * 
	 * @param n the integer to check for being a power of four
	 * @return true if n is a power of four, false otherwise
	 */
	public static boolean isPowerOfFour(int n) {
		return n > 0 && (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
	}
	
	/**
	 * 9. Check if a number is even or odd using bit manipulation.
	 * 
	 * <pre>
	 * Description: Given an integer n, determine if it is even or odd using bit manipulation.
	 * 
	 * Example 1: Input: n = 4 Output: "Even"
	 * Example 2: Input: n = 7 Output: "Odd"
	 * Example 3: Input: n = 0 Output: "Even"
	 * 
	 * Time complexity: O(1), as we are performing a constant number of operations to check if n is even or odd.
	 * Space complexity: O(1), as we are using a constant amount of space to store the result.
	 * 
	 * Approach:
	 * 
	 * 1. We can use the bitwise AND operator (&) to check if the least significant bit of n is set (1) or not (0). If n & 1 is equal to 0, then n is even; otherwise, it is odd.
	 * 
	 * </pre>
	 * 
	 * @param n the integer to check for being even or odd
	 * @return "Even" if n is even, "Odd" if n is odd
	 */
	public static String checkEvenOdd(int n) {
		return (n & 1) == 0 ? "Even" : "Odd"; // Check the least significant bit to determine if n is even or odd
	}
	
	
	/**
	 * 10. Find the missing number in an array of size n-1 containing numbers from 1 to n.
	 * 
	 * <pre>
	 * Description: Given an array of size n-1 containing distinct integers from 1 to n, find the missing number.
	 * 
	 * Example 1: Input: arr = [1, 2, 4, 5] Output: 3
	 * Example 2: Input: arr = [2, 3, 4] Output: 1
	 * Example 3: Input: arr = [1, 2, 3] Output: 4
	 * 
	 * Time complexity: O(n), where n is the size of the array, as we need to iterate through the array once.
	 * Space complexity: O(1), as we are using a constant amount of space to store the result.
	 * 
	 * Approach:
	 * 
	 * 1. We can use the XOR operator (^) to find the missing number. The idea is to XOR all the numbers from 1 to n and then XOR it with all the numbers in the array. The result will be the missing number.
	 * 
	 * </pre>
	 * 
	 * @param arr the input array containing distinct integers from 1 to n with one missing number
	 * @return the missing number in the array
	 */
	public static int findMissingNumber(int[] arr) {
		int n = arr.length + 1; // Since the array is of size n-1, we can determine n
		int xorAll = 0;
		for (int i = 1; i <= n; i++) {
			xorAll ^= i; // XOR all numbers from 1 to n
		}
		for (int num : arr) {
			xorAll ^= num; // XOR with all numbers in the array
		}
		return xorAll; // The result will be the missing number
	}
	
	/**
	 * 11. Find number appearing one time repeated twice in an array.
	 * 
	 * <pre>
	 * Description: Given an array of integers where every element appears twice except for one, find the single non-repeated element.
	 * 
	 * Example 1: Input: arr = [2, 3, 5, 4, 5, 3, 4] Output: 2
	 * Example 2: Input: arr = [1, 1, 2] Output: 2
	 * Example 3: Input: arr = [4, 1, 2, 1, 2] Output: 4
	 * 
	 * Time complexity: O(n), where n is the number of elements in the array, as we need to iterate through the array once.
	 * Space complexity: O(1), as we are using a constant amount of space to store the result.
	 * 
	 * Approach:
	 * 
	 * 1. We can use the XOR operator (^) to find the single non-repeated element. The XOR operator has a property that it returns zero when two identical numbers are XORed together and returns the number itself when XORed with zero.
	 * 2. Initialize a variable result to zero and iterate through each element in the array. For each element, perform a XOR operation with result and update result with the new value.
	 * 3. After iterating through the entire array, result will hold the value of the single non-repeated element.
	 * 
	 * </pre>
	 * 
	 * @param arr the input array containing integers where every element appears twice except for one
	 * @return the single non-repeated element in the array
	 */
	public static int findSingleNonRepeatedElement(int[] arr) {
		int result = 0;
		for (int num : arr) {
			result ^= num; // XOR operation to find the single non-repeated element
		}
		return result;
	}
	
	/**
	 * 12. Find the two non-repeated elements in an array where every other element is repeated twice.
	 * 
	 * <pre>
	 * Description: Given an array of integers where every element appears twice except for two, find the two non-repeated elements.
	 * 
	 * Example 1: Input: arr = [2, 3, 5, 4, 5, 3, 4, 6] Output: [2, 6]
	 * Example 2: Input: arr = [1, 1, 2, 3] Output: [2, 3]
	 * Example 3: Input: arr = [4, 1, 2, 1, 2, 5] Output: [4, 5]
	 * 
	 * Time complexity: O(n), where n is the number of elements in the array, as we need to iterate through the array once.
	 * Space complexity: O(1), as we are using a constant amount of space to store the result.
	 * 
	 * Approach:
	 * 
	 * 1. We can use the XOR operator (^) to find the two non-repeated elements. The idea is to XOR all the numbers in the array to get a combined XOR of the two unique numbers. Then we can find a set bit in this combined XOR to differentiate between the two unique numbers and separate them into two groups. Finally, we can XOR each group to get the individual unique numbers.
	 * 
	 * </pre>
	 * 
	 * @param arr the input array containing integers where every element appears twice except for two
	 * @return an array containing the two non-repeated elements
	 */
	public static int[] findTwoNonRepeatedElements(int[] arr) {
		int xorAll = 0;
		for (int num : arr) {
			xorAll ^= num; // XOR all numbers in the array to get the combined XOR of the two unique numbers
		}
		// Find a set bit in xorAll (we can use the rightmost set bit)
		int setBit = xorAll & (-xorAll);
		
		int num1 = 0, num2 = 0;
		for (int num : arr) {
			if ((num & setBit) != 0) {
				num1 ^= num; // XOR for the first group
			} else {
				num2 ^= num; // XOR for the second group
			}
		}
		return new int[]{num1, num2}; // Return the two non-repeated elements
	}
	/**
	 * 13. Subsets of a set using bit manipulation.
	 * 
	 * <pre>
	 * Description: Given a set of distinct integers, find all possible subsets (the power set) using bit manipulation.
	 * 
	 * Example 1: Input: nums = [1, 2] Output: [[], [1], [2], [1, 2]]
	 * Example 2: Input: nums = [1, 2, 3] Output: [[], [1], [2], [3], [1, 2], [1, 3], [2, 3], [1, 2, 3]]
	 * 
	 * Time complexity: O(2^n), where n is the number of elements in the input set, as there are 2^n possible subsets.
	 * Space complexity: O(2^n), as we need to store all the subsets in the output list.
	 * 
	 * Approach:
	 * 
	 * 1. We can use bit manipulation to generate all possible subsets. The idea is to iterate through all numbers from 0 to (2^n - 1) and use the binary representation of each number to determine which elements are included in the subset.
	 * 2. For each number i in the range from 0 to (2^n - 1), we can check each bit position j (from 0 to n-1). If the j-th bit of i is set (i.e., (i & (1 << j)) != 0), then we include nums[j] in the current subset.
	 * 
	 * </pre>
	 * 
	 * @param nums the input array containing distinct integers
	 * @return a list of all possible subsets of the input set
	 */
	public static List<List<Integer>> subsets(int[] nums) {
		
		List<List<Integer>> result = new ArrayList<>();
		int n = nums.length;
		int totalSubsets = 1 << n; // Total number of subsets is 2^n
		
		for (int i = 0; i < totalSubsets; i++) {
			List<Integer> subset = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				subset.add(nums[j]); // Add the j-th element to the subset if the j-th bit of i is set
			}
			result.add(subset); // Add the current subset to the result list
		}
		return result;
	}
	/**
	 * 14. Count number of 1 bits
	 * 
	 * <pre>
	 * Description: Given an integer n, count the number of 1 bits (set bits) in its binary representation.
	 * 
	 * Example 1: Input: n = 5 (binary: 101) Output: 2
	 * Example 2: Input: n = 7 (binary: 111) Output: 3
	 * Example 3: Input: n = 0 (binary: 0) Output: 0
	 * Example 4: Input: n = 15 (binary: 1111) Output: 4
	 * 
	 * Time complexity: O(log n), where n is the value of the integer, because we are checking each bit.
	 * Space complexity: O(1), as we are using a constant amount of space to store the count.
	 * 
	 * Approach:
	 * 
	 * 1. We can use a loop to check each bit of the integer n. We can use the expression (n & 1) to check if the least significant bit is set (1) or not (0). If it is set, we increment our count.
	 * 2. After checking the least significant bit, we can right shift n by one position (n >>= 1) to check the next bit in the next iteration of the loop.
	 * 
	 * </pre>
	 * 
	 * @param n the integer for which we want to count the set bits
	 * @return the number of set bits in the binary representation of n
	 */
	public static int countOneBits(int n) {
		int count = 0;
		while (n > 0) {
			count += (n & 1); // Increment count if the least significant bit is set
			n >>= 1; // Right shift n to check the next bit
		}
		return count;
	}
	
	/**
	 * 15. Find the duplicate number
	 * 
	 * <pre>
	 * Description: Given an array of integers containing n + 1 integers where each integer is between 1 and n (inclusive), find the duplicate number.
	 * 
	 * Example 1: Input: arr = [1, 3, 4, 2, 2] Output: 2
	 * Example 2: Input: arr = [3, 1, 3, 4, 2] Output: 3
	 * Example 3: Input: arr = [1, 1] Output: 1
	 * 
	 * Time complexity: O(n), where n is the number of elements in the array, as we need to iterate through the array once.
	 * Space complexity: O(1), as we are using a constant amount of space to store the result.
	 * 
	 * Approach:
	 * 
	 * 1. We can use the XOR operator (^) to find the duplicate number. The idea is to XOR all the numbers from 1 to n and then XOR it with all the numbers in the array. The result will be the duplicate number.
	 * 
	 * </pre>
	 * 
	 * @param arr the input array containing n + 1 integers where each integer is between 1 and n (inclusive)
	 * @return the duplicate number in the array
	 */
	public static int findDuplicate(int[] arr) {
		int n = arr.length - 1; // Since the array contains n + 1 integers, we can determine n
		int xorAll = 0;
		for (int i = 1; i <= n; i++) {
			xorAll ^= i; // XOR all numbers from 1 to n
		}
		for (int num : arr) {
			xorAll ^= num; // XOR with all numbers in the array
		}
		return xorAll; // The result will be the duplicate number
	}
}
