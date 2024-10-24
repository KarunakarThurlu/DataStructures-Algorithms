package array;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ArrayTest {

	@ParameterizedTest
	@MethodSource("provideTwoSumTestCases")
	@DisplayName("Two Sum Problem Test Cases")
	void testTwo(int[] input, int target, int[] expected) {
		int[] actual = Test.twoSum(input, target);
		assertArrayEquals(expected, actual, "Expected and Actual Arrays should be equal");
	}

	private static Stream<Arguments> provideTwoSumTestCases() {
		return Stream.of(
				Arguments.of(new int[] { 2, 7, 11, 15 }, 9, new int[] { 0, 1 }),
				Arguments.of(new int[] { 3, 2, 4, 6 }, 6, new int[] { 1, 2 }),
				Arguments.of(new int[] { -3, 4, 3, 90 }, 0, new int[] { 0, 2 }),
				Arguments.of(new int[] { 3, 3 }, 6, new int[] { 0, 1 }),
				Arguments.of(new int[] { 1, 2, 3 }, 7, new int[] { -1, -1 })
			);
	}
}
