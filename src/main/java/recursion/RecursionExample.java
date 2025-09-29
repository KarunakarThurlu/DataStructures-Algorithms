package recursion;

public class RecursionExample {
	/**
	 * 
	 * 1. Print any message n times
	 * 2. Print numbers from 1 to n
	 * 3. Print number from n to 1
	 * 4. Print 1st n numbers sum
	 * 5. Find factorial of a number
	 * 
	 */

	public static void main(String[] args) {
		String s="Hello!,How are you?";
		s.charAt(0);
		String replace = s.toLowerCase().replaceAll("[^a-z]", "");
		System.out.println(replace);
	}

	public static void printMsgNtimes(int n) {
		// This is base case if you didn't handle, you will get stackoverflow error
		if (n == 0) {
			return;
		}
		System.out.println("Hello");
		printMsgNtimes(n - 1);
	}

	public static void printNums1ToN(int i, int n) {
		System.out.println(i);
		if (i == n) {
			return;
		}
		printNums1ToN(i + 1, n);
	}

	public static void printNumsNTo1(int n) {
		if (n == 0) {
			return;
		}
		System.out.println(n);
		printNumsNTo1(n - 1);
	}

	public static int firstnNumsSum(int n) {
		if (n == 0) {
			return 0;
		}
		return n + firstnNumsSum(n - 1);
	}
	
	public static int factorial(int n) {
		if(n==1) {
			return 1;
		}
		return n*factorial(n-1);
	}
	
	public static int fibonaciNumber(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return 1;
		}
		return fibonaciNumber(n - 1) + fibonaciNumber(n - 2);
	}
	
}
