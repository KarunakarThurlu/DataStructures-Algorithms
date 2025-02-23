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
	 */

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
	
	public static List<List<String>> groupAnagramStrings(List<String> anagrams){
		Map<String,List<String>> map = new HashMap<>();
		for(String s : anagrams) {
			String string = s.chars().mapToObj(c->(char)c).map(String::valueOf).sorted().collect(Collectors.joining());
			if(map.containsKey(string)) {
				map.get(string).add(s);
			}else {
				map.put(string, new ArrayList<>());
				map.get(string).add(s);
			}
		}
		List<List<String>> res=new ArrayList<>();
		map.entrySet().forEach(e->res.add(e.getValue()));
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
	
	static BiFunction<String, String, Boolean> stringRotation = (strOne, strTwo) -> {
		 // Length must be the same & should not be empty
		if (strOne.length() != strTwo.length() || strOne == null)
			return false;
		// Concatenate s1 with itself & check if s2 is a substring
		return (strOne + strOne).contains(strTwo);
	};
	
	static BiFunction<String, String, Boolean> subSequenceCheck = (strOne, strTwo) -> {
		int strOneIndex = 0, strTwoIndex = 0;
		while (strOneIndex < strOne.length() && strTwoIndex < strTwo.length()) {
			if (strOne.charAt(strOneIndex) == strTwo.charAt(strTwoIndex))
				strTwoIndex++;
			strOneIndex++;
		}
		return strTwoIndex == strTwo.length();
	};
	
	static Function<String,String> reverseVowelsOnly = str -> {
        String vowels="aeiou";
        str=str.toLowerCase();
        char[] ch=str.toLowerCase().toCharArray();
        int startIndex=0;
        int endIndex=str.length()-1;
        while(startIndex<endIndex){
            while(vowels.indexOf(str.charAt(startIndex))<0 && startIndex<endIndex){
            	startIndex++;
            }
            while(vowels.indexOf(str.charAt(endIndex))<0 && endIndex>0){
            	endIndex--;
            }
            if(startIndex<endIndex){
                char t=ch[startIndex];
                ch[startIndex++]=ch[endIndex];
                ch[endIndex--]=t;
            }
        }
        return new String(ch);
	};
	
	static BiFunction<String, String, Integer> minChangesToMakeAnagrams = (firstString, secondString) -> {
		// Check if strings have different lengths since anagrams must be same length
		if (firstString.length() != secondString.length()) {
			return -1;
		}

		// Array to store character frequency differences (using ASCII range)
		int[] charFrequencyDiff = new int[128];

		// Calculate frequency differences between both strings
		for (int i = 0; i < firstString.length(); i++) {
			charFrequencyDiff[firstString.charAt(i)]++; // Increment for first string
			charFrequencyDiff[secondString.charAt(i)]--; // Decrement for second string
		}

		// Calculate total changes needed by summing positive differences
		int totalChanges = 0;
		for (int i = 0; i < 128; i++) {
			// Sum only positive differences (excess characters in first string)
			totalChanges += Math.max(0, charFrequencyDiff[i]);
		}

		return totalChanges; // This equals half the total differences needed
	};
}
