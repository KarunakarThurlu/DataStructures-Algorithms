package string;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class StringHandlingTest {
	
	@ParameterizedTest
	@MethodSource("provideReverseStringTestCases")
	@DisplayName("Test Reverse String")
	void testStringReverse(String input, String expected) {
		String actual = StringHandling.stringReverse.apply(input);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> provideReverseStringTestCases() {
		return Stream.of(Arguments.of("java", "avaj"), 
				Arguments.of("karun", "nurak"),
				Arguments.of("ProgrammingKT", "TKgnimmargorP"), 
				Arguments.of("j", "j"), 
				Arguments.of("", ""));
	}
	@ParameterizedTest
	@MethodSource("provideReverseStringByFrequencyTestCases")
	@DisplayName("Test Reverse String By Frequeency")
	void testStringReverseByFrequency(String input, Integer frequency, String expected) {
		String actual = StringHandling.stringReverseByFrequency.apply(input,frequency);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> provideReverseStringByFrequencyTestCases() {
		return Stream.of(Arguments.of("java",2, "ajav"), 
				Arguments.of("karun", 3, "raknu"),
				Arguments.of("ProgrammingKT", 4,  "gorPmmarKgniT"), 
				Arguments.of("j", 1, "j"), 
				Arguments.of("", 10, ""));
	}
	
	@ParameterizedTest
	@MethodSource("permutationsOfStringTestCases")
	@DisplayName("Test Permutations of a String")
	void testPermutationsOfString(String input, List<String> expected) {
		List<String> actualSorted = StringHandling.permutationsOfString.apply(input).stream().sorted().toList();
		List<String> expectedSorted = expected.stream().sorted().toList();
		assertEquals(actualSorted, expectedSorted);
	}

	private static Stream<Arguments> permutationsOfStringTestCases() {
		return Stream.of(
				Arguments.of("AB", List.of("AB", "BA")),
				Arguments.of("ABC", List.of("ABC", "ACB", "BCA", "BAC", "CAB", "CBA")),
				Arguments.of("A", List.of("A")), 
				Arguments.of("", List.of("")));
	}
	
	@ParameterizedTest
	@MethodSource("countVowelsAndConsonentTestCases")
	@DisplayName("Test Count Vowels and Consonents")
	void testCountVowelsAndConsonent(String input, Map<String, Integer> expected) {
		Map<String, Integer> actual = StringHandling.countVowelsAndConsonent.apply(input);
		assertEquals(expected.get("Vowels"), actual.get("Vowels"));
		assertEquals(expected.get("Consonents"), actual.get("Consonents"));
	}

	private static Stream<Arguments> countVowelsAndConsonentTestCases() {
		return Stream.of(
				Arguments.of("karunakar", Map.of("Vowels", 4, "Consonents", 5)),
				Arguments.of("abc", Map.of("Vowels", 1, "Consonents", 2)),
				Arguments.of("a", Map.of("Vowels", 1, "Consonents", 0)),
				Arguments.of("", Map.of("Vowels", 0, "Consonents", 0))
				);
	}
	
	@ParameterizedTest
	@MethodSource("replaceSpecificWordsTestCases")
	@DisplayName("Test Replace Specific Words")
	void testReplaceSpecificWords(String input, String expected) {
		String actual = StringHandling.replaceSpecificWords.apply(input);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> replaceSpecificWordsTestCases() {
		return Stream.of(
				Arguments.of("IhateCplusplus",  "IhateC++"),
				Arguments.of("minusplusminusplus", "-+-+"),
				Arguments.of("JavaScriptIsAwesome", "JavaScriptIsAwesome"),
				Arguments.of("Learning java is plus point", "Learning java is + point"),
				Arguments.of("","")
				);
	}
	
	@ParameterizedTest
	@MethodSource("replaceVowelsTestCases")
	@DisplayName("Test Replace Vowels")
	void testReplaceVowels(String input, String expected) {
		String actual = StringHandling.replaceVowels.apply(input);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> replaceVowelsTestCases() {
		return Stream.of(
				Arguments.of("java",  "j!v!"),
				Arguments.of("karun", "k!r%n"),
				Arguments.of("postgresql", "p$stgr@sql"),
				Arguments.of("","")
				);
	}
	
	@ParameterizedTest
	@MethodSource("angramStringsTestCases")
	@DisplayName("Test Angram Strings")
	void testAngramStrings(String firstString,String secondString, Boolean expected) {
		Boolean actual = StringHandling.angramStrings.apply(firstString,secondString);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> angramStringsTestCases() {
		return Stream.of(
				Arguments.of("tea","eat",true),
				Arguments.of("cat  ", "act", true),
				Arguments.of("", "java",false),
				Arguments.of("","",true)
				);
	}
	
	@ParameterizedTest
	@MethodSource("removeDuplicateCharsTestCases")
	@DisplayName("Test Remove Duplicate Chars")
	void testRemoveDuplicateChars(String input,String expected) {
		String actual = StringHandling.removeDuplicateChars.apply(input);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> removeDuplicateCharsTestCases() {
		return Stream.of(
				Arguments.of("java","jav"),
				Arguments.of("ram", "ram"),
				Arguments.of("jeevan", "jevan"),
				Arguments.of("","")
				);
	}
	
	@ParameterizedTest
	@MethodSource("firstUniqueCharTestCases")
	@DisplayName("Test first Unique Character")
	void testFirstUniqueChar(String input,Character expected) {
		Character actual = StringHandling.firstUniqueChar.apply(input);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> firstUniqueCharTestCases() {
		return Stream.of(
				Arguments.of("java",'j'),
				Arguments.of("ram", 'r'),
				Arguments.of("test", 'e'),
				Arguments.of("",'0')
				);
	}
	
	@ParameterizedTest
	@MethodSource("longestSubStringTestCases")
	@DisplayName("Test Longest SubString Without Repeating Characters")
	void testLongestSubString(String input,Integer expected) {
		Integer actual = StringHandling.longestSubString.apply(input);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> longestSubStringTestCases() {
		return Stream.of(
				Arguments.of("java",3),
				Arguments.of("ram", 3),
				Arguments.of("test", 3),
				Arguments.of("k",1),
				Arguments.of("",0),
				Arguments.of("aabcbacddef",4)
				);
	}
	
	@ParameterizedTest
	@MethodSource("reverseWordsTestCases")
	@DisplayName("Test Reverse Words")
	void testReverseWords(String input,String expected) {
		String actual = StringHandling.reverseWords.apply(input);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> reverseWordsTestCases() {
		return Stream.of(
				Arguments.of("java is awesome","awesome is java"),
				Arguments.of("i love 1947 before India", "India before 1947 love i"),
				Arguments.of("test", "test"),
				Arguments.of("k","k"),
				Arguments.of("",""),
				Arguments.of("aabcbacddef","aabcbacddef")
				);
	}
	
	@ParameterizedTest
	@MethodSource("charCountTestCases")
	@DisplayName("Test Char Count")
	void testCharCount(String input, Map<Character, Long> expected) {
		Map<Character, Long> actual = StringHandling.charCount.apply(input);
		for(Entry<Character, Long> e : actual.entrySet()) {
			assertEquals(e.getValue(), expected.get(e.getKey()));
		}
	}

	private static Stream<Arguments> charCountTestCases() {
		return Stream.of(
				Arguments.of("java",Map.of('j',1l,'a',2l,'v',1l)),
				Arguments.of("i",Map.of('i',1l))
				);
	}
	
	@ParameterizedTest
	@MethodSource("removeConsecutiveCharsTestCases")
	@DisplayName("Test Remove Consecutive Chars")
	void testRemoveConsecutiveChars(String input, String expected) {
		String actual = StringHandling.removeConsecutiveChars.apply(input);
		assertEquals(expected,actual);
	}

	private static Stream<Arguments> removeConsecutiveCharsTestCases() {
		return Stream.of(
				Arguments.of("java","java"),
				Arguments.of("aabcddedd","bce"),
				Arguments.of("aabeebcddedd","ce"),
				Arguments.of("i","i")
				);
	}
	
	@ParameterizedTest
	@MethodSource("groupAnagramStringsTestCases")
	@DisplayName("Test Group Anagram Strings")
	void testGroupAnagramStrings(List<String> input, Integer expected) {
		List<List<String>> actual = StringHandling.groupAnagramStrings(input);
		assertEquals(expected,actual.size());
	}

	private static Stream<Arguments> groupAnagramStringsTestCases() {
		return Stream.of(
				Arguments.of(List.of("eat","tea","tan","ate","nat","bat"),3),
				Arguments.of(List.of(""),1),
				Arguments.of(List.of("a"),1)
				);
	}
	
	@ParameterizedTest
	@CsvSource({"{{}}}},false","{{}},true"})
	@DisplayName("Test Valid Paranthases")
	void testValidParanthases(String input, Boolean expected) {
		Boolean  actual = StringHandling.validParanthases.apply(input);
		assertEquals(expected,actual);
	}
	
	@ParameterizedTest
	@CsvSource({"XX,20","LIX,59","MCMXCIV,1994"})
	@DisplayName("Test Roman To Integer")
	void testRomanToInteger(String input, Integer expected) {
		Integer  actual = StringHandling.romanToInteger.apply(input);
		assertEquals(expected,actual);
	}
	
	@ParameterizedTest
	@CsvSource({ "waterbottle,erbottlewat,true", "hello,lohel,true", "abc,acb,false" })
	@DisplayName("Test String Rotation")
	void testStringRotation(String inputOne, String inputTwo, Boolean expected) {
		Boolean actual = StringHandling.stringRotation.apply(inputOne, inputTwo);
		assertEquals(expected, actual);
	}
	
	@ParameterizedTest
	@CsvSource({ "waterbottle, wbt, true", "hello, hlo, true", "abc, acb, false" })
	@DisplayName("Test Sub Sequence Check")
	void testSubSequenceCheck(String inputOne, String inputTwo, Boolean expected) {
		Boolean actual = StringHandling.subSequenceCheck.apply(inputOne, inputTwo);
		assertEquals(expected, actual);
	}
	
	@ParameterizedTest
	@CsvSource({ "rador, rodar", "hello, holle", "java, java" })
	@DisplayName("Test Reverse Vowels Only")
	void testRevseVowelsOnly(String input, String expected) {
		String actual = StringHandling.reverseVowelsOnly.apply(input);
		assertEquals(expected, actual);
	}
	
	@ParameterizedTest
	@CsvSource({ "eat, ate, 0", "accept, except, 2","buy, bye, 1","leetcode, practice, 5"})
	@DisplayName("Test Minimum changes to make Two Strings are anagram")
	void testMinChangesToMakeAnagrams(String inputOne,String inputTwo, String expected) {
		int expectedValue = Integer.parseInt(expected);
		Integer actual = StringHandling.minChangesToMakeAnagrams.apply(inputOne,inputTwo);
		assertEquals(expectedValue, actual);
	}


}
