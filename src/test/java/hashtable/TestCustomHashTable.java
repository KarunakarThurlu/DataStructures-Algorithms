package hashtable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestCustomHashTable {
	/*
	 * ------------------------------
	 *  Test put() and get() basic flow
	 * ------------------------------
	 */
	@ParameterizedTest
	@MethodSource("putAndGetProvider")
	@DisplayName("Should insert and retrieve values correctly")
	void testPutAndGet(Integer key, String value) {

		CustomHashTable<Integer, String> table = new CustomHashTable<>(5);

		table.put(key, value);

		assertEquals(value, table.get(key));
		assertEquals(1, table.size());
	}

	static Stream<Arguments> putAndGetProvider() {
		return Stream.of(Arguments.of(1, "Java"), Arguments.of(2, "Go"), Arguments.of(100, "Rust"));
	}

	/*
	 * ------------------------------ 
	 * Test updating existing key
	 * ------------------------------
	 */
	@ParameterizedTest
	@MethodSource("updateProvider")
	@DisplayName("Should update value if key already exists")
	void testUpdateExistingKey(Integer key, String initialValue, String updatedValue) {

		CustomHashTable<Integer, String> table = new CustomHashTable<>(5);

		table.put(key, initialValue);
		table.put(key, updatedValue);

		assertEquals(updatedValue, table.get(key));
		assertEquals(1, table.size()); // size should NOT increase
	}

	static Stream<Arguments> updateProvider() {
		return Stream.of(Arguments.of(1, "Java", "Kotlin"), Arguments.of(2, "Go", "Rust"));
	}

	/*
	 * ------------------------------ 
	 * Test collision handling
	 * ------------------------------
	 */
	@ParameterizedTest
	@MethodSource("collisionProvider")
	@DisplayName("Should handle collisions using chaining")
	void testCollisionHandling(Integer key1, Integer key2) {

		// Small capacity to force collision
		CustomHashTable<Integer, String> table = new CustomHashTable<>(1);

		table.put(key1, "First");
		table.put(key2, "Second");

		assertEquals("First", table.get(key1));
		assertEquals("Second", table.get(key2));
		assertEquals(2, table.size());
	}

	static Stream<Arguments> collisionProvider() {
		return Stream.of(Arguments.of(1, 2), Arguments.of(10, 20));
	}

	/*
	 * ------------------------------ 
	 * Test get for non-existing key
	 * ------------------------------
	 */
	@ParameterizedTest
	@MethodSource("nonExistingKeyProvider")
	@DisplayName("Should return null for non-existing keys")
	void testGetNonExistingKey(Integer existingKey, Integer searchKey) {

		CustomHashTable<Integer, String> table = new CustomHashTable<>(5);
		table.put(existingKey, "Value");

		assertNull(table.get(searchKey));
	}

	static Stream<Arguments> nonExistingKeyProvider() {
		return Stream.of(Arguments.of(1, 99), Arguments.of(5, 10));
	}

	/*
	 * ------------------------------ 
	 * Test null key validation
	 * ------------------------------
	 */
	@ParameterizedTest
	@MethodSource("nullKeyProvider")
	@DisplayName("Should throw exception for null key")
	void testNullKey(Integer key) {

		CustomHashTable<Integer, String> table = new CustomHashTable<>(5);

		assertThrows(NullPointerException.class, () -> table.put(key, "Value"));
	}

	static Stream<Arguments> nullKeyProvider() {
		return Stream.of(Arguments.of((Integer) null));
	}
}
