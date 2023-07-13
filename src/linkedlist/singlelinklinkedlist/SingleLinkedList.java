package linkedlist.singlelinklinkedlist;

public class SingleLinkedList {
	static Node<Integer> head=null;
	
	public static void main(String[] args) {
		add(10);
		add(20);
		add(30);
		System.out.println(head);
	}
	
	public static void add(Integer data) {
		Node<Integer> dataNode=new Node<>(data);
		if(head==null)
			head=dataNode;
		else {
			dataNode=head;
		}
		head=dataNode;
	}
}
