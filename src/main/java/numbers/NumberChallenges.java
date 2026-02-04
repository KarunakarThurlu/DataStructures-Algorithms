package numbers;

import java.math.BigInteger;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class NumberChallenges {
	/*
	 * ================================== 
	 * Number System Problems
	 * ================================== 
	 * 1. Count digits in a integer 
	 * 2. Check given number is Armstrong or not 
	 * 3. Find N Power M 
	 * 4. Find factorial of a number
	 * 5. Count odd digits in an integer 
	 * 6. Reverse given integer
	 * 7. Armstrong number
	 * 8. Count number of 1 bits
	 */
	
	
    /**
     * 8. Counts the number of set bits (1s) in the binary representation of a non-negative integer using Brian Kernighan’s Algorithm.
     *
     * <p>
     * Brian Kernighan’s Algorithm works by repeatedly removing the rightmost set bit from the number using:
     * <pre>
     * n = n & (n - 1)
     * </pre>
     * Each iteration removes exactly one set bit.
     * </p>
     *
     * <p>
     * <pre>
     * Example 1: Input: 0  (binary: 0)        → Output: 0
     * Example 2: Input: 1  (binary: 1)        → Output: 1
     * Example 3: Input: 5  (binary: 101)      → Output: 2
     * Example 4: Input: 7  (binary: 111)      → Output: 3
     * Example 5: Input: 8  (binary: 1000)     → Output: 1
     * </pre>
     * </p>
     *
     * <b>Approach:</b>
     * <pre>
     * - Initialize a counter to 0.
     * - While the number is greater than 0:
     *     - Remove the rightmost set bit using n = n & (n - 1).
     *     - Increment the counter.
     * - Return the counter.
     * </pre>
     *
     * <b>Time Complexity:</b> O(k)
     * <br>
     * where k is the number of set bits in the integer.
     *
     * <br><br>
     * <b>Space Complexity:</b> O(1)
     *
     * @return an {@link IntFunction} that returns the count of set bits
     */
	public static IntFunction<Integer> count1bits = num -> {
		int count = 0;
		while (num > 0) {
			num = num & (num - 1); // removes lowest set bit (flip 1 with 0)
			count++;
		}
		return count;
	};
	

	
	/**
	 * 7. Armstrong Number Checker
	 *
	 * <p>
	 * An Armstrong number (also known as a Narcissistic number) is a number that is
	 * equal to the sum of the cubes of its digits.
	 * </p>
	 *
	 * <pre>
	 * Example 1: Input: 153 → Output: true   (1³ + 5³ + 3³ = 153)
	 * Example 2: Input: 370 → Output: true   (3³ + 7³ + 0³ = 370)
	 * Example 3: Input: 371 → Output: true
	 * Example 4: Input: 407 → Output: true
	 * Example 5: Input: 123 → Output: false
	 * </pre>
	 *
	 * <p>
	 * <b>Approach:</b>
	 * <pre>
	 * - Store the original number.
	 * - Extract each digit using modulo (% 10).
	 * - Cube the digit and add it to the running sum.
	 * - Remove the last digit using division (/ 10).
	 * - Compare the final sum with the original number.
	 * </pre>
	 * </p>
	 *
	 * <b>Time Complexity:</b> O(d)  
	 * where d is the number of digits in the number.
	 *
	 * <br>
	 * <b>Space Complexity:</b> O(1)
	 *
	 * @see java.util.function.IntPredicate
	 */
	public static IntPredicate isArmstrongNumber = number -> {

		int originalNumber = number;
		int sumOfCubes = 0;

		// Process each digit of the number
		while (number > 0) {

			// Extract last digit
			int digit = number % 10;

			// Add cube of the digit
			sumOfCubes += digit * digit * digit;

			// Remove last digit
			number = number / 10;
		}

		// Check if sum of cubes equals the original number
		return sumOfCubes == originalNumber;
	};

	/**
	 * 6. Reverses the digits of a given integer, including negative numbers.
	 * 
	 * <p><b>Algorithm:</b>
	 * - Handles negative numbers by reversing the absolute value, then restoring the sign.
	 * - Extracts each digit using modulo and builds the reversed number.
	 * 
	 * <p><b>Input:</b>
	 * int number = -1234;
	 * 
	 * <p><b>Output:</b>
	 * int result = -4321;
	 * 
	 * <p><b>Time Complexity:</b> O(log₁₀(n)) — processes each digit once
	 * <p><b>Space Complexity:</b> O(1) — uses constant space
	 * 
	 * @param number the input integer (can be negative)
	 * @return the reversed integer (with sign preserved)
	 */
	public static Integer reverseNumber(Integer number) {
		if (number == null) {
			throw new IllegalArgumentException("Number cannot be null.");
		}
		// Check if the number is negative
		boolean isNegative = number < 0;
		// Work with the absolute value for reversal
		number = Math.abs(number);
		int reversedNumber = 0;

		while (number > 0) {
			int remainder = number % 10;
			// Append the digit to the reversed number
			reversedNumber = reversedNumber * 10 + remainder;
			number = number / 10;
		}
		// Return the reversed number with original sign
		return isNegative ? -reversedNumber : reversedNumber;
	}
	
	
	/**
	 * 5. Counts the number of odd digits in a given positive integer.
	 * 
	 * <p>
	 * <b>Algorithm:</b>
	 * - Extracts each digit from right to left using modulo and division.
	 * - Checks whether the digit is odd (`digit % 2 != 0`).
	 * - Increments a counter for every odd digit found.
	 * - Returns the total count.
	 * 
	 * @param number the input positive integer
	 * @return the number of odd digits in the given integer
	 * 
	 * <p><b>Input:</b>
	 * int number = 12345;
	 * 
	 * <p><b>Output:</b>
	 * int result = 3; // (1, 3, 5 are odd)
	 *
	 * <p><b>Time Complexity:</b> O(log₁₀(n)) — iterates once for each digit
	 * <p><b>Space Complexity:</b> O(1) — uses constant extra space
	 */
	public static Integer oddDigitsCount(Integer number) {
		int count = 0; 						// Counter for odd digits
		while (number > 0) {				// Process each digit of the number
			int remainder = number % 10;    // Get the last digit
			if (remainder % 2 != 0) {       // Check if the digit is odd
				count++; 					// Increment if odd
			}
			number = number / 10; 			// Remove the last digit
		}
		return count;
	}
	
	/**
	 * 4. Calculates the factorial of a given non-negative integer.
	 * 
	 * <p>
	 * <b>Definition:</b>
	 * The factorial of a non-negative integer `n` is the product of all positive integers less than or equal to `n`.
	 * 
	 * <p><b>Algorithm:</b>
	 * - Returns 1 if the number is 0 or 1 (base case).
	 * - Iteratively multiplies all integers from 1 to `num` using {@link java.math.BigInteger}
	 *   to handle very large results.
	 * - Throws an exception if the number is negative.
	 *
	 * @param num the input non-negative integer
	 * @return the factorial of the input number as a {@link java.math.BigInteger}
	 * 
	 * <p><b>Input:</b>
	 * int num = 5;
	 * 
	 * <p><b>Output:</b>
	 * BigInteger result = 120;
	 *
	 * <p><b>Time Complexity:</b> O(n) — linear iteration up to `num`
	 * <p><b>Space Complexity:</b> O(1) — no additional space apart from result storage
	 * 
	 * @throws IllegalArgumentException if the input number is negative
	 */
	public static BigInteger factorialOfNum(int num) {
		if (num < 0) { // Factorial is not defined for negative numbers
			throw new IllegalArgumentException("Factorial is not defined for negative numbers");
		}

		// Initialize factorial as 1
		BigInteger fact = BigInteger.valueOf(1);

		// Base case: 0! and 1! = 1
		if (num == 0 || num == 1) {
			return fact;
		}

		// Multiply numbers from 1 to num
		for (int i = 1; i <= num; i++) {
			fact = fact.multiply(BigInteger.valueOf(i));
		}

		return fact;
	}
	
	/**
	 * 3. Calculates n raised to the power of m (n^m).
	 * 
	 * <p>
	 * <b>Algorithm:</b>
	 * - Uses a simple iterative loop to multiply `n` by itself `m` times.
	 * - Starts with 1 and multiplies it with `n`, `m` times.
	 * 
	 * @param n the base integer
	 * @param m the exponent (must be a non-negative integer)
	 * @return the result of n raised to the power m (n^m)
	 * 
	 * <p><b>Input:</b>
	 * n = 2, m = 3;
	 * 
	 * <p><b>Output:</b>
	 * int result = 8;
	 *
	 * <p><b>Time Complexity:</b> O(m) — linear in the exponent
	 * <p><b>Space Complexity:</b> O(1) — constant space used
	 */
	public static Integer nPowerM(Integer n, Integer m) {
		int mul = 1;
		for (int i = 1; i <= m; i++) {
			mul = mul * n;
		}
		return mul;
	}
	
	/**
	 * 2. Checks whether a given number is an Armstrong number.
	 * 
	 * <p>
	 * <b>Definition:</b>
	 * An Armstrong number of 'n' digits is an integer such that the sum of its digits
	 * each raised to the power 'n' is equal to the number itself.
	 * 
	 * <p><b>Algorithm:</b>
	 * - Get the number of digits using `digitsCount(num)`.
	 * - Extract each digit and raise it to the power of total digits (`nPowerM`).
	 * - Sum all these powered digits.
	 * - If the sum equals the original number, it's an Armstrong number.
	 *
	 * @param num the input integer to check
	 * @return true if the number is an Armstrong number, false otherwise
	 * 
	 * <p><b>Input:</b>
	 * int num = 153;
	 * 
	 * <p><b>Output:</b>
	 * boolean result = true; // 1³ + 5³ + 3³ = 153
	 *
	 * <p><b>Time Complexity:</b> O(d × log₁₀(nPowerM)) where d is the number of digits
	 * <p><b>Space Complexity:</b> O(1) — uses a constant amount of space
	 */
	public static Predicate<Integer> armStrongNumber = num -> {
		Integer digitsOfNum = digitsCount(num);     // Count of digits (n)
		Integer temp = num; 					    // Temporary variable to extract digits
		Integer sum = 0;    					    // Sum of powered digits

		// Iterate through each digit of the number
		while (temp > 0) {
			Integer r = temp % 10; 				    // Extract the last digit
			sum = sum + nPowerM(r, digitsOfNum);    // Add digit^n to the sum
			temp = temp / 10; 						// Remove the last digit
		}

		// If sum of powered digits equals original number, return true
		return sum.equals(num);
	};
	
	/**
	 * 1. Counts the number of digits in a given positive integer.
	 * 
	 * <p>
	 * <b>Algorithm:</b>
	 * - Initializes a counter variable to zero.
	 * - Continuously divides the number by 10 until it becomes zero.
	 * - Each division represents one digit, and the counter is incremented accordingly.
	 * - Returns the total count of digits.
	 *
	 * @param num the input positive integer
	 * @return the number of digits in the given integer
	 * 
	 * <p><b>Input:</b>
	 * int num = 12345;
	 * 
	 * <p><b>Output:</b>
	 * int result = 5;
	 *
	 * <p><b>Time Complexity:</b> O(log₁₀(n)) — since each iteration divides the number by 10.
	 * <p><b>Space Complexity:</b> O(1) — uses a constant amount of space.
	 */
	public static Integer digitsCount(int num) {
		if(num==0) return 1;        // Base Case
		Integer count = 0;    		// Initialize digit counter
		while (num > 0) {     		// Loop until the number becomes 0
			count = count + 1;		// Increment counter for each digit
			num = num / 10;   		// Remove the last digit by integer division
		}
		return count;         		// Return the total number of digits
	}


}
