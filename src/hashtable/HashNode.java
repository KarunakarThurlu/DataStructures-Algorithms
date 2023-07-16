package hashtable;

public class HashNode<K,V> {

	K key;
	V value;
	HashNode<K,V> next;
	
	public HashNode(K key, V value) {
		super();
		this.key = key;
		this.value = value;
		this.next = null;
	}

	public HashNode() {
		super();
	}

	@Override
	public String toString() {
		return "{ key : " + key + "  , value : " + value + "}";
	}
}
