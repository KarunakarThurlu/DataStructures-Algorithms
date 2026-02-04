package numbers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigInteger;
import java.util.function.IntFunction;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class TestNumberChallenges {
	
	@ParameterizedTest
	@CsvSource({"'123','3'","'99','2'","'5','1'","'123456789','9'","'0','1'"})
	@DisplayName("Test Digits Count of a number")
	void testDigitsOfNumber(String inputArgument,String expectedArgument) {
		Integer input = parseInput(inputArgument);
		Integer expected = parseInput(expectedArgument);
		Integer actual = NumberChallenges.digitsCount(input);
		assertEquals(expected, actual);
	}
	
	@ParameterizedTest
	@CsvSource({"'2','3','8'","'1','0','1'","'0','0','1'"})
	@DisplayName("Test N Power M ")
	void testNpowerM(String inputArgumentOne,String inputArgumentTwo,String expectedArgument) {
		Integer inputOne = parseInput(inputArgumentOne);
		Integer inputTwo = parseInput(inputArgumentTwo);
		Integer expected = parseInput(expectedArgument);
		Integer actual = NumberChallenges.nPowerM(inputOne,inputTwo);
		assertEquals(expected, actual);
	}
	
	@ParameterizedTest
	@DisplayName("Test Odd Digits count in an Integer")
	@CsvSource({"'43256','2'","'1','1'","'24536712','4'"})
	void testOddDigitsCount(String inputArgument,String expectedArgument) {
		Integer input = parseInput(inputArgument);
		Integer expected = parseInput(expectedArgument);
		Integer actual = NumberChallenges.oddDigitsCount(input);
		assertEquals(expected, actual);
	}
	
	@ParameterizedTest
	@CsvSource({"'5','120'","'10','3628800'","'1','1'","'-1','IllegalArgumentException'","'1','1'"})
	@DisplayName("Test Factorial of Number")
	void testFactorialOfNum(String inputArgument, String expectedArgument) {
		Integer input = parseInput(inputArgument);
		if (input < 0) {
			assertThrows(IllegalArgumentException.class, () -> NumberChallenges.factorialOfNum(input),
					"Factorial of negative number " + input + " should throw IllegalArgumentException");
		} else {
			BigInteger expected = BigInteger.valueOf(parseInput(expectedArgument));
			BigInteger actual = NumberChallenges.factorialOfNum(input);
			assertEquals(expected, actual);
		}
	}
	
	@ParameterizedTest
	@CsvSource({"'5','5'","'11','11'","'12','21'","'-1234','-4321'","'-1','-1'"})
	@DisplayName("Test Reverse Number")
	void testReverseNumber(String inputArgument, String expectedArgument) {
		Integer input = parseInput(inputArgument);
		Integer expected = parseInput(expectedArgument);
		Integer actual = NumberChallenges.reverseNumber(input);
		assertEquals(expected, actual);
	}
	
	@ParameterizedTest
	@CsvSource({"'153','True'","'370','True'","'120','False'","'-1234','False'"})
	@DisplayName("Test Armstrong Number")
	void testArmStrongNumber(String inputArgument, String expectedArgument) {
		Integer input = parseInput(inputArgument);
		Boolean expected = Boolean.valueOf(expectedArgument);
		Boolean actual = NumberChallenges.armStrongNumber.test(input);
		assertEquals(expected, actual);
	}
	
    @ParameterizedTest
    @MethodSource("provideCountSetBitsTestCases")
    @DisplayName("Test count of set bits using Brian Kernighan’s Algorithm")
    void testCountSetBits(int input, int expected) {
        Integer actual = NumberChallenges.count1bits.apply(input);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> provideCountSetBitsTestCases() {
        return Stream.of(
                Arguments.of(0, 0),    // 0 -> 0
                Arguments.of(1, 1),    // 1 -> 1
                Arguments.of(2, 1),    // 10 -> 1
                Arguments.of(3, 2),    // 11 -> 2
                Arguments.of(5, 2),    // 101 -> 2
                Arguments.of(7, 3),    // 111 -> 3
                Arguments.of(8, 1),    // 1000 -> 1
                Arguments.of(15, 4),   // 1111 -> 4
                Arguments.of(16, 1),   // 10000 -> 1
                Arguments.of(31, 5)    // 11111 -> 5
        );
    }
	
	private Integer parseInput(String input) {
		if (input.isBlank()) return 0;
		return Integer.parseInt(input);
	}
}
