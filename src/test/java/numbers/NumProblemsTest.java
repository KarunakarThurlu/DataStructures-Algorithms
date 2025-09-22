package numbers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class NumProblemsTest {

	private static Logger logger = System.getLogger(NumProblemsTest.class.getName());

	@ParameterizedTest
	@DisplayName("Test Count Digits")
	@CsvSource({ "123,3", "-120,3", "0,0" })
	void testCountDigits(String input, String expected) {
		Integer inputParam = getInt(input);
		Integer expectedResult = getInt(expected);
		Integer actualResult = NumProblems.countDigits.apply(inputParam);
		assertEquals(expectedResult, actualResult);
	}

	@ParameterizedTest
	@DisplayName("Test Reverse Number")
	@CsvSource({ "123,321", "-120,-21", "987654627893,0" })
	void testReverseNumber(String input, String expected) {
		Integer inputParam = getInt(input);
		Integer expectedResult = getInt(expected);
		Integer actualResult = NumProblems.reverseNumber.apply(inputParam);
		assertEquals(expectedResult, actualResult);
	}

	@ParameterizedTest
	@DisplayName("Test GCD Of Numbers")
	@CsvSource({ "12,21,3", "10,50,10", "19,11,1" })
	void testGCD(String inputParamOne, String inputParamTwo, String expected) {
		Integer x = getInt(inputParamOne);
		Integer y = getInt(inputParamTwo);
		Integer expectedResult = getInt(expected);
		Integer actualResult = NumProblems.gcd.apply(x, y);
		assertEquals(expectedResult, actualResult);
	}
	
	@ParameterizedTest
	@DisplayName("Test Palindrome Number")
	@CsvSource({ "123,false", "121,true", "-1441,true" })
	void testPalindromeNumber(String input, String expected) {
		Integer inputParam = getInt(input);
		Boolean expectedResult = Boolean.valueOf(expected);
		Boolean actualResult = NumProblems.palindromeNumber.test(inputParam);
		assertEquals(expectedResult, actualResult);
	}
	
	@ParameterizedTest
	@DisplayName("Test Armstrong Number")
	@CsvSource({ "153,true", "121,false", "235,fase" })
	void testArmstrongNumber(String input, String expected) {
		Integer inputParam = getInt(input);
		Boolean expectedResult = Boolean.valueOf(expected);
		Boolean actualResult = NumProblems.armstrogNumber.test(inputParam);
		assertEquals(expectedResult, actualResult);
	}
	
	@ParameterizedTest
	@DisplayName("Test Find Divisors Of Number")
	@MethodSource("findDivisorsOfNumberInput")
	void testFindDivisorsOfNumber(Integer input, List<Integer> expected) {
		List<Integer> actual = NumProblems.findDivisors.apply(input);
		assertEquals(expected, actual);
	}

	private static Stream<Arguments> findDivisorsOfNumberInput() {
		return Stream.of(Arguments.of(12, List.of(1, 2, 3, 4, 6, 12)), Arguments.of(13, List.of(1, 13)),
				Arguments.of(29, List.of(1, 29)), Arguments.of(33, List.of(1,3, 11, 33)));
	}
	
	@ParameterizedTest
	@DisplayName("Test Prime Number")
	@CsvSource({ "7,true", "49,false", "21,false", "53,true" })
	void testPrimeNumber(String input, String expected) {
		Integer inputParam = getInt(input);
		Boolean expectedResult = Boolean.valueOf(expected);
		Boolean actualResult = NumProblems.primeNumber.test(inputParam);
		assertEquals(expectedResult, actualResult);
	}

	@ParameterizedTest
	@DisplayName("Test Power N ")
	@CsvSource({ "2,3,8", "10,0,1", "3,3,27","0,10,0" })
	void testPowerN(String inputOne,String inputTwo, String expected) {
		Integer inputParamOne = getInt(inputOne);
		Integer inputParamTwo = getInt(inputTwo);
		Integer expectedResult = getInt(expected);
		Integer actualResult = NumProblems.powerN(inputParamOne,inputParamTwo);
		assertEquals(expectedResult, actualResult);
	}
	
	@ParameterizedTest
	@DisplayName("Test Power Of 2 ")
	@CsvSource({ "22,false", "16,true", "71,false","64,true" })
	void testPowerOf2(String input,String expected) {
		Integer inputParam = getInt(input);
		Boolean expectedResult = Boolean.valueOf(expected);
		Boolean actualResult = NumProblems.powerOf2(inputParam);
		assertEquals(expectedResult, actualResult);
	}
	
	@ParameterizedTest
	@DisplayName("Test FizBuzz Number ")
	@CsvSource({ "15,FizBuzz", "16,None", "71,None","21,Fiz","25,Buzz" })
	void testFizBuzz(String input,String expected) {
		Integer inputParam = getInt(input);
		String actualResult = NumProblems.fizBuzz(inputParam);
		assertEquals(expected, actualResult);
	}
	
	private static Integer getInt(String num) {
		try {
			return Integer.valueOf(num);
		} catch (NumberFormatException e) {
			logger.log(Level.ERROR, "{0}", e.getMessage());
			return 0;
		}
	}
}
