package ch001linkedList.doublyLinkedList;

public class DoublyLinkedList<T> {

	private ListNode<T> head;
	private ListNode<T> tail;
	private int length;

	public DoublyLinkedList() {
		length = 0;
	}

	public int getPosition(T data) {
		int index = 0;
		if (data == null) {
			return -1;
		}

		ListNode<T> node = head;
		while (node != null) {
			if (data.equals(node.getData())) {
				return index;
			}
			node = node.getNextNode();
			index++;
		}
		return -1;
	}
	
	public int size() {
		return length;
	}
	
	public void insert(T data) {
		ListNode<T> newNode = new ListNode<>();
		newNode.setData(data);
		if (head == null) {
			head = newNode;
			tail = newNode;
			return;
		}
		newNode.setPrevNode(tail);
		tail.setNextNode(newNode);
		tail = newNode;
		length ++;
	}
	
	public void insertFirst(T data) {
		ListNode<T> newNode = new ListNode<>();
		newNode.setData(data);
		if (head != null) {
			newNode.setNextNode(head);
			head.setPrevNode(newNode);
		}
		head = newNode;
		length++;
	}
	
	public void insertAt(T data, int index) {
		ListNode<T> node = getAt(index);
		if (node == null) {
			throw new ArrayIndexOutOfBoundsException();
		}
		ListNode<T> newNode = new ListNode<>();
		newNode.setData(data);
		newNode.setPrevNode(node.getPrevNode());
		newNode.setNextNode(node);
		node.setPrevNode(newNode);
		length++;
	}
	
	public void removeAt(int index) {
		ListNode<T> node = getAt(index);
		if (node == null) {
			throw new ArrayIndexOutOfBoundsException();
		}
		node.getPrevNode().setNextNode(node.getNextNode());
		node.getNextNode().setPrevNode(node.getPrevNode());
		length--;
	}
	
	public void remove(T data) {
		if (length == 0) {
			return;
		}
		
		ListNode<T> node = head;
		while(node != null) {
			if (node.getData().equals(data)) {
				break;
			}
			node = head.getNextNode();
		}
		if (node == null) {
			return;
		}
		node.getPrevNode().setNextNode(node.getNextNode());
		node.getNextNode().setPrevNode(node.getPrevNode());
		length--;
	}
	
	public ListNode<T> getAt(int index) {
		if (index < 0) {
			return null;
		}
		if (index >= length) {
			return tail;
		}
		if (index == 0) {
			return head;
		}
		ListNode<T> result = head;
		for (int i = 0; i < index; i++) {
			result = result.getNextNode();
		}
		return result;
	}

}
