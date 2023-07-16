package linkedlist.singlelinklinkedlist;

public class Node<T> {
	T data;
	Node<T> next;
	
	public Node(T data) {
		super();
		this.data = data;
		this.next = null;
	}

	public Node() {
		super();
	}

	@Override
	public String toString() {
		return "[ " + data +" | -]-->"+ next+ "";
	}
	
	
}


