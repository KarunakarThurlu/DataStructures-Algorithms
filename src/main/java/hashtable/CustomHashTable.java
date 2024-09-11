package hashtable;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomHashTable<K, V> {
	private static final Logger logger = Logger.getLogger(CustomHashTable.class.getName());

	private List<HashNode<K, V>> buckets;
	private Integer size;
	private Integer capacity;

	public CustomHashTable(Integer capacity) {
		this.size = 0;
		this.capacity = capacity;

		this.buckets = new ArrayList<>(capacity);

		for (int i = 0; i < capacity; i++) {
			buckets.add(null);
		}
	}

	public static void main(String[] args) {
		CustomHashTable<Integer, String> ht = new CustomHashTable<>(5);
		ht.put(11, "Java");
		ht.put(12, "Go");
		ht.put(13, "Rust");
		ht.put(14, "Scala");
		ht.put(15, "Node");
		ht.put(22, "Kotlin");
		ht.put(16, "Kotlin");
		ht.print();
		System.out.println(ht.get(16));
	}

	public void print() {
		logger.log(Level.INFO, "{0}", buckets);
	}
	
	public int size() {
		return size;
	}
	
	public int capacity() {
		return capacity;
	}
	
	public int getIndex(K key) {
		return key.hashCode() % capacity;
	}
	
	public void put(K key, V value) {
		Integer index = getIndex(key);
		HashNode<K, V> head = buckets.get(index);

		while (head != null) {
			if (head.key.equals(key)) {
				head.value = value;
				return;
			}
			head = head.next;
		}

		size++;
		head = buckets.get(index);
		HashNode<K, V> dataNode = new HashNode<>(key, value);
		dataNode.next = head;
		buckets.set(index, dataNode);
	}

	public V get(K key) {
		Integer index = getIndex(key);
		HashNode<K, V> head = buckets.get(index);
		while (head != null) {
			if (head.key.equals(key)) {
				return head.value;
			}
			head = head.next;
		}
		return null;
	}
}
