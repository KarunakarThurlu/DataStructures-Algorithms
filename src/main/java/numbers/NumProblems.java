package numbers;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class NumProblems {
	/**
	 * 
	 * ======================================
	 * Number Theory Problems
	 * ======================================
	 * 1. Count digits
	 * 2. Reverse number
	 * 3. GCD Or HCF of two numbers
	 * 4. Palindrome number
	 * 5. Armstrong number
	 * 6. Find Divisors
	 * 7. Prime Number
	 * 8. X Power N
	 * 9. Power of X
	 * 10.Fiz Buz Number
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	private static Logger logger = System.getLogger(NumProblems.class.getName());
	
	public static IntFunction<Integer> countDigits = x -> {
		logger.log(Level.INFO, "Finding Digits for {0}",x);
		int count = 0;
		if(x<0) {
			x=x*-1; //To make -ve number +ve
		}
		while (x > 0) {
			x = x / 10;
			count++;
		}
		return count;
	};

	public static IntFunction<Integer> reverseNumber = x -> {
		int y = x;
		if (y < 0)
			y = y * -1; //To make -ve number +ve
		long result = 0;
		while (y > 0) {
			int remainder = y % 10;
			if (result * 10 > Integer.MAX_VALUE) { //If product exceeds Integer range return 0
				return 0;
			}
			result = result * 10 + remainder;
			y = y / 10;
		}
		int reversedNumber = (int) result;
		if (x < 0) {
			return reversedNumber * -1; //rollback -ve
		}
		return reversedNumber;
	};

	public static BiFunction<Integer, Integer, Integer> gcd = (x, y) -> {
		while (x > 0 && y > 0) {
			if (x > y) { //Identify big number
				x = x % y;
			} else {
				y = y % x;
			}
		}
		if (x == 0) {
			return y;
		}
		return x;
	};
	
	public static Predicate<Integer> palindromeNumber = x -> {
		int result = 0;
		int y = x;
		if (y < 0) {
			y = y * -1;
		}
		while (y > 0) {
			int r = y % 10;
			result = result * 10 + r;
			y = y / 10;
		}
		if (x < 0) {
			result = result * -1;
		}
		if (result == x) {
			return true;
		}
		return false;
	};
	
	public static Predicate<Integer> armstrogNumber = x -> {
		int y = x;
		int result = 0;
		while (y > 0) {
			int r = y % 10;
			result = result + r * r * r;
			y = y / 10;
		}
		if (result == x) {
			return true;
		}
		return false;
	};
	
	public static Function<Integer, List<Integer>> findDivisors = x -> {
		List<Integer> l = new ArrayList<>();
		for (int i = 1; i <= x; i++) {
			if (x % i == 0) {
				l.add(i);
			}
		}
		return l;
	};
	
	public static Predicate<Integer> primeNumber = x -> {
		if (IntStream.range(2, x / 2).noneMatch(n -> x % n == 0)) {
			return true;
		}
		return false;
	};
	
	public static Integer powerN(Integer base, Integer power) {
		if (power == 0) {
			return 1;
		}
		if (power < 0) {
			return 1 / powerN(base, -power);
		}
		int half = powerN(base, power / 2);
		if (power % 2 == 0) {
			return half * half;
		}
		return base * half * half;
	}
	
	public static Boolean powerOf2(Integer x) {
		if (x == 1) {
			return true;
		}
		if (x % 2 != 0 || x == 0) {
			return false;
		}
		return powerOf2(x / 2);
	}
	
	public static String fizBuzz(int n) {
		if (n % 3 == 0 && n % 5 == 0)
			return "FizBuzz";
		if (n % 3 == 0)
			return "Fiz";
		if (n % 5 == 0)
			return "Buzz";
		return "None";
	}

}
