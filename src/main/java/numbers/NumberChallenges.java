package numbers;

import java.math.BigInteger;
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
	 */
	
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
	 * 6. Reverses the digits of a given integer, including negative numbers.
	 * 
	 * <p><b>Algorithm:</b>
	 * - Handles negative numbers by reversing the absolute value, then restoring the sign.
	 * - Extracts each digit using modulo and builds the reversed number.
	 * 
	 * @param number the input integer (can be negative)
	 * @return the reversed integer (with sign preserved)
	 * 
	 * <p><b>Input:</b>
	 * int number = -1234;
	 * 
	 * <p><b>Output:</b>
	 * int result = -4321;
	 * 
	 * <p><b>Time Complexity:</b> O(log₁₀(n)) — processes each digit once
	 * <p><b>Space Complexity:</b> O(1) — uses constant space
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


}
