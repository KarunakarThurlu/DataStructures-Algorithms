package string;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class StringHandling {
	/*
	 * ==================================
	 * String Handling Problems
	 * ==================================
	 * 1. Reverse given string.
	 * 2. Reverse given string by frequency
	 * 3. Find permutations of string.
	 * 4. Count vowels and consonants in given string.
	 * 5. Replace specific words
	 * 6. Replace Only Vowels
	 * 7. Anagram Strings
	 * 8. Remove Duplicate chars
	 * 9. First Unique Character
	 * 10.Longest Substring
	 * 11.Reverse words in a string
	 * 12.Remove removeAllConsecutive
	 * 13.Group anagram strings
	 * 14.Valid parentheses
	 * 15.Roman to Integer
	 * 16.String Rotation
	 * 17.Subsequence Check
	 * 18.Reverse only vowels
	 * 19.Minimum number of Changes to make Two Strings are anagrams
	 * 20.Longest SubString Without Repeating Characters
	 * 21.Longest palindromic substring
	 * 22.Longest Common Prefix
	 * 23.String to integer (atoi)
	 * 24.Generate parenthesis
	 * 25.Check if two strings are isomorphic
	 * 26.Robot return to origin
	 */
	
	/**
	 * 26. Robot Return to Origin
	 *
	 * <pre>
	 * Description:
	 * Given a string moves consisting of characters:
	 * 'L', 'R', 'U', 'D',
	 * determine if the robot returns to the origin (0,0).
	 *
	 * Movement rules:
	 * L → move left  (x--)
	 * R → move right (x++)
	 * U → move up    (y++)
	 * D → move down  (y--)
	 *
	 * Example 1: Input: "UD"        Output: true
	 * Example 2: Input: "LL"        Output: false
	 * Example 3: Input: "URDL"      Output: true
	 *
	 * Approach:
	 * - Track x and y coordinates.
	 * - Iterate through moves:
	 *      - Update x or y based on direction
	 * - At end:
	 *      - If (x == 0 && y == 0) → return true
	 *      - Else → false
	 *
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 *
	 * </pre>
	 *
	 * @param moves string representing robot moves
	 * @return true if robot returns to origin, false otherwise
	 */
	public static Function<String, Boolean> judgeCircle = moves -> {

	    if (moves == null || moves.isEmpty()) {
	        return true; // no movement → still at origin
	    }

	    int xCoordinate = 0;
	    int yCoordinate = 0;

	    for (int index = 0; index < moves.length(); index++) {
	        char move = moves.charAt(index);
	        // Update coordinates based on move
	        if (move == 'L') {
	            xCoordinate--;
	        } else if (move == 'R') {
	            xCoordinate++;
	        } else if (move == 'U') {
	            yCoordinate++;
	        } else if (move == 'D') {
	            yCoordinate--;
	        }
	    }
	    return xCoordinate == 0 && yCoordinate == 0;
	};
	
	/**
	 * 25. Isomorphic Strings
	 *
	 * <pre>
	 * Description: Given two strings str1 and str2, determine if they are isomorphic.
	 *
	 * Two strings are isomorphic if:
	 * - Characters in str1 can be replaced to get str2.
	 * - Each character must map to exactly one character.
	 * - No two characters may map to the same character.
	 * - Character order must be preserved.
	 *
	 * Example 1: Input: str1 = "egg", str2 = "add" Output: true
	 * Example 2: Input: str1 = "foo", str2 = "bar" Output: false
	 * Example 3: Input: str1 = "paper", str2 = "title" Output: true
	 * Example 4: Input: str1 = "ab", str2 = "aa" Output: false
	 * Example 5: Input: str1 = "", str2 = "" Output: true
	 * Example 6: Input: str1 = "a", str2 = "" Output: false
	 *
	 * Approach:
	 * - If lengths are different → return false.
	 * - Use two HashMaps:
	 *      mapFromFirst  → maps characters from str1 to str2
	 *      mapFromSecond → maps characters from str2 to str1
	 * - Iterate both strings simultaneously.
	 * - Check:
	 *      1. Existing mapping must match.
	 *      2. New mapping must not conflict with reverse mapping.
	 *
	 * Time Complexity: O(n)
	 * Space Complexity: O(1) (At most 256 character mappings)
	 *
	 * </pre>
	 */
	public static BiPredicate<String, String> isomorphicStrings = (str1, str2) -> {
		if(str1==null || str2==null)
			return false;
		if (str1.length() != str2.length())
			return false;
		Map<Character, Character> mapOne = new HashMap<>();
		Map<Character, Character> mapTwo = new HashMap<>();
		for (int i = 0; i < str1.length(); i++) {
			if (mapOne.containsKey(str1.charAt(i))) {
				if (mapOne.get(str1.charAt(i)) != str2.charAt(i))
					return false;
			} else {
				mapOne.put(str1.charAt(i), str2.charAt(i));
			}
			if (mapTwo.containsKey(str2.charAt(i))) {
				if (mapTwo.get(str2.charAt(i)) != str1.charAt(i))
					return false;
			} else {
				mapTwo.put(str2.charAt(i), str1.charAt(i));
			}
		}
		return true;
	};
	
	/**
	 * 24. Generate Parentheses
	 *
	 * <pre>
	 * Description:  Given an integer n, generate all combinations of well-formed parentheses.
	 *
	 * A combination is considered well-formed if:
	 * - Every opening parenthesis '(' has a corresponding closing parenthesis ')'
	 * - At no point should closing parentheses exceed opening parentheses
	 *
	 * Example 1: Input: n = 1 Output: ["()"]
	 * Example 2: Input: n = 2 Output: ["(())", "()()"]
	 * Example 3: Input: n = 3 Output: ["((()))", "(()())", "(())()", "()(())", "()()()"]
	 * Example 4: Input: n = 0 Output: [""]
	 * Example 5: Input: n =-1 Output: []
	 * 
	 * Approach:
	 * - Use Backtracking.
	 * - Maintain:
	 *      openCount  → number of '(' used
	 *      closeCount → number of ')' used
	 * - Add '(' if openCount < n
	 * - Add ')' if closeCount < openCount
	 * - When current string length becomes 2 * n, add to result list
	 *
	 * Time Complexity: O(4^n / √n)  (Catalan number growth)
	 * Space Complexity: O(n) recursion stack (excluding output list)
	 *
	 * </pre>
	 */
	public static Function<Integer, List<String>> generateParenthesis = totalPairs -> {
        List<String> validCombinations = new ArrayList<>();
        // Edge case: if n <= 0 return empty list
        if (totalPairs == null || totalPairs <= 0) {
            return validCombinations;
        }
        generateCombinations(totalPairs, "", 0, 0, validCombinations);
        return validCombinations;
	};

	private static void generateCombinations(int totalPairs, String currentString, int openCount, int closeCount,
			List<String> resultCombinations) {
		// Base case: if string length equals 2 * n, it's valid
		if (currentString.length() == totalPairs * 2) {
			resultCombinations.add(currentString);
			return;
		}

		// Add opening parenthesis if we still have '(' remaining
		if (openCount < totalPairs) {
			generateCombinations(totalPairs, currentString + "(", openCount + 1, closeCount, resultCombinations);
		}

		// Add closing parenthesis only if it won't invalidate the sequence
		if (closeCount < openCount) {
			generateCombinations(totalPairs, currentString + ")", openCount, closeCount + 1, resultCombinations);
		}
	}
	
	
	
	/**
	 * 23. String to Integer (atoi)
	 *
	 * <pre>
	 * Description:
	 * Implement a function that converts a string to a 32-bit signed integer.
	 * The function discards leading whitespace, handles an optional '+' or '-' sign,
	 * reads digits until a non-digit character is encountered, and returns the parsed integer.
	 *
	 * If the integer overflows beyond the 32-bit signed range:
	 *   [-2^31, 2^31 - 1]
	 * it clamps to Integer.MIN_VALUE or Integer.MAX_VALUE.
	 *
	 * Example1: Input: "42" → Output: 42
	 * Example2: Input: "   -42" → Output: -42
	 * Example3: Input: "4193abc" → Output: 4193
	 * Example4: Input: "abc123" → Output: 0
	 * Example5: Input: "-91283472332" → Output: -2147483648
	 *
	 * Approach:
	 * 1. Trim leading and trailing whitespace.
	 * 2. Check for optional '+' or '-' sign.
	 * 3. Traverse characters while they are digits.
	 * 4. Convert each character to numeric value.
	 * 5. Before multiplying, check for overflow:
	 *        result > (Integer.MAX_VALUE - digit) / 10
	 * 6. Apply sign and return result.
	 *
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * </pre>
	 *
	 * @param input the input string to be converted
	 * @return parsed 32-bit signed integer value
	 */
	static Function<String, Integer> atoi = str -> {
		//Step 1 : Removing leading white spaces
		str = str.trim();
		
		//Step 2 : Check if the string is empty after trimming
		if (str.length() == 0)
			return 0;
		
		//Step 3 : Initialize variables to store the result and track the sign
		int result = 0;
		int i = 0;
		boolean nVe = false;
		
		//Step 4 : Handle optional sign
		if (str.charAt(i) == '-' || str.charAt(i) == '+') {
			nVe = str.charAt(i) == '-';
			i++;
		}
		
		//Step 5 : Parse digits and build the result
		while (i < str.length() && Character.isDigit(str.charAt(i))) {
			//Extract digit value from character
			int digit = str.charAt(i) - '0';
			
			//Check for overflow and underflow before updating the result
			if (result > (Integer.MAX_VALUE - digit) / 10)
				return nVe ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			
			//Update result by multiplying current result by 10 and adding new digit
			result = result * 10 + digit;
			i++;
		}
		//Step 6 : Apply the sign to the result and return it
		return nVe ? -result : result;
	};
	
	/**
	 * 22. Longest Common Prefix
	 *
	 * <pre>
	 * Description: Given a list of strings, find the longest common prefix shared among all strings. If there is no common prefix, return an empty string "".
	 *
	 * Example 1: Input: ["flower","flow","flight"] Output: "fl"
	 * Example 2: Input: ["dog","racecar","car"] Output: ""
	 * Example 3: Input: ["interview","internet","internal","interval"] Output: "inte"
	 * Example 4: Input: [] Output: ""
	 *
	 * Approach:
	 * - Sort the list of strings lexicographically.
	 * - After sorting:
	 *      first string → smallest
	 *      last string  → largest
	 * - The longest common prefix of the entire list must be the common prefix
	 *   between these two strings.
	 * - Compare characters until mismatch occurs.
	 *
	 * Time Complexity: O(n log n + m)
	 *      n → number of strings
	 *      m → length of prefix comparison
	 *
	 * Space Complexity: O(1) (ignoring sorting overhead)
	 *
	 * </pre>
	 * @param strings the list of input strings
	 * @return the longest common prefix among the input strings
	 */
	static Function<List<String>, String> longestCommonPrefix = strings -> {
	    // Handle empty input
	    if (strings == null || strings.isEmpty()) {
	        return "";
	    }
	    // Sort strings lexicographically
	    List<String> sortedStrings = strings.stream()
	            .sorted()
	            .toList();
	    String firstString = sortedStrings.get(0);
	    String lastString = sortedStrings.get(sortedStrings.size() - 1);
	    StringBuilder commonPrefix = new StringBuilder();
	    int index = 0;
	    int maxPrefixLength = Math.min(firstString.length(), lastString.length());

	    // Compare characters until mismatch
	    while (index < maxPrefixLength) {
	        if (firstString.charAt(index) == lastString.charAt(index)) {
	            commonPrefix.append(firstString.charAt(index));
	        } else {
	            break;
	        }
	        index++;
	    }
	    return commonPrefix.toString();
	};
	
	/**
	 * 21. Longest Palindromic Substring
	 *
	 * <pre>
	 * Description: Given a string, find the longest substring that is a palindrome.
	 *
	 * A palindrome is a string that reads the same forward and backward.
	 *
	 * Example 1: Input: "babad" Output: "bab"  Explanation: "aba" is also a valid answer.
	 * Example 2: Input: "cbbd"  Output: "bb"
	 * Example 3: Input: "a"     Output: "a"
	 * Example 4: Input: "ac"    Output: "a"
	 *
	 * Approach:
	 * - Treat every character as a potential center of a palindrome.
	 * - Expand outward while characters match.
	 * - Consider two cases:
	 *      1) Odd length palindrome  → center at one character
	 *      2) Even length palindrome → center between two characters
	 * - Track the start and end indices of the longest palindrome found.
	 *
	 * Time Complexity: O(n²)
	 * Space Complexity: O(1)
	 *
	 *@param str input string
	 *@return longest palindrome sub string
	 * </pre>
	 */
	static UnaryOperator<String> longestPalindromicSubString = str -> {
		int palindromeStart = 0;
		int palindromeEnd = 0;
		for (int center = 0; center < str.length(); center++) {
			int oddPalindromeLength = expandAroundCenter(str, center, center);
			int evenPalindromeLength = expandAroundCenter(str, center, center + 1);
			int maxLength = Math.max(oddPalindromeLength, evenPalindromeLength);
			int currentLength = palindromeEnd - palindromeStart;
			if (maxLength > currentLength) {
				palindromeStart = center - (maxLength - 1) / 2; 
				palindromeEnd = center + (maxLength) / 2;
			}
		}
		return str.substring(palindromeStart, palindromeEnd + 1);
	};
	
	private static int expandAroundCenter(String str, int left, int right) {
		while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
			left--;
			right++;
		}
		return right - left - 1;
	}
	
	/**
	 * 20. Longest Substring Without Repeating Characters
	 *
	 * <pre>
	 * Description: Given a string, find the longest substring that contains no repeating characters.
	 * The substring must contain only unique characters.
	 *
	 * Example 1: Input: "abcabcbb" Output: "abc" Explanation: The longest substring without repeating characters is "abc".
	 * Example 2: Input: "bbbbb"    Output: "b"
	 * Example 3: Input: "pwwkew"   Output: "wke"
	 * Example 4: Input: ""         Output: ""
	 *
	 * Approach:
	 * - Use the Sliding Window technique with two pointers:
	 *      start → beginning of current window
	 *      end   → expanding pointer
	 *
	 * - Maintain a Set to track characters currently in the window.
	 *
	 * - If the current character is not in the set:
	 *      add it and expand the window.
	 *
	 * - If a duplicate is found:
	 *      shrink the window from the left until the duplicate is removed.
	 *
	 * - Track the maximum window length and starting index of the longest substring.
	 *
	 * Time Complexity: O(n)
	 *      Each character is visited at most twice.
	 *
	 * Space Complexity: O(k)
	 *      k = size of character set stored in the HashSet.
	 *
	 * </pre>
	 *
	 * @param str the input string to evaluate
	 * @return the longest substring containing only unique characters
	 */
	static Function<String, String> longestSubStringWithOutRepeatingChars = str -> {
		// Handle null or empty input
		if (str == null || str.isEmpty())
			return null;

		// Set to keep track of characters in the current window
		Set<Character> seenCharacters = new HashSet<>();

		int maxLength = 0;

		// Sliding window pointers
		int windowStart = 0;
		int windowEnd = 0;

		// Track starting index of the longest unique substring
		int longestSubstringStartIndex = 0;

		while (windowEnd < str.length()) {
			// If character not present → expand window
			if (seenCharacters.add(str.charAt(windowEnd))) {

				int currentWindowLength = windowEnd - windowStart + 1;

				// Update longest substring
				if (currentWindowLength > maxLength) {
					maxLength = currentWindowLength;
					longestSubstringStartIndex = windowStart;
				}
				windowEnd++;
			} else {
				// Duplicate found → shrink window from left
				seenCharacters.remove(str.charAt(windowStart));
				windowStart++;
			}
		}
		return str.substring(longestSubstringStartIndex, longestSubstringStartIndex + maxLength);
	};
	
	/**
	 * 19. Minimum Changes to Make Two Strings Anagrams
	 *
	 * <pre>
	 * Description: Given two strings of equal length, determine the minimum number of character changes required in one string to make it an anagram of the other.
	 *
	 * An anagram is a word or phrase formed by rearranging the letters of another,
	 * using all the original letters exactly once.
	 *
	 * Example 1: Input: one = "bab", two = "aba"         Output: 1 Explanation: Change 'b' → 'a' in "bab" to make it "aab".
	 * Example 2: Input: one = "anagram", two = "mangaar" Output: 0
	 * Example 3: Input: one = "abc", two = "def"         Output: 3
	 * Example 4: Input: one = "aabbcc", two = "abcabc"   Output: 0
	 * Example 5: Input: one = "abc", two = "ab"          Output: -1
	 * 
	 * Explanation: Strings must have the same length to become anagrams by character replacement.
	 *
	 * Approach:
	 * - Use a frequency array to count character differences.
	 * - Iterate through both strings simultaneously:
	 *      increment frequency for characters in first string
	 *      decrement frequency for characters in second string
	 *
	 * - After processing both strings:
	 *      positive values represent extra characters in first string
	 *
	 * - Sum all positive values to determine how many replacements are needed.
	 *
	 * Time Complexity: O(n)
	 * Space Complexity: O(1) (fixed-size frequency array)
	 *
	 * </pre>
	 *
	 * @param one the first input string
	 * @param two the second input string
	 * @return the minimum number of character changes required to make the strings anagrams, or -1 if the strings have different lengths
	 */
	static BiFunction<String, String, Integer> minChangesToMakeAnagrams = (one, two) -> {
	    // If lengths differ, it's impossible to make anagrams via replacements
	    if (one.length() != two.length()) {
	        return -1;
	    }

	    // Frequency array for ASCII characters
	    int[] frequency = new int[128];

	    // Count characters
	    for (int i = 0; i < one.length(); i++) {
	        frequency[one.charAt(i)]++;   // count characters in first string
	        frequency[two.charAt(i)]--;   // remove characters from second string
	    }

	    int totalChangesRequired = 0;

	    // Only positive values indicate extra characters in first string
	    for (int i = 0; i < frequency.length; i++) {
	        totalChangesRequired += Math.max(0, frequency[i]);
	    }

	    return totalChangesRequired;
	};
	
	/**
	 * 18. Reverse a String
	 *
	 * <pre>
	 * Description: Given a string, reverse the characters of the string and return the reversed string.
	 *
	 * Example 1: Input: "hello" Output: "olleh"
	 * Example 2: Input: "Java"  Output: "avaJ"
	 * Example 3: Input: "a"     Output: "a"
	 * Example 4: Input: ""      Output: ""
	 *
	 * Approach:
	 * - Convert the string into a character array.
	 * - Use two pointers:
	 *      startIndex → beginning of the array
	 *      endIndex   → end of the array
	 * - Swap characters while moving pointers toward each other.
	 * - Convert the modified array back to a string.
	 *
	 * Time Complexity: O(n)
	 * Space Complexity: O(n) (due to char array)
	 *
	 * </pre>
	 *
	 * @param input the string to be reversed
	 * @return the reversed string
	 */
	static UnaryOperator<String> stringReverse = input -> {
		char[] charArray = input.toCharArray();
		int startIndex = 0;
		int endIndex = input.length() - 1;
		// Swap characters from both ends moving toward center
		while (startIndex <= endIndex) {
			swap(charArray, startIndex++, endIndex--);
		}
		return new String(charArray);
	};
	
	/**
	 * Swaps two characters in the array.
	 *
	 * @param charArray the character array
	 * @param startIndex index of first character
	 * @param endIndex index of second character
	 */
	private static void swap(char[] charArray, int startIndex, int endIndex) {
		char temp = charArray[startIndex];
		charArray[startIndex] = charArray[endIndex];
		charArray[endIndex] = temp;
	}
	
	/**
	 * 17. Subsequence Check
	 *
	 * <pre>
	 * Description: Given two strings, determine if the second string is a subsequence of the first string.
	 *
	 * A subsequence is a sequence that can be derived from another string by deleting some or no elements without changing the order of the remaining elements.
	 *
	 * Example 1: Input: one = "abcde", two = "ace" Output: true
	 * Example 2: Input: one = "abc", two = "acb" Output: false
	 * Example 3: Input: one = "abc", two = "" Output: true
	 * Example 4: Input: one = "", two = "a" Output: false
	 *
	 * Approach:
	 * - Use two pointers:
	 *      oneIndex → iterate over main string
	 *      twoIndex → iterate over subsequence
	 *
	 * - If characters match, move both pointers.
	 * - Otherwise, move only main string pointer.
	 * - If we reach end of subsequence → it is a valid subsequence.
	 *
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 *
	 * </pre>
	 *
	 * @param one the main string
	 * @param two the string to check as subsequence
	 * @return true if 'two' is a subsequence of 'one', otherwise false
	 */
	static BiFunction<String, String, Boolean> subSequenceCheck = (one, two) -> {
	    // Handle null cases
	    if (one == null || two == null) {
	        return false;
	    }
	    int oneIndex = 0;
	    int twoIndex = 0;

	    // Traverse both strings
	    while (oneIndex < one.length() && twoIndex < two.length()) {
	        // Match found → move subsequence pointer
	        if (one.charAt(oneIndex) == two.charAt(twoIndex)) {
	            twoIndex++;
	        }
	        // Always move main string pointer
	        oneIndex++;
	    }
	    // If we matched entire 'two', it's a subsequence
	    return twoIndex == two.length();
	};
	
	/**
	 * 16. Reverse Vowels of a String
	 *
	 * <pre>
	 * Description:
	 * Given a string, reverse only the vowels in the string and return the result.
	 *
	 * Vowels include: a, e, i, o, u (both lowercase and uppercase).
	 *
	 * Example 1: Input: "hello"    Output: "holle"
	 * Example 2: Input: "leetcode" Output: "leotcede"
	 * Example 3: Input: "aA"       Output: "Aa"
	 * Example 4: Input: "bcdfg"    Output: "bcdfg"
	 *
	 * Approach:
	 * - Use two pointers:
	 *      start → beginning of string
	 *      end   → end of string
	 *
	 * - Move start forward until a vowel is found.
	 * - Move end backward until a vowel is found.
	 * - Swap the vowels.
	 *
	 * - Continue until pointers meet.
	 *
	 * Time Complexity: O(n)
	 * Space Complexity: O(n) (char array)
	 *
	 * </pre>
	 *
	 * @param str the input string
	 * @return string with vowels reversed
	 */
	static Function<String, String> reverseVowelsOnly = str -> {
	    if (str == null || str.isEmpty())
	        return "";
	    char[] charArray = str.toCharArray();
	    String vowels = "aeiouAEIOU";
	    int start = 0;
	    int end = charArray.length - 1;
	    while (start < end) {
	        // Move start to next vowel
	        while (start < end && vowels.indexOf(charArray[start]) == -1) {
	            start++;
	        }

	        // Move end to previous vowel
	        while (start < end && vowels.indexOf(charArray[end]) == -1) {
	            end--;
	        }

	        // Swap vowels
	        if (start < end) {
	            char temp = charArray[start];
	            charArray[start++] = charArray[end];
	            charArray[end--] = temp;
	        }
	    }
	    return new String(charArray);
	};
	
	/**
	 * 15. Roman to Integer
	 *
	 * <pre>
	 * Description:
	 * Convert a Roman numeral string into its corresponding integer value.
	 *
	 * Roman numerals:
	 * I → 1
	 * V → 5
	 * X → 10
	 * L → 50
	 * C → 100
	 * D → 500
	 * M → 1000
	 *
	 * Special Rule:
	 * - If a smaller value appears before a larger value, subtract it.
	 *   Example:
	 *      IV → 4   (5 - 1)
	 *      IX → 9   (10 - 1)
	 *
	 * - Otherwise, add the value.
	 *
	 * Example 1: Input: "III"     Output: 3
	 * Example 2: Input: "IV"      Output: 4
	 * Example 3: Input: "IX"      Output: 9
	 * Example 4: Input: "LVIII"   Output: 58
	 * Example 5: Input: "MCMXCIV" Output: 1994
	 *
	 * Approach:
	 * - Traverse the string from left to right.
	 * - Compare current character value with next character value.
	 * - If next > current → subtract current
	 * - Else → add current
	 *
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 *
	 * </pre>
	 *
	 * @param roman the Roman numeral string
	 * @return integer value of Roman numeral
	 */
	static Function<String, Integer> romanToInteger = input -> {
		Map<Character, Integer> map = Map.of('M', 1000, 'D', 500, 'C', 100, 'L', 50, 'X', 10, 'V', 5, 'I', 1);
		Integer res = 0;
		for (int i = 0; i < input.length(); i++) {
			char charAt = input.charAt(i);
			 // Check if next value is greater (subtraction case)
			if (i + 1 < input.length() && map.get(input.charAt(i + 1)) > map.get(charAt)) {
				res = res - map.get(charAt);
			} else {
				res = res + map.get(charAt);
			}
		}
		return res;
	};
	
	/**
	 * 14. Valid Parentheses
	 *
	 * <pre>
	 * Description:
	 * Given a string containing only '(', ')', '{', '}', '[' and ']',
	 * determine if the input string is valid.
	 *
	 * A string is valid if:
	 * - Open brackets are closed by the same type of brackets.
	 * - Open brackets are closed in the correct order.
	 *
	 * Example 1: Input: "()"        Output: true
	 * Example 2: Input: "()[]{}"    Output: true
	 * Example 3: Input: "(]"        Output: false
	 * Example 4: Input: "([)]"      Output: false
	 * Example 5: Input: "{[]}"      Output: true
	 *
	 * Approach:
	 * - Use a stack to track opening brackets.
	 * - Traverse each character:
	 *      - If opening bracket → push to stack
	 *      - If closing bracket:
	 *          - If stack empty → invalid
	 *          - Check top of stack matches → pop
	 *          - Else → invalid
	 *
	 * - At end, stack should be empty.
	 *
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 *
	 * </pre>
	 *
	 * @param input the input string containing brackets
	 * @return true if valid parentheses, false otherwise
	 */
	static Function<String, Boolean> validParanthases = input -> {
		Stack<Character> stack = new Stack<>();
		if (input.length() % 2 != 0) {
			return false;
		} else {
			for (int i = 0; i < input.length(); i++) {
				char current = input.charAt(i);
				// Push opening brackets
				if (current == '{' || current == '(' || current == '[') {
					stack.push(input.charAt(i));
				} else {
					 // If stack is empty, no matching opening bracket
					if (stack.isEmpty()) {
						return false;
					} else {
						Character open = stack.peek();
						// Check for matching pair
						if ((open == '{' && current == '}') || (open == '[' && current == ']')
								|| (open == '(' && current == ')')) {
							stack.pop();
						}
					}
				}
			}
		}
		return stack.isEmpty();
	};
	
	/**
	 * 13. Group Anagrams
	 *
	 * <pre>
	 * Description: Given a list of strings, group the anagrams together.
	 *
	 * Two strings are anagrams if they contain the same characters in the same frequency, but possibly in different order.
	 *
	 * Example 1: Input: ["eat","tea","tan","ate","nat","bat"] Output: [["eat","tea","ate"],["tan","nat"],["bat"]]
	 * Example 2: Input: [""] Output: [[""]]
	 * Example 3: Input: ["a"] Output: [["a"]]
	 *
	 * Approach:
	 * - For each string:
	 *      - Convert to char array
	 *      - Sort the characters
	 *      - Use sorted string as key
	 *
	 * - Store original strings in a map grouped by this key.
	 * - Return all grouped values.
	 *
	 * Time Complexity: O(n * k log k)
	 *      n → number of strings
	 *      k → max length of string (sorting cost)
	 *
	 * Space Complexity: O(n * k)
	 *
	 * </pre>
	 *
	 * @param input list of strings
	 * @return grouped list of anagrams
	 */
	public static List<List<String>> groupAnagramStrings(List<String> anagrams) {
		Map<String, List<String>> map = new HashMap<>();
		for (String s : anagrams) {
			String string = s.chars().mapToObj(c -> (char) c).map(String::valueOf).sorted()
					.collect(Collectors.joining());
			if (map.containsKey(string)) {
				map.get(string).add(s);
			} else {
				map.put(string, new ArrayList<>());
				map.get(string).add(s);
			}
		}
		List<List<String>> res = new ArrayList<>();
		map.entrySet().forEach(e -> res.add(e.getValue()));
		return res;
	}
	
	/**
	 * 12. Remove Adjacent Duplicate Characters
	 *
	 * <pre>
	 * Description: Given a string, repeatedly remove adjacent duplicate characters until no such duplicates remain.
	 *
	 * Example 1: Input: "abbaca"   Output: "ca"
	 * Example 2: Input: "azxxzy"   Output: "ay"
	 * Example 3: Input: "a"        Output: "a"
	 * Example 4: Input: ""         Output: ""
	 * Example 5: Input: "google"   Output: "le"
	 *
	 * Approach:
	 * - Use a stack to track characters.
	 * - Traverse the string:
	 *      - If current character matches top of stack → remove (pop)
	 *      - Else → push to stack
	 *
	 * - This ensures consecutive duplicates are removed iteratively.
	 *
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 *
	 * </pre>
	 *
	 * @param input the input string
	 * @return string after removing adjacent duplicates
	 */
	static UnaryOperator<String> removeConsecutiveCharacters = input -> {
		if (input == null || input.length() == 1) {
			return input;
		}
		Stack<Character> stack = new Stack<>();
		stack.push(input.charAt(0));
		for (int i = 1; i < input.length(); i++) {
			char currentChar = input.charAt(i);
			if (!stack.isEmpty() && stack.peek() == currentChar) {
				stack.pop();
			} else {
				stack.push(currentChar);
			}
		}
		return stack.stream().map(String::valueOf).collect(Collectors.joining(""));
	};
	
	/**
	 * 11. Reverse Words in a String
	 *
	 * <pre>
	 * Description:
	 * Given a string, reverse the order of words.
	 *
	 * A word is defined as a sequence of non-space characters.
	 * Extra spaces should be removed in the output.
	 *
	 * Example 1: Input: "the sky is blue"      Output: "blue is sky the"
	 * Example 2: Input: "  hello world  "      Output: "world hello"
	 * Example 3: Input: "a good   example"     Output: "example good a"
	 *
	 * Approach:
	 * - Split the string by spaces.
	 * - Traverse words from end to start.
	 * - Skip empty words (caused by multiple spaces).
	 * - Append valid words with a single space separator.
	 *
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 *
	 * </pre>
	 *
	 * @param input the input string
	 * @return string with words reversed
	 */
	static UnaryOperator<String> reverseWords = input -> {
		StringBuilder result = new StringBuilder();
		String[] words = input.split(" ");
		for (String word : words) {
			if (!word.equals(" ")) {
				result.insert(0, word).insert(0, " ");
			}
		}
		return new String(result).trim();
	};
	
	
	/**
	 * 10. Longest Substring Without Repeating Characters
	 *
	 * <pre>
	 * Description:
	 * Given a string, find the length of the longest substring
	 * without repeating characters.
	 *
	 * Example 1: Input: "abcabcbb"   Output: 3   ("abc")
	 * Example 2: Input: "bbbbb"      Output: 1   ("b")
	 * Example 3: Input: "pwwkew"     Output: 3   ("wke")
	 * Example 4: Input: ""           Output: 0
	 *
	 * Approach:
	 * - Use sliding window technique with two pointers:
	 *      left  → start of window
	 *      right → end of window
	 *
	 * - Use a Set to track unique characters in current window.
	 *
	 * - If character is not present → expand window (right++)
	 * - If duplicate found → shrink window (left++) until valid
	 *
	 * - Track maximum window size during traversal.
	 *
	 * Time Complexity: O(n)
	 * Space Complexity: O(min(n, charset))
	 *
	 * </pre>
	 *
	 * @param input the input string
	 * @return length of longest substring without repeating characters
	 */
	static Function<String, Integer> longestSubString = str -> {
		Set<Character> lookUp = new HashSet<>();
		int fast = 0;
		int slow = 0;
		int maxLength = 0;
		while (fast < str.length()) {
			if (lookUp.add(str.charAt(fast))) {
				if (maxLength < lookUp.size()) {
					maxLength = lookUp.size();
				}
				fast++;
			} else {
				lookUp.remove(str.charAt(slow));
				slow++;
			}
		}
		return maxLength;
	};
	
	/**
	 * 9. First Unique Character in a String
	 *
	 * <pre>
	 * Description:
	 * Given a string, find the first non-repeating character
	 * and return it. If none exists, return '0'.
	 *
	 * Example 1: Input: "leetcode"      Output: 'l'
	 * Example 2: Input: "loveleetcode"  Output: 'v'
	 * Example 3: Input: "aabb"          Output: '0'
	 *
	 * Approach:
	 * - Traverse the string.
	 * - For each character:
	 *      - Check if first index == last index
	 *      - If yes → character is unique → return it
	 *
	 * - If no unique character found → return '0'
	 *
	 * Time Complexity: O(n²) (due to indexOf & lastIndexOf)
	 * Space Complexity: O(1)
	 *
	 * </pre>
	 *
	 * @param input the input string
	 * @return first non-repeating character or '0' if none exists
	 */
	static Function<String, Character> firstUniqueChar = input -> {
		if (input == null || input.isEmpty()) {
			return '0';
		}
		for (int index = 0; index < input.length(); index++) {
			char currentChar = input.charAt(index);
			// Check if character appears only once
			if (input.indexOf(currentChar) == input.lastIndexOf(currentChar)) {
				return currentChar;
			}
		}
		return '0';
	};
	
	/**
	 * 8. Remove Duplicate Characters from String
	 *
	 * <pre>
	 * Description:
	 * Given a string, remove duplicate characters while preserving
	 * the order of first occurrence.
	 *
	 * Example 1: Input: "programming"   Output: "progamin"
	 * Example 2: Input: "aabbcc"        Output: "abc"
	 * Example 3: Input: "abc"           Output: "abc"
	 * Example 4: Input: ""              Output: ""
	 *
	 * Approach:
	 * - Use a Set to track already seen characters.
	 * - Traverse the string:
	 *      - If character not in set → add to set and append to result
	 *      - Else → skip
	 *
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 *
	 * </pre>
	 *
	 * @param input the input string
	 * @return string with duplicate characters removed
	 */
	static Function<String, String> removeDuplicateChars = input -> {
		StringBuilder result = new StringBuilder();
		Set<Character> container = new HashSet<>();
		for (int i = 0; i < input.length(); i++) {
			if (!container.contains(input.charAt(i))) {
				container.add(input.charAt(i));
				result.append(input.charAt(i));
			}
		}
		return new String(result);
	};
	
	/**
	 * 7. Valid Anagram Strings
	 *
	 * <pre>
	 * Description:
	 * Given two strings, determine if they are anagrams of each other.
	 *
	 * Two strings are anagrams if they contain the same characters
	 * with the same frequency, ignoring spaces.
	 *
	 * Example 1: Input: "listen", "silent"        Output: true
	 * Example 2: Input: "triangle", "integral"    Output: true
	 * Example 3: Input: "hello", "world"          Output: false
	 * Example 4: Input: "a gentleman", "elegant man" Output: true
	 *
	 * Approach:
	 * - Remove all whitespace from both strings.
	 * - If lengths differ → not anagrams.
	 * - Sort both strings and compare.
	 *
	 * Time Complexity: O(n log n)
	 * Space Complexity: O(n)
	 *
	 * </pre>
	 *
	 * @param first  first input string
	 * @param second second input string
	 * @return true if both strings are anagrams, false otherwise
	 */
	static BiFunction<String, String, Boolean> angramStrings = (one, two) -> {
		// Removing white spaces from given strings
		String stringOne = one.replaceAll("\\s", "");
		String stringTwo = two.replaceAll("\\s", "");

		// if lengths are not equal then not anagrams
		if (stringOne.length() != stringTwo.length()) {
			return false;
		}
		return sortCharsInString(stringOne).equals(sortCharsInString(stringTwo));
	};
	
	/**
	 * 6. Replace Vowels in a String
	 *
	 * <pre>
	 * Description:
	 * Given a string, replace all vowels with specific special characters:
	 *
	 * a → !
	 * e → @
	 * i → #
	 * o → $
	 * u → %
	 *
	 * Note:
	 * - Input is converted to lowercase before replacement.
	 *
	 * Example 1: Input: "hello"     Output: "h@ll$"
	 * Example 2: Input: "APPLE"     Output: "!ppl@"
	 * Example 3: Input: "xyz"       Output: "xyz"
	 *
	 * Approach:
	 * - Convert string to lowercase.
	 * - Replace each vowel using chained replace operations.
	 *
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 *
	 * </pre>
	 *
	 * @param input the input string
	 * @return string with vowels replaced by special characters
	 */
	static Function<String, String> replaceVowels = input -> {
		return input.toLowerCase().replace('a', '!').replace('e', '@').replace('i', '#').replace('o', '$').replace('u','%');
	};

	private static String sortCharsInString(String input) {
		return input.chars().mapToObj(c -> String.valueOf((char) c)).sorted().collect(Collectors.joining());
	}
	
	static BiFunction<String, Integer, String> stringReverseByFrequency = (String input, Integer frequency) -> {
		StringBuilder reversedString = new StringBuilder();
		int startIndex = 0;
		int endIndex = input.length() - 1;
		while (startIndex <= endIndex) {
			int frequencyStart = startIndex;
			int frequencyEnd = Math.min(startIndex + frequency - 1, endIndex);
			String substring = input.substring(frequencyStart, frequencyEnd + 1);
			String reversedSubString = stringReverse.apply(substring);
			reversedString.append(reversedSubString);
			startIndex = startIndex + frequency;
		}
		return new String(reversedString);
	};

	static Function<String, List<String>> permutationsOfString = input -> {
		List<String> permutations = new ArrayList<>();
		Integer startIndex = 0;
		return findPermutations(input.toCharArray(), startIndex, permutations);
	};

	private static List<String> findPermutations(char[] charArray, Integer startIndex, List<String> permutations) {
		if (charArray.length == startIndex) {
			permutations.add(new String(charArray));
		}
		for (int i = startIndex; i < charArray.length; i++) {
			swap(charArray, startIndex, i);
			findPermutations(charArray, startIndex + 1, permutations);
			swap(charArray, startIndex, i);
		}
		return permutations;
	}

	static Function<String, Map<String, Integer>> countVowelsAndConsonent = input -> {
		String vowels = "aeiouAEIOU";
		Map<String, Integer> map = new HashMap<>();
		map.put("Vowels", 0);
		map.put("Consonents", 0);
		for (int i = 0; i < input.length(); i++) {
			if (vowels.indexOf(input.charAt(i)) >= 0) {
				map.put("Vowels", map.get("Vowels") + 1);
			} else {
				map.put("Consonents", map.get("Consonents") + 1);
			}
		}
		return map;
	};

	static Function<String, String> replaceSpecificWords = input -> {
		return input.replaceAll("plus", "+").replaceAll("minus", "-");
	};

	static Function<String, Map<Character, Long>> charCount = input -> {
		IntFunction<? extends Character> mapper = c -> (char) c;
		return input.chars().mapToObj(mapper).collect(groupingBy(identity(), counting()));
	};
	
	static BiFunction<String, String, Boolean> stringRotation = (one, two) -> {
		// Concatenate s1 with itself & check if s2 is a substring
		if (one.length() != two.length() || one == null) {
			return false;
		}
		// Concatenate s1 with itself & check if s2 is a substring
		return one.concat(one).contains(two);
	};
	
}