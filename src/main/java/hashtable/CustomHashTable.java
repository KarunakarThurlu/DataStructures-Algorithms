package hashtable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A simple custom implementation of a Hash Table using
 * Separate Chaining (Linked List) for collision handling.
 *
 * @param <K> the type of keys maintained by this table
 * @param <V> the type of mapped values
 */
public class CustomHashTable<K, V> {

    /** Array of buckets where each bucket stores a linked list of entries */
    private final List<HashNode<K, V>> table;

    /** Number of key-value pairs stored in the table */
    private int size;

    /** Total number of buckets */
    private final int capacity;

    /**
     * Constructs a HashTable with the given capacity.
     *
     * @param capacity number of buckets
     */
    public CustomHashTable(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.table = new ArrayList<>(capacity);

        // Initialize buckets with null values
        for (int i = 0; i < capacity; i++) {
            table.add(null);
        }
    }

    /**
     * Returns number of key-value pairs stored.
     */
    public int size() {
        return size;
    }

    /**
     * Returns total bucket capacity.
     */
    public int capacity() {
        return capacity;
    }

    /**
     * Computes bucket index for a given key.
     * Ensures non-negative index.
     */
    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    /**
     * Inserts or updates a key-value pair in the hash table.
     *
     * If key already exists, its value is updated.
     * Otherwise, a new entry is added to the bucket.
     */
    public void put(K key, V value) {
        Objects.requireNonNull(key, "Key cannot be null");

        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> current = table.get(bucketIndex);

        // Check if key already exists → update value
        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            current = current.next;
        }

        // Insert new node at head of linked list (chaining)
        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = table.get(bucketIndex);
        table.set(bucketIndex, newNode);

        size++;
    }

    /**
     * Retrieves value associated with the given key.
     *
     * @param key the lookup key
     * @return value mapped to the key, or null if not found
     */
    public V get(K key) {
        Objects.requireNonNull(key, "Key cannot be null");

        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> current = table.get(bucketIndex);

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }

        return null;
    }
}