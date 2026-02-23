package string;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
	 */
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
	
	static Function<List<String>, String> longestCommonPrefix = strs -> {
		List<String> list = strs.stream().sorted().toList();
		String firstString = list.get(0);
		String lastString = list.get(list.size() - 1);
		StringBuilder commonPrefix = new StringBuilder();
		int index = 0;
		while (index < firstString.length()) {
			if (firstString.charAt(index) == lastString.charAt(index)) {
				commonPrefix.append(firstString.charAt(index));
			} else {
				break;
			}
			index++;
		}
		return String.valueOf(commonPrefix);
	};
	
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
	
	static UnaryOperator<String> stringReverse = input -> {
		char[] charArray = input.toCharArray();
		int startIndex = 0;
		int endIndex = input.length() - 1;
		while (startIndex <= endIndex) {
			swap(charArray, startIndex++, endIndex--);
		}
		return new String(charArray);
	};

	private static void swap(char[] charArray, int startIndex, int endIndex) {
		char temp = charArray[startIndex];
		charArray[startIndex] = charArray[endIndex];
		charArray[endIndex] = temp;
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

	static Function<String, String> replaceVowels = input -> {
		return input.toLowerCase().replace('a', '!').replace('e', '@').replace('i', '#').replace('o', '$').replace('u',
				'%');
	};

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

	private static String sortCharsInString(String input) {
		return input.chars().mapToObj(c -> String.valueOf((char) c)).sorted().collect(Collectors.joining());
	}

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

	static Function<String, Character> firstUniqueChar = input -> {
		for (int i = 0; i < input.length(); i++) {
			char charAt = input.charAt(i);
			if (input.indexOf(charAt) == input.lastIndexOf(charAt)) {
				return charAt;
			}
		}
		return '0';
	};

	static Function<String, Integer> longestSubString = input -> {
		Set<Character> set = new HashSet<>();
		int maxLength = 0;
		int pointerOne = 0;
		int pointerTwo = 0;
		while (pointerOne < input.length() && pointerTwo < input.length()) {
			if (set.add(input.charAt(pointerTwo))) {
				pointerTwo++;
				maxLength = Math.max(maxLength, set.size());
			} else {
				set.remove(input.charAt(pointerOne));
				pointerOne++;
			}
		}
		return maxLength;
	};

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

	static Function<String, Map<Character, Long>> charCount = input -> {
		IntFunction<? extends Character> mapper = c -> (char) c;
		return input.chars().mapToObj(mapper).collect(groupingBy(identity(), counting()));
	};

	static UnaryOperator<String> removeConsecutiveChars = input -> {
		String current = input;
		String previous;
		do {
			previous = current;
			current = removeConsecutiveCharsUtil(previous);
		} while (!current.equals(previous));
		return current;
	};

	private static String removeConsecutiveCharsUtil(String input) {
		int length = input.length();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < length; i++) {
			Character peek = stack.isEmpty() ? '0' : stack.peek();
			if (peek == '0') {
				stack.push(input.charAt(i));
			} else {
				if (stack.peek() == input.charAt(i)) {
					stack.pop();
				} else {
					stack.push(input.charAt(i));
				}
			}
		}
		return stack.stream().map(c -> String.valueOf(c)).collect(Collectors.joining(""));
	}

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

	static Function<String, Boolean> validParanthases = input -> {
		Stack<Character> stack = new Stack<>();
		if (input.length() % 2 != 0) {
			return false;
		} else {
			for (int i = 0; i < input.length(); i++) {
				char current = input.charAt(i);
				if (current == '{' || current == '(' || current == '[') {
					stack.push(input.charAt(i));
				} else {
					if (stack.isEmpty()) {
						return false;
					} else {
						Character open = stack.peek();
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

	static Function<String, Integer> romanToInteger = input -> {
		Map<Character, Integer> map = Map.of('M', 1000, 'D', 500, 'C', 100, 'L', 50, 'X', 10, 'V', 5, 'I', 1);
		Integer res = 0;
		for (int i = 0; i < input.length(); i++) {
			char charAt = input.charAt(i);
			if (i + 1 < input.length() && map.get(input.charAt(i + 1)) > map.get(charAt)) {
				res = res - map.get(charAt);
			} else {
				res = res + map.get(charAt);
			}
		}
		return res;
	};
	
	static BiFunction<String, String, Boolean> stringRotation = (one, two) -> {
		// Concatenate s1 with itself & check if s2 is a substring
		if (one.length() != two.length() || one == null) {
			return false;
		}
		// Concatenate s1 with itself & check if s2 is a substring
		return one.concat(one).contains(two);
	};
	
	static BiFunction<String, String, Boolean> subSequenceCheck = (one, two) -> {
		int oneIndex = 0, twoIndex = 0;
		while (oneIndex < one.length() && twoIndex < two.length()) {
			if (one.charAt(oneIndex) == two.charAt(twoIndex)) {
				twoIndex++;
			}
			oneIndex++;
		}
		return oneIndex == twoIndex;
	};
	
	static Function<String, String> reverseVowelsOnly = str -> {
		char[] charArray = str.toLowerCase().toCharArray();
		String vowels = "aeiou";
		int start = 0, end = str.length() - 1;
		while (start < end) {
			while (vowels.indexOf(str.charAt(start)) < 0) {
				start++;
			}
			while (vowels.indexOf(str.charAt(end)) < 0) {
				end--;
			}
			if (start < end) {
				char temp = charArray[end];
				charArray[end--] = charArray[start];
				charArray[start++] = temp;
			}
		}
		return String.valueOf(charArray);
	};
	
	static BiFunction<String, String, Integer> minChangesToMakeAnagrams = (one, two) -> {
		if (one.length() != two.length()) {
			return -1;
		}
		int[] count = new int[128];
		for (int i = 0; i < one.length(); i++) {
			count[one.charAt(i)]++;
			count[two.charAt(i)]--;
		}
		int total = 0;
		for (int i = 0; i < count.length; i++) {
			total = total + Math.max(0, count[i]);
		}
		return total;
	};
	
	
	static Function<String, String> longestSubStringWithOutRepeatingChars = str -> {
		Set<Character> seen = new HashSet<>();
		int maxLength = 0;
		int start = 0;
		int end = 0;
		int uniqueCharsStringStartIndex = 0;
		while (end < str.length()) {
			if (seen.add(str.charAt(end))) {
				if (end - start+1 > maxLength) {
					maxLength = end - start+1;
					uniqueCharsStringStartIndex = start;
				}
				end++;
			} else {
				seen.remove(str.charAt(start));
				start++;
			}
		}
		return str.substring(uniqueCharsStringStartIndex, uniqueCharsStringStartIndex + maxLength);
	};
	
}