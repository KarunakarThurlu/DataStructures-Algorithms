package linkedlist;

class CacheNode<K, V> {

	K key;
	V value;
	CacheNode<K, V> next;

	public CacheNode(K key, V value) {
		super();
		this.key = key;
		this.value = value;
		this.next = null;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public CacheNode<K, V> getNext() {
		return next;
	}

	public void setNext(CacheNode<K, V> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return " [ " + key + " | " + value + " | -- ] ->" + next;
	}

}

public class LRUcache<K, V> {
	private int capacity = 0;
	private int size = 0;
	private CacheNode<K, V> head = null;

	public LRUcache(int capacity) {
		this.capacity = capacity;
	}

	public V put(K key, V value) {
		CacheNode<K, V> currentNode = new CacheNode<>(key, value);
		// 1. check head is null
		if (head == null) {
			head = currentNode;
			size++;
			return value;
		}
		if (head.getValue().equals(value)) {
			return value;
		}
		// 2. check key exists, if exits update value and move to front
		CacheNode<K, V> current = head;
		while (current.getNext() != null) {
			if (current.next.value.equals(value)) {
				CacheNode<K, V> next = current.next;
				current.next = current.next.next;
				next.next = current;
				head = next;
				return value;
			}
			current = current.getNext();
		}
		// 3. new entry add at front
		currentNode.next = head;
		head = currentNode;
		size++;
		// 4. check capacity if exceeds remove last one
		if (size > capacity) {
			CacheNode<K, V> temp = head;
			while (temp.next != null && temp.next.next != null) {
				temp = temp.next.next;
			}
			temp.next = null;
			size--;
		}
		return value;
	}

	public V get(K key) {
		if (head == null) {
			return null;
		}
		if (head.key.equals(key)) {
			return head.value;
		}
		CacheNode<K, V> current = head;
		while (current.next != null) {
			if (current.next.key.equals(key)) {
				CacheNode<K, V> f = current.next;
				current.next = current.next.next;
				f.next = head;
				head = f;
				return f.value;
			}
			current = current.next;
		}
		return head.value;
	}

	public int getSize() {
		return size;
	}

	public int getCapacity() {
		return capacity;
	}

	public static void main(String[] args) {
		LRUcache<String, String> lruCache = new LRUcache<>(5);
		System.out.println("Size : " + lruCache.size + " Capacity " + lruCache.capacity);
		lruCache.put("Java", "1995");
		lruCache.put("C", "1970");
		lruCache.put("Kotlin", "2010");
		lruCache.put("SpringBoot", "2014");
		lruCache.put("Go", "2009");
		System.out.println("Size : " + lruCache.size + " Capacity " + lruCache.capacity);
		System.out.println(lruCache.head);
		System.out.println(lruCache.get("C"));
		System.out.println(lruCache.head);
		System.out.println("Size : " + lruCache.size + " Capacity : " + lruCache.capacity);
	}

}
