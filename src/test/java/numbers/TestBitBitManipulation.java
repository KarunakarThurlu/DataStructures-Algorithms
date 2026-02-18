package numbers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestBitBitManipulation {

	
	@ParameterizedTest
	@DisplayName("Test count of set bits")
	@CsvSource({
		"0, 0", // 0 in binary is 0, which has 0 set bits
		"1, 1", // 1 in binary is 1, which has 1 set bit
		"2, 1", // 2 in binary is 10, which has 1 set bit
		"3, 2", // 3 in binary is 11, which has 2 set bits
		"4, 1", // 4 in binary is 100, which has 1 set bit
		"5, 2", // 5 in binary is 101, which has 2 set bits
		"6, 2", // 6 in binary is 110, which has 2 set bits
		"7, 3", // 7 in binary is 111, which has 3 set bits
		"8, 1", // 8 in binary is 1000, which has 1 set bit
		"15, 4", // 15 in binary is 1111, which has 4 set bits
		"16, 1", // 16 in binary is 10000, which has 1 set bit
	})
	void testCountSetBits(int n, int expected) {
		int actual = BitManipulation.countSetBits(n);
		assertEquals(expected, actual);
	}
	
}
